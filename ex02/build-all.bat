@echo off
echo Building all services...

cd user
call gradlew.bat clean build -x test
cd ..

cd product
call gradlew.bat clean build -x test
cd ..

cd order
call gradlew.bat clean build -x test
cd ..

cd delivery
call gradlew.bat clean build -x test
cd ..


echo Build completed!





