# craftworks_challenge

## requests previews

Get all of the tasks ordered by date created

`curl -X GET localhost:8080/tasks`

Get one task by id

`curl -X GET localhost:8080/tasks/{id}`

Delete task by id

`curl -X DELETE localhost:8080/tasks/{id}`

Add one task

`curl -X POST localhost:8080/tasks -H 'Content-type:application/json' -d '{json-content}'`

Update one task

`curl -X PUT localhost:8080/tasks/{id} -H 'Content-type:application/json' -d '{json-content-to-update}'`

## starting the application
`./gradlew clean build`

`docker build -t myapp .`

`docker compose up`
