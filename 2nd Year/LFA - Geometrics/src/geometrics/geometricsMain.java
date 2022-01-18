
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import org.stringtemplate.v4.*;

public class geometricsMain {
   public static void main(String[] args) {
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(System.in);
         // create a lexer that feeds off of input CharStream:
         geometricsLexer lexer = new geometricsLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         geometricsParser parser = new geometricsParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            GeometricsSemantic semantic = new GeometricsSemantic();
            GeometricsCompiler compiler = new GeometricsCompiler();
            //if(semantic.visit(tree) == null){ System.out.println("Erro");}
            semantic.visit(tree);
            ST code = compiler.visit(tree);
            String filename = "Output.py";
            PrintWriter pw = new PrintWriter(new File(filename));
            pw.print(code.render());
            pw.close();
            
         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
