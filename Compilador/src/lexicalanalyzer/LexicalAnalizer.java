package lexicalanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import lexicalanalyzer.semanticactions.SAParam;
import lexicalanalyzer.semanticactions.sa.SA_1;
import lexicalanalyzer.semanticactions.sa.SA_10;
import lexicalanalyzer.semanticactions.sa.SA_11;
import lexicalanalyzer.semanticactions.sa.SA_12;
import lexicalanalyzer.semanticactions.sa.SA_13;
import lexicalanalyzer.semanticactions.sa.SA_14;
import lexicalanalyzer.semanticactions.sa.SA_15;
import lexicalanalyzer.semanticactions.sa.SA_16;
import lexicalanalyzer.semanticactions.sa.SA_17;
import lexicalanalyzer.semanticactions.sa.SA_2;
import lexicalanalyzer.semanticactions.sa.SA_3;
import lexicalanalyzer.semanticactions.sa.SA_4;
import lexicalanalyzer.semanticactions.sa.SA_5;
import lexicalanalyzer.semanticactions.sa.SA_6;
import lexicalanalyzer.semanticactions.sa.SA_7;
import lexicalanalyzer.semanticactions.sa.SA_8;
import lexicalanalyzer.semanticactions.sa.SA_9;
import lexicalanalyzer.semanticactions.ISemanticAction;
import objects.ConfigurationParams;
import objects.enums.ECharacterType;
import objects.enums.ELexicalAnalizerState;
public class LexicalAnalizer {

    private final int stateTable [][] = {
        {1, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, 7, 6, 0, 0, 0, 3, 5, 1, -1, 1, -1},
        {1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1},
        {-1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
        {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, -1, 4, 4, 4, -1, 4, 4},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 8, 8, 8, 8, 8, 8, -1, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, -1, 8, 8, 8, 8, 8, 8, -1, 8, 8}
    };

    private final ISemanticAction semanticActionsTable [][] = {
        {new SA_3(), new SA_3(),new SA_3(),new SA_5(),new SA_5(),new SA_5(),new SA_5(),new SA_5(),new SA_5(),new SA_5(),new SA_5(),new SA_5(),new SA_3(),new SA_3(),null,null,null,null,new SA_3(),new SA_3(),new SA_15(), new SA_3(), new SA_16()},
        {new SA_2(), new SA_2(),new SA_2(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_1(),new SA_2(),new SA_1(), new SA_2(), new SA_1()},
        {new SA_4(), new SA_4(), new SA_3(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(), new SA_4(),new SA_4(), new SA_4(), new SA_4()},
        {new SA_6(), new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(),new SA_6(), null,new SA_6(),new SA_6(),new SA_6(), new SA_6(), new SA_6()},
        {null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null, null, null, null},
        {new SA_14(), new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(),new SA_14(), new SA_14(), new SA_14()},
        {new SA_8(), new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_7(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(),new SA_8(), new SA_8(), new SA_8()},
        {new SA_9(), new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_10(),new SA_11(),new SA_10(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(),new SA_9(), new SA_9(), new SA_9()},
        {new SA_12(), new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),null,new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(),new SA_12(), new SA_12(), new SA_12()},
        {new SA_13(), new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_17(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(),new SA_13(), new SA_13(), new SA_13()}
    };
    private BufferedReader sourceCode;
    private int currentCharacter;
    private boolean readNewCharacter;
    private SAParam SAParam;
    private int newLineCount;

    public LexicalAnalizer (){
        String path = "";
        newLineCount = 1;
        do {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Elegí el archivo a compilar");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setCurrentDirectory(new File("Files/TestUnits"));
            try {
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    path = fileChooser.getSelectedFile().getAbsolutePath();
                    ConfigurationParams.setOutputFileName(fileChooser.getSelectedFile().getName());
                }else
                    Thread.currentThread().stop();
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null,(String)"No se ha seleccionado ningún archivo");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(path == null || !readFiles(path));
    }

    public boolean readFiles(String path) {
        try {
            File file = new File (path);
            sourceCode = new BufferedReader(new FileReader(file));   
            readNewCharacter = true;
            return true;
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public long getToken () {

        int currentState = ELexicalAnalizerState.INITIAL.getValue(); //Iniciamos en el estado inicial (0)
        SAParam = new SAParam(); //Inicializamos la semantic action param con nuestra tabla de símbolos
        ISemanticAction semanticAction;
        try {
            if (readNewCharacter)
                currentCharacter = sourceCode.read(); //n
            while (currentState != ELexicalAnalizerState.FINAL.getValue()){ // -1 es EOF
                
                //Busco la acción semántica correspondiente a la transición, para el estado en el que estoy y el tipo de caracter que consumo
                semanticAction = semanticActionsTable[currentState][ECharacterType.fromChar((char)currentCharacter).getValue()];// 3 2
                if(semanticAction != null) {
                    SAParam.setLastReadedCharacter((char)currentCharacter);
                    semanticAction.execute(SAParam);
                }
                else if (currentCharacter == 10){ // es el new line verdadero, no el 
                    newLineCount++;
                }
                //Calculo próximo estado en base al estado en el que estoy y el tipo de caracter que consumí
                currentState = stateTable [currentState][ECharacterType.fromChar((char)currentCharacter).getValue()];
                //El if es necesario aca, porque cuando ejecuta una acción léxica que va al estado final sin el if lee el siguiente caracter
                if (SAParam.isReadNewCharacter())
                    currentCharacter = sourceCode.read();
                else 
                    readNewCharacter = false;
            }
            return SAParam.getTokenType().getValue();

        } catch (IOException e) {
        
            return 0;
        }
    }

    public String getErrorMessage () {
        return SAParam!=null?SAParam.getMessageError().toString():"";
    }
    public String getWarningMessage () {
        return SAParam!=null?SAParam.getMessageWarning().toString():"";
    }
    public String getLexema () {
        return SAParam!=null?SAParam.getLexema().toString():"";
    }

    public int yylex() {
        Long tokenLong = getToken();
        int tokenInt = Long.valueOf(tokenLong).intValue();
        return tokenInt;
    }

    public int getNewLineCount() {
        return newLineCount;
    }
    
}