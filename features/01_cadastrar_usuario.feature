Feature: Criar uma nova conta de usuário.

Scenario: Cadastro de novo usuário com um e-mail ainda não presente no banco de dados

Given Abrir o navegador

Given Abrir tela de cadastro

Given Cadastrar nome de usuario

Given Cadastrar login do usuario

Given Cadastrar senha do usuario

When Finalizar cadastro do usuario

Then Confirmar cadastro com sucesso 
