import tables
import algorithm


proc topSelling*(top: int, songs: seq[int]): seq[int] =
  var selling = initOrderedTable[int, int]()

  for song in songs:
    if not selling.hasKey(song):
      selling[song] = 0
    selling[song] = selling[song] + 1

  selling.sort(proc (x, y: (int, int)): int = cmp(x[1], y[1]), Descending)

  for i in selling.keys:
    result.add(i)

  result[0..top-1]

