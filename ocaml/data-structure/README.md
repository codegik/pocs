
# Array

Arrays are mutable and we can replace their elements with other values of the same type, but cannot be resized. Also we can access elements at any position.

```ocaml
utop # [|1; 2; 3; 4|];;
- : int array = [|1; 2; 3; 4|]


utop # let numbers = Array.init 5 (fun i -> i * 2);;
val even_numbers : int array = [|0; 2; 4; 6; 8|]

utop # numbers.(3);;
- : int = 6


utop # Array.length numbers;;
- : int = 5

(* Iterate array *)
utop # Array.iter (fun x -> print_int x; print_string " ") numbers;;
0 2 4 6 8 - : unit = ()

utop # for i = 0 to Array.length numbers - 1 do
   print_int numbers.(i);
   print_string " "
done;;


(* 
an array is a mutable, fixed-size data structure that can store 
a sequence of elements of the same type 
*)
utop # let a = [| 2; 4; 6; 8 |];;
val a : int array = [|2; 4; 6; 8|]

utop # a.(0);; (* accessing array element *)
- : int = 2

utop # a.(0) <- 23;; (* updating array element *)
- : unit = ()

utop # a;;
- : int array = [|23; 4; 6; 8|]



# List

(* Lists are ordered sequence of elements. All elements should be the same type. *)
(* Lists are imutable by default *)

utop # [false; true; false];;
- : bool list = [false; true; false]

utop # let u = [1; 2; 3; 4];;
val u : int list = [1; 2; 3; 4]

utop # ["this"; "is"; "string"; "list"];;
- : string list = ["this"; "is"; "string"; "list"]

(* cons operator, it will add new value in beginning of the list, but will keep original list *)
utop # 10 :: u;; 
- : int list = [10; 1; 2; 3; 4]

(* original list untouched *)
utop # u;; 
- : int list = [1; 2; 3; 4]

(* Functions on list *)
utop #
let rec total l =
  match l with
  | [] -> 0
  | h :: t -> h + total t;;
val total : int list -> int = <fun>



utop #
let rec append list_a list_b =
  match list_a with
  | [] -> list_b
  | element :: list -> element :: append list list_b;;
val append : 'a list -> 'a list -> 'a list = <fun>

utop # append [1] [2];;
- : int list = [1; 2]


utop #
let rec map func list =
  match list with
  | [] -> []
  | item :: list_r -> func item :: map func list_r;;
val map : ('a -> 'b) -> 'a list -> 'b list = <fun>

utop # map (fun x -> x * x) [1; 2; 4];;
- : int list = [1; 4; 16]

(* finding and filtering *)
utop # List.find (fun item -> item > 3) [1;2;3;4;5;6;7];;
- : int = 4

utop # List.filter (fun item -> item > 3) [1;2;3;4;5;6;7];;
- : int list = [4; 5; 6; 7]


(* wrapping funtion *)
utop #
let size list =
  let rec size_inner count list =
    match list with
    | [] -> count
    | _ :: r_list -> size_inner (count + 1) r_list
  in
    size_inner 0 list;;
val size : 'a list -> int = <fun>

utop # size [1; 4; 6];;
- : int = 3


# Map

(* Maps are imutable key-value, they are never modified and every operation returns a new map instead. *)
(* Maps are alse called dictionaries or associative tables. *)
utop # module StringMap = Map.Make(String);;
module StringMap :
  sig
    type key = string
    type 'a t = 'a Map.Make(String).t
    val empty : 'a t
    val add : key -> 'a -> 'a t -> 'a t
    (......)
  end

(* creating map from list *)
utop # let map = StringMap.of_list [("one", 1); ("two", 2)];;
val map : int StringMap.t = <abstr>

(* creating empty map *)
utop # let int_map : int StringMap.t = StringMap.empty;;
val int_map : int StringMap.t = <abstr>

(* accessing key *)
utop # StringMap.find_opt "two" map;;
- : int option = Some 2

(* adding element to map *)
utop # let more_map = StringMap.add "three" 3 map;;
val more_map : int StringMap.t = <abstr>







```
