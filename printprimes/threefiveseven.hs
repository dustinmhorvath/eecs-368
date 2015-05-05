isPrime k = null [ x | x <- [2..k - 1], k `mod`x  == 0]

hasFactor i = (i `mod` 3 == 0 || i `mod` 5 == 0 || i `mod` 7 == 0)

next357 i n x = do
 if(n < x)
  then
   if(hasFactor i)
    then
     do
      print i
      next357 (i+1) (n+1) x
    else
     next357 (i+1) n x
  else
   return()

enumerate x = do
 next357 1 0 x
 return()

isHamming i = ((i `mod` 2 == 0 || i `mod` 3 == 0 || i `mod` 5 == 0 ))

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
