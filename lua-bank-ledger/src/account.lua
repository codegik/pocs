function Account(
	number, --[[string]]
	balance --[[int]]
)
	local self = {}

	local number = number
	local balance = balance

	if balance == nil then
		balance = 0
	end

	function self.getNumber()
		return number
	end

	function self.getBalance()
		return balance
	end

	function self.addBalance(
		amount --[[int]]
	)
		balance = balance + amount
		return balance
	end

	function self.subtractBalance(
		amount --[[int]]
	)
		balance = balance - amount
		return balance
	end

	return self
end
