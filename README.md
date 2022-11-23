# CSIT314_APR_2022_PROJECTHD
UOW Bachelor of Computer Science (Big Data) - Software Development Methodologies's Project

This is a project which adopting the Agile Software Development Methodology. It takes 5 sprints (each sprint per week) to be done all the deliverables.

Group member:
1. Cheong Wai Hong (@DylanCheong-tech)
2. Freddy Agus (@babypom)
3. Freddie Koh Shun Gui (@f-ksg)
4. Ngui Kai Zhe (@Vioel)
5. Winson Junior (@Rhynst)
6. Toh Shan Feng
7. Johan Heng

## Overview 
In this project, the team is asked to design and develop a contactless table ordering system that provides a platform for customers to order food and drinks from a restaurant’s digital menu. The customers will be able to make payment directly using the system that can run on their phone, or computer. They will enter a unique code that is available at each table to access the system to make their orders. 

The name of the restaurant is Honeyz Star, which is a Korean fast-food restaurant that specializes in selling fried chicken. Honeyz Star’s Contactless Ordering System supports different user profiles including customers and restaurant employees and employers. For each role, there are different system requirements as each role has different objectives in the system.

- User admins would be in charge of managing all the accounts and roles in the system. They have the authority to add or remove accounts or roles whenever necessary. 
- Customers would be able to browse the restaurant menu, place orders, and make payments all at the table, without heading to the cashier. 
- Restaurant managers would be able to create or modify restaurant information such as menu and prices, coupon codes etc. 
- Restaurant staff would be able to manage orders made by customers and fulfil orders with the help of the system. 
- Restaurant owners would be able to use the system to collect and organize data such as customers’ behaviours and patterns. These insights can be utilised for marketing efforts, allowing the restaurant to provide personalised marketing to customers.

## Technogies 
### Frontend
1. HTML/CSS/JS
2. jQuery
3. d3.js

### Backend
1. Java 
2. Java Web Servlet
3. Apache Tomcat

### Testing
1. JUnit 
2. Mockito

### Database 
1. MySQL
2. phpmyadmin (MySQL web interface)

### Others Tools
1. Maven Project Manager 

## Application Startup
1. Start the database and setup or load in the data if neccessary (as the SQL scripts provided)
2. Run the following command on terminal with maven in the project directory
```
mvn -f ./PROJECTHD tomcat7:run
```
3. After the server code is started, head over to your any browser and accees the application with the following address:
[http://localhost:9000/login.html](http://localhost:9000/login.html)

#### Last Updated On : 28th May 2022
