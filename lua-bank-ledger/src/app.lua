require("src/account")
require("src/transaction")
require("src/ledger")

print(Account("4444", 9).getBalance())

local account1 = Account("1234", 0)
local account2 = Account("5678", 10)
local ledger = Ledger()

ledger.process(Transaction(account2, account1, 5))
ledger.process(Transaction(account2, account1, 2))
ledger.process(Transaction(account1, account2, 7))
ledger.restore()
