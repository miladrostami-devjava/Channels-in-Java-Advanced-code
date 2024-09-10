package com.sg;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ScatterGatherDemo {



        public static void main(String[] args) {
            // Define input and output file paths
            String[] inputFiles = {"C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\Scatter-Gather-IO-in-channels-in-java\\src\\main\\resources\\file1.txt",
                    "C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\Scatter-Gather-IO-in-channels-in-java\\src\\main\\resources\\file2.txt",
                    "C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\Scatter-Gather-IO-in-channels-in-java\\src\\main\\resources\\file3.txt"};

            String outputFile = "C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Channels-in-java\\Scatter-Gather-IO-in-channels-in-java\\src\\main\\resources\\output.txt";


            // List to hold ByteBuffers
            List<ByteBuffer> buffers = new ArrayList<>();

            // Read data from input files and store ByteBuffers
            for (String inputFile : inputFiles) {
                Path inputPath = Paths.get(inputFile);
                try (FileChannel inputChannel = FileChannel.open(inputPath, StandardOpenOption.READ)) {
                    ByteBuffer buffer = ByteBuffer.allocate((int) inputChannel.size());
                    inputChannel.read(buffer);
                    buffer.flip();
                    buffers.add(buffer);
                } catch (IOException e) {
                    System.err.println("Error reading file " + inputFile + ": " + e.getMessage());
                    e.printStackTrace();
                }
            }

            // Write data to the output file using Scatter/Gather I/O
            Path outputPath = Paths.get(outputFile);
            try (FileChannel outputChannel = FileChannel.open(outputPath,
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
                ByteBuffer[] bufferArray = buffers.toArray(new ByteBuffer[0]);
                outputChannel.write( bufferArray);
                System.out.println("Data successfully combined and written to \n" + outputFile);
            } catch (IOException e) {
                System.err.println("Error writing to file " + outputFile + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
