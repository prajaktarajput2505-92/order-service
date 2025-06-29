# 🛒 Order Service

A Spring Boot microservice that manages order creation and processing in a microservices architecture. This service interacts with other services (like Product Service) and supports REST APIs to handle order-related operations.

---

## 🚀 Features

- Create and retrieve orders
- Integration with external Product Service via Feign Client
- Circuit Breaker support using Resilience4j
- JWT/OAuth2 authentication (if enabled)
- Configurable service endpoints

---

## 🧰 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Cloud OpenFeign
- Resilience4j (for Circuit Breaker)
- Spring Security (JWT/OAuth2)
- Maven

---

## 📦 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven 3.6+
- (Optional) Docker

### 🔧 Clone the Repository

```bash
git clone https://github.com/prajaktarajput2505-92/order-service.git
cd order-service
