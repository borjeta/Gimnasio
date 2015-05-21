package Utils;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Apariencia {
	
	
	 public static void apariencia(int apariencia) {
	        try {
	            
	                if(apariencia==0){// Metal
	                    UIManager.setLookAndFeel(UIManager
	                            .getCrossPlatformLookAndFeelClassName());
	        }    

	               if(apariencia==1){// GTK - WINDOWS
	                    UIManager.setLookAndFeel(UIManager
	                            .getSystemLookAndFeelClassName());
	               }

	                if(apariencia==2)// CDE/Motif
	                    UIManager
	                            .setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	        

	            

	            }
	         catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
	            JOptionPane.showMessageDialog(null,
	                    "No pudo cargarse la apariencia deseada\n" + e.getMessage(), "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}



