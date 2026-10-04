# Student Management System

A console-based Java application to manage student records. It performs CRUD operations (Create, Read, Update, Delete) on a PostgreSQL database using JDBC.

## Project Description

This project lets an administrator add, view, search, update and delete student records from a menu-driven console. All data is stored in a PostgreSQL database, so records stay saved after the program closes. The code is divided into separate layers (model, database connection, DAO and main), so each class has one job and the project is easy to maintain and extend.

## Features

- Add a new student (name, email, course, marks)
- View all students
- Search a student by ID
- Update student details
- Delete a student
- Input validation for numeric fields
- Exception handling for database errors
- Unique email constraint to prevent duplicate students

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17+ | Core programming language |
| JDBC | Connecting Java to the database |
| PostgreSQL | Database |
| Maven | Build and dependency management |
| Eclipse IDE | Development environment |

## Project Structure

```
StudentManagementSystem
├── pom.xml
└── src/main/java/com/student
    ├── model
    │   └── Student.java          (student data: fields, getters, setters)
    ├── db
    │   └── DBConnection.java     (database connection details)
    ├── dao
    │   └── StudentDAO.java       (SQL operations: insert, select, update, delete)
    └── main
        └── Main.java             (menu and user input)
```

## Prerequisites

- JDK 17 or later
- PostgreSQL (with pgAdmin or any SQL client)
- Eclipse IDE (or any Java IDE with Maven support)
- Internet connection on first run, so Maven can download the PostgreSQL JDBC driver

## Database Setup

1. Open pgAdmin and create a database named `Student_db` (the name is case-sensitive).
2. Open the Query Tool on that database and run:

```sql
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(80) UNIQUE,
    course VARCHAR(50),
    marks DOUBLE PRECISION
);
```

### Table structure

| Column | Type | Description |
|---|---|---|
| id | SERIAL (Primary Key) | Auto-generated student ID |
| name | VARCHAR(50), NOT NULL | Student name |
| email | VARCHAR(80), UNIQUE | Student email |
| course | VARCHAR(50) | Course name |
| marks | DOUBLE PRECISION | Marks obtained |

## How to Run

1. Clone the repository:
```
   git clone https://github.com/ramchandra397/StudentManagementSystem.git
```
   or download it as a ZIP and extract it.
2. In Eclipse, go to **File → Import → Maven → Existing Maven Projects** and select the project folder.
3. Open `src/main/java/com/student/db/DBConnection.java` and replace `your_password` with your PostgreSQL password. If your database name or port is different, update the URL as well:
```java
   jdbc:postgresql://localhost:5432/Student_db
```
4. Right-click the project → **Maven → Update Project** to download the JDBC driver.
5. Open `Main.java`, right-click → **Run As → Java Application**.

## Sample Menu

```
===== Student Management System =====
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
Enter choice:
```

## Sample Output

```
Enter choice: 2
1 | ram | ram@test.com | java | 70.0
2 | tarun | tarun@test.com | python | 79.0
```

## Concepts Used

- Object-Oriented Programming (classes, encapsulation, constructors)
- Collections (ArrayList)
- JDBC with PreparedStatement and ResultSet
- try-with-resources and exception handling
- DAO design pattern and layered structure
- SQL (CREATE, INSERT, SELECT, UPDATE, DELETE)
- Maven dependency management (pom.xml)

## Future Improvements

- Move database credentials to a properties file
- Add a web interface using Servlets/JSP or Spring Boot
- Add search by name or course

## Author

MADDIBOINA SRI RAMCHANDRA
GitHub: [ramchandra397](https://github.com/ramchandra397)
