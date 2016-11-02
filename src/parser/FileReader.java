package parser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class FileReader {
    public static String readFileContents(File fileName) throws IOException {
        List<String> fileContents = Files.readAllLines(fileName.toPath(), Charset.defaultCharset());
        return fileContents.get(0);
    }
}
