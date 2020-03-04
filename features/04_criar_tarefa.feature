Feature: Criar tarefas de um usuário.

Scenario: Criar uma nova tarefa de um usuário cadastrado.

Given Clicar no botão de nova tarefa

Given Preencher titulo da tarefa

Given Selecionar uma data limite

Given Selecionar uma hora limite

Given Preencher uma descricao da tarefa

Given Informar a situacao da tarefa

Then Criar tarefa 