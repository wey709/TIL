const {Client} = require('pg')
const client = new Client({
    user: 'young',
    password: '9379',
    host: 'localhost',
    port: 5432,
    database: 'twt'
})

client.connect()
.then(() => console.log('connected successfully'))

//.then(() => client.query("insert into twt values ($1, $2, $3, $4, $5)"))
.then(results => console.table(results.rows))
.catch(e => console.log)
.finally(()=>client.end())