import random
import urllib.parse
import certifi

def get_database():
    from pymongo import MongoClient

    username = urllib.parse.quote_plus('eldorado')
    password = urllib.parse.quote_plus('eldorado')
    client = MongoClient("mongodb+srv://%s:%s@bulkdata.7dx2x.mongodb.net/BulkData?retryWrites=true&w=majority" % (username, password), tlsCAFile=certifi.where())
    return client['BulkData']
        

dbname = get_database()

collection = dbname["Alldata"]
print('Deleting collection')
collection.drop()
print('Collection deleted successfully..')