# DevInsight – Software Quality & Data Analytics Platform

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.9-red)
![Swagger](https://img.shields.io/badge/API-Swagger%2FOpenAPI-green)
![JUnit](https://img.shields.io/badge/Testing-JUnit%205-blue)
![CI](https://github.com/SMD-JUNAID-BASHA/DevInsight-Software-Quality-Analytics/actions/workflows/ci.yml/badge.svg)

## 📌 Overview

**DevInsight** is a backend-focused **Software Quality and Data Analytics Platform** built using **Java 21 and Spring Boot**.

The platform provides REST APIs for managing software projects, test cases, defects, and build executions. It also calculates software quality metrics and performs automated project risk analysis.

The project demonstrates practical backend engineering, relational database integration, REST API design, validation, exception handling, automated testing, API documentation, code coverage, and CI automation.

---

## 🎯 Project Objectives

DevInsight provides a centralized platform for monitoring software quality indicators such as:

* Test execution results
* Test pass rate
* Defect status
* Defect resolution time
* Build success rate
* Failed builds
* Open defects
* Project-level quality metrics
* Automated project risk assessment

---

## 🚀 Key Features

### Project Management

* Create projects
* Retrieve projects
* Update projects
* Delete projects
* Store project technology and status

### Test Case Management

* Create test cases
* Retrieve test cases
* Update test cases
* Delete test cases
* Track test status
* Track test priority
* Associate test cases with projects

### Defect Management

* Create defects
* Retrieve defects
* Update defects
* Delete defects
* Track defect severity
* Track defect status
* Record defect creation time
* Record defect resolution time

### Build Management

* Create build records
* Retrieve builds
* Update builds
* Delete builds
* Track build status
* Store build duration
* Associate builds with projects

### Quality Analytics

The analytics engine calculates:

* Total test cases
* Passed test cases
* Failed test cases
* Test pass rate
* Total defects
* Open defects
* Resolved defects
* Closed defects
* Average defect resolution time
* Total builds
* Successful builds
* Failed builds
* Build success rate

### Risk Analysis

DevInsight evaluates project quality metrics and generates:

* Risk score
* Risk level
* Quality-based recommendation

Risk levels:

* `LOW`
* `MEDIUM`
* `HIGH`

### API Documentation

Interactive API documentation is available through **Swagger UI / OpenAPI**.

---

## 🏗️ Architecture

```text
                    Client
                      |
                      v
              REST Controllers
                      |
                      v
                Service Layer
                      |
                      v
              Repository Layer
                      |
                      v
                MySQL Database
```

The application follows a layered architecture that separates API handling, business logic, data access, and persistence responsibilities.

---

## 🧩 Technology Stack

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java 21            | Application development         |
| Spring Boot        | Backend application framework   |
| Spring Web         | REST API development            |
| Spring Data JPA    | Database access                 |
| Hibernate          | ORM and persistence             |
| MySQL 8            | Relational database             |
| Maven              | Dependency and build management |
| Jakarta Validation | Request validation              |
| JUnit 5            | Unit testing                    |
| Mockito            | Mock-based testing              |
| JaCoCo             | Code coverage reporting         |
| Swagger / OpenAPI  | API documentation               |
| Git & GitHub       | Version control                 |
| GitHub Actions     | Continuous Integration          |

---

## 📂 Project Structure

```text
devinsight/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/junaid/devinsight/
│   │   │       ├── analytics/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── entity/
│   │   │       ├── exception/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       ├── java/
│       └── resources/
│
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── Dockerfile
├── pom.xml
├── README.md
└── .gitignore
```

---

## 🔌 REST API Endpoints

### Projects

```text
GET     /api/projects
GET     /api/projects/{id}
POST    /api/projects
PUT     /api/projects/{id}
DELETE  /api/projects/{id}
```

### Test Cases

```text
GET     /api/test-cases
GET     /api/test-cases/{id}
POST    /api/test-cases
PUT     /api/test-cases/{id}
DELETE  /api/test-cases/{id}
```

### Defects

```text
GET     /api/defects
GET     /api/defects/{id}
POST    /api/defects
PUT     /api/defects/{id}
DELETE  /api/defects/{id}
```

### Builds

```text
GET     /api/builds
GET     /api/builds/{id}
POST    /api/builds
PUT     /api/builds/{id}
DELETE  /api/builds/{id}
```

### Analytics

```text
GET /api/analytics/quality
GET /api/analytics/projects
GET /api/analytics/risk
```

---

## 📊 Example Quality Metrics

The analytics engine can produce metrics such as:

```json
{
  "totalTestCases": 5,
  "passedTestCases": 4,
  "failedTestCases": 1,
  "testPassRate": 80.0,
  "totalDefects": 6,
  "openDefects": 3,
  "resolvedDefects": 2,
  "closedDefects": 1,
  "totalBuilds": 4,
  "successfulBuilds": 3,
  "failedBuilds": 1,
  "buildSuccessRate": 75.0
}
```

These metrics are used by the risk analysis module to evaluate the current quality state of the project.

---

## 🧪 Testing

The project includes automated tests using **JUnit 5 and Mockito**.

Testing covers application components such as:

* Application context
* Project service operations
* Defect service operations
* Validation and business logic

Test execution:

```bash
mvn clean test
```

---

## 📈 Code Coverage

**JaCoCo** is configured to generate a code coverage report.

Generate the report with:

```bash
mvn clean test
```

The report is generated under:

```text
target/site/jacoco/index.html
```

---

## 🔄 Continuous Integration

The project uses **GitHub Actions** to automatically build and test the application.

The CI pipeline:

1. Checks out the source code
2. Sets up Java 21
3. Uses Maven dependency caching
4. Builds the project
5. Executes the automated test suite

Workflow:

```text
Git Push / Pull Request
          |
          v
    GitHub Actions
          |
          v
       Java 21
          |
          v
     Maven Build
          |
          v
     Automated Tests
          |
          v
       CI Result
```

---

## 📖 API Documentation

After starting the Spring Boot application, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI specification:

```text
http://localhost:8080/v3/api-docs
```

Swagger provides an interactive interface for exploring and testing the REST APIs.

---

## ⚙️ Configuration

The application uses MySQL for the main runtime database.

Database configuration is supplied through environment variables rather than storing sensitive credentials directly in source code.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/devinsight_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}
```

For automated tests, an in-memory H2 database is used so that the test suite can run independently of the local MySQL environment.

---

## ▶️ Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/SMD-JUNAID-BASHA/DevInsight-Software-Quality-Analytics.git
```

### 2. Navigate to the project

```bash
cd DevInsight-Software-Quality-Analytics
```

### 3. Configure the database

Create a MySQL database:

```sql
CREATE DATABASE devinsight_db;
```

Configure the `DB_PASSWORD` environment variable with the MySQL password.

### 4. Run the application

```bash
mvn spring-boot:run
```

The application starts on:

```text
http://localhost:8080
```
