package ir.filelock;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileLockDemo {

    public static void main(String[] args) {

        Path filePath = Paths.get("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\fileLock-in-java\\src\\main\\resources\\filelock.txt");

        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.WRITE,
                StandardOpenOption.APPEND) ;
              ){
            FileLock  fileLock = fileChannel.lock();

            try{
                String logMessage = "Logging message have some important information...";
                ByteBuffer buffer = ByteBuffer.wrap(logMessage.getBytes());
                fileChannel.write(buffer);
                System.out.println("written data in file was successfully");
            }finally {
                fileLock.release();
                System.out.println("file is unLock for other processing and or threading for writable or readable!!!");

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
