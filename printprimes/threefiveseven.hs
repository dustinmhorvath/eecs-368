-- This is a hideously brute-force attempt at producing Hamming numbers. It does far more computation
--  than is likely necessary, and does a poor job of leveraging the programmatic advantages that haskell
--  offers for manipulating lists and infinite series. It stands as a testament to stubbornness, but also 
--  gives a new perspective on how to approach the problem.


isPrime k = null [ x | x <- [2..k - 1], k `mod`x  == 0]

-- This function checks to make sure there are no primes 9 or larger inside the parameter
noHigher x = noHigherPrimes 9 x
noHigherPrimes i x = 
 if(i < x)
  then
   if(isPrime i)
    then
     if(x `mod` i == 0)
      then
       True
      else
       noHigherPrimes (i+2) x
    else
     noHigherPrimes (i+2) x
  else
   False

isHamming i = ((i `mod` 3 == 0 || i `mod` 5 == 0 || i `mod` 7 == 0) && not (noHigher i) && i `mod` 2 /= 0)

nextHamming i n x = do
 if(n < x)
  then
   if(isHamming i)
    then
     do
      print i
      nextHamming (i+1) (n+1) x
    else
     nextHamming (i+1) n x
  else
   return()

enumHamming x = do
 if(x > 0)
  then
   do
    print 1
    nextHamming 1 1 x
  else
   return()
 return()


