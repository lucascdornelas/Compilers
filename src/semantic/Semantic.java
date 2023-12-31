package semantic;

import java.util.HashMap;
import java.util.Map;
import symbolTable.Table;
import lexical.Word;
import lexical.Tag;
import lexical.Types;

public class Semantic {
    private Table symbolTableInfos;
    private Map<String, Word> wordsInDeclaration;
    private Types typeInExpression;
    private Tag tagInExpression;

    public Semantic(Table symbolTable) {
        this.symbolTableInfos = symbolTable;
        this.wordsInDeclaration = new HashMap<String, Word>();
    }

    public boolean containsString(String lexeme) {
        return symbolTableInfos.containsString(lexeme);
    }

    public void addWordInDeclaration(String lexeme, Word word) {
        this.wordsInDeclaration.put(lexeme, word);
    }

    public void addTypeWordsInDeclarationInTable(String lexeme, Types type) {
        for (Map.Entry<String, Word> entry : this.wordsInDeclaration.entrySet()) {
            Word w = entry.getValue();
            this.symbolTableInfos.setSetTypeOfTag(w, type);
            this.wordsInDeclaration = new HashMap<String, Word>();
        }
    }

    public Types getTypeWordInSymbolTable(String key) throws Exception {
        return this.symbolTableInfos.getElementTypeByKey(key);
    }

    public Types getTypeInExpression() {
        return typeInExpression;
    }

    public void setTypeInExpression(Types typeInExpression) {
        this.typeInExpression = typeInExpression;
    }

    public Tag getTagInExpression() {
        return tagInExpression;
    }

    public void setTagInExpression(Tag tagInExpression) {
        this.tagInExpression = tagInExpression;
    }
}
