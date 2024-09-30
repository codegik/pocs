package com.codegik.zioapp
package domain
package item

enum ProductType:
  case Electronics, Clothes, VideoGames, Toys

object ProductType extends EnumOps[ProductType]
