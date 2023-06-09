FROM ubuntu
WORKDIR /

# Base packages
ENV DEBIAN_FRONTEND noninteractive

RUN apt update 
RUN apt -y upgrade
RUN apt -y install openjdk-17-jre-headless

ENV DEBIAN_FRONTEND interactive

# Mapping porst 
EXPOSE 8080 8080
EXPOSE 3306 3306

#Launch commands
ENTRYPOINT ["bash", "-c", "chmod +x ./code/startup.sh ; ./code/startup.sh"]


