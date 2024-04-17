# Haji dan Umroh - Customer Service Back-end Java(SpringBoot)

This project is a Java application built using the Spring Boot framework. It serves as a template for creating a backend service with database connectivity. The application includes features such as database operations, API endpoints, and testing using Postman.

## Environment Variables

To run this application, you need to set up the following environment variables:

- spring.datasource.url: The URL of your MySQL database.
- spring.datasource.username: The username to access your MySQL database.
- spring.datasource.password: The password to access your MySQL database.
- spring.datasource.driver-class-name: The JDBC driver class name for MySQL, which is com.mysql.cj.jdbc.Driver.
- spring.jpa.hibernate.ddl-auto=update
  Hibernate strategy mode for DDL (Data Definition Language), set to update to automatically update the database schema.
  Ensure that you set these values according to your MySQL database configuration.

## Deployment

To deploy this application, follow these steps:

1. Clone the repository to your local machine.
2. Set up the environment variables in your deployment environment or in your IDE's run configuration.
3. Build the project using Gradle or Maven.
4. Run the application using your preferred method (e.g., ./gradlew bootRun for Gradle or mvn spring-boot:run for Maven).
5. Once the application is running, it will be accessible at the specified port (default is 8080).

## API Reference

Testing for this application can be done using Postman. You can perform various HTTP requests to the API endpoints to test the functionality. Here are the steps to test the application:

1. Open Postman.
2. Set up requests for the API endpoints defined in the application.
3. Send requests to create, read, update, or delete data in the database.
4. Verify that the responses from the API endpoints are as expected.
5. Test different scenarios to ensure the robustness of the application.

Ensure that you have set up your MySQL database properly and that the application is running before testing. You can also automate testing using Postman collections and Newman for continuous integration pipelines.

This project provides a solid foundation for building backend services with Spring Boot and MySQL database connectivity. Customize it according to your requirements and extend its functionality as needed.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/11708290-7c9feff6-3865-40fe-aced-239108032805?action=collection%2Ffork&collection-url=entityId%3D11708290-7c9feff6-3865-40fe-aced-239108032805%26entityType%3Dcollection%26workspaceId%3Db8082477-685c-4add-8d56-64f1c34ecbdc#?env%5Bphp%5D=W3sia2V5IjoicGhwLXNlcnZlciIsInZhbHVlIjoiIGh0dHA6Ly8xMjcuMC4wLjE6ODAwMCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0In0seyJrZXkiOiJiZWFyZXItdG9rZW4iLCJ2YWx1ZSI6IiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJzZWNyZXQifSx7ImtleSI6ImJlYXJlci10b2tlbiIsInZhbHVlIjoiIiwiZW5hYmxlZCI6ZmFsc2UsInR5cGUiOiJkZWZhdWx0In1d)
