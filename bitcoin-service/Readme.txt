#Build and deployment steps
1. git clone https://github.com/PSEH-3/BitcoinAPP.git
2. mvn clean install
3. copy bitcoin-service-0.0.1-SNAPSHOT.jar from bitcoin-service/tartget/ and place at server deployment directory
4. restart the server

#Deployment steps of docker image in kubernative cluster
#Clone project from git hub
1. git clone https://github.com/PSEH-3/BitcoinAPP.git 

#buid the project
2. mvn clean install

#Create the docker image using docker file
3. kubectl apply -f bitcon-service.docker

#push the docker to container registry
4. kubctl push /gke/ecomm/registry/image

#Deploy the image on kubernative cluster
5. kubectl apply -f deployment.ymal

#Check if service is deployed
6. kubectl get pods