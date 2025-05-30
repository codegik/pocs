
import BookMyShow
import Test.HUnit
import Data.Array.IO
import Data.IORef

main :: IO ()
main = do
    let testGather = TestCase $ do
            bookShow <- newBookMyShow 2 5
            result1 <- gather bookShow 4 0
            assertEqual "gather 4 0 should return Just (0, 0)" (Just (0, 0)) result1
            result2 <- gather bookShow 2 0
            assertEqual "gather 2 0 should return Nothing" Nothing result2
            result3 <- gather bookShow 6 0
            assertEqual "gather 6 0 should return Nothing" Nothing result3

    let testScatter = TestCase $ do
            bookShow <- newBookMyShow 2 5
            result1 <- scatter bookShow 5 1
            assertEqual "scatter 5 1 should return True" True result1
            result2 <- scatter bookShow 3 1
            assertEqual "scatter 3 1 should return True" True result2
            result3 <- scatter bookShow 6 1
            assertEqual "scatter 6 1 should return False" False result3

    -- Run all tests
    runTestTT $ TestList [TestLabel "Test Gather" testGather, TestLabel "Test Scatter" testScatter]
    return ()
