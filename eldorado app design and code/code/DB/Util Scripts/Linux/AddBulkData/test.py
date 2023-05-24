import json
from faker import Faker
import random
import urllib.parse
import certifi
import pandas as pd 
fake = Faker()

def data_add(fname,var,ilist,c,mini,maxi):
    flist=[]
    
    for i in range(mini,maxi):
        for j in range(len(var)):
            dic={
                'ProductId':str(i),
                'VariationId':var[j],
                'Title':fname[random.randint(0,999)],
                'Category':c,
                'Price':random.randint(500,5000),
                'Quantity':random.randint(3, 50),
                'Pdf_link':"https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf",
                'Description':fake.paragraph(),
                'Product_Images': ilist,
                }
            flist.append(dic)
    return flist

def get_database():
    from pymongo import MongoClient

    username = urllib.parse.quote_plus('eldorado')
    password = urllib.parse.quote_plus('eldorado')
    client = MongoClient("mongodb+srv://%s:%s@bulkdata.7dx2x.mongodb.net/BulkData?retryWrites=true&w=majority" % (username, password), tlsCAFile=certifi.where())
    return client['BulkData']
        

with open('fname.json') as json_file:
    data = json.load(json_file)
    cname=[d['clothes'] for d in data['objects']]
    bname=[d['books'] for d in data['objects']]
    gname=[d['grocery'] for d in data['objects']]
    fname=[d['food'] for d in data['objects']]
    mname=[d['medical'] for d in data['objects']]

cvar=["S","M","L","XL"]
bvar=["Paperback","HardCover","Kindle"]
gvar=["Standard"]
fvar=["Dine-in","TakeAway"]
mvar=["Standard"]

cilist=[
    "https://images.unsplash.com/photo-1441986300917-64674bd600d8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80",
    "https://images.unsplash.com/photo-1517502166878-35c93a0072f0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1534&q=80",
    "https://vod-progressive.akamaized.net/exp=1626952009~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F4475%2F11%2F297379518%2F1133287444.mp4~hmac=349a972bdc69d19341608224f616728777d41bbd20d2652974a0a5018b013f98/vimeo-prod-skyfire-std-us/01/4475/11/297379518/1133287444.mp4?filename=Clothing+-+18897.mp4",
    "https://images.unsplash.com/photo-1501127122-f385ca6ddd9d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=375&q=80"
]

bilist=[
    "https://images.unsplash.com/photo-1509266272358-7701da638078?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=333&q=80",
    "https://images.unsplash.com/photo-1513001900722-370f803f498d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80",
    "https://images.unsplash.com/photo-1520387294843-fd994fd872e7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=375&q=80",
    "https://vod-progressive.akamaized.net/exp=1626953494~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F3164%2F5%2F140823862%2F421230848.mp4~hmac=f700dea4975f573b0d1d4b5529c963339e832f3b577866828ca9c4ff0044bdd2/vimeo-prod-skyfire-std-us/01/3164/5/140823862/421230848.mp4?filename=Library+-+846.mp4"
]

gilist=[
    "https://images.unsplash.com/photo-1578916171728-46686eac8d58?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=667&q=80",
    "https://images.unsplash.com/photo-1601599561213-832382fd07ba?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=400&q=80",
    "https://images.unsplash.com/photo-1584680226833-0d680d0a0794?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
]

filist=[
    "https://images.unsplash.com/photo-1606788076220-dc07ae3d2120?ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80",
    "https://images.unsplash.com/photo-1504674900247-0877df9cc836?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1500&q=80",
    "https://images.unsplash.com/photo-1493770348161-369560ae357d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
]

milist=[
    "https://images.unsplash.com/photo-1530210124550-912dc1381cb8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80",
    "https://images.unsplash.com/photo-1560582861-45078880e48e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80",
    "https://images.unsplash.com/photo-1583324113626-70df0f4deaab?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=889&q=80",
    "https://images.unsplash.com/photo-1512069772995-ec65ed45afd6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=377&q=80"
]

dbname = get_database()
col = dbname["Alldata"]

flist = data_add(cname, cvar, cilist, "clothes", 0, 100000)
for eachRow in flist:
    col.insert_one(eachRow)
print("Inserting Clothes done")

flist = data_add(bname, bvar, bilist, "books", 100000, 200000)
for eachRow in flist:
    col.insert_one(eachRow)
print("Inserting Books done")

flist = data_add(gname, gvar, gilist, "grocery", 200000, 300000)
for eachRow in flist:
    col.insert_one(eachRow)
print("Inserting Grocery done")

flist = data_add(fname, fvar, filist, "food", 300000, 400000)
for eachRow in flist:
    col.insert_one(eachRow)
print("Inserting Food done")

flist = data_add(mname, mvar, milist, "medical", 400000, 500000)
for eachRow in flist:
    col.insert_one(eachRow)
print("Inserting Medical done")