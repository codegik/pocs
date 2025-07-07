![img_1.png](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx1_z6L4p6nWrR7ENDdIK9nu2kqHV_5oJ0ikLXYRTtNH4AMxaPagJwzJAMflweJE0qUPE&usqp=CAU)

## Challenge: Minimum cost to process m tasks where switching costs


## Language: C++

## Challenge
There are `n` cores of processor. Each core can process a task at a time. 
Different cores can process different tasks simultaneously without affecting others. 
Suppose, there are `m` tasks in queue and the processor has to process these `m` tasks. 
Again, these `m` tasks are not all of similar type. The type of task is denoted by a number. 
So, `m` tasks are represented as `m` consecutive numbers, same number represents same type of task, like 1 represents task of type 1, 2 for type 2 task and so on.

Initially, all the cores are free. It takes one unit of cost to start a type of task in a core, 
which is currently not running in that core. 
One unit cost will be charged at the starting to start tasks on each core. 

As an example, a core is running type 3 task and if we assign type 3 task again in that core, 
then cost for this assignment will be zero. But, if we assign type 2 task then cost for this assignment will be one unit. 
A core keeps processing a task until next task is assigned to that core.

## Example 1
```
Input : n = 3, m = {1, 2, 1, 3, 4, 1}
Output : 4
```

### Explanation

Here total number of cores are 3. Let, A, B and C.<br/>
First assign task of type 1 in any of the cores -> cost 1 unit.<br/>
States: A – 1, B – None, C – None.<br/>

Assign task of type 2 in any of the rest 2 cores -> cost 1 unit.<br/>
States : A – 1, B – 2, C – None.<br/>

Then assign task of type 1 in that core where task of type 1 is ongoing -> cost 0 unit.<br/>
States : A – 1, B – 2, C – None.<br/>

Assign task of type 3 in the free core -> cost 1 unit.<br/>
States : A – 1, B – 2, C – 3.<br/>

Now, all the cores are running a task. So we have to assign task of type 4 in one of these cores.<br/>
Let’s load it in the core B, where previously type 2 task was going on -> cost 1 unit.<br/>
States: A – 1, B – 4, C – 3.<br/>

Now, load the type 1 task in the core A, where type 1 task is running -> cost 0 unit.<br/>
States: A – 1, B – 4, C – 3.<br/>
Hence, total cost = 1 + 1 + 0 + 1 + 1 + 0 = 4 units.<br/>

## Example 2
```
Input : n = 2, m = {1, 2, 1, 3, 2, 1}
Output : 4
```

### Explanation

Total number of cores are 2. Let A and B.<br/>
First process task of type 1 in any of the cores -> cost 1 unit.<br/>
States: A – 1, B – None.<br/>

Process task of type 2 in any of the rest 2 cores -> cost 1 unit.<br/>
States: A – 1, B – 2.<br/>

Then process task of type 1 in that core where task of type 1 is ongoing -> cost 0 unit.<br/>
States : A – 1, B – 2.fv

Now, let’s assign task of type 3 to core A -> cost 1 unit.<br/>
States : A – 3, B – 2.<br/>

Now, assign type 2 task in core B, where already type 2 task is going on -> cost 0 unit.f
States : A – 3, B – 2.<br/>
Hence, total cost = 1 + 1 + 0 + 1 + 1 = 4 unit.<br/>

Last assign type 1 task in any of the cores(say A) -> cost 1 unit.<br/>
States : A – 1, B – 2.<br/>
Hence, total cost = 1 + 1 + 0 + 1 + 0 + 1 = 4 units.<br/>

## Example 3
```
Input : n = 3, m = {7, 11, 17, 10, 7, 10, 2, 9, 2, 18, 8, 10, 20, 10, 3, 20,
                   17, 17, 17, 1, 15, 10, 8, 3, 3, 18, 13, 2, 10, 10, 11}
Output : 21
```

## Test
```shell
make run
```
