package Main;

import Automata.DFA;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import parser.FileReader;
import parser.InputParser;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JSONException, NullPointerException {
        String pathName = "data/" + args[0];
        File fileName = new File(pathName);
        String contents = FileReader.readFileContents(fileName);
        String parsedFileContents = InputParser.parseInput(contents);
        JSONArray dfaCriterias = new JSONArray(parsedFileContents);
        for (int index = 0; index < dfaCriterias.length(); index++) {
            JSONObject dfaMachineInfo = (JSONObject) dfaCriterias.get(index);
            JSONArray passCases = InputParser.getPassCases(dfaMachineInfo);
            JSONArray failCases = InputParser.getFailCases(dfaMachineInfo);
            DFA dfa = DFAGenerator.generate(dfaMachineInfo);
            validateDfa(dfa, passCases, failCases);
        }
    }

    private static void validateDfa(DFA dfa, JSONArray passCases, JSONArray failCases) {
        for (int index = 0; index < passCases.length(); index++) {
            boolean passCasesInput = dfa.isInputValueReachedToFinalState((String) passCases.get(index));
            System.out.println("pass cases: input " + passCases.get(index) + " :"+ passCasesInput);
        }
        for (int index = 0; index < failCases.length(); index++) {
            boolean failCasesInput = dfa.isInputValueReachedToFinalState((String) failCases.get(index));
            System.out.println("fail cases: input " + failCases.get(index) + " :"+ failCasesInput);
        }
    }
}
