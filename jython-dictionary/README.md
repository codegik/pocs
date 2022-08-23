# Problem

## Dictionary replacer

This kata is about making a simple string replacer. Create a method that takes a string and a dictionary, and replaces every key in the dictionary preffixed with a dollar sign, with the corresponding value from the Dictionary.

## Tests

```
input : “”, 
dict empty, 
output:""
```

```
input : “$temp”, 
dict [“temp”, “temporary”], 
output: “temporary”
```

```
input : “$temp here comes the name $name”, 
dict [“temp”, “temporary”] [“name”, “John Doe”], 
output : “temporary here comes the name John Doe”
```