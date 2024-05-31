## Http Java Deamon 형태로 적용

### 아래 예시를 참고하세요.

테스트 <br>
curl -X POST http://localhost:8000/api/test-call -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"phoneNo":"010","msg":"안녕하세요."}'
