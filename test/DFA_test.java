import Automata.DFA;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DFA_test {
    DFA dfa;

    private HashMap<String, String> createTransition(String alphabet, String possibleReach) {
        HashMap<String, String> transition = new HashMap<>();
        transition.put(alphabet, possibleReach);
        return transition;
    }

    private HashMap<String, HashMap<String, String>> addToTransitionTable(HashMap<String, HashMap<String, String>> transitions, HashMap<String, String> transition, String symbol, String destString, String sourceState) {
        if (transitions.containsKey(sourceState)) {
            transitions.get(sourceState).put(symbol, destString);
        } else
            transitions.put(sourceState, transition);
        return transitions;
    }

    @Before
    public void before() {
        String initialState = "q1";
        String alphabet1 = "A";
        String alphabet2 = "B";
        String firstState = "q1";
        String secondState = "q2";

        ArrayList<String> finalStates = new ArrayList<>();
        finalStates.add("q2");

        HashMap<String, HashMap<String, String>> transitions = new HashMap<>();

        HashMap<String, String> firstTransition = createTransition(alphabet1, firstState);

        transitions = addToTransitionTable(transitions, firstTransition, alphabet1, firstState, firstState);


        HashMap<String, String> secondTransition = createTransition(alphabet2, secondState);
        transitions = addToTransitionTable(transitions, secondTransition, alphabet2, secondState, firstState);

        //transition from state2
        HashMap<String, String> thirdTransition = createTransition(alphabet1, firstState);
        transitions = addToTransitionTable(transitions, thirdTransition, alphabet1, firstState, secondState);

        HashMap<String, String> fourthTransition = createTransition(alphabet2, secondState);
        transitions = addToTransitionTable(transitions, fourthTransition, alphabet2, secondState, secondState);

        dfa = new DFA(transitions, initialState, finalStates);
    }

    @Test
    public void should_pass_string_ending_with_B() {
        boolean result = dfa.isInputValueReachedToFinalState("ABAB");
        assertEquals(result, true);
    }

    @Test
    public void should_not_pass_string_ending_with_A() {
        boolean result = dfa.isInputValueReachedToFinalState("ABABA");
        assertEquals(result, false);
    }
}