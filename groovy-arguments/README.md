# Groovy Arguments

The arguments passed to a program consist of flags and values.

Flags should be one, or more character, preceded by minus sign. Each flag should have zero, or one, or many values associated.

We need to create a parser to recognize these arguments.

The known arguments are:

`-l -dir /usr/bin -p 8080 -v -d 1,2,3,4,-5 -s save,delete`

Flag "s" means a list of strings.

Flag "d" means a list of integers.

The user that is running the program can input the flags in any order.
Make sure the parser is extensible, which means it should be easy to add new flags.