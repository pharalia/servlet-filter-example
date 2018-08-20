# servlet-filter-example
A couple of simple examples to demonstrate servlet filters, utilising the following dependencies;
- org.springframework:spring-webmvc
- javax.servlet:javax.servlet-api
- org.apache.logging.log4j:log4j-core

## Running the example
The application is executed using an embedded jetty container. The project requires maven 3.x to run;
```bash
mvn jetty:run
```

Try out the examples below;
- [Filter a request](http://localhost:8080/example-filtered)
- [Filter with an error handled by @ExceptionHandler](http://localhost:8080//example-exception)
- [Filter with an unhandled Exception](http://localhost:8080//example-exception/unhandled)