open OUnit2
open Oop.Int_queue

let tests = "testing int list" >::: [

  "int list is empty" >:: (fun _ -> 
    let queue = new int_queue in
    assert_equal queue#size 0
  );

  "add item in the end of list" >:: (fun _ -> 
    let queue = new int_queue in
    queue#add 5;
    assert_equal queue#size 1
  );

  "pop item from int list" >:: (fun _ -> 
    let queue = new int_queue in
    queue#add 5;
    let result = queue#pop in
    assert_equal result 5;
    assert_equal queue#size 0
  );
]

let _ = run_test_tt_main tests
