# 🏫 Sistema de Gerenciamento Escolar

![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-green)

Este projeto é um sistema básico para o gerenciamento de uma escola, focado na relação entre alunos, disciplinas e a própria instituição. Foi desenvolvido como a **Prova do Grau A** na cadeira de **Programação Orientada a Objetos** da Escola Politécnica da **Universidade do Vale do Rio dos Sinos (Unisinos)**.

O objetivo central do projeto é aplicar conceitos de Programação Orientada a Objetos, com ênfase especial no **Encapsulamento** para proteger o acesso aos dados.

---

## ⚙️ Estrutura de Classes

A arquitetura do sistema é baseada em três classes principais que modelam o domínio do problema:

1.  **`Escola`**: A classe central que gerencia uma lista de até 10 disciplinas. Armazena o nome da escola e o CNPJ.
2.  **`Disciplina`**: Representa uma disciplina oferecida, contendo o nome, o professor responsável e uma lista de até 50 estudantes matriculados.
3.  **`Estudante`**: Modela um aluno, armazenando seu nome, data de nascimento e suas notas nas matérias que está matriculado.

---

## 🔑 Conceito Principal: Encapsulamento

Um requisito fundamental do projeto é o uso correto do encapsulamento. O acesso direto às listas (como a lista de estudantes em uma `Disciplina` ou a lista de disciplinas na `Escola`) é proibido.

Toda interação, como adicionar ou remover um aluno de uma disciplina, deve ser feita através de **métodos específicos** (ex: `matricularAluno()`, `transferirAluno()`), garantindo que as regras de negócio (como o limite de alunos) sejam respeitadas.

---

## 📋 Funcionalidades Implementadas

O sistema permite realizar as seguintes operações:

* **Gerenciamento da Escola:** Criar uma escola e adicionar novas disciplinas ao seu catálogo (limite de 10).
* **Matrícula de Alunos:** Matricular um estudante em uma disciplina (limite de 50 alunos).
* **Transferência:** Mover um estudante de uma disciplina para outra.
* **Análise Acadêmica:**
    * Calcular a média individual das notas de cada estudante.
    * Exibir uma lista de estudantes reprovados (média inferior a 6.0) em uma disciplina específica.
