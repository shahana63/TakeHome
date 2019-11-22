# TakeHome

## To run the project,
1. Unzip the project or clone.
2. Open terminal
3. cd to directory 'TakeHome'.
4. Run the command 'maven install'
5. Run the command ' java -jar target/takehome-0.0.1-SNAPSHOT.jar'

## To test the project using Postman.
1. Get a list of all doctors,
    GET http://localhost:8080/doctors

2. Add a new appointment to a doctor's calendar. New appointments can only start at 15 minute intervals. A doctor can have multiple appointments with the same time

    POST http://localhost:8080/doctors/1
    Body Json 

    { "id" : 5, "patientFirstName":"patientFirstName5", "patientLastName" : "patientLastName5", "date":"2019-11-23T08:45", "isNewPatient":true }

3. Get a list of all appointments for a particular doctor and particular day

    GET http://localhost:8080/doctors/1/2019-11-23/appointments

4. Delete an existing appointment from a doctor's calendar

    Delete http://localhost:8080/doctors/1/5
