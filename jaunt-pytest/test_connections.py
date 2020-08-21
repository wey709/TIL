from pathlib import Path
import psycopg2
from pymongo import MongoClient
import json
import pytest


properties = Path('db.properties')
p = open(properties)
p = json.load(p)
connection_names = list(p.keys())
scheme = p[connection_names[0]] #input


def db_connect(scheme=scheme): # db의 scheme이 parameter
    
    
    if scheme['drivername'] == 'postgresql':
        try:
            pg_url = '{drivername}://{username}:{password}@{host}:{port}/{database}'.format(**scheme)
            connection = psycopg2.connect(pg_url)
            return connection

        except:
            return False

    else:

        try:
            mongo_url = 'mongodb://{username}:{password}@{host}:{port}/?authSource={database}'.format(**scheme)
            connection = MongoClient(mongo_url)            
            return connection

        except:
            return False

        

def test_dbconn():
    assert db_connect() is not False


class Test_psql:
    def execute_query(self):
        try:
            connection = db_connect()
            cursor = connection.cursor()
            cursor.execute("""SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'""")
            list_all = [table[0] for table in cursor.fetchall()]
            return list_all
        except:
            pytest.fail('not connected')


    def test_tc(self):
        list_all = self.execute_query()
        list_tc = [tbname for tbname in list_all if tbname[0:3] =="tc_"]
        assert len(list_tc)>0

    def test_volun(self):
        list_all = self.execute_query()
        list_volun = [tbname for tbname in list_all if tbname == "volunteer"]
        assert len(list_volun)>0



def test_mongo():
    try:
        connection = db_connect()
        dbname = scheme['database'] 
        database = connection[dbname]
        collection = database.list_collection_names(include_system_collections=False)
        assert all(x in collection for x in ['answer', 'question', 'device'])

    except:
        pytest.fail('not connected')


