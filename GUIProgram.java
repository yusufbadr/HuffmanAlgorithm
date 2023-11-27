import java.util.Map;

public class GUIProgram {

    public static void main(String[] args) {
        Object[] pair = HuffmanEncode.encode("this is a test string");
        // first object is encodedBits, second is the map of huffman codes Map<Character, String>
        String encodedBits = (String) pair[0];
        Map<Character, String> huffmanCodes = (Map<Character, String>) pair[1];

        System.out.println(encodedBits);
        System.out.println("--");
        System.out.println(huffmanCodes);

    }





}
