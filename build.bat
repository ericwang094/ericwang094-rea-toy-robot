mvn clean install
echo "here"
mvn exec:java "-Dexec.mainClass=com.toy.robot.ToyRobotApp" "-Dexec.args=$1"