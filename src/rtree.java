/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irrtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import static java.util.Spliterators.iterator;
import static java.util.Spliterators.iterator;
import java.util.TreeSet;

/**
 *
 * @author abhishek
 */
class rtree
{

    boolean falg=true,flag=true;
    int i=0;
    int k=0;
    ArrayList al1=new ArrayList();
    ArrayList al2=new ArrayList();
    ArrayList<ArrayList> al=new ArrayList<>();
    int till=0;
    void construct(LinkedList l,double a,double b,int k,String q,double prt,int per) 
    {
      System.out.println(l.size());
      while(falg) 
      {
       node n1=(node)l.get(i);
       node n2=(node)l.get(i+1);
       node n3=combinenodes(n1,n2);
       System.out.println(n3);
       n1.setParent(n3);
       n2.setParent(n3);
       n3.setLeftchild(n1);
       n3.setRightchild(n2);
       System.out.println(n3.getLeftchild()+" "+n3.getRightchild());
       al1.add(n1);
       al1.add(n2);
       al2.add(n3);
       i=i+2;
       till=till+2;
       if(till>(l.size()-2))
       {
           falg=false;
       }
         
      }
      System.out.println("reached here checking al1 size"+al1.size()+"al2 size"+al2.size());
      int p=0;
      int m=0;
      boolean flag1=true;
      boolean flag2=true;
      int kill=0,d=0;
      ArrayList ab=new ArrayList();
      ArrayList cd=new ArrayList();
      ArrayList am=new ArrayList();
      Iterator it1=al2.iterator();
                             while(it1.hasNext())
                             {
                             ab.add(it1.next());
                             }
                             System.out.println(ab.size()+"ab size");
      al.add(al1);
      al.add(al2);
      System.out.println(al.size()+"printing al size");
      double x=(double)al2.size();
      flag=true;
      System.out.println(x+" "+al1.size()+""+l.size());
                    while(flag1)
                    {  d++;
                       flag=true;
                       p=0;
                       kill=0;         
                        while(flag)
                            {
                             node nk1=(node) ab.get(p);
                             node nk2=(node) ab.get(p+1);
                             node nnew=combinenodes(nk1,nk2);
                             nk1.setParent(nnew);
                             nk2.setParent(nnew);
                             nnew.setLeftchild(nk1);
                             nnew.setRightchild(nk2);
                             cd.add(nnew);
                             System.out.println("cd size"+cd.size());
                             p=p+2;
                             kill=kill+2;
                               if(kill>(ab.size()-2))
                                {
                                   flag=false;
                                }
                            }
                             ab.clear();
                             System.out.println(ab.size()+"after removal");
                             Iterator it=cd.iterator();
                             while(it.hasNext())
                             {
                             ab.add(it.next());
                             }
                             System.out.println(ab.size()+"after addition");
                             al.add(cd);
                             System.out.println("jill");
                             if(d==5)
                             {
                                flag1=false; 
                                am.addAll(cd);
                             }
                             cd.clear();
                             System.out.println(al.size());
                       }
      System.out.println("tree built successfully");
      System.out.println(al.size());
      System.out.println(am.size());
      distk dk=new distk();
      dk.cal(al,am,a,b,k,q,prt,per);
    }

    private node combinenodes(node n1,node n2) 
    {
       float a11=n1.getLat1();
       float a12=n1.getLat2();
       float b11=n1.getLog1();
       float b12=n1.getLog2();
       float a21=n2.getLat1();
       float a22=n2.getLat2();
       float b21=n2.getLog1();
       float b22=n2.getLog2();
       String sig1=n1.getSig();
       String sig2=n2.getSig();
       int i1=Integer.parseInt(sig1);
       int i2=Integer.parseInt(sig2);
       float m1=Math.min(a11,a21);
       float m2=Math.min(b11,b21);
       float m3=Math.max(a12,a22);
       float m4=Math.max(b12,b22);
       int i3=0;
       int i11,i21;
       int sum=0;
       String sum1=null;
       while((i1>0)&&(i2>0))
       {
           i11=i1%10;
           i21=i2%10;
           if((i11==1) && (i21==1))
           {
               i3=1;
           }
           
           else if((i11==1)&&(i21==0))
           {
               i3=1;
           }else if((i11==0)&&(i21==1))
           {
               i3=1;
           }
           else
           {
               i3=0;
           }
           
           i1=i1/10;
           i2=i2/10;
           sum=(sum*10)+i3;
           sum1=Integer.toString(sum);
       }
       node k= new node("",m1,m2,m3,m4,sum1,null,null,null,"");
       System.out.println(k);
       return k;
    }
    
}
