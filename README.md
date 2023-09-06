# Library

API para gerenciar uma biblioteca simples (CRUD), que usa relacionamento entre collections do MongoDB.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/)
- [MongoDB](https://www.mongodb.com/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git
- Ajustar informações de banco de dados nos arquivos `application-dev.yml` e criar seu `env.properties` a partir do exemplo em `env-example.properties`)
- Construir o projeto:

```bash
./mvnw clean package
```

- Executar a aplicação:

```bash
java -jar target/library-mongodb-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizado o Swagger:

- Listar Livros

```bash
$curl -X 'GET' \
  'http://localhost:8080/v1/api/library/book' \
  -H 'accept: */*'
```
Resposta
```bash
  [
  {
    "id": "64f5ff2d4083a360712236d3",
    "name": "How to Conduct BAU",
    "isbn": "1231231234",
    "author": {
      "id": "64f5fe924083a360712236d2",
      "firstName": "Aaron",
      "lastName": "Hotchner"
    }
  }
]
```

- Cadastrar Membro
```bash
curl -X 'POST' \
  'http://localhost:8080/v1/api/library/member' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "firstName": "Fulano",
  "lastName": "de Tal"
}'
```

Resposta
```bash
{
  "id": "64f759909ddc9c1f9b8dc915",
  "firstName": "Fulano",
  "lastName": "de Tal",
  "status": "ACTIVE"
}
```

- Atualizar Membro
```bash
curl -X 'PATCH' \
  'http://localhost:8080/v1/api/library/member/64f759909ddc9c1f9b8dc915' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "64f759909ddc9c1f9b8dc915",
  "firstName": "Beltrano",
  "lastName": "de Tal",
  "status": "ACTIVE"
}'
```

Resposta
```bash
{
  "id": "64f759909ddc9c1f9b8dc915",
  "firstName": "Beltrano",
  "lastName": "de Tal",
  "status": "ACTIVE"
}
```

- Cadastrar Autor
```bash
curl -X 'POST' \
  'http://localhost:8080/v1/api/library/author' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "firstName": "Jennifer",
  "lastName": "Jareau"
}'
```

Resposta
```bash
{
  "id": "64f775cff6a4786e58b8fbbb",
  "firstName": "Jennifer",
  "lastName": "Jareau"
}
```

- Cadastrar Livro
```bash
curl -X 'POST' \
  'http://localhost:8080/v1/api/library/book' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "name": "Press Management: For FBI agents",
  "isbn": "1112223333",
  "authorId": "64f775cff6a4786e58b8fbbb"
}'
```

Resposta
```bash
{
  "id": "64f77621f6a4786e58b8fbbc",
  "name": "Press Management: For FBI agents",
  "isbn": "1112223333",
  "author": {
    "id": "64f775cff6a4786e58b8fbbb",
    "firstName": "Jennifer",
    "lastName": "Jareau"
  }
}
```

- Listar Livro por ID
```bash
curl -X 'GET' \
  'http://localhost:8080/v1/api/library/book/64f77621f6a4786e58b8fbbc' \
  -H 'accept: */*'
```

Resposta
```bash
{
  "id": "64f77621f6a4786e58b8fbbc",
  "name": "Press Management: For FBI agents",
  "isbn": "1112223333",
  "author": {
    "id": "64f775cff6a4786e58b8fbbb",
    "firstName": "Jennifer",
    "lastName": "Jareau"
  }
}
```

- Emprestar Livro
```bash
curl -X 'POST' \
  'http://localhost:8080/v1/api/library/book/lend' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "bookIds": [
    "64f5ff2d4083a360712236d3"
  ],
  "memberId": "64f759909ddc9c1f9b8dc915"
}'
```

Resposta
```bash
[]
```

- Excluir Livro
```bash
curl -X 'DELETE' \
  'http://localhost:8080/v1/api/library/book/64f5ff2d4083a360712236d3' \
  -H 'accept: */*'
```

Resposta
```bash
```