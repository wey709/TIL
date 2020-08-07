# import app
from pathlib import Path
import pytest
import json
from jsonschema import validate

properties = Path('db.properties')


def test_existence():
    assert properties.is_file()

def test_jsvalid():
    try: 
        p = open(properties)
        json.load(p)

    except Exception as e:
        e = type(e).__name__
        msg = e + " throwed"
        pytest.fail(msg)

def test_arraylike():
    p = open(properties)
    p = json.load(p)
    assert (len(p.keys())>0)
 


class Test_Schema:
    p = open(properties)
    p = json.load(p)
    connection_names = list(p.keys())

    def count_valid(self, schema, num_valid):
        for i in self.connection_names:
            try:
                validate(self.p[i], schema=schema)

            except:
                continue

            num_valid = num_valid+1
        return num_valid

    def test_psql(self):

        schema = {
            "type": "object",
            "properties":{
                "drivername": {"const" : "postgresql"}

            },
            "required": ["drivername"]
        }

        num_valid = self.count_valid(schema,0)
        # for i in self.connection_names:
        #     try:
        #         validate(self.p[i], schema=schema)

        #     except:
        #         continue

        #     num_valid = num_valid+1
        assert num_valid>0

    def test_mongo(self):

        schema = {
            "type": "object",
            "properties":{
                "drivername": {"enum" : ["mongodb","mongo"]}

            },
            "required": ["drivername"]
        }

        num_valid = self.count_valid(schema,0)
        assert num_valid>0

    def test_traccar(self):
        schema = {
            "type": "object",
            "properties":{
                "user":{
                    "type": "object",
                    "properties":{
                        "email": {"type": "string"},
                        "password": {"type": "string"}
                    },
                    "required": ["email", "password"]
                }
            },
            "required":["user"]
        }
        num_valid = self.count_valid(schema,0)
        assert num_valid>0




