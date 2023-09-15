# HNG TASK 2

This is a RESTful API designed to handle the Person record.


## Table of Contents
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Setting Up the Environment](#setting-up-the-environment)
- [Project Structure](#project-structure)
- [Features](#features)
- [Technologies](#technologies)
- [API Endpoints](#api-endpoints)
- [Documentation](#documentation)



## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java Development Kit (JDK) 8 or later installed.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) for code development.
- [Java](https://www.oracle.com/java/)
- [Maven](https://maven.apache.org/)
- Git for cloning the repository.

Your Spring Boot application should now be running at http://localhost:8080.
## Getting Started

### Setting Up the Environment
1. Clone the repository to your local machine:
```bash
   git clone <repository_url>
   cd 
   ```
2. Configure the database:
```bash
spring.datasource.url=jdbc:mysql://localhost:<port>/<database name>
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=<database username>
spring.datasource.password=<database password>
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```
- Copy and paste this and navigate into resource.
- In resource directory.
- Open application.properties

3. Build and Run:
```bash
mvn clean install
mvn spring-boot:run
```

## Project Structure
````
your-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── yourcompany/
│   │   │           └── yourproject/
│   │   │               ├── controller/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── yourcompany/
│       │           └── yourproject/
│       │               ├── controller/
│       │               ├── service/
│       │               └── ...
│       └── resources/
│           └── ...
├── .gitignore
├── LICENSE
├── README.md
└── ...
````

## Features

- Create Persons
- Retrieve Person Information
- Delete person Information
- Update Person Information

## Technologies

- Java (Spring Boot)
- MySQL 
- Maven
- Docker


## API Endpoints
Here are the main endpoints provided by the API:

GET /api/persons: Retrieve a list of all persons.
GET /api/persons/{id}: Retrieve a specific person by their ID.
POST /api/persons: Create a new person.
PATCH /api/persons/{id}: Update a person using JSON Patch.
DELETE /api/persons/{id}: Delete a person by their ID.

## Documentation


Examples
Example 1: Creating a Person
To create a new person, send a POST request to /api/persons with a JSON body containing the person's details.

Example request body:

json
Copy code
{
  "firstName": "John",
  "lastName": "Doe",
  "address": {
    "city": "New York",
    "street": "123 Main St",
    "state": "NY",
    "country": "USA"
  },
  "phoneNumber": "+1-123-456-7890"
}
Example 2: Updating a Person
To update a person's information, send a PATCH request to /api/persons/{id} with a JSON Patch document in the request body.

Example request body (JSON Patch):

json
Copy code
[
  { "op": "replace", "path": "/phoneNumber", "value": "+1-987-654-3210" }
]
