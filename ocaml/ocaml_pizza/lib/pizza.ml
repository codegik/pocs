type person_tastes = { first_name: string; spice_chiken: int; italian: int; four_cheese: int; banana: int; veggi: int; };;

let user_tastes = [{first_name = "Inacio"; spice_chiken = 5; italian = 3; four_cheese = 2; banana = 1; veggi = 1};
                    {first_name = "Gamba"; spice_chiken = 1; italian = 3; four_cheese = 5; banana = 2; veggi = 5}; 
                    {first_name = "John"; spice_chiken = 4; italian = 1; four_cheese = 4; banana = 4; veggi = 3};
                    ];;
  
let compare_tastes person_taste1 person_taste2 =
  if person_taste1.spice_chiken == person_taste2.spice_chiken then true
  else if person_taste1.italian == person_taste2.italian then true
  else if person_taste1.four_cheese == person_taste2.four_cheese then true
  else if person_taste1.banana == person_taste2.banana then true
  else if person_taste1.veggi == person_taste2.veggi then true
  else false;;

let rec find name team_tastes =
  match team_tastes with 
  | [] -> raise (Failure "Not Found")
  | user :: list -> 
    if name = user.first_name then 
      List.filter (fun teammate -> 
          (compare user.first_name teammate.first_name) != 0 
          && compare_tastes teammate user
        ) user_tastes
    else 
      find name list;;