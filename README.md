# 🎓 Student Management System

A web-based application built using **Java, JSP, Servlets, and JDBC**. This project implements a complete **CRUD** (Create, Read, Update, Delete) system to manage student records efficiently in a MySQL database.

## 🚀 Features

- **Add Student:** Register new students with details (ID, Name, Email, Department, etc.).
- **View Students:** Display a comprehensive list of all registered students.
- **Update Records:** Edit existing student information dynamically.
- **Delete Student:** Remove student records from the database.

## 🛠️ Tech Stack

- **Backend:** Java (Servlets, JDBC)
- **Frontend:** JSP, HTML5, CSS3
- **Database:** MySQL
- **Server:** Apache Tomcat (v9.0 or v10.x)
- **IDE:** Eclipse / IntelliJ IDEA / NetBeans

## 📁 Project Structure

```text
Student-Management-System/
├── src/main/
│   ├── java/in/ajay/
│   │   ├── controller/          # Handles HTTP requests/responses
│   │   │   └── MyServlet.java
│   │   ├── daofactory/          # Factory pattern for DAO instantiation
│   │   │   └── StudentDaoFactory.java
│   │   ├── dto/                 # Data Transfer Objects (Student POJO)
│   │   │   └── Student.java
│   │   ├── persistence/         # Database interaction layer (DAO)
│   │   │   ├── RStudentDao.java (Interface)
│   │   │   └── StudentDaoImpl.java (Implementation)
│   │   ├── service/             # Business logic layer
│   │   │   ├── RStudentService.java (Interface)
│   │   │   └── StudentServiceImpl.java (Implementation)
│   │   └── servicefactory/      # Factory pattern for Service instantiation
│   │       └── StudentServiceFactory.java
│   └── webapp/                  # JSP files, CSS, and WEB-INF
└── README.md
