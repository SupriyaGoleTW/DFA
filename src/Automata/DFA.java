package Automata;/*
 Role of class:-
    this class will say weather string has successfully met all required criteria.
*/

import Objects.State;
import Objects.States;
import Objects.Transitions;

public class DFA {

    private Transitions transitions;
    private final State initialState;
    private final States finalStates;

    public DFA(Transitions transitions, State initialState, States finalStates) {
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    public boolean isInputValueReachedToFinalState(String value) {
        String[] character = value.split("");
        State currentState = initialState;
        for(int index=0;index<character.length;index++){
            String letter = character[index];
            currentState = getNextState(currentState,letter);
        }
        return isMachineInAFinalState(currentState);
    }

    private boolean isMachineInAFinalState(State state) {
        return finalStates.contains(state);
    }

    private State getNextState(State currentState, String letter){
        return transitions.transit(currentState,letter);
    }
}
