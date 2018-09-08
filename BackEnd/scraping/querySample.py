
import pymongo
import ssl
from pymongo import MongoClient



client = MongoClient('mongodb+srv://admin:siderift@cluster0-1jnpy.mongodb.net/test?retryWrites=true', ssl=True, ssl_cert_reqs=ssl.CERT_NONE)

# Get the sampleDB database
db = client.database
collection = db.usersNew
username = "admin"
password = "pass"

query = {'username' : 'admin'}

user = {
	'username' : username,
	'password' : password,
	'projects' : None,
	'badges' : None


}

#collection.insert_one(user)

for item in collection.find(query):
	print(item)
	if (item['password'] == 'pass'):
		print(0)
	else:
		print(1)
	

