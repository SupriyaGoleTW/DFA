package Main;

import Automata.DFA;
import org.json.JSONException;
import org.json.JSONObject;
import parser.InputParser;

import java.util.ArrayList;
import java.util.HashMap;

public class DFAGenerator{

    public static DFA generate(JSONObject dfaMachineInfo) throws JSONException{
        JSONObject tuple = dfaMachineInfo.getJSONObject("tuple");
        String initialState = (String) tuple.get("start-state");
        ArrayList<String> finalStates = InputParser.getFinalStates(tuple.getJSONArray("final-states"));
        ArrayList<String> alphabets = InputParser.getAlphabets(tuple.getJSONArray("alphabets"));
        HashMap<String, HashMap<String, String>> transitions = InputParser.createTransitionTable(tuple.getJSONObject("delta"));

        DFA dfa = new DFA(transitions, initialState, finalStates);
        return dfa;
    }
}
