# 🧱 Kotlin 기반 MSA 학습 프로젝트

이 저장소는 **Kotlin + Spring Boot + Spring Cloud**를 기반으로 한  
**마이크로서비스 아키텍처(MSA)** 학습 내용을 정리한 프로젝트입니다.


---

## 🛠️ 사용 기술 스택

- **Language**: Kotlin
- **Framework**: Spring Boot 3.x
- **MSA Core**:
  - Spring Cloud Gateway
  - Spring Cloud Netflix Eureka
  - Spring Cloud Config Server
  - Spring Cloud Bus + Kafka
- **Logging & Tracing**:
  - Kotlin Logging
  - Spring Cloud Sleuth + Zipkin
- **Build Tool**: Maven
- **Containerization**: Docker (추후 적용 예정)

---

## 📦 서비스 구성

| 서비스 | 설명 | 포트 |
|--------|------|------|
| `gateway-service` | API Gateway 역할 | 8000 |
| `discovery-service` | Eureka Server (서비스 디스커버리) | 8761 |
| `first-service` | 예제 마이크로서비스 1 | 8081 |
| `second-service` | 예제 마이크로서비스 2 | 8082 |

---

## ✅ 학습 목표

- [x] Spring Cloud를 활용한 MSA 아키텍처 설계
- [x] Gateway를 통한 API 라우팅
- [x] Eureka를 통한 서비스 등록 및 탐색
- [ ] Config Server + Bus를 통한 설정 관리 자동화
- [ ] Kafka를 활용한 서비스 간 메시지 통신
- [ ] Zipkin을 통한 분산 추적 구현

---

## 🚀 실행 방법

1. 각 서비스별 `application.yml` 설정 확인
2. Maven 빌드:  
   ```bash
   ./mvnw clean install
   ```
3. 순차 실행:
   - `discovery-service` → `config-server` → 기타 서비스들
4. Gateway로 테스트:  
   예: `http://localhost:8000/first-service/hello`

---

## 📌 참고

- 강의 노트와 실습 코드는 모두 Kotlin으로 재작성됨
- 원본 강의는 Java 기반이며, 이를 Kotlin 스타일로 학습 중

---

## ✍️ 기타 메모

- 실습 중 발견한 차이점이나 문제점은 Issues 또는 Wiki에 정리 예정
- Kotlin Logging을 통해 로그 관리 개선
- 각 마이크로서비스는 독립 실행형 + Eureka 연동 구조
