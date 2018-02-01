----------------------------------------------------------------------------------------------------
<h1>Seção 01 - Começando com SpringMVC</h1>

Bem-vindo ao curso de SpringMVC! Neste curso estudaremos o SpringMVC e alguns dos seus módulos para resolver problemas reais. Neste curso criaremos um projeto semelhante a Casa do Código, no qual há várias peculiaridades que desenvolveremos com o SpringMVC.

SpringMVC é um framework Java e como todo projeto java, temos que configurar nosso ambiente de desenvolvimento para conseguirmos desenvolver o projeto. Neste caso, usaremos o JBoss Forge, um framework criado pela JBoss para a criação da estrutura inicial do projeto.

Antes de continuarmos, baixe o JBoss Forge no site forge.jboss.org, descompacte em um diretório de sua preferência e renomeie o diretório do JBoss Forge para forge. Este último passo foi feito para deixar mais simples a interação com o JBoss Forge, pois o usaremos através do terminal.

Com o terminal aberto, navegue até o diretório onde está o JBoss Forge (pasta forge renomeada no passo anterior) e execute o JBoss dentro de bin/forge. Este executável é um terminal disponibilizado pelo JBoss Forge para que possamos configurar a estrutura inicial do projeto.

Atenção: O passo anterior pode demorar um pouco para ser finalizado, pois o JBoss irá carregar uma série de itens para que possamos usá-lo.

Neste momento, já dentro do terminal do JBoss, podemos digitar e executar o seguinte comando para criar o projeto: project-new --named casadocodigo. Este comando indica para o JBoss que queremos um novo projeto (project-new) e que este projeto terá o nome casadocodigo (--named casadocodigo).

Observação: Nas versões mais recentes do JBoss o comando para criar um novo projeto mudou para new-project, ou seja, utilize o comando new-project --named casadocodigo para criar o projeto caso encontre o erro: ***ERROR*** No such command: project-new .

"** \*\*\*Success\*\*\* ** Project named 'casadocodigo' has been created!"
Sucesso! Nosso projeto inicial está criado!

Observação: Se verificar no site do JBoss Forge, notará que o projeto criado por este framework, é um projeto Maven-based, ou seja, um projeto baseado no Maven. Note que na pasta onde o JBoss Forge há uma nova pasta com o nome do projeto.

Podemos agora abrir o eclipse e fazer os seguintes passos: Abrir a ferramenta de import, escolher que queremos importar um projeto Maven e selecionar o projeto criado com o JBoss Forge!

Clique com o direito no project explorer do Eclipse e vá até a opção de import e selecione import.

Na caixa de filtro, digite maven para que o eclipse filtre as opções de importe e selecione Existing Maven Projects.

Em Root Directory, selecione Browse e navegue pelas pastas até chegar na pasta do projeto (casadocodigo). Selecione a pasta do projeto e clique em Open. Após isso note que o eclipse reconheceu o projeto e já exibe na listagem o pom.xml do projeto. Clique em Finish!

Nosso projeto agora é listado no eclipse, com a estrutura padrão criada com o JBoss Forge. Seu projeto deve estar parecido com a imagem abaixo:

Visualização do projeto na perspectiva JavaEE

Para deixarmos o projeto com um fluxo um pouco mais simples de se trabalhar e visualizar, vamos mudar a perspectiva do eclipse de Java EE para Java. Podemos fazer isso acessando os menus:

Window -> Perspective -> Open Perspective -> Other
selecionando a perspectiva Java e clicando em ok note como a estrutura do projeto é exibida de forma mais simples.

Visualização do projeto na perspectiva Java

Experimente explorar as pastas do projeto!

Com a estrutura inicial do projeto pronta, podemos começar a criar algumas páginas para podermos visualizar o projeto funcionando. Clique na pasta webapp do projeto e use o atalho ctrl + n para criarmos um novo arquivo. Na caixa de seleção que aparece, digite html para criarmos um arquivo HTML. Selecione a opção HTML File. Em File name digite index.html e clique em Finish.

O código do index.html deve estar parecido com este:

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
Modifique o título, coloque algum código no corpo do HTML, para visualizar depois como ficou. Algo como:

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Livros de Java, Android, iPhone, PHP, Ruby e Muito mais - Casa Do Código</title>
</head>
<body>
    <h1>Oi</h1>
</body>
</html>
Com este último passo, estamos prontos para vermos nosso projeto funcionando, mas temos que configurar mais uma coisa, o servidor!

Baixe o Tomcat (versão 7) no site da Apache e descompacte em um diretório de sua preferência. Após isso, no eclipse use a barra de pesquisa na parte superior direita e procure por servers. Abra esta aba.

Abrindo aba servers no Eclipse

Quando a aba de servers do eclipse for aberta, clique com o direito do mouse na área da aba aberta e selecione new -> server. Há uma lista de servidores que podemos usar, vamos selecionar o Apache -> Tomcat V0.7 Server e clique em Next.O próximo passo é seleciona o diretório onde nosso Tomcat está instalado, clique em Browse e navegue pelas pastas até encontrar a pasta do Tomcat e selecione esta pasta e clique em Finish.

Nosso servidor deve ser listado na aba servers do eclipse. Devemos agora adicionar nosso projeto no servidor. Cliquando com o botão direito sobre o servidor e selecionando a opção add/remove visualizamos nosso projeto na listagem.Para adiciona-lo ao servidor, basta selecionar o projeto e clicarmos em add e depois em Finish. Podemos iniciar então o servidor clicando com o direito novamente sobre o servidor e selecionando a opção start.

Nosso projeto já está rodando no servidor, para verificar, basta acessar com um navegador a url: localhost:8080/casadocodigo.

Apesar de funcionar, não é esse nosso real objetivo, queremos nossa lista de livros igual a casa do código!

Até o momento, não usamos nada do SpringMVC e neste ponto que sabemos que está tudo funcionando perfeitamente, podemos começar a usar o SpringMVC de fato!

Criando o primeiro controller.
Criaremos agora nosso primeiro controller! O controller é nada mais nada menos que uma classe Java, então crie uma classe com o nome de HomeController no pacote br.com.casadocodigo.loja.controllers.

package br.com.casadocodigo.loja.controllers;

public class HomeController{

}
O que temos aqui não é nada mais que uma simples classe java. Nós ainda não dissemos para o SpringMVC que esta classe é um controller! Podemos fazer esta definição de duas formas: 1. Usando regras de XML. 2. Usando anotaçoes Java.

Por questões de simplicidade, usaremos a segunda forma, para isto só precisamos adicionar a anotação @Controller logo acima da definição da nossa classe:

package br.com.casadocodigo.loja.controllers;

@Controller
public class HomeController{

}
Note que apesar de termos feito todos estes passos, o Eclipse marca de vermelho a anotação @Controller, como se ele não entendesse a anotação. Isso acontece porque em momento nenhum configuramos o SpringMVC para nosso projeto. Para isso precisamos declarar algumas dependências no arquivo pom.xml para que o Maven baixe e configure o SpringMVC para o nosso projeto.

Abra o arquivo pom.xml e na aba pom.xml cole as dependências do projeto logo abaixo do fechamento da tag <properties>.

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
Salve o pom.xml e aguarde um momento, o Maven deverá baixar e configurar as dependências do nosso projeto. Um novo diretório chamado Maven Dependencies deve aparecer no projeto (Isso pode demorar um pouco já que o Maven irá baixar as dependências).

Tudo parece funcionar perfeitamente! Vamos agora criar um metodo em nossa classe que será responsável por atender as requisições que chegam na página inicial do nosso projeto, ou seja, o endereço raiz ("/"). Em nosso controller teremos o código:Observação: Lembre-se de fazer os imports necessários (Atalho: Ctrl + Shift + O)

[...]
@Controller
public class HomeController{

    @RequestMapping("/")
    public void index(){
        System.out.println("Entrando na home da CDC");
    }

}
Uma novidade em nosso código é a anotação @RequestMapping, que tem a função de definir que aquele metodo atende a um determinado path ou endereço. Neste caso estamos definindo que o metodo index atenderá as requisições que chegarem na raiz do nosso projeto ("/").Se entrarmos em nosso projeto agora, deveriamos visualizar a mensagem do escrita no System.out.println certo? Ainda não!

Em nenhum momento até agora, configuramos o SpringMVC para atender as requisições que chegam para nossa aplicação. Se acessarmos através do navegador o nosso projeto, veremos a mensagem de Oi que fizemos no arquivo index.html.

Existem duas formas de configurarmos o servidor Tomcat para que ele passe as requisições para o SpringMVC: 1. Usando o Servets 2. Usando os Filtros

Usaremos a primeira opção, pois o SpringMVC já vem com um servlet pronto para utilizarmos como servlet de configuração. Podemos configura-lo através de XML ou código Java e mais uma vez usaremos código java!

Crie uma nova classe dentro do pacote br.com.casadocodigo.loja.conf chamada de ServletSpringMVC. Com a classe criada, faça ela extender a classe: AbstractAnnotationConfigDispatcherServletInitializer.

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

}
A classe ServletSpringMVC parece estar com erros agora que extendemos a classe do SpringMVC. A classe do SpringMVC contém alguns métodos que precisamos implementar! Clique sobre o nome da Classe ServletSpringMVC use o atalho Ctrl + 1 e selecione a opção: Add Unimplemented Methods. Veja que o Eclipse completou nossa classe com alguns metodos:

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
Implementaremos os dois últimos metodos. O getServletConfigClasses pede um array de classes de configurações, que ainda não temos, mas que iremos criar depois. O getServletMappings pede um array com os mapeamentos que queremos que nosso servlet atenda. Nossa implementação ficará assim:

@Override
protected Class<?>[] getServletConfigClasses() {
    return new Class[] {AppWebConfiguration.class};
}

@Override
protected String[] getServletMappings() {
    return new String[] {"/"};
}
Como estas configurações estamos definindo que o servlet do SpringMVC atenderá as requisições a partir da raiz do nosso projeto (/) e que a classe AppWebConfiguration será usada como classe de configuração do servlet do SpringMVC.Crie a classe AppWebConfiguration no pacote br.com.casadocodigo.loja.conf.

Na classe AppWebConfiguration nós precisamos usar o recurso de Web MVC do SpringMVC. Podemos fazer isso através de mais uma anotação. Antes da declaração da classe devemos adicionar a anotação: @EnableWebMvc.

@EnableWebMvc
public class AppWebConfiguration {

}
Precisamos também configurar o caminho (pacote) onde o SpringMVC irá encontrar os nossos controllers! Mais uma anotação para esta configuração é necessária: @ComponentScan.Isso somente não resolve nosso problema, o ComponentScan precisa saber onde procurar os nossos controllers e podemos indicar isso passando um paramêtro. Exitem duas possibilidades:1. @ComponentScan(basePackages={""}) que recebe um array de Strings com os nomes dos pacotes onde o SpringMVC pode encontrar os controllers.

@ComponentScan(basePackageClasses={}) que recebe um array de classes de onde o SpringMVC pode extrair os pacotes nos quais ele pode encontrar os controllers.
A segunda opção é a melhor escolha, pois podemos passar classes que estão no mesmo pacote dos controllers e assim o SpringMVC descobre o pacote de forma automática, diferente da primeira opção, que é mais manual.Com a primeira opção, caso o pacote mude, temos que lembrar de modificar essa configuração também.Para a segunda opção, passaremos então nossa classe HomeController. Assim o SpringMVC descobre o pacote desta classe e pode encontrar os outros controllers automáticamente.

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class})
public class AppWebConfiguration {

}
Se iniciarmos nosso servidor agora, devemos ter alguma mudança visível em nossa aplicação! Acessando-a pelo navegador (em localhost:8080/casadocodigo) temos:

Home com erro  404

Erro 404! Porque? O que aconteceu? Nossas configurações estão todas certas e aparentemente o projeto não funcionou! Acontece que o SpringMVC está com um conflito de recursos, nós mapeamos a rota "/", mas o servidor por padrão, quando recebe uma requisição para o "/" ele retorna o index que estiver naquele endereço!Para resolvermos isso, basta deletar o arquivo index.html. Atualizando a página teremos:

Home com erro 500 (no view name)

Erro 500! O que aconteceu agora? veja a mensagem de erro: javax.servlet.ServletException: Could not resolve view with name '' in servlet with name 'dispatcher'. O SpringMVC está procurando uma view de nome vazio? Note que no log do Eclipse que nossa mensagem no System.out.println do método index foi impressa! Isso indica que o SpringMVC chamou nosso metodo index. Mesmo assim ele continua com o erro dizendo que não encontrou uma view.

Vamos modificar nosso controler para retornar a view que o SpringMVC espera receber. No nosso HomeController modificamos o metodo index para ficar da seguinte forma:

@RequestMapping("/")
public String index(){
    System.out.println("Entrando na home da CDC");
    return "home.jsp";
}
Agora estamos retornando uma String que representa o nome da view. Se atualizarmos no navegador a página do nosso projeto, podemos visualizar que o erro mudou! Ainda é um erro 500 mas desta vez o SpringMVC identifica a view que foi retornada pelo método: home.jsp.

Erro 500 com nome da view impressa

Apesar de termos retornado uma view, não temos esta view criada ainda! Crie então o home.jsp dentro da pasta webapp do seu projeto (Use os atalhos do Eclipse). Seu home.jsp deve ficar parecido com este:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
    <h1>Casa do Código</h1>
</body>
</html>
Apenas este passo não resolve nosso problema, pois o SpringMVC ainda não sabe onde encontrar as views do nosso projeto. Antes de fazermos esta configuração, vamos fazer algumas modificações por questões de boas práticas. 1. Crie uma pasta dentro de webapp chamada WEB-INF. 2. Crie uma pasta dentro de WEB-INF chamada views. 3. Mova o arquivo home.jsp para dentro da pasta views.

A pasta WEB-INF é uma pasta protegida pelo servidor. Este que não permite que os arquivos dentro dela sejam acessados diretamente. É uma boa prática que deixemos nossas views dentro desta pasta para que o usuário não consiga acessar as páginas de forma direta, sem que ele passe pelo controller, pois se a view for acessada sem passar pelo controller, podemos ter quebra de regras negócio para aquela view.

Nosso próximo passo é configurar o projeto para que o SpringMVC consiga encontrar as views. Essa configuração é feita na classe de configuração AppWebConfiguration. Nesta criaremos um novo metodo que ajudará o SpringMVC a encontrar nossas views:

@Bean
public InternalResourceViewResolver internalResourceViewResolver(){
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
}
Este método na classe AppWebConfiguration retorna um objeto do tipo InternalResourceViewResolver (Resolvedor Interno de Recursos de View) que ajuda o SpringMVC a encontrar as views. O setPrefix define o caminho onde estão nossas views, já o setSuffix adiciona a extenção dos arquivos de view.

Note que no final do caminho das views há uma barra "/", ela poderia não estar ai, mas caso não estivesse, teriamos que lembrar que sempre que quisessemos retornar uma view, teriamos que no controller, no retorno da view escrever algo como: return "/pagina.jsp", então colocamos esta barra já na configuração para não termos que nos preocupar com isto.

A anotação @Bean é para que o retorno da chamada deste metódo possa ser gerenciada pelo SpringMVC, sem ela nossa configuração não funciona. Outra observação válida é que já estamos colocando o sufixo dos arquivos (.jsp). Desta forma, não precisamos colocar a extenção dos arquivos de view nos controllers. Sendo assim, modifique o HomeController para retornar apenas "home" em vez de "home.jsp"

Com essas configurações feitas, podemos agora visualizar a página inicial do projeto sem mais problemas. Experimente pôr mais alguns elementos na home.jsp, como por exemplo uma tabela que pode listar alguns livros da casa do código! Algo como:

[...]
<h1>Casa do Código</h1>
<table>
    <tr>
        <td>TDD na Prática - JAVA</td>
        <td>Google Android</td>
     </tr>
    <tr>
        <td>Certificação OCJP</td>
        <td>Java 8 Prático</td>
    </tr>
</table>
[...]

<h2>Avaliando o projeto gerado pelo JBoss Forge</h2>

Para configurar o nosso projeto nós utilizamos o JBoss Forge. Percebeu como o JBoss forge qual é a vantagem ganhamos ao usar?

A grande vantagem de utilizar o JBoss Forge é agilizar a configuração inicial do projeto, permitindo ganhar tempo indo direto para o código.

O JBoss Forge é um gerador de projetos Java. Ele gera toda a estrutura base do projeto integrada com o Maven. Configuração de dependências (bibliotecas e frameworks), estrutura de pastas e gera configurações iniciais que geralmente envolve arquivos XML.

Sem ele, em um projeto tipicamente Java EE, devemos criar vários arquivos XML na mão, por exemplo: persistence.xml, web.xml, faces-config.xml, pom.xml, beans.xml entre outros.

Temos um curso de maven para caso queira aprender mais sobre essa magnífica ferramenta, no qual usamos neste projeto para principalmente gerenciarmos nossas dependências.

<h2>Criando o projeto usando o JBOSS Forge</h2>
Agora que já fizemos o download do JBoss Forge abra o seu terminal navegue até a pasta do forge e execute o comando:

project-new --named [nome do projeto]
Cole aqui os comandos digitados no terminal.
Os comandos ficarão da seguinte forma:

1) Navegue até a sua pasta workspace:

cd /workspace

2) Inicie o terminal do forge:

/forge/bin/forge

3) Crie o projeto:

project-new --named casadocodigo

E como criamos o projeto utilizando o Forge o nosso projeto já vem com o Maven !

---------------------------------------------------------------------------------------------------------------
<h1>Seção 02 - Cadastro de Produtos</h1>

Nossa aplicação está começando a tomar forma. Ela já lista os produtos em nossa home. Agora começaremos a criar o cadastro de produtos, para assim podermos cadastrar livros da Casa do Código.

Para o cadastro de produtos, precisaremos de um formulário. Sendo assim, crie um novo arquivo JSP chamado form.jsp dentro da pasta WEB-INF/views/produtos/. A pasta produtos ainda não existe, teremos que criá-la também. faremos alterações para deixar no padrão HTML 5. O arquivo form.jsp inicial deve estar parecido com esse:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>

</body>
</html>
O próximo passo é criar o html referente ao formulário (form) de cadastro dos livros. Eles terão inicialmente os seguintes atributos: Título, Descrição e Número de Páginas, todos do tipo texto. Vamos então criar o formulário com estes campos. O formulário deve ficar parecido com este:

<form action="/produtos" method="post">
    <div>
        <label>Título</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Páginas</label>
        <input type="text" name="paginas" />
    </div>
    <button type="submit">Cadastrar</button>
</form>
Note que estamos fazendo o formulário enviar seus dados para o path /produtos e que o estamos enviando via post no método do formulário.

Nosso form.jsp deve ser acessado na url localhost:8080/casadocodigo/produtos/form. Se acessarmos agora, veremos uma página de erro 404, pois as views não podem ser acessadas diretamente. Lembra? Como resolvemos isso? Criando um Controller!

Crie então o ProdutosController dentro do pacote br.com.casadocodigo.loja.controllers. Neste Controller crie o método form que retorna a view com o formulário. Mapeie o path que este método vai atender com a anotação @RequestMapping. O ProdutosController deve ficar parecido com este:

@Controller
public class ProdutosController {

    @RequestMapping("/produtos/form")
    public String form(){
        return "produtos/form";
    }

}
Se acessarmos agora o nosso formulário em localhost:8080/casadocodigo/produtos/form, devemos vê-lo sem nenhum problema. Não esqueça de reiniciar o servidor! Teste o formulário, tente cadastrar um livro!

Quando enviamos o formulário, recebemos um erro 404:

Erro 404 com url errada

Mas tem algo estranho neste erro 404 , note a url. O caminho está sem o /casadocodigo/. Isto acontece porque o nosso formulário não aponta /casadocodigo/ em sua action. Vamos fazê-lo apontar, então.

<form action="/casadocodigo/produtos" method="post">
    [...]
</form>
Este é o primeiro passo para resolver nosso problema. Agora precisamos mapear o path /produtos para um método em no ProdutosController. Algo parecido com:

@RequestMapping("/produtos")
public String gravar(String titulo, String descricao, int paginas){
    System.out.println(titulo);
    System.out.println(descricao);
    System.out.println(paginas);

    return "ok";
}
Nosso método atende ao path /produtos e se chama gravar. Este irá gravar os produtos em um banco de dados posteriormente. Ele recebe os dados do produto e imprime no terminal, por fim, retorna "ok" para indicar que tudo ocorreu bem.

Faça alguns testes! Teremos um erro 404 indicando que a view ok não foi encontrada, mas não deixe de verificar se os dados do formulário foram impressos no console. Funciona! O SpringMVC sozinho verifica a assinatura do nosso método e faz um bind dos parâmetros do método com os names do formulário.

Nossa aplicação já funciona, mas antes de continuarmos, vamos melhorar um ponto e corrigir outro.

Primeiro ponto, imagine que o formulário de produtos terá 30 campos. A assinatura do nosso método ficará enorme! Vamos mudar isso, o método gravar requer um produto. Vamos criar um Produto então.

Crie uma classe chamada Produto com os mesmos atributos do formulário e os defina como private. Use os atalhos do Eclipse e gere também os getters and setters. Gere também o toString na classe Produto para que deixemos de imprimir aquela mensagem padrão estranha e possamos imprimir o objeto diretamente de forma amigável.A classe Produto deve estar no pacote br.com.casadocodigo.loja.models.Esta classe representa uma entidade no nosso sistema.

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
Desta forma isolamos todo o comportamento e dados dos produtos em uma classe. Podemos então em nosso Controller receber um Produto em vez de seus dados separadamente.O SpringMVC fará o bind dos names em nosso formulário com os atributos do Produto de agora em diante. Sendo assim, vamos modificar o ProdutosController para recebermos um objeto produto agora.

O método gravar deve ficar assim:

@RequestMapping("/produtos")
public String gravar(Produto produto){
    System.out.println(produto);
    return "/produtos/ok";
}
Agora recebemos um objeto do tipo produto, imprimimos o produto no console e retornamos a view "ok", que deve estar dentro da pasta produtos (perceba que mudamos também o caminho de retorno da view de /ok em /views/ para /produtos/ok em /views/produtos/ok). Crie a view ok.jsp na pasta WEB-INF/views/produtos com uma mensagem de sucesso. Algo como:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
 <h1>Produto cadastrado com sucesso!</h1>
</body>
</html>
Agora, se acessarmos nosso formulário, preenchermos os campos e tentarmos cadastrar um produto (um livro), teremos a mensagem de sucesso e os dados do nosso livro serão mostrados no console. Faça o teste!

produto cadastrado com sucesso

Salvando produtos no banco de dados
Nossa aplicação ainda não salva os produtos no banco de dados. Para essa tarefa usaremos a JPA (Java Persistence API) e o Hibernate, que ainda não estão configurados em nosso projeto. Vamos configura-los agora.

No pom.xml vamos declarar algumas novas dependências. Entre elas estão a JPA, o Hibernate, O SpringORM e o Driver MySQL. No final do pom.xml antes do fechamento da tag <dependencies> cole as seguintes dependencias:

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
Salve o pom.xml e aguarde um momento, pois o Maven irá baixar e deixar disponivel em nosso projeto as bibliotecas que acabamos de adicionar como dependências.

Com as dependências configuradas, podemos começar a criar a lógica responsável por salvar os produtos. O primeiro passo é definir que o produto é uma entidade. Fazemos isso marcando a classe Produto com a anotação @Entity.

import javax.persistence.Entity;

@Entity
public class Produto {
    [...]
}
Atenção: O importe deve ser do pacote: javax.persistence.Entity.

Com este passo a classe Produto já representa uma entidade em nosso sistema. Fazer isso é apenas o primeiro passo, ainda não temos a lógica responsável por efetivamente salvar o produto no banco de dados.

Vamos então criar uma classe de acesso a dados responsável por manipular os dados dos produtos. Criaremos então a classe ProdutoDAO (DAO: Data Access Object ou Objeto de Acesso a Dados). Inicialmente, criamos nesta classe o método gravar que receberá um objeto produto e o salvará no banco de dados. Está classe deve ficar no pacote: br.com.casadocodigo.loja.daos

package br.com.casadocodigo.loja.daos;
import br.com.casadocodigo.loja.models.Produto;

public class ProdutoDAO {

    public void gravar(Produto produto){

    }
}
Para que o ProdutoDAO realize a persistencia ou seja, para que ele salve o produto no banco de dados. É necessário que ele tenha um gerenciador de entidades, um EntityManager. Este EntityManager é fornecido pelo Spring. Assim podemos usar o EntityManager para persistir os produto no banco de dados. No código teremos algo como:

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
Temos quase tudo pronto neste ponto. Precisamos fazer com que agora, quando o Controller receba o produto, ele use o ProdutoDAO para salvar o produto no banco de dados. Estas modificações serão feitas no ProdutosController.

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
A anotação @Autowired serve para que nós não nos preocupemos em criar manualmente o ProdutoDAO no Controller. O Spring fará isso automaticamente. Mas para isso, o Spring precisa "conhecer" o ProdutoDAO. Em outras palavras dizemos que devemos definir que o ProdutoDAO será gerenciado pelo Spring. Para isso devemos marcar o ProdutoDAO com a anotação @Repository.

@Repository
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto){
        manager.persist(produto);
    }

}
Se tentarmos inicializar o projeto neste momento, teremos dois problemas. O primeiro deles será que, apesar de termos aparentemente configurado todo o necessário para persistir os produtos no banco de dados, Spring não conseguirá gerenciar nossas classes, nem mesmo encontrá-las.

Esta configuração está presente em nossa classe AppWebConfiguration, na qual configuramos para o Spring encontrar nossos controllers. Nós vamos configurar para que encontre nossos daos também. A anotação @ComponentScan deve ficar assim:

ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class})
Note que em momento algum estamos fornecendo para o Spring qual é o banco, o usuário ou a senha do banco de dados. Faremos essas configurações em uma nova classe. Crie uma classe no pacote br.com.casadocodigo.conf chamada JPAConfiguration.

Nesta nova classe, criaremos o método que será gerenciado pelo Spring e criará o EntityManager usado em nosso DAO. Ela também terá as configurações de banco de dados e algumas outras propriedades importantes. Vejamos o código:

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
Nesta classe estamos criando um único médoto, que será usado pelo Spring para gerar o EntityManager. Este precisa de um adapter e estamos passando um que o Hibernate disponibiliza.

Criamos também um DataSource que contém as configurações de banco de dados. Criamos um objeto do tipo Properties para podermos setar algumas configurações, como por exemplo o dialeto usado para a comunicação com o banco de dados. Setamos também onde o EntityManager encontrará nossos Models. Feito isso retornamos nossas configurações para o Spring poder utiliza-las.

Nosso próximo passo é disponibilizar essa configuração para o Spring. Faremos isso na nossa class: ServletSpringMVC. No Método: getServletConfigClasses.

@Override
protected Class<?>[] getServletConfigClasses() {
    return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
}
Mais um passo é necessário para podermos finalizar esta etapa de configuração. Como as nossas entidades serão gerenciadas pelo Framework, precisaremos setar mais um atributos, que essencialmente é utilizado sempre que usamos o banco de dados. O id. Então em nossa classe Produto, definiremos o id.

@Entity
public class Produto {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    [...]
}
Basicamente, só precisaríamos do @Id. Mas para que não precisemos gerenciá-lo manualmente, usamos a segunda anotação (@GeneratedValue(strategy=GenerationType.IDENTITY)) para que o próprio framework o gere e o gerencie. Feito isso podemos acessar a página de cadastro de produtos e tentarmos cadastrar um produto. A resposta que temos logo após tentar cadastrar um produto será essa:

HTTP Status 500 - Request processing failed; nested exception is javax.persistence.TransactionRequiredException: No transactional EntityManager available
Como assim? Aparentemente estava tudo funcionando. Note que o erro é bem claro: No transactional EntityManager available do tipo TransactionRequiredException. Ou seja, nossa operação com o banco de dados deve ser gerenciada com uma transação.

Façamos então essas últimas configurações para conseguirmos cadastrar nosso produtos no banco de dados. Primeiro precisaremos de um TransactionManager que conheça nosso EntityManager para que assim ele possa gerenciar as transações de nossas entidades.Na classe JPAConfiguration adicionaremos mais um método que criará o TransactionManager.

@EnableTransactionManagement
public class JPAConfiguration {

    [...]

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
Note que adicionamos a anotação @EnableTransactionManagement. Assim o Spring ativa o gerenciamento de transações e já reconhece o TransactionManager. Agora precisamos definir que o nosso ProdutoDAO é uma classe Transancional e fazemos isso atravez da anotação @Transactional do pacote org.springframework.transaction.annotation.Transactional.

@Repository
@Transactional
public class ProdutoDAO {
    [...]
}
É isso! Não precisamos configurar mais nada por hora. Desta forma já conseguiremos cadastrar nossos produtos sem nenhum problema. Não se esqueça de verificar as configurações do seu banco de dados e de criar o banco casadocodigo pois o Hibernate não cria o banco, mas as tabelas e campos sim.

Experimente cadastrar alguns livros da Casa do Código e verificar se estão realmente no banco de dados. Caso tenha problemas ou dúvidas, publique no forúm, você sempre encontrará alguém para ajudar!

<h2>Sobre a utilização do @AutoWired</h2>
Dentro do ProdutosControllers, para utilizarmos o produtoDAO do tipo ProdutoDAO simplesmente anotamos o objeto com a annotation @Autowired do Spring. Por que ao invés de instanciarmos manualmente, fizemos essa abordagem?
R: Quando utilizamos o @AutoWired, pedimos para o Spring uma instância do objeto que foi anotado. Esse recurso é chamado de injeção de dependência e está disponível para qualquer Bean do Spring. É preferível esse tipo de abordagem, justamente para manter o conceito da inversão de controle que basicamente joga toda a responsabilidade de instanciar ou inicializar qualquer tipo de configuração necessária de um objeto para o servidor, nesse caso, o Spring.

Dessa forma, diminuímos tanto o trabalho na utilização desses objetos, como também, removemos o risco de esquecermos algum passo ou configuração durante a utilização.


-------------------------------------------------------------------------------------------------------
<h1>Seção 03 - Cadastro de preços do produto</h1>

Até este ponto do curso, já fizemos o cadastro de produtos e tivemos a certeza de que tudo está funcionando corretamente. Nossos produtos já estão sendo cadastrados no banco de dados. Mas se verificarmos alguns livros na Casa do Código, veremos que há mais algumas informações que precisamos incluir sobre os produtos.

Vamos voltar ao formulário(form.jsp):

<form action="casadocodigo/produtos" method="POST">
    <div>
        <label>Título</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Páginas</label>
        <input type="text" name="paginas"/>
    </div>
    <button type="submit">Cadastrar</button>
</form>
Uma das informações que queremos adicionar é o Preço. No caso da Casa do Código, os livros têm três opções de compra. O Ebook, Impresso e o Combo (ebook e impresso juntos). Faremos o mesmo em nosso sistema. Sendo assim, modifique o formulário (form.jsp) de produtos adicionando esses três novos campos:

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
Dessa forma, temos as três opções de preço. Agora precisamos modificar a classe Produto, para que possa guarda-los também.

Imagine colocar os três atributos de preço na classe Produto. Estaríamos duplicando informações. Agora imagine se tivermos que adicionar no futuro, outras variações de preço além dessas três... Teríamos que adicionar mais atributos em nossa classe. Pensando assim, parece uma boa ideia ter uma lista de preços.

O preço representa uma algo importante em nosso negócio. Criaremos então uma classe que representa o preço do produto e neste teremos uma lista com cada um dos preços (Ebook, Impresso e Combo). Sendo assim, modifique a classe Produto adicionando o atributo precos.

@Entity
public class Produto {
    [...]
    private List<Preco> precos;
    [...]
}
Observação: Estamos usando atributos privados, então lembre-se sempre de gerar os getters and setters. Use os atalhos do Eclipse!

Agora criaremos a classe Preco que terá dois atributos. O valor, que é o preço propriamente dito e o tipo. O tipo limita-se as três opções que temos atualmente: Ebook, Impresso e Combo.

Poderíamos usar Strings para identificar os tipos de preço, mas teríamos que fazer várias verificações na Strings. Para evitar isso, vamos criar um atributo TipoPreco e um ENUM que lista nossas três opções de preço. Então teremos a classe Preco:

public class Preco {
    private BigDecimal valor;
    private TipoPreco tipo;
    [...]
}
Depois, iremos criar também o ENUM TipoPreco:

public enum TipoPreco {
    EBOOK, IMPRESSO, COMBO;
}
Observação: A classe Preco e o enum TipoPreco devem ficar no pacote br.com.casadocodigo.loja.models.

Podemos fazer uma relação de produtos com seus preços em duas tabelas diferentes no banco de dados, usando o id do produto para estabelecer essa relação OneToMany, ou seja, um produto para vários preços. Mas neste contexto, isso não faria muito sentido, porque teríamos um id para o preço e não precisamos disso, pois não vamos reutilizar o preço do produto.

Faremos essa relação de uma outra forma, marcaremos o atributo List<Preco> precos da classe Produto com a anotação @ElementCollection indicando que este atributo é uma coleção de elementos:

@Entity
public class Produto {
    [...]
    @ElementCollection
    private List<Preco> precos;
    [...]
}
E para que o Spring possa relacionar e portar os elementos de preço para dentro desta coleção, devemos marcar a classe Preco com uma a anotação Embeddable:

@Embeddable
public class Preco {
    [...]
}
Note que já estamos tomando todos os cuidados para que os preços de nossos sejam flexíveis. A classe Produto tem uma lista de Preco e o enum TipoPreco tem os tipos de preços dos nossos produtos. O nosso form.jsp está fixo com as três opções que deixamos disponíveis. Vamos deixá-la mais flexível também.

Veja o código do form atual:

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>Título</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Páginas</label>
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
Já que teremos uma lista de preços, podemos fazer um forEach nessa lista e exibir todos os preços de forma dinâmica. O arquivo form.jsp ficará assim:

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>Título</label>
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Páginas</label>
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
Perceba que estamos fazendo um forEach com JSTL em uma coleção ou lista que se chama tipos e acessando cada tipo de preço através da variável tipoPreco. Estamos também usando o index da varStatus="status" que serve como uma espécie de contador.

Mas antes de utilizarmos a lista de tipoPreco, temos que fazer uma pequena alteração no ProdutosController. Teremos que mudar o método form para retornar um objeto do tipo ModelAndView.

@RequestMapping("/produtos/form")
    public ModelAndView form(){

        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }
Reparem que no construtor de ModelAndView passamos o endereço da View para que o Spring entenda qual o arquivo que ele deverá retornar ao navegador.

Observação: Para que as tags da JSTL funcionarem, lembre-se de fazer o importe da taglib logo após a diretiva de página JSP no início do arquivo. Observe:

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Import da taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
[...]
Observação: Caso não conheça a JSTL, recomendamos que faça o curso de Java e JSTL: Tags para facilitar o desenvolvimento JSP disponível aqui no Alura.

Nosso laço(forEach), manipula o html do formulário para criar os campos de tipos de preços, e o resultado deste laço é algo como:

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
Perceba que no name dos inputs do formulário, estamos usando: precos[numero].valor e precos[numero].tipo. Quando enviarmos nosso formulário, o Spring ao fazer o bind dos atributos do Produto, irá detectar que estamos passando valores para o atributo precos em determinadas posições da lista. Ele também detectará que os valores são do tipo tipoPreco e irá preencher corretamente a lista.

Note que quando fazemosprecos[numero].tipo, estamos acessando na lista de preços, o atributo tipo de um objeto do tipo Preco. E lembre-se que o tipo é recuperado da enum TipoPreco. O input do tipo hidden serve para que passemos o tipo do preço: Ebook, Impresso e Combo. Estes campos são ocultos ao usuário. Não queremos que ele modifique os valores destes campos e insira informações inválidas sobre os tipos de preços em nosso sistema.

Teste cadastrar um novo produto agora. Tudo deve funcionar corretamente. Observe também que no console do Eclipse deve aparecer algo como:

console do Eclipse mostrando saída do Hibernate

Esta saída é do Hibernate mostrando o SQL gerado. Ela também indica que temos uma nova tabela em nosso banco de dados chamada Produto_precos. Mostra também que nesta tabela temos um campo Produto_id, que referencia a qual produto aquele preço se refere. Se acessamos nosso banco e fizermos um SELECT * from Produto_precos; teremos algo como a seguinte saída:

saída do select no banco de dados

Tipo: 0, 1 e 2? Como assim? Não deveria ser Ebook, Impresso e Combo? Para responder essa pergunta, devemos lembrar que por padrão o enum associa um texto a um número, iniciando de zero. Então, faz sentido sim. Essa associação depende da ordem dos elementos, sendo assim: 0 = Ebook, 1 = Impresso e 2 = Combo.

Assim terminamos de cadastrar nossos produtos e seus respectivos preços. Experimente cadastrar mais alguns itens, porque no próximo capítulo iremos trabalhar com a listagem de produtos.


<h2>Utilização do ModelAndView</h2>
Em diversos métodos mapeados dos nossos controllers, costumamos retornar uma String para devolvermos uma página assim que aquele método for chamado. Entretanto, em alguns métodos, ao invés de utilizarmos o retorno de String, retornamos a classe ModelAndView. Porque utilizamos a classe ModelAndView ao invés da String?
R: Quando utilizamos o ModelAndView, além retornar uma página, temos a possibilidade de enviar objetos de qualquer classe para essas páginas. Em outras palavras, dessa forma somos capazes de exibir, por exemplo, as informações das nossas classes modelos.

--------------------------------------------------------------------------------------------------
<h1>Seção 04 - Listando os Produtos</h1>

Nos últimos capítulos fizemos o cadastro completo dos produtos da nossa aplicação e já integramos esse cadastro com o banco de dados. Fizemos o formulário (form.jsp) ter os campos necessários para o cadastro de um novo produto. Fizemos também os campos dos tipos de preços serem criados dinamicamente através de um loop (forEach).

Criamos na classe Produto um atributo que guarda uma lista de preços. Também criamos a classe Preco que guarda o valor e o tipo do preço, sendo que, para o tipo do preço, usamos um enum chamado TipoPreco para guardar as opções de preços que temos em nossa aplicação, sendo elas: Ebook, Impresso e Combo.

Agora faremos a listagem desses produtos.

Para aproveitarmos um pouco um código que já temos, vamos copiar todo o código que está no form.jsp. Criar um novo arquivo JSP chamado lista.jsp no mesmo diretório onde está o form.jsp e colar o código do form.jsp no lista.jsp.

Como esta será uma página que apenas lista nossos produtos, não precisamos do formulário, sendo assim, apague o código referente ao formulário de cadastro (<form>). O código restante deve algo assim:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
    </head>
    <body>

    </body>
</html>
Nesta página então, criaremos uma tabela onde serão listados os produtos usando os seguintes dados: Título, descrição e quantidade de páginas. Sendo assim, no corpo da página (dentro da tag <body>) crie a estrutura básica da tabela, algo parecido com o código:

[...]
<body>
    <table>
        <tr>
            <td>Título</td>
            <td>Descrição</td>
            <td>Páginas</td>
        </tr>
    </table>
</body>
[...]
As tags table, tr, td representam a tabela (table), as linhas (tr) e as colunas (td). Esta será nossa tabela, esta primeira tr será a cabeçalho. As próximas linhas, já devem ser preenchidas com os dados dos produtos.

No capítulo anterior, conhecemos o forEach. O forEach foi usado para percorrer uma lista e criar os campos do formulário. Faremos algo parecido aqui. Vamos percorrer uma lista de produtos. Usaremos a mesma estrutura do forEach aqui.

Como cada uma das próximas linhas da tabela será um produto. E em cada linha, vamos imprimir os dados do produto(titulo, descricao e paginas). Então podemos facílmente escrever algo como:

[...]
<table>
    <tr>
        <td>Título</td>
        <td>Descrição</td>
        <td>Páginas</td>
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
Vamos também adicionar um título nessa nossa página, pra não ficar só a tabela sem nenhuma descrição. Usaremos a tag h1 antes da tabela com o título: Lista de Produtos. <h1>Lista de Produtos</h1>.

Já temos quase tudo pronto, precisamos somente fazer com que nosso ProdutoDAO acesse o banco de dados e crie essa lista de produtos que queremos exibir. E por último fazer o mapeamento no ProdutosController retornando a lista de produtos para a view lista.jsp.

Crie na classe ProdutoDAO o método listar que usuará o EntityManager para criar uma consulta no banco de dados e retornar uma lista de produtos. O código é parecido com:

public List<Produto> listar(){
    return manager.createQuery("select p from Produto p", Produto.class).getResultList();
}
O getResultList irá criar uma lista com os resultados da consulta ao banco de dados.

Nosso segundo passo é fazer com que nosso ProdutosController use o método listar do ProdutoDAO e retornar essa lista de produtos para a view.

public ModelAndView listar(){
    List<Produto> produtos = produtoDao.listar();
    ModelAndView modelAndView = new ModelAndView("/produtos/lista");
    modelAndView.addObject("produtos", produtos);
    return modelAndView;
}
Nenhuma surpresa até aqui não é? Estamos usando recursos que já aprendemos anteriormente. Acessando o banco de dados, criando um ModelAndView para anexar objetos que serão usados em nossa view e retorando a lista.

O ModelAndView é uma classe do Spring que faz um relacionamento de um modelo (model) com uma visualização (view) . Este além de poder disponibilizar um outro objeto qualquer para a view pode fazer outras operações, como redirecionamento de páginas, entre outras. Veremos mais sobre ModelAndView posteriormente.

Vamos fazer com que a lista de produtos fique na url /produtos e faz sentido, certo? Quando acessamos /produtos queremos ver uma lista de produtos. Agora adicionaremos esse mapeamento de rota. O metodo listar deve ficar assim:

@RequestMapping("/produtos")
public ModelAndView listar(){
    List<Produto> produtos = produtoDao.listar();
    ModelAndView modelAndView = new ModelAndView("/produtos/lista");
    modelAndView.addObject("produtos", produtos);
    return modelAndView;
}
Com tudo isso pronto, podemos iniciar o servidor e tentar acessar a lista de produtos em localhost:8080/casadocodigo/produtos/. Mas algo parece não funcionar bem, temos um erro no console. veja a mensagem de erro:

Ambiguous mapping found. Cannot map 'ProdutosController'.
Isso acontece porque temos duas rotas em nosso controller apontando para a mesma url. Quando o acesso for feito, o Spring não vai saber qual método chamar do controller. Vamos resolver isso!

Podemos diferenciar as rotas simplemente mudando a url que o método mapeia. Mas vamos diferenciar as rotas de uma outra forma. Vamos diferenciar pelos métodos usados pelo protocolo HTTP.

Quando acessamos uma página, digitando uma url ou clicando em links, estamos fazendo um GET. Quando estamos clicando em nosso botão de cadastrar produtos por exemplo, geralmente estamos fazendo um POST. Se você verificar o formulário (form.jsp) verá o atribudo method com o valor POST.

Para resolvermos o problema das todas duplicadas só precisaremos adicionar um novo parametro no @RequestMapping usando o enum RequestMethod do Spring, definindo assim qual método HTTP vai ser usado para chamar aquele método do controller.

Quando fizermos um GET para /produtos o Spring deve chamar o método listar do nosso ProdutosController . Quando fizermos um POST para /produtos ele deve chamar o gravar, enviando um produto para ser gravado no banco de dados.

Modificaremos então as anotações de @RequestMapping do método gravar e listar do nosso ProdutosController, fazendo essa diferenciação. Veja o código como fica:

@RequestMapping(value="/produtos", method=RequestMethod.POST)
    public String gravar(Produto produto){
        [...]
    }


@RequestMapping(value="/produtos", method=RequestMethod.GET)
public ModelAndView listar(){
    [...]
}
Tente iniciar o servidor novamente e acessar a página de produtos, tudo deve funcionar normalmente.

Mudando Enconding do Spring.
Note que nossa lista de produtos aparece com alguns caracteres estranhos. Isso acontece por que o servidor não conhece o encoding da requisição, então ele troca os caracteres especiais e com acentos por outros caracteres.

Carasteres estranhos na listagem dos produtos

Há várias formas de resolver este problema, mas vamos usar uma das mais simples. Criando Filtros! Dessa forma, ao receber a requisição o Spring filtra a requisição com o encoding que vamos configurar. Em nossa classe ServeltSpringMVC dentro do pacote br.com.casadocodigo.loja.conf, vamos criar mais um método de configuração do Spring.

Exite um método chamado getServletFilters usado pelo Spring que espera receber um array de filtros. Então vamos criar um CharacterEncodingFilter, definir o encoding deste filtro usando o valor "UTF-8", adicionar este filtro ao array de filtros e o retornar esse array para o Spring. Use os imports import javax.servlet.Filter e org.springframework.web.filter.CharacterEncodingFilter.

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
    }
}
Agora quando cadastrarmos novos produtos, os caracteres estarão normais.

Carasteres normais na listagem dos produtos

Melhorando rotas no controller
Vamos fazer agora um pequeno ajuste em nosso ProdutosController para deixar o mapeamento das rotas mais simples. Note que em todos os métodos usamos a anotação @RequestMapping passando sempre /produtos.

Para que não precisemos ficar passando /produtos em todos os métodos do controller, vamos pôr essa anotação em nossa classe. Assim podemos remover o /produtos de todos os métodos e o Spring se encarrega de carregar os mapeamentos baseados no mapeamento da classe. Sendo assim nossa classe ProdutosController deve ficar parecida com o código abaixo:

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
Dessa forma, se acessamos /produtos via GET, o método listar será chamado. Se o acesso for via POST o método gravar será chamado. E o /produtos/form continua chamando o método form. Bem mais simples, certo?

Teste novamente as páginas de listagem e de cadastro de produtos. Tudo deve estar funcionando normalmente. Cadastre novos produtos e verifique que os caracteres estranhos também não aparecem mais.


<h2>Utilização de métodos de requisição do HTTP</h2>
Até o momento, estávamos utilizando a anotação @RequestMapping apenas enviando a String que desejamos que ele mapeie. Entretanto, nesse capítulo, fizemos o uso do atributo method enviando como parâmetro os enuns RequestMethod.GET e RequestMethod.POST, e então, obtemos os seguintes resultados:

@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @RequestMapping(method = RequestMethod.POST)
    public String gravar(Produto produto) {
            //Código
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
            //Código
    }

        // métodos
}
Considerando o exemplo, escolha a opção que descreve o que significa o atributo method e o motivo de utilizarmos ele para esse caso:

R:Quando utilizamos o atributo method, significa que estamos enviando o método de requisicação do HTTP. Para esse caso, utilizamos esse atributo justamente para que fosse possível ter o mesmo mapeamento para duas funcionalidades distintas.


------------------------------------------------------------------------------------------------
<h1>Seção 05 - Redirect com Escopo de Flash</h1>

O cadastro de produtos da nossa aplicação já funciona, mas da mesma forma que melhoramos as rotas no capítulo passado, vamos melhorar outro ponto da aplicação neste momento.

É muito comum que após o cadastro de produtos, por exemplo, em vez de ser mostrada uma página com a mensagem de cadastro realizado com sucesso, sejamos levados novamente à lista com todos os produtos. Faremos essa modificação agora.

Para que após o cadastro de produtos, sejamos levados à página de listagem, devemos então modificar o método gravar no ProdutosController, para que este método chame o método listar em vez de retornar a view ok.jsp.

Nosso código atualmente está assim:

@RequestMapping(method=RequestMethod.POST)
public String gravar(Produto produto){
    System.out.println(produto);
    produtoDao.gravar(produto);
    return "produtos/ok";
}
Vamos então, simplesmente mudar a rota do retorno do método para o endereço /produtos. Nosso código ficará assim:

@RequestMapping(method=RequestMethod.POST)
public String gravar(Produto produto){
    System.out.println(produto);
    produtoDao.gravar(produto);
    return "produtos";
}
Com essa mudança, quando cadastrarmos um novo produtos, o método gravar deve salvar o produto no banco de dados e então o Spring deve chamar o método listar que é responsável por atender o endereço /produtos. Vamos fazer um teste e realizar um cadastro em "novo produto".

![Erro 404 - página produtos.jsp não encontrada](https://s3.amazonaws.com/caelum-online-public/SpringMVC+-+criando+webapp/springmvc_i_webaapp_5_1_pagina_produtos_nao_encontrada.png)
O que acontece? Vemos uma mensagem de Erro 404.

A página produtos.jsp não foi encontrada, porque realmente não temos uma página produtos.jsp, temos uma página lista.jsp.

O Spring, quando retornamos uma String procura uma página com o mesmo nome da String que retornamos, por isso ele está procurando uma página chamada produtos.jsp.

Não era o que queríamos... Nós queremos ver a listagem de produtos que já está pronta na nossa página lista.jsp. Sabendo disso, vamos chamar o método listar do ProdutosController diretamente, isto fará com que o Spring carregue a listagem dos produtos e mostre a listagem no navegador.

Logo, iremos mudar o retorno do nosso método gravar para que seja o mesmo do método listar. E depois, chamar o método listar com o return. Veja como ficou o código com as nossas modificações.

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto){
    System.out.println(produto);
    produtoDao.gravar(produto);
    return listar();
}
Observe que o retorno do método muda, pois o método listar retorna um objeto do tipo ModelAndView. Vamos cadastrar um novo produto agora. Após o cadastro, devemos ver a listagem de produtos com o nosso novo produto.

cadastrando novo produto

produto sendo listado depois do cadastro

Experimente apertar F5 após o cadastro de algum produto.

página de listagem fazendo resubmissão de formulário

Veja que o navegador nos questiona se queremos resubmeter o formulário. Isso quer dizer que se confirmarmos, ele vai enviar os dados do produto novamente e teremos o produto recadastrado. Duplicação de produtos não é bom!

Acontece que o navegador ainda está guardando os dados do post do formulário. Apesar de ser um problema real, não podemos culpar o navegador, pois este é o funcionamento normal no caso de posts de formulário. Modificaremos então este comportamento em nossa aplicação.

Resolveremos isto através de recursos do protocolo HTTP. Já usamos outros recursos do protocolo (GET e POST). Agora, usaremos um recurso chamado de redirect, que passa um status para o navegador carregar uma outra página e esquecer dos dados da requisição anterior. O status que o navegador recebe é um 302.

Para isso devemos mudar a última linha do método gravar, que agora vai retornar um novo ModelAndView usando como rota o redirect:produtos.

Após as modificações, o método gravar ficará igual ao que está abaixo:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto){
    System.out.println(produto);
    produtoDao.gravar(produto);
    return new ModelAndView("redirect:produtos");
}
Teste cadastrar um novo produto e atualizar a página de listagem depois do cadastro. O navegador não nos pede mais confirmação de resubmissão do formulário e também não duplicará os produtos na listagem.

Nossa aplicação ainda precisa de mais um ajuste. Ela não mostra mais a mensagem de produto cadastrado com sucesso como tínhamos na view ok.jsp. Como é uma simples mensagem, usaremos um recurso do Spring que nos permite enviar informações entre requisições. Esse recurso é o RedirectAttributtes.

O método gravar agora deve receber um objeto do tipo RedirectAttributes fornecido pelo Spring. Usaremos então esse objeto para adicionar um atributo do tipo Flash (usando o método addFlashAttribute deste objeto), passando assim a uma chave sucesso e o valor dessa chave que é Produto cadastrado com sucesso!.

Veja como fica nosso método gravar com esta nova modificação:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes){
    System.out.println(produto);
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso!");
    return new ModelAndView("redirect:produtos");
}
Observação: Atributos do tipo Flash têm uma particularidade que é interessante observar. Eles só duram até a próxima requisição, ou seja, transportam informações de uma requisição para a outra e então, deixam de existir.

Note que usamos um RedirectAttributes. Isto faz muito sentido, já que após o post iremos redirecionar a página. A prática de fazer redirecionamentos após posts tem um nome bem conhecido, Always redirect after post (em português, significa Sempre redirecione após post).

Agora para exibirmos esta mensagem em nossa listagem, devemos modificar o lista.jsp para exibir o RedirectAttributes, que é acessado através da chave message, veja como fica nosso lista.jsp:

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
    <h1>Lista de Produtos</h1>
    <p> ${sucesso} </p>
    <table>
        <tr>
            <td>Título</td>
            <td>Descrição</td>
            <td>Páginas</td>
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

listagem sem pedir resubmissão de formulario e com menssagem de sucesso

Recapitulando:
Até aqui fizemos nossa listagem de produtos, que usa o DAO para recuperar os produtos do banco de dados. Simplificamos nossas rotas assinando o ProdutosController com a anotação RequestMapping('produtos') e diferenciamos os métodos listar e gravar que mapeiam a mesma rota, através dos métodos usados pelo protocolo HTTP (GET e POST).

Também aprendemos a redirecionar de uma página para outra. Vimos o conceito de Always redirect after post (que significa, "Sempre redirecione depois de post"). Evitando que dados sejam reenviados para nossa aplicação, duplicando registros em nosso banco de dados.

Vimos também como podemos enviar mensagens de uma requisição para outra, havendo redirecionamento de páginas com o Flash, usando o RedirectAttributes e o método addFlashAttribute.


<h2>Escopo de Flash</h2>
O que é o Flash Scoped que usamos através do objeto RedirectAttributes do Spring?
R: O Flash Scoped é um escopo rápido. Os objetos que adicionamos nele através do método addFlashAttribute ficam vivos de um request para outro, enquanto o navegador executa um redirect (usando o código de status 302).


<h2>Always Redirect After Post</h2>
Por que devemos sempre fazer um redirect após o formulário enviar um POST para nossos sistemas?
R:Pois ao fazer F5 o navegador repete o ultimo request que ele realizou, e quando esse resquest é um POST, todos os dados que foram enviados também são repetidos. Se você realizou um insert no banco de dados, esse insert será repetido. Ou mesmo se realizou alguma operações que envia e-mail, por exemplo, o e-mail será enviado duas vezes ao pressionar F5.

Para evitar qualquer problema de dados reenviados, realizamos um redirect após um formulário com POST.

------------------------------------------------------------------------------------------------------
<h1>Seção 06 - Validação e conversão de dados</h1>

Até aqui fizemos bastante coisa na nossa aplicação. Cadastramos livros, exibimos uma mensagem de sucesso e fizemos nossos livros aparecerem em uma listagem simples, mas que demonstra que tudo está funcionando perfeitamente.

Agora chegamos em um ponto em que precisamos validar os dados enviados pelo usuário. Esta validação é muito importante. Como seria se alguém tentasse cadastrar livros sem preencher os dados do formulário? Tente fazer isso pra ver o que acontece.

Erro HTTP 400 ao cadastrar produto

Erro 400 - The request sent by the client was syntactically incorrect.
A requisição foi enviada com uma sintaxe errada. Como assim? Tem algum problema acontecendo na hora de enviar os dados. Isso acontece porque não estamos enviando dados. Para corrigir isso, devemos validá-los e para isso existem algumas formas.

A primeira forma seria validar com JavasSript, mas como esta aconteceria no navegador seria menos confiável, pois o usuário poderia modificar o código no navegador nas ferramentas do desenvolvedor. Nós podemos fazer a validação em nosso código Java, que é mais confiável porque o usuário não tem acesso a esse código.

O Controller de Produto, ou seja ProdutosController, parece ser um bom lugar para validar os dados dos produtos. E o método gravar parece ser o lugar onde precisamos de uma validação. É certo validar os dados antes de salvar o produto no banco de dados?

Validações geralmente envolvem ifs, que avaliam uma condição e garantem se está tudo certo. Nosso método grava atualmente está assim:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes){
    System.out.println(produto);
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Vamos primeiro tirar esse System.out.println(produto), porque ele não é mais necessário. Então vamos fazer um if antes de salvar o produto, verificando se o título é null ou vazio. Devemos validar pelo menos o título, a descrição e o preço, mas vamos começar com o título. Caso um dos casos da validação dê false, retornaremos para o formulário. Veja como fica nosso código com o if:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes){
    if(produto.getTitulo() == null || produto.getTitulo().isEmpty()){
        return form();
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Vamos fazer dois testes agora, um com o título preenchido e outro, sem preenchê-lo. Lembre-se de deixar os outros campos em branco, pois estamos validando somente o título. Veremos o que acontece.

Erro HTTP 400 ao cadastrar produto

Nos dois casos que testamos agora, teremos o mesmo erro de antes e não voltaremos para o formulário. Por quê?

O erro acontecerá antes mesmo de chegar ao nosso código de validação. O Spring não está conseguindo fazer o bind dos dados do formulário para o nosso objeto produto. Vejamos então os atributos da nossa classe Produto.

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
Se olharmos bem, temos o atributo paginas que é do tipo int. Este é um tipo primitivo, ele não pode receber uma valor null. No entanto, os outros como String e List podem, pois são objetos. O id não nos importa nesse momento, porque é gerenciado pelo Spring. Vamos, então, enviar o formulário preenchendo somente o número de páginas.

Formulário vazio após tentar enviar dados incorretos

Agora sim, voltamos para o nosso formulário como fizemos em nossa validação. Perceba que apesar de preencher o número de páginas e o formulário ter enviado os dados sem problemas, não temos nenhuma mensagem de erro.

O problema da validação ser feita desta forma é que se for preciso validar mais campos, aquele if em nosso controller vai ficar muito grande e isso não é bom. Pior ainda se for preciso validar o produto em outra parte da aplicação. Teríamos que ficar copiando e colando código. Sabemos que isso também não é bom. A melhor ideia é isolar o código em outro lugar e sempre que precisarmos, usá-lo.

Vamos criar então uma classe para esse código, que chamaremos de ProdutoValidation e ela ficará no pacote br.com.casadocodigo.loja.validation. Esta classe terá um método boolean chamado valida que fará a mesma coisa que nosso if do controller e retorna true caso o produto tenha os dados corretos e false caso não tenha. Nossa classe ProdutosValidation ficará assim:

public class ProdutoValidation {
    public boolean valida(Produto produto) {
        if (produto.getTitulo() == null || produto.getTitulo().isEmpty()) {
            return false;
        }
        return true;
    }
}
Este código terá o mesmo efeito do outro que estava no nosso ProdutosController e continuará com um problema que quase não notamos. Por hora, estamos validando somente o título, mas se fizermos a validação da descrição e depois tentarmos cadastrar um produto sem nenhuma dessas informações, como vamos saber qual delas deu erro? O código não nos informa isso. Apesar de funcionar, o código não nos ajuda muito. Então, vamos usar algo do Spring. O Framework deve poder nos ajudar. Neste caso, o Spring tem uma classe chamada ValidationUtils, com alguns métodos que validam dados.

Dentre os métodos disponíveis em ValidationUtils, teremos um que se encaixa exatamente com nosso caso, que é o rejectIfEmpty, que traduzido para português significa "rejeite se for vazio". É exatamente o que queremos. Este método recebe três parâmetros: Um objeto errors que contém os erros da validação; O nome do campo que iremos validar passado como String; e um errorCode que também é passado como String, mas que é reconhecido pelo Spring. Neste último parâmetro, usaremos o errorCode com o valor "field.required" para informar ao Spring que aquele campo é obrigatório.

Note que o objeto errors não é gerenciado por nós, mas sim pelo Spring. Nosso método agora não precisa mais retornar nenhum valor, já que o objeto errors terá as informações se a validação falhou ou não. Vejamos como fica o método valida após essas modificações.

public void valida(Produto produto, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
}
Bem mais simples não acha? Vamos aproveitar o momento e já validar da mesma forma o nosso campo descricao. Veja como fica:

public void valida(Produto produto, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
    ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
}
Para validar o campo paginas nós precisamos de uma outra estratégia, pois nosso campo precisa de um número maior que zero não é verdade? Neste caso, teremos que fazer um if verificando isso. Caso o número de páginas seja menor ou igual a zero, usaremos o objeto errors para rejeitar o valor, passando também o errorCodede campo obrigatório. Nosso método valida ficará dessa forma:

public void valida(Produto produto, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
    ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
    if(produto.getPaginas() <= 0){
        errors.rejectValue("paginas", "field.required");
    }
}
Está quase tudo pronto para nossa validação ser finalizada. Iremos agora usar a validação em nosso controller e mostrar os devidos erros em nossa view. Para não nos preocuparmos em ficar fazendo ifs em nosso código, podemos dizer para o Spring usar a nossa classe de validação para validar o produto. Para isso precisamos de algumas configurações.

Vamos usar a especificação do Java chamada Bean Validation. A implementação desta especificação que vamos usar será a Hibernate Validator . Usaremos algumas bibliotecas para facilitar nosso trabalho. No pom.xml adicionaremos essas dependências:

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
Nosso próximo passo é configurar nosso projeto para usar essas bibliotecas e fazer com que o Spring passe a usar nossa classe ProdutoValidation para validar nosso produto. No ProdutosController vamos usar uma nova anotação. No método gravar, antes da assinatura do Objeto produto adicione a anotação @valid do pacote: javax.validation. A assinatura do método deve ficar dessa forma:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(@Valid Produto produto, RedirectAttributes redirectAttributes){
    [...]
}
Isso ainda não é o suficiente para nossa validação funcionar. Agora precisamos criar um método em nosso controller chamado InitBinder que terá uma anotação com o mesmo nome do método @InitBinder. Este método recebera um objeto do tipo WebDataBinder que chamaremos apenas de binder. O objeto binder tem um médoto chamado addValidators que recebe uma instância de uma classe que implemente a interface Validator do pacote org.springframwork.validation.

Observação: O Binder, por assim dizer, é o responsável por conectar duas coisas. Por exemplo, os dados do formulário com o objeto da classe Produto, como já fizemos anteriormente.

Dito isso, vamos implementar esse método InitBinder em nosso ProdutosController, então. Nosso código deve ficar parecido com esse:

@InitBinder
public void InitBinder(WebDataBinder binder){
    binder.addValidators(new ProdutoValidation());
}
Com este passo pronto, notamos que o Eclipse irá reclamar que o método addValidators não é um objeto Validator. Isso é justo, já que nossa classe ProdutoValidation não implementa essa interface. Vamos então modificar nossa classe ProdutoValidation para que ela implemente a interface correta. A interface Validator correta é a que está no pacote org.springframework.validation.Fazendo com que a nossa classe ProdutoValidation implemente esta interface, adicionaremos os métodos da interface, nossa classe fica dessa forma:

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
Perceba que o método Validate é onde realmente acontecerá a validação. Este método se parece bastante com o método valida, criado anteriormente. Então, vamos usar o médoto da interface. Primeiro renomearemos os parâmetros, arg0 se chamará target, este será o objeto alvo da validação. O arg1 será o errors igual ao método valida. Depois deste passo, vamos copiar o código dentro do método valida e colá-lo no método validate. Podemos apagar o método valida depois disso. Até aqui nosso código deve estar parecido com esse:

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
O Eclipse vai reclamar, pois no if estamos usando um objeto produto e não temos mais esse objeto em mãos. O que podemos fazer então? Não podemos simplesmente mudar o nome target porque estamos recebendo um objeto do tipo Object agora. A forma mais simples é fazer um cast antes do if. Nosso código ficará assim então:

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
O método supports também precisa ser implementado. A implementação desse método indica a qual classe a validação dará suporte. Sabemos que será a classe Produto. Vamos então fazer essa implementação da seguinte forma:

public class ProdutoValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Produto.class.isAssignableFrom(clazz);
    }
}
O que esse código faz é verificar se o objeto recebido para a validação tem uma assinatura da classe Produto. Com isso o Spring pode verificar se o objeto é uma instância daquela classe ou não.

Um último passo é necessário agora, para nossa validação estar completa. Falta recebermos o resultado da verificação, da validação em sí em nosso controller e verificar se houve algum erro. Faremos isto recebendo na assinatura do nosso método gravar um objeto do tipo BindingResult que tem um método chamado hasErrors, que informa se houve erros de validação ou não. Com isso poderemos fazer um simples if, para ver se tudo funciona bem. Caso a validação não tenha encontrado erros, salvaremos o produto. Porém, se houver erros, voltaremos para o formulário. Nosso código no método gravar ficará dessa forma:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(@Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){
    if(result.hasErrors()){
        return form();
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Note que o BindingResult vem logo após o atributo que está assinado com a anotação @Valid, essa ordem não é por acaso, precisa ser desta forma para que o Spring consiga fazer as validações da forma correta. Teste o formulário mais uma vez!

Agora podemos enviar o formulário sem preencher nenhum dos campos e nada acontecerá. Ainda falta mostrar as informações de erro - as mensagem. Mas logo faremos isto. Até o momento, basta acreditar que a validação está acontecendo.

<h2>Validator do Spring MVC</h2>
Por quê utilizamos o Validator do Spring ao invés de fazer as validações manualmente?
R: Quando utilizamos o Validator do Spring, temos a possibilidade de configurar o controller para que utilize automaticamente o validador todas as vezes que for necessário validar a classe desejada

Quando utilizamos o Validator do Spring, temos a possibilidade de configurar o controller para que utilize automaticamente o validador todas as vezes que for necessário validar a classe desejada, ou seja, a classe que precisa ser validada (anotada com @Valid). Vale lembrar que o uso do InitBinder é necessário para que seja possível essa validação automática.

------------------------------------------------------------------------------------------------------
<h1>Seção 07 - Mais Validações</h1>

Terminamos a aula anterior com as validações já funcionando, mesmo que não exibindo as mensagens. Faremos isto agora de uma forma muito simples. Primeiro vamos abrir nosso arquivo form.jsp e adicionar uma nova taglib. Veja como está nosso form.jsp :

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
    <form action="/casadocodigo/produtos" method="post">
        <div>
            <label>Título</label> 
            <input type="text" name="titulo" />
        </div>
        <div>
            <label>Descrição</descricao>
            <textarea rows="10" cols="20" name="descricao"></textarea>
        </div>
        <div>
            <label>Páginas</label> 
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
A taglib que adicionaremos será uma do próprio Spring. A uri da taglib será: http://www.springframework.org/tags/form e o prefix será form. Dessa forma teremos nosso form.jsp da seguinte forma:

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais - Casa do Código</title>
</head>
<body>
    <form action="/casadocodigo/produtos" method="post">
        [...]
    </form>
</body>
</html>
Com a taglib adicionada em nossa página JSP, podemos então usar uma tag dessa biblioteca para exibir as mensagens de erro. A tag usada para isso é a tag form:errors e ela tem um atributo chamado path que indica de qual atributo queremos obter a mensagem de erro. Sendo assim, podemos escrever algo do tipo: <form:errors path="produto.titulo" />. Simples! Não? Vamos fazer o mesmo para os outros campos, colocando a tag acima do campo a que o erro se refere. Vejamos como o código do formulário ficará:

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>Título</label> 
        <form:errors path="produto.titulo" />
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <form:errors path="produto.descricao" />
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Páginas</label>
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
Agora nossas mensagens devem aparecer no formulário caso cadastremos um produto que não seja válido, ou seja, sem título, descrição ou sem páginas. Vamos testá-lo então. Submeta o formulário sem preencher os campos corretamente!

Erro 500. mensagens não encontradas

Deu erro? Como assim? Veja a mensagem de erro: No message found under code field.required.produto.titulo. O Spring não está encontrando nossas mensagens de erro. Em lugar nenhum definimos isso. Se você já conhece, existem os arquivos properties que são comuns de serem usados nesses casos. Vamos criar então um properties para deixarmos as mensagens para o formulário neste arquivo.

Na pasta WEB-INF vamos criar um arquivo de texto chamado messages.properties e associar as chaves dos erros aos valores, ou seja, associar as chaves dos erros às mensagens. Dentro desse arquivo, podemos ter algo do tipo field.required.produto.titulo = O Campo título é obrigatório.

Por hora, para testarmos, vamos deixar só a mensagem referente ao título. Depois adicionaremos o restante dos campos. Agora, precisamos configurar o Spring para que ele encontre esse nosso arquivos de mensagens. Já temos uma classe de configuração: a AppWebConfiguration.

Na classe AppWebConfiguration criaremos um novo método que carregará nossos arquivos de mensagens. Este método se chama messageSource e retorna um objeto do tipo MessageSource. Dentro deste método criaremos um objeto do tipo ReloadableResourceBundleMessageSource que chamaremos de messageSource. Neste objeto, iremos definir três propriedades: setBaseName com o valor /WEB-INF/message que terá o nome base dos nossos resources. O setDefaultEncoding com o valor UTF-8 para evitar o problema de caracteres estranhos que já vimos outras vezes e o setCacheSeconds para que o Spring recarregue o arquivo de tempos em tempos com o valor 1.

Esta última propriedade é muito útil em desenvolvimento pois poderemos ficar sempre modificando as mensagens sem se preocupar em ficar refazendo reload do arquivo manualmente. Nosso método fica da seguinte forma: Observação: Lembre-se de anotar esse método com a anotação @Bean para que o Spring possa reconhecer essa configuração.

@Bean
public MessageSource messageSource(){
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("/WEB-INF/messages");
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setCacheSeconds(1);
    return messageSource;
}
Agora com a configuração correta, vamos tentar mais uma vez? Vamos enviar o formulário mais uma vez sem preencher nenhum dos campos. Deve aparecer alguma mensagem agora, correto?Erro 500 - field.required não encontrado

O erro 500 continua mesmo tendo configurado tudo. Embora o número do erro seja o mesmo, o erro agora é outro. O Spring não está encontrando a mensagem referida com a chave field.required. Vamos adicionar então a chave em nosso messages.properties e aproveitar o momento para pôr as outras mensagens - uma para a descrição, que não pode ser vazia, e a outra para a quantidade de páginas, que deve ser superior a zero. Nosso arquivo messages.properties deve ficar dessa forma:

field.required = Campo é obrigatório
field.required.produto.titulo = O Campo título é obrigatório
field.required.produto.paginas = Informe o número de páginas
field.required.produto.descricao = O Campo descrição é obrigatório
Agora temos todas as mensagens prontas. A field.required será a mensagem mais genérica do nosso sistema, as outras serão mais específicas. Vamos tentar de novo então com estas novas modificações.Observação: Qualquer modificação nos textos do arquivo messages.properties pode ser feita sem precisar reiniciar o servidor. Nossa configuração de reload do arquivo já recarrega o arquivo automáticamente.

caracteres estranhos e mensagem de erro de conversão de dados

Nossas mensagens aparecem! Mas que estranho, mesmo configurando os caracteres para ter a codificação UTF-8 eles aparecem estranhos na página e note uma mensagem de erro aparece no campo de páginas. Vamos resolver primeiro o problema dos caracteres.

O problema dos caracteres acontece por que o Eclipse por si só, codifica os arquivos em uma codificação especifica que por padrão não é a UTF-8. Devemos mudar isso então para o nosso arquivo messages.properties. Siga o seguinte caminho: clique direito sobre o arquivo: messages.properties > Propriedades. Na seção Text file encoding selecione UTF-8. Clique em aplicar. Confirma a mensagem que aparece e depois clica em Ok.

clique direito sobre o messages.properties

selecionando utf-8 como codificação

Os caracteres estranhos, agora, aparecem em nosso arquivo. Devemos trocá-los pelo texto que havia antes e salvar o arquivo novamente.messages.properties com caracteres estranhos

Nosso segundo passo será resolver a mensagem de erro. Ela apareceu devido ao fato do Spring ter recebido um valor que não conseguiu converter para inserir no atributo páginas do objeto produto. Vamos adicionar uma mensagem dizendo que o tipo do dado fornecido no campo é inválido. A chave usada para este tipo de mensagem é a typeMismatch. Nosso arquivo messages.properties final ficará dessa forma:

field.required = Campo é obrigatório
field.required.produto.titulo = O Campo título é obrigatório
field.required.produto.paginas = Informe o número de páginas
field.required.produto.descricao = O Campo descrição é obrigatório
typeMismatch = O tipo de dado foi inválido
Precisamos reiniciar o servidor para que essa alteração se valide porque mudamos uma propriedade do arquivo e não seu conteúdo. Vamos reiniciar o servidor e tentar novamente então.erros aparecendo corretamente.

Nossas mensagens agora aparecem sem nenhum problema, mas elas se misturam um pouco com o nome dos campos, para melhorar um pouco essa visualização, vamos por a tag form:errors de cada campo, logo após o campo a que a tag de refere. Nosso form.jsp dentro de views/produtos esta assim atualmente:

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>Título</label> 
        <form:errors path="produto.titulo" />
        <input type="text" name="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <form:errors path="produto.descricao" />
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Páginas</label>
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
Com a modificação que foi proposta antes, o mesmo formulário deve ficar desta forma.

<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>Título</label> 
        <input type="text" name="titulo" />
        <form:errors path="produto.titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="produto.descricao" />
    </div>
    <div>
        <label>Páginas</label>
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
Desta forma, as mensagens aparecerão um pouco separadas do nome do campo e fica mais fácil de identificar de qual campo é a mensagem que aparece. Faça o teste, o resultado deve ser o mesmo que este:

posicao das mensagens mudou

Tudo funciona perfeitamente, mas podemos melhorar um pouco nosso código do formulário. Note que em todos os campos, onde queremos que apareça a mensagem de erro, temos que usar a tag form:errors usando o valor produto.ALGUMACOISA no atributo path. Nosso formulário só trata de um produto especifico, não precisamos ficar repetindo a informação em todos os campos. Se pudermos fazer: <form:errors path="titulo" /> seria mais simples.

Podemos fazer isso usando um atributo da tag form:form da biblioteca do Spring. Ela tem um atributo chamado commandName, no qual podemos fazer uma referencia a qual entidade aquele formulário se refere. nesse caso, seria algo como: commandName="produto". Dessa forma, nas tags de erros (form:errors) não precisaríamos colocar o prefixo produto.. Colocaríamos então só o nome do atributo.

Vamos então melhorar isso. Mudaremos a tag form do nosso form.jsp para a form:form do Spring, que tem os mesmos atributos da tag do HTML e ainda mais esse extra. O próximo passo é eliminar o prefixo produto usado nas tags form:errors para usar somente o nome do atributo, como por exemplo: título e descrição. Lembre-se que o fechamento da tag form também deve ser modificado para form:form. Nosso código então ficará assim:

<form:form action="/casadocodigo/produtos" method="post" commandName="produto">
    <div>
        <label>Título</label> 
        <input type="text" name="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="descricao" />
    </div>
    <div>
        <label>Páginas</label>
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
Se testar o formulário novamente, verá que não houve nenhuma mudança de comportamento, mas nosso código com certeza ficou mais claro e mais simples. Mas podemos melhorá-lo mais um ponto em nosso formulário. A action do nosso formulário é estática, caso precisemos mudar futuramente, teremos que lembrar em todos os lugares que usamos essa action. Conforme o número de controllers também cresce e ficará ainda mais complicado.

Vamos fazer com que o Spring gere automaticamente a action do nosso formulário. Caso a rota no controller mude, a action também muda automaticamente. Para isto precisaremos de uma outra taglib do Spring. Iremos adicionar a seguinte taglib na página form.jsp, logo após as outras taglibs.

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
Com essa nova biblioteca, podemos fazer uso da tag mvcUrl que gera uma URL de acordo com um determinado controller. Não precisamos passar o nome do controller por completo. Se passarmos as iniciais PC para se referir a ProdutosController, o Spring já conseguirá fazer a relação entre os dois.

Precisamos passar uma segunda informação para a tag: o método para qual os dados serão enviados. Neste caso, o método será o gravar.

Faremos isto da seguinte forma: mvcUrl('PC#gravar'). Com isso o Spring já consegue montar a rota corretamente, mas para que ele efetivamente faça isto, devemos usar o método build(). Sendo assim, teremos na action do nosso formulário o seguinte código:

action= "${s:mvcUrl('PC#gravar').build()}"
Lembre-se que o s: é usado por causa do prefix presente na declaração da taglib. Devemos ainda pôr uma barra na rota de produtos definida em nosso ProdutosController, para que a URL possa ser contruída de forma correta, separando os contextos. Assim, o @RequestMapping do nosso ProdutosController muda de @RequestMapping("produtos") para @RequestMapping("/produtos").

Agora o nosso formulário esta pronto!

Teste cadastrar um produto de forma inválida e depois, de forma válida. Sempre precisamos verificar se alguma das modificações feitas não resultou em que outra parte da aplicação parasse de funcionar. Faça alguns testes, verifique se está tudo certo.

Recapitulando
Vimos bastante coisa até aqui, não é mesmo? Construímos nossa lógica de validação usando a classe ProdutoValidation que implementa a interface validator. Vimos como relacionar a validação em nosso controller com a classe de validação através do InitBinder e usando o WebDataBinder.

Fizemos também o nosso formulário ficar mais dinâmico, simples e claro, com o uso das tags do Spring. Vimos como podemos fazer o uso da anotação @Valid e também observamos que o BindingResult precisa ser usado logo após a declaração do @Valid.

Agora, vamos fazer alguns exercícios.

-----------------------------------------------------------------------------------------------------
<h1>Seção 08 - Formatação de Datas</h1>

Nos últimos capítulos, fizemos uma série de validações em nossos livros para garantir que os livros sejam cadastrados com pelo menos três informações que deixamos como obrigatórias, que são: O título, a quantidade de páginas e a descrição. Essas são as informações minimas para cadastrar um livro em nosso sistema.

Na Casa do Código quando ocorre o lançamento de um livro, a data do lançamento deste livro fica registrada no sistema. Vamos fazer com que essa data seja cadastrada em nosso sistema também. Vamos começar essas alterações pelo form.jsp

Nosso formulário agora precisa de um campo onde possamos digitar a data de lançamento do livro. Teremos então um novo input do tipo text com o atributo name com o valor dataLancamento. Já vamos deixar a validação dos erros com a tag form:errors pronta, com o path de valor dataLancamento. Seguindo o padrão dos outros campos do form.jsp teremos com nosso novo campo o seguinte código: Observação: Lembre-se de pôr o label deste campo.

<div>
    <label>Data de Lançamento</label>
    <input type="text" name="dataLancamento" />
    <form:errors path="dataLancamento" />
</div>
Vamos pôr esse campo logo após o campo de número de páginas. Nosso formulário no form.jsp fica assim:

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto">
    <div>
        <label>Título</label> 
        <input type="text" name="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="descricao" />
    </div>
    <div>
        <label>Páginas</label>
        <input type="text" name="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <div>
        <label>Data de Lançamento</label>
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
Precisamos agora, de um atributo que guarde datas em nosso model de produto. Existem duas principais classes para trabalhar com datas no Java. São elas a Date e a Calendar. Iremos usar a Calendar que é mais recente e mais simples de usar. Sendo assim, vamos criar um novo atributo na nossa classe Produto do tipo Calendar, sendo private.

Observação: Geralmente os atributos das classes são private, nestes casos lembre-se sempre de gerar os *Getters and Setters necessários. Use os atalhos do Eclipse, é mais rápido.

Com este novo atributo e seus Getters and Setters nossa classe Produto fica com o seguinte código:

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
Pronto! Já podemos testar se o nosso sistema salva corretamente as datas. Abra o formulário em localhost:8080/casadocodigo/produto/form e tente cadastrar um novo livro com uma data qualquer. Teremos um erro, mas dessa vez um erro amigavel. Lembra que fizemos algumas validações? Veja o que acontece ao tentar cadastrar o livro com uma data, como por exemplo a data 10/05/2015.

erro na data de lancamento do livro

O erro que recebemos faz todo o sentido. Note que apesar de estamos usando um data, no formulário só há textos. Ou seja, o Spring não está conseguindo converter nossa data que está em texto no formulário para um formato aceito pelo Calendar. O formato padrão é o internacional.

Podemos resolver esse problema, com uma anotação em nosso atributo dataLancamento chamada @DateTimeFormat passando o parametro pattern com o valor dd/MM/yyyy. Esse valor será usado para que o Spring consiga converter a data corretamente. O código do atributo em nossa classe Produto com a anotação fica da seguinte forma:

@Entity
public class Produto {
    [...]
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Calendar dataLancamento;
    [...]
}
Tente cadastrar um produto agora, com a data no padrão brasileiro, sendo este: dia/mes/ano. Apesar de funcionar, essa é uma forma trabalhosa de se fazer isso. Imagine que em todo lugar que precisemos usar data precisaremos lembrar dessa formatação. É fácil de esquecer certo? Sem contar que esse será o padrão da aplicação. Sendo um padrão, a melhor opção é configurarmos isso.

Em nossa classe AppWebConfiguration, que é nossa classe de configuração, faremos essa nova configuração para que não precisemos ficar repetindo essa configuração de data em todos os atributos das outras classes do sistema.

Criaremos então um novo método chamado mvcConversionService que retorna um objeto do tipo FormattingConversionService. Dentro deste novo método precisamos fazer duas coisas. A primeira delas é criar um objeto do tipo DefaultFormattingConversionService que será o responsável pelo serviço de conversão de formato. A segunda é criar um objeto do tipo DateFormatterRegistrar que fará o registro do formato de data usado para a conversão. Este segundo objeto espera receber outro objeto do tipo DateFormatter que será quem efetivamente guarda o padrão da data, que neste caso será dd/MM/yyyy, dia/mês/ano.

O último passo será usar o registrador para registar o padrão de data no serviço de conversão. Lembre-se de usar a anotação @Bean para que o Spring consiga usar essa configuração. Encerramos o código desse método retornando o objeto DefaultFormattingConversionService. Nosso código final fica dessa forma:

@Bean
public FormattingConversionService mvcConversionService(){
    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
    DateFormatterRegistrar formatterRegistrar = new DateFormatterRegistrar();
    formatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
    formatterRegistrar.registerFormatters(conversionService);

    return conversionService;
}
Nosso atributo agora, não precisa mais passar o formato da data. Ela agora só precisa da anotação simples, sem nenhum parametro. Dessa forma:

@Entity
public class Produto {
    [...]
    @DateTimeFormat
    private Calendar dataLancamento;
    [...]
}
Teste novamente, tudo deve funcionar normalmente.Nosso próximo passo é resolver um outro problema que é bem chatinho de se ver acontecendo. A esta altura do curso você já deve ter notado que quando enviamos os dados, com os campos preenchidos, quando validado o formulário nos exibe os erros, mas o forme aparece em branco. É trabalhoso preencher todos os campos novamente por causa de um campo que estava errado.

O ideal é que mesmo que um dos campos esteja com erro, os outros que não tiveram erro continuem com os dados que foram digitados antes de serem enviados. Para isso, devemos deixar com que o Spring gerencie todo o formulário. Fazemos isso usando as tags de formulário do Spring.

Da mesma forma que usamos form:form e form:errors, usaremos agora o form:input que cria um input do tipo text, mas em vez de usar o atributo name, usaremos o atributo path e não precisaremos usar o atributo type. Veja o antes e depois do campo de titulo por exemplo.Antes: <input type="text" name="titulo" />Depois: <form:input path="titulo" />

A nova tag parece ser bem mais simples certo? Para a descrição, que é um textarea, usaremos a tag form:textarea e para o tipo hidden usaremos a tag form:hidden. A mudança só requer quee troquemos o atributo name para path e remover o atributo type. Nosso formulário está assim atualmente:

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto">
    <div>
        <label>Título</label> 
        <input type="text" name="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="descricao" />
    </div>
    <div>
        <label>Páginas</label>
        <input type="text" name="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <div>
        <label>Data de Lançamento</label>
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
Com as mudanças, nosso formulário fica dessa forma:

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto">
    <div>
        <label>Título</label> 
        <form:input path="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>descricao</label>
        <form:textarea rows="10" cols="20" path="descricao" />
        <form:errors path="descricao" />
    </div>
    <div>
        <label>Páginas</label>
        <form:input path="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <div>
        <label>Data de Lançamento</label>
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
Nosso formulário dessa forma ficou bem mais simples. Até o código ficou menor. Vamos agora atualizar nossa página de formulário no navegador para ver se tudo continua funcionando normalmente.

erro 500 - objeto não disponivel no formulario

Erro 500: Neither BindingResult nor plain target object for bean name 'produto' available as request attribute. Nosso formulário agora está com erro, ele não chega nem a ser exibido. A mensagem de erro diz que o objeto produto não está disponível como atributo da requisição. O Spring tenta usar um objeto da classe Produto para poder exibir o formulário. Isso acontece porque já que configuramos o formulário para guardar os dados mesmo quando acontecer erros de validação, dessa forma, ele precisa de um objeto para poder armazenar esses dados e para poder exibir o formulário, mesmo que vazio.

Para que o objeto do tipo Produto fique disponível em nosso formulário, só precisamos fazer uma pequena alteração em nosso ProdutosController. Em nosso método form() só precisamos colocar que queremos receber como parametro um objeto do tipo Produto. Dessa forma o Spring já deixará este objeto disponível na requisição. Nosso médoto form() que estava assim: public ModelAndView form(){ ... } agora fica assim: public ModelAndView form(Produto produto){ ... }.

Lembre-se também de passar o objeto produto onde chamamos o médoto form. Lembra do método gravar? Ele caso não receba um produto válido, chama o método form. Devemos então passar para o método form o mesmo objeto recebido no método gravar. Nosso código atual do método gravar está assim:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(@Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){
    if(result.hasErrors()){
        return form();
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
E com a mudança fica assim:

@RequestMapping(method=RequestMethod.POST)
public ModelAndView gravar(@Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){
    if(result.hasErrors()){
        return form(produto);
    }
    produtoDao.gravar(produto);
    redirectAttributes.addFlashAttribute("message","Produto cadastrado com sucesso");
    return new ModelAndView("redirect:produtos");
}
Atualize o formulário no navegador e teste novamente. Tente cadastrar livros com dados incorretos, tente com dados corretos também para verificar que tudo continua funcionando e agora nossas mensagens de erro aparecem sem que o formulário apareça todo em branco novamente.formulario com os erros e os dados

Recapitulando
Neste capítulo fizemos com que nosso formulário de cadastro de produtos permaneça dos com dados mesmo que algum campo tenha sido enviado com informações inválidas. Deixamos o formulário com um código mais simples e fácil de entender.

Fizemos também uma série de configurações para conversão de datas, uma tarefa muito comum em aplicação de qualquer gênero. Agora é hora de praticar um pouco mais com os exercícios.


-------------------------------------------------------------------------------------------
<h1>Seção 09 - Enviando arquivos ao servidor</h1>

Nossa aplicação já tem uma série de funcionalidades. Ela lista, cadastra e valida os produtos e ainda nos mostra qualquer problema que ocorre durante o processo de cadastramento dos livros.

Neste capítulo, faremos com que a aplicação permita o cadastro do sumário dos livros. Os sumários na maioria das vezes são feitos em PDF. Sendo assim, vamos fazer com que o nosso sistema hospede os arquivos no servidor.

Começaremos a fazer esta mudança a partir do formúlário de cadastro de produtos. O form.jsp agora terá um novo campo com o label sumario e o input - que desta vez será do tipo file. Este tipo é usado exatamente para os casos nos quais queremos enviar um arquivo para o servidor. Usando este tipo de campo, o navegador já saberá que é preciso abrir um janela de seleção para selecionarmos o arquivo. O name deste campo file também será "súmario". Com isto teremos o seguinte código:

<div>
    <label>Sumário</label>
    <input name="sumario" type="file" />
</div>
O form.jsp com esta adição ficará assim:

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto">
    <div>
        <label>Título</label> 
        <form:input path="titulo" />
        <form:errors path="titulo" />
    </div>
    <div>
        <label>Descrição</label>
        <form:textarea rows="10" cols="20" path="descricao" />
        <form:errors path="descricao" />
    </div>
    <div>
        <label>Páginas</label>
        <form:input path="paginas" />
        <form:errors path="paginas" /> 
    </div>
    <div>
        <label>Data de Lançamento</label>
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
        <label>Sumário</label>
        <input name="sumario" type="file" />
    </div>
    <button type="submit">Cadastrar</button>
</form:form>
Isto é tudo que precisamos fazer no form.jsp. Agora precisamos atualizar a classe Produto. Vamos adicionar também um novo atributo chamado sumarioPath e os seus *Getters and Setters. Este será do tipo String.

A classe Produto ficará assim:

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
Existem várias estratégias para guardar arquivos nas aplicações. Uma delas seria guardar o arquivo no banco de dados, mas esta seria muito trabalhosa e precisaríamos converter o arquivo para um formato aceito pelo banco, geralmente bytes. Outra opção seria guardar nas pastas do sistema de arquivos do servidor. Optaremos por esta segunda opção, por isso, o atributo sumarioPath é do tipo String. Nele será guardado apenas o caminho (path) do arquivo.

Nossa classe Produto já está pronta para armazenar o caminho do arquivo. Podemos então modificar o ProdutosController para receber este arquivo e realizar as operações necessárias. O Spring enviará nosso arquivo para o ProdutosController como um objeto do tipo MultipartFile, que chamaremos de sumario. Vamos imprimir o nome do arquivo no console do Eclipse usando o método getOriginalFilename(). Este será o teste básico para sabermos se o arquivo está sendo enviado corretamente.

Observação: Lembre-se que o formulário envia os dados para o método gravar. Estas modificação são realizadas justamente neste método.

Então, receberemos em nosso controller este novo objeto da seguinte forma:

public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result,  RedirectAttributes redirectAttributes){ ... }
Imprimindo o nome do arquivo, teremos o seguinte código no nosso método gravar.

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
Teste agora, cadastrar um produto preenchendo todos os campos, inclusive escolhendo um arquivo qualquer para o sumário. Teremos um erro! multipart request error

A mensagem do erro diz que a requisição atual não é multipart. Requisições deste tipo podem fazer envios de arquivos, sendo estes de qualquer tipo. Corrigir o erro é simples, basta usar o atributo enctype com o valor multipart/form-data na tag form do nosso form.jsp.

<form:form action="${ s:mvcUrl('PC#gravar').build() }" method="post" commandName="produto" enctype="multipart/form-data">
    [...]
</form:form>
Atualize a página de cadastro de produtos. Novamente, tente cadastrar um produto preenchendo todos os campos. Teremos um novo erro.

erro multipart form data resolver

A mensagem de erro nos diz que era esperado um MultipartHttpServletRequest e nos pergunta is a MultipartResolver configured?. Esta mensagem parece bem ser clara. Ela nos pergunta se temos um MultipartResolver configurado. Não configuramos nada disso em nossa aplicação. Vamos fazer essa configuração, então.

Nossas configurações ficam na classe AppWebConfiguration. Vamos até esta classe e adicionaremos a nova configuração. Vamos criar um método chamado multipartResolver que retorna um objeto do tipo MultipartResolver. Este objeto será instanciado da classe StandardServletMultipartResolver e retornado. Sendo assim, teremos o seguinte código em nossa classe AppWebConfiguration:

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class})
public class AppWebConfiguration {

    [...]
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

}
Agora que temos um multipartResolver configurado em nossa aplicação, podemos tentar cadastrar um produto novamente. Lembre-se de reiniciar o servidor para as alterações funcionarem.

Observação: MultipartResolver se refere a um resolvedor de dados multimidia. Quando temos texto e arquivos por exemplo. Os arquivos podem ser: imagem, PDF e outros. Este objeto é que identifica cada um dos recursos enviados e nos fornece uma forma mais simples de manipulalos.

Quando tentarmos cadastrar um produto agora, iremos receber um novo erro. null pointer exception

Este erro acontece porque o nosso método gravar, em ProdutosController, tenta imprimir o nome do arquivo enviado. Aparentemente não resolvemos nosso problema de multipartResolver por completo. Mesmo tendo feito a configuração do multipartResolver, o Spring ainda não consegue fazer a conversão dos dados. Teremos que configurar mais algumas coisas.

As novas configurações devem ser feitas na classe ServletSpringMVC, que é a classe de inicialização da nossa aplicação. Nesta classe, iremos sobrescrever um método chamado customizeRegistration que recebe um objeto do tipo Dynamic que chamaremos de registration. Neste objeto, usaremos o método setMultipartConfig que requer um objeto do tipo MultipartConfigElement. O MultipartConfigElement espera receber uma String que configure o arquivo. Não usaremos nenhuma configuração para o arquivo, queremos receber este do jeito que vier. Passamos então uma String vazia.

O código destas mudanças ficará assim:

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{
    [...]
    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }

}
Reiniciando o servidor e testando novamente, veremos que o produto foi cadastrado com sucesso e no console do Eclipse o nome do arquivo deve estar impresso. Verifique, faça o teste.

Apesar de funcionar, a intenção não é simplesmente imprimir o nome do arquivo no console. Mas sim enviar o arquivo e deixa-lo hospedado no servidor. Este código é um código de infra (abreviação de infraestrutura). Ele carregará os arquivos enviados e assim irá salvar os arquivos em algum diretório/pasta especifico.

Vamos criar uma nova classe para conter esse código. Vamos chama-la de FileSaver e deixa-la no pacote br.com.casadocodigo.loja.infra. Nós precisamos que essa classe seja reconhecida pelo Spring para que ele consiga fazer os injects corretamente. Está classe é importante e ela representa um componente em nosso sistema. Teremos então que usar a anotação @Component.

Nesta classe criaremos um método chamado write que fará a transferência do arquivo e retornará o caminho onde o arquivo foi salvo. Este método então precisara de duas informações, o local onde o arquivo será salvo e o arquivo em si. O local será recebido como String e o arquivo como um objeto MultipartFile. Os quais chamaremos de baseFolder e file respectivamente.

@Component
public class FileSaver {
    public String write(String baseFolder, MultipartFile file){

    }
}
Com o baseFolder e o file em mãos, conseguiremos facilmente montar uma String que indique o caminho do arquivo a ser salvo. Com esta String construída, criaremos um novo objeto do tipo File que irá representar o arquivo a ser gravado no servidor. Este último objeto será passado para o método transferTo que será o método responsável por transferir o arquivo para o servidor. O código parece ser mais fácil de entender.

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
Note que a String path monta o caminho do arquivo. O file.transferTO() faz a transferência do arquivo e o objeto File representa um o arquivo no servidor. O bloco try/catch foi adicionado por causa que operações I/O, ou seja, de entrada e saída, que podem gerar erros. Perceba também que estamos retornando a String path dentro do bloco try.

Apesar deste código parecer claro, não podemos definir com certeza o caminho final do arquivo, o caminho absoluto que ele vai ter ao ser enviado. Podemos mudar isto detectando o caminho atual que o usuário está em nosso sistema e fazer o upload do arquivo baseado neste caminho. Para isso precisamos dos dados da requisição, pois com ela sabemos onde o usuário está em nosso sistema.

Pensando nisso, criaremos um atributo do tipo HttpServletRequest na classe FileSaver, chamaremos este de request e o marcaremos com a anotação @Autowired para que o Spring faça o inject desse atributo. A partir deste objeto, conseguimos extrair o contexto atual em que o usuário se encontra e então conseguir o caminho absoluto desse diretório em nosso servidor.

Vamos começar criando este novo atributo.

@Component
public class FileSaver {
    @Autowired
    private HttpServletRequest request;
    [...]
}
E então, dentro do bloco try/catch usaremos o método getServletContext para extrair o contexto atual do usuário e logo em seguida, do retorno deste método, usaremos o getRealPath que irá nos retornar o caminho completo de onde está determinada pasta dentro do servidor. Passaremos para o getRealPath o nome da pasta base que estamos recebendo em nosso método para que este método encontre a pasta correta. O bloco try/catch então fica dessa forma:

public String write(String baseFolder, MultipartFile file) {
    try {
        request.getServletContext().getRealPath("/"+baseFolder);
        [...]
    }catch([...]){
        [...]
    }
}
O caminho do arquivo agora é diferente do que fizemos antes, ele não é mais uma simples junção do baseFolder com o nome do arquivo. Este caminho agora precisa ser concatenado com o caminho absoluto que acabamos de implementar através do request. Sendo assim, guardaremos o retorno do request.getServletContext().getRealPath("/"+baseFolder); em uma nova String que chamaremos de realPath e usaremos esta String para concatenar ao path do arquivo que geramos anteriormente. Observe o código:

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
Quase nada mudou, apenas a String path deixou de concatenar o basePath e passou a concatenar o realPath. A classe FileSaver está pronta. Ela recebe um arquivo e o nome de uma pasta, transfere o arquivo enviado pelo formulário para a pasta e retorna o caminho onde o arquivo foi salvo.

Agora só precisamos alterar o ProdutosController para usar a classe FileSaver. Como queremos que o Spring fique responsável por instanciar estes objetos. Usaremos a mesma estratégia do request na classe FileSaver, mas agora em nosso ProdutosController com o FileSaver. Criaremos um atribudo da classe e assinaremos este atributo com@Autowired.

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private FileSaver fileSaver;

    [...]
}
O próximo passo é usar este objeto no método gravar. Usaremos o método write deste objeto e passaremos o objeto MultipartFile que recebemos no método gravar como arquivo a ser salvo e como nome da pasta passaremos a String arquivos-sumario. Vamos pôr este código após a verificação de erros, desta forma o arquivo só será efetivamente gravado caso não haja erros de validação no formulário. O código do método gravar fica assim:

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
Lembre-se que a classe que salva o arquivo no servidor retorna o caminho do arquivo. Este caminho deve ser salvo no banco de dados, por isso estamos usando a String path e passando esta String para o método setSumarioPath do produto.

Podemos reiniciar o servidor e fazer alguns testes agora. Mas quando reiniciamos, recebemos um erro: No qualifying bean found for dependency

O Spring indica que não foi encontrado nenhum bean qualificado. Isso acontece porque ele não consegue encontrar nossa classe FileSaver pois esta em um pacote não gerenciado pelo Spring. Solucionamos isso atualizando o componentScan na classe de configuração da aplicação, a classe AppWebConfiguration:

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class, FileSaver.class})
public class AppWebConfiguration {
    [...]
}
Com esta configuração feita, o servidor reiniciará normalmente. Então podemos testar cadastrar um livro com sumário. Por questões de ser um teste simples, escolha um arquivo qualquer, pode ser até mesmo uma pequena imagem. Preencha e submeta o formulário para ver o resultado. Erro 500 - FileNotFoundException

O erro acontece porque a pasta arquivos-sumario não existe. Vamos criar então esta pasta dentro de src/main/webapp/. Com a pasta criada, refaça o teste e veja tudo funcionar perfeitamente.

Note que apesar de salvarmos o caminho completo para o arquivo, não precisamos realmente do caminho completo. Perceba que se acessarmos localhost:8080/casadocodigo/arquivos-sumario/NOME_DO_ARQUIVO já poderiamos acessar o arquivo diretamente. Mas se tentarmos teremos um erro 404.404 - file not found

O motivo deste erro descobriremos mais a frente neste curso, mas por hora, faremos um pequeno ajuste no caminho retornado pelo médoto write na classe FileSaver que retorna o caminho absoluto do nosso arquivo para retornar o caminho relativo ao nosso sistema.

O caminho relativo é composto pelo baseFolder + nomeDoArquivo. Nosso método que estava assim:

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
Agora ficará assim:

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
Está mudança aparentemente não afetou em nada nosso sistema, mas agora em vez de guardamos o caminho completo até o arquivo, armazenamos apenas uma parte. Isso fará com que fique mais simples a exibição das imagens posteriormente.

Recapitulando
Fizemos uma série de adições em nosso sistema nesta aula. Adicionamos um input de arquivos para o envio dos sumários dos livros que serão cadastrados. Agora, os produtos guardam o caminho dos sumários. O upload dos arquivos também funciona graças às configurações de Resolver e de Multipart que fizemos e por último - mas não menos importante - fizemos a classe FileSaver que efetivamente realiza a transferência dos arquivos para o servidor.

Em seguida, faremos alguns exercícios para fixar o que aprendemos até aqui. Não se esqueça de que qualquer dúvida pode ser postada no forúm.

--------------------------------------------------------------------------------------
<h1>Seção 10 - Url amigáveis</h1>

Nesta aula, criaremos a página de "detalhes" dos nossos livros. Se entrarmos no site da Casa do Código e clicarmos em qualquer um dos livros, veremos outra página com todos os detalhes do produto, como por exemplo: a descrição, a quantidade de páginas, sumário etc.

Diversas dessas informações estão sendo gravadas no banco de dados durante o cadastro do produto. Então, vamos utilizar a página da Casa do Código como modelo e criar nossa página de detalhes.

Observação: Os arquivos da página de modelo que usaremos estão disponíveis para download* nos exercício. Usaremos o código disponibilizada como referência nesta aula.

Faremos na página de "detalhes" uma série de modificações para que esta passe a exibir os detalhes dos nossos produtos. A página se encontrará no arquivo detalhe.jsp. A primeira mudança que faremos neste arquivo é referente ao título da páginas. Veja como está agora:

<title>Livros de Java, SOA, Android, iPhone, Ruby on Rails e muito mais - Casa do Código</title>
Como a página deve exibir os detalhes de um determinado produto. Mudaremos o título de acordo com o livro escolhido. Substituiremos então a parte do título da página que tem o seguinte texto: Livros de Java, SOA, Android, iPhone, Ruby on Rails e muito mais para ${produto.titulo}.

<title>${produto.titulo} - Casa do Código</title>
Na tag body não há nenhuma classe de estilo. Vamos usar uma chamada produto para esclarecer que se refere à página de um produto especifico. Assim também poderemos aproveitar os CSS da Casa do Código. A tag body ficará dessa forma: <body class="produto">.

Note que o código fonte da página está todo em Inglês. Por questões de praticidade, modificaremos algumas partes para usarmos o idioma Português. Busque a parte do código referente ao carrinho de compras, que estará dentro da tag header:

 <header id="layout-header">
        <div class="clearfix container">
            <a href="/" id="logo">
            </a>
            <div id="header-content">
                <nav id="main-nav">

                    <ul class="clearfix">
                        <li><a href="/cart" rel="nofollow">Carrinho</a></li>

                        <li><a href="/pages/sobre-a-casa-do-codigo" rel="nofollow">Sobre Nós</a></li>

                        <li><a href="/pages/perguntas-frequentes" rel="nofollow">Perguntas Frequentes</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
Nós iremos trabalhar com a seguinte li:

<li><a href="/cart" rel="nofollow">Carrinho</a></li>.
Vamos mudar o /cart para /carrinho. O código resultante será:

<li><a href="/carrinho" rel="nofollow">Carrinho</a></li>
Não vamos nos preocupar com as urls neste momento, faremos elas funcionarem logo em seguida.

A tag article tem o atributo id, gerado dinamicamente pelo sistema da Casa do Código.

<article id="livro-java8" itemscope intemtype="http://schema.org/Book">
          <header id="product-highlight" class="clearfix">
            <div id="product-overview" class="container">
              <img itemprop="image" width="280px" height="395px" src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145" class="product-featured-image" />
              <h1 class="product-title" itemprop="name">Java 8 Prático: Lambdas, Streams e os novos recursos</h1>

              \...
Vamos fazer uma adaptação para que seja usado o id do produto exibido.

Iremos apagar o seguinte trecho na primeira linha

itemscope intemtype="http://schema.org/Book
E da mesma forma que fizemos no título da página, faremos o seguinte: ${produto.id}.

A tag article ficará assim:

<article id="${produto.id}">
No arquivo disponibilizado da Casa do Código, na tag h1 dentro da tag article faremos alterações para o texto AQUI COLOQUE O TÍTULO.

\...
  <h1 class="product-title">AQUI COLOQUE O TÍTULO</h1>
              <p class="product-author">
                <span class="product-author-link">

                </span>
              </p>
No lugar, iremo substituir pelo nome do produto. Já sabemos como fazer, certo? Podemos usar ${produto.titulo}. A tag h1 ficará assim:

<h1 class="product-title">${produto.titulo}</h1>
Onde temos o seguinte código:

<p class="book-description">
    AQUI COLOQUE A DESCRIÇÃO
</p>
Vamos trocar o texto AQUI COLOQUE A DESCRIÇÃO pela real descrição do livro através do produto: ${produto.descricao}.

<p class="book-description">
    ${produto.description}
</p>
O código ficará assim:

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
Um pouco mais abaixo deste código encontraremos a parte do código HTML referente a compra dos livros. A parte do HTML que exibe os preços dos livros. As opções de preço são envolvidas pela tag li. Veja o código atual:

<li class="buy-option">
    <input type="radio" name="id" class="variant-radio" id="product-variant-9720393823" value="9720393823"  checked="checked"  />
    <label  class="variant-label" for="product-variant-9720393823">
      E-book + Impresso 
    </label>
    <small class="compare-at-price">R$ 39,90</small>
    <p class="variant-price">R$ 29,90</p>
</li>
No cadastro de produtos, deixamos disponível três opções de preços: Ebook, Impresso e Combo. Vamos aproveitar as facilidades da Expression Language e fazer um forEach para repetir o código de opção de compra para as três opções que temos. Faremos uso da tag forEach da JSTL. O código deste forEach ficará dessa forma:

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
Note que a tag li que estamos modificando está dentro de um formulário. Ou seja, envolvido por uma tag form. Cada li no código da se refere a uma variante do produto, que podem ser: Ebook, Impresso ou Combo. Na Casa do Código cada uma dessas variações tem um id próprio, mas em nosso caso não. Temos variações de preços, mas não de produtos.

Sendo assim, iremos remover o valor do atributo id do input type="radio" fazendo com que o código fique desta forma:

<c:forEach items="" var="preco">
    <li class="buy-option">
        [...]
        <input type="radio" name="id" class="variant-radio" id="" value="9720393823"  checked="checked"  />
        [...]
    </li> 
</c:forEach>
Dessa forma, perdemos a referência para o produto a ser adicionado ao carrinho de compras do nosso sistema. Este formulário que estamos modificando é o que adiciona produtos no carrinho. Precisamos de alguma referência do produto a ser adicionado no carrinho. Vamos criar um novo input, mas desta vez sendo do tipo hidden, configurando o valor desse input para ser o id do produto e o name como sendo produtoId. Este código deve vir antes do forEach.

<input type="hidden" value="${produto.id}" value="produtoId" />
Agora que temos uma referência ao produto, precisamos deixar disponível também uma referência ao tipo de preço a ser escolhido pelo usuário na hora da compra. Modificamos anteriormente o input type="radio" no qual o usuário selecionava uma variante do produto. No nosso caso, temos variantes de preço. Vamos adaptar isso também.

O input type="radio" agora deve referenciar os tipos de preços que temos em nosso sistema. seu atributo name então deve ter valor definido como tipo assim como seu id. E o atributo value deve ter seu valor definido como o tipo de preço do produto. Algo como: ${preco.tipo}.

No label que se encotra logo abaixo do input type="radio" deve ser exibido o tipo de preço. Então em vez de:

<label  class="variant-label" for="product-variant-9720393823">
  E-book + Impresso 
</label>
Teremos:

<label  class="variant-label">
    ${preco.tipo}
</label>
Removemos o atributo for porque não precisamos dele e também para deixar o código um pouco mais simples.A tag p abaixo do label exibe o valor do produto, o preco! Até aqui só exibimos informações referentes ao tipo do preço. Não podemos esquecer do valor. Exibiremos então o valor do preço atravéz do código: ${preco.valor}. A tag p que se encontra assim:

<p class="variant-price">R$ 29,90</p>
Ficará assim:

<p class="variant-price">${preco.valor}</p>
A última mudança que precisamos fazer no formulário de adição produtos no carrinho é referente ao atributo title do botão no final do formulário. Este botão é do tipo submit, responsável por fazer o envio dos dados do formulário. O botão contém o atributo title da seguinte forma: title="Compre Agora".

 <button type="submit" class="submit-image icon-basket-alt" alt="Compre Agora" title="Compre Agora"></button>
Vamos compor este título com o nome do livro, para ficar mais intuitivo. Desta forma o atributo do botão ficará da seguinte forma:

title="Compre Agora ${produto.titulo}!"
Observação: Não esqueça de atualizar os outros pontos do código que se referem ao carrinho de compras. Modificamos o /cart para /carrinho lembra? Essa mudança também ocorre na action do formulário que estava assim:


<form action="/cart/add" method="post" class="container">
E ficou assim:

<form action="/carrinho/add" method="post" class="container">
O código completo do formulário com todas as modificações que fizemos até aqui ficará da seguinte forma:

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
Não se preocupe com as partes que não modificamos. Estamos adaptando o código as nossas necessidades e ainda vamos continuar modificando nos próximos passos.

Antes do final da tag article existe uma tag section que deve exibir algumas informações que também são importantes de serem mostradas. Como o número de páginas e a data de publicação. Veja o código dessa seção abaixo:

<section class="data product-detail">
    <h2 class="section-title">Dados do livro:</h2>
    <p>Número de páginas: <span>AQUI O NÚMERO DE PÁGINAS</span></p>
    <p></p>
    <p>Data de publicação: AQUI A DATA DE PUBLICAÇÃO </p>
    <p>Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta uma errata</a></p>
</section>
Vamos exibir o número de páginas através de: ${produto.paginas} e a data de lançamento da seguinte forma: ${produto.dataLancamento}. Depois dessas mudanças o código da seção ficará assim:

<section class="data product-detail">
    <h2 class="section-title">Dados do livro:</h2>
    <p>Número de páginas: <span>${produto.paginas}</span></p>
    <p></p>
    <p>Data de publicação: ${produto.dataLancamento}</p>
    <p>Encontrou um erro? <a href='/submissao-errata' target='_blank'>Submeta uma errata</a></p>
</section>
Nossa página de detalhe com todas as modificações que fizemos até aqui está pronta. Precisamos agora criar um novo método na classe ProdutosController que faça a seguinte tarefa: Buscar um produto usando o id e deixar este produto disponível na view de detalhes, ou seja, no arquivo detalhe.jsp.

Chamaremos este novo método de detalhe. Ele precisa fazer o mapeamento para a url /detalhe através da anotação @RequestMapping e receber um id do tipo int. Após isto, precisaremos criar um objeto do tipo ModelAndView passando para o construtor da classe do ModelAndView o caminho da view a ser utilizada. A view a ser utilizada será detalhe.jsp, que acabamos de criar.

No próximo passo, usaremos o objeto produtoDao que temos no ProdutosController para buscar os livros pelo id e atribui-lo a um outro objeto da classe Produto. O método que faz a busca se chamará find. Ainda não temos o método da busca, mas vamos deixar a parte do controller pronta. O código ficará assim:

@RequestMapping("/detalhe")
public ModelAndView detalhe(int id){
    ModelAndView modelAndView = new ModelAndView("/produtos/detalhe");
    Produto produto = produtoDao.find(id);
    modelAndView.addObject("produto", produto);
    return modelAndView;
}
Em seguida, iremos criar o método find na classe ProdutoDAO para que receba um id e retorne um objeto da classe Produto. Para esta tarefa utilizaremos o objeto manager da classe ProdutoDAO para buscar o produto através do método find, que requer dois parâmetros. O primeiro se refere à classe representante da entidade na qual o produto será buscado. O segundo será o próprio id. O valor do primeiro parâmetro será Produto.class. No fim, retornaremos o resultado dessa busca. O código ficará dessa forma:

public Produto find(int id){
    return manager.find(Produto.class, id);
}
A página de detalhes deve funcionar e já estamos fazendo a busca pelo produto no banco de dados. Também implementamos a lógica que busca o produto e envia o produto para a view no ProdutosController. Logo, poderemos exibir os dados do produto no arquivo detalhe.jsp que é a nossa view.

Mas como faremos para acessar a páginas de detalhes de um produto? Vamos precisar passar o id para que o produto possa ser buscado e exibido. Podemos tentar acessar diretamente pela url. O id pode ser passado na url da seguinte forma: detalhe?id=4. Sendo assim, podemos montar a seguinte url para exibir os detalhes de um determinado livro:

localhost:8080/casadocodigo/produtos/detalhe?id=4
Agora, é possível ver a página de detalhes de um livro. Alguns detalhes poderão não ser exibidos corretamente - isso é perfeitamente normal -, porque não fizemos todas as adaptações necessárias ainda. Os preços são uma das informações que não serão exibidas corretamente, considerando que não o escrevemos da forma correta. Veremos como ele esta agora:

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
Perceba que não preenchemos o atributo items do forEach. Devemos passar, para este atributo, a lista de preços presente no produto dessa forma:

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
Se atualizamos a página agora, teremos um erro:

Erro LazyInitializationException

Este erro de LazyInitializationException indica que ao carregar o produto, os preços não foram carregados juntos. Ou seja, tentamos exibir os preços sem carregá-los do banco de dados. Isto acontece porque nosso ProdutoDAO no método find só busca o produto, sem se relacionar com seus preços.

Precisamos então fazer com que o Hibernate relacione os produtos com seus preços. Faremos isto através de uma query personalizada:

select distinct(p) from Produto p join fetch p.precos precos where p.id = :id
Observe que estamos fazendo um select comum, mas estamos usando o distinct para que o Hibernate nos retorne apenas resultados diferentes. Estamos também fazendo um join fetch com a tabela Precos usando como relação o id do produto presente na tabela de preços.

Usaremos o sql através do método createQuery e passaremos o :id através do método setParameter. Queremos retornar apenas um resultado desta query através do método getSingleResult. Nosso método find ficará assim:

return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
Para que não precisemos ficar chutando ids diretamente na url. Criaremos links na listagem e assim poderemos clicar em um determinado produto e já visualizar a página de detalhes do produto. Faremos isso no arquivo lista.jsp usando o construtor de urls do Spring. Lembra do mvcUrl? Iremos usa-lo novamente aqui.

Passaremos o id para o mvcUrl através do método arg que recebe dois parâmetros: o primeiro será a posição do parametro, que terá valor 0. O segundo será o valor do parâmetro, o produto.id.

<a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>
Observação: Estamos construindo o link para a página de detalhes do produto na listagem dos produto. Este link deve ser criado de forma a envolver o título do livro na listagem. Lembre-se de importar a taglib do Spring para poder usar o mvcUrl da mesma forma que fizemos no form.jsp usando o import: <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>.

Mas veja como está ficando nossa url: http://localhost:8080/casadocodigo/produtos/detalhe?id=2.

Observe como são as urls do site da Casa do Código:

https://www.casadocodigo.com.br/products/livro-code-igniter
Elas parecem mais interessantes, porque mostram o nome do produto. Estas urls são chamadas de URLs Amigaveis.

Nós não mudaremos nossas urls para ficarem amigaveis desta forma, mas faremos com que o parâmetro seja passado de forma diferente. Veja como nossa url parece mais simples usando o seguinte formato:

http://localhost:8080/casadocodigo/produtos/detalhe/2
Eliminaremos o ?id= e deixaremos nossas urls mais simples.

Para isto, precisamos mudar a assinatura do método detalhe em nosso ProdutosController. Ela precisa receber o parâmetro separado pela barra (/). A anotação @RequestMapping permite que façamos isso da seguinte forma:

@RequestMapping("/detalhe/{id}")
Mas apenas isto não é o suficiente. Precisaremos indicar para o método detalhe que o parâmetro id será recuperado do caminho da url. Então, usaremos uma nova anotação: @PathVariable passando o id desta forma: @PathVariable("id").

Com as alterações o método detalhe da classe ProdutosController ficará assim:

@RequestMapping("/detalhe/{id}")
public ModelAndView detalhe(@PathVariable("id") Integer id){
    ModelAndView modelAndView = new ModelAndView("/produtos/detalhe");
    Produto produto = produtoDao.find(id);
    modelAndView.addObject("produto", produto);
    return modelAndView;
}
Algumas coisas ainda não estão prontas - nossas datas ainda não são exibidas corretamente. Mas corrigiremos isso em breve.

Por enquanto, faremos alguns exercícios para fixar o que vimos até aqui. Mas já aprendemos como relacionar os produtos com seus preços, criar a página de detalhes do produto e configurar as urls para ficarem amigáveis.

Faça o download do código fonte da página da casa do código. Como o layout da Casa do Código mudou, você pode baixar o layout antigo aqui: https://s3.amazonaws.com/caelum-online-public/spring-mvc-1-criando-aplicacoes-web/detalhe-com-css.zip

Após baixar, será necessário importar no Eclipse. Para isso siga os seguintes passos: Botão direito em cima do projeto, escolha a opção Import, procure pela opção Archive File e clique em Next. Após isso, procure pelo ZIP baixado e depois clique em Finish.

Para verificar se tudo deu certo, abra a pasta src > main > webapp > resources e verifique se existem duas pastas chamadas css e imagens. Verifique também se o arquivo detalhe.jsp existe dentro de WEB-INF > views > produtos.


--------------------------------------------------------------------------------------------------
<h1>Seção 11 - Expondo atributos no jsp</h1>


Nas aulas anteriores, fizemos a página de detalhes de produto. Nela, além de exibirmos todos os detalhes do produto, construímos um formulário em que o usuário pode selecionar a opção de preço e clicar no botão de adicionar produto ao carrinho.

Observe que a action deste formulário aponta para uma url diferente. Ela aponta para /carrinho/add. Não temos nenhum código que atenda as requisições enviadas para este endereço. Até o momento só temos classes que atendam as requisições que usam o caminho /produtos.

Veja como está atualmente o formulário de compra de produtos.

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
Precisamos criar um novo controller, assim as requisições enviadas para o caminho /carrinho serão atendidas da mesma forma que fizemos com os produtos. Crie então uma nova classe chamada CarrinhoComprasController e não se esqueça de deixa-lo no pacote br.com.casadocodigo.loja.controllers. Faça uso também das anotações @Controller e @RequestMapping com o valor /carrinho, para que o Spring reconheça esta classe como um controller e que o mapeamento da rota seja feito corretamente. Até então teremos a classe CarrinhoComprasController:

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

}
A primeira funcionalidade que vamos codificar é a adição de produtos ao carrinho de compras. Vamos começar adicionando um método chamado add na classe CarrinhoComprasController que retorna um objeto do tipo ModelAndView. Este método precisa receber dois parâmetros que são: O id do produto e o tipo de preço selecionado pelo usuário. Lembre-se que apenas o id do produto está sendo enviado pelo formulário da página de detalhes e não o produto.

Ao escolher um produto faremos com que o método redirecione o usuário para a listagem de produtos. Sendo assim, até aqui teremos:

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
    return modelAndView;
}
Observação: Perceba o uso da anotação @RequestMapping("/add") que faz o mapeamento da rota /carrinho/add para este método no CarrinhoComprasController.

Abaixo, vemos a classe CarrinhoComprasController com o código completo escrito até aqui:

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipo){
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");

        return modelAndView;
    }

}
O que precisamos fazer agora é definir uma forma de relacionar o produto com seu preço. Podemos fazer isso de uma forma muito simples: criando um outro objeto que represente este relacionamento. O objeto será criado através da classe CarrinhoItem que iremos codificar agora. Esta só terá os atributos produto e tipoPreco. Um construtor que receba estes dois parâmetros e os Getters and Setters destes mesmos atributos. Assim teremos a classe CarrinhoItem:

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
Observação: Por se tratar de uma classe de negócio, esta ficará no pacote br.com.casadocodigo.loja.models. Ela não é um controller nem uma view e contém uma lógica importante para o negócio.

Nosso próximo passo será criar um método privado na classe CarrinhoComprasController para que ele crie e retorne um objeto da classe CarrinhoItem. Busque o produto pelo id no banco de dados e relacione o produto com o preço selecionado pelo usuário. Chamaremos este método de criaItem. Como estamos falando de buscar produtos no banco de dados, criaremos também um atributo na classe CarrinhoComprasController do tipo ProdutoDAO chamado produtoDao, com a anotação @Autowired. Iremos usá-lo para a busca do produto.

@Autowired
private ProdutoDAO produtoDao;

private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipo){
    Produto produto = produtoDao.find(produtoId);
    CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipo);
    return carrinhoItem;
}
Agora temos que usar o método dentro do método add da classe CarrinhoComprasController, passando para ele o produtoId e o tipo de preço. Então receberemos o objeto retornado pelo método criaItem.

CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
O médoto add até o momento ficará assim:

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
    return modelAndView;
}
O que fica faltando para terminarmos a funcionalidade de adicionar produtos ao carrinho de compras é: O próprio carrinho, incluindo pelo menos um método que faça a adição do carrinhoItem a uma lista. Vamos fazer isso, então.

Crie uma nova classe chamada CarrinhoCompras no pacote br.com.casadocodigo.loja.models e logo em seguida crie um método que não tem retorno, ou seja, void chamado add. Este método deve receber um objeto da classe CarrinhoItem que é a classe que representa um item em nosso carrinho.

public class CarrinhoCompras {
    public void add(CarrinhoItem item){

    }
}
Algo comum nas lojas online é que ao selecionarmos determinado produto, podemos também especificar a quantidade. Nossa página de detalhes não permite esse tipo de comportamento, mas em no carrinho de compras fará muito sentido incluir este tipo de informação. Por isso precisaremos de uma lista que associe o item a sua quantidade. Neste caso, usaremos uma do tipo Map, que permitirá a associação entre uma chave, que será o item do carrinho, e um valor, que será a quantidade total de cópias do mesmo produto.

Logo, adicionaremos à classe carrinho um atributo privado chamado itens, do tipo Map<CarrinhoItem, Integer>, e o instanciaremos com um objeto da classe LinkedHashMap.

private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<CarrinhoItem, Integer>();
Com a lista pronta, precisaremos que ao adicionarmos um produto, seja verificado se o produto já existe em nossa lista. Caso exista, somaremos +1 na quantidade, caso não exista, adicionamos o produto selecionado. Veja o código abaixo:

public void add(CarrinhoItem item){
    itens.put(item, getQuantidade(item) + 1);
}
Apesar de não termos o método getQuantidade ainda, pode-se notar que a lógica é simples. Ele deve retornar o número de vezes em que o produto foi encontrado na lista e somar 1 a essa quantidade. Agora vejamos como fica essa lógica em código.

private int getQuantidade(CarrinhoItem item) {
    if(!itens.containsKey(item)){
        itens.put(item, 0);
    }
    return itens.get(item);
}
Perceba que estamos usando o método containsKey que verifica se a lista tem a chave, que no caso é o item do carrinho. Estamos usando ! que é o sinal de negação da expressão lógica. Ou seja, se a lista não tiver o item, este será adicionado com o valor 0 na mesma. E então o método get usado no return retorna o valor que está associado aquela chave.

Explicando melhor... Caso o item não exista na lista, colocamos o item e retornamos o valor 0, que será incrementado pelo metódo add. Mas caso o item já exista, retornamos apenas o valor que representa a quantidade de vezes que o produto foi adicionado na lista.

Apesar de usar o método containsKey não é o suficiente. Ele usa o método equals disponível na classe Object. Para que o método containsKey consiga comparar corretamente os itens da lista, devemos sobrescrever dois métodos na classe CarrinhoItem e depois, na classe Produto. Use os geradores do Eclipse e selecione a opção Generate HashCode and Equals. Na classe CarrinhoItem, teremos algo parecido com:

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
Observação: Lembre-se que estes métodos são gerados a partir dos atributos da classe. No caso da classe CarrinhoItem, deixamos todos os atributos selecionados, mas no caso da classe Produto, usaremos apenas o atributo id que é gerado pelo banco de dados e nos garante que o produto é único. Na classe produto, teremos:

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
Com tudo isso feito, estamos quase prontos para testar se o carrinho de compras da nossa aplicação está realmente funcionando. O último passo é usar a anotação @Component na classe CarrinhoCompras para que o Spring instancie automaticamente objetos desta classe quando necessário. Depois, a classe ficará desta forma:

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
Lembre-se de que ainda não estamos adicionando os produtos ao carrinho de compras. Precisamos fazer isso no método add da classe CarrinhoComprasController. Primeiro faremos com que o Spring instancie para nós o carrinho de compras. Fazemos isso criando um atributo no controller em questão, que chamaremos de carrinho e o anotaremos com @Autowired.

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {

    @Autowired
    private CarrinhoCompras carrinho;
}
Após isso, no método add da classe CarrinhoComprasController, usaremos o método add do objeto carrinho, passando o objeto carrinhoItem para que este seja adicionado ao carrinho de compras.

Até aqui o método add da classe CarrinhoComprasController está assim:

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
    return modelAndView;
}
Em seguida, ficará assim:

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
    carrinho.add(carrinhoItem);
    return modelAndView;
}
Podemos iniciar agora o servidor Tomcat para podermos testar essa nova funcionalidade. Mas ao iniciar, recebemos uma mensagem de erro:

No qualifying bean of type [br.com.casadocodigo.loja.models.CarrinhoCompras] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency
Já vimos este erro antes. O Spring não está conseguindo encontrar a classe CarrinhoCompras. Isto porque o pacote models não está sendo scaneado pelo Spring. Da mesma forma que fizemos com o ProdutoDAO outra vez, faremos agora com o CarrinhoCompras. Na anotação @ComponentScan da classe AppWebConfiguration adicionaremos a classe CarrinhoCompras.

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class, FileSaver.class, CarrinhoCompras.class})
public class AppWebConfiguration {
    [...]
}
Se tentarmos testar novamente agora, não iremos receber nenhum erro do servidor. Então, tente acessar a listagem de produtos, escolher um tipo de preço e clicar no botão de adicionar produto ao carrinho. Teremos um novo erro.

404 - Not Found para /carrinho/add

Note a URL da página, ela não tem o contexto da aplicação. O contexto seria o /casadocodigo que é o nome do projeto. A URL da página fica com o endereço localhost:8080/carrinho/add. Para corrigir isso, usaremos uma tag da taglib core da JSTL no formulário da página de detalhes do produto.

No Arquivo detalhes.jsp na tag form, teremos o atribudo action com o valor /carrinho/add. Este tipo de endereço, faz com que o contexto da aplicação seja perdido. A tag c:url da JSTL cria URLs baseadas no contexto. Ela resolverá nosso problema. Antes das alterações, a action do formulário em detalhes.jsp está assim:

[...]
    <form action="/carrinho/add" method="post" class="container">
[...]
Agora, ela ficará assim:

[...]
    <form action='<c:url value="/carrinho/add" />' method="post" class="container">
[...]
Observação: Fique atento sobre as aspas nesta modificação, foi necessária a mudança por causa de conflitos que seriam gerados se usássemos aspas iguais no atribudo action e na tag c:url. Agora, estará tudo funcionando normalmente.

Da página de detalhes somos levados à listagem dos produtos quando selecionados o tipo de preço do produto e clicamos na opção de adicionar o produto ao carrinho. Mas nada indica que o produto foi realmente adicionado. Vamos fazer com que o número de produtos no carrinho seja exibido junto ao link carrinho encontrado na página de detalhes. No seguinte trecho de código:

<li><a href="/cart" rel="nofollow">Carrinho</a></li>
Faremos algo do tipo:

<li><a href="/cart" rel="nofollow">Carrinho (${carrinhoCompras.quantidade}) </a></li>
A classe CarrinhoCompras já tem um método getQuantidade, mas ele só retorna a quantidade de um produto especifico. Criaremos um novo método getQuantidade que irá iterar entre todos os itens do carrinho e contar quantos produtos estão na lista de itens. Observe o seguinte código:

public int getQuantidade(){
    return itens.values().stream().reduce(0, (proximo, acumulador) -> (proximo + acumulador));
}
Este código percorre toda a lista de itens e soma o valor de cada item a um aculumador. Caso não conheça a API de Stream e Lambdas, que são recursos do Java 8, recomendamos que faça o curso de java 8 disponível aqui no Alura.

Veja o link de menu como se encontra após estas modificações:

Link do carrinho sem mostrar o total

Apesar de parecer funcionar, não funciona. Ao testarmos adicionar alguns produtos no carrinho, veremos que não há um número indicando que a contagem dos itens está sendo feita corretamente. Isto acontece porque o objeto que representa o carrinho de compras não está disponível em lugar nenhum a não ser dentro do escopo do Spring.

Anteriormente, marcamos a classe CarrinhoCompras com a anotação @Component. Essa anotação indica que a classe será tratada como um Bean do Spring. Para que possamos acessar esse Bean em nossas view, precisaremos adicionar uma configuração na classe WebAppConfiguration. No método InternalResourceViewResolver poderiamos usar o método setExposeContextBeansAsAttributes do objeto resolver com o valor true, mas esta configuração tornará todos os Beans da aplicação disponíveis, o que parece não ser uma boa ideia.

Ao invés disso, usaremos o método setExposedContextBeanNames deste mesmo objeto. Este método nos permite dizer qual *Bean estará disponível para a view. Os nomes dos Beans seguem um padrão bem simples. O padrão é o nome da classe com sua primeira em minúsculo, ou seja, a classe CarrinhoCompras fica carrinhoCompras. Com esta mudança o método InternalResourceViewResolver da classe WebAppConfiguration fica assim:

@Bean
public InternalResourceViewResolver internalResourceViewResolver(){
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    resolver.setExposedContextBeanNames("carrinhoCompras");
    return resolver;
}
Teste novamente, verá que agora a contagem acontece normalmente e é exibida na parte superior da página de detalhes da seguinte forma:

Carrinho exibindo total

Até aqui, fizemos uma séria de adições em nossa aplicação. Criamos o carrinho de compras, relacionamos os produtos e seus tipos de preço atravé de um item de carrinho e exibimos a contagem de itens no carrinho em nossa view.

Caso tenha dúvidas, fique a vontade para perguntar no forúm. Agora vamos praticar um pouco mais com alguns exercícios.

--------------------------------------------------------------------------------------------------
<h1>Seção 12 - Escopo sessão</h1>

Nas aulas anteriores, criamos o carrinho de compras da nossa aplicação e fizemos aparecer na página de detalhes o número de produtos que já adicionamos no carrinho. Faça alguns testes, adicione produtos para se certificar que tudo está funcionando perfeitamente.

Nossos testes até agora, não consideraram a situação na qual múltiplos usuários acessam a loja. Nós testamos considerando apenas um usuário. Faça o seguinte teste: Abra a aplicação em um navegador e adicione alguns itens no carrinho de compras. Após isso, abra um outro navegador e acesse a página de detalhes de um produto. O segundo navegador apresenta o carrinho com o mesmo número de itens do primeiro navegador. Isso não deveria acontecer.

Neste caso, dois navegadores diferentes deveriam representar dois usuários diferentes. Aparentemente, a aplicação está compartilhando o carrinho com todos os usuários que a acessam. Seria a mesma situação de estar em uma loja física e outra pessoa colocasse produtos em nossa sacola de compras. Isso não parece certo.

Note que quando um usuário escolhe um livro e depois, uma segunda pessoa escolhe outro item, os dois clientes estão adicionando produtos no mesmo carrinho.

Carrinho de compras compartilhado

Isso acontece porque ao marcarmos a classe CarrinhoCompras com a anotação @Component, transformando nossa classe em um Bean do Spring estamos também configurando que este objeto será Singleton. Por padrão, o Spring tem esta configuração para os seus componentes.

Para corrigir o problema, devemos especificar o escopo do componente através da anotação @Scope. Ela recebe um parâmetro chamado value que pode receber valores das constantes da interface WebApplicationContext.

Quando se faz necessário que um recurso seja individual, ou seja, único para cada usuário, definimos os recursos com o escopo de sessão. Este é criado a partir do momento em que o usuário entra em uma determinada aplicação e segue até o encerramento da mesma - ou ao fechar do navegador em alguns casos.

Então, configure a classe CarrinhoCompras para que o componente seja criado no escopo de sessão e assim seja único para cada usuário ao entrar na aplicação. A constante da interface WebApplicationContext neste caso será a SCOPE_SESSION.

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras {
    [...]
}
Mas fazer somente isso no Spring não será o suficiente. Se iniciarmos o servidor agora teremos um erro porque o escopo de sessão não é permitido dentro do CarrinhoComprasController que está dentro do escopo de aplicação. Resolveremos este problema com a mesma solução, mas com valores diferentes. Em seguida, entenderemos o motivo.

Controller no geral tem um papel bem definido, ele simplesmente trata a requisição. Ele recebe os dados, repassa para um outro objeto e devolve uma resposta. Pensando assim, podemos concluir que após a requisição ser atendida, não faz sentido que o controller ainda esteja "vivo". Geralmente, o escopo dos controllers é o de request. Isto significa que quando há uma requisição, o controller é criado e depois, ela deixa de existir. Podemos configurar isso através da anotação @Scope com o valor da constante SCOPE_REQUEST da interface WebApplicationContext.

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {
    [...]
}
Inicie o servidor, faça os testes novamente. Faça verificação tanto com um usuário quanto com vários. O carrinho de compras não deve mais estar compartilhado e cada usuário deve ter o seu próprio com os produtos selecionados.

<h2>Entendendo o escopo</h2>
O nosso carrinho já está funcionando, mas vamos pensar em como ele funcionaria para vários usuários. Abra dois navegadores diferentes e acesse a sua aplicação. Veja que os dados do carrinho estão sendo compartilhados com todos os usuários. Por que isso acontece ?

Por padrão o spring define que o escopo de todos os componentes é de "application" ou seja apenas uma instancia existe desde quando a aplicação foi criada. O principal problema dessa abordagem é esse que acabamos de encontrar, os usuários compartilham sempre os mesmos dados, uma alteração afeta todo mundo que está conectado a nossa aplicação. Para resolver isso precisamos mudar o escopo do nosso carrinho.

<h2>Tipos de escopo</h2>
Durante o vídeo foi apresentado três tipos diferentes de escopo: aplicação, sessão e request. Com as suas palavras descreva a diferença de cada um deles e qual escopo você deveria usar em um carrinho de compras.

O primeiro escopo apresentado é o escopo de aplicação, isto é, desde que o servidor é iniciado apenas um objeto na memória é manipulado, o que causa conflito quando temos mais de um usuário usando a nossa aplicação. O segundo escopo é o de sessão, no qual o objeto é criado para cada usuário que se conecta à aplicação, ou seja, usuários diferentes usam objetos diferentes, o que é ideal para um carrinho de compras, uma vez que cada usuário possui o seu próprio carrinho. O último escopo apresentado é o escopo de request, no qual cada vez que acessamos a página um objeto é criado.


--------------------------------------------------------------------------------------------
<h1>Seção 13 - Carrinho de compras</h1>

Se entrarmos no site da Casa do Código, selecionarmos um livro e clicar em comprar, veremos que o livro é adicionado ao carrinho de compras. Veremos também que o carrinho de compras é uma lista com todos os livros selecionados. Esta lista exibe os preços de cada livro, a quantidade e o total da soma dos preços.

Faremos o mesmo em nosso projeto. Crie uma nova pasta chamada carrinho no diretório webapp/WEB-INF/views/. Baixe os arquivos que serão usados nessa aula através deste link: https://s3.amazonaws.com/caelum-online-public/spring-mvc-1-criando-aplicacoes-web/carrinho-com-imagem.zip. Descompacte o zip baixado e extrai-o. Copie o arquivo itens.jsp que extraiu de dentro do zip e cole-o na pasta carrinho do seu projeto.

O primeiro ajuste que faremos é fazer com que a página de itens.jsp exiba a quantidade de produtos no carrinho do mesmo jeito que fizemos na página de detalhes. Encontre a seguinte linha de código no arquivo itens.jsp:

<li><a href="/cart" rel="nofollow">Carrinho</a></li>
E modifique para:

<li><a href="${s:mvcUrl('CCC#itens').build()}" rel="nofollow">Carrinho ( ${carrinhoCompras.quantidade} )</a></li>
Adicione o taglib "tags" em itens.jsp:

<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
Observação: Note que estamos criando uma nova url. Esta url criada aponta para o método itens na classe CarrinhoComprasController que ainda não existe, mas que criaremos em instantes. Este método será o responsável por exibir esta página.

O próximo passo será a criação da tabela que exibirá nossa lista de produtos. Procure as seguintes linhas no HTML da página itens.jsp:

<body>
    <tr>
        <td class="cart-img-col">
            <img src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145" width="71px" height="100px" />
        </td>
        <td class="item-title">TÍTULO DO LIVRO AQUI</td>
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
Perceba que pela estrutura da tabela, cada produto será representado por uma linha. Sendo assim, envolveremos a tag tr com a tag forEach da JSTL percorrendo a lista de itens presente em nosso carrinho. Até aqui teremos o seguinte código:

<c:forEach items="${carrinhoCompras.itens }" var="item">
    <tr>
        <td class="cart-img-col">
            <img src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145" width="71px" height="100px" />
        </td>
        <td class="item-title">TÍTULO DO LIVRO AQUI</td>
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
Antes de continuarmos, vamos implementar um novo método na classe CarrinhoCompras. Veja que apesar de estarmos fazendo ${carrinhoCompras.itens } a classe CarrinhoCompras não tem esse método. Outra observação a ser feita é que o carrinho de compras guarda um objeto do tipo Map e nesse ponto da aplicação, não queremos um Map mas sim uma lista. Veja o método a seguir:

public Collection<CarrinhoItem> getItens() {
    return itens.keySet();
}
O método anterior deve ser colocado na classe CarrinhoCompras. Perceba que ele retornar uma Collection que funciona como uma lista. Note também que o retorno do método captura as chaves do Map e as retorna. Se você se lembrar, vai perceber que as chaves desse Map são objetos da classe CarrinhoItem que possuem as informações sobre os produtos adicionados ao carrinho.

Agora, exibiremos as informações referentes aos produtos do carrinho de compras no HTML da página itens.jsp. Na linha onde há:

<td class="item-title">TÍTULO DO LIVRO AQUI</td>
Substitua por:

<td class="item-title">${item.produto.titulo}</td>
Apesar da linha anterior funcionar para o título do produto, não funcionaria para o preço. O preço dentro da classe produto está sendo representado por uma lista e não queremos uma lista de preços neste ponto da aplicação. Queremos simplesmente o preço selecionado pelo usuário, um único preço. Por hora faremos apenas item.preco e depois implementaremos este método para que funcione. Sendo assim onde há:

<td class="numeric-cell">R$ 59,90</td>
Substitua por:

<td class="numeric-cell">${item.preco}</td>
Agora exibiremos a quantidade de cada item adicionado no carrinho de compras. Encontre e observe a seguinte linha do HTML:

<input type="number" min="0" readonly="readonly" id="updates_4082273665" name="updates[4082273665]" value="1" />
O atributo id e name estão com alguns números malucos. Estes números são usados no site da Casa do Código. Não precisamos destes números. Modificaremos estes atributos para ter o texto quantidade e no valor usaremos o método getQuantidade da classe CarrinhoCompras que recebe um item e retorna a quantidade daquele item no carrinho. A linha anterior modificada fica assim:

<input type="number" min="0" readonly="readonly" id="quantidade" name="quantidade" value="${carrinhoCompras.getQuantidade(item) }" />
A seguinte linha diz respeito ao preço novamente, mas desta vez não é o valor unitário do produto. É o total da soma dos preços daquele produto específico. Criaremos um método pra isso em instantes, mas já vamos deixar o HTML pronto por hora. Onde esta assim:

<td class="numeric-cell">R$ 59,90</td>
Deixe assim:

<td class="numeric-cell">${carrinhoCompras.getTotal(item)}</td>
O método getTotal que usamos neste HTML não existe ainda. Iremos implementá-lo em instantes. O próximo passo será modificar o link de remoção de produtos do carrinho. Atualmente ele se encontra dessa forma:

<td>
    <a href="/cart/change?218748921802387812&quantity=0">
        <img src="/excluir.png" alt="Excluir" title="Excluir" />
    </a>
</td>
Em vez de um simples link para remoção, usaremos um formulário com o atributo method configurado como post. Substituiremos o link da tag a e a tag img pela tag input configurando o atributo type com o valor image. As modificações propostas ficam assim:

<td>
    <form action="" method="post">
        <input type="image" src="/excluir.png" alt="Excluir" title="Excluir" />
    </form>
</td>
Por último e não menos importante temos o rodapé desta tabela que lista nossos produtos no carrinho. Ela contém o seguinte código:

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
Só precisaremos modificar as duas tds centrais. Remover a que tem o name=update por se tratar de algo especifico da Casa do Código e fazer com que a que tem o valor R$ 59,90 passe a exibir o total calculado pelo carrinho de compras. Esta parte do código modificada deve ficar parecida com o código abaixo:

<tfoot>
    <tr>
        <td colspan="3">
            <input type="submit" class="checkout" name="checkout" value="Finalizar compra" />
        </td>
        <td class="numeric-cell">${carrinhoCompras.total}</td>
        <td></td>
    </tr>
</tfoot>
Na classe CarrinhoItem, precisaremos criar todos os métodos que usamos na tabela de lista para que a tabela possa funcionar corretamente o mostrar a lista dos produtos no carrinho. Começaremos pelo método que retorna o preço de um produto específico. O método será chamado de getPreco e retornará um objeto do tipo BigDecimal e este método simplesmente usará o objeto produto para retornar o preço escolhido pelo usuário através do objeto tipoPreco, veja o código:

public BigDecimal getPreco(){
    return produto.precoPara(tipoPreco);
}
O método precoPara não existe na classe Produto. Crie-o. Neste método, precisaremos filtrar de todos os preços, o preco escolhido e logo após encontra-lo retornar seu valor através do método getvalor(). Observe o código abaixo:

public BigDecimal precoPara(TipoPreco tipoPreco) {
    return precos.stream().filter(preco -> preco.getTipo().equals(tipoPreco)).findFirst().get().getValor();        
}
Outro método que precisamos implementar é o que soma o total de um produto específico e recebe um CarrinhoItem. O método fará o seguinte cálculo: Quantidade de vezes que aquele item foi adicionado no carrinho vezes o seu preço. Na classe CarrinhoCompras teremos então um método chamado getTotal que recebe um CarrinhoItem e chama o método getTotal daquele item. Passando para este método a quantidade de vezes que o produto foi adicionado ao carrinho. Até aqui teremos:

public BigDecimal getTotal(CarrinhoItem item){
    return item.getTotal(getQuantidade(item));
}
E na classe CarrinhoItem teremos:

public BigDecimal getTotal(int quantidade) {
    return this.getPreco().multiply(new BigDecimal(quantidade));
}
Note como é simples, estamos recuperando o preço do produto e usando o método multiply da classe BigDecimal e passando para este método um novo BigDecimal pois o valor recebido por parâmetro é do tipo int.

Agora precisamos mostrar o valor total do carrinho, até aqui só calculamos o total de um produto específico. Para calcular o total do carrinho, só precisamos fazer um laço na classe CarrinhoCompras que a cada iteração chame o método getTotal criado anteriormente. Passando como parâmetro o produto atual e guardando o resultado de cada iteração em uma variável. Este método também se chamará getTotal, mas não receberá parâmetros. Vejamos no código como fica:

public BigDecimal getTotal(){
    BigDecimal total = BigDecimal.ZERO;
    for (CarrinhoItem item : itens.keySet()) {
        total = total.add(getTotal(item));
    }
    return total;
}
Para podermos testar, vamos ajustar outros dois detalhes que são: O CarrinhoComprasController não tem nenhum método mapeando a página de itens do carrinho e vamos fazer com que ao adicionar um produto, o usuário seja redirecionado para a página de itens do carrinho.

Para o primeiro ponto, precisaremos de um novo método. Chamaremos este método de itens e o mapeamento será o mesmo do controller que é /carrinho. Neste caso especificaremos apenas o método HTTP que será GET. Este método apenas cria um objeto ModelAndView direcionando a requisição para a página itens.jsp. Vejamos em código:

@RequestMapping(method=RequestMethod.GET)
public ModelAndView itens(){
    return new ModelAndView("/carrinho/itens");
}
Observação: Lembre-se que esta adição e a próxima modificação é para ser feita na classe CarrinhoComprasController.

E para o ajuste do segundo ponto, precisamos apenas alterar o método add para que em vez de redirect:/produtos este faça redirect:/carrinho.

@RequestMapping("/add")
public ModelAndView add(Integer produtoId, TipoPreco tipo){
    ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
    carrinho.add(carrinhoItem);
    return modelAndView;
}
Se iniciarmos o servidor agora, teremos um erro do tipo NotSerializableException informando que o objeto da classe CarrinhoCompras não é serializável. Isso acontece, porque o servidor ao verificar que um objeto está em escopo de sessão, ele tenta salvar este objeto em arquivo. Para que ele possa sempre salvar a sessão e recuperar este objeto. Para resolvermos isto, basta fazer com que a classe CarrinhoCompras implemente a interface Serializable.

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class CarrinhoCompras implements Serializable{

    private static final long serialVersionUID = 1L;

}
Perceba que a interface Serializable não adiciona nenhum método, mas sim um atributo estático. Agora podemos testar! Faça todos os passos de uma compra normal, visite a lista de produtos, adicione alguns ao carrinho de compras e clique em Finalizar Compra. Verifique se tudo está funcionando corretamente e prossiga para a próxima aula, onde continuaremos a desenvolver nosso carrinho de compras.


--------------------------------------------------------------------------------------------------
<h1>Seção 14 - Finalizando o carrinho</h1>

Nosso carrinho de compras já funciona. Além de listar os produtos escolhidos, ele mostrará o total da soma dos preços dos produtos. O que falta fazer para que a aplicação fique completa é que ao clicar no botão de finalização da compra, a compra seja registrada.

Já que a compra é algo especifico e diferente da lógica do carrinho, criaremos um novo controller para podermos implementar tal funcionalidade. Crie uma nova classe chamada PagamentoController e a defina como controller assinando a mesma com a anotação @Controller. Defina também o caminho que o controller irá atender através da anotação @RequestMapping com o valor /pagamento.

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {

}
Neste controller criaremos um método responsável por finalizar as compras dos usuários. Chamaremos este método de finalizar e ele retornará um objeto do tipo ModelAndView redirecionando o usuário para a listagem dos produtos ou seja redirect:/produtos. Este método também será anotado com a anotação @RequestMapping usando o valor /finalizar.

O método finalizar não precisa receber nenhum parâmetro, mas ele precisa do carrinho de compras. O carrinho de compras já está no escopo de sessão e para que o tenhamos em mãos, precisamos apenas criar um novo atributo na classe PagamentoController do tipo CarrinhoCompras anotado com @Autowired. Desta forma o Spring já busca a atribui o carrinho de compra em nosso controller. Por hora, vamos apenas imprimir o total da compra e redirecionar. Até aqui teremos:

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
Parece estranho redirecionar o usuário e não informá-lo se o processo funcionou bem. Pensando nisto, vamos fazer uso da classe RedirectAttributes que chamaremos de model e do método addFlashAttribute para exibirmos uma mensagem amigável para o usuário. Nos campos de chave e valor do método addFlashAttributes usaremos sucesso e Pagamento Realizado com Sucesso respectivamente.

    model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso");
Com as alterações, o nosso código ficará assim:

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
Usamos como chave da mensagem o valor sucesso, porque na página de listagem dos produtos em lista.jsp já há um código responsável por exibir mensagens que venham com esta mesma chave. Lá deve haver uma linha código como esta:

<p> ${sucesso} </p>
Agora queremos que ao clicar no botão de finalizar a compra, a requisição seja enviada para o PagamentoController e que o método finaliza seja chamado. Veja como está o botão de finalizar compra atualmente:

<td colspan="3">
    <input type="submit" class="checkout" name="checkout" value="Finalizar compra" />
</td>
O botão é um input. Por questões de prática, vamos envolver este input com a tag form. Vamos definir o action deste formulário com a ajuda das tags do Spring (s:mvcUrl) e ajustar o atributo method para que seja post. Desta forma teremos:

<form action="${s:mvcUrl('PC#finalizar').build()}" method="post">
    <input type="submit" class="checkout" name="checkout" value="Finalizar compra" />
</form>
Já que estamos usando post como médoto no formulário, vamos fazer com que o método finalizar receba apenas requisições post, pois não faz muito sentido recebermos uma requisição do tipo get neste contexto. Ajuste a assinatuda do médoto finalizar para que esta fique da seguinte forma:

@RequestMapping(value="/finalizar", method=RequestMethod.POST)
public ModelAndView finalizar(RedirectAttributes model){
    System.out.println(carrinho.getTotal());

    model.addFlashAttribute("sucesso", "Pagamento Realizado com Sucesso");

    return new ModelAndView("redirect:/produtos");
}
Assim já poderemos fazer os testes necessários para saber se tudo que fizemos até o momento funciona. Inicie então o servidor e tente efetuar uma compra. Adicione alguns produtos ao carrinho e clique em Finalizar Compra.

Ao iniciar nossa aplicação, teremos uma mensagem de erro:

Error creating bean with name 'carrinhoCompras': Scope 'session' is not active for the current thread;
O Spring não conseguiu atribuir o carrinho de compras da sessão ao PagamentoController. Já vimos este problema antes na classe CarrinhoComprasController e resolvemos usando a anotação que muda o escopo do controller. Desta vez, resolveremos este problema de uma outra forma.

Na classe CarrinhoCompras, usamos a anotação:

@Scope(value=WebApplicationContext.SCOPE_SESSION)
Passaremos para esta mesma anotação uma segunda informação definindo que o Spring criará um proxy envolvendo o objeto alvo (TARGET_CLASS) afim de possibilitar que as informações possam ser transitadas de um escopo para o outro. A anotação com a modificação proposta fica da seguinte forma:

@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS).
Assim conseguiremos fazer com que o carrinho de compras seja acessivel dentro dos controllers sem ter que mudar o escopo dos controllers para isso. Reinicie então o servidor e experimente fazer algumas compras.

Compra efetuada com sucesso

Nosso próximo passo será fazer com que o link de remoção de produtos do carrinho funcione. Começaremos adicionando o action correto para esta finalidade na página itens.jsp. Nesta página procure pelo link de remoção que deve estar da seguinte forma:

<td class="remove-item">
    <form action="" method="post">
        <input type="image" src="/excluir.png" alt="Excluir" title="Excluir" />
    </form>
</td>
Usaremos novamente as tags do Spring para esta tarefa. No mvcUrl criaremos uma url que aponte para o CarrinhoComprasController e chame o método remover. Este método precisará do id e o tipo de preço do produto, então o passaremos através do arg da seguinte forma:

<td class="remove-item">
    <form action="${s:mvcUrl('CCC#remover').arg(0, item.produto.id).arg(1,item.tipoPreco).build() }" method="post">
        <input type="image" src="/excluir.png" alt="Excluir" title="Excluir" />
    </form>
</td>
Na classe CarrinhoComprasController precisamos adicionar o método remover que fará simplesmente uma chamada ao método remover da classe CarrinhoCompras passando o id do produto recebido e o tipo de preço do produto. Após isso, o método remover da classe CarrinhoComprasController criaremos um objeto do tipo ModelAndView para redirecionar o usuário para seu carrinho de compras. Em código teremos:

@RequestMapping("/remover")
public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco){
    carrinho.remover(produtoId, tipoPreco);
    return new ModelAndView("redirect:/carrinho");
}
Observação: Note que estamos fazendo o mapeamento do método com a anotação @RequestMapping com o valor /produtos.

Para finalizar esta funcionalidade, precisamos fazer com que a classe CarrinhoCompras remova o produto da lista de itens. Lembre-se que os itens desta lista são objetos da classe CarrinhoItem. Sendo assim, precisamos criar um objeto CarrinhoItem que precisa de um objeto Produto e em TipoPreco.

O objeto TipoPreco já esta sendo passado por parâmetro, mas o produto não. Estamos recebendo apenas o id do produto. Como fazer então? Poderíamos buscar este produto no banco de dados, mas na verdade, neste ponto, não precisamos disso. Neste caso em especifico, podemos criar um novo objeto produto e usar o método setId para definir o id do produto com o id recebido por parâmetro. Desta forma criamos um carrinhoItem e usamos o método remove do objeto itens na classe CarrinhoCompras passando este carrinhoItem criado. Vejamos como fica em código:

public void remover(Integer produtoId, TipoPreco tipoPreco) {
    Produto produto = new Produto();
    produto.setId(produtoId);
    itens.remove(new CarrinhoItem(produto, tipoPreco));
}
Observação: Lembre-se de que este método remove é para ser escrito na classe CarrinhoCompras.

Faça alguns testes para verificar que tudo está funcionando. Reinicie o servidor, vá até lista de produtos, adicione alguns no carrinho de compras, remova alguns e finaliza a compra. Tudo deve estar funcionando sem problemas.

Realizando pagamento
Ao encerrar uma compra, é muito comum que as aplicações usem uma outra aplicação terceirizada para o processamento do pagamento. Aplicações como Paypal e PagSeguro são exemplos de sistemas que geralmente se usam para processar o pagamento da compra. Em nosso caso, usaremos uma pequena aplicação hospedada em http://book-payment.herokuapp.com/payment.

A aplicação de pagamento apresentada anteriormente serve para podermos verificar se os dados estão sendo enviados corretamente, ela não processa realmente o pagamento, mas simula a situação. Ela espera receber uma requisição do tipo POST enviando um JSON com o seguinte formato: {"value": 500} onde no lugar do valor 500 enviaremos o valor da compra.

Observação: Esta aplicação limita o valor do pagamento a 500. Valores acima deste retornam uma mensagem de que o valor não é permitido.

Para alguns testes pontuais, usaremos uma outra ferramenta para verificar algumas coisas, como por exemplo o tempo e a resposta em que a requisição ocorre e é respondida. No Google Chrome, você pode instalar uma extensão chamada DHC.

Extensão DHC no Google Chrome

E no Mozilla Firefox você pode usar o HttpRequester:

HttpRequester no Firefox

Observação: Note que as imagens mostram uma captura de tela das extensões com alguns testes realizados. Faça alguns também para ter certeza que está tudo funcionando corretamente.

O problema agora é conseguir fazer com que a nossa aplicação consiga enviar uma requisição para outra aplicação. Não podemos redirecionar o navegador neste caso. O que precisamos fazer é chamado de integração, os sistemas se comunicam entre si de forma independente do navegador.

Para a solução deste tipo de problema, o Spring nos disponibiliza uma classe com a qual podemos fazer as requisições que precisamos. Esta classe é a RestTemplate. Ela tem um método chamado postForObject que requer três parâmetros. O primeiro deles é a url na qual queremos enviar a requisição, o segundo é o objeto que representa a mensagem (o corpo) da requisição e por último uma classe na qual esperamos receber uma resposta do tipo.

Vamos então fazer uso do RestTemplate em nossa classe PagamentoController. Crie um atributo deste tipo e o assine com a anotação @Autowired.

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
No método finaliza faremos o seguinte procedimento: Criar uma String que guardará a url para onde a requisição será enviada. Chamar o método postForObject do objeto restTemplate usando a String criada, um objeto da classe DadosPagamento (que ainda não temos mas vamos criar daqui a pouco) usando o valor total do carrinho e por último, dizer que esperamos uma resposta do tipo String, passando String.class como último parâmetro.

String url = "http://book-payment.herokuapp.com/payment";
restTemplate.postForObject(url, new DadosPagamento(carrinho.getTotal()), String.class);
Já que se é esperada uma resposta da requisição enviada, vamos atribuir o resultado deste método a um objeto String que chamaremos de response e usa-lo para exibir a mensagem recebida tanto no console, quanto na view. Veja o método finaliza como fica ao final:

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
Lembre-se de criar esta classe dentro do pacote de modelos. Observe que o nome do atributo é o mesmo que o sistema de pagamentos espera receber. Isto é necessário pois o Spring irá transformar o objeto desta classe em um objeto JSON. Por padrão ele irá criar a chave com o nome do atributo da classe e o valor será o mesmo do definido no atributo.

Para podermos testar, nos falta apenas criar uma configuração básica para que o Spring consiga criar o objeto RestTemplate corretamente. Para isso criaremos um novo método na classe WebAppConfiguration anotado com @Bean e que apenas retorna um objeto do tipo RestTamplate.

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutoDAO.class, FileSaver.class, CarrinhoCompras.class})
public class AppWebConfiguration {
    [...]

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
Agora podemos testar nossa aplicação. Inicie o servidor e efetue o processo de compra, vá até a listagem de produtos, adicione alguns ao carrinho e clique em Finalizar Compra. E veja o que acontece:

HTTP Status 500 - Request processing failed

Obtemos um erro 500 ao finalizar a compra. Por que? Veja o que diz a mensagem de erro:

Could not write request: no suitable HttpMessageConverter found for request type [br.com.casadocodigo.loja.models.DadosPagamento]
O Spring não conseguiu transformar o objeto da classe DadosPagamento em JSON. Veja que ele pede por um HttpMessageConverter. Perceba que mesmo o Spring se encarregando de fazer a conversão do objeto de DadosPagamento para JSON não dissemos em lugar nenhum como ele deve fazer isto. Existe uma biblioteca que já faz essa tarefa, esta biblioteca se chama jackson. Vamos utilizá-la.

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

Recebemos um erro do tipo Bad Request. Lembre-se que o sistema de pagamentos que estamos simulando retorna um erro de número 400 do HTTP quando o valor excede o valor de 500. Para que essa mensagem de erro seja mostrada para o usuário, vamos fazer uso de um bloco try/catch e caso aconteça o erro, mostraremos uma mensagem amigável. Veja como ficará o método finaliza da classe PagamentoController:

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
Com esta adição em nosso código, paramos de exibir a mensagem de erro do próprio Spring e passamos a exibir uma mensagem mais amigável ao usuário.Lembre-se de exibir a mensagem de falha através de ${falha} no arquivo lista.jsp. Onde se encontra a listagem dos produtos.

Fazendo requisições assíncronas.
O comportamento padrão da nossa aplicação atualmente tem um problema bem comum em diversas aplicações do gênero. Perceba que ao finalizar uma compra a aplicação envia os dados de pagamento para um outro sistema e fica aguardando uma resposta. Enquanto aguarda uma reposta a aplicação simplesmente para. Isto porque ela executa em uma única thread.

Atualmente como estamos fazendo poucas operações ao finalizar uma compra, isso pode não aparentar um problema, mas em um sistema real será, pois ao finalizar uma compra, geralmente a operação envolve envio de emails, confirmação de pagamento por terceiros e registro da compra. Juntando essa quantidade de atividades a um possível grande número de usuários acessando o sistema, teremos problemas com um sistema lento que pode trazer diversos outros problemas como queda nas vendas por exemplo.

Pensando nisso, podemos fazer uma pequena otimização na funcionalidade de finalização da compra. Faremos com que ao o usuário finalizar uma compra a requisição seja feita de forma assíncrona e que somente este usuário aguarde a resposta do processamento. Desta forma os demais usuários continuam usando a aplicação sem nenhum problema.

Para implementarmos essa modificação, precisamos apenas modificar a assinatura do método finalizar na classe PagamentoController para que retorne um objeto Callable do tipo ModelAndView. Veja como fazemos isso:

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
Observação: Observe que estamos usando novamente recursos do Java 8. Esta forma de usar lambda nos permite criar um objeto do mesmo tipo esperado pelo retorno do método, evitando que criemos uma classe anônima. Neste caso é perfeitamente aplicável o recurso, por que na interface Callable só há um método, de nome call.

Conheça mais sobre Java 8 fazendo o curso disponível aqui no Alura. Clique aqui para ver o curso

A otimização feita não poderá ser analisada em ambiente local como estamos desenvolvendo, mas sim acompanhando o dia a dia da aplicação, com muitos usuários e requisições transitando pela aplicação. Mas é possivel fazer alguns testes através do JMetter, uma ferramenta para testes de performace. Leia mais sobre o JMetter na documentação do mesmo em: http://jmeter.apache.org/.