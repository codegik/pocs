local lu = require("luaunit")
require("account")

function testNegativeAmount()
	local account = Account("1234")

	account.addBalance(4)
	account.subtractBalance(10)

	lu.assertEquals(-6, account.getBalance())
end

function testPositiveAmount()
	local account = Account("1234")

	account.addBalance(4)

	lu.assertEquals(4, account.getBalance())
end

os.exit(lu.LuaUnit.run())
