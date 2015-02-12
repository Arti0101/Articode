package NumberCode;
import java.io.IOException;

public class MainCode {
	
	   public static void main(String[] args)
	   {
	      NumCode numcode = new NumCode();
	      try {
	    	  numcode.start();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
	}

}
