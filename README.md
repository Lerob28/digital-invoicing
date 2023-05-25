# Digital invoicing - Assignment
---

Implement a REST service and a web application to manage invoices.

## Terminology
---

- **Cutommer** - A customer can have many invoices
- **Invoice** - An invoice belong to one and only one Customer
- **Address** - Holds address informations

## Requirements
---
### Backend
The service should implement the following fonctionalities:
- Create **[Customer, Invoice, Address, PaymentInfo]**
- Update **[Customer, Invoice, Address, PaymentInfo]**
- Delete **[Customer, Invoice, Address, PaymentInfo]**
- Get all/paginated/partially(search, filter) **[customers, invoices, addresses, payment infos]**

### Frontend
The frontend app should implememt the following features:
- Manage **[customers, invoices, addresses, payment infos]** according to provided service(backend)
- Display a paginated data(particularly invoices) with filter support
- Add the possbility to print invoices.

## Minimum entities Schema
---
### Invoice
-  id : a nullable string representing the ID of the invoice 
-  invoiceNumber : a nullable string representing the invoice number 
-  customer : a nullable  Customer  object representing the customer associated with the invoice 
-  items : a nullable list of  InvoiceItem  objects representing the items included in the invoice 
-  billingAddress : a nullable  Address  object representing the billing address associated with the invoice 
-  paymentInfo :  a nullable  PaymentInfo  object representing the payment information associated with the invoice 
-  totalAmount : a nullable double representing the total amount charged for the invoice 
### Customer
-  name : a nullable string representing the name of the customer 
-  email : a nullable string representing the email address of the customer 
-  phone : a nullable string representing the phone number of the customer 
-  address : a nullable  Address  object representing the address of the customer 
### Address
-  street : a nullable string representing the street address 
-  city : a nullable string representing the city 
-  state : a nullable string representing the state 
-  zipCode : a nullable string representing the zip code 
-  country : a nullable string representing the country 
### PaymentInfo
-  cardType : a nullable string representing the type of credit card used for payment 
-  cardNumber : a nullable string representing the credit card number used for payment 
-  expirationMonth : an integer representing the expiration month of the credit card used for payment 
-  expirationYear : an integer representing the expiration year of the credit card used for payment 
-  cvv : a nullable string representing the Card Verification Value (CVV) of the credit card used for 
### InvoiceItem
-  name : a nullable string representing the name of the item 
-  quantity : an integer representing the quantity of the item included in the invoice 
-  price : a nullable double representing the price of the item 
-  total : a nullable double representing the total price charged for the item in the invoice 

## Notes
- Our tech stack is mostly Java with Spring framework and React for front-end.
- Please create a 'production-ready' service as you see it (documentation / tests / logs / exception handling).
- Please provide an instruction on how to run the app.
- Submit your solution either as a public repository (github, bitbucket, etc.) or as a zip archive.
