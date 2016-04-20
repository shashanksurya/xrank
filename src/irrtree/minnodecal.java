/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irrtree;

import java.util.Iterator;
import java.util.LinkedList;


class minnodecal 
{
    public static int comp=0;

    node mincal(LinkedList processinglist,double lat,double log,String f1,double prt,int per) 
    {
       Distance d=new Distance();
       Iterator il=processinglist.iterator();
       signaturegen sg=new signaturegen();
       String sig1=sg.calc(f1);
       sigmatch sm=new sigmatch();
       node mindistnode = null;
       double dist=0.0;
       double mindist=10000.0;
       double compdist=0.0;
            while(il.hasNext())
            {
                 node n=(node)il.next();
                 String sig2=(String)n.getSig();
                 double c1=n.getLat1();
                 double d1=n.getLog1();
                 dist=d.calc(lat,log,c1,d1);
                 float p=sm.sig(sig1,sig2);
                 compdist=((1-prt)*dist)+(prt*p);
                 if(compdist <= mindist)
                 {
                     mindist=compdist;
                     mindistnode=(node)n;
                     comp++;
                 }
            }
            if(mindistnode!=null)
            {
                mindistnode.setStatus("1");
            }
     return mindistnode;
    }
    
}
