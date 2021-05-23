# Installation

#### Requirements Maven & Java

##### Step 1: Clone git repo locally with : git clone https://github.com/Isendoum/companycatalogue.git
##### Step 2: Install dependencies and build artifacts
##### Step 3: In project structure src/main/java/com.backend.backend/config/JPAConfig replace Datasource Bean properties with your database link and credentials(don't forget this step otherwise it is going to throw an error on build)
  
  example:
  dataSource.setUsername("yourUsername");
  dataSource.setPassword("yourPassword");
  dataSource.setUrl("yourDatabaseLink?createDatabaseIfNotExist=true");
          
  leave ?createDatabaseIfNotExist=true for database auto-creation
  
#####Step 4: run "mvn package" in terminal

#####Step 5: run "java -jar target/backend-0.0.1-SNAPSHOT.jar" in terminal

#####Step 6: open browser on localhost:8080/ to view the application

###Note: running example on deployed on heroku with inserted data in the database https://companycatalogue.herokuapp.com/

# Using application rest endpoints without frontend

####Endpoints:
 
 ####Location endpoint rest/locations
 #####get "/" 
    returns xml list of all available locations
    
 ####Department endpoint rest/departments
 #####get "/" request params (lodId, locName)
     Both params empty: returns xml list of all available departmets
     locId: returns xml list of all departments based on locId
     locName returns xml list of all departments based on locName
     Both params: returns xml list of all departments based on locName igonoring locId
     
 ####Empolyees endpoint rest/employees
 #####get "/" request params
     returns xml list of all employees
 #####get "/employeesByDept/" request params (deptId)
      returns xml list of all employees with deptId
 #####get "/employee/" request params (empId)
      returns xml of employee with empId
 #####get "/search/" request params (firstName,lastName)
      returns xml list of employees with match firstName and lastName or any of them if one is empty
      returns all employees if both params are empty strings