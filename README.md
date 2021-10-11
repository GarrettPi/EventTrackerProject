# EventTrackerProject
3d Printer Resources

### Description
This is the JPA/Sprint Boot/RESTful backend for a web application designed to manage one's 3d printers, materials, and prints.  It allows the user to create a manage a relational database of 3d Printers and all associated information. 

### How to Use
This API project can be accessed by going to the following address and inputing the routes listed below:                                               
http://13.58.89.163/webapp/3dPrint

The Database has been prepopulated with rows in each table, allowing you to test all features.

### API Endpoints

| Return Type    | Route                       | Functionality                     |
|----------------|-----------------------------|-----------------------------------|
| `List<Print>`  |`GET /api/prints`               | Gets all 3d Prints                 |
| `Print`      |`GET /api/prints/{id}`   | Gets one Print by id            |
| `Print`      |`POST /api/prints`              | Creates a new Print             |
| `Print`      |`PUT /api/prints/{id}`   | Replaces an existing Print by id|
| `Boolean`      |`DELETE /api/prints/{id}`| Deletes an existing Print by id |
| `List<Printer>`  |`GET /api/printers`               | Gets all 3d Printers                 |
| `Printer`      |`GET /api/printers/{id}`   | Gets one Printer by id            |
| `Printer`      |`POST /api/printerss`              | Creates a new Printer             |
| `Printer`      |`PUT /api/printers/{id}`   | Replaces an existing Printer by id|
| `Boolean`      |`DELETE /api/printers/{id}`| Deletes an existing Printer by id |

### MySQL Schema

![alt text](https://i.imgur.com/GwUwP5G.png)

### Technologies
- Java Persistence API
- Spring Boot
- RESTful API
- MySQL
- postman

### Future Updates
* An Angular frontend that will allow the user to interact with the database and API in a GUI
* Full CRUD capabilities for the material table
