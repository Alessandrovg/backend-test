<p align="center">
  <a href="http://www.catho.com.br">
      <img src="http://static.catho.com.br/svg/site/logoCathoB2c.svg" alt="Catho"/>
  </a>
</p>
# backend-test

Uma pessoa esta a procura de emprego e dentre as vÃ¡rias vagas que existem no mercado (disponibilizadas nesse <a href="https://github.com/catho/backend-test/blob/master/vagas.json">JSON</a>) e ela quer encontrar vagas que estejam de acordo com o que ela saiba fazer, seja direto pelo cargo ou atribuiÃ§Ãµes que podem ser encontradas na descriÃ§Ã£o das vagas. Para atender essa necessidade precisamos:

- uma API simples p/ procurar vagas (um GET p/ procurar as vagas no .json disponibilizado);
- deve ser possÃ­vel procurar vagas por texto (no atributos title e description);
- deve ser possÃ­vel procurar vagas por uma cidade;
- deve ser possÃ­vel ordenar o resultado pelo salÃ¡rio (asc e desc);

O teste deve ser feito utilizando PHP (com ou sem framework, a escolha Ã© sua). Esperamos como retorno, fora o GET da API funcionando, os seguintes itens:

- uma explicaÃ§Ã£o do que Ã© necessÃ¡rio para fazer seu projeto funcionar;
- como executar os testes, se forem testes de unidade melhor ainda;
- comentÃ¡rios nos cÃ³digos para nos explicar o que estÃ¡ sendo feito.

Lembre-se que na hora da avaliaÃ§Ã£o olharemos para:

- organizaÃ§Ã£o de cÃ³digo;
- desempenho;
- manutenabilidade.

# Alessnadro Vieira Grammelsbacher

O projeto foi desenvolvido em Java, foi criado uma API Rest para realizar a busca no JSON e filtrar / ordenar a lista de vagas.

- <b> Utilização: </b>

Para fazer a utilização da API, realize o deploy do WAR, contido em /compilado em um Apache TOMCAT 8. <<Colocar URL para passo a passo>>
Inicie o serviço do TOMCAT e a utilização da API se dará através da URL: http://localhost:8080/backend-test/api/vagas, para um exemplo de front-end, utilize a URL: http://localhost:8080/backend-test, o front-end foi utilizado um template Bootstrap chamado ADMIN LTE, como o objetivo era a visualização do BackEnd, utilizei um template pronto apenas para mostrar como pode ser utilizada a API.

 - <b> API </b>
 
A API Rest pode ser utilizada através do endereço: 
São esperados as seguintes Queries Strings: filtro, cidade e salario, detralhadas abaixo

- <i>Filtro:</i> Texto com as informações que irão filtrar a lista nos campos Descrição e Título das vagas

- <i>Cidade:</i> Texto que será aplicado na lista de cidades

- <i>Salário: </i> Expera o texto: DESC ou CRES para ordenação por salário: Desc para Decrescente ou CRES para Crescente.

- <b> Arquivo JSON </b>

O Arquivo JSON deverá ficar na pasta: C:/Catho/json/vagas.json, para alterar o caminho ou arquivo, realize a alteração no arquivo Global.java

#Lista de Dependências

guava: Biblioteca para auxiliar no filtro das listas;
gson: Biblioteca para auxiliar na utilização do JSON
jersey-bundle: Biblioteca para criação do servidor REST
jackson-databind: Biblioteca utilizada para mapemento entre objeto JSON e Java

rest-assured: Biblioteca do framework rest-assured;
json-path: Biblioteca responsável por ler as respostas das mensagens retornadas pela API;
json-schema-validator: Biblioteca responsável por validar se a estrutura da resposta está correta;
junit: Biblioteca que auxilia na escrita de testes automatizados.