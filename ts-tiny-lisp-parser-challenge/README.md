# Tiny Lisp Parser Challenge 

<img src="https://miro.medium.com/v2/1*_XEK5hMqdyjVw0GzQu-KUw.png" width="200" height="200"> 
<img src="https://www.sqlservercentral.com/wp-content/uploads/legacy/2dce785563c411cf102d0c2d06384df3da7af3fb/parens0.jpg" width="200" height="200"> 
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOwf8lu9i_hkF8e8QeRSJjyUxwKmtwSpCGQL-g3sov3lBMPOWpWQHoYq4qkAN3S0BzEeY&usqp=CAU" width="200" height="200"> 
<img src="https://cdn-icons-png.flaticon.com/512/3344/3344356.png" width="200" height="200"> 

Parsing is based on the concept of grammar, which is a set of rules that define how a language can be constructed from basic symbols. 
A grammar can be formal or informal, depending on how rigorously it is specified and enforced. 
For example, natural languages like English have informal grammars that allow for variations and exceptions, while programming languages have formal grammars that are precise and unambiguous. 
A formal grammar can be classified into different types, such as regular, context-free, context-sensitive, and unrestricted, depending on the complexity and expressiveness of the rules. 
We need to write a tiny lisp parser. The good news is that you don't need to write the whole parser. 

You will write 2 modules on the parser first module you need to tell if the parentheses are valid. 

Second module check if the functions being called exist on the function list or not. 

functions: 
``` 
print 
echo 
``` 
code: 
```
clojure (print (echo (echo "1"))) 
``` 
Does code compile?

Restrictions 
``` 
1. No String manipulations like: (contains) can be used. 
2. No Recursion allowed. 
3. No While loops. 
``` 

