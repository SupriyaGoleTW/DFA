import com.google.gson.Gson;

import java.util.HashMap;

public class DFA_input {

    private DFA_Generate dfaInput;

    public DFA_input(String sampleDFAInput) {
        this.dfaInput = new Gson().fromJson(sampleDFAInput.toString(), DFA_Generate.class);
    }

    @Override
    public String toString() {
        return "DFA_input{" +
                "dfaInput=" + dfaInput +
                '}';
    }

    public DFA generateDFA() {
        return this.dfaInput.create();
    }

    public HashMap<String, HashMap<String, Boolean>> runAllTestCases(DFA dfa) {
        return this.dfaInput.runAllTestCases(dfa);
    }
}
