# College Admission Portal Backend

## Overview
This project is a backend service for a College Admission Portal. It is built using **Spring Boot** and provides RESTful APIs to manage **courses, departments, and students**.

## Features
- **Manage Courses**: Add, update, retrieve, and delete courses.
- **Manage Departments**: Add, update, retrieve, and delete departments.
- **Manage Students**: Add, update, retrieve, and delete student records.

## Tech Stack
- **Java** (Spring Boot, Spring MVC, Spring Data JPA)
- **MongoDB** (for database storage)
- **Maven** (dependency management)
- **IntelliJ IDEA** (development environment)

## Installation and Setup
### Prerequisites
- Java 17+
- Maven
- MongoDB installed and running

### Steps to Run the Project
1. **Clone the repository**
   ```sh
   git clone https://github.com/selenophil1805/CollegeAdmissionPortal_Backend.git
   cd College_Admission_Portal
   ```
2. **Build the project**
   ```sh
   mvn clean install
   ```
3. **Run the application**
   ```sh
   mvn spring-boot:run
   ```
4. The application will start at **http://localhost:8080**

## API Endpoints

### Courses API
| Method | Endpoint            | Description |
|--------|---------------------|-------------|
| POST   | `/courses`          | Add a new course |
| GET    | `/courses`          | Get all courses |
| GET    | `/courses/{id}`     | Get course by ID |
| PUT    | `/courses/{id}`     | Update course by ID |
| DELETE | `/courses/{id}`     | Delete course by ID |

### Departments API
| Method | Endpoint               | Description |
|--------|------------------------|-------------|
| POST   | `/departments`         | Add a new department |
| GET    | `/departments`         | Get all departments |
| GET    | `/departments/{id}`    | Get department by ID |
| PUT    | `/departments/{id}`    | Update department by ID |
| DELETE | `/departments/{id}`    | Delete department by ID |

### Students API
| Method | Endpoint          | Description |
|--------|------------------|-------------|
| POST   | `/students`      | Add a new student |
| GET    | `/students`      | Get all students |
| GET    | `/students/{id}` | Get student by ID |
| PUT    | `/students/{id}` | Update student by ID |
| DELETE | `/students/{id}` | Delete student by ID |

## Project Structure
```
College_Admission_Portal/
│── src/
│   ├── main/
│   │   ├── java/com/chetan/College_Admission_Portal/
│   │   │   ├── config/                # Security Configurations
│   │   │   ├── controller/            # REST Controllers
│   │   │   ├── entity/                # Entity Classes
│   │   │   ├── repository/            # MongoDB Repositories
│   │   │   ├── service/               # Service Classes
│   │   │   ├── CollegeAdmissionPortalApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│── pom.xml
│── .gitignore
│── README.md
```

## Contributing
1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Open a Pull Request

## 👩‍💻 Author

- **Chetan Dongare**  
  [GitHub Profile](https://github.com/selenophile1805)  
  [LinkedIn Profile](https://www.linkedin.com/in/chetan-dongare-01854022b/)

Feel free to customize this file further based on your needs! Let me know if you'd like additional help. 😊


