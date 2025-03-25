main = do
  putStrLn "Hey all"
  putStrLn ("These are my odd numbers: " ++ show (filter odd [5..15]))
