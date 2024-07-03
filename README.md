
# Teste Prático para Vaga de Desenvolvedor Java Junior na Projedata

Este repositório contém minha realização do teste prático para a vaga de Desenvolvedor Java Junior na Projedata. O objetivo do projeto é manipular e processar dados de funcionários utilizando Java, seguindo as especificações fornecidas no teste.

## Descrição do Projeto

O projeto consiste em uma aplicação Java que realiza diversas operações com uma lista de funcionários, tais como:

1. Inserir funcionários conforme uma tabela.
2. Remover um funcionário específico.
3. Imprimir todos os funcionários com todas suas informações.
4. Aplicar um aumento de 10% no salário de todos os funcionários.
5. Agrupar os funcionários por função em um Map.
6. Imprimir os funcionários que fazem aniversário nos meses de outubro e dezembro.
7. Imprimir o funcionário com maior idade.
8. Imprimir a lista de funcionários por ordem alfabética.
9. Imprimir o total dos salários dos funcionários.
10. Imprimir quantos salários mínimos cada funcionário ganha, considerando que o salário mínimo é R$1212.00.

## Estrutura do Projeto

### Pacotes

- `Classes`: Contém as classes `Pessoa` e `Funcionario`, que representam os dados dos funcionários.
- `Service`: Contém a classe `FuncionarioService`, que implementa os métodos de manipulação e processamento dos dados dos funcionários.

### Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Jackson**: Biblioteca para manipulação de JSON.
- **Lombok**: Biblioteca para reduzir o boilerplate code, como getters, setters, construtores, etc.

### Dependências

- `com.fasterxml.jackson.core:jackson-databind:2.12.3`
- `com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.12.3`
- `org.projectlombok:lombok:1.18.20`

## Funcionalidades

### Inserir Funcionários

Utiliza um arquivo JSON (`src/main/resources/funcionarios.json`) para carregar os dados dos funcionários.

### Remover Funcionário

Remove o funcionário com o nome "João".

### Imprimir Funcionários

Imprime todos os funcionários com as informações formatadas corretamente:
- Data de nascimento no formato `dd/MM/yyyy`.
- Salário formatado com separador de milhar como ponto e decimal como vírgula.

### Aplicar Aumento de Salário

Aplica um aumento de 10% no salário de todos os funcionários.

### Agrupar Funcionários por Função

Agrupa os funcionários por função em um Map, onde a chave é a função e o valor é a lista de funcionários.

### Imprimir Aniversariantes

Imprime os funcionários que fazem aniversário nos meses de outubro e dezembro.

### Imprimir Funcionário Mais Velho

Imprime o funcionário com maior idade, mostrando apenas o nome e a idade.

### Imprimir Funcionários em Ordem Alfabética

Imprime a lista de funcionários em ordem alfabética pelo nome.

### Imprimir Total dos Salários

Calcula e imprime o total dos salários de todos os funcionários.

### Imprimir Salários Mínimos

Calcula e imprime quantos salários mínimos cada funcionário ganha, considerando o salário mínimo de R$1212.00.

## Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Navegue até o diretório do projeto:
   ```sh
   cd seu-repositorio
   ```

3. Compile o projeto:
   ```sh
   mvn clean install
   ```

4. Execute a classe `Main`:
   ```sh
   java -cp target/seu-projeto.jar Classes.Main
   ```

Estou ansioso para começar a trabalhar nessa empresa incrível!
