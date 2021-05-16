# Interview-Assignment
Interview-Assignment

Extend ArrayList this way:

1. it should not allow inserting a value (including null), that already exists in the list

2. if there is a size limit, inserting next value will remove the first item from the list, and put the new one at the end

3. if it is not possible to insert new value (any reason) - throw custom exception

4. make this class further non-extendable

5. make it thread-safe (with exception described in point 6)

6. after any insert attempt, wait random period (0.01-0.05s) - this part should not be thread safe. So multiple threads can wait here at the same time.
 Then use this class in multiple threads - your choice how.

For points 1-3 it's required to create also unit tests, but the implementation of the functionality is of course more important.

Points are sorted based on the priority (1 - most important, 6 - least important). That means if a less important point is not implemented or not working, it's better than not having a more important.

 

write optimised code, with java coding standards followed.
