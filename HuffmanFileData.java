import java.util.Map;

public class HuffmanFileData {

        private static Map<Character, String> huffmanCodes;
        private static String encodedBits;

        public HuffmanFileData(Map<Character, String> huffmanCodes, String encodedBits) {
            this.huffmanCodes = huffmanCodes;
            this.encodedBits = encodedBits;
        }

        public static Map<Character, String> getHuffmanCodes() {
            return huffmanCodes;
        }

        public static String getEncodedBits() {
            return encodedBits;
        }
}
