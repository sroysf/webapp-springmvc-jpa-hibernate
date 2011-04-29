## Purpose ##

Provide an integrated starter project for SpringMVC + Spring ORM, backed by Hibernate and PostgreSQL. 

This project demonstrates a variety of useful functions right out of the box, and can be used as a starting point for a real web application.
It makes extensive use of SpringMVC for the web tier. It also uses Spring to replace the direct access to the JPA entity manager API and 
instead uses Spring dependency injection patterns to access data.

## Technologies ##

* Maven
* Hibernate
* JPA annotations
* PostgreSQL
* JSTL
* Servlets
* Log4J via SLF4J
* JUnit
* Hibernate maven plugin
* Spring MVC
* Spring ORM

## Features demonstrated ##

* JSTL page rendering
* Implementation of REST API, automatically returning JSON serialization.
* Parsing and controller routing in Spring MVC
* File upload
* Database access via injected DAO objects

## Setup and run ##

Assuming you have setup your postgres database separately and have updated persistence.xml to point at it...

1. mvn clean install -DskipTests
2. mvn hibernate3:hbm2ddl
3. Use target/hibernate3/sql/schema.ddl to create your database schema
4. mvn -e exec:java -Dexec.mainClass=com.force.samples.util.DataLoadUtil  (adds some data to the database)
5. mvn tomcat:run
6. Point browser at [http://localhost:8080/webapp-springmvc-jpa-hibernate](http://localhost:8080/webapp-springmvc-jpa-hibernate)
