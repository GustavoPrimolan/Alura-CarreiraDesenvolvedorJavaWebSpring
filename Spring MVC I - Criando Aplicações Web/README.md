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

