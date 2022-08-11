### Building an image
#### If docker file name is Dockerfile
```bash
cd <folder where docker file exists>; docker build -t krishnom/<repo>:<tag> .
```


#### If docker file name is not Dockerfile
```bash
cd <folder where docker file exists>; docker build -t krishnom/<repo>:<tag> -f <Dockerfile.name>
```


#### Push to dockerhub repo
```bash
docker login
docker push krishnom/<repo>:<tag>
```


#### Push to you local docker image repository
```bash
docker tag krishnom/<repo>:<tag> <repository-url>/<repo>:<tag>
docker push <repository-url>/<repo>:<tag> 
```