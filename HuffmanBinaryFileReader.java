import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class HuffmanBinaryFileReader {

    public static Object[] read(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Map<Character, String> huffmanCodes = (Map<Character, String>) inputStream.readObject();
            String encodedBits = (String) inputStream.readObject();
            return new Object[]{huffmanCodes, encodedBits};
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
