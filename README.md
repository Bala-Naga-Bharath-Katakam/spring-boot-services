# Spring Boot Microservices Project

## Overview
This project is a microservices architecture built using Spring Boot. It consists of the following components:

- **Accounts Microservice**: Manages account details and interacts with the Cards Service to retrieve card information.
- **Cards Microservice**: Provides card details.
- **Eureka Server**: Acts as a discovery service for service registration and discovery.
- **Config Server**: Manages external configuration properties for microservices.
- **API Gateway**: Handles authentication and routing using Keycloak.

## Architecture Diagram
# Spring Boot Microservices Project

## Overview
This project implements a microservices architecture using Spring Boot. The main components include:

- **Accounts Microservice**: Manages account details and interacts with the Cards Service to retrieve card information.
- **Cards Microservice**: Provides card details.
- **Eureka Server**: Acts as a service registry for service discovery.
- **Config Server**: Manages external configuration properties for all microservices.
- **API Gateway**: Handles authentication and routing using Keycloak.

## Architecture Diagram

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

## Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- PostgreSQL (or another database of your choice)
- Keycloak server (for authentication)

## Setup

### 1. Clone the Repository
git clone <your-repository-url>
cd <your-project-directory>
