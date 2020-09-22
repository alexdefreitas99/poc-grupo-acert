# poc-grupo-acert

# Voting session
[![Build Status](https://travis-ci.org/alexdefreitas99/voting-sessions.svg?branch=master)](https://travis-ci.org/alexdefreitas99/voting-sessions)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=alexdefreitas99_voting-sessions&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=alexdefreitas99_voting-sessions)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=alexdefreitas99_voting-sessions&metric=code_smells)](https://sonarcloud.io/dashboard?id=alexdefreitas99_voting-sessions)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=alexdefreitas99_voting-sessions&metric=bugs)](https://sonarcloud.io/dashboard?id=alexdefreitas99_voting-sessions)

Este é um projeto para trabalhar com temperaturas, atualmente converter e verifica a temperatura do dia em determinada cidade.

# Tecnologias utilizadas
- **Java 14.** 
- **Spring boot 2.3.4.**
- **Gradle 6.6.1.**
- **MariaDB in AWS cloud.**

**Obs**: O versionamento de api é feito com packages (v1, v2..).

# Documentação
## Swagger
http://localhost:8283/swagger-ui.html

https://temperature-service.herokuapp.com/swagger-ui.html

# Como rodar este projeto localmente
```bash
$ ./gradlew bootRun
```

# Como utilizar esta API (Application Programming Interface)
## Step 1: 
Convertendo graus celsius em fahrenheit em : 

Request:

[POST] https://voting-sessions-available.herokuapp.com/voting-sessions/v1/agenda
```json
{ "subject": "Agenda testing vote" }
```
Response: 
```json
{
  "id": 4,
  "subject": "Agenda testing vote",
  "votesInFavor": 0,
  "votesAgainst": 0
}
```

## Step 2:
Criando uma sessão de votação para a pauta criada anteriormente.

Request:

[POST] https://voting-sessions-available.herokuapp.com/voting-sessions/v1/session/agenda/4
```json
{ "minuteDuration": 3 }
```
Response: 
```json
{
  "sessionId": 10,
  "agendaId": 4,
  "openingDate": "2020-03-23T22:25:19.628266678",
  "closingDate": "2020-03-23T22:28:19.622715976"
}
```

## Step: 3
Votando

Request:

[POST] https://voting-sessions-available.herokuapp.com/voting-sessions/v1/voting/session/10/agenda/4
```json
{
	"associatedCpf": "54125851085",
	"vote": true
}
```
Response:
```json
{
	"id": 20
}
```

## Para ver o total de votos em uma pauta
[GET] https://voting-sessions-available.herokuapp.com/voting-sessions/v1/agenda/4

Response: 
```json
{
  "id": 4,
  "subject": "Agenda testing vote",
  "votesInFavor": 15,
  "votesAgainst": 6
}
```

# Bônus

## Para ver o total de votes de pautas em sessões especificas.
Obs: The result of each session will only be available after closing

**Esta funcionalidade esta disponíbel apenas para quem rodar a aplicação localmente**
```bash
$ kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic agenda.queuing --from-beginning
```

# Documentação em inglês:
https://github.com/alexdefreitas99/voting-sessions/blob/master/README.EN.md
