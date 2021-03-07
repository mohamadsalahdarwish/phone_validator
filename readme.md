steps :- 
1- Clone the project to your workspace.<br/>
2- Open terminal,cmd .<br />
3- Go to the root project .<br />
4- Type "mvn clean install".
5- Type "docker-compose up —-build".
6- It will be up and running on port 9092.
7- You can use swagger to test the service => http://localhost:9092/swagger-ui.html
8- Test Api1 -> curl -X GET "http://localhost:9092/phones?page=1" -H "accept: application/json"
9- Test APi2(filter by state) -> curl -X POST "http://localhost:9092/phones/filterbyfield" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"criteria\": \"state\", \"field\": \"valid\", \"pageNo\": 1}"
10- Test APi2(filter by country)-> curl -X POST "http://localhost:9092/phones/filterbyfield" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"criteria\": \"country\", \"field\": \"Morocco\", \"pageNo\": 1}"
