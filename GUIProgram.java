import javax.swing.*;
import java.util.Map;

public class GUIProgram {

    public static void main(String[] args) {
//        Object[] pair = HuffmanEncode.encode("this is a test string");
//        // first object is encodedBits, second is the map of huffman codes Map<Character, String>
//        Map<Character, String> huffmanCodes = (Map<Character, String>) pair[0];
//        String encodedBits = (String) pair[1];
//
//        System.out.println(encodedBits);
//        System.out.println("--");
//        System.out.println(huffmanCodes);
//
//        HuffmanBinaryFileWriter.write("output.dat", huffmanCodes,encodedBits);
//        StringBuilder decodedText = HuffmanDecode.decode(huffmanCodes,encodedBits);
//        System.out.println(decodedText);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Appview gui = new Appview();
                gui.setVisible(true);
            }
        });
    }
}
