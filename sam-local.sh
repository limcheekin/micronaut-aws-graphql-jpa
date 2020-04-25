#!/bin/sh
docker build . -t micronaut-aws-graphql-jpa
mkdir -p build
docker run --rm --entrypoint cat micronaut-aws-graphql-jpa  /home/application/function.zip > build/function.zip

sam local start-api -t sam.yaml -p 3000

