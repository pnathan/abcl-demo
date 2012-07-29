/*
lispRunner.java
 */

import org.armedbear.lisp.*;

class lispRunner
{
   lispRunner()
   {
      try
      {
          //
          Interpreter interpreter = Interpreter.createInstance();
          interpreter.eval("(load \"lispfunction.lisp\")");

          // Get a datapoint
          LispObject result = JavaObject.getInstance(100, true);
          org.armedbear.lisp.Package defaultPackage =
           Packages.findPackage("CL-USER");
          Symbol sym =
           defaultPackage.findAccessibleSymbol("LISPFUNCTION");
          Function function = (Function) sym.getSymbolFunction();
          function.execute(result);
          System.out.print("");
      }
      catch (Throwable t)
      {
              System.out.println("exception!");
       t.printStackTrace();
      }
   }
}
