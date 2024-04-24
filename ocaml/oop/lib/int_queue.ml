  class int_queue = object 
    val mutable list = ([] : int list)

    method size =
      List.length list

    method pop =
      let first = List.hd list in
      list <- List.tl list;
      first

    method add item =
      list <- list @ [item]

  end;;
