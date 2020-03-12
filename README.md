# ContactList


Environment
---

1. We can run our application on the localhost or in the cloud, using a RDS instance, for example. For a production environment, change the `application.properties`, changing the database connection properties.

2. We can simulate our application on localhost with docker-compose. Run the command: `docker-compose build`. We should have 2 images:
- mysql_image (optional): You can use this image if you want a localhost connection
- contact_list_image

3. We can run our applications with the command: `docker-compose up`. We should then have 2 running containers:
- mysql_service (optional): In a production environment, you could use a RDS instance, for example
- contact_list_service: The service responsible for running our API.

How to start the application manually (outside docker-compose)
---

1. Run `mvn clean install` to build your application
2. Create a mysql schema, for example `contact_list`
3. Setup your database configurations (mysql user, mysql password, mysql host and schema name) inside the `application.properties`
4. Start application with `java -jar target/contactlist-1.0.jar`
5. To check that your application is running enter url `http://localhost:8080`

Tests
---

There are unit tests in this project. You can run it with `mvn clean test`

Project structure
---
1. `Controllers` are responsible for handling HTTP requests
2. `DTOs` are responsible for exposing data, while `FORMs` are responsible for receiving it
3. `Repositories` are responsible for database connections

Endpoints
---

1. You can add a new person on our database with a `POST method` on the URL `http://localhost:8080/person`: `curl --header "Content-Type: application/json"  --request POST http://localhost:8080/person  --data '{"name": "Guilherme", "contacts": [ {"type": "PHONE", "value": "11 99117 6997"}, {"type": "EMAIL", "value": "guilherme@gmail.com"} ] }'`
2. You can list all people from our database with a `GET method` on the URL `http://localhost:8080/person`: `curl --header "Content-Type: application/json"   --request GET    http://localhost:8080/person`
3. Since our listing method uses a pageable object, we can pass additional parameters, simulating a webapp with a `GET method` on the URL `http://localhost:8080/person`: `curl --header "Content-Type: application/json"   --request GET    http://localhost:8080/person?name=Guilherme&page=0&size=2&sort=name,ASC` 
4. You can alter a person data on our database with a `PUT method` on the URL `http://localhost:8080/person/:id`: `curl --header "Content-Type: application/json"  --request PUT http://localhost:8080/person/1  --data '{"name": "Guilherme updated", "contacts": [ {"type": "PHONE", "value": "+ 55 11 99117 6997"}, {"type": "EMAIL", "value": "guilherme.campos@gmail.com"} ] }'`
5. You can delete a person along with its contacts from our database with a `DELETE method` on the URL `http://localhost:8080/person/:id`: `curl --header "Content-Type: application/json"   --request DELETE    http://localhost:8080/person/1`
6. You get the details of a single person from our database with a `GET method` on the URL `http://localhost:8080/person/:id`: `curl --header "Content-Type: application/json"   --request GET    http://localhost:8080/person/1`


Contact
---
grcampos21@gmail.com | (11) 99117-6997