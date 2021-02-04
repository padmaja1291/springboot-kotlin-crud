# springboot-kotlin-crud

A simple RESTful API application to perform CRUD operations using Spring Boot, Kotlin, Gradle, H2 database and Java 11

This project consists of APIs to perform CRUD operations for a single Entity (Employee)
### List of APIs
**Create	- POST**
* http://localhost:8080/crudwebservice/employees 

**Read	- GET**
* http://localhost:8080/crudwebservice/employees
* http://localhost:8080/crudwebservice/employees/{wwid}
* http://localhost:8080/crudwebservice/employees/hasMultipleLastname

**Update	- PUT**
* http://localhost:8080/crudwebservice/employees/{wwid} 

**Delete	- DELETE**
* http://localhost:8080/crudwebservice/employees/5 


This project was created using [https://start.spring.io/](https://start.spring.io/) as a start with following options
* Project – Gradle Project
* Language – Kotlin
* Spring Boot - 2.4.2
* Packaging – war
* Java – 11
* Dependencies
  -	Spring Web
  -	Spring Data JPA
  -	H2 Database
  -	OpenFeign
* IDE used for development – IntelliJ IDEA 2020.3.2 (Community Edition)

### Features
* Application runs on Undertow web server
* REST controller named EmployeeController that exposes CRUD operations for Employee Entity.  APIs mentioned in above table are available
* Service layer named EmployeeService that performs data validation on the following fields
  -	Firstname – checks if it has only alphabets
  -	lastname – checks if it has only alphabets
  -	email – checks if it is a valid email address
* Repository named EmployeeDao has a query method (findOneByWwid) which retrieves one employee based on wwid
* Repository named EmployeeDao also has a custom query method (hasMultipleLastName) which retrieves employees who have multiple last name
* RepositoriesTest has a unit test for the repository class
* Consume a public RESTful API [https://mailboxlayer.com](https://mailboxlayer.com) using Spring Cloud OpenFeign to validate email address 

