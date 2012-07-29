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
          Interpreter interpreter = Interpreter.createInstance();
          interpreter.eval("(load \"lispfunction.lisp\")");

          // Get a datapoint
          LispObject one_hundred = JavaObject.getInstance(100, true);
          Package defaultPackage = Packages.findPackage("CL-USER");
          Symbol sym = defaultPackage.findAccessibleSymbol("LISPFUNCTION");
          Function function = (Function) sym.getSymbolFunction();
          LispObject result = function.execute(one_hundred);
          System.out.print(result.getStringValue());
      }
      catch (Throwable exception)
      {
              System.out.println("Error Occurred in ABCL!");
              exception.printStackTrace();
      }
   }
}
