package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import comp_decomp.compressor;
import comp_decomp.decompressor;

// Frame class for the application
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    // Constructor
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // Set layout to null
        this.setTitle("Compressor-Decompressor");

        // Create heading label
        JLabel headingLabel = new JLabel("Compressor-Decompressor");
        headingLabel.setBounds(250, 20, 300, 30);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Create buttons for compression and decompression
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(200, 300, 200, 30);
        compressButton.addActionListener(this);
        compressButton.setBackground(Color.LIGHT_GRAY);
        compressButton.setForeground(Color.BLACK);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(450, 300, 200, 30);
        decompressButton.addActionListener(this);
        compressButton.setBackground(Color.LIGHT_GRAY);
        compressButton.setForeground(Color.BLACK);

        // Set background color for the frame
        this.getContentPane().setBackground(new Color(220, 240, 220));

        this.add(headingLabel);

        // Add buttons to the content pane
        this.getContentPane().add(compressButton);
        this.getContentPane().add(decompressButton);

        this.setSize(800, 400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            // Show file chooser dialog for selecting file to compress
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    // Call the compression method
                    compressor.method(file);
                    // Show success message dialog
                    JOptionPane.showMessageDialog(null, "File compressed successfully!",
                            "Compression Success", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception ee){
                    // Show error message dialog
                    JOptionPane.showMessageDialog(null, "Error compressing file: " + ee.toString(),
                            "Compression Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if(e.getSource() == decompressButton){
            // Show file chooser dialog for selecting file to decompress
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    // Call the decompression method
                    decompressor.method(file);
                    // Show success message dialog
                    JOptionPane.showMessageDialog(null, "File decompressed successfully!",
                            "Decompression Success", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception ee){
                    // Show error message dialog
                    JOptionPane.showMessageDialog(null, "Error decompressing file: " + ee.toString(),
                            "Decompression Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
