# ✅ Checklist do Projeto — Sobrevivência Jurássica

## 1. Estrutura Geral

* [ ] Projeto em Java
* [ ] Utilizar Programação Orientada a Objetos
* [ ] Código compila sem erros
* [ ] Relatório produzido
* [ ] Apresentação preparada

---

# 2. Conceitos de POO Obrigatórios

* [ ] Encapsulamento
* [ ] Herança
* [ ] Polimorfismo
* [ ] Composição
* [ ] Classes próprias modeladas pelo grupo
* [ ] Uso de Interface (`interface` do Java)

Exemplos possíveis:

* [ ] Classe abstrata `Dinossauro`
* [ ] Classes `Compsognato`, `Troodonte`, `Velociraptor`, `TRex`
* [ ] Interface `Movimentavel`
* [ ] Classe `Jogador`
* [ ] Classe `Tabuleiro`
* [ ] Classe `CaixaSuprimentos`
* [ ] Classe `Arma`

---

# 3. Menu Inicial

* [ ] Mensagem de boas-vindas
* [ ] Opção Jogar
* [ ] Opção Sair

### Dificuldades

* [ ] Fácil → percepção 3
* [ ] Médio → percepção 2
* [ ] Difícil → percepção 1



---

# 4. Geração do Mapa

* [ ] Matriz quadrada
* [ ] Tamanho definido (20x20, 40x40, etc.)
* [ ] Paredes geradas aleatoriamente
* [ ] Jogador posicionado

Distribuição obrigatória:

* [ ] 2 Compsognatos

* [ ] 5 Troodontes

* [ ] 2 Velociraptors

* [ ] 1 Tiranossauro Rex

* [ ] 4 Caixas de suprimentos

* [ ] T-Rex colocado no lado oposto ao jogador
---

# 5. Jogador

Atributos:

* [ ] Saúde
* [ ] Percepção

Funcionalidades:

* [ ] Movimentação horizontal
* [ ] Movimentação vertical
* [ ] Não mover diagonalmente



---

# 6. Sistema de Visão

* [ ] Mostrar apenas linha de visão do jogador
* [ ] Visão horizontal
* [ ] Visão vertical
* [ ] Visão interrompida por:

    * [ ] Parede
    * [ ] Caixa
    * [ ] Dinossauro



---

# 7. Caixas de Suprimentos

Existem 4 caixas:

* [ ] 1 Kit Médico
* [ ] 1 Bastão Elétrico
* [ ] 2 Armas de Dardos

Além disso:

* [ ] Um Compsognato surpresa escondido

Regras:

* [ ] Kit médico recupera vida
* [ ] Bastão substitui ataque desarmado
* [ ] Dardos adicionam munição caso arma já exista
* [ ] Teste de percepção contra Compsognato surpresa



---

# 8. Dinossauros

## Compsognato

* [ ] Vida 1

## Troodonte

* [ ] Vida 2

## Velociraptor

* [ ] Vida 2
* [ ] Move 2 casas

## Tiranossauro Rex

* [ ] Vida 3
* [ ] Não se move



---

# 9. Sistema de Combate

Antes do combate:

* [ ] Escolher ataque

Tipos:

### Ataque com as mãos

* [ ] Dado de 6 lados
* [ ] Resultado 6 → dano 2
* [ ] Resultado 1 ou 2 → dano 0
* [ ] Resultado 3,4,5 → dano 1

### Bastão Elétrico

* [ ] Dado de 6 lados
* [ ] Resultado 6 → dano 2
* [ ] Resultado 1 → dano 0
* [ ] Resultado 2-5 → dano 1

### Arma de Dardos

* [ ] Consome munição
* [ ] Sempre causa dano 2



---

# 10. Regras Especiais de Combate

* [ ] Velociraptor não pode ser derrotado com dardos
* [ ] T-Rex não recebe dano sem arma
* [ ] Jogador pode fugir
* [ ] Fuga para casa adjacente sem inimigo



---

# 11. Esquiva

Após sobreviver ao ataque:

* [ ] Jogador lança dado de 3 lados
* [ ] Resultado ≤ percepção → esquiva
* [ ] Resultado > percepção → perde vida



---

# 12. Movimento dos Dinossauros

Após cada jogada:

* [ ] Todos os dinossauros se movem
* [ ] T-Rex não se move
* [ ] Movimento aleatório

Velociraptor:

* [ ] Move até 2 casas

Regras:

* [ ] Não ocupar mesma posição de outro dinossauro
* [ ] Se encontrar jogador → combate



---

# 13. Menu Durante o Jogo

* [ ] Movimentar
* [ ] Cura
* [ ] DEBUG
* [ ] Sair

DEBUG:

* [ ] Revela todo o mapa



---

# 14. Fim de Jogo

Vitória:

* [ ] Todos os dinossauros derrotados

Derrota:

* [ ] Vida do jogador chega a 0

Ao terminar:

* [ ] Mostrar resultado
* [ ] Opção Novo Jogo
* [ ] Opção Reiniciar Jogo



---

# 15. Funcionalidades Extras (Opcional)

* [ ] Threads para movimentação
* [ ] Comportamentos diferentes para cada dinossauro
* [ ] Salvamento em arquivo
* [ ] Tratamento de exceções
* [ ] Padrão de projeto



---

# 16. Relatório

* [ ] Capa
* [ ] Sumário
* [ ] Introdução
* [ ] Diagrama de Classes
* [ ] Explicação dos conceitos de POO utilizados
* [ ] Passos para compilar e executar
* [ ] Capturas de tela do jogo
* [ ] Dificuldades encontradas
* [ ] Sugestões para próximos semestres
* [ ] Conclusão



---

# Prioridade Recomendada

1. [ ] Modelar classes
2. [ ] Criar tabuleiro
3. [ ] Gerar mapa aleatório
4. [ ] Implementar jogador
5. [ ] Implementar dinossauros
6. [ ] Implementar combate
7. [ ] Implementar caixas
8. [ ] Implementar movimentação dos inimigos
9. [ ] Implementar visão do jogador
10. [ ] Implementar menus
11. [ ] Fazer relatório
12. [ ] Refatorar e testar tudo

Essa ordem costuma evitar retrabalho e facilita aplicar herança, composição e polimorfismo desde o início.
