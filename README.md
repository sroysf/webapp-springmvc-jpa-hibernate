## Purpose ##

Provide an integrated Hello World application demonstrating JPA persistence using Hibernate and PostgreSQL,
in the context of a very simple web application. This demo does not use any real frameworks except for JSTL for a little bit
of JSP processing. 

This pattern should not be used for all but the simplest possible use cases. However, it's useful to have as a skeleton starting
point for a java web application when you don't want to incorporate the complexities of an actual web framework.

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

## Setup and run ##

Assuming you have setup your postgres database separately and have updated persistence.xml to point at it...

1. mvn clean install -DskipTests
2. mvn hibernate3:hbm2ddl
3. Use target/hibernate3/sql/schema.ddl to create your database schema
4. mvn -e exec:java -Dexec.mainClass=com.force.samples.util.DataLoadUtil  (adds some data to the database)
5. mvn tomcat:run
6. Point browser at [http://localhost:8080/webapp-jsp-jpa-hibernate/listbooks](http://localhost:8080/webapp-jsp-jpa-hibernate/listbooks)
7. Or try [http://localhost:8080/webapp-jsp-jpa-hibernate/](http://localhost:8080/webapp-jsp-jpa-hibernate/)
