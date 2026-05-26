# URL-Shortener-API

API REST desenvolvida com Java + Spring Boot para encurtamento de URLs.

O projeto permite:

Criar URLs encurtadas
Buscar URLs pelo código
Listar todas as URLs cadastradas
Redirecionar automaticamente para a URL original
Tecnologias utilizadas
Java 17+
Spring Boot
Spring Web
Spring Data JPA
H2 Database
Lombok
Maven
Estrutura do projeto
src/main/java/com/Shortener/Url
│
├── controller     # Endpoints da API
├── service        # Regras de negócio
├── repository     # Comunicação com banco
├── model          # Entidade JPA
├── dto            # Objetos de requisição/resposta
├── exception      # Tratamento de exceções
Como rodar o projeto
1. Clonar o repositório
git clone https://github.com/seuusuario/url-shortener.git
2. Abrir o projeto

Abra o projeto em uma IDE como:

IntelliJ IDEA
VSCode
Eclipse
3. Rodar a aplicação

Execute a classe:

UrlApplication.java

Ou via terminal:

./mvnw spring-boot:run
Banco de dados H2

O projeto utiliza banco em memória H2.

Console H2

Acesse:

http://localhost:8080/h2-console
Configurações
JDBC URL: jdbc:h2:mem:urldb
User Name: sa
Password:
Endpoints da API
Criar URL encurtada
POST /api/urls
Body
{
  "urlOriginal": "https://google.com"
}
Exemplo de resposta
{
  "id": 1,
  "urlOriginal": "https://google.com",
  "urlCurta": "a1b2c3d4",
  "geradoEm": "2026-05-26T20:30:00"
}
Buscar URL pelo código
GET /api/urls/{codigo}
Exemplo
GET /api/urls/a1b2c3d4
Listar todas URLs
GET /api/urls
Redirecionar URL
GET /api/urls/redirect/{codigo}
Exemplo
GET /api/urls/redirect/a1b2c3d4

A API retorna um redirecionamento HTTP 302 para a URL original.

Testando no Postman
1. Criar URL
Método: POST
URL:
http://localhost:8080/api/urls
Body → raw → JSON
{
  "urlOriginal": "https://youtube.com"
}
2. Buscar URL
Método: GET
http://localhost:8080/api/urls/{codigo}
3. Redirecionar URL
Método: GET
http://localhost:8080/api/urls/redirect/{codigo}
Tratamento de erros

A API possui tratamento global de exceções utilizando @RestControllerAdvice.

Exemplo de erro
{
  "timestamp": "2026-05-26T20:40:00",
  "status": 404,
  "error": "Not Found",
  "message": "URL não encontrada abc123"
}
Melhorias futuras
Validação de URLs
Swagger/OpenAPI
Banco de dados PostgreSQL
Docker
Deploy na nuvem
Expiração de links
Contador de acessos
Autor

Matheus Cabral

Backend Developer | Java | Spring Boot
