package Main;

import Automata.DFA;
import Objects.State;
import Objects.States;
import Objects.Transitions;
import org.json.JSONException;
import org.json.JSONObject;
import parser.InputParser;

public class DFAGenerator{

    public static DFA generate(JSONObject dfaMachineInfo) throws JSONException{
        JSONObject tuple = dfaMachineInfo.getJSONObject("tuple");
        State initialState = new State((String) tuple.get("start-state"));
        States finalStates = InputParser.getFinalStates(tuple.getJSONArray("final-states"));
        Transitions transitions = InputParser.createTransitionTable(tuple.getJSONObject("delta"));

        DFA dfa = new DFA(transitions, initialState, finalStates);
        return dfa;
    }
}
