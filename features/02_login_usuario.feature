Feature: Login da conta de usuário.

Scenario: Login de usuário com um e-mail já existente no banco de dados

Given Abrir o navegador

Given Abrir tela de login

Given Preencher login de usuario

Given Preencher senha do usuario

When Clicar no botao signin

Then Confirmar login com sucesso 
