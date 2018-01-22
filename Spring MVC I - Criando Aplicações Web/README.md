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

