import Prelude hiding ((.))


newtype Html = Html String
newtype Structure = Structure String

(.) :: (b -> c) -> (a -> b) -> (a -> c)
(.) f g x = f (g x)

tag :: String -> String -> String
tag tagParam contentParam = "<" <> tagParam <> ">" <> contentParam <> "</" <> tagParam <> ">"

html :: String -> String
html = tag "html"

body :: String -> String
body = tag "body"

head_ :: String -> String
head_ = tag "head"

title :: String -> String
title = tag "title"

h1 :: String -> String
h1 = tag "h1"

p :: String -> Structure
p = Structure . tag "p"

makeHtml :: String -> String -> String
makeHtml titleParam contentParam = html (head_ (title titleParam) <> body contentParam)

append :: Structure -> Structure -> Structure
append (Structure first) (Structure second) =
  Structure (first <> second)

render :: Html -> String
render (Html html) = html





myHtml = makeHtml
  "Blog Post" 
  (h1 "Hey all!" <> p "This is my blog post")

main = putStrLn myHtml

