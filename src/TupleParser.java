import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TupleParser {
    public TupleParser() throws IOException {
    }


    public void readTuple(String fileContents) {

    }

    public String getFileContents(String fileName) throws IOException {
        BufferedReader br;
        String sCurrentLine = "";

        br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();

        while ( line != null) {
            sCurrentLine+=line;
            line = br.readLine();
        }
        return sCurrentLine;

    }
}

