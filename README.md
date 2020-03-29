# REA Toy Robot
A mini game app that take command to move a robot on a game board.

## Getting started
#### Prerequisites:
* Java 8
* Maven

#### To build project, run following command:
```
build.sh
```

#### To start the game:
* Use user command input
```
run.sh
```

* Use input file
```
run.sh  filename
```

#### Test
run
```
mvn test
```
Jacoco will produce a index.html file that show test coverage, file name
```
target/site/jacoco/index.html
```
Current test coverage: 97%

#### UML
![UML] (uml/diagram.png)