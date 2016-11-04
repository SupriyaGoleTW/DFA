package Objects;

import java.util.HashMap;

public class Transitions {
    HashMap<State, HashMap<String,State>> transitionsMap;
    public Transitions(){
        this.transitionsMap = new HashMap<>();
    }

    public void add(State currentState, String letter, State nextState){
        if(transitionsMap.containsKey(currentState)){
            transitionsMap.get(currentState).put(letter,nextState);
        }else{
            HashMap<String, State> transition = new HashMap<>();
            transition.put(letter,nextState);
            transitionsMap.put(currentState,transition);
        }
    }

    public State transit(State currentState, String letter) {
        return transitionsMap.get(currentState).get(letter);
    }
}
