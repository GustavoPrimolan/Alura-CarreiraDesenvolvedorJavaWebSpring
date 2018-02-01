----------------------------------------------------------------------------------------------------
<h1>Se��o 01 - Come�ando com SpringMVC</h1>

Bem-vindo ao curso de SpringMVC! Neste curso estudaremos o SpringMVC e alguns dos seus m�dulos para resolver problemas reais. Neste curso criaremos um projeto semelhante a Casa do C�digo, no qual h� v�rias peculiaridades que desenvolveremos com o SpringMVC.

SpringMVC � um framework Java e como todo projeto java, temos que configurar nosso ambiente de desenvolvimento para conseguirmos desenvolver o projeto. Neste caso, usaremos o JBoss Forge, um framework criado pela JBoss para a cria��o da estrutura inicial do projeto.

Antes de continuarmos, baixe o JBoss Forge no site forge.jboss.org, descompacte em um diret�rio de sua prefer�ncia e renomeie o diret�rio do JBoss Forge para forge. Este �ltimo passo foi feito para deixar mais simples a intera��o com o JBoss Forge, pois o usaremos atrav�s do terminal.

Com o terminal aberto, navegue at� o diret�rio onde est� o JBoss Forge (pasta forge renomeada no passo anterior) e execute o JBoss dentro de bin/forge. Este execut�vel � um terminal disponibilizado pelo JBoss Forge para que possamos configurar a estrutura inicial do projeto.

Aten��o: O passo anterior pode demorar um pouco para ser finalizado, pois o JBoss ir� carregar uma s�rie de itens para que possamos us�-lo.

Neste momento, j� dentro do terminal do JBoss, podemos digitar e executar o seguinte comando para criar o projeto: project-new --named casadocodigo. Este comando indica para o JBoss que queremos um novo projeto (project-new) e que este projeto ter� o nome casadocodigo (--named casadocodigo).

Observa��o: Nas vers�es mais recentes do JBoss o comando para criar um novo projeto mudou para new-project, ou seja, utilize o comando new-project --named casadocodigo para criar o projeto caso encontre o erro: ***ERROR*** No such command: project-new .

"** \*\*\*Success\*\*\* ** Project named 'casadocodigo' has been created!"
Sucesso! Nosso projeto inicial est� criado!

Observa��o: Se verificar no site do JBoss Forge, notar� que o projeto criado por este framework, � um projeto Maven-based, ou seja, um projeto baseado no Maven. Note que na pasta onde o JBoss Forge h� uma nova pasta com o nome do projeto.

Podemos agora abrir o eclipse e fazer os seguintes passos: Abrir a ferramenta de import, escolher que queremos importar um projeto Maven e selecionar o projeto criado com o JBoss Forge!

Clique com o direito no project explorer do Eclipse e v� at� a op��o de import e selecione import.

Na caixa de filtro, digite maven para que o eclipse filtre as op��es de importe e selecione Existing Maven Projects.

Em Root Directory, selecione Browse e navegue pelas pastas at� chegar na pasta do projeto (casadocodigo). Selecione a pasta do projeto e clique em Open. Ap�s isso note que o eclipse reconheceu o projeto e j� exibe na listagem o pom.xml do projeto. Clique em Finish!

Nosso projeto agora � listado no eclipse, com a estrutura padr�o criada com o JBoss Forge. Seu projeto deve estar parecido com a imagem abaixo:

Visualiza��o do projeto na perspectiva JavaEE

Para deixarmos o projeto com um fluxo um pouco mais simples de se trabalhar e visualizar, vamos mudar a perspectiva do eclipse de Java EE para Java. Podemos fazer isso acessando os menus:

Window -> Perspective -> Open Perspective -> Other
selecionando a perspectiva Java e clicando em ok note como a estrutura do projeto � exibida de forma mais simples.

Visualiza��o do projeto na perspectiva Java

Experimente explorar as pastas do projeto!

Com a estrutura inicial do projeto pronta, podemos come�ar a criar algumas p�ginas para podermos visualizar o projeto funcionando. Clique na pasta webapp do projeto e use o atalho ctrl + n para criarmos um novo arquivo. Na caixa de sele��o que aparece, digite html para criarmos um arquivo HTML. Selecione a op��o HTML File. Em File name digite index.html e clique em Finish.

O c�digo do index.html deve estar parecido com este:

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
Modifique o t�tulo, coloque algum c�digo no corpo do HTML, para visualizar depois como ficou. Algo como:

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Livros de Java, Android, iPhone, PHP, Ruby e Muito mais - Casa Do C�digo</title>
</head>
<body>
    <h1>Oi</h1>
</body>
</html>
Com este �ltimo passo, estamos prontos para vermos nosso projeto funcionando, mas temos que configurar mais uma coisa, o servidor!

Baixe o Tomcat (vers�o 7) no site da Apache e descompacte em um diret�rio de sua prefer�ncia. Ap�s isso, no eclipse use a barra de pesquisa na parte superior direita e procure por servers. Abra esta aba.

Abrindo aba servers no Eclipse

Quando a aba de servers do eclipse for aberta, clique com o direito do mouse na �rea da aba aberta e selecione new -> server. H� uma lista de servidores que podemos usar, vamos selecionar o Apache -> Tomcat V0.7 Server e clique em Next.O pr�ximo passo � seleciona o diret�rio onde nosso Tomcat est� instalado, clique em Browse e navegue pelas pastas at� encontrar a pasta do Tomcat e selecione esta pasta e clique em Finish.

Nosso servidor deve ser listado na aba servers do eclipse. Devemos agora adicionar nosso projeto no servidor. Cliquando com o bot�o direito sobre o servidor e selecionando a op��o add/remove visualizamos nosso projeto na listagem.Para adiciona-lo ao servidor, basta selecionar o projeto e clicarmos em add e depois em Finish. Podemos iniciar ent�o o servidor clicando com o direito novamente sobre o servidor e selecionando a op��o start.

Nosso projeto j� est� rodando no servidor, para verificar, basta acessar com um navegador a url: localhost:8080/casadocodigo.

Apesar de funcionar, n�o � esse nosso real objetivo, queremos nossa lista de livros igual a casa do c�digo!

At� o momento, n�o usamos nada do SpringMVC e neste ponto que sabemos que est� tudo funcionando perfeitamente, podemos come�ar a usar o SpringMVC de fato!

Criando o primeiro controller.
Criaremos agora nosso primeiro controller! O controller � nada mais nada menos que uma classe Java, ent�o crie uma classe com o nome de HomeController no pacote br.com.casadocodigo.loja.controllers.

package br.com.casadocodigo.loja.controllers;

public class HomeController{

}
O que temos aqui n�o � nada mais que uma simples classe java. N�s ainda n�o dissemos para o SpringMVC que esta classe � um controller! Podemos fazer esta defini��o de duas formas: 1. Usando regras de XML. 2. Usando anota�oes Java.

Por quest�es de simplicidade, usaremos a segunda forma, para isto s� precisamos adicionar a anota��o @Controller logo acima da defini��o da nossa classe:

package br.com.casadocodigo.loja.controllers;

@Controller
public class HomeController{

}
Note que apesar de termos feito todos estes passos, o Eclipse marca de vermelho a anota��o @Controller, como se ele n�o entendesse a anota��o. Isso acontece porque em momento nenhum configuramos o SpringMVC para nosso projeto. Para isso precisamos declarar algumas depend�ncias no arquivo pom.xml para que o Maven baixe e configure o SpringMVC para o nosso projeto.

Abra o arquivo pom.xml e na aba pom.xml cole as depend�ncias do projeto logo abaixo do fechamento da tag <properties>.

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>4.1.0.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.apache.tomcat</groupId>
        <artifactId>tomcat-servlet-api</artifactId>
        <version>7.0.30</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>jsp-api</artifactId>
        <version>2.1</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>javax.servlet.jsp.jstl</groupId>
        <artifactId>jstl-api</artifactId>
        <version>1.2</version>
        <exclusions>
            <exclusion>
                <groupId>javax.servlet</groupId>
                <artifactId>servlet-api</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>org.glassfish.web</groupId>
        <artifactId>jstl-impl</artifactId>
        <version>1.2</version>
        <exclusions>
            <exclusion>
                <groupId>javax.servlet</groupId>
                <artifactId>servlet-api</artifactId>
            </exclusion>
        </exclusions>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.6.1</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>jcl-over-slf4j</artifactId>
        <version>1.6.1</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>1.6.1</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.16</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
Salve o pom.xml e aguarde um momento, o Maven dever� baixar e configurar as depend�ncias do nosso projeto. Um novo diret�rio chamado Maven Dependencies deve aparecer no projeto (Isso pode demorar um pouco j� que o Maven ir� baixar as depend�ncias).

Tudo parece funcionar perfeitamente! Vamos agora criar um metodo em nossa classe que ser� respons�vel por atender as requisi��es que chegam na p�gina inicial do nosso projeto, ou seja, o endere�o raiz ("/"). Em nosso controller teremos o c�digo:Observa��o: Lembre-se de fazer os imports necess�rios (Atalho: Ctrl + Shift + O)

[...]
@Controller
public class HomeController{

    @RequestMapping("/")
    public void index(){
        System.out.println("Entrando na home da CDC");
    }

}
Uma novidade em nosso c�digo � a anota��o @RequestMapping, que tem a fun��o de definir que aquele metodo atende a um determinado path ou endere�o. Neste caso estamos definindo que o metodo index atender� as requisi��es que chegarem na raiz do nosso projeto ("/").Se entrarmos em nosso projeto agora, deveriamos visualizar a mensagem do escrita no System.out.println certo? Ainda n�o!

Em nenhum momento at� agora, configuramos o SpringMVC para atender as requisi��es que chegam para nossa aplica��o. Se acessarmos atrav�s do navegador o nosso projeto, veremos a mensagem de Oi que fizemos no arquivo index.html.

Existem duas formas de configurarmos o servidor Tomcat para que ele passe as requisi��es para o SpringMVC: 1. Usando o Servets 2. Usando os Filtros

Usaremos a primeira op��o, pois o SpringMVC j� vem com um servlet pronto para utilizarmos como servlet de configura��o. Podemos configura-lo atrav�s de XML ou c�digo Java e mais uma vez usaremos c�digo java!

Crie uma nova classe dentro do pacote br.com.casadocodigo.loja.conf chamada de ServletSpringMVC. Com a classe criada, fa�a ela extender a classe: AbstractAnnotationConfigDispatcherServletInitializer.

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

}
A classe ServletSpringMVC parece estar com erros agora que extendemos a classe do SpringMVC. A classe do SpringMVC cont�m alguns m�todos que precisamos implementar! Clique sobre o nome da Classe ServletSpringMVC use o atalho Ctrl + 1 e selecione a op��o: Add Unimplemented Methods. Veja que o Eclipse completou nossa classe com alguns metodos:

@Override
protected Class<?>[] getRootConfigClasses() {
    return null;
}

@Override
protected Class<?>[] getServletConfigClasses() {
    return null;
}

@Override
protected String[] getServletMappings() {
    return null;
}
Implementaremos os dois �ltimos metodos. O getServletConfigClasses pede um array de classes de configura��es, que ainda n�o temos, mas que iremos criar depois. O getServletMappings pede um array com os mapeamentos que queremos que nosso servlet atenda. Nossa implementa��o ficar� assim:

@Override
protected Class<?>[] getServletConfigClasses() {
    return new Class[] {AppWebConfiguration.class};
}

@Override
protected String[] getServletMappings() {
    return new String[] {"/"};
}
Como estas configura��es estamos definindo que o servlet do SpringMVC atender� as requisi��es a partir da raiz do nosso projeto (/) e que a classe AppWebConfiguration ser� usada como classe de configura��o do servlet do SpringMVC.Crie a classe AppWebConfiguration no pacote br.com.casadocodigo.loja.conf.

Na classe AppWebConfiguration n�s precisamos usar o recurso de Web MVC do SpringMVC. Podemos fazer isso atrav�s de mais uma anota��o. Antes da declara��o da classe devemos adicionar a anota��o: @EnableWebMvc.

@EnableWebMvc
public class AppWebConfiguration {

}
Precisamos tamb�m configurar o caminho (pacote) onde o SpringMVC ir� encontrar os nossos controllers! Mais uma anota��o para esta configura��o � necess�ria: @ComponentScan.Isso somente n�o resolve nosso problema, o ComponentScan precisa saber onde procurar os nossos controllers e podemos indicar isso passando um param�tro. Exitem duas possibilidades:1. @ComponentScan(basePackages={""}) que recebe um array de Strings com os nomes dos pacotes onde o SpringMVC pode encontrar os controllers.

@ComponentScan(basePackageClasses={}) que recebe um array de classes de onde o SpringMVC pode extrair os pacotes nos quais ele pode encontrar os controllers.
A segunda op��o � a melhor escolha, pois podemos passar classes que est�o no mesmo pacote dos controllers e assim o SpringMVC descobre o pacote de forma autom�tica, diferente da primeira op��o, que � mais manual.Com a primeira op��o, caso o pacote mude, temos que lembrar de modificar essa configura��o tamb�m.Para a segunda op��o, passaremos ent�o nossa classe HomeController. Assim o SpringMVC descobre o pacote desta classe e pode encontrar os outros controllers autom�ticamente.

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class})
public class AppWebConfiguration {

}
Se iniciarmos nosso servidor agora, devemos ter alguma mudan�a vis�vel em nossa aplica��o! Acessando-a pelo navegador (em localhost:8080/casadocodigo) temos:

Home com erro  404

Erro 404! Porque? O que aconteceu? Nossas configura��es est�o todas certas e aparentemente o projeto n�o funcionou! Acontece que o SpringMVC est� com um conflito de recursos, n�s mapeamos a rota "/", mas o servidor por padr�o, quando recebe uma requisi��o para o "/" ele retorna o index que estiver naquele endere�o!Para resolvermos isso, basta deletar o arquivo index.html. Atualizando a p�gina teremos:

Home com erro 500 (no view name)

Erro 500! O que aconteceu agora? veja a mensagem de erro: javax.servlet.ServletException: Could not resolve view with name '' in servlet with name 'dispatcher'. O SpringMVC est� procurando uma view de nome vazio? Note que no log do Eclipse que nossa mensagem no System.out.println do m�todo index foi impressa! Isso indica que o SpringMVC chamou nosso metodo index. Mesmo assim ele continua com o erro dizendo que n�o encontrou uma view.

Vamos modificar nosso controler para retornar a view que o SpringMVC espera receber. No nosso HomeController modificamos o metodo index para ficar da seguinte forma:

@RequestMapping("/")
public String index(){
    System.out.println("Entrando na home da CDC");
    return "home.jsp";
}
Agora estamos retornando uma String que representa o nome da view. Se atualizarmos no navegador a p�gina do nosso projeto, podemos visualizar que o erro mudou! Ainda � um erro 500 mas desta vez o SpringMVC identifica a view que foi retornada pelo m�todo: home.jsp.

Erro 500 com nome da view impressa

Apesar de termos retornado uma view, n�o temos esta view criada ainda! Crie ent�o o home.jsp dentro da pasta webapp do seu projeto (Use os atalhos do Eclipse). Seu home.jsp deve ficar parecido com este:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do C�digo</title>
</head>
<body>
    <h1>Casa do C�digo</h1>
</body>
</html>
Apenas este passo n�o resolve nosso problema, pois o SpringMVC ainda n�o sabe onde encontrar as views do nosso projeto. Antes de fazermos esta configura��o, vamos fazer algumas modifica��es por quest�es de boas pr�ticas. 1. Crie uma pasta dentro de webapp chamada WEB-INF. 2. Crie uma pasta dentro de WEB-INF chamada views. 3. Mova o arquivo home.jsp para dentro da pasta views.

A pasta WEB-INF � uma pasta protegida pelo servidor. Este que n�o permite que os arquivos dentro dela sejam acessados diretamente. � uma boa pr�tica que deixemos nossas views dentro desta pasta para que o usu�rio n�o consiga acessar as p�ginas de forma direta, sem que ele passe pelo controller, pois se a view for acessada sem passar pelo controller, podemos ter quebra de regras neg�cio para aquela view.

Nosso pr�ximo passo � configurar o projeto para que o SpringMVC consiga encontrar as views. Essa configura��o � feita na classe de configura��o AppWebConfiguration. Nesta criaremos um novo metodo que ajudar� o SpringMVC a encontrar nossas views:

@Bean
public InternalResourceViewResolver internalResourceViewResolver(){
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
}
Este m�todo na classe AppWebConfiguration retorna um objeto do tipo InternalResourceViewResolver (Resolvedor Interno de Recursos de View) que ajuda o SpringMVC a encontrar as views. O setPrefix define o caminho onde est�o nossas views, j� o setSuffix adiciona a exten��o dos arquivos de view.

Note que no final do caminho das views h� uma barra "/", ela poderia n�o estar ai, mas caso n�o estivesse, teriamos que lembrar que sempre que quisessemos retornar uma view, teriamos que no controller, no retorno da view escrever algo como: return "/pagina.jsp", ent�o colocamos esta barra j� na configura��o para n�o termos que nos preocupar com isto.

A anota��o @Bean � para que o retorno da chamada deste met�do possa ser gerenciada pelo SpringMVC, sem ela nossa configura��o n�o funciona. Outra observa��o v�lida � que j� estamos colocando o sufixo dos arquivos (.jsp). Desta forma, n�o precisamos colocar a exten��o dos arquivos de view nos controllers. Sendo assim, modifique o HomeController para retornar apenas "home" em vez de "home.jsp"

Com essas configura��es feitas, podemos agora visualizar a p�gina inicial do projeto sem mais problemas. Experimente p�r mais alguns elementos na home.jsp, como por exemplo uma tabela que pode listar alguns livros da casa do c�digo! Algo como:

[...]
<h1>Casa do C�digo</h1>
<table>
    <tr>
        <td>TDD na Pr�tica - JAVA</td>
        <td>Google Android</td>
     </tr>
    <tr>
        <td>Certifica��o OCJP</td>
        <td>Java 8 Pr�tico</td>
    </tr>
</table>
[...]

<h2>Avaliando o projeto gerado pelo JBoss Forge</h2>

Para configurar o nosso projeto n�s utilizamos o JBoss Forge. Percebeu como o JBoss forge qual � a vantagem ganhamos ao usar?

A grande vantagem de utilizar o JBoss Forge � agilizar a configura��o inicial do projeto, permitindo ganhar tempo indo direto para o c�digo.

O JBoss Forge � um gerador de projetos Java. Ele gera toda a estrutura base do projeto integrada com o Maven. Configura��o de depend�ncias (bibliotecas e frameworks), estrutura de pastas e gera configura��es iniciais que geralmente envolve arquivos XML.

Sem ele, em um projeto tipicamente Java EE, devemos criar v�rios arquivos XML na m�o, por exemplo: persistence.xml, web.xml, faces-config.xml, pom.xml, beans.xml entre outros.

Temos um curso de maven para caso queira aprender mais sobre essa magn�fica ferramenta, no qual usamos neste projeto para principalmente gerenciarmos nossas depend�ncias.

<h2>Criando o projeto usando o JBOSS Forge</h2>
Agora que j� fizemos o download do JBoss Forge abra o seu terminal navegue at� a pasta do forge e execute o comando:

project-new --named [nome do projeto]
Cole aqui os comandos digitados no terminal.
Os comandos ficar�o da seguinte forma:

1) Navegue at� a sua pasta workspace:

cd /workspace

2) Inicie o terminal do forge:

/forge/bin/forge

3) Crie o projeto:

project-new --named casadocodigo

E como criamos o projeto utilizando o Forge o nosso projeto j� vem com o Maven !

---------------------------------------------------------------------------------------------------------------
<h1>Se��o 02 - Cadastro de Produtos</h1>

Nossa aplica��o est� come�ando a tomar forma. Ela j� lista os produtos em nossa home. Agora come�aremos a criar o cadastro de produtos, para assim podermos cadastrar livros da Casa do C�digo.

Para o cadastro de produtos, precisaremos de um formul�rio. Sendo assim, crie um novo arquivo JSP chamado form.jsp dentro da pasta WEB-INF/views/produtos/. A pasta produtos ainda n�o existe, teremos que cri�-la tamb�m. faremos altera��es para deixar no padr�o HTML 5. O arquivo form.jsp inicial deve estar parecido com esse:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do C�digo</title>
</head>
<body>

</body>
</html>
O pr�ximo passo � criar o html referente ao formul�rio (form) de cadastro dos livros. Eles ter�o inicialmente os seguintes atributos: T�tulo, Descri��o e N�mero de P�ginas, todos do tipo texto. Vamos ent�o criar o formul�rio com estes campos. O formul�rio deve ficar parecido com este:

<form action="/produtos" method="post">
    <div>
        <label>T�tulo</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas" />
    </div>
    <button type="submit">Cadastrar</button>
</form>
Note que estamos fazendo o formul�rio enviar seus dados para o path /produtos e que o estamos enviando via post no m�todo do formul�rio.

Nosso form.jsp deve ser acessado na url localhost:8080/casadocodigo/produtos/form. Se acessarmos agora, veremos uma p�gina de erro 404, pois as views n�o podem ser acessadas diretamente. Lembra? Como resolvemos isso? Criando um Controller!

Crie ent�o o ProdutosController dentro do pacote br.com.casadocodigo.loja.controllers. Neste Controller crie o m�todo form que retorna a view com o formul�rio. Mapeie o path que este m�todo vai atender com a anota��o @RequestMapping. O ProdutosController deve ficar parecido com este:

@Controller
public class ProdutosController {

    @RequestMapping("/produtos/form")
    public String form(){
        return "produtos/form";
    }

}
Se acessarmos agora o nosso formul�rio em localhost:8080/casadocodigo/produtos/form, devemos v�-lo sem nenhum problema. N�o esque�a de reiniciar o servidor! Teste o formul�rio, tente cadastrar um livro!

Quando enviamos o formul�rio, recebemos um erro 404:

Erro 404 com url errada

Mas tem algo estranho neste erro 404 , note a url. O caminho est� sem o /casadocodigo/. Isto acontece porque o nosso formul�rio n�o aponta /casadocodigo/ em sua action. Vamos faz�-lo apontar, ent�o.

<form action="/casadocodigo/produtos" method="post">
    [...]
</form>
Este � o primeiro passo para resolver nosso problema. Agora precisamos mapear o path /produtos para um m�todo em no ProdutosController. Algo parecido com:

@RequestMapping("/produtos")
public String gravar(String titulo, String descricao, int paginas){
    System.out.println(titulo);
    System.out.println(descricao);
    System.out.println(paginas);

    return "ok";
}
Nosso m�todo atende ao path /produtos e se chama gravar. Este ir� gravar os produtos em um banco de dados posteriormente. Ele recebe os dados do produto e imprime no terminal, por fim, retorna "ok" para indicar que tudo ocorreu bem.

Fa�a alguns testes! Teremos um erro 404 indicando que a view ok n�o foi encontrada, mas n�o deixe de verificar se os dados do formul�rio foram impressos no console. Funciona! O SpringMVC sozinho verifica a assinatura do nosso m�todo e faz um bind dos par�metros do m�todo com os names do formul�rio.

Nossa aplica��o j� funciona, mas antes de continuarmos, vamos melhorar um ponto e corrigir outro.

Primeiro ponto, imagine que o formul�rio de produtos ter� 30 campos. A assinatura do nosso m�todo ficar� enorme! Vamos mudar isso, o m�todo gravar requer um produto. Vamos criar um Produto ent�o.

Crie uma classe chamada Produto com os mesmos atributos do formul�rio e os defina como private. Use os atalhos do Eclipse e gere tamb�m os getters and setters. Gere tamb�m o toString na classe Produto para que deixemos de imprimir aquela mensagem padr�o estranha e possamos imprimir o objeto diretamente de forma amig�vel.A classe Produto deve estar no pacote br.com.casadocodigo.loja.models.Esta classe representa uma entidade no nosso sistema.

package br.com.casadocodigo.loja.models;

public class Produto {
    private String titulo;
    private String descricao;
    private int paginas;


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Produto [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
    }

}
Desta forma isolamos todo o comportamento e dados dos produtos em uma classe. Podemos ent�o em nosso Controller receber um Produto em vez de seus dados separadamente.O SpringMVC far� o bind dos names em nosso formul�rio com os atributos do Produto de agora em diante. Sendo assim, vamos modificar o ProdutosController para recebermos um objeto produto agora.

O m�todo gravar deve ficar assim:

@RequestMapping("/produtos")
public String gravar(Produto produto){
    System.out.println(produto);
    return "/produtos/ok";
}
Agora recebemos um objeto do tipo produto, imprimimos o produto no console e retornamos a view "ok", que deve estar dentro da pasta produtos (perceba que mudamos tamb�m o caminho de retorno da view de /ok em /views/ para /produtos/ok em /views/produtos/ok). Crie a view ok.jsp na pasta WEB-INF/views/produtos com uma mensagem de sucesso. Algo como:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do C�digo</title>
</head>
<body>
 <h1>Produto cadastrado com sucesso!</h1>
</body>
</html>
Agora, se acessarmos nosso formul�rio, preenchermos os campos e tentarmos cadastrar um produto (um livro), teremos a mensagem de sucesso e os dados do nosso livro ser�o mostrados no console. Fa�a o teste!

produto cadastrado com sucesso

Salvando produtos no banco de dados
Nossa aplica��o ainda n�o salva os produtos no banco de dados. Para essa tarefa usaremos a JPA (Java Persistence API) e o Hibernate, que ainda n�o est�o configurados em nosso projeto. Vamos configura-los agora.

No pom.xml vamos declarar algumas novas depend�ncias. Entre elas est�o a JPA, o Hibernate, O SpringORM e o Driver MySQL. No final do pom.xml antes do fechamento da tag <dependencies> cole as seguintes dependencias:

<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>4.3.0.Final</version>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>4.3.0.Final</version>
</dependency>
<dependency>
    <groupId>org.hibernate.javax.persistence</groupId>
    <artifactId>hibernate-jpa-2.1-api</artifactId>
    <version>1.0.0.Final</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-orm</artifactId>
    <version>4.1.0.RELEASE</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.15</version>
</dependency>
Salve o pom.xml e aguarde um momento, pois o Maven ir� baixar e deixar disponivel em nosso projeto as bibliotecas que acabamos de adicionar como depend�ncias.

Com as depend�ncias configuradas, podemos come�ar a criar a l�gica respons�vel por salvar os produtos. O primeiro passo � definir que o produto � uma entidade. Fazemos isso marcando a classe Produto com a anota��o @Entity.

import javax.persistence.Entity;

@Entity
public class Produto {
    [...]
}
Aten��o: O importe deve ser do pacote: javax.persistence.Entity.

Com este passo a classe Produto j� representa uma entidade em nosso sistema. Fazer isso � apenas o primeiro passo, ainda n�o temos a l�gica respons�vel por efetivamente salvar o produto no banco de dados.

Vamos ent�o criar uma classe de acesso a dados respons�vel por manipular os dados dos produtos. Criaremos ent�o a classe ProdutoDAO (DAO: Data Access Object ou Objeto de Acesso a Dados). Inicialmente, criamos nesta classe o m�todo gravar que receber� um objeto produto e o salvar� no banco de dados. Est� classe deve ficar no pacote: br.com.casadocodigo.loja.daos

package br.com.casadocodigo.loja.daos;
import br.com.casadocodigo.loja.models.Produto;

public class ProdutoDAO {

    public void gravar(Produto produto){

    }
}
Para que o ProdutoDAO realize a persistencia ou seja, para que ele salve o produto no banco de dados. � necess�rio que ele tenha um gerenciador de entidades, um EntityManager. Este EntityManager � fornecido pelo Spring. Assim podemos usar o EntityManager para persistir os produto no banco de dados. No c�digo teremos algo como:

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Produto;

public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto){
        manager.persist(produto);
    }

}
Temos quase tudo pronto neste ponto. Precisamos fazer com que agora, quando o Controller receba o produto, ele use o ProdutoDAO para salvar o produto no banco de dados. Estas modifica��es ser�o feitas no ProdutosController.

@Controller
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDao;

    @RequestMapping("/produtos")
    public String gravar(Produto produto){
        System.out.println(produto);
        produtoDao.gravar(produto);
        return "/produtos/ok";
    }
    [...]
}
A anota��o @Autowired serve para que n�s n�o nos preocupemos em criar manualmente o ProdutoDAO no Controller. O Spring far� isso automaticamente. Mas para isso, o Spring precisa "conhecer" o ProdutoDAO. Em outras palavras dizemos que devemos definir que o ProdutoDAO ser� gerenciado pelo Spring. Para isso devemos marcar o ProdutoDAO com a anota��o @Repository.

@Repository
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto){
        manager.persist(produto);
    }

}
Se tentarmos inicializar o projeto neste momento, teremos dois problemas. O primeiro deles ser� que, apesar de termos aparentemente configurado todo o necess�rio para persistir os produtos no banco de dados, Spring n�o conseguir� gerenciar nossas classes, nem mesmo encontr�-las.

Esta configura��o est� presente em nossa classe AppWebConfiguration, na qual configuramos para o Spring encontrar nossos controllers. N�s vamos configurar para que encontre nossos daos tamb�m. A anota��o @ComponentScan deve ficar assim:

ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class})
Note que em momento algum estamos fornecendo para o Spring qual � o banco, o usu�rio ou a senha do banco de dados. Faremos essas configura��es em uma nova classe. Crie uma classe no pacote br.com.casadocodigo.conf chamada JPAConfiguration.

Nesta nova classe, criaremos o m�todo que ser� gerenciado pelo Spring e criar� o EntityManager usado em nosso DAO. Ela tamb�m ter� as configura��es de banco de dados e algumas outras propriedades importantes. Vejamos o c�digo:

package br.com.casadocodigo.loja.conf;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class JPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(vendorAdapter);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/casadocodigo");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        factoryBean.setDataSource(dataSource);

        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");

        factoryBean.setJpaProperties(props);

        factoryBean.setPackagesToScan("br.com.casadocodigo.loja.models");

        return factoryBean;
    }
}
Nesta classe estamos criando um �nico m�doto, que ser� usado pelo Spring para gerar o EntityManager. Este precisa de um adapter e estamos passando um que o Hibernate disponibiliza.

Criamos tamb�m um DataSource que cont�m as configura��es de banco de dados. Criamos um objeto do tipo Properties para podermos setar algumas configura��es, como por exemplo o dialeto usado para a comunica��o com o banco de dados. Setamos tamb�m onde o EntityManager encontrar� nossos Models. Feito isso retornamos nossas configura��es para o Spring poder utiliza-las.

Nosso pr�ximo passo � disponibilizar essa configura��o para o Spring. Faremos isso na nossa class: ServletSpringMVC. No M�todo: getServletConfigClasses.

@Override
protected Class<?>[] getServletConfigClasses() {
    return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
}
Mais um passo � necess�rio para podermos finalizar esta etapa de configura��o. Como as nossas entidades ser�o gerenciadas pelo Framework, precisaremos setar mais um atributos, que essencialmente � utilizado sempre que usamos o banco de dados. O id. Ent�o em nossa classe Produto, definiremos o id.

@Entity
public class Produto {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    [...]
}
Basicamente, s� precisar�amos do @Id. Mas para que n�o precisemos gerenci�-lo manualmente, usamos a segunda anota��o (@GeneratedValue(strategy=GenerationType.IDENTITY)) para que o pr�prio framework o gere e o gerencie. Feito isso podemos acessar a p�gina de cadastro de produtos e tentarmos cadastrar um produto. A resposta que temos logo ap�s tentar cadastrar um produto ser� essa:

HTTP Status 500 - Request processing failed; nested exception is javax.persistence.TransactionRequiredException: No transactional EntityManager available
Como assim? Aparentemente estava tudo funcionando. Note que o erro � bem claro: No transactional EntityManager available do tipo TransactionRequiredException. Ou seja, nossa opera��o com o banco de dados deve ser gerenciada com uma transa��o.

Fa�amos ent�o essas �ltimas configura��es para conseguirmos cadastrar nosso produtos no banco de dados. Primeiro precisaremos de um TransactionManager que conhe�a nosso EntityManager para que assim ele possa gerenciar as transa��es de nossas entidades.Na classe JPAConfiguration adicionaremos mais um m�todo que criar� o TransactionManager.

@EnableTransactionManagement
public class JPAConfiguration {

    [...]

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
Note que adicionamos a anota��o @EnableTransactionManagement. Assim o Spring ativa o gerenciamento de transa��es e j� reconhece o TransactionManager. Agora precisamos definir que o nosso ProdutoDAO � uma classe Transancional e fazemos isso atravez da anota��o @Transactional do pacote org.springframework.transaction.annotation.Transactional.

@Repository
@Transactional
public class ProdutoDAO {
    [...]
}
� isso! N�o precisamos configurar mais nada por hora. Desta forma j� conseguiremos cadastrar nossos produtos sem nenhum problema. N�o se esque�a de verificar as configura��es do seu banco de dados e de criar o banco casadocodigo pois o Hibernate n�o cria o banco, mas as tabelas e campos sim.

Experimente cadastrar alguns livros da Casa do C�digo e verificar se est�o realmente no banco de dados. Caso tenha problemas ou d�vidas, publique no for�m, voc� sempre encontrar� algu�m para ajudar!

<h2>Sobre a utiliza��o do @AutoWired</h2>
Dentro do ProdutosControllers, para utilizarmos o produtoDAO do tipo ProdutoDAO simplesmente anotamos o objeto com a annotation @Autowired do Spring. Por que ao inv�s de instanciarmos manualmente, fizemos essa abordagem?
R: Quando utilizamos o @AutoWired, pedimos para o Spring uma inst�ncia do objeto que foi anotado. Esse recurso � chamado de inje��o de depend�ncia e est� dispon�vel para qualquer Bean do Spring. � prefer�vel esse tipo de abordagem, justamente para manter o conceito da invers�o de controle que basicamente joga toda a responsabilidade de instanciar ou inicializar qualquer tipo de configura��o necess�ria de um objeto para o servidor, nesse caso, o Spring.

Dessa forma, diminu�mos tanto o trabalho na utiliza��o desses objetos, como tamb�m, removemos o risco de esquecermos algum passo ou configura��o durante a utiliza��o.


-------------------------------------------------------------------------------------------------------
<h1>Se��o 03 - Cadastro de pre�os do produto</h1>

At� este ponto do curso, j� fizemos o cadastro de produtos e tivemos a certeza de que tudo est� funcionando corretamente. Nossos produtos j� est�o sendo cadastrados no banco de dados. Mas se verificarmos alguns livros na Casa do C�digo, veremos que h� mais algumas informa��es que precisamos incluir sobre os produtos.

Vamos voltar ao formul�rio(form.jsp):

<form action="casadocodigo/produtos" method="POST">
    <div>
        <label>T�tulo</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas"/>
    </div>
    <button type="submit">Cadastrar</button>
</form>
Uma das informa��es que queremos adicionar � o Pre�o. No caso da Casa do C�digo, os livros t�m tr�s op��es de compra. O Ebook, Impresso e o Combo (ebook e impresso juntos). Faremos o mesmo em nosso sistema. Sendo assim, modifique o formul�rio (form.jsp) de produtos adicionando esses tr�s novos campos:

<form action="/casadocodigo/produtos" method="post">
[...]
    <div>
        <label>E-book</label>
        <input type="text" name="ebook"/>
    </div>
    <div>
        <label>Impresso</label>
        <input type="text" name="impresso"/>
    </div>
    <div>
        <label>Combo</label>
        <input type="text" name="combo"/>
    </div>
[...]
</form>
Dessa forma, temos as tr�s op��es de pre�o. Agora precisamos modificar a classe Produto, para que possa guarda-los tamb�m.

Imagine colocar os tr�s atributos de pre�o na classe Produto. Estar�amos duplicando informa��es. Agora imagine se tivermos que adicionar no futuro, outras varia��es de pre�o al�m dessas tr�s... Ter�amos que adicionar mais atributos em nossa classe. Pensando assim, parece uma boa ideia ter uma lista de pre�os.

O pre�o representa uma algo importante em nosso neg�cio. Criaremos ent�o uma classe que representa o pre�o do produto e neste teremos uma lista com cada um dos pre�os (Ebook, Impresso e Combo). Sendo assim, modifique a classe Produto adicionando o atributo precos.

@Entity
public class Produto {
    [...]
    private List<Preco> precos;
    [...]
}
Observa��o: Estamos usando atributos privados, ent�o lembre-se sempre de gerar os getters and setters. Use os atalhos do Eclipse!

Agora criaremos a classe Preco que ter� dois atributos. O valor, que � o pre�o propriamente dito e o tipo. O tipo limita-se as tr�s op��es que temos atualmente: Ebook, Impresso e Combo.

Poder�amos usar Strings para identificar os tipos de pre�o, mas ter�amos que fazer v�rias verifica��es na Strings. Para evitar isso, vamos criar um atributo TipoPreco e um ENUM que lista nossas tr�s op��es de pre�o. Ent�o teremos a classe Preco:

public class Preco {
    private BigDecimal valor;
    private TipoPreco tipo;
    [...]
}
Depois, iremos criar tamb�m o ENUM TipoPreco:

public enum TipoPreco {
    EBOOK, IMPRESSO, COMBO;
}
Observa��o: A classe Preco e o enum TipoPreco devem ficar no pacote br.com.casadocodigo.loja.models.

Podemos fazer uma rela��o de produtos com seus pre�os em duas tabelas diferentes no banco de dados, usando o id do produto para estabelecer essa rela��o OneToMany, ou seja, um produto para v�rios pre�os. Mas neste contexto, isso n�o faria muito sentido, porque ter�amos um id para o pre�o e n�o precisamos disso, pois n�o vamos reutilizar o pre�o do produto.

Faremos essa rela��o de uma outra forma, marcaremos o atributo List<Preco> precos da classe Produto com a anota��o @ElementCollection indicando que este atributo � uma cole��o de elementos:

@Entity
public class Produto {
    [...]
    @ElementCollection
    private List<Preco> precos;
    [...]
}
E para que o Spring possa relacionar e portar os elementos de pre�o para dentro desta cole��o, devemos marcar a classe Preco com uma a anota��o Embeddable:

@Embeddable
public class Preco {
    [...]
}
Note que j� estamos tomando todos os cuidados para que os pre�os de nossos sejam flex�veis. A classe Produto tem uma lista de Preco e o enum TipoPreco tem os tipos de pre�os dos nossos produtos. O nosso form.jsp est� fixo com as tr�s op��es que deixamos dispon�veis. Vamos deix�-la mais flex�vel tamb�m.

Veja o c�digo do form atual:

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>T�tulo</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas" />
    </div>
    <div>
        <label>Ebook</label>
        <input type="text" name="ebook"/>
    </div>
    <div>
        <label>Impresso</label>
        <input type="text" name="impresso"/>
    </div>
    <div>
        <label>Combo</label>
        <input type="text" name="combo"/>
    </div>
    <button type="submit">Cadastrar</button>
</form>
J� que teremos uma lista de pre�os, podemos fazer um forEach nessa lista e exibir todos os pre�os de forma din�mica. O arquivo form.jsp ficar� assim:

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>T�tulo</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas" />
    </div>


    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label>
            <input type="text" name="precos[${status.index}].valor" />
            <input type="hidden" name="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>


    <button type="submit">Cadastrar</button>
</form>
Perceba que estamos fazendo um forEach com JSTL em uma cole��o ou lista que se chama tipos e acessando cada tipo de pre�o atrav�s da vari�vel tipoPreco. Estamos tamb�m usando o index da varStatus="status" que serve como uma esp�cie de contador.

Mas antes de utilizarmos a lista de tipoPreco, temos que fazer uma pequena altera��o no ProdutosController. Teremos que mudar o m�todo form para retornar um objeto do tipo ModelAndView.

@RequestMapping("/produtos/form")
    public ModelAndView form(){

        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }
Reparem que no construtor de ModelAndView passamos o endere�o da View para que o Spring entenda qual o arquivo que ele dever� retornar ao navegador.

Observa��o: Para que as tags da JSTL funcionarem, lembre-se de fazer o importe da taglib logo ap�s a diretiva de p�gina JSP no in�cio do arquivo. Observe:

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
[...]
Observa��o: Caso n�o conhe�a a JSTL, recomendamos que fa�a o curso de Java e JSTL: Tags para facilitar o desenvolvimento JSP dispon�vel aqui no Alura.

Nosso la�o(forEach), manipula o html do formul�rio para criar os campos de tipos de pre�os, e o resultado deste la�o � algo como:

<div>
    <label>EBOOK</label>
    <input type="text" name="precos[0].valor" />
    <input type="hidden" name="precos[0].tipo" value="EBOOK" />
</div>

<div>
    <label>IMPRESSO</label>
    <input type="text" name="precos[1].valor" />
    <input type="hidden" name="precos[1].tipo" value="IMPRESSO" />
</div>

<div>
    <label>COMBO</label>
    <input type="text" name="precos[2].valor" />
    <input type="hidden" name="precos[2].tipo" value="COMBO" />
</div>
Perceba que no name dos inputs do formul�rio, estamos usando: precos[numero].valor e precos[numero].tipo. Quando enviarmos nosso formul�rio, o Spring ao fazer o bind dos atributos do Produto, ir� detectar que estamos passando valores para o atributo precos em determinadas posi��es da lista. Ele tamb�m detectar� que os valores s�o do tipo tipoPreco e ir� preencher corretamente a lista.

Note que quando fazemosprecos[numero].tipo, estamos acessando na lista de pre�os, o atributo tipo de um objeto do tipo Preco. E lembre-se que o tipo � recuperado da enum TipoPreco. O input do tipo hidden serve para que passemos o tipo do pre�o: Ebook, Impresso e Combo. Estes campos s�o ocultos ao usu�rio. N�o queremos que ele modifique os valores destes campos e insira informa��es inv�lidas sobre os tipos de pre�os em nosso sistema.

Teste cadastrar um novo produto agora. Tudo deve funcionar corretamente. Observe tamb�m que no console do Eclipse deve aparecer algo como:

console do Eclipse mostrando sa�da do Hibernate

Esta sa�da � do Hibernate mostrando o SQL gerado. Ela tamb�m indica que temos uma nova tabela em nosso banco de dados chamada Produto_precos. Mostra tamb�m que nesta tabela temos um campo Produto_id, que referencia a qual produto aquele pre�o se refere. Se acessamos nosso banco e fizermos um SELECT * from Produto_precos; teremos algo como a seguinte sa�da:

sa�da do select no banco de dados

Tipo: 0, 1 e 2? Como assim? N�o deveria ser Ebook, Impresso e Combo? Para responder essa pergunta, devemos lembrar que por padr�o o enum associa um texto a um n�mero, iniciando de zero. Ent�o, faz sentido sim. Essa associa��o depende da ordem dos elementos, sendo assim: 0 = Ebook, 1 = Impresso e 2 = Combo.

Assim terminamos de cadastrar nossos produtos e seus respectivos pre�os. Experimente cadastrar mais alguns itens, porque no pr�ximo cap�tulo iremos trabalhar com a listagem de produtos.


<h2>Utiliza��o do ModelAndView</h2>
Em diversos m�todos mapeados dos nossos controllers, costumamos retornar uma String para devolvermos uma p�gina assim que aquele m�todo for chamado. Entretanto, em alguns m�todos, ao inv�s de utilizarmos o retorno de String, retornamos a classe ModelAndView. Porque utilizamos a classe ModelAndView ao inv�s da String?
R: Quando utilizamos o ModelAndView, al�m retornar uma p�gina, temos a possibilidade de enviar objetos de qualquer classe para essas p�ginas. Em outras palavras, dessa forma somos capazes de exibir, por exemplo, as informa��es das nossas classes modelos.

--------------------------------------------------------------------------------------------------
<h1>Se��o 04 - Listando os Produtos</h1>

Nos �ltimos cap�tulos fizemos o cadastro completo dos produtos da nossa aplica��o e j� integramos esse cadastro com o banco de dados. Fizemos o formul�rio (form.jsp) ter os campos necess�rios para o cadastro de um novo produto. Fizemos tamb�m os campos dos tipos de pre�os serem criados dinamicamente atrav�s de um loop (forEach).

Criamos na classe Produto um atributo que guarda uma lista de pre�os. Tamb�m criamos a classe Preco que guarda o valor e o tipo do pre�o, sendo que, para o tipo do pre�o, usamos um enum chamado TipoPreco para guardar as op��es de pre�os que temos em nossa aplica��o, sendo elas: Ebook, Impresso e Combo.

Agora faremos a listagem desses produtos.

Para aproveitarmos um pouco um c�digo que j� temos, vamos copiar todo o c�digo que est� no form.jsp. Criar um novo arquivo JSP chamado lista.jsp no mesmo diret�rio onde est� o form.jsp e colar o c�digo do form.jsp no lista.jsp.

Como esta ser� uma p�gina que apenas lista nossos produtos, n�o precisamos do formul�rio, sendo assim, apague o c�digo referente ao formul�rio de cadastro (<form>). O c�digo restante deve algo assim:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do C�digo</title>
    </head>
    <body>

    </body>
</html>
Nesta p�gina ent�o, criaremos uma tabela onde ser�o listados os produtos usando os seguintes dados: T�tulo, descri��o e quantidade de p�ginas. Sendo assim, no corpo da p�gina (dentro da tag <body>) crie a estrutura b�sica da tabela, algo parecido com o c�digo:

[...]
<body>
    <table>
        <tr>
            <td>T�tulo</td>
            <td>Descri��o</td>
            <td>P�ginas</td>
        </tr>
    </table>
</body>
[...]
As tags table, tr, td representam a tabela (table), as linhas (tr) e as colunas (td). Esta ser� nossa tabela, esta primeira tr ser� a cabe�alho. As pr�ximas linhas, j� devem ser preenchidas com os dados dos produtos.

No cap�tulo anterior, conhecemos o forEach. O forEach foi usado para percorrer uma lista e criar os campos do formul�rio. Faremos algo parecido aqui. Vamos percorrer uma lista de produtos. Usaremos a mesma estrutura do forEach aqui.

Como cada uma das pr�ximas linhas da tabela ser� um produto. E em cada linha, vamos imprimir os dados do produto(titulo, descricao e paginas). Ent�o podemos fac�lmente escrever algo como:

[...]
<table>
    <tr>
        <td>T�tulo</td>
        <td>Descri��o</td>
        <td>P�ginas</td>
    </tr>

    <c:forEach items="${produtos}" var="produto">
        <tr>
            <td>${produto.titulo}</td>
            <td>${produto.descricao}</td>
            <td>${produto.paginas}</td>
        </tr>
    </c:forEach>
</table>
[...]
Vamos tamb�m adicionar um t�tulo nessa nossa p�gina, pra n�o ficar s� a tabela sem nenhuma descri��o. Usaremos a tag h1 antes da tabela com o t�tulo: Lista de Produtos. <h1>Lista de Produtos</h1>.

J� temos quase tudo pronto, precisamos somente fazer com que nosso ProdutoDAO acesse o banco de dados e crie essa lista de produtos que queremos exibir. E por �ltimo fazer o mapeamento no ProdutosController retornando a lista de produtos para a view lista.jsp.

Crie na classe ProdutoDAO o m�todo listar que usuar� o EntityManager para criar uma consulta no banco de dados e retornar uma lista de produtos. O c�digo � parecido com:

public List<Produto> listar(){
    return manager.createQuery("select p from Produto p", Produto.class).getResultList();
}
O getResultList ir� criar uma lista com os resultados da consulta ao banco de dados.

Nosso segundo passo � fazer com que nosso ProdutosController use o m�todo listar do ProdutoDAO e retornar essa lista de produtos para a view.

public ModelAndView listar(){
    List<Produto> produtos = produtoDao.listar();
    ModelAndView modelAndView = new ModelAndView("/produtos/lista");
    modelAndView.addObject("produtos", produtos);
    return modelAndView;
}
Nenhuma surpresa at� aqui n�o �? Estamos usando recursos que j� aprendemos anteriormente. Acessando o banco de dados, criando um ModelAndView para anexar objetos que ser�o usados em nossa view e retorando a lista.

O ModelAndView � uma classe do Spring que faz um relacionamento de um modelo (model) com uma visualiza��o (view) . Este al�m de poder disponibilizar um outro objeto qualquer para a view pode fazer outras opera��es, como redirecionamento de p�ginas, entre outras. Veremos mais sobre ModelAndView posteriormente.

Vamos fazer com que a lista de produtos fique na url /produtos e faz sentido, certo? Quando acessamos /produtos queremos ver uma lista de produtos. Agora adicionaremos esse mapeamento de rota. O metodo listar deve ficar assim:

@RequestMapping("/produtos")
public ModelAndView listar(){
    List<Produto> produtos = produtoDao.listar();
    ModelAndView modelAndView = new ModelAndView("/produtos/lista");
    modelAndView.addObject("produtos", produtos);
    return modelAndView;
}
Com tudo isso pronto, podemos iniciar o servidor e tentar acessar a lista de produtos em localhost:8080/casadocodigo/produtos/. Mas algo parece n�o funcionar bem, temos um erro no console. veja a mensagem de erro:

Ambiguous mapping found. Cannot map 'ProdutosController'.
Isso acontece porque temos duas rotas em nosso controller apontando para a mesma url. Quando o acesso for feito, o Spring n�o vai saber qual m�todo chamar do controller. Vamos resolver isso!

Podemos diferenciar as rotas simplemente mudando a url que o m�todo mapeia. Mas vamos diferenciar as rotas de uma outra forma. Vamos diferenciar pelos m�todos usados pelo protocolo HTTP.

Quando acessamos uma p�gina, digitando uma url ou clicando em links, estamos fazendo um GET. Quando estamos clicando em nosso bot�o de cadastrar produtos por exemplo, geralmente estamos fazendo um POST. Se voc� verificar o formul�rio (form.jsp) ver� o atribudo method com o valor POST.

Para resolvermos o problema das todas duplicadas s� precisaremos adicionar um novo parametro no @RequestMapping usando o enum RequestMethod do Spring, definindo assim qual m�todo HTTP vai ser usado para chamar aquele m�todo do controller.

Quando fizermos um GET para /produtos o Spring deve chamar o m�todo listar do nosso ProdutosController . Quando fizermos um POST para /produtos ele deve chamar o gravar, enviando um produto para ser gravado no banco de dados.

Modificaremos ent�o as anota��es de @RequestMapping do m�todo gravar e listar do nosso ProdutosController, fazendo essa diferencia��o. Veja o c�digo como fica:

@RequestMapping(value="/produtos", method=RequestMethod.POST)
    public String gravar(Produto produto){
        [...]
    }


@RequestMapping(value="/produtos", method=RequestMethod.GET)
public ModelAndView listar(){
    [...]
}
Tente iniciar o servidor novamente e acessar a p�gina de produtos, tudo deve funcionar normalmente.

Mudando Enconding do Spring.
Note que nossa lista de produtos aparece com alguns caracteres estranhos. Isso acontece por que o servidor n�o conhece o encoding da requisi��o, ent�o ele troca os caracteres especiais e com acentos por outros caracteres.

Carasteres estranhos na listagem dos produtos

H� v�rias formas de resolver este problema, mas vamos usar uma das mais simples. Criando Filtros! Dessa forma, ao receber a requisi��o o Spring filtra a requisi��o com o encoding que vamos configurar. Em nossa classe ServeltSpringMVC dentro do pacote br.com.casadocodigo.loja.conf, vamos criar mais um m�todo de configura��o do Spring.

Exite um m�todo chamado getServletFilters usado pelo Spring que espera receber um array de filtros. Ent�o vamos criar um CharacterEncodingFilter, definir o encoding deste filtro usando o valor "UTF-8", adicionar este filtro ao array de filtros e o retornar esse array para o Spring. Use os imports import javax.servlet.Filter e org.springframework.web.filter.CharacterEncodingFilter.

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
    }
}
Agora quando cadastrarmos novos produtos, os caracteres estar�o normais.

Carasteres normais na listagem dos produtos

Melhorando rotas no controller
Vamos fazer agora um pequeno ajuste em nosso ProdutosController para deixar o mapeamento das rotas mais simples. Note que em todos os m�todos usamos a anota��o @RequestMapping passando sempre /produtos.

Para que n�o precisemos ficar passando /produtos em todos os m�todos do controller, vamos p�r essa anota��o em nossa classe. Assim podemos remover o /produtos de todos os m�todos e o Spring se encarrega de carregar os mapeamentos baseados no mapeamento da classe. Sendo assim nossa classe ProdutosController deve ficar parecida com o c�digo abaixo:

@Controller
@RequestMapping("produtos")
public class ProdutosController {
    [...]

    @RequestMapping("/form")
    public ModelAndView form(){
        [...]
    }

    @RequestMapping(method=RequestMethod.POST)
    public String gravar(Produto produto){
        [...]
    }


    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView listar(){
        [...]
    }

}
Dessa forma, se acessamos /produtos via GET, o m�todo listar ser� chamado. Se o acesso for via POST o m�todo gravar ser� chamado. E o /produtos/form continua chamando o m�todo form. Bem mais simples, certo?

Teste novamente as p�ginas de listagem e de cadastro de produtos. Tudo deve estar funcionando normalmente. Cadastre novos produtos e verifique que os caracteres estranhos tamb�m n�o aparecem mais.


<h2>Utiliza��o de m�todos de requisi��o do HTTP</h2>
At� o momento, est�vamos utilizando a anota��o @RequestMapping apenas enviando a String que desejamos que ele mapeie. Entretanto, nesse cap�tulo, fizemos o uso do atributo method enviando como par�metro os enuns RequestMethod.GET e RequestMethod.POST, e ent�o, obtemos os seguintes resultados:

@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @RequestMapping(method = RequestMethod.POST)
    public String gravar(Produto produto) {
            //C�digo
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
            //C�digo
    }

        // m�todos
}
Considerando o exemplo, escolha a op��o que descreve o que significa o atributo method e o motivo de utilizarmos ele para esse caso:

R:Quando utilizamos o atributo method, significa que estamos enviando o m�todo de requisica��o do HTTP. Para esse caso, utilizamos esse atributo justamente para que fosse poss�vel ter o mesmo mapeamento para duas funcionalidades distintas.


------------------------------------------------------------------------------------------------
<h1>Se��o 05 - Redirect com Escopo de Flash</h1>

O cadastro de produtos da nossa aplica��o j� funciona, mas da mesma forma que melhoramos as rotas no cap�tulo passado, vamos melhorar outro ponto da aplica��o neste momento.

� muito comum que ap�s o cadastro de produtos, por exemplo, em vez de ser mostrada uma p�gina com a mensagem de cadastro realizado com sucesso, sejamos levados novamente � lista com todos os produtos. Faremos essa modifica��o agora.

Para que ap�s o cadastro de produtos, sejamos levados � p�gina de listagem, devemos ent�o modificar o m�todo gravar no ProdutosController, para que este m�todo chame o m�todo listar em vez de retornar a view ok.jsp.

Nosso c�digo atualmente est� assim:

@RequestMapping(method=RequestMethod.POST)
public String gravar(Produto produto){
    System.out.println(produto);
    produtoDao.gravar(produto);
    return "produtos/ok";
}
Vamos ent�o, simplesmente mudar a rota do retorno do m�todo para o endere�o /produtos. Nosso c�digo ficar� assim:

@RequestMapping(method=RequestMethod.POST)
public String gravar(Produto produto){
    System.out.println(produto);
    produtoDao.gravar(produto);
    return "produtos";
}
Com essa mudan�a, quando cadastrarmos um novo produtos, o m�todo gravar deve salvar o produto no banco de dados e ent�o o Spring deve chamar o m�todo listar que � respons�vel por atender o endere�o /produtos. Vamos fazer um teste e realizar um cadastro em "novo produto".

![Erro 404 - p�gina produtos.jsp n�o encontrada](https://s3.amazonaws.com/caelum-online-public/SpringMVC+-+criando+webapp/springmvc_i_webaapp_5_1_pagina_produtos_nao_encontrada.png)
O que acontece? Vemos uma mensagem de Erro 404.

A p�gina produtos.jsp n�o foi encontrada, porque realmente n�o temos uma p�gina produtos.jsp, temos uma p�gina lista.jsp.

O Spring, quando retornamos uma String procura uma p�gina com o mesmo nome da String que retornamos, por isso ele est� procurando uma p�gina chamada produtos.jsp.

N�o era o que quer�amos... N�s queremos ver a listagem de produtos que j� est� pronta na nossa p�gina lista.jsp. Sabendo disso, vamos chamar o m�todo listar do ProdutosController diretamente, isto far� com que o Spring carregue a listagem dos produtos e mostre a listagem no navegador.

Logo, iremos mudar o retorno do nosso m�todo gravar para que seja o mesmo do m�todo listar. E depois, chamar o m�todo listar com o return. Veja como ficou o c�digo com as nossas modifica��es.

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto){
    System.out.println(produto);
    produtoDao.gravar(produto);
    return listar();
}
Observe que o retorno do m�todo muda, pois o m�todo listar retorna um objeto do tipo ModelAndView. Vamos cadastrar um novo produto agora. Ap�s o cadastro, devemos ver a listagem de produtos com o nosso novo produto.

cadastrando novo produto

produto sendo listado depois do cadastro

Experimente apertar F5 ap�s o cadastro de algum produto.

p�gina de listagem fazendo resubmiss�o de formul�rio

Veja que o navegador nos questiona se queremos resubmeter o formul�rio. Isso quer dizer que se confirmarmos, ele vai enviar os dados do produto novamente e teremos o produto recadastrado. Duplica��o de produtos n�o � bom!

Acontece que o navegador ainda est� guardando os dados do post do formul�rio. Apesar de ser um problema real, n�o podemos culpar o navegador, pois este � o funcionamento normal no caso de posts de formul�rio. Modificaremos ent�o este comportamento em nossa aplica��o.

Resolveremos isto atrav�s de recursos do protocolo HTTP. J� usamos outros recursos do protocolo (GET e POST). Agora, usaremos um recurso chamado de redirect, que passa um status para o navegador carregar uma outra p�gina e esquecer dos dados da requisi��o anterior. O status que o navegador recebe � um 302.

Para isso devemos mudar a �ltima linha do m�todo gravar, que agora vai retornar um novo ModelAndView usando como rota o redirect:produtos.

Ap�s as modifica��es, o m�todo gravar ficar� igual ao que est� abaixo:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto){
    System.out.println(produto);
    produtoDao.gravar(produto);
    return new ModelAndView("redirect:produtos");
}
Teste cadastrar um novo produto e atualizar a p�gina de listagem depois do cadastro. O navegador n�o nos pede mais confirma��o de resubmiss�o do formul�rio e tamb�m n�o duplicar� os produtos na listagem.

Nossa aplica��o ainda precisa de mais um ajuste. Ela n�o mostra mais a mensagem de produto cadastrado com sucesso como t�nhamos na view ok.jsp. Como � uma simples mensagem, usaremos um recurso do Spring que nos permite enviar informa��es entre requisi��es. Esse recurso � o RedirectAttributtes.

O m�todo gravar agora deve receber um objeto do tipo RedirectAttributes fornecido pelo Spring. Usaremos ent�o esse objeto para adicionar um atributo do tipo Flash (usando o m�todo addFlashAttribute deste objeto), passando assim a uma chave sucesso e o valor dessa chave que � Produto cadastrado com sucesso!.

Veja como fica nosso m�todo gravar com esta nova modifica��o:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes){
    System.out.println(produto);
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso!");
    return new ModelAndView("redirect:produtos");
}
Observa��o: Atributos do tipo Flash t�m uma particularidade que � interessante observar. Eles s� duram at� a pr�xima requisi��o, ou seja, transportam informa��es de uma requisi��o para a outra e ent�o, deixam de existir.

Note que usamos um RedirectAttributes. Isto faz muito sentido, j� que ap�s o post iremos redirecionar a p�gina. A pr�tica de fazer redirecionamentos ap�s posts tem um nome bem conhecido, Always redirect after post (em portugu�s, significa Sempre redirecione ap�s post).

Agora para exibirmos esta mensagem em nossa listagem, devemos modificar o lista.jsp para exibir o RedirectAttributes, que � acessado atrav�s da chave message, veja como fica nosso lista.jsp:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do C�digo</title>
</head>
<body>
    <h1>Lista de Produtos</h1>
    <p> ${sucesso} </p>
    <table>
        <tr>
            <td>T�tulo</td>
            <td>Descri��o</td>
            <td>P�ginas</td>
        </tr>

        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td>${produto.titulo}</td>
                <td>${produto.descricao}</td>
                <td>${produto.paginas}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
Veja como ficou nossa mensagem de sucesso:

listagem sem pedir resubmiss�o de formulario e com menssagem de sucesso

Recapitulando:
At� aqui fizemos nossa listagem de produtos, que usa o DAO para recuperar os produtos do banco de dados. Simplificamos nossas rotas assinando o ProdutosController com a anota��o RequestMapping('produtos') e diferenciamos os m�todos listar e gravar que mapeiam a mesma rota, atrav�s dos m�todos usados pelo protocolo HTTP (GET e POST).

Tamb�m aprendemos a redirecionar de uma p�gina para outra. Vimos o conceito de Always redirect after post (que significa, "Sempre redirecione depois de post"). Evitando que dados sejam reenviados para nossa aplica��o, duplicando registros em nosso banco de dados.

Vimos tamb�m como podemos enviar mensagens de uma requisi��o para outra, havendo redirecionamento de p�ginas com o Flash, usando o RedirectAttributes e o m�todo addFlashAttribute.


<h2>Escopo de Flash</h2>
O que � o Flash Scoped que usamos atrav�s do objeto RedirectAttributes do Spring?
R: O Flash Scoped � um escopo r�pido. Os objetos que adicionamos nele atrav�s do m�todo addFlashAttribute ficam vivos de um request para outro, enquanto o navegador executa um redirect (usando o c�digo de status 302).


<h2>Always Redirect After Post</h2>
Por que devemos sempre fazer um redirect ap�s o formul�rio enviar um POST para nossos sistemas?
R:Pois ao fazer F5 o navegador repete o ultimo request que ele realizou, e quando esse resquest � um POST, todos os dados que foram enviados tamb�m s�o repetidos. Se voc� realizou um insert no banco de dados, esse insert ser� repetido. Ou mesmo se realizou alguma opera��es que envia e-mail, por exemplo, o e-mail ser� enviado duas vezes ao pressionar F5.

Para evitar qualquer problema de dados reenviados, realizamos um redirect ap�s um formul�rio com POST.

------------------------------------------------------------------------------------------------------
<h1>Se��o 06 - Valida��o e convers�o de dados</h1>

At� aqui fizemos bastante coisa na nossa aplica��o. Cadastramos livros, exibimos uma mensagem de sucesso e fizemos nossos livros aparecerem em uma listagem simples, mas que demonstra que tudo est� funcionando perfeitamente.

Agora chegamos em um ponto em que precisamos validar os dados enviados pelo usu�rio. Esta valida��o � muito importante. Como seria se algu�m tentasse cadastrar livros sem preencher os dados do formul�rio? Tente fazer isso pra ver o que acontece.

Erro HTTP 400 ao cadastrar produto

Erro 400 - The request sent by the client was syntactically incorrect.
A requisi��o foi enviada com uma sintaxe errada. Como assim? Tem algum problema acontecendo na hora de enviar os dados. Isso acontece porque n�o estamos enviando dados. Para corrigir isso, devemos valid�-los e para isso existem algumas formas.

A primeira forma seria validar com JavasSript, mas como esta aconteceria no navegador seria menos confi�vel, pois o usu�rio poderia modificar o c�digo no navegador nas ferramentas do desenvolvedor. N�s podemos fazer a valida��o em nosso c�digo Java, que � mais confi�vel porque o usu�rio n�o tem acesso a esse c�digo.

O Controller de Produto, ou seja ProdutosController, parece ser um bom lugar para validar os dados dos produtos. E o m�todo gravar parece ser o lugar onde precisamos de uma valida��o. � certo validar os dados antes de salvar o produto no banco de dados?

Valida��es geralmente envolvem ifs, que avaliam uma condi��o e garantem se est� tudo certo. Nosso m�todo grava atualmente est� assim:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes){
    System.out.println(produto);
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Vamos primeiro tirar esse System.out.println(produto), porque ele n�o � mais necess�rio. Ent�o vamos fazer um if antes de salvar o produto, verificando se o t�tulo � null ou vazio. Devemos validar pelo menos o t�tulo, a descri��o e o pre�o, mas vamos come�ar com o t�tulo. Caso um dos casos da valida��o d� false, retornaremos para o formul�rio. Veja como fica nosso c�digo com o if:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes){
    if(produto.getTitulo() == null || produto.getTitulo().isEmpty()){
        return form();
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Vamos fazer dois testes agora, um com o t�tulo preenchido e outro, sem preench�-lo. Lembre-se de deixar os outros campos em branco, pois estamos validando somente o t�tulo. Veremos o que acontece.

Erro HTTP 400 ao cadastrar produto

Nos dois casos que testamos agora, teremos o mesmo erro de antes e n�o voltaremos para o formul�rio. Por qu�?

O erro acontecer� antes mesmo de chegar ao nosso c�digo de valida��o. O Spring n�o est� conseguindo fazer o bind dos dados do formul�rio para o nosso objeto produto. Vejamos ent�o os atributos da nossa classe Produto.

@Entity
public class Produto {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String descricao;
    private int paginas;

    @ElementCollection
    private List<Preco> precos;
    [...]
}
Se olharmos bem, temos o atributo paginas que � do tipo int. Este � um tipo primitivo, ele n�o pode receber uma valor null. No entanto, os outros como String e List podem, pois s�o objetos. O id n�o nos importa nesse momento, porque � gerenciado pelo Spring. Vamos, ent�o, enviar o formul�rio preenchendo somente o n�mero de p�ginas.

Formul�rio vazio ap�s tentar enviar dados incorretos

Agora sim, voltamos para o nosso formul�rio como fizemos em nossa valida��o. Perceba que apesar de preencher o n�mero de p�ginas e o formul�rio ter enviado os dados sem problemas, n�o temos nenhuma mensagem de erro.

O problema da valida��o ser feita desta forma � que se for preciso validar mais campos, aquele if em nosso controller vai ficar muito grande e isso n�o � bom. Pior ainda se for preciso validar o produto em outra parte da aplica��o. Ter�amos que ficar copiando e colando c�digo. Sabemos que isso tamb�m n�o � bom. A melhor ideia � isolar o c�digo em outro lugar e sempre que precisarmos, us�-lo.

Vamos criar ent�o uma classe para esse c�digo, que chamaremos de ProdutoValidation e ela ficar� no pacote br.com.casadocodigo.loja.validation. Esta classe ter� um m�todo boolean chamado valida que far� a mesma coisa que nosso if do controller e retorna true caso o produto tenha os dados corretos e false caso n�o tenha. Nossa classe ProdutosValidation ficar� assim:

public class ProdutoValidation {
    public boolean valida(Produto produto) {
        if (produto.getTitulo() == null || produto.getTitulo().isEmpty()) {
            return false;
        }
        return true;
    }
}
Este c�digo ter� o mesmo efeito do outro que estava no nosso ProdutosController e continuar� com um problema que quase n�o notamos. Por hora, estamos validando somente o t�tulo, mas se fizermos a valida��o da descri��o e depois tentarmos cadastrar um produto sem nenhuma dessas informa��es, como vamos saber qual delas deu erro? O c�digo n�o nos informa isso. Apesar de funcionar, o c�digo n�o nos ajuda muito. Ent�o, vamos usar algo do Spring. O Framework deve poder nos ajudar. Neste caso, o Spring tem uma classe chamada ValidationUtils, com alguns m�todos que validam dados.

Dentre os m�todos dispon�veis em ValidationUtils, teremos um que se encaixa exatamente com nosso caso, que � o rejectIfEmpty, que traduzido para portugu�s significa "rejeite se for vazio". � exatamente o que queremos. Este m�todo recebe tr�s par�metros: Um objeto errors que cont�m os erros da valida��o; O nome do campo que iremos validar passado como String; e um errorCode que tamb�m � passado como String, mas que � reconhecido pelo Spring. Neste �ltimo par�metro, usaremos o errorCode com o valor "field.required" para informar ao Spring que aquele campo � obrigat�rio.

Note que o objeto errors n�o � gerenciado por n�s, mas sim pelo Spring. Nosso m�todo agora n�o precisa mais retornar nenhum valor, j� que o objeto errors ter� as informa��es se a valida��o falhou ou n�o. Vejamos como fica o m�todo valida ap�s essas modifica��es.

public void valida(Produto produto, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
}
Bem mais simples n�o acha? Vamos aproveitar o momento e j� validar da mesma forma o nosso campo descricao. Veja como fica:

public void valida(Produto produto, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
    ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
}
Para validar o campo paginas n�s precisamos de uma outra estrat�gia, pois nosso campo precisa de um n�mero maior que zero n�o � verdade? Neste caso, teremos que fazer um if verificando isso. Caso o n�mero de p�ginas seja menor ou igual a zero, usaremos o objeto errors para rejeitar o valor, passando tamb�m o errorCodede campo obrigat�rio. Nosso m�todo valida ficar� dessa forma:

public void valida(Produto produto, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
    ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
    if(produto.getPaginas() <= 0){
        errors.rejectValue("paginas", "field.required");
    }
}
Est� quase tudo pronto para nossa valida��o ser finalizada. Iremos agora usar a valida��o em nosso controller e mostrar os devidos erros em nossa view. Para n�o nos preocuparmos em ficar fazendo ifs em nosso c�digo, podemos dizer para o Spring usar a nossa classe de valida��o para validar o produto. Para isso precisamos de algumas configura��es.

Vamos usar a especifica��o do Java chamada Bean Validation. A implementa��o desta especifica��o que vamos usar ser� a Hibernate Validator . Usaremos algumas bibliotecas para facilitar nosso trabalho. No pom.xml adicionaremos essas depend�ncias:

<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>1.0.0.GA</version>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>4.2.0.Final</version>
</dependency>
Nosso pr�ximo passo � configurar nosso projeto para usar essas bibliotecas e fazer com que o Spring passe a usar nossa classe ProdutoValidation para validar nosso produto. No ProdutosController vamos usar uma nova anota��o. No m�todo gravar, antes da assinatura do Objeto produto adicione a anota��o @valid do pacote: javax.validation. A assinatura do m�todo deve ficar dessa forma:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(@Valid Produto produto, RedirectAttributes redirectAttributes){
    [...]
}
Isso ainda n�o � o suficiente para nossa valida��o funcionar. Agora precisamos criar um m�todo em nosso controller chamado InitBinder que ter� uma anota��o com o mesmo nome do m�todo @InitBinder. Este m�todo recebera um objeto do tipo WebDataBinder que chamaremos apenas de binder. O objeto binder tem um m�doto chamado addValidators que recebe uma inst�ncia de uma classe que implemente a interface Validator do pacote org.springframwork.validation.

Observa��o: O Binder, por assim dizer, � o respons�vel por conectar duas coisas. Por exemplo, os dados do formul�rio com o objeto da classe Produto, como j� fizemos anteriormente.

Dito isso, vamos implementar esse m�todo InitBinder em nosso ProdutosController, ent�o. Nosso c�digo deve ficar parecido com esse:

@InitBinder
public void InitBinder(WebDataBinder binder){
    binder.addValidators(new ProdutoValidation());
}
Com este passo pronto, notamos que o Eclipse ir� reclamar que o m�todo addValidators n�o � um objeto Validator. Isso � justo, j� que nossa classe ProdutoValidation n�o implementa essa interface. Vamos ent�o modificar nossa classe ProdutoValidation para que ela implemente a interface correta. A interface Validator correta � a que est� no pacote org.springframework.validation.Fazendo com que a nossa classe ProdutoValidation implemente esta interface, adicionaremos os m�todos da interface, nossa classe fica dessa forma:

public class ProdutoValidation implements Validator {
    public void valida(Produto produto, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
        if(produto.getPaginas() <= 0){
            errors.rejectValue("paginas", "field.required");
        }
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return false;
    }

    @Override
    public void validate(Object arg0, Errors arg1) {

    }
}
Perceba que o m�todo Validate � onde realmente acontecer� a valida��o. Este m�todo se parece bastante com o m�todo valida, criado anteriormente. Ent�o, vamos usar o m�doto da interface. Primeiro renomearemos os par�metros, arg0 se chamar� target, este ser� o objeto alvo da valida��o. O arg1 ser� o errors igual ao m�todo valida. Depois deste passo, vamos copiar o c�digo dentro do m�todo valida e col�-lo no m�todo validate. Podemos apagar o m�todo valida depois disso. At� aqui nosso c�digo deve estar parecido com esse:

public class ProdutoValidation implements Validator {
    @Override
    public boolean supports(Class<?> arg0) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        if(produto.getPaginas() <= 0){
            errors.rejectValue("paginas", "field.required");
        }
    }
}
O Eclipse vai reclamar, pois no if estamos usando um objeto produto e n�o temos mais esse objeto em m�os. O que podemos fazer ent�o? N�o podemos simplesmente mudar o nome target porque estamos recebendo um objeto do tipo Object agora. A forma mais simples � fazer um cast antes do if. Nosso c�digo ficar� assim ent�o:

public class ProdutoValidation implements Validator {
    @Override
    public boolean supports(Class<?> arg0) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        Produto produto = (Produto) target;    
        if(produto.getPaginas() <= 0){
            errors.rejectValue("paginas", "field.required");
        }
    }
}
O m�todo supports tamb�m precisa ser implementado. A implementa��o desse m�todo indica a qual classe a valida��o dar� suporte. Sabemos que ser� a classe Produto. Vamos ent�o fazer essa implementa��o da seguinte forma:

public class ProdutoValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Produto.class.isAssignableFrom(clazz);
    }
}
O que esse c�digo faz � verificar se o objeto recebido para a valida��o tem uma assinatura da classe Produto. Com isso o Spring pode verificar se o objeto � uma inst�ncia daquela classe ou n�o.

Um �ltimo passo � necess�rio agora, para nossa valida��o estar completa. Falta recebermos o resultado da verifica��o, da valida��o em s� em nosso controller e verificar se houve algum erro. Faremos isto recebendo na assinatura do nosso m�todo gravar um objeto do tipo BindingResult que tem um m�todo chamado hasErrors, que informa se houve erros de valida��o ou n�o. Com isso poderemos fazer um simples if, para ver se tudo funciona bem. Caso a valida��o n�o tenha encontrado erros, salvaremos o produto. Por�m, se houver erros, voltaremos para o formul�rio. Nosso c�digo no m�todo gravar ficar� dessa forma:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(@Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){
    if(result.hasErrors()){
        return form();
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Note que o BindingResult vem logo ap�s o atributo que est� assinado com a anota��o @Valid, essa ordem n�o � por acaso, precisa ser desta forma para que o Spring consiga fazer as valida��es da forma correta. Teste o formul�rio mais uma vez!

Agora podemos enviar o formul�rio sem preencher nenhum dos campos e nada acontecer�. Ainda falta mostrar as informa��es de erro - as mensagem. Mas logo faremos isto. At� o momento, basta acreditar que a valida��o est� acontecendo.

<h2>Validator do Spring MVC</h2>
Por qu� utilizamos o Validator do Spring ao inv�s de fazer as valida��es manualmente?
R: Quando utilizamos o Validator do Spring, temos a possibilidade de configurar o controller para que utilize automaticamente o validador todas as vezes que for necess�rio validar a classe desejada

Quando utilizamos o Validator do Spring, temos a possibilidade de configurar o controller para que utilize automaticamente o validador todas as vezes que for necess�rio validar a classe desejada, ou seja, a classe que precisa ser validada (anotada com @Valid). Vale lembrar que o uso do InitBinder � necess�rio para que seja poss�vel essa valida��o autom�tica.

------------------------------------------------------------------------------------------------------
<h1>Se��o 07 - Mais Valida��es</h1>

Terminamos a aula anterior com as valida��es j� funcionando, mesmo que n�o exibindo as mensagens. Faremos isto agora de uma forma muito simples. Primeiro vamos abrir nosso arquivo form.jsp e adicionar uma nova taglib. Veja como est� nosso form.jsp :

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do C�digo</title>
</head>
<body>
    <form action="/casadocodigo/produtos" method="post">
        <div>
            <label>T�tulo</label> 
            <input type="text" name="titulo" />
        </div>
        <div>
            <label>Descri��o</descricao>
            <textarea rows="10" cols="20" name="descricao"></textarea>
        </div>
        <div>
            <label>P�ginas</label> 
            <input type="text" name="paginas" />
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label> <input type="text"
                    name="precos[${status.index}].valor" /> <input type="hidden"
                    name="precos[${status.index}].tipo" value="${tipoPreco}" />
            </div>
        </c:forEach>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
A taglib que adicionaremos ser� uma do pr�prio Spring. A uri da taglib ser�: http://www.springframework.org/tags/form e o prefix ser� form. Dessa forma teremos nosso form.jsp da seguinte forma:

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do C�digo</title>
</head>
<body>
    <form action="/casadocodigo/produtos" method="post">
        [...]
    </form>
</body>
</html>
Com a taglib adicionada em nossa p�gina JSP, podemos ent�o usar uma tag dessa biblioteca para exibir as mensagens de erro. A tag usada para isso � a tag form:errors e ela tem um atributo chamado path que indica de qual atributo queremos obter a mensagem de erro. Sendo assim, podemos escrever algo do tipo: <form:errors path="produto.titulo" />. Simples! N�o? Vamos fazer o mesmo para os outros campos, colocando a tag acima do campo a que o erro se refere. Vejamos como o c�digo do formul�rio ficar�:

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>T�tulo</label> 
        <form:errors path="produto.titulo" />
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <form:errors path="produto.descricao" />
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>P�ginas</label>
        <form:errors path="produto.paginas" /> 
        <input type="text" name="paginas" />
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label> <input type="text"
                name="precos[${status.index}].valor" /> <input type="hidden"
                name="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>
    <button type="submit">Cadastrar</button>
</form>
Agora nossas mensagens devem aparecer no formul�rio caso cadastremos um produto que n�o seja v�lido, ou seja, sem t�tulo, descri��o ou sem p�ginas. Vamos test�-lo ent�o. Submeta o formul�rio sem preencher os campos corretamente!

Erro 500. mensagens n�o encontradas

Deu erro? Como assim? Veja a mensagem de erro: No message found under code field.required.produto.titulo. O Spring n�o est� encontrando nossas mensagens de erro. Em lugar nenhum definimos isso. Se voc� j� conhece, existem os arquivos properties que s�o comuns de serem usados nesses casos. Vamos criar ent�o um properties para deixarmos as mensagens para o formul�rio neste arquivo.

Na pasta WEB-INF vamos criar um arquivo de texto chamado messages.properties e associar as chaves dos erros aos valores, ou seja, associar as chaves dos erros �s mensagens. Dentro desse arquivo, podemos ter algo do tipo field.required.produto.titulo = O Campo t�tulo � obrigat�rio.

Por hora, para testarmos, vamos deixar s� a mensagem referente ao t�tulo. Depois adicionaremos o restante dos campos. Agora, precisamos configurar o Spring para que ele encontre esse nosso arquivos de mensagens. J� temos uma classe de configura��o: a AppWebConfiguration.

Na classe AppWebConfiguration criaremos um novo m�todo que carregar� nossos arquivos de mensagens. Este m�todo se chama messageSource e retorna um objeto do tipo MessageSource. Dentro deste m�todo criaremos um objeto do tipo ReloadableResourceBundleMessageSource que chamaremos de messageSource. Neste objeto, iremos definir tr�s propriedades: setBaseName com o valor /WEB-INF/message que ter� o nome base dos nossos resources. O setDefaultEncoding com o valor UTF-8 para evitar o problema de caracteres estranhos que j� vimos outras vezes e o setCacheSeconds para que o Spring recarregue o arquivo de tempos em tempos com o valor 1.

Esta �ltima propriedade � muito �til em desenvolvimento pois poderemos ficar sempre modificando as mensagens sem se preocupar em ficar refazendo reload do arquivo manualmente. Nosso m�todo fica da seguinte forma: Observa��o: Lembre-se de anotar esse m�todo com a anota��o @Bean para que o Spring possa reconhecer essa configura��o.

@Bean
public MessageSource messageSource(){
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("/WEB-INF/messages");
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setCacheSeconds(1);
    return messageSource;
}
Agora com a configura��o correta, vamos tentar mais uma vez? Vamos enviar o formul�rio mais uma vez sem preencher nenhum dos campos. Deve aparecer alguma mensagem agora, correto?Erro 500 - field.required n�o encontrado

O erro 500 continua mesmo tendo configurado tudo. Embora o n�mero do erro seja o mesmo, o erro agora � outro. O Spring n�o est� encontrando a mensagem referida com a chave field.required. Vamos adicionar ent�o a chave em nosso messages.properties e aproveitar o momento para p�r as outras mensagens - uma para a descri��o, que n�o pode ser vazia, e a outra para a quantidade de p�ginas, que deve ser superior a zero. Nosso arquivo messages.properties deve ficar dessa forma:

field.required = Campo � obrigat�rio
field.required.produto.titulo = O Campo t�tulo � obrigat�rio
field.required.produto.paginas = Informe o n�mero de p�ginas
field.required.produto.descricao = O Campo descri��o � obrigat�rio
Agora temos todas as mensagens prontas. A field.required ser� a mensagem mais gen�rica do nosso sistema, as outras ser�o mais espec�ficas. Vamos tentar de novo ent�o com estas novas modifica��es.Observa��o: Qualquer modifica��o nos textos do arquivo messages.properties pode ser feita sem precisar reiniciar o servidor. Nossa configura��o de reload do arquivo j� recarrega o arquivo autom�ticamente.

caracteres estranhos e mensagem de erro de convers�o de dados

Nossas mensagens aparecem! Mas que estranho, mesmo configurando os caracteres para ter a codifica��o UTF-8 eles aparecem estranhos na p�gina e note uma mensagem de erro aparece no campo de p�ginas. Vamos resolver primeiro o problema dos caracteres.

O problema dos caracteres acontece por que o Eclipse por si s�, codifica os arquivos em uma codifica��o especifica que por padr�o n�o � a UTF-8. Devemos mudar isso ent�o para o nosso arquivo messages.properties. Siga o seguinte caminho: clique direito sobre o arquivo: messages.properties > Propriedades. Na se��o Text file encoding selecione UTF-8. Clique em aplicar. Confirma a mensagem que aparece e depois clica em Ok.

clique direito sobre o messages.properties

selecionando utf-8 como codifica��o

Os caracteres estranhos, agora, aparecem em nosso arquivo. Devemos troc�-los pelo texto que havia antes e salvar o arquivo novamente.messages.properties com caracteres estranhos

Nosso segundo passo ser� resolver a mensagem de erro. Ela apareceu devido ao fato do Spring ter recebido um valor que n�o conseguiu converter para inserir no atributo p�ginas do objeto produto. Vamos adicionar uma mensagem dizendo que o tipo do dado fornecido no campo � inv�lido. A chave usada para este tipo de mensagem � a typeMismatch. Nosso arquivo messages.properties final ficar� dessa forma:

field.required = Campo � obrigat�rio
field.required.produto.titulo = O Campo t�tulo � obrigat�rio
field.required.produto.paginas = Informe o n�mero de p�ginas
field.required.produto.descricao = O Campo descri��o � obrigat�rio
typeMismatch = O tipo de dado foi inv�lido
Precisamos reiniciar o servidor para que essa altera��o se valide porque mudamos uma propriedade do arquivo e n�o seu conte�do. Vamos reiniciar o servidor e tentar novamente ent�o.erros aparecendo corretamente.

Nossas mensagens agora aparecem sem nenhum problema, mas elas se misturam um pouco com o nome dos campos, para melhorar um pouco essa visualiza��o, vamos por a tag form:errors de cada campo, logo ap�s o campo a que a tag de refere. Nosso form.jsp dentro de views/produtos esta assim atualmente:

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>T�tulo</label> 
        <form:errors path="produto.titulo" />
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <form:errors path="produto.descricao" />
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>P�ginas</label>
        <form:errors path="produto.paginas" /> 
        <input type="text" name="paginas" />
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label> <input type="text"
                name="precos[${status.index}].valor" /> <input type="hidden"
                name="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>
    <button type="submit">Cadastrar</button>
</form>
Com a modifica��o que foi proposta antes, o mesmo formul�rio deve ficar desta forma.

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>T�tulo</label> 
        <input type="text" name="titulo" />
        <form:errors path="produto.titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="produto.descricao" />
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas" />
        <form:errors path="produto.paginas" /> 
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label> <input type="text"
                name="precos[${status.index}].valor" /> <input type="hidden"
                name="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>
    <button type="submit">Cadastrar</button>
</form>
Desta forma, as mensagens aparecer�o um pouco separadas do nome do campo e fica mais f�cil de identificar de qual campo � a mensagem que aparece. Fa�a o teste, o resultado deve ser o mesmo que este:

posicao das mensagens mudou

Tudo funciona perfeitamente, mas podemos melhorar um pouco nosso c�digo do formul�rio. Note que em todos os campos, onde queremos que apare�a a mensagem de erro, temos que usar a tag form:errors usando o valor produto.ALGUMACOISA no atributo path. Nosso formul�rio s� trata de um produto especifico, n�o precisamos ficar repetindo a informa��o em todos os campos. Se pudermos fazer: <form:errors path="titulo" /> seria mais simples.

Podemos fazer isso usando um atributo da tag form:form da biblioteca do Spring. Ela tem um atributo chamado commandName, no qual podemos fazer uma referencia a qual entidade aquele formul�rio se refere. nesse caso, seria algo como: commandName="produto". Dessa forma, nas tags de erros (form:errors) n�o precisar�amos colocar o prefixo produto.. Colocar�amos ent�o s� o nome do atributo.

Vamos ent�o melhorar isso. Mudaremos a tag form do nosso form.jsp para a form:form do Spring, que tem os mesmos atributos da tag do HTML e ainda mais esse extra. O pr�ximo passo � eliminar o prefixo produto usado nas tags form:errors para usar somente o nome do atributo, como por exemplo: t�tulo e descri��o. Lembre-se que o fechamento da tag form tamb�m deve ser modificado para form:form. Nosso c�digo ent�o ficar� assim:

<form:form action="/casadocodigo/produtos" method="post" commandName="produto">
    <div>
        <label>T�tulo</label> 
        <input type="text" name="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="descricao" />
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label> <input type="text"
                name="precos[${status.index}].valor" /> <input type="hidden"
                name="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>
    <button type="submit">Cadastrar</button>
</form:form>
Se testar o formul�rio novamente, ver� que n�o houve nenhuma mudan�a de comportamento, mas nosso c�digo com certeza ficou mais claro e mais simples. Mas podemos melhor�-lo mais um ponto em nosso formul�rio. A action do nosso formul�rio � est�tica, caso precisemos mudar futuramente, teremos que lembrar em todos os lugares que usamos essa action. Conforme o n�mero de controllers tamb�m cresce e ficar� ainda mais complicado.

Vamos fazer com que o Spring gere automaticamente a action do nosso formul�rio. Caso a rota no controller mude, a action tamb�m muda automaticamente. Para isto precisaremos de uma outra taglib do Spring. Iremos adicionar a seguinte taglib na p�gina form.jsp, logo ap�s as outras taglibs.

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
Com essa nova biblioteca, podemos fazer uso da tag mvcUrl que gera uma URL de acordo com um determinado controller. N�o precisamos passar o nome do controller por completo. Se passarmos as iniciais PC para se referir a ProdutosController, o Spring j� conseguir� fazer a rela��o entre os dois.

Precisamos passar uma segunda informa��o para a tag: o m�todo para qual os dados ser�o enviados. Neste caso, o m�todo ser� o gravar.

Faremos isto da seguinte forma: mvcUrl('PC#gravar'). Com isso o Spring j� consegue montar a rota corretamente, mas para que ele efetivamente fa�a isto, devemos usar o m�todo build(). Sendo assim, teremos na action do nosso formul�rio o seguinte c�digo:

action= "${s:mvcUrl('PC#gravar').build()}"
Lembre-se que o s: � usado por causa do prefix presente na declara��o da taglib. Devemos ainda p�r uma barra na rota de produtos definida em nosso ProdutosController, para que a URL possa ser contru�da de forma correta, separando os contextos. Assim, o @RequestMapping do nosso ProdutosController muda de @RequestMapping("produtos") para @RequestMapping("/produtos").

Agora o nosso formul�rio esta pronto!

Teste cadastrar um produto de forma inv�lida e depois, de forma v�lida. Sempre precisamos verificar se alguma das modifica��es feitas n�o resultou em que outra parte da aplica��o parasse de funcionar. Fa�a alguns testes, verifique se est� tudo certo.

Recapitulando
Vimos bastante coisa at� aqui, n�o � mesmo? Constru�mos nossa l�gica de valida��o usando a classe ProdutoValidation que implementa a interface validator. Vimos como relacionar a valida��o em nosso controller com a classe de valida��o atrav�s do InitBinder e usando o WebDataBinder.

Fizemos tamb�m o nosso formul�rio ficar mais din�mico, simples e claro, com o uso das tags do Spring. Vimos como podemos fazer o uso da anota��o @Valid e tamb�m observamos que o BindingResult precisa ser usado logo ap�s a declara��o do @Valid.

Agora, vamos fazer alguns exerc�cios.

-----------------------------------------------------------------------------------------------------
<h1>Se��o 08 - Formata��o de Datas</h1>

Nos �ltimos cap�tulos, fizemos uma s�rie de valida��es em nossos livros para garantir que os livros sejam cadastrados com pelo menos tr�s informa��es que deixamos como obrigat�rias, que s�o: O t�tulo, a quantidade de p�ginas e a descri��o. Essas s�o as informa��es minimas para cadastrar um livro em nosso sistema.

Na Casa do C�digo quando ocorre o lan�amento de um livro, a data do lan�amento deste livro fica registrada no sistema. Vamos fazer com que essa data seja cadastrada em nosso sistema tamb�m. Vamos come�ar essas altera��es pelo form.jsp

Nosso formul�rio agora precisa de um campo onde possamos digitar a data de lan�amento do livro. Teremos ent�o um novo input do tipo text com o atributo name com o valor dataLancamento. J� vamos deixar a valida��o dos erros com a tag form:errors pronta, com o path de valor dataLancamento. Seguindo o padr�o dos outros campos do form.jsp teremos com nosso novo campo o seguinte c�digo: Observa��o: Lembre-se de p�r o label deste campo.

<div>
    <label>Data de Lan�amento</label>
    <input type="text" name="dataLancamento" />
    <form:errors path="dataLancamento" />
</div>
Vamos p�r esse campo logo ap�s o campo de n�mero de p�ginas. Nosso formul�rio no form.jsp fica assim:

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto">
    <div>
        <label>T�tulo</label> 
        <input type="text" name="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="descricao" />
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <div>
        <label>Data de Lan�amento</label>
        <input type="text" name="dataLancamento" />
        <form:errors path="dataLancamento" />
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label> <input type="text"
                name="precos[${status.index}].valor" /> <input type="hidden"
                name="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>
    <button type="submit">Cadastrar</button>
</form:form>
Precisamos agora, de um atributo que guarde datas em nosso model de produto. Existem duas principais classes para trabalhar com datas no Java. S�o elas a Date e a Calendar. Iremos usar a Calendar que � mais recente e mais simples de usar. Sendo assim, vamos criar um novo atributo na nossa classe Produto do tipo Calendar, sendo private.

Observa��o: Geralmente os atributos das classes s�o private, nestes casos lembre-se sempre de gerar os *Getters and Setters necess�rios. Use os atalhos do Eclipse, � mais r�pido.

Com este novo atributo e seus Getters and Setters nossa classe Produto fica com o seguinte c�digo:

@Entity
public class Produto {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String descricao;
    private int paginas;

    @ElementCollection
    private List<Preco> precos;

    private Calendar dataLancamento;


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Preco> getPrecos() {
        return precos;
    }
    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }

    public Calendar getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    @Override
    public String toString() {
        return "Produto [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
    }

}
Pronto! J� podemos testar se o nosso sistema salva corretamente as datas. Abra o formul�rio em localhost:8080/casadocodigo/produto/form e tente cadastrar um novo livro com uma data qualquer. Teremos um erro, mas dessa vez um erro amigavel. Lembra que fizemos algumas valida��es? Veja o que acontece ao tentar cadastrar o livro com uma data, como por exemplo a data 10/05/2015.

erro na data de lancamento do livro

O erro que recebemos faz todo o sentido. Note que apesar de estamos usando um data, no formul�rio s� h� textos. Ou seja, o Spring n�o est� conseguindo converter nossa data que est� em texto no formul�rio para um formato aceito pelo Calendar. O formato padr�o � o internacional.

Podemos resolver esse problema, com uma anota��o em nosso atributo dataLancamento chamada @DateTimeFormat passando o parametro pattern com o valor dd/MM/yyyy. Esse valor ser� usado para que o Spring consiga converter a data corretamente. O c�digo do atributo em nossa classe Produto com a anota��o fica da seguinte forma:

@Entity
public class Produto {
    [...]
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Calendar dataLancamento;
    [...]
}
Tente cadastrar um produto agora, com a data no padr�o brasileiro, sendo este: dia/mes/ano. Apesar de funcionar, essa � uma forma trabalhosa de se fazer isso. Imagine que em todo lugar que precisemos usar data precisaremos lembrar dessa formata��o. � f�cil de esquecer certo? Sem contar que esse ser� o padr�o da aplica��o. Sendo um padr�o, a melhor op��o � configurarmos isso.

Em nossa classe AppWebConfiguration, que � nossa classe de configura��o, faremos essa nova configura��o para que n�o precisemos ficar repetindo essa configura��o de data em todos os atributos das outras classes do sistema.

Criaremos ent�o um novo m�todo chamado mvcConversionService que retorna um objeto do tipo FormattingConversionService. Dentro deste novo m�todo precisamos fazer duas coisas. A primeira delas � criar um objeto do tipo DefaultFormattingConversionService que ser� o respons�vel pelo servi�o de convers�o de formato. A segunda � criar um objeto do tipo DateFormatterRegistrar que far� o registro do formato de data usado para a convers�o. Este segundo objeto espera receber outro objeto do tipo DateFormatter que ser� quem efetivamente guarda o padr�o da data, que neste caso ser� dd/MM/yyyy, dia/m�s/ano.

O �ltimo passo ser� usar o registrador para registar o padr�o de data no servi�o de convers�o. Lembre-se de usar a anota��o @Bean para que o Spring consiga usar essa configura��o. Encerramos o c�digo desse m�todo retornando o objeto DefaultFormattingConversionService. Nosso c�digo final fica dessa forma:

@Bean
public FormattingConversionService mvcConversionService(){
    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
    DateFormatterRegistrar formatterRegistrar = new DateFormatterRegistrar();
    formatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
    formatterRegistrar.registerFormatters(conversionService);

    return conversionService;
}
Nosso atributo agora, n�o precisa mais passar o formato da data. Ela agora s� precisa da anota��o simples, sem nenhum parametro. Dessa forma:

@Entity
public class Produto {
    [...]
    @DateTimeFormat
    private Calendar dataLancamento;
    [...]
}
Teste novamente, tudo deve funcionar normalmente.Nosso pr�ximo passo � resolver um outro problema que � bem chatinho de se ver acontecendo. A esta altura do curso voc� j� deve ter notado que quando enviamos os dados, com os campos preenchidos, quando validado o formul�rio nos exibe os erros, mas o forme aparece em branco. � trabalhoso preencher todos os campos novamente por causa de um campo que estava errado.

O ideal � que mesmo que um dos campos esteja com erro, os outros que n�o tiveram erro continuem com os dados que foram digitados antes de serem enviados. Para isso, devemos deixar com que o Spring gerencie todo o formul�rio. Fazemos isso usando as tags de formul�rio do Spring.

Da mesma forma que usamos form:form e form:errors, usaremos agora o form:input que cria um input do tipo text, mas em vez de usar o atributo name, usaremos o atributo path e n�o precisaremos usar o atributo type. Veja o antes e depois do campo de titulo por exemplo.Antes: <input type="text" name="titulo" />Depois: <form:input path="titulo" />

A nova tag parece ser bem mais simples certo? Para a descri��o, que � um textarea, usaremos a tag form:textarea e para o tipo hidden usaremos a tag form:hidden. A mudan�a s� requer quee troquemos o atributo name para path e remover o atributo type. Nosso formul�rio est� assim atualmente:

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto">
    <div>
        <label>T�tulo</label> 
        <input type="text" name="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="descricao" />
    </div>
    <div>
        <label>P�ginas</label>
        <input type="text" name="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <div>
        <label>Data de Lan�amento</label>
        <input type="text" name="dataLancamento" />
        <form:errors path="dataLancamento" />
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label> <input type="text"
                name="precos[${status.index}].valor" /> <input type="hidden"
                name="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>
    <button type="submit">Cadastrar</button>
</form:form>
Com as mudan�as, nosso formul�rio fica dessa forma:

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto">
    <div>
        <label>T�tulo</label> 
        <form:input path="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>descricao</label>
        <form:textarea rows="10" cols="20" path="descricao" />
        <form:errors path="descricao" />
    </div>
    <div>
        <label>P�ginas</label>
        <form:input path="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <div>
        <label>Data de Lan�amento</label>
        <form:input path="dataLancamento" />
        <form:errors path="dataLancamento" />
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label> 
            <form:input path="precos[${status.index}].valor" /> 
            <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>
    <button type="submit">Cadastrar</button>
</form:form>
Nosso formul�rio dessa forma ficou bem mais simples. At� o c�digo ficou menor. Vamos agora atualizar nossa p�gina de formul�rio no navegador para ver se tudo continua funcionando normalmente.

erro 500 - objeto n�o disponivel no formulario

Erro 500: Neither BindingResult nor plain target object for bean name 'produto' available as request attribute. Nosso formul�rio agora est� com erro, ele n�o chega nem a ser exibido. A mensagem de erro diz que o objeto produto n�o est� dispon�vel como atributo da requisi��o. O Spring tenta usar um objeto da classe Produto para poder exibir o formul�rio. Isso acontece porque j� que configuramos o formul�rio para guardar os dados mesmo quando acontecer erros de valida��o, dessa forma, ele precisa de um objeto para poder armazenar esses dados e para poder exibir o formul�rio, mesmo que vazio.

Para que o objeto do tipo Produto fique dispon�vel em nosso formul�rio, s� precisamos fazer uma pequena altera��o em nosso ProdutosController. Em nosso m�todo form() s� precisamos colocar que queremos receber como parametro um objeto do tipo Produto. Dessa forma o Spring j� deixar� este objeto dispon�vel na requisi��o. Nosso m�doto form() que estava assim: public ModelAndView form(){ ... } agora fica assim: public ModelAndView form(Produto produto){ ... }.

Lembre-se tamb�m de passar o objeto produto onde chamamos o m�doto form. Lembra do m�todo gravar? Ele caso n�o receba um produto v�lido, chama o m�todo form. Devemos ent�o passar para o m�todo form o mesmo objeto recebido no m�todo gravar. Nosso c�digo atual do m�todo gravar est� assim:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(@Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){
    if(result.hasErrors()){
        return form();
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
E com a mudan�a fica assim:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(@Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){
    if(result.hasErrors()){
        return form(produto);
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Atualize o formul�rio no navegador e teste novamente. Tente cadastrar livros com dados incorretos, tente com dados corretos tamb�m para verificar que tudo continua funcionando e agora nossas mensagens de erro aparecem sem que o formul�rio apare�a todo em branco novamente.formulario com os erros e os dados

Recapitulando
Neste cap�tulo fizemos com que nosso formul�rio de cadastro de produtos permane�a dos com dados mesmo que algum campo tenha sido enviado com informa��es inv�lidas. Deixamos o formul�rio com um c�digo mais simples e f�cil de entender.

Fizemos tamb�m uma s�rie de configura��es para convers�o de datas, uma tarefa muito comum em aplica��o de qualquer g�nero. Agora � hora de praticar um pouco mais com os exerc�cios.


-------------------------------------------------------------------------------------------
<h1>Se��o 09 - Enviando arquivos ao servidor</h1>

Nossa aplica��o j� tem uma s�rie de funcionalidades. Ela lista, cadastra e valida os produtos e ainda nos mostra qualquer problema que ocorre durante o processo de cadastramento dos livros.

Neste cap�tulo, faremos com que a aplica��o permita o cadastro do sum�rio dos livros. Os sum�rios na maioria das vezes s�o feitos em PDF. Sendo assim, vamos fazer com que o nosso sistema hospede os arquivos no servidor.

Come�aremos a fazer esta mudan�a a partir do form�l�rio de cadastro de produtos. O form.jsp agora ter� um novo campo com o label sumario e o input - que desta vez ser� do tipo file. Este tipo � usado exatamente para os casos nos quais queremos enviar um arquivo para o servidor. Usando este tipo de campo, o navegador j� saber� que � preciso abrir um janela de sele��o para selecionarmos o arquivo. O name deste campo file tamb�m ser� "s�mario". Com isto teremos o seguinte c�digo:

<div>
    <label>Sum�rio</label>
    <input name="sumario" type="file" />
</div>
O form.jsp com esta adi��o ficar� assim:

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto">
    <div>
        <label>T�tulo</label> 
        <form:input path="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>Descri��o</label>
        <form:textarea rows="10" cols="20" path="descricao" />
        <form:errors path="descricao" />
    </div>
    <div>
        <label>P�ginas</label>
        <form:input path="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <div>
        <label>Data de Lan�amento</label>
        <form:input path="dataLancamento" />
        <form:errors path="dataLancamento" />
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label> 
            <form:input path="precos[${status.index}].valor" /> 
            <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}" />
        </div>
    </c:forEach>

    <div>
        <label>Sum�rio</label>
        <input name="sumario" type="file" />
    </div>
    <button type="submit">Cadastrar</button>
</form:form>
Isto � tudo que precisamos fazer no form.jsp. Agora precisamos atualizar a classe Produto. Vamos adicionar tamb�m um novo atributo chamado sumarioPath e os seus *Getters and Setters. Este ser� do tipo String.

A classe Produto ficar� assim:

@Entity
public class Produto {    

    [...]
    private String sumarioPath;
    [...]

    public String getSumarioPath() {
        return sumarioPath;
    }
    public void setSumarioPath(String sumarioPath) {
        this.sumarioPath = sumarioPath;
    }

}
Existem v�rias estrat�gias para guardar arquivos nas aplica��es. Uma delas seria guardar o arquivo no banco de dados, mas esta seria muito trabalhosa e precisar�amos converter o arquivo para um formato aceito pelo banco, geralmente bytes. Outra op��o seria guardar nas pastas do sistema de arquivos do servidor. Optaremos por esta segunda op��o, por isso, o atributo sumarioPath � do tipo String. Nele ser� guardado apenas o caminho (path) do arquivo.

Nossa classe Produto j� est� pronta para armazenar o caminho do arquivo. Podemos ent�o modificar o ProdutosController para receber este arquivo e realizar as opera��es necess�rias. O Spring enviar� nosso arquivo para o ProdutosController como um objeto do tipo MultipartFile, que chamaremos de sumario. Vamos imprimir o nome do arquivo no console do Eclipse usando o m�todo getOriginalFilename(). Este ser� o teste b�sico para sabermos se o arquivo est� sendo enviado corretamente.

Observa��o: Lembre-se que o formul�rio envia os dados para o m�todo gravar. Estas modifica��o s�o realizadas justamente neste m�todo.

Ent�o, receberemos em nosso controller este novo objeto da seguinte forma:

public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){ ... }
Imprimindo o nome do arquivo, teremos o seguinte c�digo no nosso m�todo gravar.

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){

    System.out.println(sumario.getOriginalFilename());

    if(result.hasErrors()){
        return form(produto);
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Teste agora, cadastrar um produto preenchendo todos os campos, inclusive escolhendo um arquivo qualquer para o sum�rio. Teremos um erro! multipart request error

A mensagem do erro diz que a requisi��o atual n�o � multipart. Requisi��es deste tipo podem fazer envios de arquivos, sendo estes de qualquer tipo. Corrigir o erro � simples, basta usar o atributo enctype com o valor multipart/form-data na tag form do nosso form.jsp.

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto" enctype="multipart/form-data">
    [...]
</form:form>
Atualize a p�gina de cadastro de produtos. Novamente, tente cadastrar um produto preenchendo todos os campos. Teremos um novo erro.

erro multipart form data resolver

A mensagem de erro nos diz que era esperado um MultipartHttpServletRequest e nos pergunta is a MultipartResolver configured?. Esta mensagem parece bem ser clara. Ela nos pergunta se temos um MultipartResolver configurado. N�o configuramos nada disso em nossa aplica��o. Vamos fazer essa configura��o, ent�o.

Nossas configura��es ficam na classe AppWebConfiguration. Vamos at� esta classe e adicionaremos a nova configura��o. Vamos criar um m�todo chamado multipartResolver que retorna um objeto do tipo MultipartResolver. Este objeto ser� instanciado da classe StandardServletMultipartResolver e retornado. Sendo assim, teremos o seguinte c�digo em nossa classe AppWebConfiguration:

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class})
public class AppWebConfiguration {

    [...]
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

}
Agora que temos um multipartResolver configurado em nossa aplica��o, podemos tentar cadastrar um produto novamente. Lembre-se de reiniciar o servidor para as altera��es funcionarem.

Observa��o: MultipartResolver se refere a um resolvedor de dados multimidia. Quando temos texto e arquivos por exemplo. Os arquivos podem ser: imagem, PDF e outros. Este objeto � que identifica cada um dos recursos enviados e nos fornece uma forma mais simples de manipulalos.

Quando tentarmos cadastrar um produto agora, iremos receber um novo erro. null pointer exception

Este erro acontece porque o nosso m�todo gravar, em ProdutosController, tenta imprimir o nome do arquivo enviado. Aparentemente n�o resolvemos nosso problema de multipartResolver por completo. Mesmo tendo feito a configura��o do multipartResolver, o Spring ainda n�o consegue fazer a convers�o dos dados. Teremos que configurar mais algumas coisas.

As novas configura��es devem ser feitas na classe ServletSpringMVC, que � a classe de inicializa��o da nossa aplica��o. Nesta classe, iremos sobrescrever um m�todo chamado customizeRegistration que recebe um objeto do tipo Dynamic que chamaremos de registration. Neste objeto, usaremos o m�todo setMultipartConfig que requer um objeto do tipo MultipartConfigElement. O MultipartConfigElement espera receber uma String que configure o arquivo. N�o usaremos nenhuma configura��o para o arquivo, queremos receber este do jeito que vier. Passamos ent�o uma String vazia.

O c�digo destas mudan�as ficar� assim:

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{
    [...]
    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }

}
Reiniciando o servidor e testando novamente, veremos que o produto foi cadastrado com sucesso e no console do Eclipse o nome do arquivo deve estar impresso. Verifique, fa�a o teste.

Apesar de funcionar, a inten��o n�o � simplesmente imprimir o nome do arquivo no console. Mas sim enviar o arquivo e deixa-lo hospedado no servidor. Este c�digo � um c�digo de infra (abrevia��o de infraestrutura). Ele carregar� os arquivos enviados e assim ir� salvar os arquivos em algum diret�rio/pasta especifico.

Vamos criar uma nova classe para conter esse c�digo. Vamos chama-la de FileSaver e deixa-la no pacote br.com.casadocodigo.loja.infra. N�s precisamos que essa classe seja reconhecida pelo Spring para que ele consiga fazer os injects corretamente. Est� classe � importante e ela representa um componente em nosso sistema. Teremos ent�o que usar a anota��o @Component.

Nesta classe criaremos um m�todo chamado write que far� a transfer�ncia do arquivo e retornar� o caminho onde o arquivo foi salvo. Este m�todo ent�o precisara de duas informa��es, o local onde o arquivo ser� salvo e o arquivo em si. O local ser� recebido como String e o arquivo como um objeto MultipartFile. Os quais chamaremos de baseFolder e file respectivamente.

@Component
public class FileSaver {
    public String write(String baseFolder, MultipartFile file){

    }
}
Com o baseFolder e o file em m�os, conseguiremos facilmente montar uma String que indique o caminho do arquivo a ser salvo. Com esta String constru�da, criaremos um novo objeto do tipo File que ir� representar o arquivo a ser gravado no servidor. Este �ltimo objeto ser� passado para o m�todo transferTo que ser� o m�todo respons�vel por transferir o arquivo para o servidor. O c�digo parece ser mais f�cil de entender.

@Component
public class FileSaver {
    public String write(String baseFolder, MultipartFile file) {
        try {
            String path = baseFolder + "/" + file.getOriginalFilename();
            file.transferTo(new File(path));
            return path;

        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
Note que a String path monta o caminho do arquivo. O file.transferTO() faz a transfer�ncia do arquivo e o objeto File representa um o arquivo no servidor. O bloco try/catch foi adicionado por causa que opera��es I/O, ou seja, de entrada e sa�da, que podem gerar erros. Perceba tamb�m que estamos retornando a String path dentro do bloco try.

Apesar deste c�digo parecer claro, n�o podemos definir com certeza o caminho final do arquivo, o caminho absoluto que ele vai ter ao ser enviado. Podemos mudar isto detectando o caminho atual que o usu�rio est� em nosso sistema e fazer o upload do arquivo baseado neste caminho. Para isso precisamos dos dados da requisi��o, pois com ela sabemos onde o usu�rio est� em nosso sistema.

Pensando nisso, criaremos um atributo do tipo HttpServletRequest na classe FileSaver, chamaremos este de request e o marcaremos com a anota��o @Autowired para que o Spring fa�a o inject desse atributo. A partir deste objeto, conseguimos extrair o contexto atual em que o usu�rio se encontra e ent�o conseguir o caminho absoluto desse diret�rio em nosso servidor.

Vamos come�ar criando este novo atributo.

@Component
public class FileSaver {
    @Autowired
    private HttpServletRequest request;
    [...]
}
E ent�o, dentro do bloco try/catch usaremos o m�todo getServletContext para extrair o contexto atual do usu�rio e logo em seguida, do retorno deste m�todo, usaremos o getRealPath que ir� nos retornar o caminho completo de onde est� determinada pasta dentro do servidor. Passaremos para o getRealPath o nome da pasta base que estamos recebendo em nosso m�todo para que este m�todo encontre a pasta correta. O bloco try/catch ent�o fica dessa forma:

public String write(String baseFolder, MultipartFile file) {
    try {
        request.getServletContext().getRealPath("/"+baseFolder);
        [...]
    }catch([...]){
        [...]
    }
}
O caminho do arquivo agora � diferente do que fizemos antes, ele n�o � mais uma simples jun��o do baseFolder com o nome do arquivo. Este caminho agora precisa ser concatenado com o caminho absoluto que acabamos de implementar atrav�s do request. Sendo assim, guardaremos o retorno do request.getServletContext().getRealPath("/"+baseFolder); em uma nova String que chamaremos de realPath e usaremos esta String para concatenar ao path do arquivo que geramos anteriormente. Observe o c�digo:

@Component
public class FileSaver {
    @Autowired
    private HttpServletRequest request;

    public String write(String baseFolder, MultipartFile file) {
        try {
            String realPath = request.getServletContext().getRealPath("/"+baseFolder);
            String path = realPath + "/" + file.getOriginalFilename();
            file.transferTo(new File(path));
            return path;

        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
Quase nada mudou, apenas a String path deixou de concatenar o basePath e passou a concatenar o realPath. A classe FileSaver est� pronta. Ela recebe um arquivo e o nome de uma pasta, transfere o arquivo enviado pelo formul�rio para a pasta e retorna o caminho onde o arquivo foi salvo.

Agora s� precisamos alterar o ProdutosController para usar a classe FileSaver. Como queremos que o Spring fique respons�vel por instanciar estes objetos. Usaremos a mesma estrat�gia do request na classe FileSaver, mas agora em nosso ProdutosController com o FileSaver. Criaremos um atribudo da classe e assinaremos este atributo com@Autowired.

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private FileSaver fileSaver;

    [...]
}
O pr�ximo passo � usar este objeto no m�todo gravar. Usaremos o m�todo write deste objeto e passaremos o objeto MultipartFile que recebemos no m�todo gravar como arquivo a ser salvo e como nome da pasta passaremos a String arquivos-sumario. Vamos p�r este c�digo ap�s a verifica��o de erros, desta forma o arquivo s� ser� efetivamente gravado caso n�o haja erros de valida��o no formul�rio. O c�digo do m�todo gravar fica assim:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){

    if(result.hasErrors()){
        return form(produto);
    }

    String path = fileSaver.write("arquivos-sumario", sumario);
    produto.setSumarioPath(path);

    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Lembre-se que a classe que salva o arquivo no servidor retorna o caminho do arquivo. Este caminho deve ser salvo no banco de dados, por isso estamos usando a String path e passando esta String para o m�todo setSumarioPath do produto.

Podemos reiniciar o servidor e fazer alguns testes agora. Mas quando reiniciamos, recebemos um erro: No qualifying bean found for dependency

O Spring indica que n�o foi encontrado nenhum bean qualificado. Isso acontece porque ele n�o consegue encontrar nossa classe FileSaver pois esta em um pacote n�o gerenciado pelo Spring. Solucionamos isso atualizando o componentScan na classe de configura��o da aplica��o, a classe AppWebConfiguration:

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class, FileSaver.class})
public class AppWebConfiguration {
    [...]
}
Com esta configura��o feita, o servidor reiniciar� normalmente. Ent�o podemos testar cadastrar um livro com sum�rio. Por quest�es de ser um teste simples, escolha um arquivo qualquer, pode ser at� mesmo uma pequena imagem. Preencha e submeta o formul�rio para ver o resultado. Erro 500 - FileNotFoundException

O erro acontece porque a pasta arquivos-sumario n�o existe. Vamos criar ent�o esta pasta dentro de src/main/webapp/. Com a pasta criada, refa�a o teste e veja tudo funcionar perfeitamente.

Note que apesar de salvarmos o caminho completo para o arquivo, n�o precisamos realmente do caminho completo. Perceba que se acessarmos localhost:8080/casadocodigo/arquivos-sumario/NOME_DO_ARQUIVO j� poderiamos acessar o arquivo diretamente. Mas se tentarmos teremos um erro 404.404 - file not found

O motivo deste erro descobriremos mais a frente neste curso, mas por hora, faremos um pequeno ajuste no caminho retornado pelo m�doto write na classe FileSaver que retorna o caminho absoluto do nosso arquivo para retornar o caminho relativo ao nosso sistema.

O caminho relativo � composto pelo baseFolder + nomeDoArquivo. Nosso m�todo que estava assim:

public String write(String baseFolder, MultipartFile file) {
    try {
        String realPath = request.getServletContext().getRealPath("/"+baseFolder);
        String path = realPath + "/" + file.getOriginalFilename();
        file.transferTo(new File(path));
        return path;

    } catch (IllegalStateException | IOException e) {
        throw new RuntimeException(e);
    }
}
Agora ficar� assim:

public String write(String baseFolder, MultipartFile file) {
    try {
        String realPath = request.getServletContext().getRealPath("/"+baseFolder);
        String path = realPath + "/" + file.getOriginalFilename();
        file.transferTo(new File(path));
        return baseFolder + "/" + file.getOriginalFilename();

    } catch (IllegalStateException | IOException e) {
        throw new RuntimeException(e);
    }
}
Est� mudan�a aparentemente n�o afetou em nada nosso sistema, mas agora em vez de guardamos o caminho completo at� o arquivo, armazenamos apenas uma parte. Isso far� com que fique mais simples a exibi��o das imagens posteriormente.

Recapitulando
Fizemos uma s�rie de adi��es em nosso sistema nesta aula. Adicionamos um input de arquivos para o envio dos sum�rios dos livros que ser�o cadastrados. Agora, os produtos guardam o caminho dos sum�rios. O upload dos arquivos tamb�m funciona gra�as �s configura��es de Resolver e de Multipart que fizemos e por �ltimo - mas n�o menos importante - fizemos a classe FileSaver que efetivamente realiza a transfer�ncia dos arquivos para o servidor.

Em seguida, faremos alguns exerc�cios para fixar o que aprendemos at� aqui. N�o se esque�a de que qualquer d�vida pode ser postada no for�m.

--------------------------------------------------------------------------------------
<h1>Se��o 10 - Url amig�veis</h1>

Nesta aula, criaremos a p�gina de "detalhes" dos nossos livros. Se entrarmos no site da Casa do C�digo e clicarmos em qualquer um dos livros, veremos outra p�gina com todos os detalhes do produto, como por exemplo: a descri��o, a quantidade de p�ginas, sum�rio etc.

Diversas dessas informa��es est�o sendo gravadas no banco de dados durante o cadastro do produto. Ent�o, vamos utilizar a p�gina da Casa do C�digo como modelo e criar nossa p�gina de detalhes.

Observa��o: Os arquivos da p�gina de modelo que usaremos est�o dispon�veis para download* nos exerc�cio. Usaremos o c�digo disponibilizada como refer�ncia nesta aula.

Faremos na p�gina de "detalhes" uma s�rie de modifica��es para que esta passe a exibir os detalhes dos nossos produtos. A p�gina se encontrar� no arquivo detalhe.jsp. A primeira mudan�a que faremos neste arquivo � referente ao t�tulo da p�ginas. Veja como est� agora:

<title>Livros de Java, SOA, Android, iPhone, Ruby on Rails e muito mais - Casa do C�digo</title>
Como a p�gina deve exibir os detalhes de um determinado produto. Mudaremos o t�tulo de acordo com o livro escolhido. Substituiremos ent�o a parte do t�tulo da p�gina que tem o seguinte texto: Livros de Java, SOA, Android, iPhone, Ruby on Rails e muito mais para ${produto.titulo}.

<title>${produto.titulo} - Casa do C�digo</title>
Na tag body n�o h� nenhuma classe de estilo. Vamos usar uma chamada produto para esclarecer que se refere � p�gina de um produto especifico. Assim tamb�m poderemos aproveitar os CSS da Casa do C�digo. A tag body ficar� dessa forma: <body class="produto">.

Note que o c�digo fonte da p�gina est� todo em Ingl�s. Por quest�es de praticidade, modificaremos algumas partes para usarmos o idioma Portugu�s. Busque a parte do c�digo referente ao carrinho de compras, que estar� dentro da tag header:

 <header id="layout-header">
        <div class="clearfix container">
            <a href="/" id="logo">
            </a>
            <div id="header-content">
                <nav id="main-nav">

                    <ul class="clearfix">
                        <li><a href="/cart" rel="nofollow">Carrinho</a></li>

                        <li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre N�s</a></li>

                        <li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
N�s iremos trabalhar com a seguinte li:

<li><a href="/cart" rel="nofollow">Carrinho</a></li>.
Vamos mudar o /cart para /carrinho. O c�digo resultante ser�:

<li><a href="/carrinho" rel="nofollow">Carrinho</a></li>
N�o vamos nos preocupar com as urls neste momento, faremos elas funcionarem logo em seguida.

A tag article tem o atributo id, gerado dinamicamente pelo sistema da Casa do C�digo.

<article id="livro-java8" itemscope intemtype="http://schema.org/Book">
          <header id="product-highlight" class="clearfix">
            <div id="product-overview" class="container">
              <img itemprop="image" width="280px" height="395px" src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145" class="product-featured-image" />
              <h1 class="product-title" itemprop="name">Java 8 Pr�tico: Lambdas, Streams e os novos recursos</h1>

              \...
Vamos fazer uma adapta��o para que seja usado o id do produto exibido.

Iremos apagar o seguinte trecho na primeira linha

itemscope intemtype="http://schema.org/Book
E da mesma forma que fizemos no t�tulo da p�gina, faremos o seguinte: ${produto.id}.

A tag article ficar� assim:

<article id="${produto.id}">
No arquivo disponibilizado da Casa do C�digo, na tag h1 dentro da tag article faremos altera��es para o texto AQUI COLOQUE O T�TULO.

\...
  <h1 class="product-title">AQUI COLOQUE O T�TULO</h1>
              <p class="product-author">
                <span class="product-author-link">

                </span>
              </p>
No lugar, iremo substituir pelo nome do produto. J� sabemos como fazer, certo? Podemos usar ${produto.titulo}. A tag h1 ficar� assim:

<h1 class="product-title">${produto.titulo}</h1>
Onde temos o seguinte c�digo:

<p class="book-description">
    AQUI COLOQUE A DESCRI��O
</p>
Vamos trocar o texto AQUI COLOQUE A DESCRI��O pela real descri��o do livro atrav�s do produto: ${produto.descricao}.

<p class="book-description">
    ${produto.description}
</p>
O c�digo ficar� assim:

<header id="product-highlight" class="clearfix">
   <div id="product-overview" class="container">
    <img itemprop="image" width="280px" height="395px" src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145" class="product-featured-image" />

    <h1 class="product-title" itemprop="name">
      ${produto.titulo} 
    </h1>
    <p class="product-author">
       <span class="product-author-link">

   </span>
</p>

<p itemprop="description" class="book-description">${produto.descricao }</p>

    </div>
</header>
Um pouco mais abaixo deste c�digo encontraremos a parte do c�digo HTML referente a compra dos livros. A parte do HTML que exibe os pre�os dos livros. As op��es de pre�o s�o envolvidas pela tag li. Veja o c�digo atual:

<li class="buy-option">
    <input type="radio" name="id" class="variant-radio" id="product-variant-9720393823" value="9720393823"  checked="checked"  />
    <label  class="variant-label" for="product-variant-9720393823">
      E-book + Impresso 
    </label>
    <small class="compare-at-price">R$ 39,90</small>
    <p class="variant-price">R$ 29,90</p>
</li>
No cadastro de produtos, deixamos dispon�vel tr�s op��es de pre�os: Ebook, Impresso e Combo. Vamos aproveitar as facilidades da Expression Language e fazer um forEach para repetir o c�digo de op��o de compra para as tr�s op��es que temos. Faremos uso da tag forEach da JSTL. O c�digo deste forEach ficar� dessa forma:

<c:forEach items="" var="preco">
    <li class="buy-option">
        <input type="radio" name="id" class="variant-radio" id="product-variant-9720393823" value="9720393823"  checked="checked"  />
        <label  class="variant-label" for="product-variant-9720393823">
          E-book + Impresso 
        </label>
        <small class="compare-at-price">R$ 39,90</small>
        <p class="variant-price">R$ 29,90</p>
    </li> 
</c:forEach>
Note que a tag li que estamos modificando est� dentro de um formul�rio. Ou seja, envolvido por uma tag form. Cada li no c�digo da se refere a uma variante do produto, que podem ser: Ebook, Impresso ou Combo. Na Casa do C�digo cada uma dessas varia��es tem um id pr�prio, mas em nosso caso n�o. Temos varia��es de pre�os, mas n�o de produtos.

Sendo assim, iremos remover o valor do atributo id do input type="radio" fazendo com que o c�digo fique desta forma:

<c:forEach items="" var="preco">
    <li class="buy-option">
        [...]
        <input type="radio" name="id" class="variant-radio" id="" value="9720393823"  checked="checked"  />
        [...]
    </li> 
</c:forEach>
Dessa forma, perdemos a refer�ncia para o produto a ser adicionado ao carrinho de compras do nosso sistema. Este formul�rio que estamos modificando � o que adiciona produtos no carrinho. Precisamos de alguma refer�ncia do produto a ser adicionado no carrinho. Vamos criar um novo input, mas desta vez sendo do tipo hidden, configurando o valor desse input para ser o id do produto e o name como sendo produtoId. Este c�digo deve vir antes do forEach.

<input type="hidden" value="${produto.id}" value="produtoId" />
Agora que temos uma refer�ncia ao produto, precisamos deixar dispon�vel tamb�m uma refer�ncia ao tipo de pre�o a ser escolhido pelo usu�rio na hora da compra. Modificamos anteriormente o input type="radio" no qual o usu�rio selecionava uma variante do produto. No nosso caso, temos variantes de pre�o. Vamos adaptar isso tamb�m.

O input type="radio" agora deve referenciar os tipos de pre�os que temos em nosso sistema. seu atributo name ent�o deve ter valor definido como tipo assim como seu id. E o atributo value deve ter seu valor definido como o tipo de pre�o do produto. Algo como: ${preco.tipo}.

No label que se encotra logo abaixo do input type="radio" deve ser exibido o tipo de pre�o. Ent�o em vez de:

<label  class="variant-label" for="product-variant-9720393823">
  E-book + Impresso 
</label>
Teremos:

<label  class="variant-label">
    ${preco.tipo}
</label>
Removemos o atributo for porque n�o precisamos dele e tamb�m para deixar o c�digo um pouco mais simples.A tag p abaixo do label exibe o valor do produto, o preco! At� aqui s� exibimos informa��es referentes ao tipo do pre�o. N�o podemos esquecer do valor. Exibiremos ent�o o valor do pre�o atrav�z do c�digo: ${preco.valor}. A tag p que se encontra assim:

<p class="variant-price">R$ 29,90</p>
Ficar� assim:

<p class="variant-price">${preco.valor}</p>
A �ltima mudan�a que precisamos fazer no formul�rio de adi��o produtos no carrinho � referente ao atributo title do bot�o no final do formul�rio. Este bot�o � do tipo submit, respons�vel por fazer o envio dos dados do formul�rio. O bot�o cont�m o atributo title da seguinte forma: title="Compre Agora".

 <button type="submit" class="submit-image icon-basket-alt" alt="Compre Agora" title="Compre Agora"></button>
Vamos compor este t�tulo com o nome do livro, para ficar mais intuitivo. Desta forma o atributo do bot�o ficar� da seguinte forma:

title="Compre Agora ${produto.titulo}!"
Observa��o: N�o esque�a de atualizar os outros pontos do c�digo que se referem ao carrinho de compras. Modificamos o /cart para /carrinho lembra? Essa mudan�a tamb�m ocorre na action do formul�rio que estava assim:


<form action="/cart/add" method="post" class="container">
E ficou assim:

<form action="/carrinho/add" method="post" class="container">
O c�digo completo do formul�rio com todas as modifica��es que fizemos at� aqui ficar� da seguinte forma:

 <form action="/carrinho/add" method="post" class="container">
    <ul id="variants" class="clearfix">
        <input type="hidden" name="produtoId" value="${produto.id}" />
        <c:forEach items="" var="preco">
          <li class="buy-option">
            <input type="radio" name="tipo" class="variant-radio" id="tipo" value="${preco.tipo}"  checked="checked"  />
            <label  class="variant-label">
              ${preco.tipo} 
            </label>
            <small class="compare-at-price">R$ 39,90</small>
            <p class="variant-price">${produto.titulo}</p>
          </li>
        </c:forEach>           
    </ul>
    <button type="submit" class="submit-image icon-basket-alt" alt="Compre Agora" title="Compre Agora${produto.titulo}"></button>
  </form>
N�o se preocupe com as partes que n�o modificamos. Estamos adaptando o c�digo as nossas necessidades e ainda vamos continuar modificando nos pr�ximos passos.

Antes do final da tag article existe uma tag section que deve exibir algumas informa��es que tamb�m s�o importantes de serem mostradas. Como o n�mero de p�ginas e a data de publica��o. Veja o c�digo dessa se��o abaixo:

<section class="data product-detail">
    <h2 class="section-title">Dados do livro:</h2>
    <p>N�mero de p�ginas: <span>AQUI O N�MERO DE P�GINAS</span></p>
    <p></p>
    <p>Data de publica��o: AQUI A DATA DE PUBLICA��O </p>
    <p>Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta uma errata</a></p>
</section>
Vamos exibir o n�mero de p�ginas atrav�s de: ${produto.paginas} e a data de lan�amento da seguinte forma: ${produto.dataLancamento}. Depois dessas mudan�as o c�digo da se��o ficar� assim:

<section class="data product-detail">
    <h2 class="section-title">Dados do livro:</h2>
    <p>N�mero de p�ginas: <span>${produto.paginas}</span></p>
    <p></p>
    <p>Data de publica��o: ${produto.dataLancamento}</p>
    <p>Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta uma errata</a></p>
</section>
Nossa p�gina de detalhe com todas as modifica��es que fizemos at� aqui est� pronta. Precisamos agora criar um novo m�todo na classe ProdutosController que fa�a a seguinte tarefa: Buscar um produto usando o id e deixar este produto dispon�vel na view de detalhes, ou seja, no arquivo detalhe.jsp.

Chamaremos este novo m�todo de detalhe. Ele precisa fazer o mapeamento para a url /detalhe atrav�s da anota��o @RequestMapping e receber um id do tipo int. Ap�s isto, precisaremos criar um objeto do tipo ModelAndView passando para o construtor da classe do ModelAndView o caminho da view a ser utilizada. A view a ser utilizada ser� detalhe.jsp, que acabamos de criar.

No pr�ximo passo, usaremos o objeto produtoDao que temos no ProdutosController para buscar os livros pelo id e atribui-lo a um outro objeto da classe Produto. O m�todo que faz a busca se chamar� find. Ainda n�o temos o m�todo da busca, mas vamos deixar a parte do controller pronta. O c�digo ficar� assim:

@RequestMapping("/detalhe")
public ModelAndView detalhe(int id){
    ModelAndView modelAndView = new ModelAndView("/produtos/detalhe");
    Produto produto = produtoDao.find(id);
    modelAndView.addObject("produto", produto);
    return modelAndView;
}
Em seguida, iremos criar o m�todo find na classe ProdutoDAO para que receba um id e retorne um objeto da classe Produto. Para esta tarefa utilizaremos o objeto manager da classe ProdutoDAO para buscar o produto atrav�s do m�todo find, que requer dois par�metros. O primeiro se refere � classe representante da entidade na qual o produto ser� buscado. O segundo ser� o pr�prio id. O valor do primeiro par�metro ser� Produto.class. No fim, retornaremos o resultado dessa busca. O c�digo ficar� dessa forma:

public Produto find(int id){
    return manager.find(Produto.class, id);
}
A p�gina de detalhes deve funcionar e j� estamos fazendo a busca pelo produto no banco de dados. Tamb�m implementamos a l�gica que busca o produto e envia o produto para a view no ProdutosController. Logo, poderemos exibir os dados do produto no arquivo detalhe.jsp que � a nossa view.

Mas como faremos para acessar a p�ginas de detalhes de um produto? Vamos precisar passar o id para que o produto possa ser buscado e exibido. Podemos tentar acessar diretamente pela url. O id pode ser passado na url da seguinte forma: detalhe?id=4. Sendo assim, podemos montar a seguinte url para exibir os detalhes de um determinado livro:

localhost:8080/casadocodigo/produtos/detalhe?id=4
Agora, � poss�vel ver a p�gina de detalhes de um livro. Alguns detalhes poder�o n�o ser exibidos corretamente - isso � perfeitamente normal -, porque n�o fizemos todas as adapta��es necess�rias ainda. Os pre�os s�o uma das informa��es que n�o ser�o exibidas corretamente, considerando que n�o o escrevemos da forma correta. Veremos como ele esta agora:

<c:forEach items="" var="preco">
  <li class="buy-option">
    <input type="radio" name="tipo" class="variant-radio" id="tipo" value="${preco.tipo}"  checked="checked"  />
    <label  class="variant-label">
      ${preco.tipo} 
    </label>
    <small class="compare-at-price">R$ 39,90</small>
    <p class="variant-price">${preco.valor}</p>
  </li>
</c:forEach>
Perceba que n�o preenchemos o atributo items do forEach. Devemos passar, para este atributo, a lista de pre�os presente no produto dessa forma:

<c:forEach items="${produto.precos}" var="preco">
  <li class="buy-option">
    <input type="radio" name="tipo" class="variant-radio" id="tipo" value="${preco.tipo}"  checked="checked"  />
    <label  class="variant-label">
      ${preco.tipo} 
    </label>
    <small class="compare-at-price">R$ 39,90</small>
    <p class="variant-price">${preco.valor}</p>
  </li>
</c:forEach>
Se atualizamos a p�gina agora, teremos um erro:

Erro LazyInitializationException

Este erro de LazyInitializationException indica que ao carregar o produto, os pre�os n�o foram carregados juntos. Ou seja, tentamos exibir os pre�os sem carreg�-los do banco de dados. Isto acontece porque nosso ProdutoDAO no m�todo find s� busca o produto, sem se relacionar com seus pre�os.

Precisamos ent�o fazer com que o Hibernate relacione os produtos com seus pre�os. Faremos isto atrav�s de uma query personalizada:

select distinct(p) from Produto p join fetch p.precos precos where p.id = :id
Observe que estamos fazendo um select comum, mas estamos usando o distinct para que o Hibernate nos retorne apenas resultados diferentes. Estamos tamb�m fazendo um join fetch com a tabela Precos usando como rela��o o id do produto presente na tabela de pre�os.

Usaremos o sql atrav�s do m�todo createQuery e passaremos o :id atrav�s do m�todo setParameter. Queremos retornar apenas um resultado desta query atrav�s do m�todo getSingleResult. Nosso m�todo find ficar� assim:

return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
Para que n�o precisemos ficar chutando ids diretamente na url. Criaremos links na listagem e assim poderemos clicar em um determinado produto e j� visualizar a p�gina de detalhes do produto. Faremos isso no arquivo lista.jsp usando o construtor de urls do Spring. Lembra do mvcUrl? Iremos usa-lo novamente aqui.

Passaremos o id para o mvcUrl atrav�s do m�todo arg que recebe dois par�metros: o primeiro ser� a posi��o do parametro, que ter� valor 0. O segundo ser� o valor do par�metro, o produto.id.

<a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>
Observa��o: Estamos construindo o link para a p�gina de detalhes do produto na listagem dos produto. Este link deve ser criado de forma a envolver o t�tulo do livro na listagem. Lembre-se de importar a taglib do Spring para poder usar o mvcUrl da mesma forma que fizemos no form.jsp usando o import: <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>.

Mas veja como est� ficando nossa url: http://localhost:8080/casadocodigo/produtos/detalhe?id=2.

Observe como s�o as urls do site da Casa do C�digo:

https://www.casadocodigo.com.br/products/livro-code-igniter
Elas parecem mais interessantes, porque mostram o nome do produto. Estas urls s�o chamadas de URLs Amigaveis.

N�s n�o mudaremos nossas urls para ficarem amigaveis desta forma, mas faremos com que o par�metro seja passado de forma diferente. Veja como nossa url parece mais simples usando o seguinte formato:

http://localhost:8080/casadocodigo/produtos/detalhe/2
Eliminaremos o ?id= e deixaremos nossas urls mais simples.

Para isto, precisamos mudar a assinatura do m�todo detalhe em nosso ProdutosController. Ela precisa receber o par�metro separado pela barra (/). A anota��o @RequestMapping permite que fa�amos isso da seguinte forma:

@RequestMapping("/detalhe/{id}")
Mas apenas isto n�o � o suficiente. Precisaremos indicar para o m�todo detalhe que o par�metro id ser� recuperado do caminho da url. Ent�o, usaremos uma nova anota��o: @PathVariable passando o id desta forma: @PathVariable("id").

Com as altera��es o m�todo detalhe da classe ProdutosController ficar� assim:

@RequestMapping("/detalhe/{id}")
public ModelAndView detalhe(@PathVariable("id") Integer id){
    ModelAndView modelAndView = new ModelAndView("/produtos/detalhe");
    Produto produto = produtoDao.find(id);
    modelAndView.addObject("produto", produto);
    return modelAndView;
}
Algumas coisas ainda n�o est�o prontas - nossas datas ainda n�o s�o exibidas corretamente. Mas corrigiremos isso em breve.

Por enquanto, faremos alguns exerc�cios para fixar o que vimos at� aqui. Mas j� aprendemos como relacionar os produtos com seus pre�os, criar a p�gina de detalhes do produto e configurar as urls para ficarem amig�veis.

Fa�a o download do c�digo fonte da p�gina da casa do c�digo. Como o layout da Casa do C�digo mudou, voc� pode baixar o layout antigo aqui: https://s3.amazonaws.com/caelum-online-public/spring-mvc-1-criando-aplicacoes-web/detalhe-com-css.zip

Ap�s baixar, ser� necess�rio importar no Eclipse. Para isso siga os seguintes passos: Bot�o direito em cima do projeto, escolha a op��o Import, procure pela op��o Archive File e clique em Next. Ap�s isso, procure pelo ZIP baixado e depois clique em Finish.

Para verificar se tudo deu certo, abra a pasta src > main > webapp > resources e verifique se existem duas pastas chamadas css e imagens. Verifique tamb�m se o arquivo detalhe.jsp existe dentro de WEB-INF > views > produtos.


--------------------------------------------------------------------------------------------------
<h1>Se��o 11 - Expondo atributos no jsp</h1>


Nas aulas anteriores, fizemos a p�gina de detalhes de produto. Nela, al�m de exibirmos todos os detalhes do produto, constru�mos um formul�rio em que o usu�rio pode selecionar a op��o de pre�o e clicar no bot�o de adicionar produto ao carrinho.

Observe que a action deste formul�rio aponta para uma url diferente. Ela aponta para /carrinho/add. N�o temos nenhum c�digo que atenda as requisi��es enviadas para este endere�o. At� o momento s� temos classes que atendam as requisi��es que usam o caminho /produtos.

Veja como est� atualmente o formul�rio de compra de produtos.

<form action="/carrinho/add" method="post" class="container">
    <ul id="variants" class="clearfix">
        <input type="hidden" name="produtoId" value="${produto.id}" />
        <c:forEach items="${produto.precos}" var="preco">
          <li class="buy-option">
            <input type="radio" name="tipo" class="variant-radio" id="tipo" value="${preco.tipo}"  checked="checked"  />
            <label  class="variant-label">
              ${preco.tipo}
            </label>
            <small class="compare-at-price">R$ 39,90</small>
            <p class="variant-price">${preco.valor}</p>
          </li>
        </c:forEach>           
    </ul>
    <button type="submit" class="submit-image icon-basket-alt" alt="Compre Agora" title="Compre Agora${produto.titulo}"></button>
</form>
Precisamos criar um novo controller, assim as requisi��es enviadas para o caminho /carrinho ser�o atendidas da mesma forma que fizemos com os produtos. Crie ent�o uma nova classe chamada CarrinhoComprasController e n�o se esque�a de deixa-lo no pacote br.com.casadocodigo.loja.controllers. Fa�a uso tamb�m das anota��es @Controller e @RequestMapping com o valor /carrinho, para que o Spring reconhe�a esta classe como um controller e que o mapeamento da rota seja feito corretamente. At� ent�o teremos a classe CarrinhoComprasController:

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

}
A primeira funcionalidade que vamos codificar � a adi��o de produtos ao carrinho de compras. Vamos come�ar adicionando um m�todo chamado add na classe CarrinhoComprasController que retorna um objeto do tipo ModelAndView. Este m�todo precisa receber dois par�metros que s�o: O id do produto e o tipo de pre�o selecionado pelo usu�rio. Lembre-se que apenas o id do produto est� sendo enviado pelo formul�rio da p�gina de detalhes e n�o o produto.

Ao escolher um produto faremos com que o m�todo redirecione o usu�rio para a listagem de produtos. Sendo assim, at� aqui teremos:

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
    return modelAndView;
}
Observa��o: Perceba o uso da anota��o @RequestMapping("/add") que faz o mapeamento da rota /carrinho/add para este m�todo no CarrinhoComprasController.

Abaixo, vemos a classe CarrinhoComprasController com o c�digo completo escrito at� aqui:

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipo){
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");

        return modelAndView;
    }

}
O que precisamos fazer agora � definir uma forma de relacionar o produto com seu pre�o. Podemos fazer isso de uma forma muito simples: criando um outro objeto que represente este relacionamento. O objeto ser� criado atrav�s da classe CarrinhoItem que iremos codificar agora. Esta s� ter� os atributos produto e tipoPreco. Um construtor que receba estes dois par�metros e os Getters and Setters destes mesmos atributos. Assim teremos a classe CarrinhoItem:

public class CarrinhoItem {

    private TipoPreco tipoPreco;
    private Produto produto;

    public CarrinhoItem(Produto produto, TipoPreco tipoPreco) {
        this.produto = produto;
        this.tipoPreco = tipoPreco;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
Observa��o: Por se tratar de uma classe de neg�cio, esta ficar� no pacote br.com.casadocodigo.loja.models. Ela n�o � um controller nem uma view e cont�m uma l�gica importante para o neg�cio.

Nosso pr�ximo passo ser� criar um m�todo privado na classe CarrinhoComprasController para que ele crie e retorne um objeto da classe CarrinhoItem. Busque o produto pelo id no banco de dados e relacione o produto com o pre�o selecionado pelo usu�rio. Chamaremos este m�todo de criaItem. Como estamos falando de buscar produtos no banco de dados, criaremos tamb�m um atributo na classe CarrinhoComprasController do tipo ProdutoDAO chamado produtoDao, com a anota��o @Autowired. Iremos us�-lo para a busca do produto.

@Autowired
private ProdutoDAO produtoDao;

private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipo){
    Produto produto = produtoDao.find(produtoId);
    CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipo);
    return carrinhoItem;
}
Agora temos que usar o m�todo dentro do m�todo add da classe CarrinhoComprasController, passando para ele o produtoId e o tipo de pre�o. Ent�o receberemos o objeto retornado pelo m�todo criaItem.

CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
O m�doto add at� o momento ficar� assim:

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
    return modelAndView;
}
O que fica faltando para terminarmos a funcionalidade de adicionar produtos ao carrinho de compras �: O pr�prio carrinho, incluindo pelo menos um m�todo que fa�a a adi��o do carrinhoItem a uma lista. Vamos fazer isso, ent�o.

Crie uma nova classe chamada CarrinhoCompras no pacote br.com.casadocodigo.loja.models e logo em seguida crie um m�todo que n�o tem retorno, ou seja, void chamado add. Este m�todo deve receber um objeto da classe CarrinhoItem que � a classe que representa um item em nosso carrinho.

public class CarrinhoCompras {
    public void add(CarrinhoItem item){

    }
}
Algo comum nas lojas online � que ao selecionarmos determinado produto, podemos tamb�m especificar a quantidade. Nossa p�gina de detalhes n�o permite esse tipo de comportamento, mas em no carrinho de compras far� muito sentido incluir este tipo de informa��o. Por isso precisaremos de uma lista que associe o item a sua quantidade. Neste caso, usaremos uma do tipo Map, que permitir� a associa��o entre uma chave, que ser� o item do carrinho, e um valor, que ser� a quantidade total de c�pias do mesmo produto.

Logo, adicionaremos � classe carrinho um atributo privado chamado itens, do tipo Map<CarrinhoItem, Integer>, e o instanciaremos com um objeto da classe LinkedHashMap.

private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();
Com a lista pronta, precisaremos que ao adicionarmos um produto, seja verificado se o produto j� existe em nossa lista. Caso exista, somaremos +1 na quantidade, caso n�o exista, adicionamos o produto selecionado. Veja o c�digo abaixo:

public void add(CarrinhoItem item){
    itens.put(item, getQuantidade(item) + 1);
}
Apesar de n�o termos o m�todo getQuantidade ainda, pode-se notar que a l�gica � simples. Ele deve retornar o n�mero de vezes em que o produto foi encontrado na lista e somar 1 a essa quantidade. Agora vejamos como fica essa l�gica em c�digo.

private int getQuantidade(CarrinhoItem item) {
    if(!itens.containsKey(item)){
        itens.put(item, 0);
    }
    return itens.get(item);
}
Perceba que estamos usando o m�todo containsKey que verifica se a lista tem a chave, que no caso � o item do carrinho. Estamos usando ! que � o sinal de nega��o da express�o l�gica. Ou seja, se a lista n�o tiver o item, este ser� adicionado com o valor 0 na mesma. E ent�o o m�todo get usado no return retorna o valor que est� associado aquela chave.

Explicando melhor... Caso o item n�o exista na lista, colocamos o item e retornamos o valor 0, que ser� incrementado pelo met�do add. Mas caso o item j� exista, retornamos apenas o valor que representa a quantidade de vezes que o produto foi adicionado na lista.

Apesar de usar o m�todo containsKey n�o � o suficiente. Ele usa o m�todo equals dispon�vel na classe Object. Para que o m�todo containsKey consiga comparar corretamente os itens da lista, devemos sobrescrever dois m�todos na classe CarrinhoItem e depois, na classe Produto. Use os geradores do Eclipse e selecione a op��o Generate HashCode and Equals. Na classe CarrinhoItem, teremos algo parecido com:

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((produto == null) ? 0 : produto.hashCode());
    result = prime * result + ((tipoPreco == null) ? 0 : tipoPreco.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    CarrinhoItem other = (CarrinhoItem) obj;
    if (produto == null) {
        if (other.produto != null)
            return false;
    } else if (!produto.equals(other.produto))
        return false;
    if (tipoPreco != other.tipoPreco)
        return false;
    return true;
}
Observa��o: Lembre-se que estes m�todos s�o gerados a partir dos atributos da classe. No caso da classe CarrinhoItem, deixamos todos os atributos selecionados, mas no caso da classe Produto, usaremos apenas o atributo id que � gerado pelo banco de dados e nos garante que o produto � �nico. Na classe produto, teremos:

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Produto other = (Produto) obj;
    if (id != other.id)
        return false;
    return true;
}
Com tudo isso feito, estamos quase prontos para testar se o carrinho de compras da nossa aplica��o est� realmente funcionando. O �ltimo passo � usar a anota��o @Component na classe CarrinhoCompras para que o Spring instancie automaticamente objetos desta classe quando necess�rio. Depois, a classe ficar� desta forma:

@Component
public class CarrinhoCompras {
    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();

    public void add(CarrinhoItem item){
        itens.put(item, getQuantidade(item) + 1);
    }

    private int getQuantidade(CarrinhoItem item) {
        if(!itens.containsKey(item)){
            itens.put(item, 0);
        }
        return itens.get(item);
    }

}
Lembre-se de que ainda n�o estamos adicionando os produtos ao carrinho de compras. Precisamos fazer isso no m�todo add da classe CarrinhoComprasController. Primeiro faremos com que o Spring instancie para n�s o carrinho de compras. Fazemos isso criando um atributo no controller em quest�o, que chamaremos de carrinho e o anotaremos com @Autowired.

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

    @Autowired
    private CarrinhoCompras carrinho;
}
Ap�s isso, no m�todo add da classe CarrinhoComprasController, usaremos o m�todo add do objeto carrinho, passando o objeto carrinhoItem para que este seja adicionado ao carrinho de compras.

At� aqui o m�todo add da classe CarrinhoComprasController est� assim:

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
    return modelAndView;
}
Em seguida, ficar� assim:

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
    carrinho.add(carrinhoItem);
    return modelAndView;
}
Podemos iniciar agora o servidor Tomcat para podermos testar essa nova funcionalidade. Mas ao iniciar, recebemos uma mensagem de erro:

No qualifying bean of type [br.com.casadocodigo.loja.models.CarrinhoCompras] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency
J� vimos este erro antes. O Spring n�o est� conseguindo encontrar a classe CarrinhoCompras. Isto porque o pacote models n�o est� sendo scaneado pelo Spring. Da mesma forma que fizemos com o ProdutoDAO outra vez, faremos agora com o CarrinhoCompras. Na anota��o @ComponentScan da classe AppWebConfiguration adicionaremos a classe CarrinhoCompras.

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class, FileSaver.class, CarrinhoCompras.class})
public class AppWebConfiguration {
    [...]
}
Se tentarmos testar novamente agora, n�o iremos receber nenhum erro do servidor. Ent�o, tente acessar a listagem de produtos, escolher um tipo de pre�o e clicar no bot�o de adicionar produto ao carrinho. Teremos um novo erro.

404 - Not Found para /carrinho/add

Note a URL da p�gina, ela n�o tem o contexto da aplica��o. O contexto seria o /casadocodigo que � o nome do projeto. A URL da p�gina fica com o endere�o localhost:8080/carrinho/add. Para corrigir isso, usaremos uma tag da taglib core da JSTL no formul�rio da p�gina de detalhes do produto.

No Arquivo detalhes.jsp na tag form, teremos o atribudo action com o valor /carrinho/add. Este tipo de endere�o, faz com que o contexto da aplica��o seja perdido. A tag c:url da JSTL cria URLs baseadas no contexto. Ela resolver� nosso problema. Antes das altera��es, a action do formul�rio em detalhes.jsp est� assim:

[...]
    <form action="/carrinho/add" method="post" class="container">
[...]
Agora, ela ficar� assim:

[...]
    <form action='<c:url value="/carrinho/add" />' method="post" class="container">
[...]
Observa��o: Fique atento sobre as aspas nesta modifica��o, foi necess�ria a mudan�a por causa de conflitos que seriam gerados se us�ssemos aspas iguais no atribudo action e na tag c:url. Agora, estar� tudo funcionando normalmente.

Da p�gina de detalhes somos levados � listagem dos produtos quando selecionados o tipo de pre�o do produto e clicamos na op��o de adicionar o produto ao carrinho. Mas nada indica que o produto foi realmente adicionado. Vamos fazer com que o n�mero de produtos no carrinho seja exibido junto ao link carrinho encontrado na p�gina de detalhes. No seguinte trecho de c�digo:

<li><a href="/cart" rel="nofollow">Carrinho</a></li>
Faremos algo do tipo:

<li><a href="/cart" rel="nofollow">Carrinho (${carrinhoCompras.quantidade}) </a></li>
A classe CarrinhoCompras j� tem um m�todo getQuantidade, mas ele s� retorna a quantidade de um produto especifico. Criaremos um novo m�todo getQuantidade que ir� iterar entre todos os itens do carrinho e contar quantos produtos est�o na lista de itens. Observe o seguinte c�digo:

public int getQuantidade(){
    return itens.values().stream().reduce(0, (proximo, acumulador) -> (proximo + acumulador));
}
Este c�digo percorre toda a lista de itens e soma o valor de cada item a um aculumador. Caso n�o conhe�a a API de Stream e Lambdas, que s�o recursos do Java 8, recomendamos que fa�a o curso de java 8 dispon�vel aqui no Alura.

Veja o link de menu como se encontra ap�s estas modifica��es:

Link do carrinho sem mostrar o total

Apesar de parecer funcionar, n�o funciona. Ao testarmos adicionar alguns produtos no carrinho, veremos que n�o h� um n�mero indicando que a contagem dos itens est� sendo feita corretamente. Isto acontece porque o objeto que representa o carrinho de compras n�o est� dispon�vel em lugar nenhum a n�o ser dentro do escopo do Spring.

Anteriormente, marcamos a classe CarrinhoCompras com a anota��o @Component. Essa anota��o indica que a classe ser� tratada como um Bean do Spring. Para que possamos acessar esse Bean em nossas view, precisaremos adicionar uma configura��o na classe WebAppConfiguration. No m�todo InternalResourceViewResolver poderiamos usar o m�todo setExposeContextBeansAsAttributes do objeto resolver com o valor true, mas esta configura��o tornar� todos os Beans da aplica��o dispon�veis, o que parece n�o ser uma boa ideia.

Ao inv�s disso, usaremos o m�todo setExposedContextBeanNames deste mesmo objeto. Este m�todo nos permite dizer qual *Bean estar� dispon�vel para a view. Os nomes dos Beans seguem um padr�o bem simples. O padr�o � o nome da classe com sua primeira em min�sculo, ou seja, a classe CarrinhoCompras fica carrinhoCompras. Com esta mudan�a o m�todo InternalResourceViewResolver da classe WebAppConfiguration fica assim:

@Bean
public InternalResourceViewResolver internalResourceViewResolver(){
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    resolver.setExposedContextBeanNames("carrinhoCompras");
    return resolver;
}
Teste novamente, ver� que agora a contagem acontece normalmente e � exibida na parte superior da p�gina de detalhes da seguinte forma:

Carrinho exibindo total

At� aqui, fizemos uma s�ria de adi��es em nossa aplica��o. Criamos o carrinho de compras, relacionamos os produtos e seus tipos de pre�o atrav� de um item de carrinho e exibimos a contagem de itens no carrinho em nossa view.

Caso tenha d�vidas, fique a vontade para perguntar no for�m. Agora vamos praticar um pouco mais com alguns exerc�cios.

--------------------------------------------------------------------------------------------------
<h1>Se��o 12 - Escopo sess�o</h1>

Nas aulas anteriores, criamos o carrinho de compras da nossa aplica��o e fizemos aparecer na p�gina de detalhes o n�mero de produtos que j� adicionamos no carrinho. Fa�a alguns testes, adicione produtos para se certificar que tudo est� funcionando perfeitamente.

Nossos testes at� agora, n�o consideraram a situa��o na qual m�ltiplos usu�rios acessam a loja. N�s testamos considerando apenas um usu�rio. Fa�a o seguinte teste: Abra a aplica��o em um navegador e adicione alguns itens no carrinho de compras. Ap�s isso, abra um outro navegador e acesse a p�gina de detalhes de um produto. O segundo navegador apresenta o carrinho com o mesmo n�mero de itens do primeiro navegador. Isso n�o deveria acontecer.

Neste caso, dois navegadores diferentes deveriam representar dois usu�rios diferentes. Aparentemente, a aplica��o est� compartilhando o carrinho com todos os usu�rios que a acessam. Seria a mesma situa��o de estar em uma loja f�sica e outra pessoa colocasse produtos em nossa sacola de compras. Isso n�o parece certo.

Note que quando um usu�rio escolhe um livro e depois, uma segunda pessoa escolhe outro item, os dois clientes est�o adicionando produtos no mesmo carrinho.

Carrinho de compras compartilhado

Isso acontece porque ao marcarmos a classe CarrinhoCompras com a anota��o @Component, transformando nossa classe em um Bean do Spring estamos tamb�m configurando que este objeto ser� Singleton. Por padr�o, o Spring tem esta configura��o para os seus componentes.

Para corrigir o problema, devemos especificar o escopo do componente atrav�s da anota��o @Scope. Ela recebe um par�metro chamado value que pode receber valores das constantes da interface WebApplicationContext.

Quando se faz necess�rio que um recurso seja individual, ou seja, �nico para cada usu�rio, definimos os recursos com o escopo de sess�o. Este � criado a partir do momento em que o usu�rio entra em uma determinada aplica��o e segue at� o encerramento da mesma - ou ao fechar do navegador em alguns casos.

Ent�o, configure a classe CarrinhoCompras para que o componente seja criado no escopo de sess�o e assim seja �nico para cada usu�rio ao entrar na aplica��o. A constante da interface WebApplicationContext neste caso ser� a SCOPE_SESSION.

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras {
    [...]
}
Mas fazer somente isso no Spring n�o ser� o suficiente. Se iniciarmos o servidor agora teremos um erro porque o escopo de sess�o n�o � permitido dentro do CarrinhoComprasController que est� dentro do escopo de aplica��o. Resolveremos este problema com a mesma solu��o, mas com valores diferentes. Em seguida, entenderemos o motivo.

Controller no geral tem um papel bem definido, ele simplesmente trata a requisi��o. Ele recebe os dados, repassa para um outro objeto e devolve uma resposta. Pensando assim, podemos concluir que ap�s a requisi��o ser atendida, n�o faz sentido que o controller ainda esteja "vivo". Geralmente, o escopo dos controllers � o de request. Isto significa que quando h� uma requisi��o, o controller � criado e depois, ela deixa de existir. Podemos configurar isso atrav�s da anota��o @Scope com o valor da constante SCOPE_REQUEST da interface WebApplicationContext.

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {
    [...]
}
Inicie o servidor, fa�a os testes novamente. Fa�a verifica��o tanto com um usu�rio quanto com v�rios. O carrinho de compras n�o deve mais estar compartilhado e cada usu�rio deve ter o seu pr�prio com os produtos selecionados.

<h2>Entendendo o escopo</h2>
O nosso carrinho j� est� funcionando, mas vamos pensar em como ele funcionaria para v�rios usu�rios. Abra dois navegadores diferentes e acesse a sua aplica��o. Veja que os dados do carrinho est�o sendo compartilhados com todos os usu�rios. Por que isso acontece ?

Por padr�o o spring define que o escopo de todos os componentes � de "application" ou seja apenas uma instancia existe desde quando a aplica��o foi criada. O principal problema dessa abordagem � esse que acabamos de encontrar, os usu�rios compartilham sempre os mesmos dados, uma altera��o afeta todo mundo que est� conectado a nossa aplica��o. Para resolver isso precisamos mudar o escopo do nosso carrinho.

<h2>Tipos de escopo</h2>
Durante o v�deo foi apresentado tr�s tipos diferentes de escopo: aplica��o, sess�o e request. Com as suas palavras descreva a diferen�a de cada um deles e qual escopo voc� deveria usar em um carrinho de compras.

O primeiro escopo apresentado � o escopo de aplica��o, isto �, desde que o servidor � iniciado apenas um objeto na mem�ria � manipulado, o que causa conflito quando temos mais de um usu�rio usando a nossa aplica��o. O segundo escopo � o de sess�o, no qual o objeto � criado para cada usu�rio que se conecta � aplica��o, ou seja, usu�rios diferentes usam objetos diferentes, o que � ideal para um carrinho de compras, uma vez que cada usu�rio possui o seu pr�prio carrinho. O �ltimo escopo apresentado � o escopo de request, no qual cada vez que acessamos a p�gina um objeto � criado.


--------------------------------------------------------------------------------------------
<h1>Se��o 13 - Carrinho de compras</h1>

Se entrarmos no site da Casa do C�digo, selecionarmos um livro e clicar em comprar, veremos que o livro � adicionado ao carrinho de compras. Veremos tamb�m que o carrinho de compras � uma lista com todos os livros selecionados. Esta lista exibe os pre�os de cada livro, a quantidade e o total da soma dos pre�os.

Faremos o mesmo em nosso projeto. Crie uma nova pasta chamada carrinho no diret�rio webapp/WEB-INF/views/. Baixe os arquivos que ser�o usados nessa aula atrav�s deste link: https://s3.amazonaws.com/caelum-online-public/spring-mvc-1-criando-aplicacoes-web/carrinho-com-imagem.zip. Descompacte o zip baixado e extrai-o. Copie o arquivo itens.jsp que extraiu de dentro do zip e cole-o na pasta carrinho do seu projeto.

O primeiro ajuste que faremos � fazer com que a p�gina de itens.jsp exiba a quantidade de produtos no carrinho do mesmo jeito que fizemos na p�gina de detalhes. Encontre a seguinte linha de c�digo no arquivo itens.jsp:

<li><a href="/cart" rel="nofollow">Carrinho</a></li>
E modifique para:

<li><a href="${s:mvcUrl('CCC#itens').build()}" rel="nofollow">Carrinho ( ${carrinhoCompras.quantidade} )</a></li>
Adicione o taglib "tags" em itens.jsp:

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
Observa��o: Note que estamos criando uma nova url. Esta url criada aponta para o m�todo itens na classe CarrinhoComprasController que ainda n�o existe, mas que criaremos em instantes. Este m�todo ser� o respons�vel por exibir esta p�gina.

O pr�ximo passo ser� a cria��o da tabela que exibir� nossa lista de produtos. Procure as seguintes linhas no HTML da p�gina itens.jsp:

<body>
    <tr>
        <td class="cart-img-col">
            <img src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145" width="71px" height="100px" />
        </td>
        <td class="item-title">T�TULO DO LIVRO AQUI</td>
        <td class="numeric-cell">R$ 59,90</td>
        <td class="quantity-input-cell">
            <input type="number" min="0" readonly="readonly" id="updates_4082273665" name="updates[4082273665]" value="1" />
        </td>
        <td class="numeric-cell">R$ 59,90</td>
        <td class="remove-item">
            <a href="/cart/change?218748921802387812&quantity=0">
                excluir
            </a>
        </td>
    </tr>
</body>
Perceba que pela estrutura da tabela, cada produto ser� representado por uma linha. Sendo assim, envolveremos a tag tr com a tag forEach da JSTL percorrendo a lista de itens presente em nosso carrinho. At� aqui teremos o seguinte c�digo:

<c:forEach items="${carrinhoCompras.itens }" var="item">
    <tr>
        <td class="cart-img-col">
            <img src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145" width="71px" height="100px" />
        </td>
        <td class="item-title">T�TULO DO LIVRO AQUI</td>
        <td class="numeric-cell">R$ 59,90</td>
        <td class="quantity-input-cell">
            <input type="number" min="0" readonly="readonly" id="updates_4082273665" name="updates[4082273665]" value="1" />
        </td>
        <td class="numeric-cell">R$ 59,90</td>
        <td class="remove-item">
            <a href="/cart/change?218748921802387812&quantity=0">
                excluir
            </a>
        </td>
    </tr>
</c:forEach>
Antes de continuarmos, vamos implementar um novo m�todo na classe CarrinhoCompras. Veja que apesar de estarmos fazendo ${carrinhoCompras.itens } a classe CarrinhoCompras n�o tem esse m�todo. Outra observa��o a ser feita � que o carrinho de compras guarda um objeto do tipo Map e nesse ponto da aplica��o, n�o queremos um Map mas sim uma lista. Veja o m�todo a seguir:

public Collection<CarrinhoItem> getItens() {
    return itens.keySet();
}
O m�todo anterior deve ser colocado na classe CarrinhoCompras. Perceba que ele retornar uma Collection que funciona como uma lista. Note tamb�m que o retorno do m�todo captura as chaves do Map e as retorna. Se voc� se lembrar, vai perceber que as chaves desse Map s�o objetos da classe CarrinhoItem que possuem as informa��es sobre os produtos adicionados ao carrinho.

Agora, exibiremos as informa��es referentes aos produtos do carrinho de compras no HTML da p�gina itens.jsp. Na linha onde h�:

<td class="item-title">T�TULO DO LIVRO AQUI</td>
Substitua por:

<td class="item-title">${item.produto.titulo}</td>
Apesar da linha anterior funcionar para o t�tulo do produto, n�o funcionaria para o pre�o. O pre�o dentro da classe produto est� sendo representado por uma lista e n�o queremos uma lista de pre�os neste ponto da aplica��o. Queremos simplesmente o pre�o selecionado pelo usu�rio, um �nico pre�o. Por hora faremos apenas item.preco e depois implementaremos este m�todo para que funcione. Sendo assim onde h�:

<td class="numeric-cell">R$ 59,90</td>
Substitua por:

<td class="numeric-cell">${item.preco}</td>
Agora exibiremos a quantidade de cada item adicionado no carrinho de compras. Encontre e observe a seguinte linha do HTML:

<input type="number" min="0" readonly="readonly" id="updates_4082273665" name="updates[4082273665]" value="1" />
O atributo id e name est�o com alguns n�meros malucos. Estes n�meros s�o usados no site da Casa do C�digo. N�o precisamos destes n�meros. Modificaremos estes atributos para ter o texto quantidade e no valor usaremos o m�todo getQuantidade da classe CarrinhoCompras que recebe um item e retorna a quantidade daquele item no carrinho. A linha anterior modificada fica assim:

<input type="number" min="0" readonly="readonly" id="quantidade" name="quantidade" value="${carrinhoCompras.getQuantidade(item) }" />
A seguinte linha diz respeito ao pre�o novamente, mas desta vez n�o � o valor unit�rio do produto. � o total da soma dos pre�os daquele produto espec�fico. Criaremos um m�todo pra isso em instantes, mas j� vamos deixar o HTML pronto por hora. Onde esta assim:

<td class="numeric-cell">R$ 59,90</td>
Deixe assim:

<td class="numeric-cell">${carrinhoCompras.getTotal(item)}</td>
O m�todo getTotal que usamos neste HTML n�o existe ainda. Iremos implement�-lo em instantes. O pr�ximo passo ser� modificar o link de remo��o de produtos do carrinho. Atualmente ele se encontra dessa forma:

<td>
    <a href="/cart/change?218748921802387812&quantity=0">
        <img src="/excluir.png" alt="Excluir" title="Excluir" />
    </a>
</td>
Em vez de um simples link para remo��o, usaremos um formul�rio com o atributo method configurado como post. Substituiremos o link da tag a e a tag img pela tag input configurando o atributo type com o valor image. As modifica��es propostas ficam assim:

<td>
    <form action="" method="post">
        <input type="image" src="/excluir.png" alt="Excluir" title="Excluir" />
    </form>
</td>
Por �ltimo e n�o menos importante temos o rodap� desta tabela que lista nossos produtos no carrinho. Ela cont�m o seguinte c�digo:

<tfoot>
    <tr>
        <td colspan="3">
            <input type="submit" class="checkout" name="checkout" value="Finalizar compra" />
        </td>
        <td class="quantity-input-cell">
            <input type="submit" class="update-cart" disabled="disabled" name="update" value="" />
        </td>
        <td class="numeric-cell">R$ 59,90</td>
        <td></td>
    </tr>
</tfoot>
S� precisaremos modificar as duas tds centrais. Remover a que tem o name=update por se tratar de algo especifico da Casa do C�digo e fazer com que a que tem o valor R$ 59,90 passe a exibir o total calculado pelo carrinho de compras. Esta parte do c�digo modificada deve ficar parecida com o c�digo abaixo:

<tfoot>
    <tr>
        <td colspan="3">
            <input type="submit" class="checkout" name="checkout" value="Finalizar compra" />
        </td>
        <td class="numeric-cell">${carrinhoCompras.total}</td>
        <td></td>
    </tr>
</tfoot>
Na classe CarrinhoItem, precisaremos criar todos os m�todos que usamos na tabela de lista para que a tabela possa funcionar corretamente o mostrar a lista dos produtos no carrinho. Come�aremos pelo m�todo que retorna o pre�o de um produto espec�fico. O m�todo ser� chamado de getPreco e retornar� um objeto do tipo BigDecimal e este m�todo simplesmente usar� o objeto produto para retornar o pre�o escolhido pelo usu�rio atrav�s do objeto tipoPreco, veja o c�digo:

public BigDecimal getPreco(){
    return produto.precoPara(tipoPreco);
}
O m�todo precoPara n�o existe na classe Produto. Crie-o. Neste m�todo, precisaremos filtrar de todos os pre�os, o preco escolhido e logo ap�s encontra-lo retornar seu valor atrav�s do m�todo getvalor(). Observe o c�digo abaixo:

public BigDecimal precoPara(TipoPreco tipoPreco) {
    return precos.stream().filter(preco -> preco.getTipo().equals(tipoPreco)).findFirst().get().getValor();        
}
Outro m�todo que precisamos implementar � o que soma o total de um produto espec�fico e recebe um CarrinhoItem. O m�todo far� o seguinte c�lculo: Quantidade de vezes que aquele item foi adicionado no carrinho vezes o seu pre�o. Na classe CarrinhoCompras teremos ent�o um m�todo chamado getTotal que recebe um CarrinhoItem e chama o m�todo getTotal daquele item. Passando para este m�todo a quantidade de vezes que o produto foi adicionado ao carrinho. At� aqui teremos:

public BigDecimal getTotal(CarrinhoItem item){
    return item.getTotal(getQuantidade(item));
}
E na classe CarrinhoItem teremos:

public BigDecimal getTotal(int quantidade) {
    return this.getPreco().multiply(new BigDecimal(quantidade));
}
Note como � simples, estamos recuperando o pre�o do produto e usando o m�todo multiply da classe BigDecimal e passando para este m�todo um novo BigDecimal pois o valor recebido por par�metro � do tipo int.

Agora precisamos mostrar o valor total do carrinho, at� aqui s� calculamos o total de um produto espec�fico. Para calcular o total do carrinho, s� precisamos fazer um la�o na classe CarrinhoCompras que a cada itera��o chame o m�todo getTotal criado anteriormente. Passando como par�metro o produto atual e guardando o resultado de cada itera��o em uma vari�vel. Este m�todo tamb�m se chamar� getTotal, mas n�o receber� par�metros. Vejamos no c�digo como fica:

public BigDecimal getTotal(){
    BigDecimal total = BigDecimal.ZERO;
    for (CarrinhoItem item : itens.keySet()) {
        total = total.add(getTotal(item));
    }
    return total;
}
Para podermos testar, vamos ajustar outros dois detalhes que s�o: O CarrinhoComprasController n�o tem nenhum m�todo mapeando a p�gina de itens do carrinho e vamos fazer com que ao adicionar um produto, o usu�rio seja redirecionado para a p�gina de itens do carrinho.

Para o primeiro ponto, precisaremos de um novo m�todo. Chamaremos este m�todo de itens e o mapeamento ser� o mesmo do controller que � /carrinho. Neste caso especificaremos apenas o m�todo HTTP que ser� GET. Este m�todo apenas cria um objeto ModelAndView direcionando a requisi��o para a p�gina itens.jsp. Vejamos em c�digo:

@RequestMapping(method=RequestMethod.GET)
public ModelAndView itens(){
    return new ModelAndView("/carrinho/itens");
}
Observa��o: Lembre-se que esta adi��o e a pr�xima modifica��o � para ser feita na classe CarrinhoComprasController.

E para o ajuste do segundo ponto, precisamos apenas alterar o m�todo add para que em vez de redirect:/produtos este fa�a redirect:/carrinho.

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
    carrinho.add(carrinhoItem);
    return modelAndView;
}
Se iniciarmos o servidor agora, teremos um erro do tipo NotSerializableException informando que o objeto da classe CarrinhoCompras n�o � serializ�vel. Isso acontece, porque o servidor ao verificar que um objeto est� em escopo de sess�o, ele tenta salvar este objeto em arquivo. Para que ele possa sempre salvar a sess�o e recuperar este objeto. Para resolvermos isto, basta fazer com que a classe CarrinhoCompras implemente a interface Serializable.

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras implements Serializable{

    private static final long serialVersionUID = 1L;

}
Perceba que a interface Serializable n�o adiciona nenhum m�todo, mas sim um atributo est�tico. Agora podemos testar! Fa�a todos os passos de uma compra normal, visite a lista de produtos, adicione alguns ao carrinho de compras e clique em Finalizar Compra. Verifique se tudo est� funcionando corretamente e prossiga para a pr�xima aula, onde continuaremos a desenvolver nosso carrinho de compras.


--------------------------------------------------------------------------------------------------
<h1>Se��o 14 - Finalizando o carrinho</h1>

Nosso carrinho de compras j� funciona. Al�m de listar os produtos escolhidos, ele mostrar� o total da soma dos pre�os dos produtos. O que falta fazer para que a aplica��o fique completa � que ao clicar no bot�o de finaliza��o da compra, a compra seja registrada.

J� que a compra � algo especifico e diferente da l�gica do carrinho, criaremos um novo controller para podermos implementar tal funcionalidade. Crie uma nova classe chamada PagamentoController e a defina como controller assinando a mesma com a anota��o @Controller. Defina tamb�m o caminho que o controller ir� atender atrav�s da anota��o @RequestMapping com o valor /pagamento.

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

}
Neste controller criaremos um m�todo respons�vel por finalizar as compras dos usu�rios. Chamaremos este m�todo de finalizar e ele retornar� um objeto do tipo ModelAndView redirecionando o usu�rio para a listagem dos produtos ou seja redirect:/produtos. Este m�todo tamb�m ser� anotado com a anota��o @RequestMapping usando o valor /finalizar.

O m�todo finalizar n�o precisa receber nenhum par�metro, mas ele precisa do carrinho de compras. O carrinho de compras j� est� no escopo de sess�o e para que o tenhamos em m�os, precisamos apenas criar um novo atributo na classe PagamentoController do tipo CarrinhoCompras anotado com @Autowired. Desta forma o Spring j� busca a atribui o carrinho de compra em nosso controller. Por hora, vamos apenas imprimir o total da compra e redirecionar. At� aqui teremos:

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

    @Autowired
    CarrinhoCompras carrinho;
    @RequestMapping("/finalizar")
    public ModelAndView finalizar(){
        System.out.println(carrinho.getTotal());
        return new ModelAndView("redirect:/produtos");
    }
}
Parece estranho redirecionar o usu�rio e n�o inform�-lo se o processo funcionou bem. Pensando nisto, vamos fazer uso da classe RedirectAttributes que chamaremos de model e do m�todo addFlashAttribute para exibirmos uma mensagem amig�vel para o usu�rio. Nos campos de chave e valor do m�todo addFlashAttributes usaremos sucesso e Pagamento Realizado com Sucesso respectivamente.

    model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso");
Com as altera��es, o nosso c�digo ficar� assim:

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

    @Autowired
    CarrinhoCompras carrinho;

    @RequestMapping(value="/finalizar", method=RequestMethod.POST)
    public ModelAndView finalizar(RedirectAttributes model){
        System.out.println(carrinho.getTotal());
        model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso");

        return new ModelAndView("redirect:/produtos");
    }
}
Usamos como chave da mensagem o valor sucesso, porque na p�gina de listagem dos produtos em lista.jsp j� h� um c�digo respons�vel por exibir mensagens que venham com esta mesma chave. L� deve haver uma linha c�digo como esta:

<p> ${sucesso} </p>
Agora queremos que ao clicar no bot�o de finalizar a compra, a requisi��o seja enviada para o PagamentoController e que o m�todo finaliza seja chamado. Veja como est� o bot�o de finalizar compra atualmente:

<td colspan="3">
    <input type="submit" class="checkout" name="checkout" value="Finalizar compra" />
</td>
O bot�o � um input. Por quest�es de pr�tica, vamos envolver este input com a tag form. Vamos definir o action deste formul�rio com a ajuda das tags do Spring (s:mvcUrl) e ajustar o atributo method para que seja post. Desta forma teremos:

<form action="${s:mvcUrl('PC#finalizar').build()}" method="post">
    <input type="submit" class="checkout" name="checkout" value="Finalizar compra" />
</form>
J� que estamos usando post como m�doto no formul�rio, vamos fazer com que o m�todo finalizar receba apenas requisi��es post, pois n�o faz muito sentido recebermos uma requisi��o do tipo get neste contexto. Ajuste a assinatuda do m�doto finalizar para que esta fique da seguinte forma:

@RequestMapping(value="/finalizar", method=RequestMethod.POST)
public ModelAndView finalizar(RedirectAttributes model){
    System.out.println(carrinho.getTotal());

    model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso");

    return new ModelAndView("redirect:/produtos");
}
Assim j� poderemos fazer os testes necess�rios para saber se tudo que fizemos at� o momento funciona. Inicie ent�o o servidor e tente efetuar uma compra. Adicione alguns produtos ao carrinho e clique em Finalizar Compra.

Ao iniciar nossa aplica��o, teremos uma mensagem de erro:

Error creating bean with name 'carrinhoCompras': Scope 'session' is not active for the current thread;
O Spring n�o conseguiu atribuir o carrinho de compras da sess�o ao PagamentoController. J� vimos este problema antes na classe CarrinhoComprasController e resolvemos usando a anota��o que muda o escopo do controller. Desta vez, resolveremos este problema de uma outra forma.

Na classe CarrinhoCompras, usamos a anota��o:

@Scope(value=WebApplicationContext.SCOPE_SESSION)
Passaremos para esta mesma anota��o uma segunda informa��o definindo que o Spring criar� um proxy envolvendo o objeto alvo (TARGET_CLASS) afim de possibilitar que as informa��es possam ser transitadas de um escopo para o outro. A anota��o com a modifica��o proposta fica da seguinte forma:

@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS).
Assim conseguiremos fazer com que o carrinho de compras seja acessivel dentro dos controllers sem ter que mudar o escopo dos controllers para isso. Reinicie ent�o o servidor e experimente fazer algumas compras.

Compra efetuada com sucesso

Nosso pr�ximo passo ser� fazer com que o link de remo��o de produtos do carrinho funcione. Come�aremos adicionando o action correto para esta finalidade na p�gina itens.jsp. Nesta p�gina procure pelo link de remo��o que deve estar da seguinte forma:

<td class="remove-item">
    <form action="" method="post">
        <input type="image" src="/excluir.png" alt="Excluir" title="Excluir" />
    </form>
</td>
Usaremos novamente as tags do Spring para esta tarefa. No mvcUrl criaremos uma url que aponte para o CarrinhoComprasController e chame o m�todo remover. Este m�todo precisar� do id e o tipo de pre�o do produto, ent�o o passaremos atrav�s do arg da seguinte forma:

<td class="remove-item">
    <form action="${s:mvcUrl('CCC#remover').arg(0, item.produto.id).arg(1,item.tipoPreco).build() }" method="post">
        <input type="image" src="/excluir.png" alt="Excluir" title="Excluir" />
    </form>
</td>
Na classe CarrinhoComprasController precisamos adicionar o m�todo remover que far� simplesmente uma chamada ao m�todo remover da classe CarrinhoCompras passando o id do produto recebido e o tipo de pre�o do produto. Ap�s isso, o m�todo remover da classe CarrinhoComprasController criaremos um objeto do tipo ModelAndView para redirecionar o usu�rio para seu carrinho de compras. Em c�digo teremos:

@RequestMapping("/remover")
public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco){
    carrinho.remover(produtoId, tipoPreco);
    return new ModelAndView("redirect:/carrinho");
}
Observa��o: Note que estamos fazendo o mapeamento do m�todo com a anota��o @RequestMapping com o valor /produtos.

Para finalizar esta funcionalidade, precisamos fazer com que a classe CarrinhoCompras remova o produto da lista de itens. Lembre-se que os itens desta lista s�o objetos da classe CarrinhoItem. Sendo assim, precisamos criar um objeto CarrinhoItem que precisa de um objeto Produto e em TipoPreco.

O objeto TipoPreco j� esta sendo passado por par�metro, mas o produto n�o. Estamos recebendo apenas o id do produto. Como fazer ent�o? Poder�amos buscar este produto no banco de dados, mas na verdade, neste ponto, n�o precisamos disso. Neste caso em especifico, podemos criar um novo objeto produto e usar o m�todo setId para definir o id do produto com o id recebido por par�metro. Desta forma criamos um carrinhoItem e usamos o m�todo remove do objeto itens na classe CarrinhoCompras passando este carrinhoItem criado. Vejamos como fica em c�digo:

public void remover(Integer produtoId, TipoPreco tipoPreco) {
    Produto produto = new Produto();
    produto.setId(produtoId);
    itens.remove(new CarrinhoItem(produto, tipoPreco));
}
Observa��o: Lembre-se de que este m�todo remove � para ser escrito na classe CarrinhoCompras.

Fa�a alguns testes para verificar que tudo est� funcionando. Reinicie o servidor, v� at� lista de produtos, adicione alguns no carrinho de compras, remova alguns e finaliza a compra. Tudo deve estar funcionando sem problemas.

Realizando pagamento
Ao encerrar uma compra, � muito comum que as aplica��es usem uma outra aplica��o terceirizada para o processamento do pagamento. Aplica��es como Paypal e PagSeguro s�o exemplos de sistemas que geralmente se usam para processar o pagamento da compra. Em nosso caso, usaremos uma pequena aplica��o hospedada em http://book-payment.herokuapp.com/payment.

A aplica��o de pagamento apresentada anteriormente serve para podermos verificar se os dados est�o sendo enviados corretamente, ela n�o processa realmente o pagamento, mas simula a situa��o. Ela espera receber uma requisi��o do tipo POST enviando um JSON com o seguinte formato: {"value": 500} onde no lugar do valor 500 enviaremos o valor da compra.

Observa��o: Esta aplica��o limita o valor do pagamento a 500. Valores acima deste retornam uma mensagem de que o valor n�o � permitido.

Para alguns testes pontuais, usaremos uma outra ferramenta para verificar algumas coisas, como por exemplo o tempo e a resposta em que a requisi��o ocorre e � respondida. No Google Chrome, voc� pode instalar uma extens�o chamada DHC.

Extens�o DHC no Google Chrome

E no Mozilla Firefox voc� pode usar o HttpRequester:

HttpRequester no Firefox

Observa��o: Note que as imagens mostram uma captura de tela das extens�es com alguns testes realizados. Fa�a alguns tamb�m para ter certeza que est� tudo funcionando corretamente.

O problema agora � conseguir fazer com que a nossa aplica��o consiga enviar uma requisi��o para outra aplica��o. N�o podemos redirecionar o navegador neste caso. O que precisamos fazer � chamado de integra��o, os sistemas se comunicam entre si de forma independente do navegador.

Para a solu��o deste tipo de problema, o Spring nos disponibiliza uma classe com a qual podemos fazer as requisi��es que precisamos. Esta classe � a RestTemplate. Ela tem um m�todo chamado postForObject que requer tr�s par�metros. O primeiro deles � a url na qual queremos enviar a requisi��o, o segundo � o objeto que representa a mensagem (o corpo) da requisi��o e por �ltimo uma classe na qual esperamos receber uma resposta do tipo.

Vamos ent�o fazer uso do RestTemplate em nossa classe PagamentoController. Crie um atributo deste tipo e o assine com a anota��o @Autowired.

@Controller
@RequestMapping("/pagamento")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

    @Autowired
    CarrinhoCompras carrinho;

    @Autowired
    RestTemplate restTemplate;
    [...]
}
No m�todo finaliza faremos o seguinte procedimento: Criar uma String que guardar� a url para onde a requisi��o ser� enviada. Chamar o m�todo postForObject do objeto restTemplate usando a String criada, um objeto da classe DadosPagamento (que ainda n�o temos mas vamos criar daqui a pouco) usando o valor total do carrinho e por �ltimo, dizer que esperamos uma resposta do tipo String, passando String.class como �ltimo par�metro.

String url = "http://book-payment.herokuapp.com/payment";
restTemplate.postForObject(url, new DadosPagamento(carrinho.getTotal()), String.class);
J� que se � esperada uma resposta da requisi��o enviada, vamos atribuir o resultado deste m�todo a um objeto String que chamaremos de response e usa-lo para exibir a mensagem recebida tanto no console, quanto na view. Veja o m�todo finaliza como fica ao final:

@RequestMapping(value="/finalizar", method=RequestMethod.POST)
public ModelAndView finalizar(RedirectAttributes model){

    String uri = "http://book-payment.herokuapp.com/payment";
    String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);

    model.addFlashAttribute("message", response);
    System.out.println(response);

    return new ModelAndView("redirect:/produtos");
}
Agora precisamos criar a classe DadosPagamento que deve receber o valor da compra e guardar em um atributo do tipo BigDecimal. Veja como fica simples esta classe:

public class DadosPagamento {
    private BigDecimal value;

    public DadosPagamento(BigDecimal value) {
        this.value = value;
    }

    public DadosPagamento() {
    }

    public BigDecimal getValue() {
        return value;
    }
}
Lembre-se de criar esta classe dentro do pacote de modelos. Observe que o nome do atributo � o mesmo que o sistema de pagamentos espera receber. Isto � necess�rio pois o Spring ir� transformar o objeto desta classe em um objeto JSON. Por padr�o ele ir� criar a chave com o nome do atributo da classe e o valor ser� o mesmo do definido no atributo.

Para podermos testar, nos falta apenas criar uma configura��o b�sica para que o Spring consiga criar o objeto RestTemplate corretamente. Para isso criaremos um novo m�todo na classe WebAppConfiguration anotado com @Bean e que apenas retorna um objeto do tipo RestTamplate.

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class, FileSaver.class, CarrinhoCompras.class})
public class AppWebConfiguration {
    [...]

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
Agora podemos testar nossa aplica��o. Inicie o servidor e efetue o processo de compra, v� at� a listagem de produtos, adicione alguns ao carrinho e clique em Finalizar Compra. E veja o que acontece:

HTTP Status 500 - Request processing failed

Obtemos um erro 500 ao finalizar a compra. Por que? Veja o que diz a mensagem de erro:

Could not write request: no suitable HttpMessageConverter found for request type [br.com.casadocodigo.loja.models.DadosPagamento]
O Spring n�o conseguiu transformar o objeto da classe DadosPagamento em JSON. Veja que ele pede por um HttpMessageConverter. Perceba que mesmo o Spring se encarregando de fazer a convers�o do objeto de DadosPagamento para JSON n�o dissemos em lugar nenhum como ele deve fazer isto. Existe uma biblioteca que j� faz essa tarefa, esta biblioteca se chama jackson. Vamos utiliz�-la.

Abra seu pom.xml e adicione as seguintes dependencias:

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.5.1</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.5.1</version>
</dependency>
Salve seu pom.xml e atualize o projeto. Tente iniciar e refazer o processo de compra. Tudo deve funcionar normalmente. Mas veja o que acontece quando testamos com um valor acima de 500.

Bad Request Error - valor acima do permitido

Recebemos um erro do tipo Bad Request. Lembre-se que o sistema de pagamentos que estamos simulando retorna um erro de n�mero 400 do HTTP quando o valor excede o valor de 500. Para que essa mensagem de erro seja mostrada para o usu�rio, vamos fazer uso de um bloco try/catch e caso aconte�a o erro, mostraremos uma mensagem amig�vel. Veja como ficar� o m�todo finaliza da classe PagamentoController:

@RequestMapping(value="/finalizar", method=RequestMethod.POST)
public ModelAndView finalizar(RedirectAttributes model){

    try {
        String uri = "http://book-payment.herokuapp.com/payment";
        String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
        model.addFlashAttribute("sucesso", response);
        System.out.println(response);
        return new ModelAndView("redirect:/produtos");
    } catch (HttpClientErrorException e) {
        e.printStackTrace();
        model.addFlashAttribute("falha", "Valor maior que o permitido");
        return new ModelAndView("redirect:/produtos");
    }
}
Com esta adi��o em nosso c�digo, paramos de exibir a mensagem de erro do pr�prio Spring e passamos a exibir uma mensagem mais amig�vel ao usu�rio.Lembre-se de exibir a mensagem de falha atrav�s de ${falha} no arquivo lista.jsp. Onde se encontra a listagem dos produtos.

Fazendo requisi��es ass�ncronas.
O comportamento padr�o da nossa aplica��o atualmente tem um problema bem comum em diversas aplica��es do g�nero. Perceba que ao finalizar uma compra a aplica��o envia os dados de pagamento para um outro sistema e fica aguardando uma resposta. Enquanto aguarda uma reposta a aplica��o simplesmente para. Isto porque ela executa em uma �nica thread.

Atualmente como estamos fazendo poucas opera��es ao finalizar uma compra, isso pode n�o aparentar um problema, mas em um sistema real ser�, pois ao finalizar uma compra, geralmente a opera��o envolve envio de emails, confirma��o de pagamento por terceiros e registro da compra. Juntando essa quantidade de atividades a um poss�vel grande n�mero de usu�rios acessando o sistema, teremos problemas com um sistema lento que pode trazer diversos outros problemas como queda nas vendas por exemplo.

Pensando nisso, podemos fazer uma pequena otimiza��o na funcionalidade de finaliza��o da compra. Faremos com que ao o usu�rio finalizar uma compra a requisi��o seja feita de forma ass�ncrona e que somente este usu�rio aguarde a resposta do processamento. Desta forma os demais usu�rios continuam usando a aplica��o sem nenhum problema.

Para implementarmos essa modifica��o, precisamos apenas modificar a assinatura do m�todo finalizar na classe PagamentoController para que retorne um objeto Callable do tipo ModelAndView. Veja como fazemos isso:

@RequestMapping(value="/finalizar", method=RequestMethod.POST)
public Callable<ModelAndView> finalizar(RedirectAttributes model){
    return () -> {
        try {
            String uri = "http://book-payment.herokuapp.com/payment";
            String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
            model.addFlashAttribute("message", response);
            System.out.println(response);
            return new ModelAndView("redirect:/produtos");
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            model.addFlashAttribute("message", "Valor maior que o permitido");
            return new ModelAndView("redirect:/produtos");
        }
    };
}
Observa��o: Observe que estamos usando novamente recursos do Java 8. Esta forma de usar lambda nos permite criar um objeto do mesmo tipo esperado pelo retorno do m�todo, evitando que criemos uma classe an�nima. Neste caso � perfeitamente aplic�vel o recurso, por que na interface Callable s� h� um m�todo, de nome call.

Conhe�a mais sobre Java 8 fazendo o curso dispon�vel aqui no Alura. Clique aqui para ver o curso

A otimiza��o feita n�o poder� ser analisada em ambiente local como estamos desenvolvendo, mas sim acompanhando o dia a dia da aplica��o, com muitos usu�rios e requisi��es transitando pela aplica��o. Mas � possivel fazer alguns testes atrav�s do JMetter, uma ferramenta para testes de performace. Leia mais sobre o JMetter na documenta��o do mesmo em: http://jmeter.apache.org/.