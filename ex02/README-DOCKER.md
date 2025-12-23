# Docker 실행 가이드

## 사전 준비

1. Docker 및 Docker Compose 설치 확인
2. 모든 서비스가 빌드 가능한 상태인지 확인

## 실행 방법

### 1. 모든 서비스 빌드 및 실행

```bash
# 프로젝트 루트에서
docker-compose up --build
```

### 2. 백그라운드 실행

```bash
docker-compose up -d --build
```

### 3. 로그 확인

```bash
# 모든 서비스 로그
docker-compose logs -f

# 특정 서비스 로그
docker-compose logs -f gateway-service
docker-compose logs -f user-service
```

### 4. 서비스 중지

```bash
docker-compose down
```

## 서비스 접근

모든 서비스는 Gateway를 통해 접근:

```bash
# User Service
GET http://localhost:8080/api/users/1
POST http://localhost:8080/api/users/login

# Product Service
GET http://localhost:8080/api/products/1

# Order Service
POST http://localhost:8080/api/orders
GET http://localhost:8080/api/orders/1

# Delivery Service
POST http://localhost:8080/api/deliveries
GET http://localhost:8080/api/deliveries/1
```

## 직접 접근 (포트 매핑)

각 서비스는 호스트 포트로도 접근 가능:

- User Service: http://localhost:8083
- Product Service: http://localhost:8082
- Order Service: http://localhost:8081
- Delivery Service: http://localhost:8084
- Gateway: http://localhost:8080

## Docker 네트워크

모든 서비스는 `msa-network`라는 Docker 네트워크에서 실행되며, 서비스명으로 서로 통신합니다.

## 문제 해결

### 포트 충돌
포트가 이미 사용 중이면 `docker-compose.yml`에서 포트 번호를 변경하세요.

### 빌드 실패
각 서비스의 `build.gradle`과 의존성을 확인하세요.

### 서비스 간 통신 실패
Docker 네트워크에서 서비스명으로 통신하는지 확인하세요 (localhost 대신).





