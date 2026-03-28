# Laboratório de Manutenção de Software – Sistema Legado de Biblioteca

Este repositório simula um sistema Java legado que evoluiu ao longo do tempo com múltiplas mudanças incrementais, correções rápidas e decisões arquiteturais de curto prazo. O resultado é um código funcional, porém com alta complexidade de manutenção, ideal para práticas reais de manutenção de software.

## Contexto do Sistema

Com base na implementação atual, o sistema oferece:

- cadastro de livros ([BookManager.registerBook](src/BookManager.java#L10))
- cadastro de usuários ([UserManager.registerUser](src/UserManager.java#L5))
- empréstimo de livros ([LoanManager.borrowBook](src/LoanManager.java#L14))
- devolução de livros ([LoanManager.returnBook](src/LoanManager.java#L90))
- geração de relatórios ([ReportGenerator.generateSimpleReport](src/ReportGenerator.java#L9))
- operação via menu de linha de comando ([LibrarySystem.startCli](src/LibrarySystem.java#L23))

O projeto contém intencionalmente problemas de manutenibilidade e bugs sutis para apoiar atividades práticas de manutenção preventiva, corretiva e evolutiva.

## Organização das Atividades

As atividades foram separadas em documentos próprios para deixar objetivos, escopo e formato de entrega mais claros:

1. [ATIVIDADE_1.md](ATIVIDADE_1.md) - Análise de Código e Manutenção Preventiva
2. [ATIVIDADE_2.md](ATIVIDADE_2.md) - Manutenção Corretiva e Evolutiva

## Como Executar o Projeto

Compilar:

```bash
javac src/*.java
```

Executar modo interativo:

```bash
java -cp src Main
```

Executar listagem rápida:

```bash
java -cp src Main --list
```

Executar relatório rápido:

```bash
java -cp src Main --report
```

## Visão Geral de Problemas de Manutenibilidade

Problemas detalhados e guias de exploração foram movidos para os arquivos de atividade.

## Observação Final

O objetivo não é reescrever o sistema inteiro do zero.

Os estudantes devem melhorar o sistema incrementalmente, simulando manutenção de software no mundo real com pequenas mudanças seguras, validação contínua e evolução controlada.

## Lista dos problemas encontrados:

1. Empréstimos fechados
-A classe ReportGenerator não apresentava o número correto de empréstimos de livros, contando mesmo os empréstimos ainda em aberto.
-Erro do tipo: Bug de cálculo.

2. handleRegisterBook()
-O método handleRegisterBook() da classe LibrarySystem apresentava uma parte duplicada, realizando pela segunda vez uma verificaçao já realizada na classe BookManager.
Erro do tipo: Código duplicado.

3. countOpenLoansByBook()
-O método da classe LegacyDatabase deveria filtrar por id do livro, mas filtrava pelo id do usuário.
-Erro do tipo: Nomeação de variável errada e lógica inconsistente.

4. borrowBook()
-O método borrowBook() realizava várias funções além do necessário, em vez de ser dividido em vários métodos como recomenda as boas práticas de manutençao.
Erro do tipo: Método longo.

5. registerUser()
-O Método utiliza muitos parâmetros, tornando-o confuso.
-Erro do tipo: O método aceita uma lista com muitos parâmetros.

6. Classe LibrarySystem 		
-A classe centraliza muitos funções e métodos na mesma classe, como menu, orquestração, entrada de dados, logs.
-Erro do tipo: God Class.

7. registerBook()
-O método registerBook() da classe BookManager aceita registrar um livro com o nome em branco, contrariando a regra de negócio da biblioteca.
-Erro do tipo: Erro de validação.

8. returnBook() 
-O método returnBook() da classe LoanManager apresenta erros quando o empréstimo é nulo, parando de executar, sem exibir erro e imprimir mensagem no controle. 
-Erro do tipo: Tratamento de erros incosistente.

9. startCli()
-O método startCli() da classe LibrarySistem mistura regras de execução, interface do usuário e tratamentos de erros genéricos.
-Erro do tipo: Responsabilidades misturadas.

10. validateUserData()		
-O método validateUserData() da classe UserManager realiza validações já relizadas ao cadastrar o usuário.
-Erro do tipo: Código duplicado.

## Refatorações realizadas:

1. Empréstimos fechados - Corrigido a contagem de empréstimos fechados.

2. handleRegisterBook() - Retirada a parte duplicada do código.

3. countOpenLoansByBook() - Corrigido a lógica do método.

4. borrowBook() - O método foi dividido em métodos menores e mais específicos.

5. registerUser() - Foi criada a classe UserData para passar os parâmetros necessáriso para a execução do método.

