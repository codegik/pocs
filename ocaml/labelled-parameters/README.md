```ocaml

It is possible to give names and default values to function parameters. 
This is broadly known as labels. In this tutorial, we learn how to use labels.

(* call Option.value function and return default value *)
utop # Option.value None ~default:32;;
- : int = 32

(* call Option.value function and return optional value *)
utop # Option.value (Some 5) ~default:66;;
- : int = 5

(* naming parameters in a function *)
utop # let rec range ~first:lo ~last:hi = if lo > hi then [] else lo :: range ~first:(lo + 1) ~last:hi;;
val range : first:int -> last:int -> int list = <fun>

utop # range ~first:1 ~last:4;;
- : int list = [1; 2; 3; 4]

(* optional/default values in a function *)
utop # let sum ?(init = 0) u = List.fold_left (+) init u;;
val sum : ?init:int -> int list -> int = <fun>

utop # sum [1; 2; 3];;
- : int = 6

utop # sum [1; 2; 3] ~init:99;;
- : int = 105

(* An optional parameter can be declared without specifying a default value *)
(* Optional parameters should be declared first, otherwise will generate a warn *)
(* 
  s is the string from which we are extracting a substring.
  pos is the substring's starting position. It defaults to 0.
  len is the substring's length. If missing, it defaults to String.length s - pos.
*)
utop # let sub ?(pos=0) ?len:len_opt s =
    let default = String.length s - pos in
    let length = Option.value ~default len_opt in
    String.sub s pos length;;
val sub : ?pos:int -> ?len:int -> string -> string = <fun>

utop # sub ~len:5 ~pos:3 "immutability";;
- : string = "utabi" (* returns 5 chars starting on position 3 *)

utop # sub "immutability" ~len:3;;
- : string = "imm" (* returns 3 chars starting on position 0, default pos = 0 *)

utop # sub "immutability" ~pos:4;;
- : string = "tability" (* returns 8 chars starting on position 4, it ends on last char of string *)

utop # sub "Inacio";;
- : string = "Inacio" (* returns all chars due default parameters *)        


(* joining string *)
utop # let join ?(sep=";") text = String.concat sep text;;
val join : ?sep:string -> string list -> string = <fun>

utop # join ["a"; "b"; "c"];;
- : string = "a;b;c"

utop # join ["a"; "b"; "c"] ~sep:"+";;
- : string = "a+b+c"


(* Passing Labelled Arguments Using the Pipe Operator *)
(* 
  Declaring a function's unlabelled argument as the first one simplifies 
  reading the function's type and does not prevent passing this argument 
  using the pipe operator.
*)
utop # let rec range step ~first ~last =
  if first > last then []
  else first :: range step ~first:(first + step) ~last;;
val range : int -> first:int -> last:int -> int list = <fun>

(* calling function normal way *)
utop # range 3 ~first:1 ~last:10;;
- : int list = [1; 4; 7; 10]


(* calling function using | *)
utop # 3 |> range ~first:1 ~last:10;; (* parameter step will receive value 3 *)
- : int list = [1; 4; 7; 10]

``` 
