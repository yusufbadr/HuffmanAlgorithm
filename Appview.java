import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

public class Appview extends JFrame{
    private JTextArea textArea;
    private JButton browseButton, compressButton, decompressButton;
    private File selectedFile;
    private String filePath;

    public Appview() {
        setTitle("Huffman Compression GUI");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        browseButton = new JButton("Browse");
        compressButton = new JButton("Compress");
        decompressButton = new JButton("Decompress");

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filePath = chooseFile();
            }
        });

        compressButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                compressFile();

            }
        });

        decompressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decompressFile();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(browseButton);
        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private String  chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            textArea.setText("Selected file: " + selectedFile.getAbsolutePath());
            return selectedFile.getAbsolutePath();
        }
        else {
            textArea.setText("No file selected!");
            return null;
        }
    }
    private void compressFile() {
        String rawText = FileReader.read(filePath);
        //HashMap<Character, Integer> frequencyMap = HuffmanEncode.buildFrequencyMap(rawText);
        Object[] mapAndEncodedBits = HuffmanEncode.encode(rawText);
        HashMap<Character, String> huffmanCodes = (HashMap<Character, String>) mapAndEncodedBits[0];
        String encodedBits = (String) mapAndEncodedBits[1];
        HuffmanBinaryFileWriter.write("output.dat", huffmanCodes, encodedBits);
        textArea.setText(encodedBits);
        textArea.append("\n" + huffmanCodes.toString());

    }
    public void decompressFile() {
        Object[] mapAndEncodedBits = HuffmanBinaryFileReader.read("output.dat");
        HashMap<Character, String> huffmanCodes = (HashMap<Character, String>) mapAndEncodedBits[0];
        String encodedBits = (String) mapAndEncodedBits[1];
        StringBuilder decodedText = HuffmanDecode.decode(huffmanCodes, encodedBits);
        textArea.setText(decodedText.toString());
    }
}
