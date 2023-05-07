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

#Launch commands
ENTRYPOINT ["bash", "-c", "chmod +x startup.sh ; ./startup.sh"]


