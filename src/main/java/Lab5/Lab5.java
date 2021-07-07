package Lab5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Lab5 {

    public void writeToFile(String inputFile, String outputFile) throws IOException, URISyntaxException {
        URL resource = Lab5.class.getClassLoader().getResource(inputFile);
        List<String> strings = Files.readAllLines(Paths.get(resource.toURI()));
        Map<Integer, List<Integer>> characters = new TreeMap<>();
        for (int i = 0; i < strings.size(); i++) {
            String line = strings.get(i);
            List<Integer> list = characters.getOrDefault(line.length(), new ArrayList<>());
            list.add(i);
            characters.put(line.length(), list);
        }
        try (FileWriter writer = new FileWriter(new File(outputFile))) {
            for (Map.Entry<Integer, List<Integer>> entry : characters.entrySet()) {
                entry.getValue().forEach(s -> {
                    String string = strings.get(s);
                    try {
                        writer.write(string);
                        writer.write("\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
