--------------------------------------------------------------------------
<h1>Seção 01 - Criando nossa primeira aplicação com o Spring Boot</h1>

<h2>Introdução</h2>
Seja bem-vindo ao curso de Spring Boot, em que aprenderemos bastante sobre este projeto.

Para um melhor aproveitamento do conteúdo, é preciso que você já tenha conhecimentos sobre Spring IOC - o core do Spring -, Maven e JPA.


Durante o curso, migraremos uma aplicação antiga construída com Servlets e JDBC para uma aplicação nova, usando Spring Boot e todos os seus starters. Geraremos até o fim do curso, o Fatjar, ou seja, a aplicação inteira em um único JAR.

<h2>Criando nossa aplicação com Spring Boot</h2>



Somos parte da equipe de desenvolvimento da Alura e o cliente quer que nós migremos sua aplicação que foi criada com Servlet e JDBC. Trata-se de uma lista de convidados em que o cliente pode adicionar pessoas à listagem e convidá-las, que chamaremos de ListaVIPs.

lista vip - página inicial

Logo ao clicar no botão para ver a lista de convidados, somos levados a uma outra página onde vemos a listagem dos convidados e um formulário para adicionar mais convidados a lista.

listagem convidados e formulario

Como vemos, é uma aplicação bem simples, que permite adicionar convidados a uma lista e notifica estes convidados por email.

Para criar uma aplicação da forma mais rápida possível, precisamos de uma ferramenta que nos auxilie. Onde a gente não precise perder tempo configurando um servidor ou framework ORM, o que pode demorar horas. Por isso escolhemos o Spring Boot.

O Spring Boot não tem uma tarefa específica. Este é composto por starters onde, de acordo com a necessidade, adiciona-se ao projeto o starter necessário para atender determinado objetivo.

Para começarmos a criar nossa aplicação, iniciaremos um novo projeto Maven, simples, adicionando apenas o nome do projeto e o pacote.

iniciando projeto maven

Lembre-se de marcar a opção "create a simple project"(criar um projeto simples", traduzido) e após isso siga para o próximo passo.

configurando id do projeto

Preencha os campos Group Id e Artifact Id com o pacote do projeto (br.com.alura.listavip) e o nome do mesmo listavip respectivamente.

Após isso, devemos abrir o arquivo pom.xml e adicionar as dependências do projeto. Que por hora, é apenas o Spring Boot.

O Spring Boot durante a gravação deste curso está em sua versão 1.3.6 RELEASE. Sinta-se a vontade para usar uma versão mais recente. Em caso de dúvidas, recorra ao nosso fórum.

A dependência do Spring Boot pode ser encontrada no próprio site em projects.spring.io/spring-boot. Com ela o pom.xml deve ficar parecido com o código abaixo.

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
Após isso, devemos esperar um pouco até que o Maven baixe todas as dependências do Spring Boot.


<h2>Subindo nossa aplicação web</h2>
Com o Spring Boot já instalado em nossas dependências, precisamos configurar a aplicação. Sendo esta uma aplicação web, precisaremos de um container que a execute, sendo este o Tomcat, Jetty, Wildfly ou qualquer um.

A vantagem de usar Spring Boot é que não precisamos mais nos preocupar com a instalação e configuração do projeto em um destes containers. Precisamos apenas configurar o Spring Boot para que inicie um container automaticamente e gerencie todos os nossos Beans. Faremos isso por meio da classes Java.

Até um tempo atrás, as configurações não eram feitas usando as classes Java, mas sim por arquivos XML, o que não é mais necessário hoje. O único XML da nossa aplicação será o de dependências do Maven.

Criaremos então a classe Configuracao que irá configurar o Spring em nosso projeto. Esta será criada dentro do pacote br.com.alura.listavip.

package br.com.alura.listavip;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Configuracao {

}
Note a presença da anotação @SpringBootApplication, ela é a responsável por configurar nossa aplicação Spring. Ela é o resultado de um aglomerado de outras configurações, como por exemplo, o diretório onde o Spring deve procurar todos os Beans da aplicação, entre outras configurações.

Agora temos nossa aplicação inicial pronta e já podemos executá-la. Mas como podemos executar uma aplicação Java com uma classe praticamente em branco? Não podemos! Toda e qualquer aplicação básica com Java precisa do método main. Criaremos um então.

Dentro do método main, usaremos uma classe do Spring Boot para que este execute todas as configurações da nossa aplicação e a deixe disponível para podermos acessá-la, que receberá o nome de SpringApplication. Ela terá o método run, responsável por executar a classe de configuração da aplicação. Vejamos:

public static void main(String[] args){
    SpringApplication.run(Configuracao.class, args);
}
Como estamos na própria classe de configuração, passamos apenas o nome da classe. E como não temos nenhum parâmetro adicional para estas configurações, usamos apenas o args recebido pelo método main. Assim, já podemos executar nossa aplicação. Execute-a como uma aplicação Java normal.

executando a aplicacao

Logo veremos algumas informações sendo impressas no console.

informacoes no console

E então, podemos acessar nossa aplicação no navegador.

aplicacao funcionando no navegador

Mas convenhamos que mostrar uma página de erro logo no início da aplicação não é uma boa ideia para mostrar para o chefe ou amigo.

Para exibirmos uma mensagem mais interessante, transformaremos nossa classe de configuração em um Controller, e mapearemos o endereço / para um método que retornará uma String com uma mensagem de olá.

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
As anotações @Controller, @ResponseBody, @RequestMapping, são específicas do Spring MVC. Caso não tenha conhecimentos sobre o framework, recomendamos que faça estes cursos:

Spring MVC I

Spring MVC II.

Ao iniciarmos a aplicação novamente, teremos.

Mensagem de bem-vindo

Lembre-se de sempre separar seus controllers em outras classes. Neste exemplo, apenas usamos a classe de configuração para demonstração da praticidade de trabalhar com o Spring Boot.

<h2>Resumo da aula</h2>
O que fizemos nesta aula foi ver como podemos iniciar rapidamente um projeto web com o Spring Boot. Fazendo isto, apenas adicionamos uma dependência no arquivo pom.xmle criando apenas uma classe que chamamos de Configuracao onde, com algumas linhas de código, conseguimos iniciar e visualizar a aplicação funcionando.

<h2>Definição do Spring Boot</h2>
A gente criou nossa aplicação usando o Spring Boot, mas qual é a melhor definição para descrever esse framework?
R:Agilizar no desenvolvimento de aplicações com configurações default/padrão.
Tendo isso em mente, o Spring Boot junta vários starters para facilitar as diversas tarefas da nossa aplicação, como configurar o ambiente, configurar acesso ao banco de dados, oferecer um contêiner web para agilizar o desenvolvimento entre outras vantagens.

-------------------------------------------------------------------------------------------------
<h1>Seção 02 - Inicio da migração e Integração do Spring Boot com a JPA</h1>

Na aplicação entregue pelo cliente, as páginas são criadas com JSP padrão. Mas como estamos utilizando Spring Boot com o starter web que nos disponibiliza o Spring MVC, utilizaremos outra engine de templates. Uma do próprio Spring, chamada Thymeleaf.

Iniciaremos a criação da nossa primeira página criando uma nova pasta dentro da pasta resources, e chamaremos esta detemplates. Dentro desta, criaremos um arquivo HTML simples com uma mensagem de bem vindo.

criando pasta templates

O arquivo HTML se chamará index.html e terá o seguinte código.

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
O próximo passo será remover o código presente na classe de configuração que trata a requisição para uma outra classe de controller, visto que, a classe de configuração deve conter código apenas de configuração.

Criaremos uma classe chamada ConvidadoController e nesta criaremos um método chamado index que mapeará a requisição em / e retornará como String o nome do template que criamos, o index.html. Assim teremos.

@Controller
public class ConvidadoController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
Esta classe deve estar no mesmo pacote da classe de configuração.

Note que retornamos apenas o nome do template, sem a extensão do arquivo. Isto por que o engine de template fará as associações. Se iniciarmos a aplicação agora, teremos a mesma tela de erro que tivemos quando iniciamos o projeto. Isto por que não adicionamos o engine de templates na nossa aplicação. No arquivo pom.xml, teremos então que adicionar a dependência do thymeleaf starter.

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
    <version>1.4.1.RELEASE</version>
</dependency>
A versão utilizada no vídeo é a 1.3.6, porém, você pode utilizar a versão mais recente sem problema algum.

Por último, resolveremos alguns problemas do nosso template que por enquanto está muito simples, sem nenhum estilo. O HTML da aplicação antiga, que estamos migrando tinha o seguinte HTML em sua index.

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
O primeiro ponto a ser observado é que ele usa o Bootstrap. O segundo ponto é que a engine que adicionamos no nosso projeto é bem detalhista. Teremos erros por exemplo, se esquecermos de fechar alguma tag. Por isso cuidado. Sempre feche todas as tags HTML.

Para a adição dos arquivos estáticos do Bootstrap, criaremos uma nova pasta chamada static, dentro da pasta resources. Baixaremos o Bootstrap em getbootstrap.com e o descompactaremos nesta pasta que criamos.

Copiaremos o código do antigo index, fecharemos as tags corretamente e o colaremos no lugar do index atual. Que terá ao final, o seguinte código.

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
Agora, ao iniciarmos a aplicação, teremos uma página de bem-vindo mais agradável.

pagina de bem vindo

Observações: Muito do que vimos até agora, está dentro de um conceito muito comum presente nos frameworks mais modernos que é a Convenção sobre a Configuração. Antes precisaríamos configurar uma série de recursos para ter a aplicação funcionando. Agora apenas seguindo algumas convenções, pulamos todas as configurações e apenas focamos no que é importante.

Das convenções que vimos até aqui temos: Os templates das páginas são guardados na pasta templates dentro de resources e também a convenção de onde armazenar os arquivos estáticos (css, js, imagens, etc.) que ficam dentro da pasta static.


<h2>Configurando Spring Boot Data JPA</h2>

Se pensarmos em como a aplicação antiga funcionava, recordaremos que nela havia uma página onde existia uma listagem dos convidados e um formulário que nos permitia adicionar novos convidados à lista. O código da listagem era semelhante ao que está abaixo.

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
Havia uma tabela, onde através do forEach, percorria-se uma lista de convidados e imprimia-se, seu nome, email e telefone. Esta então será a segunda parte da nossa migração.

Começaremos criando uma página simples de teste, a fim de verificar que tudo está funcionando normalmente. Criaremos mais um arquivo na pasta de templates chamada listaconvidados.html e nesta apenas adicionaremos o seguinte código.

Criando listaconvidados.html

criando pagina listaconvidados

Código presente no listaconvidados.html

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
E por último, precisamos mapear a rota /listaconvidados para este template. Na classe ConvidadoController então, criaremos um novo método chamado listaConvidados que apenas retorna o nome do template da seguinte forma.

@RequestMapping("listaconvidados")
public String listaConvidados(){
    return "listaconvidados";
}
Então, ao acessarmos localhost:8080/listaconvidados, teremos nossa página sendo exibida corretamente.

pagina de listagem com mensagem

Mas se lembrarmos bem, a lista de convidados está salva no banco de dados e não temos acesso ao banco de dados ainda. Se fizermos um selec no banco de dados, teremos os seguintes resultados.

convidados no banco de dados

A imagem anterior mostra como o MySQL Workbench apresenta os dados. Use a aplicação de acesso ao banco de dados que se sentir mais confortável. Caso não tenha conhecimentos de SQL, recomendamos também qee faça nossos cursos de MySQL I e MySQL II

Para a configuração do banco de dados, vamos utilizar mais um starter, esta chamado de Spring Boot Data JPA Starter, que configura todas as dependências com Hibernate e JPA. Antes precisávamos configurar tudo isso via XML, mas não precisamos mais disso. Adicionaremos as seguinte dependências ao pom.xml

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
A primeira para o starter da JPA, e a segunda do conector do MySQL. Agora precisamos configurar o acesso ao banco de dados, ou seja, definir o caminho para o banco, o usuário e a senha.

Na classe Configuracao.java, adicionaremos um novo método responsável por criar o DataSource de conexão ao banco, o anotaremos com @Bean para que este possa ser gerenciado pelo Spring. Assim teremos:

@Bean
public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
    dataSource.setUsername("root");
    dataSource.setPassword("root");
    return dataSource;
}
Lembre-se de trocar as informações para estarem de acordo com suas configurações locais.

Já temos a página de apresentação dos convidados, temos o controller que exibe esta página, mas não temos uma entidade que representa os convidados na nossa aplicação. Para isto criaremos uma nova classe chamada Convidado que terá os atributos, id, nome, email e telefone.

criando classe convidado

Note que esta classe foi criada em um novo pacote chamado Model. Não é algo obrigatório, mas uma boa prática que ajuda a organizar o código.

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
A classe Convidado é bem simples e tem apenas algumas anotação da JPA e os atributos e método respectivos a cada coluna no banco de dados.

Neste ponto, precisamos fazer com que o controller de convidados possa resgatar os registros no banco de dados e então deixa-los disponíveis para o página exibir. O Spring Boot tem disponível um CRUD genérico que permite que façamos isso de forma bem simples.

Primeiro precisaremos criar uma interface que extenda a CRUDRepository do Spring e então, usar esta interface para acessar o banco de dados. A interface já herdará todos os método necessários, precisando apenas, indicar para ela qual é a entidade e qual é o identificador único de cada registro. Abaixo temos nossa interface ConvidadoRepository.

public interface ConvidadoRepository extends CrudRepository<Convidado, Long>{

}
A interface ConvidadoRepository foi criada em um pacote diferente, por boas práticas, o pacote chama-se repository

A interface apenas tem os indicadores que quais classes são a entidade e o identificador único, que neste caso são: A classe Convidado e o atributo do tipo Long.

Para utilizá-la precisaremos apenas de um atributo do tipo desta interface anotado com @Autowired para que o Spring disponibilize um objeto com as características de um repository capaz de retornar objetos de Convidado. No ConvidadoController teremos:

@Autowired
private ConvidadoRepository repository;
O passo a seguir é capturar todos os registros presentes no banco de dados usando o objeto repository e deixamos disponível para a página por meio de um outro objeto, chamado Model, que será recebido como parâmetro no método listaConvidados da classe ConvidadoController.

@RequestMapping("listaconvidados")
public String listaConvidados(Model model){

    Iterable<Convidado> convidados = repository.findAll();
    model.addAttribute("convidados", convidados);

    return "listaconvidados";
}
O model será disponibilizado para a view (página) pelo Spring. O método usará o findAll do repository para retornar todos os registro em um Iterable por onde podemos iterar. Adicionamos os convidados como atributo de model e retornamos o nome do template.

Como não estamos usando mais JSP, teremos que utilizar um outro starter do Spring Boot para que nossos templates possam capturar os objetos que estamos enviando para estes e fazer com que a página fique dinâmica. É aqui que começamos a usar o Thymeleaf. No pom.xml teremos mais uma dependência.

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
Perceba que não precisamos ficar usando tags específicas, apenas atributos nos elementos do HTML. O atributo th:each percorre uma lista de itens iteráveis, repetindo o próprio elemento e o atributo th:text imprime texto na página. Bem simples. E como resultado teremos:

template funcionando

Observação: Lembre-se de adicionar no template, os links para os scripts e estilos do Bootstrap. Também altere o link presente no index.html para ter a URL apontando para listaconvidados ao invés de listavip.


<h2>Resumo da aula</h2>
Nesta aula vimos como acessar o banco de dados com poucas configurações necessárias. Criamos o Data Source, utilizamos os starters Data JPA para acesso ao banco de dados e o Thymeleaf para renderizar nossas páginas.

Vimos como podemos ter um CRUD genérico por meio da interface CrudRepository e também vimos como o Thymeleaf simplifica o código dos nossos templates. Vimos como é simples a criação destes e utilização de recursos estáticos na página.

Como estamos usando o start Spring-data-jpa, a alteração no pom.xml seria a inclusão do driver de conexão com o PostgreSQL

<dependency>
    <groupId>postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>9.1-901-1.jdbc4</version>
</dependency>
E também alterar as propriedades de acesso ao banco de dados.

dataSource.setDriverClassName("org.postgresql.Driver");
dataSource.setUrl("jdbc:postgresql://localhost:5432/listavip");
dataSource.setUsername("root");
dataSource.setPassword("root");

<h2>Gerenciando o DataSource</h2>

Quando foi preciso configurar as propriedades do banco de dados, criamos um método que nos retorna um DataSource. Como o Spring Boot sabe que ele deve gerenciar esse retorno?
R: É através da anotação @Bean que o Spring Boot sabe que ele deve gerenciar aquele bean, assim é possível usa-lo onde você desejar dentro da sua aplicação atráves da injeção de dependencia.

<h2>Expression Language</h2>
Para listar os convidados no nosso HTML, de forma dinâmica, usamos a Expression Language padrão do Spring. E para facilitar ainda mais a configuração dela, usamos outro starter do Spring Boot, mas você lembra qual é essa EL(Expression Language)?
R:A EL(Expression Language) padrão da Spring é a Thymeleaf e usamos ela através de um starter spring-boot-starter-thymeleaf.


------------------------------------------------------------------------------------------------------------
<h1>Seção 03 - Produtividade com ajuda do Spring Devtools</h1>

<h2>Usando nosso CRUD genérico para salvar</h2>

Na aplicação que estamos migrando, a mesma página que listava os convidados também tinha um formulário para convidar mais pessoas para a lista. O formulário era semelhante ao que se segue:

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
Vamos copiá-lo para a nova aplicação, com algumas pequenas mudanças. Lembre-se que o Thymeleaf é bem detalhista, por isso, fecharemos todas as tags corretamente. A segunda alteração é fazer com que o formulário submeta as informações via POST e a action será salvar ao invés de convidado. Após o fechamento da tag <hr>, o código ficará assim com as refatorações.

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
O controller é quem recebe as informações enviadas pela view. Criaremos então o método salvar que recebe estas informações via POST da seguinte forma:

@RequestMapping(value= "salvar", method = RequestMethod.POST)
public void salvar(){

}
E já podemos testar. O formulário será exibido normalmente, mas ao preencher e submeter o formulário, teremos um erro. Vejamos:

submetendo formulario

E o erro será:

erro no formulário

Apesar da URL estar apontando para o endereço correto estamos tendo erros isto por que não estaremos retornando nenhuma resposta ou template. Também não estamos fazendo nenhuma tarefa com as informações.

Primeiro vamos receber todos os dados vindos do formulário, criar um objeto convidado, salva-lo com o objeto repository e retornar o template de listagem dos convidados.

@RequestMapping(value= "salvar", method = RequestMethod.POST)
public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, 
                   @RequestParam("telefone") String telefone ){

    Convidado novoConvidado = new Convidado(nome, email, telefone);
    repository.save(novoConvidado);

    return "listaconvidados";
}
Note que o retorno do método mudou de void para String para podermos retornar o template da página.

O primeiro problema deste código é: Não temos um construtor na classe Convidado e por isso teremos erros. Para evita-los, criaremos dois construtores, um vazio, padrão e outro aceitando estes valores. Na classe Convidado adicionaremos:

public Convidado(){}

public Convidado(String nome, String email, String telefone){
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
}
Será que já temos tudo resolvido? Ao testar, um comportamento estranho pode ser identificado. Após salvar, mesmo o convidado tendo sido salvo, não vemos mais a lista de convidados e a URL aponta para a página de salvar.

formulario sem a listagem

Isto ocorre porque o método que salva o convidado, não recarrega os convidados para serem listados novamente apesar de usar o mesmo template. Vamos solucionar isso fazendo com que o método salvar receba o model e carregue os convidados para a página novamente. Alteraremos o método salvar para ficar com o seguinte código:

@RequestMapping(value= "salvar", method = RequestMethod.POST)
public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
                   @RequestParam("telefone") String telefone, Model model ){

    Convidado novoConvidado = new Convidado(nome, email, telefone);
    repository.save(novoConvidado);

    Iterable<Convidado> convidados = repository.findAll();
    model.addAttribute("convidados", convidados);

    return "listaconvidados";
}
Agora ao salvar um convidado, a lista será recarregada mostrando o novo convidado na lista.


<h2>Velocidade no desenvolvimento com Spring Devtools</h2>

Softwares são alterados com frequência, sempre sofrendo atualizações e mudanças. Nosso cliente solicitou primeiramente que o campo Nome do formulário fosse atualizado para Nome completo. Posteriormente, solicitou que o nome Email tivesse hífen, se tornando E-mail.

Um dos problemas dessas atualizações é que sempre temos que parar o servidor, atualizar e depois iniciar o servidor novamente. Durante o desenvolvimento isto é uma grande perda de tempo. Toda alteração ter que fazer esse processo. Além de ser cansativo.

Para que não precisemos fazer todos esse processo, utilizaremos dois recursos. Um deles é um Spring Devtools que identifica quando o código sofreu alterações e reinicia o servidor automaticamente. Para isso precisamos adiciona-lo em nosso projeto com a dependência no pom.xml.

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <version>1.4.2.RELEASE</version>
</dependency>
Uma segunda tarefa muito repetitiva é a atualização da página. Sempre que reiniciamos o servidor, precisamos atualizar a página. Isso também pode ser automatizado. No seu navegador favorito instale um plugin chamado LiveReload.

Este plugin identifica quando a página no servidor sofreu modificações e atualiza o navegador automaticamente. É simplesmente muito prático ter isso durante desenvolvimento da aplicação.

Faça os testes necessários, atualize os labels do formulário como dito no começo da aula sem o LiveReload e o Spring Devtools e com os mesmos.

<h2>Resumo da aula</h2>
Nesta aula, aprendemos a utilizar nosso CRUD genérico para salvar convidados em nossa lista. Vimos como utilizar algumas outras ferramentas para otimizar algumas atividades repetitivas que consomem um tempo considerável durante o desenvolvimento da aplicação.

Estas ferramentas foram o Spring Devtools, que reinicia o servidor rapidamente a cada alteração na aplicação e o plugin LiveReload, que atualiza as páginas no navegador quando o servidor as altera.

<h2>CRUD Repository</h2>
Durante essa aula, foi necessário salvar o convidado que veio do formulário. Para salvar tal objeto, usamos o método save que herdamos da Interface CrudRepository. Caso eu precise deletar o objeto no banco ao invés de salvar, levando em conta que nós já temos o objeto Convidado populado. Como faria isso?

Para fazer tal operação, podemos usar também a Interface CrudRepository, porém o método que temos que usar é o delete

Convidado convidado = repository.find(idConvidado);
repository.delete(convidado);
Lembre-se que essa interface tem todos os métodos para as operações de CRUD. Caso queria conhecer mais, basta acessar a documentação:

http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

<h2>Velocidade no desenvolvimento</h2>
Vimos que sempre precisamos alterar algo na nossa aplicação e cada alteração era necessário reiniciar nossa sistema. Para resolver isso, o Spring criou um starter bem legal para nos ajudar nisso. Você sabe me dizer qual é?
R: Spring DevTools. O Spring DevTools é o starter certo. Ele nos ajuda em algumas tarefas quando estamos desenvolvendo nossas aplicações com o Spring Boot.

<h2>Vantagem do Spring DevTools</h2>
Qual é umas das principais vantagens de se usar o Spring DevTools?
R: Dentre as vantagens do Spring Devtools a mais comentada é o famoso hot deploy que nos ajuda muito quando estamos desenvolvendo. Com ele é possível ganhar muito tempo pois ele altera apenas aquilo que foi alterado e com isso não precisa subir a aplicação toda.

Na nossa caso, o tempo normal de subir o contêiner é de mais ou menos 14 segundos, e após alterar algo simples ele sobe o mesmo contêiner em apenas 2 ou 3 segundos. Imagina esse ganho de tempo diário. É uma grande vantagem para quem gosta de velocidade na hora de desenvolver.

------------------------------------------------------------------------------------------------------------
<h1>Criando uma lib standalone com o Spring Boot</h1>

<h2>Criando aplicação com o Spring Initializr</h2>


Em nossa aplicação está faltando uma regra de negócio importante que havia na aplicação antiga: O envio de emails. Os convidados ao serem adicionados à lista VIP devem ser notificados via email, indicando que estes foram convidados.

Nosso cliente, aproveitando do momento de modernização da aplicação nos solicitou que o envio de emails fosse realizado em um serviço diferente, para que este pudesse ser reaproveitado em outros de seus projetos.

Resolveremos este problema criando uma outra aplicação que será responsável apenas pelo envio de emails. Poderíamos iniciar este projeto manualmente, mas por questões de praticidade, utilizaremos o Spring Initializr, disponível em start.spring.io.

spring initializr configurado

O Spring Initializr, permite que inicializemos rapidamente uma aplicação com Spring Boot utilizando de uma página web onde podemos adicionar uma série de dependências apenas clicando em alguns botões.

Experimente clicar no link Switch to the full version. para verificar todas as possíveis opções que podemos deixar pré-configuradas no projeto.

Apenas selecionamos a versão mais recente do Spring Boot, configuramos o GroupId com o valor br.com.alura.enviadorEmail e o Artifact como enviadorEmail e clicamos no botão: Generate Project.

Após clicar no botão para gerar o projeto. Um arquivo zip será baixado e este é o projeto com Spring Boot configurado, com todas as dependências mais básicas e outras caso tenha selecionado mais. Precisamos apenas importar no Eclipse e permitir que o Maven baixe todas as dependências.

1 - Selecione a opção de importar:

importando projeto

2 - Selecione a opção importar projeto Maven existente:

importando projeto Maven existente

3 - A próxima etapa é apenas selecionar a pasta do projeto e clicar em ok. Lembre-se de descompactar o arquivo gerado pelo Spring Initializr.

Experimente explorar como o Spring Initializr criou o projeto. Quais classes já estão prontas, quais dependências estão no pom.xml. Explore!

Precisamos também adicionar uma nova dependência em nosso projeto. Esta se trata de uma biblioteca que fará o envio dos emails. Usaremos então a Apache Commons Email. No pom.xml, adicionaremos:

<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-email</artifactId>
    <version>1.4</version>
</dependency>
O próximo passo é criar a classe responsável por enviar os emails e configura-la como um serviço. Chamaremos esta de EmailService, ela será anotada com @Service e terá um método enviar que não terá retorno e receberá como parâmetro o nome e o email do convidado.

@Service
public class EmailService {
    public void enviar(String nome, String emailConvidado){

    }
}
O código presente na aplicação antiga é bem funcional. Só precisamos adaptá-lo ao nosso novo serviço. Assim não teremos que codificar tudo novamente. Vejamos o código da aplicação antiga.

public void enviarEmail(Convidado convidado) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("email", "password"));
            email.setSSLOnConnect(true);

            email.setFrom("email");
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + convidado.getNome() + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(convidado.getEmail());
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
}
Precisamos apenas copiar o bloco try/catch alterando os lugares onde se usa o objeto convidado para utilizar o nome e o email recebidos por parâmetro.

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
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailConvidado);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
Agora precisamos gerar o artefato deste projeto com o Maven para que possamos utilizar a biblioteca nos outros projetos, como o Lista VIPs inclusive. Com a ajuda do terminal, vá até a pasta do projeto enviadorEmail e use o comando mvn install.

Após o comando, algumas tarefas serão realizadas pelo Maven e o .jar do projeto enviadorEmail estará disponível na pasta target do projeto.

Lembre-se de trocar os dados de autenticação e uso do servidor de email para garantir o funcionamento com seu servidor de emails.

<h2>Integrando nossa nova lib com a aplicação principal</h2>

Agora que temos nossa biblioteca de envio de e-mail pronta, precisamos integrar a mesma com a aplicação Lista VIP. Fazemos isso adicionando-a como uma dependência do projeto no pom.xml.

<dependency>
    <groupId>br.com.alura.enviadorEmail</groupId>
    <artifactId>enviadorEmail</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
Com isto teremos a biblioteca disponível e podemos enviar e-mails instanciando um objeto da classe EmailService e utilizando o método enviar. No método salvar da classe ConvidadoController após salvar o convidado no banco de dados, enviaremos o e-mail.

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

Uma camada de serviço: Convidado
Por questões de boas práticas faremos uma pequena refatoração em nosso projeto. Observe que o controller de convidados está acessando diretamente o repositório de convidados, o que de certa forma pode não parecer problemático, mas não está dentro dos padrões de projetos adequados.

A solução adequada é que para obter e salvar convidados em nossa aplicação, não é acessar a base de dados diretamente do controller, mas sim por meio de um serviço. Criaremos então uma nova classe chamada ConvidadoService, no pacote br.com.alura.service e anotaremos esta classe com @Service.

Após isso, moveremos o código que recupera todos os convidados que está na classe ConvidadoController para um método que chamaremos de obterTodos nesta nova classe. Faremos o mesmo com a lógica de salvar o convidado. A classe ConvidadoService deverá ficar assim:

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
Lembre-se de que agora é a classe ConvidadoService que acessa o repositório. Por isso precisamos do objeto ConvidadoRepository. E lembre-se também de atualizar a classe ConvidadoController para refletir estas mudanças.

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
Nesta aula vimos como iniciar um novo projeto Spring com o Spring Initializr, onde criamos uma aplicação que envia e-mails e que pode ser utilizada por outras aplicações. Também refatoramos o acesso a dados do nosso projeto para que este consuma uma camada de serviço em vez de acessar os dados diretamente.

<h2>Além do Java</h2>
Nessa aula, usamos o Spring Initializr para criação da nossa segunda aplicação. Vimos que lá no site do projeto, temos muitas configurações possíveis e também outras linguagens de programação. Além do Java, que usamos, quais são essas linguagens para criar projetos com o Spring Boot?
R: Kotlin e Groovy.

<h2>Empacotamento</h2>
Após finalizar nossa aplicação, geramos um artefato. Esse artefato é um JAR, mas se a gente quiser gerar um WAR ao inves do JAR. Como a gente faria isso?

Como estamos usando o Maven para geração de artefatos da nossa aplicação, a configuração de qual tipo ele vai gerar fica no pom.xml. Dentro do arquivo tem a tag <packaging>.

Então basta trocar o valor dela para war e rodar o comando:

mvn package

---------------------------------------------------------------------------------------------------
<h1>Seção 05 - Configurando nosso container e gerando nosso Fatjar</h1>

<h2>Mundado o nosso container web</h2>

O nosso cliente ligou e solicitou desta vez que trocássemos o servidor de aplicação do Lista VIPs de Tomcat para Jetty. E agora? Como faremos isso se utilizamos o Spring Boot para desenvolver a aplicação?

O Spring Boot por padrão, trás o Tomcat pré-configurado para o projeto. Felizmente a troca é muito simples e a próprio documentação é clara sobre como fazer isso.

Para acessar a documentação e ver como trocar Tomcat pelo Jetty clique aqui.

Precisamos simplesmente adicionar uma exclusão na dependência do starter web, sendo esta, o starter do Tomcat e adicionar uma nova dependência, neste caso, do starter do Jetty. Assim teremos:

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
Desta forma conseguimos trocar o Tomcat pelo Jetty sem muito trabalho. Muito prático.

<h2>Agrupando configurações no application properties</h2>

O cliente liga novamente e solicita uma nova mudança. Agora ele nos pede para que a aplicação seja acessada pela porta 9000 do servidor, e não pela 8080 padrão do Jetty ou Tomcat. E agora?

O Spring mais uma vez nos fornece estas e outras configurações de forma simplificada e prática de realizar. Muitas destas configurações que são tidas como propriedades da aplicação podem ser configuradas em um arquivo chamado application.properties ou application.yml que deve estar dentro da pasta resources.

Uma lista de configurações pode ser encontrada no apêndice da documentação. A que nos interessa no momento é a server.port, onde podemos definir que a porta de acesso para a aplicação agora será a 9000.

Além de configurarmos a porta padrão do servidor de aplicação, vamos aproveitar para mover as configurações de banco de dados para o arquivo properties também. Assim teremos todas as configurações centralizadas neste mesmo arquivo. Veja como ficou o arquivo application.properties

# Server
server.port=9000

# Database
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/springboot_listavip
spring.datasource.username=root
spring.datasource.password=root
Existem diversas outras opções para configurar. Explore-as.

<h2>Gerando nosso fatjar</h2>

Com a aplicação finalizada, precisamos envia-la para o cliente. Como iremos fazer isso? Vamos empacotar toda a aplicação em um único JAR e envia-la.

Semelhante ao que fizemos com a aplicação enviadorEmail, iremos ao diretório da aplicação Lista VIPs e usaremos o comando mvn package. Assim o Maven fará o empacotamento da aplicação e a deixará disponível na pasta target do projeto.

Após o empacotamento, devemos testar a aplicação a fim de verificar que está tudo funcionando perfeitamente. Usando para isto o comando java -jar passando para o comando o arquivo gerado pelo Maven. Por exemplo:

java -jar target/listavip-1.0-SNAPSHOT.jar

Mas por algum motivo, recebemos um erro:

no main manifest attribute, in target/listavip-1.0-SNAPSHOT.jar

O que acontece é que não instruímos ao Maven como o empacotamento da aplicação deve ser feito. Também não iremos fazer isso manualmente. Iremos utilizar um plugin do Spring Boot para isto.

A documentação do Spring Boot além de explicar como gerar o pacote com nossa aplicação, disponibiliza o plugin e a regra de como o build será realizado. O Maven executará a seguinte regra ao empacotar a aplicação - Insira esta regra no pom.xml.

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
Para garantir que o novo pacote seja gerado sem correr o risco de ainda utilizar coisas do pacote gerado anteriormente, utilizaremos o comando mvn clean. Assim o Maven fará uma limpeza na pasta target. Após isso basta executar o comando mvn package novamente.

Agora, ao executar o comando:

java -jar target/listavip-1.0-SNAPSHOT.jar

A aplicação deve iniciar sem problemas.

<h2>Pós implantação com Spring actuator</h2>


Uma atividade comum é a de acompanhamento da saúde da aplicação após ela ter sido implantada e estar em produção. Como podemos verificar se a aplicação está funcionando normalmente? Se o banco de dados está online?

Um projeto interessante que também é um starter do Spring é o Spring Actuator que fornece vários endpoints onde podemos verificar algumas informações em tempo de execução da aplicação. Para utiliza-lo primeiro temos que o adicionar no pom.xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
    <version>1.4.2.RELEASE</version>
</dependency>
Os endpoints podem ser vistos na própria documentação do Spring Actuator. Entre estes, podemos ver os Beans gerenciados pelo Spring usando o endereço da aplicação seguindo de /beans ou também ver a saúde da aplicação usando o /health.

Tenha em mente que, o Spring Actuator é um RESTful Web Service. Isso quer dizer que todos os dados disponíveis por ele, estarão em formato de texto, que por padrão é JSON. Acessando o /health por exemplo, teremos:

{"status":"UP","diskSpace":{"status":"UP","total":46310486016,"free":27349037056,"threshold":10485760},"db":{"status":"UP","database":"MySQL","hello":1}}
Indicando o status da aplicação e do banco de dados, o consumo de espaço em disco. Algumas opções podem ser bem complicadas de ler, por isso pode ser necessário uma outra ferramenta que torne o JSON mais legível.


<h2>Resumo da aula</h2>

Nesta aula exploramos bastante o Spring Boot. Primeiro vimos como remover algo de algum starter, como no caso da troca do Tomcat pelo Jetty. Vimos também como agrupar as configurações/propriedades da nossa aplicação em um arquivo a parte chamado application.properties.

Aprendemos a gerar o conhecido Fatjar que é a aplicação completa empacotada em um único arquivo .jar e por último vimos como monitorar a saída de aplicação com o Spring Actuator.

<h2>Conclusão do curso</h2>
Parabéns! Você concluiu o curso de Spring Boot e como encerramento, vamos revisar um pouco de tudo que fizemos neste curso.

Iniciamos o curso migrando a aplicação de Lista VIPs, primeiramente com o starter Web criando controllers e iniciando a aplicação. Vimos como disponibiliza arquivos estáticos para os templates e também estudamos um outro starter neste ponto o Thymeleaf.

Aprendemos como acessar o banco de dados com o starter Data JPA e obtivemos o CRUD genérico por meio da interface CrudRepository. Onde posteriormente fizemos uma refatoração, criando um serviço de acesso a dados.

Criamos também um outro projeto responsável pelo envio de emails da aplicação principal e adicionamos o jar desta outra aplicação como dependência do Lista VIPs.

Também aprendemos como personalizar um starter, removendo algum sub-starter especifico e adicionando outro, como no caso da troca do Tomcat pelo Jetty e vimos como agrupar todas as configurações em um único arquivo .properties.

Por último, vimos como empacotar a aplicação da forma correta usando o Maven em conjunto com o plugin de build e como utilizar o Spring Actuator para monitorar a aplicação em produção por meio de endpoints RESTful.

Esperamos que tenha gostado e aproveitado o curso! Bons estudos!


<h2>Padrões</h2>
Até aqui vimos várias configurações padrões durante nosso curso. Colocar os arquivos de view dentro do src/main/resources, por exemplo. Ter um arquivo para configurações de várias propriedades e deixa-lo nesse mesmo diretório. Essa estrategia de seguir um padrão ao invés de realizar configurações para certas coisas é chamada de:
R: Convenção sobre configuração. A estratégia de seguir uma convenção, que indica quais são as configurações é exatamente o que acontece dentro do Spring Boot.
Quando temos várias configurações ou padrões que não precisamos deixar explicito em algum lugar, o termo usado é convenção sobre configuração. Ao invés de dizer pro Spring Boot onde estão os HTML, deixamos em um local que é uma convenção, então o framework vai direto lá sem precisar deixar isso configurado em algum local.


<h2>Configuração do container web</h2>
No nosso curso, foi preciso alterar a porta no qual nosso container web vai subir. Qual a configuração que deveremos fazer?
R: server.port=9000
A configuração certa é a server.port=9000 e é feita no nosso arquivo de configuração application.properties que se encontra no src/main/resources

<h2>FatJar</h2>
Com a ajuda do plugin do Maven, geramos um jar que, quando executado, já sobe toda nossa aplicação diretamente da linha de comando. Esse artefato recebe o nome de Fatjar ou Uber Jar. Qual é a principal vantagem dele no nosso projeto principal?
R:Ao executar o fat jar e ele já conter toda as configurações da sua aplicação, até mesmo o contêiner, te da uma série de vantagens sendo que a principal é que não é mais necessários ter alguém para cuidar do servidor da sua aplicação, pois a sua aplicação já toma conta disso.


Projeto da Aula 5
Link da documentaçao das Configurações do Spring Boot, conforme visto no vídeo

http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#common-application-properties

Segue o zip da quinta aula :

https://github.com/alura-cursos/springboot/archive/aula5.zip



