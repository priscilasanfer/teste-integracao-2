# Testes de Integração: Testes de SQL e DAOs automatizados em Java

## 01. O que são testes de integração

Vimos que os testes de integração, idealmente, deveriam ser escritos em menor proporção do que os testes de unidade.
Quais as motivações para isso?
- O tempo maior para execução.
  Testes de integração tem um tempo de execução maior do que os testes de unidade.
- O custo maior para manutenção.
  Testes de integração costumam ser mais difíceis de escrever e manter, por conta da complexidade maior.
  
A pirâmide de testes é um estudo que demonstra os diferentes tipos de testes automatizados e suas vantagens e desvantagens.
Voce pode acessar um excelente artigo que demonstra tal estudo neste [link](https://martinfowler.com/articles/practical-test-pyramid.html)

Resumo:
- Os diferentes tipos de testes automatizados que podemos escrever em uma aplicação;
- A pirâmide de testes, de maneira bem resumida;
- A configurar o projeto que será utilizado neste treinamento.


## 02. Preparando o projeto para os testes

Hoje em dia é muito comum a utilização de frameworks que realizam injeção de dependências nas classes.
Do ponto de vista dos testes automatizados, qual cuidado devemos ter ao utilizar tal recurso em uma aplicação?
- Sempre que possível utilizar injeção de dependências via construtor
  Utilizar o construtor de uma classe para receber suas dependências favorece bastante a escrita de testes automatizados.

Por que não é uma boa prática utilizar a mesma base de dados da aplicação nos testes de integração?
- Os dados da aplicação podem influenciar nos testes, fazendo com que eles falhem
  O ideal é sempre utilizar outra base de dados separada, exclusiva para a execução dos testes.

Resumo:
- Que às vezes precisamos adaptar o nosso código para poder escrever os teste automatizados;
- Que devemos preferir injeção de dependências via construtor, para facilitar na escrita dos testes automatizados;
- A realizar as configurações da JPA para a execução dos testes de integração.


## 03. Organização do código de teste

Por que é importante organizar os códigos de testes, seguindo boas práticas e padrões de projeto?
- Para facilitar a manutenção
  O código de teste também vai precisar de manutenção, portanto é importante que ele seja fácil de manter.
  
Resumo:
- A escrever outros cenários de testes;
- A como utilizar os recursos do JUnit para organizar o código de testes;
- A importância de manter o código de testes bem organizado e fácil de manter.


## 04. Testando métodos de escrita

Por que nos métodos de escrita precisamos iniciar uma transação?
- Para que a JPA pudesse sincronizar as escritas com o banco de dados
  Alguns métodos, como os que fazem insert, update e delete, vão exigir uma transação ativa.

Discutimos na última aula que alguns métodos, como os que fazem delete, insert e update, não são recomendados de serem testados.
Por qual motivo não deveríamos testar tais métodos?
- Para evitar testes redundantes
  Quando tais métodos apenas delegam para a JPA, sem possuir nenhum tipo de lógica, os testes se tornam redundantes, uma vez que estávamos testando a JPA em si e não a aplicação.
  
Resumo:
- A escrever testes de métodos de escrita no banco de dados;
- A lidar com transação na escrita dos testes;
- A como identificar e evitar escrever testes desnecessários.


## 05. Test Data Builder

Vimos como criar e utilizar uma classe que segue o padrão Teste Data Builder.
Quais as vantagens de se utilizar tal padrão na escrita dos testes automatizados?
- Melhorar a legibilidade do código de teste
  Um Test Data Builder torna o código de teste muito mais legível.
  
- Evitar códigos duplicados
  Podemos reaproveitar os Test Data Builder em diferentes classes de testes, evitando assim a duplicação de código.

Resumo:
- A identificar os problemas de códigos duplicados nas classes de testes;
- O padrão Test Data Builder;
- Como implementar um Test Data Builder.

