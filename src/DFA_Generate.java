import java.util.HashMap;
import java.util.List;

public class DFA_Generate {
    private  String name;
    private final String type;
    private final Tuple tuple;
    private final List<String> pass_cases;
    private final List<String> fail_cases;

    public DFA_Generate(String name, String type, Tuple tuple, List<String> pass_cases, List<String> fail_cases){
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    @Override
    public String toString() {
        return "DFA_Generate{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", tuple=" + tuple +
                ", pass_cases=" + pass_cases +
                ", fail_cases=" + fail_cases +
                '}';
    }

    public DFA create() {
        return tuple.create();
    }

    public HashMap<String, HashMap<String, Boolean>> runAllTestCases(DFA dfa){
        HashMap<String,HashMap<String,Boolean>> testCases = new HashMap<String,HashMap<String,Boolean>>();
        HashMap<String,Boolean> finalOutputForPassCases = new HashMap<String,Boolean>();
        HashMap<String,Boolean> finalOutputForFailCases = new HashMap<String,Boolean>();

        boolean isAllPassCasesPassed = false, isAllFailCasesPassed = false;
        for(String passCase: this.pass_cases){
            isAllPassCasesPassed = dfa.isInputValueReachedToFinalState(passCase);
            finalOutputForPassCases.put(passCase,isAllPassCasesPassed);
        }
        testCases.put("pass_cases", finalOutputForPassCases);
        for(String failCase: this.fail_cases){
            isAllFailCasesPassed = dfa.isInputValueReachedToFinalState(failCase);
            finalOutputForFailCases.put(failCase,isAllFailCasesPassed);
        }
        testCases.put("fail_cases", finalOutputForFailCases);

        return testCases;
    }
}
