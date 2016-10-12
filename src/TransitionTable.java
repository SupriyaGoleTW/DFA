import java.util.HashMap;

public class TransitionTable {

    HashMap<String, HashMap<String,State>> transitionsMap;

    public TransitionTable() {
        this.transitionsMap = new HashMap<>();
    }


    public HashMap<String, HashMap<String, State>> addTransitions(State state, String alphabet, State nextState) {
        HashMap<String, State> mappingOfLetterToState = this.transitionsMap.get(state.getState()); // hashmap so only one key is there so one state as key will contain array of transitions
        if(mappingOfLetterToState == null) mappingOfLetterToState = new HashMap<>();

        mappingOfLetterToState.put(alphabet,nextState);
        this.transitionsMap.put(state.getState(),mappingOfLetterToState);
        return this.transitionsMap;
    }

    public State getNextState(HashMap<String, HashMap<String, State>> transitions, State currentState, String letter) {
        HashMap<String, State> transitionForState = transitions.get(currentState.getState());
        State nextState = transitionForState.get(letter);
        return nextState;
    }
}
