# Spring Boot Microservices Project

## Overview
This project implements a microservices architecture using Spring Boot. The main components include:

- **Accounts Microservice**: Manages account details and interacts with the Cards Service to retrieve card information.
- **Cards Microservice**: Provides card details.
- **Eureka Server**: Acts as a service registry for service discovery.
- **Config Server**: Manages external configuration properties for all microservices.
- **API Gateway**: Handles authentication and routing using Keycloak.

## Prerequisites
Before you begin, ensure you have the following installed:

- **Java**: Version 11 or higher
- **Maven**: Version 3.6 or higher
- **PostgreSQL**: (or another preferred database)
- **Keycloak**: Server for authentication

## Setup

### 1. Clone the Repository
```bash
git clone <your-repository-url>
cd <your-project-directory>
### 2. Configure PostgreSQL
Create a PostgreSQL database for each microservice.
Update the application.properties file for each microservice with the appropriate database connection details.
### 3. Set Up Keycloak
Download and start the Keycloak server.
Create a new realm and configure clients for your microservices.
Update the API Gateway configuration to integrate with Keycloak for authentication.
### 4. Configure Eureka Server
Ensure that both the Accounts and Cards microservices register with the Eureka server by updating their application.properties files.
### 5. Configure Config Server
Set up the Config Server to read configuration properties from a Git repository or local file system.
### 6. Build the Project
Run the following command to build the project:

```bash
mvn clean install
### 7. Run the Microservices
Start the services in the following order:

Eureka Server
Config Server
Accounts Microservice
Cards Microservice
API Gateway
You can run each service using:

```bash
mvn spring-boot:run
Endpoints
Accounts Microservice
GET /accounts/{id}: Retrieve account details by account ID.
GET /accounts/{id}/cards: Retrieve card details associated with the account (interacts with Cards Service).
Cards Microservice
GET /cards/{id}: Retrieve card details by card ID.
API Gateway
Use the API Gateway for all client requests, which handles authentication via Keycloak.
Testing
Run unit tests with:

```bash
mvn test
Postman Collection
(Include a link to your Postman collection for testing the endpoints, if applicable)

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
Spring Boot Documentation
Spring Cloud Netflix Eureka
Spring Cloud Config
Keycloak Documentation
Contact
For any inquiries, feel free to reach out at [your-email@example.com].

Architecture Diagram
```plaintext
+-------------------+
|   API Gateway     |
|                   |
|  (Keycloak Auth)  |
+---------+---------+
          |
          v
+---------+---------+
|    Eureka Server   |
+---------+---------+
          |                  |
          |                  |
          v                  v
+---------+---------+  +-----+-------+
| Accounts Service  |  | Cards Service |
|                   |  |               |
+---------+---------+  +---------------+
          |                  |
          |                  |
          v                  v
+---------+---------+  +-----+-------+
| Accounts Database |  | Cards Database |
|                   |  |                 |
+-------------------+  +-----------------+

       +---------------------+
       |     Config Server   |
       +---------------------+

### Notes:
- Remember to replace placeholders like `<your-repository-url>` with your actual project details.
- Adjust any sections as necessary to fit your project's specifics! If you need further modifications,