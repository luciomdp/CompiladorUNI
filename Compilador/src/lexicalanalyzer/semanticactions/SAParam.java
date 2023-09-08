package lexicalanalyzer.semanticactions;

import objects.SymbolTable;
import objects.enums.ETokenType;

public class SAParam {
    private SymbolTable symbolTable;
    
    private Character lastReadedCharacter;
    private StringBuilder lexema;
    private StringBuilder message;
    private ETokenType tokenType;
    
    //Para las acciones semánticas que sean de transición a estado final, se define esta variable que indicará si el caracter leído es parte del token actual, (rnc=true) o si debería comenzar la lectura del próximo token en el último caracter consumido (rnc=false)
    private boolean readNewCharacter;


    public SAParam(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        
        lexema = new StringBuilder();
        readNewCharacter = true;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable tablaSimbolos) {
        this.symbolTable = tablaSimbolos;
    }

    public ETokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(ETokenType tipoToken) {
        this.tokenType = tipoToken;
    }

    public Character getLastReadedCharacter() {
        return lastReadedCharacter;
    }

    public void setLastReadedCharacter(Character ultimoCaracterLeido) {
        this.lastReadedCharacter = ultimoCaracterLeido;
    }

    public boolean isReadNewCharacter() {
        return readNewCharacter;
    }

    public void setReadNewCharacter(boolean readNewCharacter) {
        this.readNewCharacter = readNewCharacter;
    }

    public StringBuilder getLexema() {
        return lexema;
    }

    public void setLexema(StringBuilder lexema) {
        this.lexema = lexema;
    }

    public StringBuilder getMessage() {
        return message;
    }

    public void setMessage(StringBuilder message) {
        this.message = message;
    }
    
}