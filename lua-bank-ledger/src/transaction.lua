function Transaction(fromAccount, toAccount, amount)
	local self = {}

	local from = fromAccount
	local to = toAccount
	local amount = amount

	function self.save()
		from.subtractBalance(amount)
		to.addBalance(amount)
		return "from:" .. from.getNumber() .. ";to:" .. to.getNumber() .. ";amount:" .. amount
	end

	return self
end
