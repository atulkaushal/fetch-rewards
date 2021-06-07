# Fetch Rewards

# Build project

     mvn clean install
# Installable location

    $PROJECT_HOME_DIR/target/fetch-reward-1.0.jar
    
# Deployment
    java -jar fetch-rewards-1.0.jar
    
# REST endpoints:

Add Points: POST http://localhost:8080/add to add points and payer.

Request

    curl -i -X POST -H "Content-Type: application/json" --data "{ \"payer\": \"DANNON\", \"points\": 1000, \"timestamp\": \"2020-11-02T14:00:00Z\"}" http://localhost:8080/add

Response

    HTTP/1.1 200
    Content-Type: text/plain;charset=UTF-8
    Content-Length: 11
    Date: Mon, 07 Jun 2021 15:23:23 GMT

    DANNON:1000

Spend Points: POST http://localhost:8080/spend to use/spend points.

Request

    curl -i -X POST -H "Content-Type: application/json" --data "{ \"points\": 300}" http://localhost:8080/spend

Response

    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Mon, 07 Jun 2021 15:25:24 GMT

    {"DANNON":-300}

Balance: GET http://localhost:8080/balance to check balance points.

Request

    curl -i -X GET http://localhost:8080/balance
  
 Response
 
    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Mon, 07 Jun 2021 15:32:20 GMT

    {"DANNON":2700}
 
 
