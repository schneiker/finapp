# FinApp

FinApp é um aplicativo Android simples para cadastro de transações financeiras (créditos e débitos) e visualização do extrato.

Cadastro de transações com:
- Descrição
- Valor
- Tipo (Crédito ou Débito)

Visualização do extrato:
- Lista com todas as transações salvas.

Armazenamento local:
- Dados persistem usando `SharedPreferences`.

- **MainActivity**
  - Tela inicial e menu de navegação.
  - Opções: cadastrar, visualizar extrato, sair.

- **RegisterActivity**
  - Permite ao usuário cadastrar uma nova transação.
  - Valida campos obrigatórios.
  - Salva os dados no `SharedPreferences`.

- **BankStatementActivity**
  - Exibe a lista de transações salvas em um `ListView`.

