import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DFA_test {
    DFA dfa;
    @Before
    public void before(){
        State initialState = new State("q1");

        // set of states
        State q1 = new State("q1");
        State q2 = new State("q2");

        //set of alphabets
        String alphabet1 = "A";
        String alphabet2 = "B";

        //set of final states
        Set<State> finalStates = new HashSet<>();
        finalStates.add(q2);

        // transition table
        TransitionTable transitionTable = new TransitionTable();
        transitionTable.addTransitions(q1, alphabet1, q2);
        transitionTable.addTransitions(q1, alphabet2, q2);
        transitionTable.addTransitions(q2, alphabet1, q1);
        HashMap<String, HashMap<String, State>> transitions = transitionTable.addTransitions(q2, alphabet2, q2);

        dfa = new DFA(transitions, initialState, finalStates);
    }

    @Test
    public void shouldPassStringEndingWithB(){
        boolean result = dfa.isInputValueReachedToFinalState("ABAB");
        assertEquals(result,true);
    }

    @Test
    public void shouldNotPassStringEndingWithA(){
        boolean result = dfa.isInputValueReachedToFinalState("ABABA");
        assertEquals(result,false);
    }
}
