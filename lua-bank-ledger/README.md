# Bank Ledger Poc

## Requirements

- Lua 5.4.6
- LuaRocks 3.9.2

```shell
brew install lua
brew install luarocks
```

## Installing dependencies

LuaRocks will install dependencies.

```shell
luarocks install --deps-only lua-bank-ledger-dev-1.rockspec
```

## Configuration

Need to create system variable to recognize the dependencies.

```shell
export LUA_INIT="@config/setup.lua"
```

## Building

```shell
luarocks build
```

## Testing

```shell
luarocks test
```
