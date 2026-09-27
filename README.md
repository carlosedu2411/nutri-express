# NutriExpress

API REST de delivery de comida saudável desenvolvida com Spring Boot, Spring Data JPA e PostgreSQL.

## Objetivo

O projeto expõe endpoints para consultar, criar, atualizar e remover pratos de um menu digital, seguindo a arquitetura Controller -> DTO -> Service -> Entity -> Repository, com validações e tratamento de erros padronizados.

## Tecnologias

- Java 17
- Spring Boot 3/4
- Spring Web
- Spring Data JPA
- PostgreSQL
- Bean Validation
- Maven

## Instalação

1. Clone o projeto.
2. Confirme se o Java 17 está instalado.
3. Crie um banco PostgreSQL local com o nome `nutriexpress`.
4. Ajuste as credenciais em `src/main/resources/application.properties` se necessário.

## Configuração do PostgreSQL

No arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nutriexpress
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Não versionar senhas reais. Para ambiente local, usar credenciais de desenvolvimento simples.

## Como executar

```powershell
./mvnw.cmd spring-boot:run
```

## Endpoints obrigatórios

### GET /pratos
Retorna todos os pratos.

### GET /pratos/{id}
Busca um prato pelo identificador.

### GET /pratos?categoria=vegano
Filtra os pratos pela categoria.

### POST /pratos
Cria um novo prato a partir de um `PratoRequestDTO` validado.

### PUT /pratos/{id}
Atualiza um prato pelo ID.

### DELETE /pratos/{id}
Remove um prato.

## Endpoints extras

### PATCH /pratos/{id}/valor
Atualiza somente o valor do prato.

### GET /pratos/calorias?max=500
Retorna os pratos com calorias menores ou iguais ao limite informado.

## Exemplos básicos de requisições

### Criar prato

```http
POST /pratos
Content-Type: application/json

{
  "nome": "Salada Fitness",
  "descricao": "Salada com quinoa e vegetais",
  "valor": 29.90,
  "categoria": "vegano",
  "calorias": 320,
  "quantidade": 250,
  "unidadeMedida": "g"
}
```

### Buscar por categoria

```http
GET /pratos?categoria=vegano
```

### Atualizar valor

```http
PATCH /pratos/1/valor
Content-Type: application/json

{
  "valor": 25.90
}
```

## Regra de negócio implementada

A aplicação não permite dois pratos com o mesmo nome, ignorando maiúsculas e minúsculas. Isso é validado antes de criar e também antes de atualizar, permitindo que o mesmo prato mantenha o nome atual, mas impedindo que outro prato use um nome duplicado.

## Testes

```powershell
./mvnw.cmd test
```

