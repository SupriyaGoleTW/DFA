import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DFA_input_test {
    @Test
    public void shouldGenerateDFAInputInSpecificFormat(){
        String sampleDFAInput = "{'name': 'odd number of zeroes'," +
                "'type': 'dfa'," +
                "'tuple': {'states':['q1','q2'], 'alphabets':['1','0'], 'delta':{'q1':{'0':'q2','1':'q1'},'q2':{'0':'q1','1':'q2'}}," +
                "'start_state':'q1'," +
                "'final_states':['q2']}," +
                "'pass_cases':['0','000','00000','10','101010','010101']," +
                "'fail_cases':['00','0000','1001','1010','001100']}";


        DFA_input dfa_input = new DFA_input(sampleDFAInput);

        DFA dfa = dfa_input.generateDFA();
        HashMap<String, HashMap<String, Boolean>> expectedOutput = dfa_input.runAllTestCases(dfa);

        HashMap<String, Boolean> pass_cases = expectedOutput.get("pass_cases");
        HashMap<String, Boolean> fail_cases = expectedOutput.get("fail_cases");

        Object[] passCasesKeySet = pass_cases.keySet().toArray();
        Object[] failCasesKeySet = fail_cases.keySet().toArray();

        for(int index=0;index<passCasesKeySet.length;index++){
            assertEquals(pass_cases.get(passCasesKeySet[index]),true);
        }

        for(int index=0;index<failCasesKeySet.length;index++){
            assertEquals(fail_cases.get(failCasesKeySet[index]),false);
        }
    }
}