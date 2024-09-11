# FileLock in java NIO
Suppose you have an application where several users 
have simultaneous access to a file and want to write or 
read from it. In such a situation, it is possible to create
inconsistencies in the data. To avoid this problem, you can use the 
FileLock locking mechanism to ensure that only one user has access to 
the file at a time, or that read operations are performed synchronously.