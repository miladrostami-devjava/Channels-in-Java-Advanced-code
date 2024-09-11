# Memory Mapped File in java use MappedByteBuffer
Application scenario: Fast reading and writing of a large file
Suppose you have a large log file that you want to access quickly,
for example read or write part of it without having to load
the entire file into memory. This method is very useful for
accessing very large files that require fast processing.