package Lab5;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Lab5Test {

    @Test
    public void shouldWriteToFileInOrder() throws IOException, URISyntaxException {
        Lab5 lab5 = new Lab5();
        lab5.writeToFile("example.txt", "output.txt");
        List<String> lines = Files.readAllLines(Paths.get("output.txt"));
        boolean isInOrder = true;
        int sizeOfPrevString = Integer.MIN_VALUE;
        for (int i = 0; i < lines.size(); i++) {
            int lineSize = lines.get(i).length();
            if (sizeOfPrevString > lineSize) {
                isInOrder = false;
                break;
            }
            sizeOfPrevString = lineSize;
        }
        assertTrue(isInOrder);
    }
}
