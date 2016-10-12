import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TransitionTableTest {
    HashMap<String, HashMap<String, State>> transitions;
    TransitionTable transitionTable;
    State q1;
    State q2;
    @Before
    public void beforeEach(){
        q1 = new State("q1");
        q2 = new State("q2");
        transitionTable = new TransitionTable();
        transitionTable.addTransitions(q1,"A",q2);
        transitions = transitionTable.addTransitions(q1, "B", q2);
    }

    @Test
    public void shouldAddTransitionsToTransitionTable(){
        assertEquals(transitions.size(),1);
        transitionTable.addTransitions(q2,"B",q2);
        assertEquals(transitions.size(),2);
        assertEquals(transitions.containsKey("q1"),true);
        assertEquals(transitions.containsKey("q2"),true);
        assertEquals(transitions.containsKey("q3"),false);
    }

    @Test
    public void shouldReturnNextStateFromCurrentState(){
        State nextState = transitionTable.getNextState(transitions, q1, "A");
        assertEquals(nextState,q2);
    }

}