# 🍽️ FoodDelivery - Sistema de Pedidos (CLI em Java)

Bem-vindo ao **FoodDelivery**, uma plataforma desenvolvida para gerenciar restaurantes, bares, projetos gastronômicos e, agora, também mercados e farmácias.  
O objetivo é oferecer **agilidade, organização e praticidade** na palma da mão, permitindo que empreendedores e consumidores vivam uma experiência premium.  

Este projeto é um **protótipo de sistema de pedidos** executado via **linha de comando (CLI)**, implementado em **Java** utilizando os pilares da **Programação Orientada a Objetos (POO)**.  

---

## 🚀 Funcionalidades

### 📋 Gerenciamento de Cardápio
- **Cadastrar Item**: Adicione novos pratos, bebidas ou sobremesas, com nome e preço.  
- **Listar Itens**: Consulte o cardápio completo, com códigos e valores atualizados.  

### 👥 Gerenciamento de Clientes
- **Cadastrar Cliente**: Registre novos clientes com nome e telefone.  
- **Listar Clientes**: Exiba todos os clientes cadastrados com seus respectivos códigos.  

### 🛒 Gerenciamento de Pedidos
- **Registrar Pedido**:  
  - Escolha o cliente.  
  - Adicione itens do cardápio e suas quantidades.  
  - Confirme o pedido, que será criado com status inicial **ACEITO**.  
- **Atualizar Status**: Acompanhe o ciclo de vida de um pedido:  
  `ACEITO → PREPARANDO → FEITO → AGUARDANDO ENTREGADOR → SAIU PARA ENTREGA → ENTREGUE`.  
- **Consultar Pedidos por Status**: Filtre os pedidos que estão em determinada etapa.  

### 📊 Relatórios
- **Relatório Simplificado**: Mostra o total de pedidos e o valor arrecadado no dia.  
- **Relatório Detalhado**: Lista completa dos pedidos, incluindo cliente, itens e valor final de cada um.  

---

## 🏗️ Arquitetura e Organização

O sistema foi desenvolvido seguindo conceitos fundamentais de **POO**:  
- **Classes e Objetos**: representando Clientes, Pedidos, Itens e Relatórios.  
- **Relacionamentos (Associação, Agregação e Composição)**:  
  - Um Pedido está associado a um Cliente.  
  - O Cardápio agrega vários Itens.  
  - Um Pedido é composto por Itens de Pedido (com quantidades).  
- **Central de Dados (Singleton)**: único ponto de acesso para clientes, pedidos e cardápio.  
- **Relatórios Flexíveis**: possibilidade de gerar diferentes tipos de relatórios sem acoplar regras de negócio.  

---

## 🖥️ Interface (CLI)

O sistema é executado no terminal e apresenta um **menu interativo**, permitindo que atendentes realizem as operações de forma simples e organizada, sem precisar conhecer os detalhes internos do código.

---

## 🧩 Tecnologias Utilizadas
- **Java 17+**
- **Git/GitHub** para versionamento de código

---

## 🌍 Sobre a FoodDelivery

A **FoodDelivery** é uma empresa de tecnologia sediada em Salvador - BA, desde 2025.  
Nosso propósito é **conectar restaurantes, bares, mercados e farmácias aos consumidores em qualquer lugar, com apenas um clique**.  

Estamos em constante evolução, trazendo novas funcionalidades, automações e inovação para transformar a experiência de empreendedores e clientes.  

---

## 📌 Próximos Passos

🔜 Este protótipo é apenas o início. Futuramente, planejamos:  
- Integração com banco de dados (MySQL).  
- Criação de APIs com **Spring Boot**.  
- Implementação de **Backend for Frontend (BFF)** para múltiplos clientes.  
- Sistema de notificações em tempo real.  

---

## ▶️ Como executar o projeto

Este projeto utiliza o **Gradle Wrapper** para facilitar a execução, sem exigir que você tenha o Gradle instalado no seu sistema. O wrapper garante que todos usem a mesma versão do Gradle e simplifica o processo de build e execução.

### Por que usar o Gradle?

Optamos por usar o Gradle (e seu wrapper) para evitar problemas comuns de configuração de ambiente Java, como:
- Ter que configurar manualmente a pasta e a versão do JDK instalado no sistema de cada desenvolvedor.
- Garantir que todos usem a mesma versão de build, independente do sistema operacional.
- Facilitar a execução do projeto em qualquer máquina, sem necessidade de instalar ferramentas extras além do Java.

Com o Gradle Wrapper, basta ter o Java instalado (JDK 17+ recomendado) e rodar os comandos abaixo, sem se preocupar com variáveis de ambiente ou configurações específicas do sistema.

### O que é o Gradle Wrapper?

O Gradle Wrapper é um conjunto de arquivos (`gradlew`, `gradlew.bat` e a pasta `gradle/wrapper`) que permite rodar comandos Gradle mesmo que você não tenha o Gradle instalado globalmente.
- **Windows:** usa o arquivo `gradlew.bat`
- **Linux/Mac:** usa o arquivo `gradlew`

### Passos para rodar o projeto

1. **Abra um terminal na pasta do projeto**  
   Exemplo:
   ```
   cd E:\Usuarios\Bruno\Documents\VSCode\Java\tia-lu-dev-web-oo-dublin
   ```

2. **Execute o comando apropriado para seu sistema operacional:**

   - **No Windows (PowerShell ou CMD):**
     ```
     .\gradlew run
     ```
   - **No Linux/Mac:**
     ```
     ./gradlew run
     ```

   > **Importante:**  
   > Sempre use o prefixo `./` ou `.\` para executar scripts do diretório atual.

3. **Interaja com o sistema**  
   O menu será exibido no terminal e você poderá digitar as opções conforme solicitado.

### Dicas

- Dependendo das configurações da sua IDE, a execução interativa pode não funcionar corretamente ao usar o botão "Run". Por isso, prefira rodar o projeto pelo terminal para garantir que a entrada de dados funcione como esperado.
- Se for a primeira execução, o wrapper pode baixar a versão correta do Gradle automaticamente.

### Problemas comuns

- **Comando não encontrado:**  
  Certifique-se de estar usando `.\gradlew` no Windows ou `./gradlew` no Linux/Mac.
- **Entrada não reconhecida:**  
  Sempre execute pelo terminal, não pela interface gráfica da IDE.

---

## 🤝 Contribuição

Este projeto é desenvolvido em equipe, prezando pela **colaboração, clareza e organização**.  
Feedbacks e sugestões são sempre bem-vindos!