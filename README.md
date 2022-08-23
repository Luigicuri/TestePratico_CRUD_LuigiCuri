# TestePratico_CRUD_LuigiCuri

Teste prático de Cadastro completo (CRUD) de Produtos e Serviços com Spring Boot + PostgreSQL + JPA.

## 1. Requisitos para o building e o running da aplicação:
- PostgreSQL;
- Postman(para as requisições HTTP);

## 1.1. Configurando o Banco de Dados
Para que a aplicação funcione por completo, é necessário criar uma Database através do PostgreSQL e inserir o nome da mesma no arquivo de configuração ***/src/main/resources/application.properties***
### Passo 1
Crie uma nova database com o nome que desejar:

![image](https://user-images.githubusercontent.com/74516086/186069101-e117f21c-be15-49dc-ab82-9fc45e70e41a.png)

Nesse exemplo, será utilizado o nome "minhadatabase":

![image](https://user-images.githubusercontent.com/74516086/186069566-6bec2acc-f308-43af-ab0f-492b258032b0.png)

### Passo 2

Abra o arquivo de configuração do projeto spring ***/src/main/resources/application.properties*** e altere o campo da primeira linha de acordo com a porta a ser utilizada e o nome da database criada:

![image](https://user-images.githubusercontent.com/74516086/186070003-ee729ace-fcfe-4b39-be63-b1f549e3800a.png)

Caso necessário, altere os campos para seus respectivos nomes de usuário e senha:
>spring.datasource.username=postgres
>
>spring.datasource.password=root

### Passo 3

Execute o boot da aplicação, ao executar a aplicação serão criadas as tabelas e colunas no banco de dados.

## 2. Endpoints para as requisições HTTP (Create, Read, Update, Delete, List)

Recomenda-se o programa Postman para a realização das requisições.

***Itens - Produtos ou Serviços***

CREATE item - Método POST - URL: http://localhost:8080/api/items

READ item- Método GET - URL: http://localhost:8080/api/items/ {Id do item}

UPDATE item - Método PUT - URL: http://localhost:8080/api/items/ {Id do item}

DELETE item - Método DELETE - URL: http://localhost:8080/api/items/ {Id do item}

LIST all items - Método GET - URL: http://localhost:8080/api/items


***Orders - Pedidos***

CREATE order - Método POST - URL: http://localhost:8080/api/orders

READ order- Método GET - URL: http://localhost:8080/api/orders/ {Id do pedido}

UPDATE order - Método PUT - URL: http://localhost:8080/api/orders {Id do pedido}

DELETE order - Método DELETE - URL: http://localhost:8080/api/orders {Id do pedido}

LIST all orders - Método GET - URL: http://localhost:8080/api/orders


## Tasks
- [x] Connect to PostgreSQL
- [x] Create Tables and Columns
- [x] Create Model, Repository and Controller
- [x] Implement the CRUD methods in Controller classes
- [x] Create Exceptions
- [x] List, Create, Read, Update and Delete items and products in JSON format
- [ ] Implement OrderedItem API 
- [ ] Model OrderedItem attributes itemId and orderId as PK and FK from tables Item, Order
- [ ] Implement percentualDiscount
