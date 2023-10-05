local lu = require("luaunit")

TestAccount = require("test/account-test")
TestTransaction = require("test/transaction-test")
TestLedger = require("test/ledger-test")

os.exit(lu.LuaUnit.run())
