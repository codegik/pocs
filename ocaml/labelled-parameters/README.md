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

```