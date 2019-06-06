## alten-assignment

# Alten Code Challenge

	- Imagine you are one of our consultants and you got assigned to a project at one of our top partners.

## Scenario:
	
	- They have a number of connected vehicles that belongs to a number of customers.
	- They have a need to be able to view the status of the connection among these vehicles on a monitoring display.
	- The vehicles send the status of the connection one time per minute.
	- The status can be compared with a ping (network trace); no request from the vehicle means no connection. 
	- So, vehicle is either Connected or Disconnected.

## Task:

	- Your task will be to create a data store that keeps these vehicles with their status and the customers who own them, as well as a GUI (preferably web-based) that displays the status.
	- Obviously, for this task, there are no real vehicles available that can respond to your "ping" request.
	- This can either be solved by using static values or ​​by creating a separate machinery that returns random fake status.

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
	2. Write an automation test...not
	3. Explain if it is possible to be in Serverless architecture and how?...run
	4. Continuous delivery to the solution to the cloud...done

## The Solution
I have created two services at backend for renting service and monitoring service with different database for each of them.
and created the UI using themyleaf not angular to save some time :)

## The Services

    1- Discovery server Eureka
    2- Config server
    3- Rent service that responsible for renting, occuppied the vehicles by the customers
    4- Monitor service that responsible for tracking the status of the vehicles and for the demo I used H2 DB, but for the production will use Mongodb
    4- UI service created by themyleaf with two different tables that represent Users with the vehicles and another table that tracking the vehicles by the status with filter option to filter users by their name and vehicles by status
    5- Client service for making the integration testing for rent service and monitoring
  
## AWS as cloud
I have create buildspec for CodeBuild CI at AWS and Dockerrun.aws.json for deploy at Beanstalk or ECS

## The Architecture

## Dockerize the whole solution
I am using docker-compose yml file to manage the images for each of the services that I pushed at Docker Hub

    1- Discovery image: https://cloud.docker.com/repository/docker/am0awad/discovery
    2- Config image: https://cloud.docker.com/repository/docker/am0awad/config
    3- Rent image: https://cloud.docker.com/repository/docker/am0awad/rentservice
    4- Monitor image: https://cloud.docker.com/repository/docker/am0awad/monitor
    5- UI image: https://cloud.docker.com/repository/docker/am0awad/carui
    6- Client image: https://cloud.docker.com/repository/docker/am0awad/client

