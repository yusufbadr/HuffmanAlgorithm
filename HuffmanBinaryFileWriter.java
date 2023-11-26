
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class HuffmanBinaryFileWriter {
    public void write(String filename, Map<Character, String> huffmanCodes, String encodedBits){
        try(ObjectOutputStream outputStream = new ObjectOutputStream((new FileOutputStream(filename)))){
            outputStream.writeObject(huffmanCodes);
            outputStream.writeObject(encodedBits);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
