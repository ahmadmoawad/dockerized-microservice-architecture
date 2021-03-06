<img src="https://github.com/am0awad/assignment/blob/master/images/screen_5.jpg" width="100">

# Alten Code Challenge

	- Imagine you are one of our consultants and you got assigned to a project at one of our top partners.

## Scenario:
	
	- They have a number of connected vehicles that belongs to a number of customers.
	- They have a need to be able to view the status of the connection among these vehicles on a monitoring display.
	- The vehicles send the status of the connection one time per minute.
	- The status can be compared with a ping (network trace); no request from the vehficle means no connection. 
	- So, vehicle is either Connected or Disconnected.

## Task:

	- Your task will be to create a data store that keeps these vehicles with their status and the customers who own them, as well as a GUI (preferably web-based) that displays the status.
	- Obviously, for this task, there are no real vehicles available that can respond to your "ping" request.
	- This can either be solved by using static values or by creating a separate machinery that returns random fake status.

## Requirements

	1. Web GUI (Single Page Application Framework/Platform)...done
		 - An overview of all vehicles should be visible on one page (full-screen display), together with their status...done
		 - It should be able to filter, to only show vehicles for a specific customer...done
		 - It should be able to filter, to only show vehicles that have a specific status...done
	2. Random simulation to vehicles status sending...done
	3. If database design will consume a lot of time, use data in-memory representation...done
	4. Unit Testing...done
	5. .NET Core, Java or any language you feel comfortable with....done
	6. Complete analysis for the problem...run
		 - Full architectural sketch to solution.
		 - Analysis behind the solution design, technologies....
		 - How to run your solution.
	7. Use CI (Travis, Circle, TeamCity...) to verify your code (Static analysis,..) and tests...done
	8. Dockerize the whole solution.
	9. Use Microservices architecture...done
		- Use any Microservices Chassis Framework.
	10. Use any free tier on any cloud platform like: - AWS, Azure or GCP...done

## Optional Requirements

	1. Write an integration test...done
	2. Write an automation test...conflict with web driver
	3. Explain if it is possible to be in Serverless architecture and how?...done
	4. Continuous delivery to the solution to the cloud...done

## The Solution
I have created two services at backend for renting service and monitoring service with different database for each of them.
and created the UI using thymeleaf not angular to save some time :)

## The Services

	1- Discovery server Eureka run on port:8761
	2- Config server run on port:8888
	3- Rent service that responsible for renting, occupied the vehicles by the customers run on port:8081
	4- Monitor service that responsible for tracking the status of the vehicles and for the demo I used H2 DB, but for the production will use Mongodb run on port:8083
	5- UI service created by thymeleaf with two different tables that represent Users with the vehicles and another table that tracking the vehicles by the status with filter option to filter users by their names and vehicles by status (online/disconnected) run on port:8080
	For the tracking table the status is changed randomly in short time about ~ 10 Second
	6- Client service for making the integration testing for rent service and monitoring
  
## AWS as cloud
I have create buildspec for CodeBuild CI at AWS and Dockerrun.aws.json for deploy at Beanstalk or ECS

## The Architecture

![alt text](https://github.com/am0awad/assignment/blob/master/images/screen_4.PNG)

## Dockerize the whole solution
I am using docker-compose yml file to manage the images for each of the following services which I already pushed them to Docker Hub

    1- Discovery image: https://cloud.docker.com/repository/docker/am0awad/discovery
    2- Config image: https://cloud.docker.com/repository/docker/am0awad/config
    3- Rent image: https://cloud.docker.com/repository/docker/am0awad/rentservice
    4- Monitor image: https://cloud.docker.com/repository/docker/am0awad/monitor
    5- UI image: https://cloud.docker.com/repository/docker/am0awad/carui
    6- Client image: https://cloud.docker.com/repository/docker/am0awad/client

## Screenshots
### Web UI interface
![alt text](https://github.com/am0awad/assignment/blob/master/images/screen_1.PNG)
![alt text](https://github.com/am0awad/assignment/blob/master/images/screen_2.PNG)

### AWS CodeBuild CI with CodeCommit  
![alt text](https://github.com/am0awad/assignment/blob/master/images/screen_3.PNG)
by using build script: https://github.com/am0awad/assignment/blob/master/buildspec.yml

## For the continuous delivery at AWS
The project is ready for this task by using `Dockerrun.aws.json` file: https://github.com/am0awad/assignment/blob/master/Dockerrun.aws.json
and it's up to you to deploy it using what service you prefer better.

## For the deployment at AWS
there are many solutions, you can use Beanstalk, ansible playbook, ECS, EC2 manual configuration with Autoscale group and bootstrap and Cloudformation

## For the Serverless architecture
We can use Lambda for doing the job, we can create the following flow:

	1- Create Lambda function calledn fn(1) for doing registration to the vehicles to the customers
	2- Create a trigger on Lambda function fn(1) to save the data to MySQL/MariaDB
	3- Create another Lambda function called fn(2) for getting the response (status) from the vehicles 
	4- Create a trigger on Lambda function fn(2) to save the data to DynamoDB
	5- Create Lambda function called fn(3) for making redirect to the webpage hosted at S3 service
	6- Create Lambda function called fn(4) that return JSON data that showing the status of the vechicles
	7- Update the request every 1 minute for getting the new update about the status

## How you can run the solution:
You will need the following dependencies

	1- Docker-Compose yml file: https://github.com/am0awad/assignment/blob/master/docker-compose.yml
	2- Install Docker: https://docs.docker.com/docker-for-mac/install/
	3- Install Docker-Compose: https://docs.docker.com/compose/install/
and run the following command

	$ docker-compose up

Then open your browser and type: http://localhost:8080/
enjoy!
