mongodb-java-springdata-casadocodigo
====================================

MongoDB + Java com Spring Data  + Bootstrap
--------------------------------------------

* Database.....: *test*
* Collection...: *seriados*

* Carga 

```
 mongo < db/seriados.js
```


* Exemplo de documento

```
db.seriados.findOne()
 
{
    "_id" : "1",
    "nome" : "Breaking Bad",
    "personagens" : [ 
        "Walter White", 
        "Skyler White", 
        "Jesse Pinkman", 
        "Hank Schrader", 
        "Marie Schrader ", 
        "Saul Goodman"
    ]
}
```


# Rodando


```
 mvn clean  
 mvn spring-boot:run

```
