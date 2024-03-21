```ocaml

utop # 4 * 45;;
- : int = 180

utop # 4.67;;
- : float = 4.67

utop # "my string";;
- : string = "my string"

utop # let u = [1; 2; 3; 4];;
val u : int list = [1; 2; 3; 4]

utop # ["this"; "is"; "string"; "list"];;
- : string list = ["this"; "is"; "string"; "list"]

utop # 10 :: u;; // cons operator, it will add new value in beginning of the list, but will keep original list
- : int list = [10; 1; 2; 3; 4]

utop # u;; // original list untouched
- : int list = [1; 2; 3; 4]

// if … then … else … is not a statement; it is an expression.
utop # 2 * if "hello" = "hi" then 3 else 9;;
- : int = 18

```