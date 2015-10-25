import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
public class ShortenedForgottenLines {
    private static String fileLocation = new String();
    public static void main(String[] args) throws IOException {
        // Set file location
        fileLocation = "macbeth.txt";
        String fullString = new String(Files.readAllBytes(Paths.get(fileLocation)));
        String[] lineBlocks = fullString.split("\r\n\r\n");
        String[] partialLines = new String[2];
        partialLines[0] = "break this enterprise";
        partialLines[1] = "Yet who would have thought";
        for(String partial : partialLines){
            System.out.println("From the input of: " + partial);
            for(String block : lineBlocks){
                if(block.contains(partial))
                    System.out.println(block);
            }
        }
    }
}
