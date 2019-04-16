# A demo of Microservices using Spring Cloud. Spring boot.

## Installation
* Zipkin should be installed using Docker or manually. Default port is 9411.
## Run
* There are four projects. 
* Run config_server first.
* Run service_discovery after config_server is done.
* Run twosum_main and calcaulate_fast_service after config and eureka are started.
* There are two profile for calculate_fast_service. dev and dev2. Change boostrap.yml to
indicate which one should be used. The difference is port number(7006 and 7007).
* Request Body using POST method to MainService is :
	
	* content-type:application/json
	* HTTP method: POST
	* Body: { "type":"TWO_SUM", "result": "4","array":[1,2,3,4,5]}
## Monitoring
* access localhost:9411 for zipkin.
* access localhost:8761 for eureka.


