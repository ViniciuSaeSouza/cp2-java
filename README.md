# 🏰 Projeto Mercado Medieval - API Java

Este projeto é uma API REST desenvolvida em Java para simular um **mercado medieval** onde personagens podem **cadastrar, vender, comprar e trocar itens mágicos**, como espadas encantadas, elixires, grimórios e muito mais.

## 🚀 Funcionalidades

### 🧙 Personagem
CRUD completo de personagens com os seguintes atributos:
- `nome` (obrigatório)
- `classe`: guerreiro, mago ou arqueiro
- `nivel`: mínimo 1, máximo 99
- `moedas`: saldo utilizado para transações de itens

### 🧾 Item
CRUD completo de itens do mercado:
- `nome` (obrigatório)
- `tipo`: arma, armadura, poção ou acessório
- `raridade`: comum, raro, épico ou lendário
- `preco`: valor em moedas
- `dono`: relacionamento com o personagem proprietário

### 🔎 Filtros e Busca
Endpoints com filtros inteligentes:
- Buscar personagem por nome
- Buscar personagem por classe
- Buscar itens por nome parcial
- Buscar itens por tipo
- Buscar itens por faixa de preço (mínimo e máximo)
- Buscar itens por raridade

## 📚 Tecnologias Utilizadas
- Java (Spring Boot)
- API REST
- JPA / Hibernate
- Banco de Dados Relacional
- Maven

## 🛠️ Como Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/projeto-mercado.git
