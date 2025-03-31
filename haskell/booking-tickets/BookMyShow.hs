import Data.Array
import Data.Int (Int64)


data BookMyShow = BookMyShow {
    n :: Int,
    m :: Int,
    stree :: Array Int (Int64, Int64)
}

build :: Int -> Int -> Int -> Array Int (Int64, Int64) -> Array Int (Int64, Int64)
build i p q stree
    | p == q    = stree // [(i, (fromIntegral m, fromIntegral m))]
    | otherwise = build (2 * i + 1) p r (build (2 * i + 2) (r + 1) q (stree // [(i, (fromIntegral m, fromIntegral (q - p + 1) * fromIntegral m))]))
  where
    r = (p + q) `div` 2
    m = snd (stree ! i)


main :: IO ()
main = do
    let n = 4
    let m = 5
    let initialStree = array (0, 2 * n - 1) [(i, (0, 0)) | i <- [0..2 * n - 1]]
    let expectedStree = array (0, 2 * n - 1) [(0, (5, 20)), (1, (5, 10)), (2, (5, 10)), (3, (5, 5)), (4, (5, 5)), (5, (5, 5)), (6, (5, 5)), (7, (5, 5))]
    let resultStree = build 0 0 (n - 1) initialStree
    putStrLn resultStree
    putStrLn expectedStree
    return ()

