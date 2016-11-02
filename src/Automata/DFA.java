package Automata;/*
 Role of class:-
    this class will say weather string has successfully met all required criteria.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class DFA {

    private HashMap<String, HashMap<String, String>> transitions;
    private final String initialState;
    private final ArrayList<String> finalStates;

    public DFA(HashMap<String, HashMap<String, String>> transitions, String initialState, ArrayList<String> finalStates) {
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    public boolean isInputValueReachedToFinalState(String value) { // todo
        String[] character = value.split("");
        String currentState = initialState;
        for(int index=0;index<character.length;index++){
            String letter = character[index];
            currentState = getNextState(currentState,letter);
        }
        return isMachineInAFinalState(currentState);
    }

    private boolean isMachineInAFinalState(String state) {
        return finalStates.contains(state);
    }

    private String getNextState(String currentState, String letter){
        return transitions.get(currentState).get(letter);
    }
}
