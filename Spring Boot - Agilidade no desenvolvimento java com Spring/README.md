--------------------------------------------------------------------------
<h1>Se��o 01 - Criando nossa primeira aplica��o com o Spring Boot</h1>

<h2>Introdu��o</h2>
Seja bem-vindo ao curso de Spring Boot, em que aprenderemos bastante sobre este projeto.

Para um melhor aproveitamento do conte�do, � preciso que voc� j� tenha conhecimentos sobre Spring IOC - o core do Spring -, Maven e JPA.


Durante o curso, migraremos uma aplica��o antiga constru�da com Servlets e JDBC para uma aplica��o nova, usando Spring Boot e todos os seus starters. Geraremos at� o fim do curso, o Fatjar, ou seja, a aplica��o inteira em um �nico JAR.

<h2>Criando nossa aplica��o com Spring Boot</h2>



Somos parte da equipe de desenvolvimento da Alura e o cliente quer que n�s migremos sua aplica��o que foi criada com Servlet e JDBC. Trata-se de uma lista de convidados em que o cliente pode adicionar pessoas � listagem e convid�-las, que chamaremos de ListaVIPs.

lista vip - p�gina inicial

Logo ao clicar no bot�o para ver a lista de convidados, somos levados a uma outra p�gina onde vemos a listagem dos convidados e um formul�rio para adicionar mais convidados a lista.

listagem convidados e formulario

Como vemos, � uma aplica��o bem simples, que permite adicionar convidados a uma lista e notifica estes convidados por email.

Para criar uma aplica��o da forma mais r�pida poss�vel, precisamos de uma ferramenta que nos auxilie. Onde a gente n�o precise perder tempo configurando um servidor ou framework ORM, o que pode demorar horas. Por isso escolhemos o Spring Boot.

O Spring Boot n�o tem uma tarefa espec�fica. Este � composto por starters onde, de acordo com a necessidade, adiciona-se ao projeto o starter necess�rio para atender determinado objetivo.

Para come�armos a criar nossa aplica��o, iniciaremos um novo projeto Maven, simples, adicionando apenas o nome do projeto e o pacote.

iniciando projeto maven

Lembre-se de marcar a op��o "create a simple project"(criar um projeto simples", traduzido) e ap�s isso siga para o pr�ximo passo.

configurando id do projeto

Preencha os campos Group Id e Artifact Id com o pacote do projeto (br.com.alura.listavip) e o nome do mesmo listavip respectivamente.

Ap�s isso, devemos abrir o arquivo pom.xml e adicionar as depend�ncias do projeto. Que por hora, � apenas o Spring Boot.

O Spring Boot durante a grava��o deste curso est� em sua vers�o 1.3.6 RELEASE. Sinta-se a vontade para usar uma vers�o mais recente. Em caso de d�vidas, recorra ao nosso f�rum.

A depend�ncia do Spring Boot pode ser encontrada no pr�prio site em projects.spring.io/spring-boot. Com ela o pom.xml deve ficar parecido com o c�digo abaixo.

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>br.com.alura.listavip</groupId>
    <artifactId>listavip</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>1.4.1.RELEASE</version>
        </dependency>
    </dependencies>

</project>
Ap�s isso, devemos esperar um pouco at� que o Maven baixe todas as depend�ncias do Spring Boot.


<h2>Subindo nossa aplica��o web</h2>
Com o Spring Boot j� instalado em nossas depend�ncias, precisamos configurar a aplica��o. Sendo esta uma aplica��o web, precisaremos de um container que a execute, sendo este o Tomcat, Jetty, Wildfly ou qualquer um.

A vantagem de usar Spring Boot � que n�o precisamos mais nos preocupar com a instala��o e configura��o do projeto em um destes containers. Precisamos apenas configurar o Spring Boot para que inicie um container automaticamente e gerencie todos os nossos Beans. Faremos isso por meio da classes Java.

At� um tempo atr�s, as configura��es n�o eram feitas usando as classes Java, mas sim por arquivos XML, o que n�o � mais necess�rio hoje. O �nico XML da nossa aplica��o ser� o de depend�ncias do Maven.

Criaremos ent�o a classe Configuracao que ir� configurar o Spring em nosso projeto. Esta ser� criada dentro do pacote br.com.alura.listavip.

package br.com.alura.listavip;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Configuracao {

}
Note a presen�a da anota��o @SpringBootApplication, ela � a respons�vel por configurar nossa aplica��o Spring. Ela � o resultado de um aglomerado de outras configura��es, como por exemplo, o diret�rio onde o Spring deve procurar todos os Beans da aplica��o, entre outras configura��es.

Agora temos nossa aplica��o inicial pronta e j� podemos execut�-la. Mas como podemos executar uma aplica��o Java com uma classe praticamente em branco? N�o podemos! Toda e qualquer aplica��o b�sica com Java precisa do m�todo main. Criaremos um ent�o.

Dentro do m�todo main, usaremos uma classe do Spring Boot para que este execute todas as configura��es da nossa aplica��o e a deixe dispon�vel para podermos acess�-la, que receber� o nome de SpringApplication. Ela ter� o m�todo run, respons�vel por executar a classe de configura��o da aplica��o. Vejamos:

public static void main(String[] args){
    SpringApplication.run(Configuracao.class, args);
}
Como estamos na pr�pria classe de configura��o, passamos apenas o nome da classe. E como n�o temos nenhum par�metro adicional para estas configura��es, usamos apenas o args recebido pelo m�todo main. Assim, j� podemos executar nossa aplica��o. Execute-a como uma aplica��o Java normal.

executando a aplicacao

Logo veremos algumas informa��es sendo impressas no console.

informacoes no console

E ent�o, podemos acessar nossa aplica��o no navegador.

aplicacao funcionando no navegador

Mas convenhamos que mostrar uma p�gina de erro logo no in�cio da aplica��o n�o � uma boa ideia para mostrar para o chefe ou amigo.

Para exibirmos uma mensagem mais interessante, transformaremos nossa classe de configura��o em um Controller, e mapearemos o endere�o / para um m�todo que retornar� uma String com uma mensagem de ol�.

@SpringBootApplication
@Controller
public class Configuracao {

    @RequestMapping("/")
    @ResponseBody
    public String ola(){
        return "Ola, Bem vindo ao sistema Lista VIPs";
    }

    public static void main(String[] args){
        SpringApplication.run(Configuracao.class, args);
    }

}
As anota��es @Controller, @ResponseBody, @RequestMapping, s�o espec�ficas do Spring MVC. Caso n�o tenha conhecimentos sobre o framework, recomendamos que fa�a estes cursos:

Spring MVC I

Spring MVC II.

Ao iniciarmos a aplica��o novamente, teremos.

Mensagem de bem-vindo

Lembre-se de sempre separar seus controllers em outras classes. Neste exemplo, apenas usamos a classe de configura��o para demonstra��o da praticidade de trabalhar com o Spring Boot.

<h2>Resumo da aula</h2>
O que fizemos nesta aula foi ver como podemos iniciar rapidamente um projeto web com o Spring Boot. Fazendo isto, apenas adicionamos uma depend�ncia no arquivo pom.xmle criando apenas uma classe que chamamos de Configuracao onde, com algumas linhas de c�digo, conseguimos iniciar e visualizar a aplica��o funcionando.

<h2>Defini��o do Spring Boot</h2>
A gente criou nossa aplica��o usando o Spring Boot, mas qual � a melhor defini��o para descrever esse framework?
R:Agilizar no desenvolvimento de aplica��es com configura��es default/padr�o.
Tendo isso em mente, o Spring Boot junta v�rios starters para facilitar as diversas tarefas da nossa aplica��o, como configurar o ambiente, configurar acesso ao banco de dados, oferecer um cont�iner web para agilizar o desenvolvimento entre outras vantagens.

-------------------------------------------------------------------------------------------------
<h1>Se��o 02 - Inicio da migra��o e Integra��o do Spring Boot com a JPA</h1>

Na aplica��o entregue pelo cliente, as p�ginas s�o criadas com JSP padr�o. Mas como estamos utilizando Spring Boot com o starter web que nos disponibiliza o Spring MVC, utilizaremos outra engine de templates. Uma do pr�prio Spring, chamada Thymeleaf.

Iniciaremos a cria��o da nossa primeira p�gina criando uma nova pasta dentro da pasta resources, e chamaremos esta detemplates. Dentro desta, criaremos um arquivo HTML simples com uma mensagem de bem vindo.

criando pasta templates

O arquivo HTML se chamar� index.html e ter� o seguinte c�digo.

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h1>Bem-vindo ao sistema Lista VIPs</h1>
</body>
</html>
O pr�ximo passo ser� remover o c�digo presente na classe de configura��o que trata a requisi��o para uma outra classe de controller, visto que, a classe de configura��o deve conter c�digo apenas de configura��o.

Criaremos uma classe chamada ConvidadoController e nesta criaremos um m�todo chamado index que mapear� a requisi��o em / e retornar� como String o nome do template que criamos, o index.html. Assim teremos.

@Controller
public class ConvidadoController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
Esta classe deve estar no mesmo pacote da classe de configura��o.

Note que retornamos apenas o nome do template, sem a extens�o do arquivo. Isto por que o engine de template far� as associa��es. Se iniciarmos a aplica��o agora, teremos a mesma tela de erro que tivemos quando iniciamos o projeto. Isto por que n�o adicionamos o engine de templates na nossa aplica��o. No arquivo pom.xml, teremos ent�o que adicionar a depend�ncia do thymeleaf starter.

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
    <version>1.4.1.RELEASE</version>
</dependency>
A vers�o utilizada no v�deo � a 1.3.6, por�m, voc� pode utilizar a vers�o mais recente sem problema algum.

Por �ltimo, resolveremos alguns problemas do nosso template que por enquanto est� muito simples, sem nenhum estilo. O HTML da aplica��o antiga, que estamos migrando tinha o seguinte HTML em sua index.

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ListaVIP</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="jumbotron" align="center" style="margin-top: 50px;">
            <h1>Seja bem vindo ao ListaVIPs</h1>
            <div align="center">
                <a href="listavip" class="btn btn-lg btn-primary">Clique aqui para ver a lista de convidados</a>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
O primeiro ponto a ser observado � que ele usa o Bootstrap. O segundo ponto � que a engine que adicionamos no nosso projeto � bem detalhista. Teremos erros por exemplo, se esquecermos de fechar alguma tag. Por isso cuidado. Sempre feche todas as tags HTML.

Para a adi��o dos arquivos est�ticos do Bootstrap, criaremos uma nova pasta chamada static, dentro da pasta resources. Baixaremos o Bootstrap em getbootstrap.com e o descompactaremos nesta pasta que criamos.

Copiaremos o c�digo do antigo index, fecharemos as tags corretamente e o colaremos no lugar do index atual. Que ter� ao final, o seguinte c�digo.

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>ListaVIP</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
    <div class="container">
        <div class="jumbotron" align="center" style="margin-top: 50px;">
            <h1>Seja bem-vindo ao ListaVIPs</h1>
            <div align="center">
                <a href="listavip" class="btn btn-lg btn-primary">Clique aqui para ver a lista de convidados</a>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
Agora, ao iniciarmos a aplica��o, teremos uma p�gina de bem-vindo mais agrad�vel.

pagina de bem vindo

Observa��es: Muito do que vimos at� agora, est� dentro de um conceito muito comum presente nos frameworks mais modernos que � a Conven��o sobre a Configura��o. Antes precisar�amos configurar uma s�rie de recursos para ter a aplica��o funcionando. Agora apenas seguindo algumas conven��es, pulamos todas as configura��es e apenas focamos no que � importante.

Das conven��es que vimos at� aqui temos: Os templates das p�ginas s�o guardados na pasta templates dentro de resources e tamb�m a conven��o de onde armazenar os arquivos est�ticos (css, js, imagens, etc.) que ficam dentro da pasta static.


<h2>Configurando Spring Boot Data JPA</h2>

Se pensarmos em como a aplica��o antiga funcionava, recordaremos que nela havia uma p�gina onde existia uma listagem dos convidados e um formul�rio que nos permitia adicionar novos convidados � lista. O c�digo da listagem era semelhante ao que est� abaixo.

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>ListaVIP</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div id="listaDeConvidados">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Nome</th>
                    </tr>
                </thead>
                <c:forEach var="convidado" items="${convidados}">
                    <tr>
                        <td>${convidado.nome}</td>
                        <td>${convidado.email}</td>
                        <td>${convidado.telefone}</td>
                     </tr>
                </c:forEach>
            </table>
        </div>
        <hr>
        <form action="convidado">
            <div class="form-group">
                <label for="nome">Nome</label> <input type="text"
                    class="form-control" id="nome" name="nome" placeholder="Nome">
            </div>
            <div class="form-group">
                <label for="email">Email</label> <input type="email"
                    class="form-control" id="email" name="email" placeholder="Email">
            </div>
            <div class="form-group">
                <label for="telefone">Telefone</label> <input
                    type="text" class="form-control" id="telefone" name="telefone" placeholder="Telefone">
            </div>
            <button type="submit" class="btn btn-success">Convidar</button>
        </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
Havia uma tabela, onde atrav�s do forEach, percorria-se uma lista de convidados e imprimia-se, seu nome, email e telefone. Esta ent�o ser� a segunda parte da nossa migra��o.

Come�aremos criando uma p�gina simples de teste, a fim de verificar que tudo est� funcionando normalmente. Criaremos mais um arquivo na pasta de templates chamada listaconvidados.html e nesta apenas adicionaremos o seguinte c�digo.

Criando listaconvidados.html

criando pagina listaconvidados

C�digo presente no listaconvidados.html

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>insert title here</title>
</head>
<body>
    <h1>Lista de Convidados</h1>
</body>
</html>
E por �ltimo, precisamos mapear a rota /listaconvidados para este template. Na classe ConvidadoController ent�o, criaremos um novo m�todo chamado listaConvidados que apenas retorna o nome do template da seguinte forma.

@RequestMapping("listaconvidados")
public String listaConvidados(){
    return "listaconvidados";
}
Ent�o, ao acessarmos localhost:8080/listaconvidados, teremos nossa p�gina sendo exibida corretamente.

pagina de listagem com mensagem

Mas se lembrarmos bem, a lista de convidados est� salva no banco de dados e n�o temos acesso ao banco de dados ainda. Se fizermos um selec no banco de dados, teremos os seguintes resultados.

convidados no banco de dados

A imagem anterior mostra como o MySQL Workbench apresenta os dados. Use a aplica��o de acesso ao banco de dados que se sentir mais confort�vel. Caso n�o tenha conhecimentos de SQL, recomendamos tamb�m qee fa�a nossos cursos de MySQL I e MySQL II

Para a configura��o do banco de dados, vamos utilizar mais um starter, esta chamado de Spring Boot Data JPA Starter, que configura todas as depend�ncias com Hibernate e JPA. Antes precis�vamos configurar tudo isso via XML, mas n�o precisamos mais disso. Adicionaremos as seguinte depend�ncias ao pom.xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <version>1.4.2.RELEASE</version>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.40</version>
</dependency>
A primeira para o starter da JPA, e a segunda do conector do MySQL. Agora precisamos configurar o acesso ao banco de dados, ou seja, definir o caminho para o banco, o usu�rio e a senha.

Na classe Configuracao.java, adicionaremos um novo m�todo respons�vel por criar o DataSource de conex�o ao banco, o anotaremos com @Bean para que este possa ser gerenciado pelo Spring. Assim teremos:

@Bean
public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
    dataSource.setUsername("root");
    dataSource.setPassword("root");
    return dataSource;
}
Lembre-se de trocar as informa��es para estarem de acordo com suas configura��es locais.

J� temos a p�gina de apresenta��o dos convidados, temos o controller que exibe esta p�gina, mas n�o temos uma entidade que representa os convidados na nossa aplica��o. Para isto criaremos uma nova classe chamada Convidado que ter� os atributos, id, nome, email e telefone.

criando classe convidado

Note que esta classe foi criada em um novo pacote chamado Model. N�o � algo obrigat�rio, mas uma boa pr�tica que ajuda a organizar o c�digo.

@Entity(name = "convidado")
public class Convidado {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
A classe Convidado � bem simples e tem apenas algumas anota��o da JPA e os atributos e m�todo respectivos a cada coluna no banco de dados.

Neste ponto, precisamos fazer com que o controller de convidados possa resgatar os registros no banco de dados e ent�o deixa-los dispon�veis para o p�gina exibir. O Spring Boot tem dispon�vel um CRUD gen�rico que permite que fa�amos isso de forma bem simples.

Primeiro precisaremos criar uma interface que extenda a CRUDRepository do Spring e ent�o, usar esta interface para acessar o banco de dados. A interface j� herdar� todos os m�todo necess�rios, precisando apenas, indicar para ela qual � a entidade e qual � o identificador �nico de cada registro. Abaixo temos nossa interface ConvidadoRepository.

public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{

}
A interface ConvidadoRepository foi criada em um pacote diferente, por boas pr�ticas, o pacote chama-se repository

A interface apenas tem os indicadores que quais classes s�o a entidade e o identificador �nico, que neste caso s�o: A classe Convidado e o atributo do tipo Long.

Para utiliz�-la precisaremos apenas de um atributo do tipo desta interface anotado com @Autowired para que o Spring disponibilize um objeto com as caracter�sticas de um repository capaz de retornar objetos de Convidado. No ConvidadoController teremos:

@Autowired
private ConvidadoRepository repository;
O passo a seguir � capturar todos os registros presentes no banco de dados usando o objeto repository e deixamos dispon�vel para a p�gina por meio de um outro objeto, chamado Model, que ser� recebido como par�metro no m�todo listaConvidados da classe ConvidadoController.

@RequestMapping("listaconvidados")
public String listaConvidados(Model model){

    Iterable<Convidado> convidados = repository.findAll();
    model.addAttribute("convidados", convidados);

    return "listaconvidados";
}
O model ser� disponibilizado para a view (p�gina) pelo Spring. O m�todo usar� o findAll do repository para retornar todos os registro em um Iterable por onde podemos iterar. Adicionamos os convidados como atributo de model e retornamos o nome do template.

Como n�o estamos usando mais JSP, teremos que utilizar um outro starter do Spring Boot para que nossos templates possam capturar os objetos que estamos enviando para estes e fazer com que a p�gina fique din�mica. � aqui que come�amos a usar o Thymeleaf. No pom.xml teremos mais uma depend�ncia.

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
    <version>1.4.2.RELEASE</version>
</dependency>
Para utilizar o thymeleaf em nossos templates precisamos apenas criar o template, que chamaremos de listaconvidados.html e no atributo html do template adicionaremos o atributo xmlns:th="http://www.thymeleaf.org". Desta forma, o template engine sabe que o template atual deve ser processado. Vejamos a listagem dos convidados como fica:
<code>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>ListaVIP</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<div class="container">
<div id="listaDeConvidados">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>telefone</th>
        </tr>
        </thead>
        <tr th:each="convidado : ${convidados}">
            <td> <span th:text="${convidado.nome}"></span> </td>
            <td> <span th:text="${convidado.email}"></span> </td>
            <td> <span th:text="${convidado.telefone}"></span> </td>
        </tr>
    </table>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
</code>
Perceba que n�o precisamos ficar usando tags espec�ficas, apenas atributos nos elementos do HTML. O atributo th:each percorre uma lista de itens iter�veis, repetindo o pr�prio elemento e o atributo th:text imprime texto na p�gina. Bem simples. E como resultado teremos:

template funcionando

Observa��o: Lembre-se de adicionar no template, os links para os scripts e estilos do Bootstrap. Tamb�m altere o link presente no index.html para ter a URL apontando para listaconvidados ao inv�s de listavip.


<h2>Resumo da aula</h2>
Nesta aula vimos como acessar o banco de dados com poucas configura��es necess�rias. Criamos o Data Source, utilizamos os starters Data JPA para acesso ao banco de dados e o Thymeleaf para renderizar nossas p�ginas.

Vimos como podemos ter um CRUD gen�rico por meio da interface CrudRepository e tamb�m vimos como o Thymeleaf simplifica o c�digo dos nossos templates. Vimos como � simples a cria��o destes e utiliza��o de recursos est�ticos na p�gina.

Como estamos usando o start Spring-data-jpa, a altera��o no pom.xml seria a inclus�o do driver de conex�o com o PostgreSQL

<dependency>
    <groupId>postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>9.1-901-1.jdbc4</version>
</dependency>
E tamb�m alterar as propriedades de acesso ao banco de dados.

dataSource.setDriverClassName("org.postgresql.Driver");
dataSource.setUrl("jdbc:postgresql://localhost:5432/listavip");
dataSource.setUsername("root");
dataSource.setPassword("root");

<h2>Gerenciando o DataSource</h2>

Quando foi preciso configurar as propriedades do banco de dados, criamos um m�todo que nos retorna um DataSource. Como o Spring Boot sabe que ele deve gerenciar esse retorno?
R: � atrav�s da anota��o @Bean que o Spring Boot sabe que ele deve gerenciar aquele bean, assim � poss�vel usa-lo onde voc� desejar dentro da sua aplica��o atr�ves da inje��o de dependencia.

<h2>Expression Language</h2>
Para listar os convidados no nosso HTML, de forma din�mica, usamos a Expression Language padr�o do Spring. E para facilitar ainda mais a configura��o dela, usamos outro starter do Spring Boot, mas voc� lembra qual � essa EL(Expression Language)?
R:A EL(Expression Language) padr�o da Spring � a Thymeleaf e usamos ela atrav�s de um starter spring-boot-starter-thymeleaf.


------------------------------------------------------------------------------------------------------------
<h1>Se��o 03 - Produtividade com ajuda do Spring Devtools</h1>

<h2>Usando nosso CRUD gen�rico para salvar</h2>

Na aplica��o que estamos migrando, a mesma p�gina que listava os convidados tamb�m tinha um formul�rio para convidar mais pessoas para a lista. O formul�rio era semelhante ao que se segue:

<hr>
<form action="convidado">
    <div class="form-group">
        <label for="nome">Nome</label> 
        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
    </div>
    <div class="form-group">
        <label for="email">Email</label> 
        <input type="email" class="form-control" id="email" name="email" placeholder="Email">
    </div>
    <div class="form-group">
        <label for="telefone">Telefone</label> 
        <input type="text" class="form-control" id="telefone" name="telefone" placeholder="Telefone">
    </div>
    <button type="submit" class="btn btn-success">Convidar</button>
</form>

/...
Vamos copi�-lo para a nova aplica��o, com algumas pequenas mudan�as. Lembre-se que o Thymeleaf � bem detalhista, por isso, fecharemos todas as tags corretamente. A segunda altera��o � fazer com que o formul�rio submeta as informa��es via POST e a action ser� salvar ao inv�s de convidado. Ap�s o fechamento da tag <hr>, o c�digo ficar� assim com as refatora��es.

<form action="salvar" method="post">
    <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" />
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Email" />
    </div>
    <div class="form-group">
        <label for="telefone">Telefone</label>
        <input type="text" class="form-control" id="telefone" name="telefone" placeholder="Telefone" />
    </div>
    <button type="submit" class="btn btn-success">Convidar</button>
</form>
O controller � quem recebe as informa��es enviadas pela view. Criaremos ent�o o m�todo salvar que recebe estas informa��es via POST da seguinte forma:

@RequestMapping(value= "salvar", method = RequestMethod.POST)
public void salvar(){

}
E j� podemos testar. O formul�rio ser� exibido normalmente, mas ao preencher e submeter o formul�rio, teremos um erro. Vejamos:

submetendo formulario

E o erro ser�:

erro no formul�rio

Apesar da URL estar apontando para o endere�o correto estamos tendo erros isto por que n�o estaremos retornando nenhuma resposta ou template. Tamb�m n�o estamos fazendo nenhuma tarefa com as informa��es.

Primeiro vamos receber todos os dados vindos do formul�rio, criar um objeto convidado, salva-lo com o objeto repository e retornar o template de listagem dos convidados.

@RequestMapping(value= "salvar", method = RequestMethod.POST)
public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, 
                   @RequestParam("telefone") String telefone ){

    Convidado novoConvidado = new Convidado(nome, email, telefone);
    repository.save(novoConvidado);

    return "listaconvidados";
}
Note que o retorno do m�todo mudou de void para String para podermos retornar o template da p�gina.

O primeiro problema deste c�digo �: N�o temos um construtor na classe Convidado e por isso teremos erros. Para evita-los, criaremos dois construtores, um vazio, padr�o e outro aceitando estes valores. Na classe Convidado adicionaremos:

public Convidado(){}

public Convidado(String nome, String email, String telefone){
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
}
Ser� que j� temos tudo resolvido? Ao testar, um comportamento estranho pode ser identificado. Ap�s salvar, mesmo o convidado tendo sido salvo, n�o vemos mais a lista de convidados e a URL aponta para a p�gina de salvar.

formulario sem a listagem

Isto ocorre porque o m�todo que salva o convidado, n�o recarrega os convidados para serem listados novamente apesar de usar o mesmo template. Vamos solucionar isso fazendo com que o m�todo salvar receba o model e carregue os convidados para a p�gina novamente. Alteraremos o m�todo salvar para ficar com o seguinte c�digo:

@RequestMapping(value= "salvar", method = RequestMethod.POST)
public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
                   @RequestParam("telefone") String telefone, Model model ){

    Convidado novoConvidado = new Convidado(nome, email, telefone);
    repository.save(novoConvidado);

    Iterable<Convidado> convidados = repository.findAll();
    model.addAttribute("convidados", convidados);

    return "listaconvidados";
}
Agora ao salvar um convidado, a lista ser� recarregada mostrando o novo convidado na lista.


<h2>Velocidade no desenvolvimento com Spring Devtools</h2>

Softwares s�o alterados com frequ�ncia, sempre sofrendo atualiza��es e mudan�as. Nosso cliente solicitou primeiramente que o campo Nome do formul�rio fosse atualizado para Nome completo. Posteriormente, solicitou que o nome Email tivesse h�fen, se tornando E-mail.

Um dos problemas dessas atualiza��es � que sempre temos que parar o servidor, atualizar e depois iniciar o servidor novamente. Durante o desenvolvimento isto � uma grande perda de tempo. Toda altera��o ter que fazer esse processo. Al�m de ser cansativo.

Para que n�o precisemos fazer todos esse processo, utilizaremos dois recursos. Um deles � um Spring Devtools que identifica quando o c�digo sofreu altera��es e reinicia o servidor automaticamente. Para isso precisamos adiciona-lo em nosso projeto com a depend�ncia no pom.xml.

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <version>1.4.2.RELEASE</version>
</dependency>
Uma segunda tarefa muito repetitiva � a atualiza��o da p�gina. Sempre que reiniciamos o servidor, precisamos atualizar a p�gina. Isso tamb�m pode ser automatizado. No seu navegador favorito instale um plugin chamado LiveReload.

Este plugin identifica quando a p�gina no servidor sofreu modifica��es e atualiza o navegador automaticamente. � simplesmente muito pr�tico ter isso durante desenvolvimento da aplica��o.

Fa�a os testes necess�rios, atualize os labels do formul�rio como dito no come�o da aula sem o LiveReload e o Spring Devtools e com os mesmos.

<h2>Resumo da aula</h2>
Nesta aula, aprendemos a utilizar nosso CRUD gen�rico para salvar convidados em nossa lista. Vimos como utilizar algumas outras ferramentas para otimizar algumas atividades repetitivas que consomem um tempo consider�vel durante o desenvolvimento da aplica��o.

Estas ferramentas foram o Spring Devtools, que reinicia o servidor rapidamente a cada altera��o na aplica��o e o plugin LiveReload, que atualiza as p�ginas no navegador quando o servidor as altera.

<h2>CRUD Repository</h2>
Durante essa aula, foi necess�rio salvar o convidado que veio do formul�rio. Para salvar tal objeto, usamos o m�todo save que herdamos da Interface CrudRepository. Caso eu precise deletar o objeto no banco ao inv�s de salvar, levando em conta que n�s j� temos o objeto Convidado populado. Como faria isso?

Para fazer tal opera��o, podemos usar tamb�m a Interface CrudRepository, por�m o m�todo que temos que usar � o delete

Convidado convidado = repository.find(idConvidado);
repository.delete(convidado);
Lembre-se que essa interface tem todos os m�todos para as opera��es de CRUD. Caso queria conhecer mais, basta acessar a documenta��o:

http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

<h2>Velocidade no desenvolvimento</h2>
Vimos que sempre precisamos alterar algo na nossa aplica��o e cada altera��o era necess�rio reiniciar nossa sistema. Para resolver isso, o Spring criou um starter bem legal para nos ajudar nisso. Voc� sabe me dizer qual �?
R: Spring DevTools. O Spring DevTools � o starter certo. Ele nos ajuda em algumas tarefas quando estamos desenvolvendo nossas aplica��es com o Spring Boot.

<h2>Vantagem do Spring DevTools</h2>
Qual � umas das principais vantagens de se usar o Spring DevTools?
R: Dentre as vantagens do Spring Devtools a mais comentada � o famoso hot deploy que nos ajuda muito quando estamos desenvolvendo. Com ele � poss�vel ganhar muito tempo pois ele altera apenas aquilo que foi alterado e com isso n�o precisa subir a aplica��o toda.

Na nossa caso, o tempo normal de subir o cont�iner � de mais ou menos 14 segundos, e ap�s alterar algo simples ele sobe o mesmo cont�iner em apenas 2 ou 3 segundos. Imagina esse ganho de tempo di�rio. � uma grande vantagem para quem gosta de velocidade na hora de desenvolver.

------------------------------------------------------------------------------------------------------------
<h1>Criando uma lib standalone com o Spring Boot</h1>

<h2>Criando aplica��o com o Spring Initializr</h2>


Em nossa aplica��o est� faltando uma regra de neg�cio importante que havia na aplica��o antiga: O envio de emails. Os convidados ao serem adicionados � lista VIP devem ser notificados via email, indicando que estes foram convidados.

Nosso cliente, aproveitando do momento de moderniza��o da aplica��o nos solicitou que o envio de emails fosse realizado em um servi�o diferente, para que este pudesse ser reaproveitado em outros de seus projetos.

Resolveremos este problema criando uma outra aplica��o que ser� respons�vel apenas pelo envio de emails. Poder�amos iniciar este projeto manualmente, mas por quest�es de praticidade, utilizaremos o Spring Initializr, dispon�vel em start.spring.io.

spring initializr configurado

O Spring Initializr, permite que inicializemos rapidamente uma aplica��o com Spring Boot utilizando de uma p�gina web onde podemos adicionar uma s�rie de depend�ncias apenas clicando em alguns bot�es.

Experimente clicar no link Switch to the full version. para verificar todas as poss�veis op��es que podemos deixar pr�-configuradas no projeto.

Apenas selecionamos a vers�o mais recente do Spring Boot, configuramos o GroupId com o valor br.com.alura.enviadorEmail e o Artifact como enviadorEmail e clicamos no bot�o: Generate Project.

Ap�s clicar no bot�o para gerar o projeto. Um arquivo zip ser� baixado e este � o projeto com Spring Boot configurado, com todas as depend�ncias mais b�sicas e outras caso tenha selecionado mais. Precisamos apenas importar no Eclipse e permitir que o Maven baixe todas as depend�ncias.

1 - Selecione a op��o de importar:

importando projeto

2 - Selecione a op��o importar projeto Maven existente:

importando projeto Maven existente

3 - A pr�xima etapa � apenas selecionar a pasta do projeto e clicar em ok. Lembre-se de descompactar o arquivo gerado pelo Spring Initializr.

Experimente explorar como o Spring Initializr criou o projeto. Quais classes j� est�o prontas, quais depend�ncias est�o no pom.xml. Explore!

Precisamos tamb�m adicionar uma nova depend�ncia em nosso projeto. Esta se trata de uma biblioteca que far� o envio dos emails. Usaremos ent�o a Apache Commons Email. No pom.xml, adicionaremos:

<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-email</artifactId>
    <version>1.4</version>
</dependency>
O pr�ximo passo � criar a classe respons�vel por enviar os emails e configura-la como um servi�o. Chamaremos esta de EmailService, ela ser� anotada com @Service e ter� um m�todo enviar que n�o ter� retorno e receber� como par�metro o nome e o email do convidado.

@Service
public class EmailService {
    public void enviar(String nome, String emailConvidado){

    }
}
O c�digo presente na aplica��o antiga � bem funcional. S� precisamos adapt�-lo ao nosso novo servi�o. Assim n�o teremos que codificar tudo novamente. Vejamos o c�digo da aplica��o antiga.

public void enviarEmail(Convidado convidado) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("email", "password"));
            email.setSSLOnConnect(true);

            email.setFrom("email");
            email.setSubject("Voc� foi convidado pelo ListaVIP");
            email.setMsg("Ol� " + convidado.getNome() + ". Voc� acaba de ser convidado pelo ListaVIP.");
            email.addTo(convidado.getEmail());
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
}
Precisamos apenas copiar o bloco try/catch alterando os lugares onde se usa o objeto convidado para utilizar o nome e o email recebidos por par�metro.

@Service
public class EmailService {
    public void enviar(String nome, String emailConvidado){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("email", "password"));
            email.setSSLOnConnect(true);

            email.setFrom("email");
            email.setSubject("Voc� foi convidado pelo ListaVIP");
            email.setMsg("Ol� " + nome + ". Voc� acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailConvidado);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
Agora precisamos gerar o artefato deste projeto com o Maven para que possamos utilizar a biblioteca nos outros projetos, como o Lista VIPs inclusive. Com a ajuda do terminal, v� at� a pasta do projeto enviadorEmail e use o comando mvn install.

Ap�s o comando, algumas tarefas ser�o realizadas pelo Maven e o .jar do projeto enviadorEmail estar� dispon�vel na pasta target do projeto.

Lembre-se de trocar os dados de autentica��o e uso do servidor de email para garantir o funcionamento com seu servidor de emails.

<h2>Integrando nossa nova lib com a aplica��o principal</h2>

Agora que temos nossa biblioteca de envio de e-mail pronta, precisamos integrar a mesma com a aplica��o Lista VIP. Fazemos isso adicionando-a como uma depend�ncia do projeto no pom.xml.

<dependency>
    <groupId>br.com.alura.enviadorEmail</groupId>
    <artifactId>enviadorEmail</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
Com isto teremos a biblioteca dispon�vel e podemos enviar e-mails instanciando um objeto da classe EmailService e utilizando o m�todo enviar. No m�todo salvar da classe ConvidadoController ap�s salvar o convidado no banco de dados, enviaremos o e-mail.

@RequestMapping(value= "salvar", method = RequestMethod.POST)
public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
                   @RequestParam("telefone") String telefone, Model model ){

    Convidado novoConvidado = new Convidado(nome, email, telefone);
    repository.save(novoConvidado);

    new EmailService().enviar(nome, email);

    Iterable<Convidado> convidados = repository.findAll();
    model.addAttribute("convidados", convidados);

    return "listaconvidados";
}
Desta forma, caso tenha configurado um servidor de email corretamente. Verifique, o e-mail deve ter sido enviado com sucesso.

envio do email

Uma camada de servi�o: Convidado
Por quest�es de boas pr�ticas faremos uma pequena refatora��o em nosso projeto. Observe que o controller de convidados est� acessando diretamente o reposit�rio de convidados, o que de certa forma pode n�o parecer problem�tico, mas n�o est� dentro dos padr�es de projetos adequados.

A solu��o adequada � que para obter e salvar convidados em nossa aplica��o, n�o � acessar a base de dados diretamente do controller, mas sim por meio de um servi�o. Criaremos ent�o uma nova classe chamada ConvidadoService, no pacote br.com.alura.service e anotaremos esta classe com @Service.

Ap�s isso, moveremos o c�digo que recupera todos os convidados que est� na classe ConvidadoController para um m�todo que chamaremos de obterTodos nesta nova classe. Faremos o mesmo com a l�gica de salvar o convidado. A classe ConvidadoService dever� ficar assim:

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository repository;


    public Iterable<Convidado> obterTodos(){
        Iterable<Convidado> convidados = repository.findAll();
        return convidados;
    }

    public void salvar(Convidado convidado){
        repository.save(convidado);
    }
}
Lembre-se de que agora � a classe ConvidadoService que acessa o reposit�rio. Por isso precisamos do objeto ConvidadoRepository. E lembre-se tamb�m de atualizar a classe ConvidadoController para refletir estas mudan�as.

@Controller
public class ConvidadoController {

    @Autowired
    private ConvidadoService service;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("listaconvidados")
    public String listaConvidados(Model model){

        Iterable<Convidado> convidados = service.obterTodos();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @RequestMapping(value= "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
                       @RequestParam("telefone") String telefone, Model model ){

        Convidado novoConvidado = new Convidado(nome, email, telefone);
        service.salvar(novoConvidado);

        new EmailService().enviar(nome, email);

        Iterable<Convidado> convidados = service.obterTodos();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }
}

<h2>Resumo da aula</h2>
Nesta aula vimos como iniciar um novo projeto Spring com o Spring Initializr, onde criamos uma aplica��o que envia e-mails e que pode ser utilizada por outras aplica��es. Tamb�m refatoramos o acesso a dados do nosso projeto para que este consuma uma camada de servi�o em vez de acessar os dados diretamente.

<h2>Al�m do Java</h2>
Nessa aula, usamos o Spring Initializr para cria��o da nossa segunda aplica��o. Vimos que l� no site do projeto, temos muitas configura��es poss�veis e tamb�m outras linguagens de programa��o. Al�m do Java, que usamos, quais s�o essas linguagens para criar projetos com o Spring Boot?
R: Kotlin e Groovy.

<h2>Empacotamento</h2>
Ap�s finalizar nossa aplica��o, geramos um artefato. Esse artefato � um JAR, mas se a gente quiser gerar um WAR ao inves do JAR. Como a gente faria isso?

Como estamos usando o Maven para gera��o de artefatos da nossa aplica��o, a configura��o de qual tipo ele vai gerar fica no pom.xml. Dentro do arquivo tem a tag <packaging>.

Ent�o basta trocar o valor dela para war e rodar o comando:

mvn package

---------------------------------------------------------------------------------------------------
<h1>Se��o 05 - Configurando nosso container e gerando nosso Fatjar</h1>

<h2>Mundado o nosso container web</h2>

O nosso cliente ligou e solicitou desta vez que troc�ssemos o servidor de aplica��o do Lista VIPs de Tomcat para Jetty. E agora? Como faremos isso se utilizamos o Spring Boot para desenvolver a aplica��o?

O Spring Boot por padr�o, tr�s o Tomcat pr�-configurado para o projeto. Felizmente a troca � muito simples e a pr�prio documenta��o � clara sobre como fazer isso.

Para acessar a documenta��o e ver como trocar Tomcat pelo Jetty clique aqui.

Precisamos simplesmente adicionar uma exclus�o na depend�ncia do starter web, sendo esta, o starter do Tomcat e adicionar uma nova depend�ncia, neste caso, do starter do Jetty. Assim teremos:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>1.4.2.RELEASE</version>

    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>

</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
    <version>1.4.2.RELEASE</version>
</dependency>
Desta forma conseguimos trocar o Tomcat pelo Jetty sem muito trabalho. Muito pr�tico.

<h2>Agrupando configura��es no application properties</h2>

O cliente liga novamente e solicita uma nova mudan�a. Agora ele nos pede para que a aplica��o seja acessada pela porta 9000 do servidor, e n�o pela 8080 padr�o do Jetty ou Tomcat. E agora?

O Spring mais uma vez nos fornece estas e outras configura��es de forma simplificada e pr�tica de realizar. Muitas destas configura��es que s�o tidas como propriedades da aplica��o podem ser configuradas em um arquivo chamado application.properties ou application.yml que deve estar dentro da pasta resources.

Uma lista de configura��es pode ser encontrada no ap�ndice da documenta��o. A que nos interessa no momento � a server.port, onde podemos definir que a porta de acesso para a aplica��o agora ser� a 9000.

Al�m de configurarmos a porta padr�o do servidor de aplica��o, vamos aproveitar para mover as configura��es de banco de dados para o arquivo properties tamb�m. Assim teremos todas as configura��es centralizadas neste mesmo arquivo. Veja como ficou o arquivo application.properties

# Server
server.port=9000

# Database
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/springboot_listavip
spring.datasource.username=root
spring.datasource.password=root
Existem diversas outras op��es para configurar. Explore-as.

<h2>Gerando nosso fatjar</h2>

Com a aplica��o finalizada, precisamos envia-la para o cliente. Como iremos fazer isso? Vamos empacotar toda a aplica��o em um �nico JAR e envia-la.

Semelhante ao que fizemos com a aplica��o enviadorEmail, iremos ao diret�rio da aplica��o Lista VIPs e usaremos o comando mvn package. Assim o Maven far� o empacotamento da aplica��o e a deixar� dispon�vel na pasta target do projeto.

Ap�s o empacotamento, devemos testar a aplica��o a fim de verificar que est� tudo funcionando perfeitamente. Usando para isto o comando java -jar passando para o comando o arquivo gerado pelo Maven. Por exemplo:

java -jar target/listavip-1.0-SNAPSHOT.jar

Mas por algum motivo, recebemos um erro:

no main manifest attribute, in target/listavip-1.0-SNAPSHOT.jar

O que acontece � que n�o instru�mos ao Maven como o empacotamento da aplica��o deve ser feito. Tamb�m n�o iremos fazer isso manualmente. Iremos utilizar um plugin do Spring Boot para isto.

A documenta��o do Spring Boot al�m de explicar como gerar o pacote com nossa aplica��o, disponibiliza o plugin e a regra de como o build ser� realizado. O Maven executar� a seguinte regra ao empacotar a aplica��o - Insira esta regra no pom.xml.

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <version>1.4.2.RELEASE</version>
            <executions>
                <execution>
                    <goals>
                        <goal>repackage</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
Para garantir que o novo pacote seja gerado sem correr o risco de ainda utilizar coisas do pacote gerado anteriormente, utilizaremos o comando mvn clean. Assim o Maven far� uma limpeza na pasta target. Ap�s isso basta executar o comando mvn package novamente.

Agora, ao executar o comando:

java -jar target/listavip-1.0-SNAPSHOT.jar

A aplica��o deve iniciar sem problemas.

<h2>P�s implanta��o com Spring actuator</h2>


Uma atividade comum � a de acompanhamento da sa�de da aplica��o ap�s ela ter sido implantada e estar em produ��o. Como podemos verificar se a aplica��o est� funcionando normalmente? Se o banco de dados est� online?

Um projeto interessante que tamb�m � um starter do Spring � o Spring Actuator que fornece v�rios endpoints onde podemos verificar algumas informa��es em tempo de execu��o da aplica��o. Para utiliza-lo primeiro temos que o adicionar no pom.xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
    <version>1.4.2.RELEASE</version>
</dependency>
Os endpoints podem ser vistos na pr�pria documenta��o do Spring Actuator. Entre estes, podemos ver os Beans gerenciados pelo Spring usando o endere�o da aplica��o seguindo de /beans ou tamb�m ver a sa�de da aplica��o usando o /health.

Tenha em mente que, o Spring Actuator � um RESTful Web Service. Isso quer dizer que todos os dados dispon�veis por ele, estar�o em formato de texto, que por padr�o � JSON. Acessando o /health por exemplo, teremos:

{"status":"UP","diskSpace":{"status":"UP","total":46310486016,"free":27349037056,"threshold":10485760},"db":{"status":"UP","database":"MySQL","hello":1}}
Indicando o status da aplica��o e do banco de dados, o consumo de espa�o em disco. Algumas op��es podem ser bem complicadas de ler, por isso pode ser necess�rio uma outra ferramenta que torne o JSON mais leg�vel.


<h2>Resumo da aula</h2>

Nesta aula exploramos bastante o Spring Boot. Primeiro vimos como remover algo de algum starter, como no caso da troca do Tomcat pelo Jetty. Vimos tamb�m como agrupar as configura��es/propriedades da nossa aplica��o em um arquivo a parte chamado application.properties.

Aprendemos a gerar o conhecido Fatjar que � a aplica��o completa empacotada em um �nico arquivo .jar e por �ltimo vimos como monitorar a sa�da de aplica��o com o Spring Actuator.

<h2>Conclus�o do curso</h2>
Parab�ns! Voc� concluiu o curso de Spring Boot e como encerramento, vamos revisar um pouco de tudo que fizemos neste curso.

Iniciamos o curso migrando a aplica��o de Lista VIPs, primeiramente com o starter Web criando controllers e iniciando a aplica��o. Vimos como disponibiliza arquivos est�ticos para os templates e tamb�m estudamos um outro starter neste ponto o Thymeleaf.

Aprendemos como acessar o banco de dados com o starter Data JPA e obtivemos o CRUD gen�rico por meio da interface CrudRepository. Onde posteriormente fizemos uma refatora��o, criando um servi�o de acesso a dados.

Criamos tamb�m um outro projeto respons�vel pelo envio de emails da aplica��o principal e adicionamos o jar desta outra aplica��o como depend�ncia do Lista VIPs.

Tamb�m aprendemos como personalizar um starter, removendo algum sub-starter especifico e adicionando outro, como no caso da troca do Tomcat pelo Jetty e vimos como agrupar todas as configura��es em um �nico arquivo .properties.

Por �ltimo, vimos como empacotar a aplica��o da forma correta usando o Maven em conjunto com o plugin de build e como utilizar o Spring Actuator para monitorar a aplica��o em produ��o por meio de endpoints RESTful.

Esperamos que tenha gostado e aproveitado o curso! Bons estudos!


<h2>Padr�es</h2>
At� aqui vimos v�rias configura��es padr�es durante nosso curso. Colocar os arquivos de view dentro do src/main/resources, por exemplo. Ter um arquivo para configura��es de v�rias propriedades e deixa-lo nesse mesmo diret�rio. Essa estrategia de seguir um padr�o ao inv�s de realizar configura��es para certas coisas � chamada de:
R: Conven��o sobre configura��o. A estrat�gia de seguir uma conven��o, que indica quais s�o as configura��es � exatamente o que acontece dentro do Spring Boot.
Quando temos v�rias configura��es ou padr�es que n�o precisamos deixar explicito em algum lugar, o termo usado � conven��o sobre configura��o. Ao inv�s de dizer pro Spring Boot onde est�o os HTML, deixamos em um local que � uma conven��o, ent�o o framework vai direto l� sem precisar deixar isso configurado em algum local.


<h2>Configura��o do container web</h2>
No nosso curso, foi preciso alterar a porta no qual nosso container web vai subir. Qual a configura��o que deveremos fazer?
R: server.port=9000
A configura��o certa � a server.port=9000 e � feita no nosso arquivo de configura��o application.properties que se encontra no src/main/resources

<h2>FatJar</h2>
Com a ajuda do plugin do Maven, geramos um jar que, quando executado, j� sobe toda nossa aplica��o diretamente da linha de comando. Esse artefato recebe o nome de Fatjar ou Uber Jar. Qual � a principal vantagem dele no nosso projeto principal?
R:Ao executar o fat jar e ele j� conter toda as configura��es da sua aplica��o, at� mesmo o cont�iner, te da uma s�rie de vantagens sendo que a principal � que n�o � mais necess�rios ter algu�m para cuidar do servidor da sua aplica��o, pois a sua aplica��o j� toma conta disso.


Projeto da Aula 5
Link da documenta�ao das Configura��es do Spring Boot, conforme visto no v�deo

http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#common-application-properties

Segue o zip da quinta aula :

https://github.com/alura-cursos/springboot/archive/aula5.zip



