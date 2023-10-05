local lu = require("luaunit")
require("account")
require("transaction")

function testTransfer()
	local account1 = Account("1234", 10)
	local account2 = Account("9865", 0)

	local tx = Transaction(account1, account2, 5)
	local out = "from:1234;to:9865;amount:5"
	lu.assertEquals(out, tx.save())
end

os.exit(lu.LuaUnit.run())
