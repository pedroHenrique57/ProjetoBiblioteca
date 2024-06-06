# Projeto de Biblioteca - Sistema RESTful para Criação e Empréstimo de Livros

Este projeto é o MVP para uma aplicação simples desenvolvida em Java utilizando o estilo arquitetural RESTful e clean
architecture
para a gestão de uma biblioteca escolar. Ele permite a criação, atualização, remoção e empréstimo de livros, fornecendo
endpoints para interação com a aplicação.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JDBC
- Hibernate
- Lombok
- Banco de Dados MySQL

# Consumo da Aplicação

> [!TIP]
> No diretório `./Postman Export` existe um arquivo .json configurado com todos os endpoint.

A aplicação é acessada através de endpoints HTTP. Abaixo está o mapa dos endpoints disponíveis:

## Endpoints para livros.

- `POST` `/livros/criar`: registra um livro no banco de dados. Necessário fornecer um body com a entidade livroRDN (
  Disponibilizado abaixo ).

``` Json
{
    "id__Livros": INT,
    "nome__Livro": String(45VARCHAR),
    "descricao": String(200VARCHAR)
} 
```

***

- `PATCH` `/livros/patch`: atualiza as informações de um livro no banco de dados. Necessário fornecer um body de
  livroEntidadeRepositorio ( Disponibilizado abaixo ).

``` Json
{ 
    "id__Livros": INT,
    "nome__Livro": String(45VARCHAR),
    "descricao": String(200VARCHAR)
}
```

*** 

- `DELETE` `/livros/delete/{id__Livros}`: Remove um livro do banco de dados. Necessário fornecer uma variável de
  rota com o ID do livro ( Exemplo abaixo ).  
  `Apagar livro com id 109125 = /livros/delete/109125`

*** 

- `GET` `/livros/findbyid/{id__Livros}`: Retorna um body com as informações de um livro existente com o ID fornecido (
  Exemplo abaixo ).  
  `Procurar livro com id 109125 = /livros/findbyid/109125`  
  `Body de retorno:`

``` Json
{
    "id__Livros": 109125,
    "nome__Livro": "Livro 1",
    "descricao": "Livro 1"
}
```

***

- `GET` `/livros/findall`: Retorna um body com uma lista das informações de todos os livros existente no banco de dados.  
  `Body de retorno:`
``` Json
[
    {
        "id__Livros": 109125,
        "nome__Livro": "Livro 1",
        "descricao": "Livro 1"
    },
    {
        "id__Livros": 109126,
        "nome__Livro": "Livro 2",
        "descricao": "Livro 2"
    },
        {
        "id__Livros": 109127,
        "nome__Livro": "Livro 3",
        "descricao": "Livro 3"
    }
]
```

## Endpoints para alunos.

> [!WARNING]
> O RA do aluno tem que ter obrigatóriamente 10 caracteres.

- `POST` `/aluno/criar`: Registra um aluno no banco de dados. Necessário fornecer um body com a entidade alunoRDN (
  Disponibilizado abaixo ).

``` Json
{
    "ra": String(10VARCHAR),
    "nome__aluno": String(45VARCHAR),
    "turma": String(15VARCHAR)
}
```

***

- `PATCH` `/aluno/patch`: Atualiza um aluno a partir do RA informado. É necessário enviar um body de
  alunoEntidadeRepositorio ( Disponibilizado abaixo ).

``` Json
{
    "ra": "RA com 10 Dígitos",
    "nome__aluno": "Nome para atualizar",
    "turma": "Turma para atualizar"
}
```

***

- `DELETE` `/aluno/delete/{RA}`: Remove um aluno do banco de dados. Necessário fornecer uma variável de
  rota com o RA do aluno ( Exemplo abaixo ).  
  `Apagar aluno com id 123A456B78 = /aluno/delete/123A456B78`

***

- `GET` `/aluno/findbyid/{RA}`: Retorna um body com as informações de um aluno existente com o RA fornecido (
  Exemplo abaixo ).  
  `Procurar aluno com id 123A456B78 = /aluno/delete/123A456B78`  
  `Body de retorno:`

``` Json
{
    "ra": "123A456B78",
    "nome__aluno": "Jabuticabinha",
    "turma": "Jabuticabeiro"
}
```

***

- `GET` `/alunos/findall`: Retorna um body com uma lista das informações de todos os alunos existente no banco de dados.  
  `Body de retorno:`
``` Json
[
    {
        "ra": "123A456B78",
        "nome__aluno": "Jabuticabinha",
        "turma": "Jabuticabeiro"
    },
    {
        "ra": "987C654D32",
        "nome__aluno": "Jabuticaba",
        "turma": "Jabuticabeiro"
    },
    {
        "ra": "123A78B456",
        "nome__aluno": "Jabuticabão",
        "turma": "Jabuticabeiro"
    }
]
```

## Endpoints de emprestimos.

- `POST` `/emprestimo/criar`: registra um emprestimo de livro para um aluno no banco de dados. Necessário fornecer um
  body com a entidade emprestimoRDN ( Disponibilizado abaixo ).

``` Json
{
    "livros__id__livros" : int,
    "aluno__RA" : String(10VARCHAR)
}
```

***

- `DELETE` `/emprestimo/delete`: Remove um emprestimo do banco de dados. Necessário fornecer um body com a entidade
  emprestimoRDN ( Exemplo abaixo ).

``` Json
{
    "livros__id__livros" : 10,
    "aluno__RA" : "9876542210"
}
```

***

- `GET` `/emprestimo/findemprestimobybook/{id__Livro}`: Retorna um body com uma lista contendo todos os emprestimos com
  o ID do livro (
  Exemplo abaixo ).  
  `Procurar aluno com id 123A456B78 = /aluno/delete/11`  
  `Body de retorno:`

``` Json
[
    {
        "aluno__RA": "9876543210",
        "livros__id__Livros": 11
    },    {
        "aluno__RA": "0123456789",
        "livros__id__Livros": 11
    }
]
```

***

- `GET` `/emprestimo/findemprestimobyaluno/{RA}`: Retorna um body com uma lista contendo todos os emprestimos com o RA
  do Aluno (
  Exemplo abaixo ).  
  `Procurar aluno com id 123A456B78 = /aluno/delete/0123456789`  
  `Body de retorno:`

``` Json
[
    {
        "aluno__RA": "0123456789",
        "livros__id__Livros": 11
    },
        {
        "aluno__RA": "0123456789",
        "livros__id__Livros": 14
    }
]
```

***

- `GET` `/emprestimo/findall`: Retorna um body com uma lista contendo todos os emprestimos no banco de dados (
  Exemplo abaixo ).  
  `Procurar aluno com id 123A456B78 = /aluno/delete/123A456B78`  
  `Body de retorno:`

``` Json
[
    {
        "aluno__RA": "9876543210",
        "livros__id__Livros": 11
    },
        {
        "aluno__RA": "9876543210",
        "livros__id__Livros": 12
    },
    {
        "aluno__RA": "0123456789",
        "livros__id__Livros": 11
    },
        {
        "aluno__RA": "0123456789",
        "livros__id__Livros": 14
    }
]
```

# Banco de Dados

> [!TIP]
> No diretório `./mySQL` Contem arquivos úteis, como o arquivo sql para criação do banco, o schema para futura edição e uma imagem do banco para melhor interpretação.

Foi utilizado o MySQL como banco de dados devido ao seu desempenho, escalabilidade e ampla adoção no mercado,
facilitando futuras implementações colaborativas.

# Como Executar

**Pré-requisitos:**

- JDK instalado (versão 8 ou superior)
- Maven instalado
- Terminal de comandos

**Clonar o Repositório:**

```sh
git clone https://github.com/pedroHenrique57/ProjetoBiblioteca.git
```

## Configurar o Banco de Dados

Configure as propriedades do banco de dados no arquivo `application.properties`.

## Compilar e Executar o Projeto

> [!WARNING]
> Dentro de um terminal, verifique se você está no diretório do projeto `./biblioteca` para rodar o comando.  
> caso esteja com dúvida verifique se existe um arquivo nomeado `Pom.xml` no diretório.

Navegue até o diretório do projeto e abra um terminal. Neste terminal execute o seguinte comando:

```sh
mvn spring-boot:run
```

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias e correções.

## Licença

Este projeto está licenciado sob a licença MIT. Acesse o arquivo `LICENSE` para mais informações.
