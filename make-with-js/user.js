var express = require('express');
let router = express.Router();
//app.use('/user',userRouter);

let db= require('./db')
//db.query("select username from twtmain where retweets>10"))

router.get('/user-list', function(req, res, next) {
    let sql='select username from twtmain where retweets>10';
    db.query(sql, function (err, data, fields) {
    if (err) throw err;
    res.render('user-list', { title: 'User List', userData: data});
  });
});
module.exports = router;