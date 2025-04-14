module Main (main) where

import BookMyShow

main :: IO ()
main = do
    bookShow <- newBookMyShow 2 5
    gatherResult1 <- gather bookShow 4 0
    putStrLn $ "gather 4 0: " ++ show gatherResult1
    gatherResult2 <- gather bookShow 2 0
    putStrLn $ "gather 2 0: " ++ show gatherResult2
    scatterResult1 <- scatter bookShow 5 1
    putStrLn $ "scatter 5 1: " ++ show scatterResult1
    scatterResult2 <- scatter bookShow 5 1
    putStrLn $ "scatter 5 1: " ++ show scatterResult2
