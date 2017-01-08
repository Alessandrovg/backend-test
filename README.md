<p align="center">
  <a href="http://www.catho.com.br">
      <img src="http://static.catho.com.br/svg/site/logoCathoB2c.svg" alt="Catho"/>
  </a>
</p>
# backend-test

Uma pessoa esta a procura de emprego e dentre as v√°rias vagas que existem no mercado (disponibilizadas nesse <a href="https://github.com/catho/backend-test/blob/master/vagas.json">JSON</a>) e ela quer encontrar vagas que estejam de acordo com o que ela saiba fazer, seja direto pelo cargo ou atribui√ß√µes que podem ser encontradas na descri√ß√£o das vagas. Para atender essa necessidade precisamos:

- uma API simples p/ procurar vagas (um GET p/ procurar as vagas no .json disponibilizado);
- deve ser poss√≠vel procurar vagas por texto (no atributos title e description);
- deve ser poss√≠vel procurar vagas por uma cidade;
- deve ser poss√≠vel ordenar o resultado pelo sal√°rio (asc e desc);

O teste deve ser feito utilizando PHP (com ou sem framework, a escolha √© sua). Esperamos como retorno, fora o GET da API funcionando, os seguintes itens:

- uma explica√ß√£o do que √© necess√°rio para fazer seu projeto funcionar;
- como executar os testes, se forem testes de unidade melhor ainda;
- coment√°rios nos c√≥digos para nos explicar o que est√° sendo feito.

Lembre-se que na hora da avalia√ß√£o olharemos para:

- organiza√ß√£o de c√≥digo;
- desempenho;
- manutenabilidade.

# Alessnadro Vieira Grammelsbacher

O projeto foi desenvolvido em Java, foi criado uma API Rest para realizar a busca no JSON e filtrar / ordenar a lista de vagas.

- <b> UtilizaÁ„o: </b>

Para fazer a utilizaÁ„o da API, realize o deploy do WAR, contido em /compilado em um Apache TOMCAT 8. <<Colocar URL para passo a passo>>
Inicie o serviÁo do TOMCAT e a utilizaÁ„o da API se dar· atravÈs da URL: http://localhost:8080/backend-test/api/vagas, para um exemplo de front-end, utilize a URL: http://localhost:8080/backend-test, o front-end foi utilizado um template Bootstrap chamado ADMIN LTE, como o objetivo era a visualizaÁ„o do BackEnd, utilizei um template pronto apenas para mostrar como pode ser utilizada a API.

 - <b> API </b>
 
A API Rest pode ser utilizada atravÈs do endereÁo: 
S„o esperados as seguintes Queries Strings: filtro, cidade e salario, detralhadas abaixo

- <i>Filtro:</i> Texto com as informaÁıes que ir„o filtrar a lista nos campos DescriÁ„o e TÌtulo das vagas

- <i>Cidade:</i> Texto que ser· aplicado na lista de cidades

- <i>Sal·rio: </i> Expera o texto: DESC ou CRES para ordenaÁ„o por sal·rio: Desc para Decrescente ou CRES para Crescente.

- <b> Arquivo JSON </b>

O Arquivo JSON dever· ficar na pasta: C:/Catho/json/vagas.json, para alterar o caminho ou arquivo, realize a alteraÁ„o no arquivo Global.java

