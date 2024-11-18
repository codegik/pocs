package = "lua-app"
version = "dev-1"
source = {
   url = "git+ssh://git@github.tlcinternal.com/iklassman/pocs.git"
}
description = {
   homepage = "*** please enter a project homepage ***",
   license = "*** please specify a license ***"
}
dependencies = {
  "lua >= 5.1, < 5.5",
  "pegasus >= 1.0.7-0",
  "uuid >= 1.0.0-1",
}
build = {
   type = "builtin",
   modules = {
      app = "app.lua"
   }
}
