// Import required packages
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

// Class for compression
public class compressor {
    public static void method(File file) throws IOException {
        // Get the directory path of the file
        String fileDirectory = file.getParent();

        // Open input and output streams
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gz");

        // Create GZIPOutputStream to compress the file
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        // Buffer to hold data while reading from input stream
        byte[] buffer = new byte[1024];
        int len;

        // Read data from the file and write it to the GZIPOutputStream
        while ((len = fis.read(buffer)) != -1) {
            gzip.write(buffer, 0, len);
        }

        // Close streams
        gzip.close();
        fos.close();
        fis.close();
    }

    // Main method to test compression
    public static void main(String[] args) throws IOException {
        // Specify the file path to compress
        File path = new File("C:/Users/katre/Downloads/Compressor/compressordecompressor/venky1.txt");
        method(path);
    }
}