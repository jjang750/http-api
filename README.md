## Common API �� SMS / Telegram ���ۿ� http API �Դϴ�.
## Http Java Deamon ���·� 

### �Ʒ� ���ø� �����ϼ���.
���� �߼� <br>
curl -X POST http://localhost:8000/api/send-sms -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"phoneNo":"01064386738","msg":"�ȳ��ϼ���."}'

�׷� ���� �߼� <br>
curl -X POST http://localhost:8000/api/send-sms-group -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"groupID":"1","msg":"�ȳ��ϼ���."}'

�ڷ��׷� ���� <br>
curl -X POST http://localhost:8000/api/send-telegram -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"groupID":"SCOUTER","msg":"�׽�Ʈ �޽��� ����"}'

�׽�Ʈ <br>
curl -X POST http://localhost:8000/api/testCall -H 'Content-Type: application/json;charset=UTF-8' -H 'cache-control: no-cache' -d '{"phoneNo":"01064386738","msg":"�ȳ��ϼ���."}'



cd /home/monitor/classes

/usr/local/java1.8/jdk1.8.0_241/bin/javac -cp .:/home/monitor/lib/*:/home/monitor/classes -encoding utf-8 CommonApi.java <br>
/usr/local/java1.8/jdk1.8.0_241/bin/java -cp .:/home/monitor/lib/*:/home/monitor/classes -Dfile.encoding=utf-8 CommonApi &

