package com.copy;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CopyFileChannelDemo {
    public static void main(String[] args) {

//        String sourcePath = "C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\copythecontentofonefiletoanotherfile-chanells-in-java\\src\\main\\resources\\source.txt";
//        String destinationPath = "C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\copythecontentofonefiletoanotherfile-chanells-in-java\\src\\main\\resources\\destination.txt";

        Path    sourcePath = Paths.get("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\copythecontentofonefiletoanotherfile-chanells-in-java\\src\\main\\resources\\source.txt");
        Path destinationPath = Paths.get("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\copythecontentofonefiletoanotherfile-chanells-in-java\\src\\main\\resources\\destination.txt");

        try(FileChannel inputChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
        FileChannel outputChannel = FileChannel.open(destinationPath,StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING)){
            ByteBuffer buffer = ByteBuffer.allocate(1024);
           while ( inputChannel.read(buffer) > 0){
               buffer.flip();
               outputChannel.write(buffer);
               buffer.clear();
           }
            System.out.println("copy process was successfully!!!");


                    } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
