public class FileWriter {

    public static void write(String filename, String text){
        try(java.io.FileWriter fileWriter = new java.io.FileWriter(filename)){
            fileWriter.write(text);
        } catch (java.io.IOException e){
            e.printStackTrace();
        }
    }
}
