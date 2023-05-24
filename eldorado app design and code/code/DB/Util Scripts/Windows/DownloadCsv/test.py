import csv

myRows = ["Product Name", "Product Description", "Product Price", "Product Quantity", "Image Links", "PDF Links"]

with open('ProductsList.csv', 'w', newline='') as prodListFile:
    wr = csv.writer(prodListFile, quoting=csv.QUOTE_ALL)
    wr.writerow(myRows)