-- package.path = "./src/?.lua;./src/?/init.lua;"..package.path
local port = arg[1]
local pegasus = require("pegasus")
local uuid = require("uuid")
local server = pegasus:new({ port = port })

server:start(function (req, rep)
  -- rep:write("App runnin on port " .. port .. " and uuid is " .. uuid())
  rep:addHeader('Content-Type', 'text/html'):write(uuid.v4())
  return rep:close()
end)
