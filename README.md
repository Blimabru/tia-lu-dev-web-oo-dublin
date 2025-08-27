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

## 🤝 Contribuição

Este projeto é desenvolvido em equipe, prezando pela **colaboração, clareza e organização**.  
Feedbacks e sugestões são sempre bem-vindos!