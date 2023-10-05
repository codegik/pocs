local lu = require("luaunit")
require("src/account")

local TestAccount = {}

function TestAccount:testShouldHaveNegativeAmount()
	local account = Account("1234")

	account.addBalance(4)
	account.subtractBalance(10)

	lu.assertEquals(-6, account.getBalance())
end

function TestAccount:testShouldHavePositiveAmount()
	local account = Account("1234")

	account.addBalance(4)

	lu.assertEquals(4, account.getBalance())
end

return TestAccount
