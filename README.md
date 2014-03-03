## Demo App

## Setup
  1. install Play 2.1.X http://www.playframework.com/download
  2. install Redis http://redis.io/
  3. clone https://github.com/gawkermedia/demo-app

## Question 1
persist signup form data into Redis (Scala Redis driver, rediscala already included)

## Question 2
provide a simple lookup screen based on email http://localhost:9000/signup/<email>

## Question 3
  1. provide an xml and JSON representation of http://localhost:9000/signup/<id>
  2. http://localhost:9000/signup/<id>.xml
  3. http://localhost:9000/signup/<id>.json

## Question 4
protect signup form with an admin password

## Question 5
Enforce that Signup#Username starts with uppercase (+4 char min)

## Question 6
for each incoming request print out the available request headers to the console
