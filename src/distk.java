/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irrtree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author abhishek
 */
class distk
{

    void cal(ArrayList<ArrayList> al,ArrayList am,double lat,double log,int k,String f1,double prt,int per) 
    {
        Iterator it=al.iterator();
        ArrayList al1 = null;
        boolean flag=true;
        LinkedList l=new LinkedList();
        int i=0;
        minnodecal m=new minnodecal();
        LinkedList processinglist=new LinkedList();
        LinkedList finallist=new LinkedList();
        System.out.println("AL SIZE"+al.size());
        Iterator it1=am.iterator();
        while(it1.hasNext())
        {
          l.add(it1.next());
        }
        System.out.println("size of linked list"+l.size());
        Iterator it2=l.iterator();
        while(it2.hasNext())
        {
            processinglist.add((node)it2.next());
        }
          System.out.println("size of processing list"+processinglist.size());
        boolean flag2=true;
        int comp=0;
        while(i<k)
        {
          
          node mindistnode=(node)m.mincal(processinglist,lat,log,f1,prt,per);
          if(mindistnode!=null)
          {
          if((mindistnode.getLeftchild()==null)&&(mindistnode.getRightchild()==null))
            {
                System.out.println("found a leaf");
                String signature=(String)mindistnode.getStatus();
               if(signature.equals("1"))
              {
                  System.out.print("reached leaf");
                  finallist.add(mindistnode);
                  processinglist.remove(mindistnode); 
                  i++;
              }
              else
              {
                processinglist.remove(mindistnode);
               
              }
               
            }
          else
          {
               node pilla1=(node)mindistnode.getLeftchild();
               node pilla2=(node)mindistnode.getRightchild();
               processinglist.remove(mindistnode);
               processinglist.add(pilla1);
               processinglist.add(pilla2);
               System.out.println(processinglist.size());
          }
          comp++;
          }
          else
          {
           System.out.println("no results found as per search");  
           break;
          }
        }
        System.out.println("finished searching");
        System.out.println(comp);
        Iterator it3=finallist.iterator();
        while(it3.hasNext())
        {
            node n=(node)it3.next();
            String name=n.getName();
            System.out.println(name);
        }
    }
    
}
