package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException {
        // Get the directory path of the file
        String fileDirectory = file.getParent();

        // Open input and output streams
        FileInputStream fis = new FileInputStream(file);

        // Create GZIPInputStream to decompress the file
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile");

        // Buffer to hold data while reading from GZIPInputStream
        byte[] buffer = new byte[1024];
        int len;

        // Read data from the GZIPInputStream and write it to the output file
        while ((len = gzip.read(buffer)) != -1) { // Read from gzip instead of fis
            fos.write(buffer, 0, len);
        }

        // Close streams
        gzip.close();
        fos.close();
        fis.close();
    }

    // Main method to test decompression
    public static void main(String[] args) throws IOException {
        // Specify the file path to decompress
        File path = new File("C:/Users/katre/Downloads/Compressor/compressordecompressor/CompressedFile.gz");
        method(path);
    }
}
