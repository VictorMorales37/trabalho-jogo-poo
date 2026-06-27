## Ordem de Implementação

### Fase 1 — Estrutura Base

* [x] Criar classe `sistema.Tabuleiro`
* [x] Criar classe `entidades.Jogador`
* [x] Criar classe abstrata `entidades.Dinossauro`
* [ ] Criar subclasses:
  * [ ] `Compsognato`
  * [ ] `Troodonte`
  * [ ] `Velociraptor`
  * [ ] `TRex`
* [ ] Criar classe `CaixaSuprimentos`
* [ ] Criar classes de itens/armas

---

### Fase 2 — Geração do sistema.Jogo

* [x] Gerar matriz do tabuleiro
* [x] Posicionar jogador
* [ ] Gerar paredes aleatórias
* [x] Posicionar dinossauros
* [x] Posicionar caixas
* [ ] Garantir que o T-Rex fique no lado oposto ao jogador

---

### Fase 3 — sistema.Menu Inicial

* [x] Tela de boas-vindas
* [x] Escolha de dificuldade
* [x] Definir percepção do jogador
* [x] Iniciar jogo

---

### Fase 4 — Movimentação

* [x] Movimento horizontal
* [x] Movimento vertical
* [x] Impedir movimento em paredes
* [ ] Impedir movimento diagonal

---

### Fase 5 — Combate

* [x] Ataque com mãos
* [x] Ataque com bastão elétrico
* [x] Ataque com dardos
* [x] Sistema de dano
* [ ] Sistema de esquiva
* [x] Sistema de fuga
* [ ] Regras especiais (Velociraptor e T-Rex)

---

### Fase 6 — Caixas e Itens

* [ ] Kit médico
* [ ] Bastão elétrico
* [ ] Arma de dardos
* [ ] Munição
* [ ] Compsognato surpresa

---

### Fase 7 — Movimento dos Dinossauros

* [ ] Movimento aleatório dos inimigos
* [ ] Velociraptor move 2 casas
* [ ] T-Rex imóvel
* [ ] Combate quando encontram o jogador

---

### Fase 8 — Visão do entidades.Jogador

* [ ] Implementar linha de visão
* [ ] Mostrar apenas o que o jogador pode enxergar
* [ ] Implementar modo DEBUG

---

### Fase 9 — Menus do sistema.Jogo

* [ ] Cura
* [ ] DEBUG
* [ ] Sair
* [ ] Reiniciar jogo
* [ ] Novo jogo

---

### Fase 10 — Finalização

* [ ] Verificar condição de vitória
* [x] Verificar condição de derrota
* [ ] Testar todos os casos

---

### Fase 11 — Requisitos de POO

* [ ] Encapsulamento
* [ ] Herança
* [ ] Polimorfismo
* [ ] Composição
* [ ] Interface (`interface`)

---

### Fase 12 — Relatório

* [ ] Diagrama de classes
* [ ] Explicar conceitos de POO utilizados
* [ ] Instruções para executar
* [ ] Prints do jogo
* [ ] Conclusão