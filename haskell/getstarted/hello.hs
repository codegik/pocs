main = do
  putStrLn "Hey all"
  putStrLn ("These are my odd numbers: " ++ show (filter odd [5..15]))
  putStrLn ("Take 3: " ++ show (take 3 [5..15]))
  putStrLn ("Sum: " ++ show (4 + 4))

  test :: String
  test = "Test"
  putStrLn (test)
