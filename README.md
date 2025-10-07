🥐 Sistema Padaria Mongo

O Sistema Padaria Mongo é um projeto criado para facilitar o gerenciamento de padarias e estabelecimentos similares.
O objetivo principal é oferecer uma solução moderna e simples para controlar produtos, pedidos, clientes e estoque, tornando o dia a dia do negócio mais prático e organizado.

Este sistema foi desenvolvido pensando tanto em donos de padarias que buscam automatizar seus processos, quanto em profissionais de tecnologia interessados em conhecer uma aplicação completa com Spring Boot e MongoDB.
Com ele, é possível visualizar, cadastrar e gerenciar informações de forma rápida, utilizando uma interface moderna e um banco de dados eficiente.




🎯 Objetivo do Projeto

O projeto tem como finalidade demonstrar uma aplicação Java integrada com MongoDB, explorando boas práticas de programação, arquitetura de software e utilização de contêineres Docker.
Além disso, o sistema serve como base de aprendizado para estudantes e desenvolvedores que desejam entender na prática como funciona o desenvolvimento de um sistema web completo com Java + Spring Boot + NoSQL.

🚀 Tecnologias Utilizadas

Java 17+ → Linguagem de programação principal.

Spring Boot → Framework que simplifica a criação de aplicações Java modernas e escaláveis.

MongoDB → Banco de dados NoSQL utilizado para armazenar e consultar os dados da aplicação.

Maven → Ferramenta para gerenciamento de dependências e automação de builds.

Docker → Plataforma de contêineres que facilita o empacotamento e execução da aplicação em diferentes ambientes.



👩‍💻 Autora

 Gleice Kelly Oliveira ,Raquel Fernandes, Jucelaine Teles, Guilherme Soares
 

📦 Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

Java 17 ou superior

Maven

Docker

MongoDB (ou execute via Docker)


⚙️ Como Executar o Projeto

Clone este repositório:

git clone https://github.com/kellyoliveira473/Sistema-Padaria-Mongo.git
cd Sistema-Padaria-Mongo



Compile o projeto:

./mvnw clean install


Inicie o MongoDB com Docker (caso não tenha o Mongo instalado localmente):

docker run --name mongodb -d -p 27017:27017 mongo



Execute a aplicação:

./mvnw spring-boot:run



A aplicação ficará disponível em:
👉 http://localhost:8080

🔧 Endpoints Disponíveis

Os endpoints (rotas da API) estão definidos no código-fonte da aplicação.
Para visualizá-los, consulte as classes dentro do pacote controller no diretório src/main/java.



🧪 Testes

Para executar os testes automatizados:

./mvnw test

<img width="1024" height="1024" alt="Estrutura de Diretórios do Projeto" src="https://github.com/user-attachments/assets/4fcef1dd-8c11-4132-a874-5c6fd04baefa" />



📄 Licença

Este projeto está licenciado sob a Licença MIT — veja o arquivo LICENSE para mais detalhes.


🧠 Termos Técnicos e Conclusão Profissional

O Sistema Padaria Mongo aplica conceitos fundamentais de arquitetura de software moderna, como:

Injeção de Dependência (Dependency Injection)

Camadas de Serviço e Repositório

Persistência de Dados NoSQL

Integração Contínua e Contêinerização com Docker

Trata-se de um projeto que une simplicidade funcional com robustez técnica, sendo ideal tanto para fins acadêmicos quanto empresariais.
Através deste sistema, é possível compreender a aplicação prática de padrões de desenvolvimento Java em conjunto com tecnologias atuais do ecossistema Spring e MongoDB.
