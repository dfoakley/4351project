
//	include the express module
var express = require("express");

//	create an express application
var app = express();

//	helps in extracting the body portion of an incoming request stream
var bodyparser = require("body-parser");
var urlencodedParser = bodyparser.urlencoded({ extended: false })

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
app.use('/client', express.static(__dirname + '/client'));

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

app.get("/", function(req, res) {
	res.sendFile(__dirname + "/client/landingpage.html");
});

app.get("/landingpage", function(req, res) {
	res.sendFile(__dirname + "/client/landingpage.html");
});

app.get("/make-reservation", function(req, res) {
	res.sendFile(__dirname + "/client/make-reservation.html");
});

app.get("/registration", function(req, res) {
	console.log('registration page')
	res.sendFile(__dirname + "/client/registration.html");
});

app.get("/login", function(req,res){
	console.log('login page');
	res.sendFile(__dirname + "/client/login.html");
});

//	GET method to get availability around requested time
app.get("/get-availability", function(req, res)
{
	// dummy data
	//var tablesAvailableSize2 = [JSON.Parse('{ "TableId" : 
});

//	POST method to make reservation
app.post("/push-reservation", function(req, res)
{
	var user = req.session.username;	//	TO DO: enable guest session, maybe something with req.session.id
	var numGuests = req.body.numGuests;
	var resvDateTime = req.body.revDateTime;
	var ccNumEncrypt = cryptoJS.sha256.encrypt(req.body.ccNumRaw, cfg.password[0]);		//	TO DO: probably should do some encryption on the frontend before it hits here
});

app.post("/check-availability", function(req, res)
{
	const numGuests = req.query.partysize;
	const resDate = new Date(req.query.dtim);
});

//	Function to add hours to a date value
function addHours(baseDate, hours) {
	baseDate.setTime(baseDate.getTime() + (hours * 60 * 60 * 1000));
	return baseDate;
}

//	Function to figure out the table configuration
function getTableConfiguration (numGuests, targetDateTime) {
	
}

function buildTablesQuery(maxGuests, targetDateTime) {
	var q =  "SELECT TableId ";
		q += "FROM Tables "
		q += "WHERE TableId NOT IN ";
		q += "(";
		q += "    SELECT TableId ";
		q += "    FROM BookingTables ";
		q += "    WHERE BookingId NOT IN ";
		q += "    (";
		q += "        SELECT BookingId ";
		q += "        FROM Bookings ";
		q += "        WHERE BookingDateTime NOT BETWEEN DATE_SUB('" + targetDateTime.toString() + "', INTERVAL 1.5 HOUR) AND DATE_ADD('" + targetDateTime.toString() + "', INTERVAL 1.5 HOUR)";
		q += "    )";
		q += ") ";
		q += "AND MaxGuests = " + maxGuests.toString() + ";";
		
	return q;
}

app.get("*/*", function(req, res) {
	res.sendStatus(404);
});

var username;
var password;
var fullName;
var email;
var phoneNumber;
var mailingAddress;
var billingAddress;

////////////////////////////////////////////////////////////////////
app.post('/register', urlencodedParser, function(req,res){
	console.log("hello there")
	username = req.body.username;
	password = req.body.password;
	fullName = req.body.fullname;
	email = req.body.email;
	phoneNumber = req.body.phonenumber;
	mailingAddress = req.body.mailingaddress;
	billingAddress = req.body.billingaddress;

	console.log(username);
	console.log(password);
	console.log(fullName);
	console.log(email);
	console.log(phoneNumber);	
	console.log(mailingAddress);
	console.log(billingAddress);
		

	
	
})