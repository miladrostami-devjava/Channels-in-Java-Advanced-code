package ir.memory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;


public class MemoryMappedFileDemo {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\memoryMappedFile-in-java\\src\\main\\resources//largeFile.txt","rw");
            FileChannel fileChannel = file.getChannel()){
            // mapping all the file to memory
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0, fileChannel.size());
            for (int i = 0; i < mappedByteBuffer.limit(); i++) {
                //read file from memory
                System.out.println(mappedByteBuffer.get());
            }
            long newFileChannel = fileChannel.size()+2048;
            fileChannel.truncate(newFileChannel);
            String newData = "this information is new data about big data";
            if (fileChannel.size() > 0){
                mappedByteBuffer.position((int) fileChannel.size());
            }else {
                mappedByteBuffer.position(0);

            }
           // mappedByteBuffer.position((int) (fileChannel.size()-1));
            mappedByteBuffer.put(newData.getBytes(StandardCharsets.UTF_8));
            System.out.println("the write data to file from memory was successfully!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
