package ir.transfer;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileTransferDemo {
        public static void main(String[] args) {
            Path sourcePath =
                    Path.of("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\fileTransfer-in-java\\src\\main\\resources\\sourceFile.txt");
            Path destinationPath =
                    Path.of("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\fileTransfer-in-java\\src\\main\\resources\\destinationFile.txt");

            // Check if source file exists before attempting transfer
            if (!Files.exists(sourcePath)) {
                System.err.println("Source file does not exist: " + sourcePath);
                return;
            }

            // Perform the file transfer using try-with-resources
            try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
                 FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {

                // Transfer data from source to destination
                long transferredBytes = sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);

                System.out.println("File transfer completed successfully! Transferred bytes: " + transferredBytes);

            } catch (IOException e) {
                System.err.println("An error occurred during the file transfer:");
                e.printStackTrace();
            }
        }
    }
