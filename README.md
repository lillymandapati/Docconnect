Problem Statement:
DoConnect
DoConnect is a popular Question and Answer application in which technical questions are asked and
answered. (like stackoverflow)
There are 2 users in this application:
1. User
2. Admin
## User Stories:
1. As a User, I should be able to register, login and logout from the application.
2. As a User, I should be able to ask any kind of questions based on any topic.
3. As a User, I should be able to search the question based on any string written in the search box.
4. As a User, I should be able to answer any question asked. (active discussion thread / post only)
5. As a User, I should be able to answer more than one question and the same question more than once.
6. As a User, I should be able to chat with other users.
7. As a User, I should be able to like the answers and comment on the answers provided.
## Admin Stories:
1. As an Admin, I should be able to register, login and logout from the application.
2. As an Admin, I should be able to perform CRUD operations on Users. (deactivate existing user in the
place of delete).
3. As an Admin, I should be able to perform CRUD operations on Questions.
4. As an Admin, I should be able to get mail as soon as any new question is asked or any question is
answered.
5. As an Admin, I should be able to approve the question and answer. Any question or answer will be
visible on the DoConnect platform only if it is approved by the admin.
6. As an Admin, I should be able to delete the inappropriate or irrelevant Questions or Answers.
7. As an Admin, I should be able to close the discussion thread/post for the question and update the
status as resolved.
Sprint Plan:
Sprint I Objective:
1. Create database schema (all tables along with their relationships)
2. Create entities in Spring
3. Create Microservice based structure
Proprietary Content. ©Great Learning. All Rights Reserved. Unauthorized use or distribution prohibited
lillylns8897@gmail.com
ED1SLIFRHG
This file is meant for personal use by lillylns8897@gmail.com only.
Sharing or publishing the contents in part or full is liable for legal action.
4. CRUD on User and Admin (login, logout, register)
5. Create template using HTML and CSS
Sprint II Objective:
1. Develop search functionality based on different criteria.
2. CRUD on Question and Answer (create, remove, update, display, deactivate)
3. Mark discussion thread / post as completed.
4. Mark questions / answers as approved.
5. Create like / comments / answers on other questions / answers.
6. Implement Spring security, JWT
Sprint III Objective:
1. Create Data Transfer Objects
2. Create Repository
3. Create Service Layer logic
4. Create controller to direct rest API
5. Create notification microservice for new question / answer added
6. Implement chat functionality
7. Integrate FrontEnd with BackEnd
8. Add extra features
Proprietary Content. ©Great Learning. All Rights Reserved. Unauthorized use or distribution prohibited
lillylns8897@gmail.com
ED1SLIFRHG
This file is meant for personal use by lillylns8897@gmail.com only.
Sharing or publishing the contents in part or full is liable for legal action.
## Instructions: -
1. Create a separate microservice for user and functionalities based on the user using Spring Boot and
register all microservices using Eureka Server
2. Create a separate microservice for the Admin and functionalities based on the admin using Spring Boot
and register all microservices using Eureka Server
3. Swagger implementation should be separate for all the microservices.
4. Establish the connection between the microservices.
5. Use spring cloud to share the configuration between the microservices.
6. Utilize H2 database for storage purposes, with each microservice having its own database instance.
7. Create custom exceptions in each microservice to handle invalid inputs.
8. Implement the relationships where applicable, ensuring data consistency across microservices..
9. Implement inter-microservice communication as needed, considering asynchronous messaging or RESTful APIs.
10. Develop an independent microservice dedicated to dispatching email notifications.
11. Use fetch API to integrate front END with back END.
12. Any extra functionality you may add as per the requirement.
Proprietary Content. ©Great Learning. All Rights Reserved. Unauthorized use or distribution prohibited
