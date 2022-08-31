Banco Invovar
Projeto do Relacões Bancarias - Api Rest Java

Passos para a criação do projeto

Gerador do Projeto - Spring Initializer

Projeto: Projeto Maven

Linguagem Java

Versão 2.1.6

Grupo: br.com.alura


Artefato: fórum

Dependências: Web
Gerar projeto (zip)
Descompactar zip
Eclipse: Importar/Projetos Maven Existentes
Para rodar o projeto
Na classe Main ForumApplication.java : Run As > Java Application
Página do projeto ( http://localhost:8080/ )
Dependência Devtools
Permitir reinicialização automática do servidor sem necessidade de reinicialização ao salvar as mudanças

Padrão DTO
Usando JPA, não se deve retornar todos os atributos de um,a entidade JPA. Com DTO, você escolhe exatamente os atributos da classe que você deseja retornar na resposta

DESCANSO
Transferência de Estado Representacional
Modelo de Arquitetura para sistemas distribuídos
Utiliza o protocolo HTTP
Evolução do modelo SOAP (xml)
cursos: o que a aplicação gerencia - alunos, respostas, respostas,
URI: identificação única dos recursos: /alunos, /topicos, /respostas
Verbos: manipulação dos recursos: GET /alunos POST /alunos PUT /alunos{id}
Representação dos recursos : media type : XML, JSON
Stateless: não tenha guarda sessão - não armazena dados dos usuários p/ que o protocolo escalabilidade
Repositório Padrão
Substituição do padrão ADO. Não prcisa criar métodos CRUD isolados em classes xxxxADO
criar uma interface que extender JpaRepository<T,> e injetar na classe q vc quer usar
Passando filtros
com Spring Data, use o padrão de nomenclatura findByAtributo(Tipo Atributo) como método na interface Repository que o Spring ja cria o JPQL necessário p/ filtrar
na url, filtrar com http://localhost:8080/topicos?nomeCurso=Spring+Boot
se o valor possui espaço em branco, use + no lugar do espaço
Salvando dados na API
Utilizar como padrão no lugar do padrão DTO ou da própria entidade
Para trabalhar com JPA, use sempre o construtor padrão. Mas você pode criar novos construtores de necessário.
Use @PostMapping no lugar de @RequestMapping - que agora será anotado na classe
Use @RequestBody nos parâmetros do método de cadastro para indicar ao Spring que os dados estão vindo do corpo da requisição
Códigos HTTP
200 - OK genérico
201 - OK: novo recurso criado com sucesso no servidor. Retornar URI e representação criada.
404 não encontrado
400 - Bad Request: na URI,não passado valores para todos os parâmetros obrigatórios, por exemplo.
403 - Proibido: sem autorização p/ acessar o endpoint
Carteiro
Navegador GET para o servidor na barra de armas só
Para testar POST : use o app POSTMAN do Chrome ![Post] Imgur
Validação do Bean
Especificação p/ validar pedidos
Incluir Nos atributos da classe que deseja validar
@Não nulo
@Não está vazio
@Length(min=5)
@Valid : Nenhum método do controlador que recebe uma requisição, coloca uma anotação no parâmetro para que o Spring seja chamado e utilize o bean Validation de acordo com as anotações dos atributos
Detalhes dos tópicos
GetMapping("{/id}") passando registro específico do q uma lista inteira
@PathVariable : o id vem da url do request e passado como parametro do metodo do controlador.
Atualizando Recursos
@PutMapping("/{id}")
Utilizar DTO p/formular específico os campos q são permitidos com alteração de classe
Excluindo recursos
@DeleteMapping("/{id}")
Não deve o recurso exclusivo, apenas o retornar 200.


Segurança
Com REST, o ideal é usar autenticação Stateless: servidor não guarda sessão (espaço de memória) p/ cada usuário logado e autenticado com cookies.
A aplicação cliente deve ter uma página de login, que faz uma chamada ao endpoint de autenticação da API.
Autenticação Stateless: tokens JWT (Json Web Token)
O Bearer é um dos mecanismos de autenticação utilizados no protocolo HTTP como o Basic e o Digest.
Monitoramento
A equipe de operações da TI pode a aplicação se ela esta online, se caiu ou se esta apresentando erros, por exemplo
Utilizar o Spring Boot Actuator
Documentação
API REST: outros desenvolvedores vão construir outras aplicações para consumir sua API
Disponibilizar endereço da API, os recursos, os métodos suportados
Swagger: ferramenta que automatiza a essa API e a geração de uma leitura
swagger-ui website gerou que explica funciona a API, recursos, recursos, até fazer testes diretamente para API
SpringFox: biblioteca que documenta API REST usando o Swagger. Incluir essa dependência no pom.xml
springfox-swaggerui: dependência que disponibiliza a documentação feita automaticamente através de um site.
@EnableSwagger2: habilitação da geração de documentação no ForumApplication
SwaggerConfigurations: classe para configurar o swagger no seu projeto
Com Spring security configurado, liberar o endereço do Swagger para evitar o 403
