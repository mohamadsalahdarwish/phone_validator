steps :- 
1- Clone the project to your workspace.
2- Open terminal,cmd .
3- Go to the root project .
4- Type "mvn clean install".
4- Type "docker-compose up —-build".
5- It will be up and running on port 9092.
6- You can use swagger to test the service => http://localhost:9092/swagger-ui.html
7- Test Api1 -> curl -X GET "http://localhost:9092/phones?page=1" -H "accept: application/json"
8- Test APi2(filter by state) -> curl -X POST "http://localhost:9092/phones/filterbyfield" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"criteria\": \"state\", \"field\": \"valid\", \"pageNo\": 1}"
9- Test APi2(filter by country)-> curl -X POST "http://localhost:9092/phones/filterbyfield" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"criteria\": \"country\", \"field\": \"Morocco\", \"pageNo\": 1}"