# Nutri Express

API REST de delivery de comida saudavel desenvolvida com Spring Boot, Spring Data JPA e PostgreSQL.

## Como executar

1. Crie um banco PostgreSQL chamado `nutriexpress`.
2. Confira usuario e senha em `src/main/resources/application.properties`.
3. Execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Para executar os testes sem PostgreSQL:

```powershell
.\mvnw.cmd clean test
```

## Endpoints

- `GET /pratos`
- `GET /pratos?categoria=vegano`
- `GET /pratos/{id}`
- `POST /pratos`
- `PUT /pratos/{id}`
- `PATCH /pratos/{id}/valor`
- `GET /pratos/calorias?max=500`
- `DELETE /pratos/{id}`

As respostas usam DTOs e os dados de entrada sao validados com Bean Validation.
