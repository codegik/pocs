```ocaml

(* immutable variable *)
utop # let x = 1;;
val x : int = 1

utop # x = 2;;
- : bool = false (* doesnt change the original value *)

(* mutable variable *)
(* ref is a function *)
utop # let y = ref 1;;
val y : int ref = {contents = 1}

utop # y = 3;; (* y is immutable, and cannot be changed. But {contents=2} is mutable *)
Error: This expression has type int but an expression was expected of type int ref

utop # y := 2;; (* operator := is used to update the mutable value inside y *)
- : unit = ()

utop # y;;
- : int ref = {contents = 2} (* show new contents of y*)

utop # !y;;
- : int = 2 (* operator ! reads the contents of the mutable value inside y *)


(* mutable record fields *)
utop # type book = {
  title: string;
  author: string;
  mutable sold: bool;
};;
type book = { title : string; author : string; mutable sold : bool; }

(* creating instance of book *)
utop # let hobbit = {
  title = "An Unexpected Journey";
  author = "Tolkien";
  sold = false;
};;
val hobbit : book =
  {title = "An Unexpected Journey"; author = "Tolkien"; sold = false}

(* Mutable record fields are updated using the left arrow symbol <- *)
utop # hobbit.sold <- true;;
- : unit = ()

utop # hobbit.sold;;
- : bool = true




(* function encapusulated mutability *)
utop # let sum arr =
  let result = ref 0 in
  for i = 0 to Array.length arr - 1 do
    result := !result + arr.(i)
  done;
  !result;;
val sum : int array -> int = <fun>

(* 
The function sum is written in an imperative style, 
using mutable data structures and a for loop. 
However, no mutability is exposed. It is a fully encapsulated implementation choice. 
This function is safe to use; no problems are to be expected.
*)
utop # sum [|1;2;3|];;
- : int = 6




```
