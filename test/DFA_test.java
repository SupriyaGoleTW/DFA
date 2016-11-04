import Automata.DFA;
import Objects.State;
import Objects.States;
import Objects.Transitions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DFA_test {
    DFA dfa;

    @Before
    public void before() {
        State initialState = new State("q1");

        String alphabet1 = "A";
        String alphabet2 = "B";

        State firstState = new State("q1");
        State secondState = new State("q2");

        States finalStates = new States();
        finalStates.add(secondState);

        Transitions transitions = new Transitions();
        transitions.add(firstState,alphabet1,firstState);
        transitions.add(firstState,alphabet2,secondState);
        transitions.add(secondState,alphabet2,secondState);
        transitions.add(secondState,alphabet1,firstState);

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