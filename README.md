<p align="center">
  <a href="http://www.catho.com.br">
      <img src="http://static.catho.com.br/svg/site/logoCathoB2c.svg" alt="Catho"/>
  </a>
</p>
# backend-test

Uma pessoa esta a procura de emprego e dentre as várias vagas que existem no mercado (disponibilizadas nesse <a href="https://github.com/catho/backend-test/blob/master/vagas.json">JSON</a>) e ela quer encontrar vagas que estejam de acordo com o que ela saiba fazer, seja direto pelo cargo ou atribuições que podem ser encontradas na descrição das vagas. Para atender essa necessidade precisamos:

- uma API simples p/ procurar vagas (um GET p/ procurar as vagas no .json disponibilizado);
- deve ser possível procurar vagas por texto (no atributos title e description);
- deve ser possível procurar vagas por uma cidade;
- deve ser possível ordenar o resultado pelo salário (asc e desc);

O teste deve ser feito utilizando PHP (com ou sem framework, a escolha é sua). Esperamos como retorno, fora o GET da API funcionando, os seguintes itens:

- uma explicação do que é necessário para fazer seu projeto funcionar;
- como executar os testes, se forem testes de unidade melhor ainda;
- comentários nos códigos para nos explicar o que está sendo feito.

Lembre-se que na hora da avaliação olharemos para:

- organização de código;
- desempenho;
- manutenabilidade.

# Alessnadro Vieira Grammelsbacher

O projeto foi desenvolvido em Java, foi criado uma API Rest para realizar a busca no JSON e filtrar / ordenar a lista de vagas.

- <b> Utiliza��o: </b>

Para fazer a utiliza��o da API, realize o deploy do WAR, contido em /compilado em um Apache TOMCAT 8. <<Colocar URL para passo a passo>>
Inicie o servi�o do TOMCAT e a utiliza��o da API se dar� atrav�s da URL: http://localhost:8080/backend-test/api/vagas, para um exemplo de front-end, utilize a URL: http://localhost:8080/backend-test, o front-end foi utilizado um template Bootstrap chamado ADMIN LTE, como o objetivo era a visualiza��o do BackEnd, utilizei um template pronto apenas para mostrar como pode ser utilizada a API.

 - <b> API </b>
 
A API Rest pode ser utilizada atrav�s do endere�o: 
S�o esperados as seguintes Queries Strings: filtro, cidade e salario, detralhadas abaixo

- <i>Filtro:</i> Texto com as informa��es que ir�o filtrar a lista nos campos Descri��o e T�tulo das vagas

- <i>Cidade:</i> Texto que ser� aplicado na lista de cidades

- <i>Sal�rio: </i> Expera o texto: DESC ou CRES para ordena��o por sal�rio: Desc para Decrescente ou CRES para Crescente.

- <b> Arquivo JSON </b>

O Arquivo JSON dever� ficar na pasta: C:/Catho/json/vagas.json, para alterar o caminho ou arquivo, realize a altera��o no arquivo Global.java

#Lista de Depend�ncias

guava: Biblioteca para auxiliar no filtro das listas;
gson: Biblioteca para auxiliar na utiliza��o do JSON
jersey-bundle: Biblioteca para cria��o do servidor REST
jackson-databind: Biblioteca utilizada para mapemento entre objeto JSON e Java

rest-assured: Biblioteca do framework rest-assured;
json-path: Biblioteca respons�vel por ler as respostas das mensagens retornadas pela API;
json-schema-validator: Biblioteca respons�vel por validar se a estrutura da resposta est� correta;
junit: Biblioteca que auxilia na escrita de testes automatizados.