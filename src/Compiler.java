import java.io.FileNotFoundException;

import lexical.Lexer;
import lexical.Tag;
import utils.CompilerException;
import syntatic.Parser;

public class Compiler {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        String debugParam = args.length > 1 ? args[1] : "";
        boolean debug = false;

        if (debugParam.equals("-d")) {
            System.out.println("Debug mode on.");
            debug = true;
        }

        Lexer lexer;
        Parser parser;

        try {
            lexer = new Lexer(fileName);
            parser = new Parser(lexer, debug);

            do {
                parser.programLine();
            } while (parser.getCurrentToken().getTag() != Tag.END_OF_FILE);

            System.out.println("Analise concluída com sucesso.");

            // lexer.symbolTableInfos.printTable();
            // System.out.println("*********************");
            // parser.getSymbolTable().printTable();

        } catch (FileNotFoundException e) {
            System.out.println("Insira o nome de um arquivo válido.");
        } catch (CompilerException e) {
            System.out.println(e);
        }
    }
}