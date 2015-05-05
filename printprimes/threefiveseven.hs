hasFactor i = (i `mod` 3 == 0 || i `mod` 5 == 0 || i `mod` 7 == 0)

nextNone i n x = do
 if(n < x)
  then
   if(hasFactor i)
    then
     do
      print i
      nextNone (i+1) (n+1) x
    else
     nextNone (i+1) n x
  else
   return()

enumerate x = do
 nextNone 1 0 x
 return()
