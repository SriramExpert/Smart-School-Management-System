# EduSphere: School Management System

[![GitHub last commit](https://img.shields.io/github/last-commit/SriramExpert/SpringBoot-Projects)](https://github.com/SriramExpert/SpringBoot-Projects/tree/main/EduSphere)
[![GitHub repo size](https://img.shields.io/github/repo-size/SriramExpert/SpringBoot-Projects)](https://github.com/SriramExpert/SpringBoot-Projects/tree/main/EduSphere)

##  Project Description

**EduSphere** is a robust web-based school management system designed to streamline both administrative and academic operations in educational institutions. It provides an intuitive interface to manage students, teachers, attendance, examinations, and more. EduSphere helps simplify school workflows and fosters effective communication between administrators, teachers, students, and parents.

---

##  Features

- **Student Management**  
  Add, update, delete, and view student profiles with academic and personal information.

- **Teacher Management**  
  Manage teacher profiles, assigned courses, and subject responsibilities. Teachers can enter student marks and track performance.

- **Mark Entry**  
  Allows teachers to record attendance and exam results for students.

- **User Authentication**  
  Secure login system for Admins, Teachers, and Students.

- **Role-Based Access Control**  
  Access and permissions are managed based on user roles — Admin, Teacher, or Student.

- **Responsive Design**  
  Mobile-friendly interface accessible on desktops, tablets, and smartphones.

- **Database Integration**  
  All data is securely stored using MySQL.

---

##  Technologies Used

- **Backend:** Spring Boot  
- **Frontend:** Thymeleaf (Java-based template engine)  
- **Database:** MySQL  
- **IDE/Tool:** Spring Tool Suite 4 / IntelliJ IDEA

---

## Prerequisites

Before you begin, ensure the following are installed on your system:

- Java 8 or later  
- MySQL  
- Maven  
- Spring Tool Suite (STS) or IntelliJ IDEA

---

##  Installation Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/SriramExpert/SpringBoot-Projects/tree/main/EduSphere

2. **Open the Project**  
   - Open the project in Spring Tool Suite or IntelliJ IDEA.  
   - Import it as a **Maven project**.

3. **Set Up MySQL Database**  
   - Create a database named `edusphere`.  
   - Update your MySQL credentials in the `application.properties` file.

4. **Configure `application.properties`**

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/edusphere
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   server.port=2330  # Optional


5. **Run the Application**  

   Use the following command in the terminal:
   ```bash
   mvn spring-boot:run

6. **Access the Application**

   Open your browser and navigate to:
  ```bash
 http://localhost:8080
```


## Project Directory Structure:

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com.example.edusphere/
│   │       ├── controller/       
│   │       ├── entity/            
│   │       ├── repository/        
│   │       └── service/          
│   ├── resources/
│   │   ├── templates/            
│   │   ├── static/                
│   │   └── application.properties 
│   └── webapp/
│       └── WEB-INF/
│           └── views/             
└── test/


```
##  Project Video Demo

Experience a complete walkthrough of the **Educational Portal System**, including all panels (Admin, Student, Teacher) and the main index page.

### ▶️ Watch the Demo

https://github.com/user-attachments/assets/2a36be5b-ed59-41dc-b8f8-127351bfddb5


---

###  What's Covered in the Video

- 🔹 Overview of the index (preview) page  
- 🔹 Admin Panel functionalities (view, edit, delete records)  
- 🔹 Student Panel: registration, course view, mark tracking  
- 🔹 Teacher Panel: login, course management, result update

---


# Educational Portal System

This project showcases a role-based educational management system with four core modules:

- **Landing Page**
- **Admin Panel**
- **Student Panel**
- **Teacher Panel**

---

##  Preview (Index Page)

The landing page provides a centralized entry point to the entire system. Users can navigate to their respective panels based on their roles.

![Image](https://github.com/user-attachments/assets/6136a495-9f08-40eb-9a04-154f973d9df1)

---

##  Admin Panel

The **Admin Panel** empowers administrators to manage student records effectively.

### ✨ Key Features:
- View a list of all registered students
- Perform **delete** and **edit** operations on student records
- Central control over data management

### 🔻 Screenshots:

![Image](https://github.com/user-attachments/assets/2cee6b42-cdc6-47a0-b6ba-840bac70b60a)

![Image](https://github.com/user-attachments/assets/49bf388a-b694-43de-a74e-347ebfa5fd3e)

---

##  Student Panel

The **Student Panel** is tailored for students to interact with the system seamlessly.

### ✨ Key Features:
- Course enrollment and subject selection
- Personal academic information (e.g., marks, progress)
- Registration confirmation and dashboard access

### 🔻 Screenshots:

#### Student Dashboard:
![Image](https://github.com/user-attachments/assets/17cef938-85ca-4de6-b3aa-642c7cdb3248)

#### Enrollment Activity:
![Image](https://github.com/user-attachments/assets/8c85d216-a1fe-4c28-88cd-14c75f0e3ff7)

#### Successful Registration:
![Image](https://github.com/user-attachments/assets/2be5b0a2-13d1-46ee-a3d3-29c84511856d)

#### Academic Information (Marks):
![Image](https://github.com/user-attachments/assets/582e334e-420e-472a-90ae-8fbe68167201)

![Image](https://github.com/user-attachments/assets/16e8300e-45ef-44ba-a869-d49f87d65776)

#### Course Viewing:
![Image](https://github.com/user-attachments/assets/3d6b22ac-f317-4227-82fb-532f45806d49)

---

##  Teacher Panel

The **Teacher Panel** allows instructors to manage academic content and evaluate students.

### ✨ Key Features:
- Secure teacher login
- Manage and update course details
- Enter and update student results

### 🔻 Screenshots:

#### Teacher Authentication:
![Image](https://github.com/user-attachments/assets/630cfebf-1f6f-4a63-8496-4e07578fef49)

#### Teacher Dashboard:
![Image](https://github.com/user-attachments/assets/59ddfbb1-8029-447a-85cc-945988bd7f15)

#### Course Updates:
![Image](https://github.com/user-attachments/assets/24ecd2b8-2f8e-4612-aee4-7bbe378ac1e3)

![Image](https://github.com/user-attachments/assets/3d6b22ac-f317-4227-82fb-532f45806d49)

#### Student Result Management:
![Image](https://github.com/user-attachments/assets/f85628ba-f167-4013-b251-39956c4ce24c)

---


## 💬 Questions or Feedback?: 

❓ Have Questions or Conflicts?
If you have any doubts, face issues, or find conflicts while using or exploring this project, feel free to ask! I’m always open to feedback, suggestions, and collaboration.

📬 Need more help or want to connect?
You can reach out to me through the contact section on my portfolio — I'd be happy to help!
