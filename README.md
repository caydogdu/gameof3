# gameof3
A two player game with Spring Boot and Websocket

This is a Websocket game by Cemil Aydogdu.
https://github.com/caydogdu/gameof3

This project was developed with **spring boot**. Java 8 is required. **H2** in-memory database was used.
For front-end **jQuery**, **bootstrap**, **SockJS** and **stomp** were used.

To play run the project and open **localhost:8081** on any browser.
It is played with 2 players.

When a player starts, a random whole number is generated and sent to the other player, which 
indicates the start of the game. The receiving player must now add one of {-1, 0, 1} to get a 
number that is divisible by 3 and then divide it. The resulting number is then sent back to the original sender.
The same rules apply until one of the players reaches the number 1 after division, which ends the game.

## Run options and deployment

This project is a microservice. So you can easily run it.

1- Running as a packaged application If you use the Spring Boot Maven or Gradle plugins first create an executable jar then you can run your application using java -jar. For example: 

    $ java -jar target/gameof3-0.0.1-SNAPSHOT.jar
    
It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:

2- Using the Maven plugin The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. Applications run in an exploded form just like in your IDE.

    $ mvn spring-boot:run
