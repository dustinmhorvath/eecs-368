{-# OPTIONS_GHC -O2 #-}
import Data.Array.Unboxed
 
--minus block adapted from Pedro R. on Stackoverflow, used
--because I wanted a prefix minus operator for listPrimes
minus :: Ord a => [a] -> [a] -> [a]
minus [] _ = []
minus xs [] = xs
minus l1@(x:xs) l2@(y:ys)
    | x > y = minus l1 ys
    | x < y = x : minus xs l2
    | otherwise = minus xs l2

--returns primes up to n using sieve of E
sieveE n = 2 : sieve [3,5..n]  where
    sieve (x:xs) 
       | x*x > n   = x : xs
       | otherwise = x : sieve (xs `minus` [x*x, x*x+2*x..])

isPrime k = null [ x | x <- [2..k - 1], k `mod`x  == 0]

getSuf i n x = do
 if(n < x)
  then
   if(isPrime i)
    then
     do 
      print i
      getSuf (i+1) (n+1) x
    else
     getSuf (i+1) n x
  else
   return()

-- returns x number of primes using brute force
getPrimes x = do
 getSuf 2 0 x
 return()

--returns x primes using sieve of E
takePrimes x = take x (sieveE 1000000)

--returns the x'th prime using sieve of E
getNthPrime x = last (takePrimes x)
