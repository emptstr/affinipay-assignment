### Problem Solving Approach
 
 This document provides a concise summary of the things I took into consideration while
 solving this problem. 
 
 -  The input and output is date agnostic.  We only need to keep track of the number of minutes
 that have elapsed since midnight.
 - Temporal objects are usually represented as epoch instants.  This approach provides
 extensibility and interoperability, but adds complexity.  A simple change can 
 be made to ```Time``` object if this requirement arises in the future.  We can safely omit it for now.
 - This implementation couples the formatter to the Time object. If we were designing a more
 generic temporal framework, we could invert this dependency using a ```TemporalObject``` interface to allow the reuse of the
 formatter. ex:
 ```java
public class TimeFormatter { 
    public String format(TemporalObject obj) {
      ...
    }
   ...
}
```
 - Throwing an ```IllegalArgumentException``` from the ```TimeFormatter``` doesn't clearly communicate the failure mode.  A more specific ```TimeFormatException``` would be better. I've omitted it
  here for
  brevity.
  

  
  