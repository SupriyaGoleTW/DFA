package parser;

import Objects.State;
import Objects.States;
import Objects.Transitions;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class InputParser {

    public static String parseInput(String criterias) {
        if (criterias.startsWith("\"") && criterias.endsWith("\""))
            criterias = criterias.substring(1, criterias.length() - 1);
        return criterias.replace("\\", "");
    }

    public static States getFinalStates(JSONArray finalStates) {
        States states = new States();
        for (int index = 0; index < finalStates.length(); index++) {
            State state = new State((String) finalStates.get(index));
            states.add(state);
        }
        return states;
    }

    public static ArrayList<String> getAlphabets(JSONArray alphabets) {
        ArrayList<String> allAlphabets = new ArrayList<>();
        for (int index = 0; index < alphabets.length(); index++) {
            allAlphabets.add((String) alphabets.get(index));
        }
        return allAlphabets;
    }

    public static Transitions createTransitionTable(JSONObject delta) {
        Iterator keys = delta.keys();
        Transitions transitions = new Transitions();
        while (keys.hasNext()) {
            State state = new State((String) keys.next());
            String transition = delta.get(state.toString()).toString();
            addATransition(state, transition,transitions);
        }
        return transitions;
    }

    private static void addATransition(State state, String transition, Transitions transitions) {
        String[] splittedTransition = transition.split(",");
        for (String aWaysForAlphabet : splittedTransition) {
            String transition1 = aWaysForAlphabet.replace("{", "").replace("}", "").replace("\"", "");
            String[] letterAndState = transition1.split(":");
            transitions.add(state, letterAndState[0], new State(letterAndState[1]));
        }
    }

    public static JSONArray getPassCases(JSONObject dfaMachineInfo) {
        return dfaMachineInfo.getJSONArray("pass-cases");
    }

    public static JSONArray getFailCases(JSONObject dfaMachineInfo) {
        return dfaMachineInfo.getJSONArray("fail-cases");
    }
}
