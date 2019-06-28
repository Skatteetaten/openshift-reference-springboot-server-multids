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