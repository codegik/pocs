local md5Obj = require("md5")
require("src/transaction")

function Ledger()
	local self = {}
	local fileName = "/tmp/ledger.db"

	function self.process(
		transaction --[[Transaction]]
	)
		local tx = transaction.save()
		local db = io.open(fileName, "a")
		io.output(db)
		io.write(tx .. "\n")
		io.close(db)

		return true
	end

	function self.restore()
		local accounts = {}
		local db = io.open(fileName, "r")

		for tx in db:lines() do
			local md5, from, to, amount, fromBalance, toBalance =
				tx:match("([^;]+);([^;]+);([^;]+);([^;]+);([^;]+);([^;]+)")
			local restoredTx = from .. ";" .. to .. ";" .. amount .. ";" .. fromBalance .. ";" .. toBalance
			local redoMd5 = md5Obj.sumhexa(restoredTx)

			if md5 == redoMd5 then
				local fromAccount = {}
				local toAccount = {}

				if accounts[from] then
					fromAccount = accounts[from]
				else
					fromAccount = Account(from, amount + fromBalance)
				end
				if accounts[to] then
					toAccount = accounts[to]
				else
					toAccount = Account(to, toBalance - amount)
				end

				accounts[from] = fromAccount
				accounts[to] = toAccount

				Transaction(accounts[from], accounts[to], amount).save()
			end
		end

		db:close()

		return accounts
	end

	function self.dbExists()
		local file = io.open(fileName, "r")
		if file ~= nil then
			io.close(file)
			return true
		end

		return false
	end

	return self
end
