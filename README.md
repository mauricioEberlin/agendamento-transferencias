# Sistema de agendamento de transferências

Um projeto simples possuindo uma integração na qual o Front end (Vue 3) extrai os dados de uma API realizada com o Java Spring Boot.

No Java, escolhi fazer uma arquitetura limpa e simples, composta por seis pacotes: Controller, DAO e JPA, Model, Repository e Exceptions.
No VueJS somente o necessário: Components e Services.

## Subindo o projeto

Antes de tudo, garanta que as portas 8080 e 8081 da sua rede local estejam livres.

1) Utilizando uma IDE, abra o projeto "agendamento-transferencias-backend" e aguarde a instalação de todas as dependências.
2) Após ter baixado todas as dependências, acesse a classe da aplicação (AgendamentoTransferenciasApplication) e execute a aplicação.
3) Utilizando um terminal de comando, acesse a pasta "agendamento-transferencias-frontend" e execute o comando "npm run serve". Note que a aplicação irá hospedar na porta 8081, como designado nas configurações do projeto.
4) Com o navegador, acesse sua rede local "http://localhost:8081/" e a página de transferências irá aparecer.

Ferramentas utilizadas no projeto:
	Java versão 17
	VueJS 3
	Node.js: 18.15.0
	Npm 10.2.4
	Spring Boot 3.2.2

IDE: 
	IntelliJ IDEA 2023.3.3

Edição de texto: 
	Visual Studio Code versão 1.85.2

Dependencias do Spring Boot:
	Spring Web
	Lombok
	H2 Database
	Spring Data JPA 
