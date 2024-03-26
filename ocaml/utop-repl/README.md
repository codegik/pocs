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

// Names can be defined locally, within an expression, using the let … = … in … syntax:
utop # let y = 50 in y * 2;;
- : int = 100

// Since let … = … in … is an expression, it can be used within another expression in order to have several values with their own names:
utop # let a = 4 in
       let b = 9 in
       a + b;;
- : int = 13

// Creating/calling functions
utop # let square x = x * x;;
val square : int -> int = <fun>

utop # square 3;;
- : int = 9

// call Option.value function and return default value
utop # Option.value None ~default:32;;
- : int = 32

// call Option.value function and return optional value
utop # Option.value (Some 5) ~default:66;;
- : int = 5

```