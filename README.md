# testBank

Para executar o projeto é necessário: java 17, banco de dados SQL SERVER, ajuste das propriedades em application-local.yml.

O scrpit de criação do banco de dados encontra-se em src/main/resources/SQL/testBank.sql. Caso seja necessária a recriação das tabelas altere a propriedade spring.jpa.hibernate.ddl-auto de <b>update</b> para <b>create-drop</b>,
 dessa forma as tabelas serão recriadas sempre a a aplicação iniciar.

# application-local.yml
É necessário configurar as propriedades: DB_PASSWORD e DB_USER de acordo com a configuração local do SQL SERVER.
