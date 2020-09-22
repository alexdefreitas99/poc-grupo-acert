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

[GET] https://temperature-service.herokuapp.com/v1/converter/
```json
{
    "fromScale": "CELSIUS",
    "toScale": ["FAHRENHEIT", "KELVIN"],
    "value": 1.521489293
}
```
Response: 
```json
{
    "id": 2,
    "valueKelvin": 274.671489293,
    "valueFarenheith": 34.7386807274,
    "valueCelsius": null,
    "value": 1.521489293
}
```

## Step 2:
Buscando temperatura de hoje (Em graus celsius)

Request:

[GET] https://temperature-service.herokuapp.com/v1/check/Porto Alegre
Response: 
```json
{
    "name": "Porto Alegre",
    "id": 3452925,
    "cod": 200,
    "temp": 15.83,
    "feelsLike": 11.75,
    "tempMin": 15.56,
    "tempMax": 16.0,
    "humidity": 59.0
}
```