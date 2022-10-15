# Automatic Irrigation System

## System Idea
This Automatic Irrigation System provides APIs to help the user:
### Crop API
* Add Crop
* Edit Crop
* Get Crop Details
### Plot API
* Add Plot
* Get Plot Details
* Get All Plots
* Edit Plot
* Configure Plot (planting crop in the land & define irrigation time slot)

## Project Requirements
* Java 11
* Maven 3.8.6
* MySQL

## Steps to run the project
* Run > mvn clean install
* Change Datasource settings in the application.properties to yours
* Create The Database Schema by: CREATE SCHEMA `irrigation_system` ;
* Choose the test case you want to run in "src/main/java/com/farm/irregation/utils/DatabaseSeeder.java"
* Run the project and it will create the database tables for you
* Use the postman collection to call the system APIs, the collection is here: src/main/resources/static/Irrigation-System.postman_collection.json

## Database Design
![Alt text](./src/main/resources/static/db_design.PNG?raw=true "Database Design")

## Design Assumptions
* Sensor is a Singleton Class
* Alarm is a Sigleton Class
* Crop can be planted in many Plots
* Plot can be configured with many time slots
* Each Time Slot has list of scheduled Irrigation Processes

## User Scenario
1. User creates new crop (tomato)
2. User adds new plot (GreenLand)
3. User configures the plot:
    * plant the crop in the plot
    * add TimeSlot
    * Automatically system create irrigation processes based on user setup
4. Every Minute the system checks if there is an irrigation process need to start or finish.
5. Once the sensor starts in the irrigation process , it changes the process status from SCHEDULED to IN_PROGRESS
6. Once the sensor finishes the irrigation process , it changes the process status from IN_PROGRESS to DONE
7. If the sensor was not available the irrigation process do 3 retries in sensor communication, and then change the status to REJECTED

## Test Cases (Database Seeding) 
    * Test Case 1 (Success Scenario): Sensor is available
    * Test Case 2 (Failure Scenario): Sensor is not available
 
