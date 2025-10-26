# MiniJobBoard

A modern job board application built with Spring Boot and HTML/CSS/JavaScript, designed for the Indian job market.

## ðŸš€ Features

- **Job Browsing**: View available jobs with Indian locations and Rupee salaries
- **Job Search**: Search jobs by title, description, or location
- **Job Categories**: Filter by Software Development, Data & Analytics, and Frontend
- **Job Applications**: Submit applications with form validation
- **My Applications**: View submitted applications with local storage persistence
- **Responsive Design**: Works on desktop and mobile devices
- **Indian Localization**: Optimized for Indian job market with Rupee currency

## ðŸ› ï¸ Technology Stack

- **Backend**: Spring Boot 3.2.0, Java 17+
- **Database**: MySQL with JDBC (no JPA)
- **Frontend**: HTML5, CSS3, JavaScript (ES6+)
- **Build Tool**: Maven
- **Server**: Embedded Tomcat
- **Storage**: Browser Local Storage (for applications)

## ðŸ“‹ Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+ (optional - works with local storage)
- Git

## ðŸš€ Quick Start

### 1. Clone the Repository
```bash
git clone <repository-url>
cd MiniJobBoard
```

### 2. Build the Project
```bash
mvn clean compile
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

### 4. Access the Application
- **Web Interface**: Open `index.html` in your browser
- **Backend APIs**: `http://localhost:8080/api/...`

## ðŸ“ Project Structure

```
MiniJobBoard/
â”œâ”€â”€ src/main/java/com/minijobboard/
â”‚   â”œâ”€â”€ MiniJobBoardApplication.java    # Main Spring Boot class
â”‚   â”œâ”€â”€ controller/                     # REST controllers
â”‚   â”‚   â”œâ”€â”€ UserController.java
â”‚   â”‚   â”œâ”€â”€ JobController.java
â”‚   â”‚   â””â”€â”€ ApplicationController.java
â”‚   â”œâ”€â”€ service/                        # Business logic
â”‚   â”‚   â”œâ”€â”€ UserService.java
â”‚   â”‚   â”œâ”€â”€ JobService.java
â”‚   â”‚   â””â”€â”€ ApplicationService.java
â”‚   â”œâ”€â”€ dao/                           # Data access objects
â”‚   â”‚   â”œâ”€â”€ UserDao.java
â”‚   â”‚   â”œâ”€â”€ JobDao.java
â”‚   â”‚   â””â”€â”€ ApplicationDao.java
â”‚   â”œâ”€â”€ model/                         # Data models
â”‚   â”‚   â”œâ”€â”€ User.java
â”‚   â”‚   â”œâ”€â”€ Job.java
â”‚   â”‚   â””â”€â”€ Application.java
â”‚   â”œâ”€â”€ exception/                     # Custom exceptions
â”‚   â”‚   â”œâ”€â”€ UserNotFoundException.java
â”‚   â”‚   â”œâ”€â”€ JobNotFoundException.java
â”‚   â”‚   â””â”€â”€ ApplicationNotFoundException.java
â”‚   â””â”€â”€ config/                        # Configuration classes
â”‚       â”œâ”€â”€ DatabaseConfig.java
â”‚       â””â”€â”€ WebConfig.java
â”œâ”€â”€ src/main/resources/
â”‚   â”œâ”€â”€ application.properties         # Application configuration
â”‚   â””â”€â”€ schema.sql                     # Database schema
â”œâ”€â”€ index.html                         # Frontend interface
â”œâ”€â”€ pom.xml                           # Maven configuration
â””â”€â”€ README.md                         # This file
```

## ðŸ—„ï¸ Database Schema

### Users Table
```sql
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('STUDENT', 'COMPANY') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### Jobs Table
```sql
CREATE TABLE jobs (
    job_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    company VARCHAR(255) NOT NULL,
    description TEXT,
    location VARCHAR(255) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    category VARCHAR(100) NOT NULL,
    company_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (company_id) REFERENCES users(user_id)
);
```

### Applications Table
```sql
CREATE TABLE applications (
    application_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    job_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    applicant_name VARCHAR(255) NOT NULL,
    applicant_email VARCHAR(255) NOT NULL,
    applicant_phone VARCHAR(20),
    applicant_experience INT,
    applicant_skills TEXT,
    cover_letter TEXT,
    status ENUM('PENDING', 'UNDER_REVIEW', 'SELECTED', 'REJECTED') DEFAULT 'PENDING',
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (job_id) REFERENCES jobs(job_id),
    FOREIGN KEY (student_id) REFERENCES users(user_id)
);
```

## ðŸ”Œ API Endpoints

### Users
- `GET /users/all` - Get all users
- `POST /users/register` - Register new user
- `GET /users/{id}` - Get user by ID
- `PUT /users/{id}` - Update user
- `DELETE /users/{id}` - Delete user

### Jobs
- `GET /jobs/all` - Get all jobs
- `POST /jobs` - Create new job
- `GET /jobs/{id}` - Get job by ID
- `PUT /jobs/{id}` - Update job
- `DELETE /jobs/{id}` - Delete job
- `GET /jobs/search?keyword=...` - Search jobs
- `GET /jobs/location/{location}` - Get jobs by location

### Applications
- `GET /applications/all` - Get all applications
- `POST /applications` - Create new application
- `GET /applications/{id}` - Get application by ID
- `PUT /applications/{id}` - Update application
- `DELETE /applications/{id}` - Delete application
- `GET /applications/student/{id}` - Get applications by student
- `GET /applications/job/{id}` - Get applications by job

## âš™ï¸ Configuration

### Application Properties
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/minijobboard?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Server Configuration
server.port=8080

# Logging
logging.level.org.springframework.web=DEBUG
```

## ðŸŽ¯ Sample Data

The application comes with sample data including:
- **10 Sample Jobs** with Indian cities and Rupee salaries
- **4 Companies**: Tech Corp, StartupXYZ, DesignStudio, CloudTech
- **Job Categories**: Software Development, Data & Analytics, Frontend
- **Indian Cities**: Bangalore, Mumbai, Hyderabad, Pune, Delhi, Chennai, Gurgaon, Ahmedabad, Kochi

## ðŸ’¾ Data Storage

- **Applications**: Stored in browser local storage (persists between sessions)
- **Jobs**: Sample data embedded in HTML (can be connected to database)
- **Users**: Database storage (when database is configured)

## ðŸš€ Deployment

### Local Development
1. Run `mvn spring-boot:run`
2. Open `index.html` in your browser
3. Start applying for jobs!

### Production Deployment
1. Configure MySQL database
2. Update `application.properties` with production database settings
3. Build JAR: `mvn clean package`
4. Run JAR: `java -jar target/mini-job-board-1.0.0.jar`

## ðŸ› Troubleshooting

### Common Issues

1. **Ambiguous Mapping Error**
   - Ensure no duplicate endpoint mappings in controllers
   - Check main application class doesn't have conflicting mappings

2. **Maven Not Found**
   - Ensure Maven is installed and in system PATH
   - Verify JAVA_HOME is set correctly

3. **Database Connection Issues**
   - Check MySQL server is running
   - Verify database credentials in `application.properties`

4. **Character Encoding Issues**
   - Ensure files are saved with UTF-8 encoding
   - Use HTML entities for special characters (â‚¹ = &#8377;)

## ðŸ¤ Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature-name`
3. Commit changes: `git commit -am 'Add feature'`
4. Push to branch: `git push origin feature-name`
5. Submit a pull request

## ðŸ“ License

This project is licensed under the MIT License - see the LICENSE file for details.

## ðŸ‘¨â€ðŸ’» Author

**Ruhaan** - *Initial work* - [Your GitHub Profile]

## ðŸ™ Acknowledgments

- Spring Boot team for the excellent framework
- Bootstrap for the CSS framework inspiration
- Font Awesome for the icons
- Indian job market for the localization requirements

---

**Happy Job Hunting! ðŸŽ¯**
