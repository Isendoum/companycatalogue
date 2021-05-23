# CompanyCatalogue
Requirements Maven & Java
## Instalation
#### Step 1: Clone git repo locally with : 
```bash
git clone https://github.com/Isendoum/companycatalogue.git
```
#### Step 2: Install dependencies and build artifacts
```bash
mvn install
``` 
#### Step 3: In project structure src/main/resources create application.properties file with your database link and credentials(don't forget this step otherwise it is going to throw an error on build) example:
  ```java
  spring.datasource.url=yourDatabaseLink?createDatabaseIfNotExist=true
  spring.datasource.username=yourDatabaseUsername
  spring.datasource.password=youDatabasePassword
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  ``` 
 ###### leave ?createDatabaseIfNotExist=true for database auto-creation
  
#### Step 4: run in terminal
```bash
mvn package
``` 

#### Step 5: run in terminal
```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

#### Step 6: open browser on localhost:8080/ to view the application

##### Note: running example deployed on heroku with inserted data in the database https://companycatalogue.herokuapp.com/

# Using application rest endpoints without frontend

#### Rest Endpoints:
 
 #### Location endpoint rest/locations
 ##### Get "/"
    "Content-Type":"application/xml"
    returns xml list of all available locations
    
 #### Department endpoint rest/departments
 ##### Get "/" request params (lodId, locName)
     "Content-Type":"application/xml"
     
     Both params empty: returns xml list of all available departmets
     locId: returns xml list of all departments based on locId
     locName returns xml list of all departments based on locName
     Both params: returns xml list of all departments based on locName igonoring locId
     
 #### Empolyees endpoint rest/employees
 ##### Get "/" request params
     "Content-Type":"application/xml"
     
     returns xml list of all employees
 ##### Get "/employeesByDept/" request params (deptId)
      "Content-Type":"application/xml"
      
      returns xml list of all employees with deptId
 ##### Get "/employee/" request params (empId)
      "Content-Type":"application/xml"
      
      returns xml of employee with empId
 ##### Get "/search/" request params (firstName,lastName)
      "Content-Type":"application/xml"
      
      returns xml list of employees with match firstName and lastName or any of them if one is empty
      returns all employees if both params are empty strings
