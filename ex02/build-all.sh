#!/bin/bash

echo "Building all services..."

cd user && ./gradlew clean build -x test && cd ..
cd product && ./gradlew clean build -x test && cd ..
cd order && ./gradlew clean build -x test && cd ..
cd delivery && ./gradlew clean build -x test && cd ..

echo "Build completed!"





