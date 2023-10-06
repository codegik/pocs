rockspec_format = "3.0"
package = "lua-bank-ledger"
version = "dev-1"
source = {
	url = "https://github.com/codegik/pocs.git",
}
description = {
	homepage = "*** please enter a project homepage ***",
	license = "*** please specify a license ***",
}
dependencies = {
	"lua >= 5.1, < 5.5",
	"inspect >= 3.1",
}
build = {
	type = "builtin",
	modules = {
		["lua-bank-ledger"] = "src/app.lua",
	},
}
test = {
	type = "command",
	command = "lua test/test.lua -o TAP",
}

test_dependencies = {
	"luaunit >= 3.4",
}
