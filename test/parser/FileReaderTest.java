package parser;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {
    @Test
    public void should_read_provided_file_contents() throws IOException, NoSuchFileException {
        File file = new File("data/sample.json");
        String fileContents = FileReader.readFileContents(new File(file.getAbsolutePath()));
        assertEquals(fileContents.length(),384);
    }
}