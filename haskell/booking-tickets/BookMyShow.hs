--import Data.Array
--import Data.Int (Int64)
--
--
--data BookMyShow = BookMyShow {
--    n :: Int,
--    m :: Int,
--    stree :: Array Int (Int64, Int64)
--}
--
--build :: Int -> Int -> Int -> Array Int (Int64, Int64) -> Array Int (Int64, Int64)
--build i p q stree
--    | p == q    = stree // [(i, (fromIntegral m, fromIntegral m))]
--    | otherwise = build (2 * i + 1) p r (build (2 * i + 2) (r + 1) q (stree // [(i, (fromIntegral m, fromIntegral (q - p + 1) * fromIntegral m))]))
--  where
--    r = (p + q) `div` 2
--    m = snd (stree ! i)
--
--
--main :: IO ()
--main = do
--    let n = 4
--    let m = 5
--    let initialStree = array (0, 2 * n - 1) [(i, (0, 0)) | i <- [0..2 * n - 1]]
--    let expectedStree = array (0, 2 * n - 1) [(0, (5, 20)), (1, (5, 10)), (2, (5, 10)), (3, (5, 5)), (4, (5, 5)), (5, (5, 5)), (6, (5, 5)), (7, (5, 5))]
--    let resultStree = build 0 0 (n - 1) initialStree
--    putStrLn resultStree
--    putStrLn expectedStree
--    return ()




import Data.Array.IO
import Data.IORef
import Control.Monad

data BookMyShow = BookMyShow {
    m :: Int,
    startRow :: IORef Int,
    left :: IOArray Int Int
}

newBookMyShow :: Int -> Int -> IO BookMyShow
newBookMyShow n m = do
    startRowRef <- newIORef 0
    leftArray <- newArray (0, n - 1) m
    return $ BookMyShow m startRowRef leftArray

gather :: BookMyShow -> Int -> Int -> IO (Maybe (Int, Int))
gather bookMyShow k maxRow = do
    start <- readIORef (startRow bookMyShow)
    let leftArray = left bookMyShow
    let mValue = m bookMyShow
    let loop i
            | i > maxRow = return Nothing
            | otherwise = do
                available <- readArray leftArray i
                if available >= k
                    then do
                        writeArray leftArray i (available - k)
                        return $ Just (i, mValue - available)
                    else loop (i + 1)
    loop start

scatter :: BookMyShow -> Int -> Int -> IO Bool
scatter bookMyShow k maxRow = do
    start <- readIORef (startRow bookMyShow)
    let leftArray = left bookMyShow
    let loop i remaining
            | i > maxRow = return (remaining == 0, i)
            | remaining <= 0 = return (True, i)
            | otherwise = do
                available <- readArray leftArray i
                if remaining <= available
                    then do
                        writeArray leftArray i (available - remaining)
                        return (True, i)
                    else do
                        writeArray leftArray i 0
                        loop (i + 1) (remaining - available)
    (success, newStart) <- loop start k
    when success $ writeIORef (startRow bookMyShow) newStart
    return success

main :: IO ()
main = do
    bookShow <- newBookMyShow 2 5
    gatherResult1 <- gather bookShow 4 0
    putStrLn $ "gather: " ++ show gatherResult1
    gatherResult2 <- gather bookShow 2 0
    putStrLn $ "gather: " ++ show gatherResult2
    scatterResult1 <- scatter bookShow 5 1
    putStrLn $ "scatter: " ++ show scatterResult1
    scatterResult2 <- scatter bookShow 5 1
    putStrLn $ "scatter: " ++ show scatterResult2