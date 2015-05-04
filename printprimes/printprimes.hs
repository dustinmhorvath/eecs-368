
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
