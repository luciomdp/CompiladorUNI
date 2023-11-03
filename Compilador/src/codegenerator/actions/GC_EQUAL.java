package codegenerator.actions;

import codegenerator.IAssemblerCode;

public class GC_EQUAL implements IAssemblerCode{

    @Override
    public String generateCode(String operandA, String operandB, String variableName, boolean is32BitOperation) {
        StringBuilder sb = new StringBuilder();
        sb.append("MOV eax, "+operandA+"\n");
        sb.append("MOV "+operandB+", eax \n");
        return sb.toString();
    }
    
}