local md5 = require("md5")

function Transaction(
	fromAccount, --[[Account]]
	toAccount, --[[Account]]
	amount --[[int]]
)
	local self = {}

	local from = fromAccount
	local to = toAccount
	local amount = amount

	function self.save() --[[string]]
		from.subtractBalance(amount)
		to.addBalance(amount)

		-- md5;from acc number;to acc number;amount
		local tx = from.getNumber() .. ";" .. to.getNumber() .. ";" .. amount .. ";" .. from.getBalance()
		tx = md5.sumhexa(tx) .. ";" .. tx

		return tx
	end

	return self
end
