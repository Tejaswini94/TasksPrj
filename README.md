# TasksPrj
Business Tasks Management

Replenisher Web Application
Today’s Replenishment manager is required to complete a variety of tasks, working with many people to insure optimal product movement through the supply chain.
The goal of this challenge to create an application which allows experienced business users to curate a list of recurring tasks for individual contributors to execute. Individuals should also be able to create independent tasks to be added to their personalized task list. Finally, specialized tasks may also be created by external processes via service calls.

Application Features
Display sorted list of pending tasks
Sorted by first Status, second Rank
Rank should use an algorithm which weighs inputted priority against time estimated to perform the task
User should have ability to track status for individual task
Track time in each status after “Started” until “Finished”
Recurring tasks should be duplicated based on recurrence frequency/schedule
Prerequisites
The following librarys are needed to run this application

1. Java 8
2. Spring 3.2 or higher
3. Hibernate 4
4. Mysql 5.5
5. OS independent

Installing
1. Download either zip folder or through Github desktop
2. Open project in any IDE such as Eclipse, IntelliJ etc.
3. Need Mysql 5.5 or higher version setup in your computer
4. Run the project as Spring Boot Application.

Design
Followed MVC architecture for loose coupling and to ease to add/remove any other componenet based on requirement. Following are the pacakges I have used for this application.

1. Controller
2. DAO: Data Access Object
3. DTO: Data Transfer Object
4. Model: POJO classes
5. Service
6. Util

Future Enhancment
Clientside validation.
Can add more roles /restrictions per user as per need.
Can develope RestAPI for every operation/features to make ease for other developers so that they can consume this service to make there own application.
