local lu = require("luaunit")
require("src/account")
require("src/transaction")
require("src/ledger")

local TestLedger = {}

function TestLedger:setUp()
	os.remove("/tmp/ledger.db")
end

function TestLedger:testShouldGenerateFileWith3Tx()
	local account1 = Account("1234", 0)
	local account2 = Account("5678", 10)
	local ledger = Ledger()

	ledger.process(Transaction(account2, account1, 5))
	ledger.process(Transaction(account2, account1, 2))
	ledger.process(Transaction(account1, account2, 7))

	lu.assertTrue(ledger.dbExists())
end

function TestLedger:testShouldRestoreTxs()
	local account1 = Account("1234", 0)
	local account2 = Account("5678", 10)
	local ledger = Ledger()

	ledger.process(Transaction(account2, account1, 5))
	ledger.process(Transaction(account2, account1, 2))
	ledger.process(Transaction(account1, account2, 7))

	local accounts = ledger.restore()

	lu.assertEquals(account1.getBalance(), accounts[account1.getNumber()].getBalance())
	lu.assertEquals(account2.getBalance(), accounts[account2.getNumber()].getBalance())
end

return TestLedger
