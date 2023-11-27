import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static String read(String filepath){
        StringBuilder text = new StringBuilder();
        try(Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNextLine()){
                text.append(scanner.nextLine());
                if (scanner.hasNextLine())
                    text.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
