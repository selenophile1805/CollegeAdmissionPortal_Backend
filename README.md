# College Admission Portal - Backend

## Overview
This is the backend service for the College Admission Portal, built using **Spring Boot**. It provides RESTful APIs for managing students, courses, and departments with secure authentication.

## Features
- **Student Management**: Add, update, delete, and retrieve student records.
- **Department Management**: CRUD operations for college departments.
- **Course Management**: CRUD operations for courses.
- **Authentication & Security**: Custom security configuration with OAuth2 or JWT (planned).
- **Spring Data MongoDB**: Repository-based database access.
- **RESTful API**: Well-structured API endpoints following best practices.

## Tech Stack
- **Backend**: Java, Spring Boot
- **Database**: MongoDB
- **Security**: Spring Security (OAuth2 or JWT)
- **Build Tool**: Maven

## Installation & Setup
### **Prerequisites**
- Java 17+
- Maven
- MongoDB

### **Clone the Repository**
```sh
git clone https://github.com/selenophile1805/CollegeAdmissionPortal_Backend.git
cd CollegeAdmissionPortal_Backend
```

### **Set Up Configuration**
Create a `.env` file (or update `application.properties` / `application.yml`) and configure database credentials and OAuth secrets.

### **Run the Application**
```sh
mvn spring-boot:run
```

The backend will be available at `http://localhost:8080/`.

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/students` | Get all students |
| `POST` | `/students` | Add a new student |
| `GET` | `/departments` | Get all departments |
| `POST` | `/departments` | Add a new department |
| `GET` | `/courses` | Get all courses |
| `POST` | `/courses` | Add a new course |

## Environment Variables
Set up environment variables for secrets:
```
MONGO_URI=mongodb://localhost:27017/college_portal
OAUTH_CLIENT_ID=your-client-id
OAUTH_CLIENT_SECRET=your-client-secret
```

## Contributing
1. Fork the repository
2. Create a new feature branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m "Add new feature"`)
4. Push to the branch (`git push origin feature-branch`)
5. Open a Pull Request

## License
This project is licensed under the MIT License.

---

