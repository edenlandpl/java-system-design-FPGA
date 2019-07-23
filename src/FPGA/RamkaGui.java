/** Projektowanie systemów FPGA
 * author - Adrian
 * date - 9 gru 2018
 * version - 
 */
package FPGA;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;

// nie użyte

public class RamkaGui extends javax.swing.JFrame{
	
	 public RamkaGui() {
	        //initComponents();
	        // ustalenie parametrów początkowych ramki
	        setTitle("Gui Adrian ver 0.1");
	        int szerokoscRamki = 900;
	        int wysokoscRamki = 570;
	        setSize(new Dimension(szerokoscRamki, wysokoscRamki));
//	        setLocationRelativeTo(null);
	        // ustalenie parametrów i miejsca wyświetlania okna głównego
	        int szerokoscEkranu = Toolkit.getDefaultToolkit().getScreenSize().width; 
	        int wysokoscEkranu = Toolkit.getDefaultToolkit().getScreenSize().height; 
	        
	        this.setLocation((szerokoscEkranu-szerokoscRamki)/2, (wysokoscEkranu-wysokoscRamki)/2);
	        
	        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// wyłączenie defaultowego wyłączania "krzyżykiem"
	        
	        // Okno dialogowe - informacja o programie
	        int szerokoscDialogu = 440;
	        int wysokoscDialogu = 520;
	        // ustalenie wymiarów i położenia okna dialogowego, 
	        //DialogInformacja.setSize( new Dimension(szerokoscDialogu,wysokoscDialogu));
	        //DialogInformacja.setLocation((szerokoscEkranu-szerokoscDialogu)/2, (wysokoscEkranu-wysokoscDialogu)/2);
	        // wybór opcji zamknięcia, zabezpieczenie przed przypadkowym zamknięciem
	        addWindowListener(new WindowAdapter()
	                {
	                    public void windowClosing(WindowEvent e)
	                    {
	                        int value =JOptionPane.showOptionDialog(
	                                null,
	                                "Czy chcesz zamknąć okno",
	                                "Uwaga",
	                                JOptionPane.YES_NO_CANCEL_OPTION,
	                                JOptionPane.WARNING_MESSAGE,
	                                null,
	                                new String[] { "Tak",  "Nie" },
	                                "Tak"
	                                );
	                        if(value == JOptionPane.YES_OPTION)
	                        {
	                            dispose();
	                            System.exit(0);
	                        }
	                                         
	                    }


	                });
	    }

}
