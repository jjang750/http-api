## Common API 는 SMS / Telegram 전송용 http API 입니다.
## Http Java Deamon 형태로 

### 아래 예시를 참고하세요.
문자 발송 <br>
curl -X POST http://localhost:8000/api/send-sms -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"phoneNo":"01064386738","msg":"안녕하세요."}'

그룹 문자 발송 <br>
curl -X POST http://localhost:8000/api/send-sms-group -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"groupID":"1","msg":"안녕하세요."}'

텔레그램 전송 <br>
curl -X POST http://localhost:8000/api/send-telegram -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"groupID":"SCOUTER","msg":"테스트 메시지 전송"}'

테스트 <br>
curl -X POST http://localhost:8000/api/testCall -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"phoneNo":"01064386738","msg":"안녕하세요."}'



cd /home/monitor/classes

/usr/local/java1.8/jdk1.8.0_241/bin/javac -cp .:/home/monitor/lib/*:/home/monitor/classes -encoding utf-8 CommonApi.java <br>
/usr/local/java1.8/jdk1.8.0_241/bin/java -cp .:/home/monitor/lib/*:/home/monitor/classes -Dfile.encoding=utf-8 CommonApi &

