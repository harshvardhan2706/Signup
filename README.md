# Java Signup Web Application

This is a Java web application for user registration and login, using JSP, Servlets, and MySQL. The app is ready for cloud deployment (e.g., Render.com) and uses Amazon RDS for the live database.

## Features
- User registration with validation
- User login/logout
- Session management
- Responsive UI (Bootstrap-based)
- MySQL database integration (Amazon RDS)

## Project Structure
```
Signup/
├── src/main/java/com/signup/registration/   # Java servlets
├── src/main/webapp/                        # JSPs, static assets, WEB-INF
├── build/classes/                          # Compiled classes
├── signup.war                              # Deployable WAR file (after build)
```

## Prerequisites
- Java 8+ (JDK)
- Apache Tomcat 9+
- MySQL (Amazon RDS or local)
- (Optional) MySQL Workbench for DB management

## Database Setup
- Uses Amazon RDS MySQL instance.
- Update your DB connection details in `LoginServlet.java` and `RegistrationServlet.java`:

- Make sure your RDS security group allows connections from your app host.


## Live Demo
- Once deployed, access your app at the Render.com-provided URL.


## License
MIT

---
**Contributors:** harshvardhan2706
