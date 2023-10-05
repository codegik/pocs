local md5Obj = require("md5")

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
		local db = io.open(fileName, "r")

		for tx in db:lines() do
			local md5, from, to, amount, balance = tx:match("([^;]+);([^;]+);([^;]+);([^;]+);([^;]+)")
			local restoredTx = from .. ";" .. to .. ";" .. amount .. ";" .. balance
			local redoMd5 = md5Obj.sumhexa(restoredTx)

			if md5 == redoMd5 then
			end
		end

		db:close()
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
