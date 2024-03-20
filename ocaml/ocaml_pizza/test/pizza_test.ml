open OUnit2
open Dojo.Pizza

let tests = "find similar taste" >::: [

  "inacio should share pizza with gamba" >:: (fun _ -> 
    let gamba = List.nth user_tastes 1 in
    assert_equal (find "Inacio" user_tastes) [gamba]);

]

let _ = run_test_tt_main tests