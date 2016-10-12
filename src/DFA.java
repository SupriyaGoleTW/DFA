/*
 Role of class:-
    this class will say weather string has successfully met all required criteria.
*/

import java.util.HashMap;
import java.util.Set;

public class DFA {

    private HashMap<String, HashMap<String, State>> transitions;
    private final State initialState;
    private final Set<State> finalStates;
    TransitionTable transition = new TransitionTable();

    public DFA(HashMap<String, HashMap<String, State>> transitions, State initialState, Set<State> finalStates) {
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    public boolean isInputValueReachedToFinalState(String value) {
        String[] character = value.split("");
        State currentState = initialState;
        for(int index=0;index<character.length;index++){
            String letter = character[index];
            currentState = transition.getNextState(this.transitions, currentState,letter);
        }
        return isMachineInAFinalState(currentState);
    }

    private boolean isMachineInAFinalState(State state) {
        return finalStates.contains(state);
    }
}
