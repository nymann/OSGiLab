COMPONENT=Asteroids
JAVA_FILES=$(shell find ${COMPOENT} -type f -name "*.java")
POM_FILES=$(shell find ${COMPOENT} -type f -name "pom.xml")
BIN=Asteroids/application/target/Asteroids-app-1.0-SNAPSHOT.zip

default all:run 

${BIN}: ${JAVA_FILES} ${POM_FILES}
	mvn clean install -DskipTests -f ${COMPONENT}/pom.xml

install: ${BIN}

run: ${BIN}
	mvn install pax:provision -f ${COMPONENT}/pom.xml
