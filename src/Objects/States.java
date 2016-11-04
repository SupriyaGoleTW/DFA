package Objects;

import java.util.HashSet;

public class States {
    HashSet<State> states;
    public States(){
        this.states = new HashSet<>();
    }

    public void add(State state) {
        this.states.add(state);
    }

    public boolean contains(State state) {
        return this.states.contains(state);
    }
}
