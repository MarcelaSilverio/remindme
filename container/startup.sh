change_permissions() {
    cd /code
    chmod 777 -R $1
}

change_permissions api
change_permissions front

java -jar target/api-0.0.1-SNAPSHOT.jar
