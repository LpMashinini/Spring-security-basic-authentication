# Spring Boot Authentication Mechanisms

This repository demonstrates two different authentication mechanisms in **Spring Boot Security**:

- **Basic Authentication**
- **Form Login Authentication**

---

## 📂 Repository Structure

The repo consists of two branches:

- **`basic-auth`**  
  Implements **Basic Authentication** using Spring Security.  
  - Credentials are sent with every request in the HTTP header (`Authorization: Basic ...`).  
  - Suitable for APIs or services where a browser/client handles authentication automatically.  
  - Minimal UI involvement.

- **`form-login-auth`**  
  Implements **Form Login Authentication** using Spring Security.  
  - Users log in via a custom HTML form.  
  - Credentials are processed by Spring Security, which manages sessions and cookies.  
  - Suitable for web applications with user-facing login pages.
