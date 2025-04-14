module BookMyShow
    ( newBookMyShow, gather, scatter
    ) where


import Data.Array.IO
import Data.IORef
import Control.Monad

data BookMyShow = BookMyShow {
    -- immutable Int variable
    seats :: Int,
    -- mutable Int variable
    startRow :: IORef Int,
    -- mutable array, first Int is the index type, and second Int is the value type
    left :: IOArray Int Int
}

-- IO monad means it will perform actions that involve mutable state
newBookMyShow :: Int -> Int -> IO BookMyShow
-- The "do" block is part of the IO monad, each line represents an action
newBookMyShow rows seats = do
    -- initializing the mutable state with 0
    startRowRef <- newIORef 0
    -- the (0, rows - 1) is a range creating valid indexes for the array
    leftArray <- newArray (0, rows - 1) seats
    -- $ is to avoid more (), so this is returning an function to create the object
    return $ BookMyShow seats startRowRef leftArray

gather :: BookMyShow -> Int -> Int -> IO (Maybe (Int, Int))
gather bookMyShow slots maxRow = do
    -- extracting startRow left seats from the BookMyShow object
    start <- readIORef (startRow bookMyShow)
    let leftArray = left bookMyShow
    let seatsAmt = seats bookMyShow
    -- The loop function is a recursive function that iterates
    -- over rows starting from start up to maxRow.
    -- This is a declared function that will be called by "loop start" later on.
    let loop row
            -- Pipes are guard clause.
            | row > maxRow = return Nothing -- no row has enough available slots
            | otherwise = do
                available <- readArray leftArray row
                -- Checks if the current row has enough seats for the requestes amount of slots
                if available >= slots then do
                    -- Updates the array to reduce the available seats in the current row
                    writeArray leftArray row (available - slots)
                    -- Just is a constructor for the Maybe type, which is an Optional value.
                    -- (i, seatsAmt - available) is a tuple containing the row index and the number of available seats.
                    return $ Just (row, seatsAmt - available)
                -- call loop function recursively moving to the next iteration
                else loop (row + 1)
    -- Starts the recursive search from the start row.
    loop start

scatter :: BookMyShow -> Int -> Int -> IO Bool
scatter bookMyShow slots maxRow = do
    start <- readIORef (startRow bookMyShow)
    let leftArray = left bookMyShow
    -- This is a declared function that will be called by "loop start slots" later on.
    -- This loop function is returning a tuple with a Bool and an Int:
        -- Bool: indicate that all required slots have been allocated.
        -- Int: the index of the last row that was checked.
    let loop row remaining
            -- reach the end of the loop
            | row > maxRow = return (remaining == 0, row)
            -- if remaining is less than or equal to 0, it means all slots have been allocated
            | remaining <= 0 = return (True, row)
            | otherwise = do
                available <- readArray leftArray row
                -- Checks if the current row (i) has enough available slots to fulfill the remaining request.
                if remaining <= available then do
                    -- Updates the array to reduce the available slots in the current row
                    -- by the number of slots allocated.
                    writeArray leftArray row (available - remaining)
                    -- it means all slots have been allocated.
                    return (True, row)
                else do
                    -- Updates the available slots in the current row to 0,
                    -- meaning all remaining slots in this row are used.
                    writeArray leftArray row 0
                    -- Call loop function recursively moving to the next iteration.
                    -- The updated number of slots still needed after using all available slots in the current row.
                    loop (row + 1) (remaining - available)
    -- This loop function is returning a tuple with a Bool and an Int.
    (success, newStart) <- loop start slots
    -- This ensures that if the allocation was successful, the startRow is updated to the row index where
    -- the allocation ended, preparing for the next operation.
    when success $ writeIORef (startRow bookMyShow) newStart
    return success

-- main :: IO ()
-- main = do
--     bookShow <- newBookMyShow 2 5
--     gatherResult1 <- gather bookShow 4 0
--     putStrLn $ "gather 4 0: " ++ show gatherResult1
--     gatherResult2 <- gather bookShow 2 0
--     putStrLn $ "gather 2 0: " ++ show gatherResult2
--     scatterResult1 <- scatter bookShow 5 1
--     putStrLn $ "scatter 5 1: " ++ show scatterResult1
--     scatterResult2 <- scatter bookShow 5 1
--     putStrLn $ "scatter 5 1: " ++ show scatterResult2

