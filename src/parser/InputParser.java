package parser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class InputParser {
    private static Object passCases;

    public static String parseInput(String criterias) {
        if (criterias.startsWith("\"") && criterias.endsWith("\""))
            criterias = criterias.substring(1, criterias.length() - 1);
        return criterias.replace("\\", "");
    }

    public static ArrayList<String> getFinalStates(JSONArray finalStates) {
        ArrayList<String> allFinalStates = new ArrayList<>();
        for (int index = 0; index < finalStates.length(); index++) {
            String state = (String) finalStates.get(index);
            allFinalStates.add(state);
        }
        return allFinalStates;
    }

    public static ArrayList<String> getAlphabets(JSONArray alphabets) {
        ArrayList<String> allAlphabets = new ArrayList<>();
        for (int index = 0; index < alphabets.length(); index++) {
            allAlphabets.add((String) alphabets.get(index));
        }
        return allAlphabets;
    }

    public static HashMap<String, HashMap<String, String>> createTransitionTable(JSONObject delta) {
        Iterator keys = delta.keys();
        HashMap<String, HashMap<String, String>> allTransitions = new HashMap<>();
        while (keys.hasNext()) {
            Object state = keys.next();
            String transition = delta.get(state.toString()).toString();
            HashMap<String, String> aTransition = crateATransition(transition);
            allTransitions.put(state.toString(), aTransition);
        }
        return allTransitions;
    }

    private static HashMap<String, String> crateATransition(String transition) {
        HashMap<String, String> transitionsMap = new HashMap<>();
        String[] waysForAlphabet = transition.split(",");
        for (int index = 0; index < waysForAlphabet.length; index++) {
            String transition1 = waysForAlphabet[index].replace("{", "").replace("}", "").replace("\"", "");
            String[] letterAndState = transition1.split(":");
            transitionsMap.put(letterAndState[0], letterAndState[1]);
        }
        return transitionsMap;
    }

    public static JSONArray getPassCases(JSONObject dfaMachineInfo) {
        JSONArray pass_cases = dfaMachineInfo.getJSONArray("pass-cases");
        return pass_cases;
    }

    public static JSONArray getFailCases(JSONObject dfaMachineInfo) {
        JSONArray fail_cases = dfaMachineInfo.getJSONArray("fail-cases");
        return fail_cases;
    }
}
