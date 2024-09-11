# Transferring Bytes Among Channels in java
Application scenario: copying a large file
Suppose you need to copy a large file in a project 
and you want to do it optimally. 
You can use the transferTo or transferFrom method to directly 
transfer data between two channels, without having to manually 
read and write the data into the buffer.
