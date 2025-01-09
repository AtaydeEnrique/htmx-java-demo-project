# HTMX App

This is a Spring Boot application demonstrating various features using HTMX.

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.9.9 or higher

### Installation

1. Build the project using Maven:

   ```sh
   mvn clean install
   ```

2. Run the application:
   ```sh
   mvn spring-boot:run
   ```
   or run it through your IDE.

### Usage

Once the application is running, you can navigate to the following routes:

- `/` - Home page
- `/request` - Retrieving a JSON and displaying data demo
- `/temperature` - Sending a value through a POST request and returning HTML with conversion demo
- `/polling` - Polling some data every 5 seconds demo
- `/searching` - Search some hardcoded data and search some data from an API demo
- `/validating` - Validate fields in a form, in this case, validating an email with regex demo

### Project Structure

- [controller](http://_vscodecontentref_/0) - Contains the controllers for handling web requests
- [templates](http://_vscodecontentref_/1) - Contains the HTML templates
- [static](http://_vscodecontentref_/2) - Contains static resources like CSS and JavaScript files

### Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [HTMX](https://htmx.org/)
- [Apache Maven](https://maven.apache.org/)
