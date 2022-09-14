# Desafio Spring MVC Start Java #4
## Gerenciador de Receitas
##### Open JDK version 17.0.3

### Pedidos da Entrega Básica:
1. Popular banco de dados :heavy_check_mark:
2. CRUD de unidade de medidas :heavy_check_mark:
3. CRUD de ingredientes :heavy_check_mark:
4. CRUD de Receitas :heavy_check_mark:
5. Modos de acesso Admin e Usuário :heavy_check_mark:
6. Cadastrar na inicialização Admin e Usuário padrão (com suas respectivas senhas) :heavy_check_mark:
7. Cadastro de novos usuários :x:
8. Para Receitas (Listar, cadastro, atualização, excluir, busca por nome e ingrediente) :heavy_check_mark:
9. Para Ingredientes (Listar, cadastro, atualização, excluir e busca por nome) :heavy_check_mark:
10. Para Unidade de Medida (Listar, cadastro, atualização, excluir e busca por nome) :heavy_check_mark:
### Exceeds:
1. Utilização de vídeo nas receitas cadastradas pelo botão Popular :heavy_check_mark:
2. Capacidade de cadastrar receita inserindo vídeo do YouTube via link :heavy_check_mark:
3. Página personalizada para erro 403 (Acesso proibido) :heavy_check_mark:
4. Página personalizada para erro 404 (Ao digitar uma url inexistente) :heavy_check_mark:

# Tutorial da aplicação:
#### Página de Login
![Página de Login](https://i.imgur.com/ZboYNQ7.png)
 Acima podemos ver a página de Login, onde deveremos entrar com um dos dois usuários padrão cadastrados na inicialização (admin@gft.com) ou (usuario@gft.com).
#### Popular Banco de Dados
![Popular Banco de Dados](https://i.imgur.com/9LDkmwa.png)
 Logo após o Login, o usuário ou admin deve clicar no botão **Popular Banco de Dados**.
#### Página Home
![Home](https://i.imgur.com/rKxI9Nx.png)
 Na página **Home** podemos encontrar:
 1. O Home da Navbar que estará presente em todos os momentos da aplicação, caso o usuário deseje voltar para a página principal.
 2. O botão **Logout**, onde o usuário poderá fazer Logout da aplicação e se autenticar com outro um nível de permissão(Admin ou Usuario).
 3. Ícones para **listar** seus respectivos conteúdos.
#### Dropdown
![Dropdown](https://i.imgur.com/S1X4gbd.png)
 No **Dropdown** que pode ser visto no ítem 4 da imagem acima, em cada um dos atributos temos as opções de **listar** ou **cadastrar** seus respectivos ítens.
#### Listagem
![Listagem](https://i.imgur.com/UTmgzFs.png)
 Na **Listagem** de Receitas, por exemplo, temos as opções de **Filtrar por nome**, **Filtrar por ingrediente**, **Visualizar**, **Editar** e **Excluir**. No caso dos dois últimos temos acesso apenas se tivermos feito Login como **Admin**. Caso contrário seremos levados para uma **página de erro 403 personalizada** (aconselho conferir :smile:).
#### Visualizar
![Visualizar](https://i.imgur.com/nCZzeDe.png)
 Na **Visualização** de Receitas, temos **Um vídeo** e **todas as demais informações**.
## Dicas e explicação de código:
#### 1. Sugiro conferir a página personalizada para erro 404 (digitar uma url inexistente).
#### 2. Explicação do tratamento do link do YouTube:
 Trecho de código da Entidade Receita:

 ~~~
     public void setUrl(String url) {

        if (url.contains("v=")) {
            url = url.split("v=")[1];
            url = "https://www.youtube.com/embed/"+url;
        }else {
            url = url.split("embed/")[1];
            url = "https://www.youtube.com/embed/"+url;
        }

        this.url = url;
    }
~~~
 O link do Youtube geralmente obedece o padrão https://www.youtube.com/watch?v=b3LjioFMBnc, onde encontramos (**watch?v=**), porém o padrão que deve ser inserido para que tudo funcione é o (**embed/**). Portanto esse trecho trata essa situação tanto no cadastro de uma nova receita quanto na edição da mesma.
 #### 3. Favor alterar username e password do datasource no aplication.properties caso seja necessário.
 #### 4. Uma das receitas cadastradas tem uma referência a um desenho no qual a abertura era uma receita :smile: .


# mvc
