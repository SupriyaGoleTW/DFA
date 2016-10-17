import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Tuple{

    private final List<String> states;
    private final List<String> alphabets;
    private final String start_state;
    private final Set<String> final_states;
    private final HashMap<String, HashMap<String, String>> delta;

    public Tuple(List<String> states, List<String> alphabets, HashMap<String,HashMap<String,String>> delta, String start_state, Set<String> final_states) {

        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.start_state = start_state;
        this.final_states = final_states;
    }


    @Override
    public String toString() {
        return "Tuple{" +
                "states=" + states +
                ", alphabets=" + alphabets +
                ", delta=" + delta +
                ", start_state=" + start_state +
                ", final_states=" + final_states +
                '}';
    }

    public DFA create(){
        return new DFA(delta,start_state,final_states);
    }
}
