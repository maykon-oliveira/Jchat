# Documento de Visão: JChat

## Histórico de Alterações

| Data       | Alteração         | Autor  |
| :--------: | :---------------: | :----: |
| 27/03/2018 | Início do projeto | Maykon |

### Sobre o Projeto:

Chat desenvolvido para a disciplina de Programação em ambientes de Redes. Integrantes: [@Maykon](https://github.com/maykon-oliveira/), [@Leandro](), [@Habys](https://github.com/Habys10), [@Cris](https://github.com/cristianesa).

## Descrição do Projeto:

Desenvolver um chat que possibilite o usuário enviar mensagem (A) e receber mensagens (B) simultaneamente. As mensagens quando recebidas pelo servidor (C) serão encaminhadas a todos que estiverem conectados ao servidor (D). Os usuários terão um nickname para identificá-los (E).

* **(A)** O usuário pode enviar mensagens de texto para o servidor.
* **(B)** O usuário receberá mensagem vindas do servidor.
* **(C)** O servidor receberá as mensagens de todos os usuários conectados.
* **(D)** O servidor enviara as mensagens a todos os usuários conectados a ele.
* **(E)** O usuário terá um nickname para identificá-lo no chat.

## Requisitos Funcionais:

- **RF1. Nickname:** O nickname será o identificador do usuário conectado ao sistema. O nickname será exibido quando o usuário enviar as suas mensagens para o servidor. Dois os usuários podem ter o mesmo nickname. “Por hora”.
- **RF2. Servidor:** O servidor concentra todos os usuários conectados a ele, e terá a responsabilidade de enviar as mensagens a todos os usuários conectados a ele.

## Requisitos Não-Funcionais:

- **RFN1.** Todo o sistema do lado cliente terá uma parte gráfica.
- **RFN2.** Será necessário um servidor central com “IP fixo” e portas padrões para o sistema (RN2).

## Regras de Negócio:

- **RN1.** Nickname: O nickname pode ser caracteres alfanuméricos, com no máximo 12 caracteres. /^[A-Za-z0-9]{,12}$/
- **RN2.** Portas Padrão: TCP – 5000.
