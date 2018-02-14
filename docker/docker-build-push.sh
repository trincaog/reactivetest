#!/bin/bash

REGISTRY_SRV=trincao
APP_NAME=reactivetest
#IMG_NAME=reactivetest-netty
IMG_NAME=reactivetest-tomcat
APP_VERSION=0.0.1

gradle -p .. build
cp ../build/libs/${APP_NAME}-${APP_VERSION}.jar ./app.jar

docker build -t ${IMG_NAME}:${APP_VERSION} .
rm app.jar

docker tag  ${IMG_NAME}:${APP_VERSION} ${REGISTRY_SRV}/${IMG_NAME}:${APP_VERSION}
docker push ${REGISTRY_SRV}/${IMG_NAME}:${APP_VERSION}


