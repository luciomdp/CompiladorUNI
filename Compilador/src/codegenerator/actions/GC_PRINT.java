package codegenerator.actions;

import codegenerator.IAssemblerCode;

public class GC_PRINT implements IAssemblerCode {
    @Override
    public String generateCode(String operandA, String operandB, String variableName, boolean is32BitOperation, String label) {
        StringBuilder sb = new StringBuilder();
        sb.append("     invoke MessageBox, NULL, addr "+operandA+" , addr TitPrint, MB_OK \n");
        return sb.toString();
    }
}

