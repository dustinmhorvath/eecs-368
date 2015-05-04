{-# OPTIONS_GHC -O2 #-}
import Data.Array.Unboxed

 
primesToA m = sieve 3 (array (3,m) [(i,odd i) | i<-[3..m]]
                        :: UArray Int Bool)
  where
    sieve p a 
      | p*p > m   = 2 : [i | (i,True) <- assocs a]
      | a!p       = sieve (p+2) $ a//[(i,False) | i <- [p*p, p*p+2*p..m]]
      | otherwise = sieve (p+2) a

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

getPrimes x = do
 getSuf 2 0 x
 return()

--main = do
-- print 5
