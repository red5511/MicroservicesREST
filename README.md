# MicroservicesREST

![alt text](https://github.com/red5511/MicroservicesREST/blob/main/drawIO.png)

Projekt został stworzony w celach edukacyjnych pozwala on na otrzymanie informacji, czy podany film jest godny obejrzenia.
Projket stworzony w oparciu o architekture mikroserwisow. Wykorzystane technologie:<br />
-Spring Boot<br />
-Docker<br />
-Kafka<br />
-Eureka Server/Client<br />
-Sleuth<br />
-Zipkin <br />
-Postgres<br />
<br />
Do popranego uruchomienia calości należy posiadać własną baze danych postgres ze stworzoną baza o nazwie "movie" oraz uruchomić kafke (zookeepera i serwer na porcie "[::1]:9092"). 
Ewentualnie zmodyfikować plik docker-compose, aby nie instalować ich ręcznie i wykorzystując dockera do tego (nie zorobiłem tego w ten sposób, ponieważ miałem za mało zasobów na komputerze). Następnie przy użyciu dockera uruchomić pilk dokcer-compose.yml (docker compose up -d)
Jako że moduł kafkaConsumer ma za zadanie wysłać mail do użytkownika do poprawengo działania wymagane jest podanie loginu i hasła do naszej poczty google (oraz pozaznacznie odpowiednich opcji pozwalających na korzystanie z poczty google mniej bezpiecznym aplikacjom https://support.google.com/mail/answer/7126229?p=BadCredentials&visit_id=637807893997216111-1079236320&rd=2#cantsignin&zippy=%2Ci-cant-sign-in-to-my-email-client) w pliku application.yml. Następnie uruchomić wszystkie 5 modułów. Po poprawnym uruchomieniu wszystkiego możemy wejść pod adres http://localhost:8083/api/movie i metodą POST wysłać ciało, które składa się z dwóch elementów (np programem Postman)
<br />
{
	<br />
	"title" : "Moja nazwa filmu",<br />
	"email" : "Mojmail@gmial.com"<br />
}<br />
Jeśli wszystko wykona się poprawnie otrzymamy odpowiedź w formie stringa z informacja jaki rating ma film oraz sugestie czy warto go obejrzec. Powinniśmy również wysłać maila na podany adres email z ogólnymi informacjami.  
