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

Este projeto utiliza o **Gradle Wrapper** para facilitar a geração do JAR executável, sem exigir que você tenha o Gradle instalado no seu sistema. O wrapper garante que todos usem a mesma versão do Gradle e simplifica o processo de build.

### Passos para rodar o sistema

1. **Abra um terminal na pasta do projeto**  
   Exemplo:
   ```
   cd E:\Usuarios\Bruno\Documents\VSCode\Java\tia-lu-dev-web-oo-dublin
   ```


2. **Gere o JAR executável usando o Gradle Wrapper:**

   - **No Windows (PowerShell ou CMD):**
     ```
     .\gradlew jar
     ```
   - **No Linux:**
     ```
     ./gradlew jar
     ```
   - **No Mac (OS X):**
     ```
     ./gradlew jar
     ```

   O arquivo JAR será gerado em `build/libs/`.

3. **Execute o sistema usando o Java:**

   - **No Windows:**
     ```
     java -jar build\libs\tia-lu-dev-web-oo-dublin-1.0.0.jar
     ```
   - **No Linux:**
     ```
     java -jar build/libs/tia-lu-dev-web-oo-dublin-1.0.0.jar
     ```
   - **No Mac (OS X):**
     ```
     java -jar build/libs/tia-lu-dev-web-oo-dublin-1.0.0.jar
     ```

4. **Interaja normalmente com o menu no terminal!**

### Dicas

- Se for a primeira execução, o wrapper pode baixar a versão correta do Gradle automaticamente.
- O menu e a entrada de dados funcionarão corretamente em qualquer terminal usando o comando `java -jar ...`.

### Problemas comuns

- **Comando não encontrado:**  
  Certifique-se de estar usando `.\gradlew` no Windows ou `./gradlew` no Linux/Mac.
- **Entrada não reconhecida:**  
  Tente executar o JAR pelo terminal, não pela interface gráfica da IDE.

---

## 🤝 Contribuição

Este projeto é desenvolvido em equipe, prezando pela **colaboração, clareza e organização**.  
Feedbacks e sugestões são sempre bem-vindos!