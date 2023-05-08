
# Remindme

This is a small web system to create reminders. The back end is a Spring Boot Java API REST, and the front end was made with HTML, CSS and JavaScript using the JQuery library. 

## Note

I tried to create docker containers to be easier to execute, but it didn't work out : (

If you want to check, it was supposed to work like this (the api was not connecting to the database service properly):
```bash
  cd ~/remindme
  chmod +x setup.sh
  ./setup.sh
```

## Initial Setup

Since I couldn't make the docker container work, to execute the project, your system should have the JDK17 installed. You can install it on a linux system using the command: 

```bash
  sudo apt install openjdk-17-jre-headless
  java --version
```

You also have to create the databases and start the mysql service. There are two databases you should create ("remindme" and "remindme_test"). To install the mysql on your system: 

```bash
    sudo apt install mysql-server
```
It is necessary to configure the mysql root with the password "I98b7z5$" or you can use the second command I am going to present on the following part.

To start the api you can type:

```bash
    cd ~/remindme/container/api
    java -jar api-0.0.1-SNAPSHOT.jar
```

or 

```bash
    cd ~/remindme/container/api
    java -Dspring.profiles.active=prod -DDATASOURCE_URL=jdbc:mysql://localhost:3306/remindme -DDATASOURCE_USERNAME={YOUR_USER} -DDATASOURCE_PASSWORD={YOUR_PASSWORD} -jar api-0.0.1-SNAPSHOT.jar
```

Once you have started the api, you can access the front opening the HTML file on the browser: _/remindme/container/index.html_

## The RESTful API

It is possible to access the API documentation using the url: _http://localhost:8080/swagger-ui/index.html/_

This Swagger documentation allows you to test the endpoints and see the schemas being used.

There is also a json file on the repository that you can import to insomnia to check all the endpoints.

## Project Details

- The API was created using the Spring Boot Framework because it is simple and allows to integrate easily with other technologies. I used it alongside Maven that was managing the dependencies.

- I created one unit test responsible to check if the post method returns 400 http code if invalid data is sent. I used the JUnit dependency to create it.

- One import topic I tried to follow was the SOLID principles. They are very important, and allows our code to be easier to maintain and also prevents bugs from happening.

- Some Desing Patterns were used in the project:
    - Data transfer object (DTO)
    - Repository pattern
    - Service pattern









