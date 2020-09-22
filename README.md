# Temperature Serivce

Este é um projeto para trabalhar com temperaturas, atualmente converte e verifica a temperatura do dia em determinada cidade.

# Tecnologias utilizadas
- **Java 14.** 
- **Spring boot 2.3.4.**
- **Gradle 6.6.1.**
- **MariaDB in AWS cloud.**

**Obs**: O versionamento de api é feito com packages (v1, v2..).

# Documentação
## Swagger
http://localhost:8283/swagger-ui/index.html

https://temperature-service.herokuapp.com/swagger-ui/index.html

# Como rodar este projeto localmente
1. Instalar o plugin do lombok.
2. Habilitar annotation processing nas configurações da IDE

```bash
$ ./gradlew bootRun
```

# Como utilizar esta API (Application Programming Interface)
## Step 1: 
Convertendo graus celsius em fahrenheit em : 

Request:

[POST] https://temperature-service.herokuapp.com/v1/converter/
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

Convertendo kelvin em todas escalas implementadas : 

Request:

[POST] https://temperature-service.herokuapp.com/v1/converter/
```json
{
    "fromScale": "KELVIN",
    "toScale": ["ALL"],
    "value": 300
}
```
Response: 
```json
{
    "id": 10,
    "valueKelvin": 300.0,
    "valueFahrenheit": 80.33000000000004,
    "valueCelsius": 26.850000000000023,
    "value": 300.0
}
```
## Step 2:
Buscando historico de conversões (Por id):
[GET] https://temperature-service.herokuapp.com/v1/converter/1

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

Buscando historico de conversões (Paginado):
[GET] https://temperature-service.herokuapp.com/v1/converter?page=0&size=10
```json
{
    "content": [
        {
            "id": 1,
            "valueKelvin": 274.671489293,
            "valueFarenheith": 34.7386807274,
            "valueCelsius": null,
            "value": 1.521489293
        }
    ],
    "pageable": {
        "sort": {
            "unsorted": true,
            "sorted": false,
            "empty": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 10,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "unsorted": true,
        "sorted": false,
        "empty": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
```

## Step 3:
Buscando temperatura de hoje (Em graus celsius), POR CIDADE;

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