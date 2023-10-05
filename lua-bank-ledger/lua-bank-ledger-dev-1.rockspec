rockspec_format = "3.0"
package = "lua-bank-ledger"
version = "dev-1"
source = {
	url = "git+ssh://git@github.tlcinternal.com/iklassman/pocs.git",
}
description = {
	homepage = "*** please enter a project homepage ***",
	license = "*** please specify a license ***",
}
dependencies = {
	"lua >= 5.1, < 5.5",
	"luaunit >= 3.4-1",
	"inspect >= 3.1",
}
build = {
	type = "builtin",
	modules = {
		setup = "config/setup.lua",
		account = "src/account.lua",
		main = "src/app.lua",
	},
}
test = {
	type = "command",
	script = "test/account.test.lua",
}
