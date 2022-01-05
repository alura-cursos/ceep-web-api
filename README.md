![Thumbnail](https://user-images.githubusercontent.com/8989346/148251088-b6b4797e-a228-4d92-b049-a94d9d163dfd.png)

# Ceep web API

Projeto em Spring Boot com Kotlin que oferece uma Web API de um CRUD para notas com título, descrição e imagem.

## 🔨 Funcionalidades do projeto

A aplicação salva, altera, lista e remove notas. Todos os comportamentos são realizados por meio de endpoints do recurso `"baseUrl/notas"`. (por padrão, ao rodar a aplicação, a baseUrl é http://localhost:8080/)

### Endpoints

- `GET`: devolve a lista de todos as notass -> "baseUrl/notas"
```
//exemplo de resposta
[
    {
        "id": "cf556b0f-dfb0-4366-92cf-e7c20a8faed0",
        "titulo": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        "descricao": "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
        "imagem": "https://images.pexels.com/photos/230554/pexels-photo-230554.jpeg"
    },
    {
        "id": "a1090f62-cb58-4396-b8d2-fd5f15d52bff",
        "titulo": "test 1",
        "descricao": "test 2",
        "imagem": "https://images.pexels.com/photos/3862132/pexels-photo-3862132.jpeg"
    }
]
```

- `POST`: recebe uma nota via corpo da requisição e salva. A nota salva recebe um id novo no padrão [UUID random](https://en.wikipedia.org/wiki/Universally_unique_identifier#:~:text=security%20credentials.%5B1%5D-,Version%204,-(random)%5Bedit%5D) -> "baseUrl/notas"
```
//exemplo de requisição
//header: Content-Type: application/json

//body
{
    "titulo" : "test 1",
    "descricao" : "test 2",
    "imagem" : "https://images.pexels.com/photos/3862132/pexels-photo-3862132.jpeg"
}
```

```
//exemplo de resposta
{
    "id": "a1090f62-cb58-4396-b8d2-fd5f15d52bff",
    "titulo": "test 1",
    "descricao": "test 2",
    "imagem": "https://images.pexels.com/photos/3862132/pexels-photo-3862132.jpeg"
}
```

- `PUT`: Cria ou altera uma nota a partir de um id, se existir uma nota com o id enviado, a nota é alterada, caso contrário, a nota é criada. As informações da nota devem ser enviadas via body assim como é feita na requisição `POST`. -> "baseUrl/notas/{id}"

```
//exemplo de requisição de criação
//header: Content-Type: application/json
//localhost:8080/notas/7f811a41-623a-4451-a4e8-5fc81eb2f114

//body
{
    "titulo" : "nota nova",
    "descricao" : "criando nota"
}

//resposta da requisição
{
    "id": "7f811a41-623a-4451-a4e8-5fc81eb2f114",
    "titulo": "nota nova",
    "descricao": "criando nota",
    "imagem": null
}

//exemplo de requisição de alteração
//header: Content-Type: application/json
//localhost:8080/notas/7f811a41-623a-4451-a4e8-5fc81eb2f114

//body
{
    "titulo" : "nota existente",
    "descricao" : "alterando nota existente",
    "imagem" : "https://images.pexels.com/photos/3721597/pexels-photo-3721597.jpeg"
}

//resposta da requisição
{
    "id": "7f811a41-623a-4451-a4e8-5fc81eb2f114",
    "titulo": "nota existente",
    "descricao": "alterando nota existente",
    "imagem": "https://images.pexels.com/photos/3721597/pexels-photo-3721597.jpeg"
}
```

- `DELETE`: Remove a nota a partir do id. -> "baseUrl/notas/{id}"
    - Retorna status code 200 se a remoção deu certo e 404 caso a nota não exista.

```
//exemplo de requisição "localhost:8080/notas/20ecb3a7-d499-4496-b246-879584c17881"
```

## ✔️ Técnicas e tecnologias utilizadas

A aplicação foi desenvolvida com o Spring Boot utilizando Kotlin e foram utilizadas as seguintes técnicas:

- `Controllers`: mapear os endpoints 
- `Services`: realizar as ações esperadas pelo controller
- `Repositories`: oferecer e realizar os comportamentos de persistência de banco de dados
- `Aspect`: apresentar logs de execução dos services e controllers indicando as classes e métodos chamados
- `DTO`: padrão para indicar quais informações devem ser enviada/recebidas via requisição
- `JPA` com `Hibernate`: solução para se comunicar com o banco de dados
- `H2 database`: banco de dados que pode ser persistido em um arquivo local sem a necessidade de um serviço de SGBD

Bibliotecas do Spring Framework que foram utilizadas:

- `devtools`: ferramenta para agilizar o processo de desenvolvimento sem reiniciar a aplicação para atualizar
- `starter-web`: suporte para aplicação web em geral
- `starter-data-jpa`: suporte para abstrair a implementação de repositórios e reutilizar comportamentos de CRUD com base na configuração da JPA

## 📁 Acesso ao projeto

Você pode acessar o projeto de diferentes maneiras:
- [baixar o zip do projeto](https://github.com/alura-cursos/ceep-web-api/archive/refs/heads/dev.zip)
- [acessar o código fonte](https://github.com/alura-cursos/ceep-web-api/tree/dev)
- [baixar o arquivo jar executável](https://github.com/alura-cursos/ceep-web-api/releases/download/0.0.1/server.jar)

## 🛠️ Abrir e rodar o projeto

O projeto pode ser acesso de duas maneiras diferente:

- Via código fonte
- Rodando o arquivo JAR executável

### Código fonte

Para código fonte, você precisa de uma IDE compatível com o Gradle e com o Spring Boot utilizando Kotlin. Para esse projeto foi utilizado o IntelliJ IDEA 2021.2.3, você pode usar essa versão da IDE para garantir a compatibilidade ou uma versão mais recente ou outra ferramenta de sua preferência. 

Caso opte pelo IntelliJ, na tela de launcher, acesse a opção **Open** e procure o projeto, selecione-o e clique em **OK**. (Caso baixar o arquivo zip, lembre-se de descompactá-lo antes de procurar)

Após o IntelliJ finalizar todas as tasks, acesse o arquivo `src\main\kotlin\br\com\alura\aluraponto\AluraPontoApplication.kt` e rode a função `main()`.

### JAR executável

Com o executável, você precisa ter acesso a um cliente do Java 11. Acesse o arquivo JAR via terminal, e então, execute o seguinte comando: `java -jar nomeDoArquivo.jar` (provavelmente o arquivo foi nomeado como `server.jar`). 

Após executar em alguma das possibilidades, deve apresentar a seguinte mensagem via console:

```
o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
b.c.a.a.AluraPontoApplicationKt          : Started AluraPontoApplicationKt in 6.279 seconds (JVM running for 6.949)
```

A partir desse momento, é só acessar a baseUrl (por padrão "http://localhost:8080") via navegador que apresentará a página inicial da aplicação!

> **Observações**: evite rodar o JAR em algum local que exija mais privilégios para executar ou criar arquivos.

## 🧪 Testando a API com o Postman

Você pode testar a aplicação utilizando o Postman também, você pode [baixar o zip com a collection com todos os exemplos](https://github.com/alura-cursos/ceep-web-api/archive/refs/heads/postman.zip). 

> Para fazer o teste, você precisa acessar o Postman, de preferência o cliente desktop, e fazer o [processo de importação](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/#importing-data-into-postman).

## 📝 Modificando porta de execução da aplicação

Por padrão o Spring Boot vai rodar a aplicação na porta `8080`, mas é possível modificar a porta caso seja necessário:

### Código fonte

No arquivo `application-dev.yml`, modifique o valor da `port: ${port:8080}` para um valor esperado:

```
server:
  port: ${port:8081}
```

> Vamos considerar a modificação para a porta nas amostras `8081`.

### Task `bootRun` do Gradle

Também é possível executar o projeto via task `bootRun` do Gradle. Além de rodar o projeto, é possível modificar a porta de execução:

```
./gradlew bootRun --args='--server.port=8081
```

### JAR executável

Há também a possibilidade de modificar a porta via command line pelo arquivo jar:

```
java -jar nomeDoArquivo.jar --server.port=8081
```

