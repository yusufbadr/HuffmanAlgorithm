import java.util.Map;

public class HuffmanDecode {

    public StringBuilder decode(Map<Character, String>huffmanCodes, String encodedBits){

        StringBuilder decodedText = new StringBuilder();
        StringBuilder currentBits = new StringBuilder();
        for (int i = 0; i < encodedBits.length(); i++) {
            currentBits.append(encodedBits.charAt(i));
            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                if (entry.getValue().equals(currentBits.toString())) {
                    decodedText.append(entry.getKey());
                    currentBits = new StringBuilder();
                }
            }
        }
        return decodedText;
    }
}
