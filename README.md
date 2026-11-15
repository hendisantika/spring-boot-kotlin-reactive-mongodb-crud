# spring-boot-kotlin-reactive-mongodb-crud

[![Build](https://github.com/hendisantika/spring-boot-kotlin-reactive-mongodb-crud/actions/workflows/build.yml/badge.svg)](https://github.com/hendisantika/spring-boot-kotlin-reactive-mongodb-crud/actions/workflows/build.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Kotlin](https://img.shields.io/badge/Kotlin-2.4.21-7F52FF?logo=kotlin)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-6DB33F?logo=springboot)
![Gradle](https://img.shields.io/badge/Gradle-9.9.1-02303A?logo=gradle)
![MongoDB](https://img.shields.io/badge/MongoDB-8.0-47A248?logo=mongodb)

A reactive CRUD REST API built with **Kotlin**, **Spring Boot WebFlux** and **Reactive MongoDB**.
It manages `Company` and `Employee` documents, where an employee can optionally belong to a company.

## Tech Stack

| Component        | Version                                  |
|------------------|------------------------------------------|
| JDK              | 25 (Gradle toolchain)                    |
| Kotlin           | 2.4.21                                   |
| Spring Boot      | 4.1.2 (WebFlux, Data MongoDB Reactive)   |
| Reactor Kotlin   | `reactor-kotlin-extensions`              |
| Build tool       | Gradle 9.9.1 (Kotlin DSL, wrapper)       |
| Database         | MongoDB 8.0 (via Docker Compose)         |

## Prerequisites

- JDK 25 (e.g. [Eclipse Temurin](https://adoptium.net/))
- Docker & Docker Compose (to run MongoDB)

## Getting Started

```shell
git clone https://github.com/hendisantika/spring-boot-kotlin-reactive-mongodb-crud.git
cd spring-boot-kotlin-reactive-mongodb-crud

# Run the app (spring-boot-docker-compose starts MongoDB from compose.yaml automatically)
./gradlew bootRun
```

Or start MongoDB manually first:

```shell
docker compose up -d
./gradlew bootRun
```

The application runs on `http://localhost:8080`.

### Build & Test

```shell
./gradlew build
```

## API Endpoints

### Company — `/api/company`

| Method   | Path                | Description          |
|----------|---------------------|----------------------|
| `POST`   | `/api/company`      | Create a company     |
| `GET`    | `/api/company`      | List all companies   |
| `GET`    | `/api/company/{id}` | Get company by id    |
| `PUT`    | `/api/company/{id}` | Update a company     |
| `DELETE` | `/api/company/{id}` | Delete a company     |

```json
{
  "name": "Acme Corp",
  "address": "Jl. Asia Afrika No. 1, Bandung"
}
```

### Employee — `/api/employee`

| Method   | Path                                | Description                  |
|----------|-------------------------------------|------------------------------|
| `POST`   | `/api/employee`                     | Create an employee           |
| `GET`    | `/api/employee`                     | List all employees           |
| `GET`    | `/api/employee/{id}`                | Get employee by id           |
| `GET`    | `/api/employee/company/{companyId}` | List employees of a company  |
| `PUT`    | `/api/employee/{id}`                | Update an employee           |
| `DELETE` | `/api/employee/{id}`                | Delete an employee           |

```json
{
  "firstName": "Hendi",
  "lastName": "Santika",
  "email": "hendi@example.com",
  "companyId": "<optional company id>"
}
```

### Example

```shell
curl -X POST http://localhost:8080/api/company \
  -H "Content-Type: application/json" \
  -d '{"name":"Acme Corp","address":"Bandung"}'

curl http://localhost:8080/api/company
```

## CI/CD & Dependency Management

- **GitHub Actions** — [`.github/workflows/build.yml`](.github/workflows/build.yml) builds and tests the project on
  Temurin JDK 25 for every push and pull request to `main`, and uploads test reports and the application jar as artifacts.
- **Dependabot** — [`.github/dependabot.yml`](.github/dependabot.yml) checks weekly (Monday 06:00 WIB) for updates to:
  - Gradle dependencies (grouped: `spring-boot`, `kotlin`, `test`, `minor-and-patch`)
  - GitHub Actions (grouped into a single PR)
  - Docker images in `compose.yaml` (MongoDB)

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: [@hendisantika34](https://t.me/hendisantika34)
- Link: [s.id/hendisantika](https://s.id/hendisantika)
