
//	include the express module
var express = require("express");

//	create an express application
var app = express();

//	helps in extracting the body portion of an incoming request stream
var bodyparser = require("body-parser");

//	fs module, API for interacting with the file system
var fs = require("fs");

//	for managing user sessions
var session = require("express-session");

//	js functions for hashing message with SHA-256 algorithm
var cryptoJS = require("crypto-js");

//	include mysql
var mysql = require("mysql");

var xml2js = require("xml2js");

var xmlParser = xml2js.parseString;

//	use express-session
app.use(session({
	secret: "group18",
	saveUnitialized: true,
	resave: false
}));

//	apply body-parser middleware to all incoming requests
app.use(bodyparser());
app.use(bodyparser.json());

//	read in XML config file
var text = fs.readFileSync("./dbconfig.xml").toString("utf-8");
var xmlConfig;
xmlParser(text, function(err, result) {
	xmlConfig = result.dbconfig;
});

var cfg = {
	connectionLimit: xmlConfig.connectionLimit[0],
	host: xmlConfig.host[0],
	user: xmlConfig.user[0],
	password: xmlConfig.password[0],
	database: xmlConfig.database[0],
	port: xmlConfig.port[0]
};

//	connect to mysql server
var con = mysql.createPool(cfg);

//	server listens on port 9001 for incoming connections
module.exports = app.listen(process.env.PORT || 9001, () => console.log("Listening on port 9001!"));

//	POST method to make reservation
app.post("/make-reservation", function(req, res)
{
	var user = req.session.username;	//	TO DO: enable guest session
	var numGuests = req.body.numGuests;
	var resvDateTime = req.body.revDateTime;
	var 
}