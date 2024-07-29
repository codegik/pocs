# Bin Packing Problem (Minimize number of used Bins)

Given n items of different weights and bins each of capacity c, assign each item to a bin such that number of total used bins is minimized. 
It may be assumed that all items have weights smaller than bin capacity.

### Example:
```
Input:  weight[]       = {4, 8, 1, 4, 2, 1}
        Bin Capacity c = 10
Output: 2
We need minimum 2 bins to accommodate all items
First bin contains {4, 4, 2} and second bin {8, 1, 1}

Input:  weight[]       = {9, 8, 2, 2, 5, 4}
        Bin Capacity c = 10
Output: 3
We need minimum 3 bins to accommodate all items.  

Input:  weight[]       = {2, 5, 4, 7, 1, 3, 8}; 
        Bin Capacity c = 10
Output: 4
```

### Lower bound

We can always find a lower bound on minimum number of bins required. The lower bound can be given as : 
```
   Min no. of bins  >=  Ceil ((Total Weight) / (Bin Capacity))
```

In the above examples, lower bound for first example is `ceil(4 + 8 + 1 + 4 + 2 + 1)/10 = 2` and 
lower bound in second example is `ceil(9 + 8 + 2 + 2 + 5 + 4)/10 = 3`.

### Applications

- Loading of containers like trucks.
- Placing data on multiple disks.
- Job scheduling.
- Packing advertisements in fixed length radio/TV station breaks.
- Storing a large collection of music onto tapes/CD’s, etc.
