### Problem Solving Approach
 
 This document provides a concise summary of the things I took into consideration while
 solving this problem. 
 
 -  The input and output is date agnostic.  We only need to keep track of the number of minutes
 that have elapsed since midnight.
 - Temporal objects are usually represented as epoch instants.  This approach provides
 extensibility and iteroperabilty, but adds signifigant complexity.  An additional layer can 
 be built under the ```Time``` object if this requirement were to arise in the future.  We can safely omit it for now.
 - This implementation couples the formatter to the Time object. If we were designing a more
 generic temporal framework, we could invert this dependency using a ```TemporalObject``` interface to allow the reuse of the
 formatter.
 - Throwing an ```IllegalArgumentException``` from the ```TimeFormatter```  is suboptimal.  A more specific ```TimeFormatException``` better communicates the failure mode. I've omitted it here for
  brevity.
  

  
  