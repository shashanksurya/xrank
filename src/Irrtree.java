package irrtree;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author abhishek
 */
public class Irrtree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
          String query=JOptionPane.showInputDialog("enter query with following keywords partyplace bar grill free wifi");
          double a=Double.parseDouble(JOptionPane.showInputDialog("enter lattitude"));
          double b=Double.parseDouble(JOptionPane.showInputDialog("enter longitude"));
          int k=Integer.parseInt(JOptionPane.showInputDialog("enter k value"));
          double prt=Double.parseDouble(JOptionPane.showInputDialog("enter value in range of 0.0 to 1.0 (overall priority for distance and amenities)"));
          int per=Integer.parseInt(JOptionPane.showInputDialog("enter percentage of match required for amenities say 0% 25% 50% 75% 100% (only digits)"));
          Process2 d=new Process2();
          d.cal(query,a,b,k,prt,per);
          System.out.println("the comparisions made or simple nodes accessed"+minnodecal.comp);
    }
    
}
