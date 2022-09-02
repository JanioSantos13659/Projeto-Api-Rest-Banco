# Banco Inovar
Projeto API REST - funções essenciais relacionadas ao gerenciamento de contas bancárias.

## Informações Projeto
* Project: Maven Project
* Language Java
* Versão 2.7.1
* Group: br.com.banco
* Artifact: banco
* Dependencies: Web

## Importação de Projeto 
* Eclipse: Import / Existing Maven Projects
* IntelliJ IDEA: Import / Existing Maven Projects

## Para rodar o projet
* Na classe Main BancoApplication.java :  Run As > Java Application

## Documentação
* API REST: outros desenvolvedores vão construir outras aplicações para consumir sua API
* Disponibilizar endereço da API, os recursos, os métodos suportados
* Swagger: ferramenta que automatiza a leitura dessa API e a geração de uma documentação
* [swagger-ui](http://localhost:9795/swagger-ui/index.html) website gerado que explica como funciona a API, recursos, endereços, e até fazer testes diretamente para API
* SpringFox: biblioteca que documenta API REST utilizando o Swagger. Incluir essa dependencia no pom.xml
* springfox-swagger-ui: dependência que disponibiliza a documentação gerada automaticamente através de um site.
* @EnableSwagger2: habilitação da geração de documentação no ForumApplication
* SwaggerConfigurations: classe para configurar o swagger no seu projeto
* Com Spring security configurado, liberar o endereço do Swagger para evitar o 403
 
