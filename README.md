# Spring MVC com Angular 6

Crud simples utilizando Spring MVC, Maven, MySQL Server versao 5, Angular 6, Materialize e VisJS.

Os dados e o DDL se encontram no arquivo: usuario_DDL.sql

� necess�rio mudar o nome e a senha do banco nos arquivos das pastas que est�o em "src/main/resources/..."

Para baixar as dependencias do projeto, va ate a pasta do projeto no terminal e digite: 

 - mvn clean install	#baixa as dependencias
 - mvn eclipse:eclipse -Dwtpversion=2.0		#para abrir no eclipse
 - mvn test -Ptest 		#rodar os tests 
 
 
Ao rodar a aplicacao, basta ir em http://localhost:8080/timelinecrud/ no seu navegador.


Usuarios para logar:
	email: jose@email.com	senha: 1234
	email: maria@email.com	senha: 12345
	
		
Se der erro na conexao com o BD certifique-se de sua versão do MySQL, 
pois ha problemas de compatibilidade com a nova.


O codigo do Front-end do projeto esta em https://github.com/Veronicka/Timeline-CRUD-Front