const express = require('express');
var path = require('path');
let ejs = require('ejs');
const app = express();
const port = 3000;

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

let result = [];
let getInfoFromDB = function(callback){
    client.query("select * from trump", function(err, res, fields)
    {
        if (err) return callback(err);
        if(res.length){
            for(var i =0; i<res.length; i++){
                result.push(res[i])
            }
        }
        callback(null, result);
    }
    )
}
client.query("select * from trump", (err,rows) => {
    if(err) throw err;
    else{
        tweets = rows;
    }
});


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');


//setup public folder
app.use('/public', express.static('public'));

app.get('/',function (req, res) {
res.render('index')
});
app.listen(port, () => console.log(`MasterEJS app Started on port ${port}!`));

app.get('/tweets', function(req, res, next){
    res.render('tweets', {
        title: "all tweets",
        tweets: tweets
    })
})