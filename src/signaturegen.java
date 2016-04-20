/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irrtree;

/**
 *
 * @author abhishek
 */
public class signaturegen
{
    String calc(String f1)
    {
        String signature="";
      if(f1.toLowerCase().contains("bar".toLowerCase()))
            {
                signature=signature+"1";
            }
            else
            {
                signature=signature+"0";
            }
            
            if(f1.toLowerCase().contains("partyplace".toLowerCase()))
            {
                signature=signature+"1";
            }
            else
            {
                signature=signature+"0";
            }
            if(f1.toLowerCase().contains("grill".toLowerCase()))
            {
                signature=signature+"1";
            }
            else
            {
                signature=signature+"0";
            }
            if(f1.toLowerCase().contains("free wifi".toLowerCase()))
            {
                signature=signature+"1";
            }
            else
            {
                signature=signature+"0";
            }
            System.out.println("signature"+signature);
         
           return signature;
    }
    
}
