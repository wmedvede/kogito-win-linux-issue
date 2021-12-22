# WIndows-Linux Issue Project

Trying to figure out an inconsistent behavior when runnign over Windows systems

## Running the application in using JVM package

```shell script
./mvnw clean package -DskipTests

java -jar ./target/quarkus-app/quarkus-run.jar
```


If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.


## How to reproduce the problem

1 - start env under windows
Theres is docker file to start up env under src/main/docker
double check if everything will fit for your env

docker-compose up

2 - create package and run workflow

```shell script
./mvnw clean package -DskipTests

java -jar ./target/quarkus-app/quarkus-run.jar
```

3 - go to the swagger interface 
http://localhost:8090/workflow/q/swagger-ui/

select service POST /workflow/kpialertworkflow


### First Test Case

try with a valid body (it means no exceptions should be thrown):
{
  "alert": {
    "newValue": "string",
    "kpiId": 0
  }
}

- ON WINDOWS - you will see the error on the console and no process instance is created on management-console (localhost:8280)

### Second Test Case

try another body that should throw an exception
{
  "alert": {
    "newValue": "string",
    "kpiId": 1
  }
}
- ON WINDOWS - the same error as above

Now go to A linux system and run the jar from there and the same test cases

- ON LINUX - For the first test case no exceptions will happen and the process instance is created check on management-console interface

- ON LINUX - For the second test case an exception is thrown and the process instance is also created and it can be checked on management-console

those are the expected behavior


### Version notes

If you run this project as is it is using quarkus 2.5.4.Final and Kogito 1.14.1.Final
This is the worst scenario

If you change pom.xml file to use quarkus 2.3.0.Final and Kogito 1.12.0.Final
things will be a bit better On windows SO, as following:

- first test case everything will work on windows AND on Linux

- second case will not work on Windows 
