# Spring Boot Multi Datasource Example

A simple example based on the reference application (https://github.com/Skatteetaten/openshift-reference-springboot-server)
that will use multiple databases. 

A typical AuroraConfig for this application will contain the following element;

    "database": {
      "sales": "auto",
      "customers": "auto"
    }
  
This will ensure that two schemas are created and that the environment variables
SALES_DB_PROPERTIES and CUSTOMERS_DB_PROPERTIES are made available to the application
at runtime. These environment variables contains the paths of the properties files that
contains the connection information for each individual schema. See the Main-class for 
an example of these properties are read and made available to spring.

The example should work with both Oracle and Postgres. The provided docker-compose.yml file
in the root folder can be used to spin up a couple of databases for the example to run
locally.