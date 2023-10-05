local lu = require("luaunit")
require("src/account")
require("src/transaction")

local TestTransaction = {}

function TestTransaction:testShouldGenerateTx()
	local account1 = Account("1234", 10)
	local account2 = Account("9865", 0)
	local tx = Transaction(account1, account2, 5)
	local out = "1234;9865;5" -- from acc number;to acc number;amount
	local exists = string.find(tx.save(), out) ~= nil

	lu.assertTrue(exists)
end

function TestTransaction:testShouldTransfer10()
	local account1 = Account("1234", 10)
	local account2 = Account("9865", 0)

	Transaction(account1, account2, 5).save()
	Transaction(account2, account1, 2).save()

	lu.assertEquals(7, account1.getBalance())
	lu.assertEquals(3, account2.getBalance())
end

return TestTransaction
