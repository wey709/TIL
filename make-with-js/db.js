let express = require('express')
let router = express.Router()

const {Client} = require('pg')
const client = new Client({
    user: 'twt',
    password: '930709',
    host: 'localhost',
    port: 5432,
    database: 'twt'
})

client.connect()
.then(() => console.log('connected successfully'))

//.then(() => client.query("insert into twt values ($1, $2, $3, $4, $5)"))
//.then(results => console.table(results.rows))
//.catch(e => console.log)
//.finally(()=>client.end())

client.query("select * from trump", (err,rows) => {
    if(err) throw err;
    else{
        tweets = rows;
    }
});

