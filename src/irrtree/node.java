/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irrtree;
class node 
{
   String name=null,sig=null;
   float lat1=0,log1=0,lat2=0,log2=0;
   node parent;
    node leftchild;
    node rightchild;
    String status;
  node(String name1,float a,float b,float a1,float b1,String sig1,node parent,node leftchild,node rightchild,String status)
  {
     name=name1;
     lat1=a;
     log1=b;
     lat2=a1;
     log2=b1;
     sig=sig1;
     parent=null;
     leftchild=null;
     rightchild=null;
     status=null;
  } 

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public node getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(node leftchild) {
        this.leftchild = leftchild;
    }

    public node getRightchild() {
        return rightchild;
    }

    public void setRightchild(node rightchild) {
        this.rightchild = rightchild;
    }
    
    
    public node getParent() {
        return parent;
    }

    public void setParent(node parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public float getLat1() {
        return lat1;
    }

    public void setLat1(float lat1) {
        this.lat1 = lat1;
    }

    public float getLog1() {
        return log1;
    }

    public void setLog1(float log1) {
        this.log1 = log1;
    }
    public float getLat2() {
        return lat2;
    }

    public void setLat2(float lat2) {
        this.lat2 = lat2;
    }

    public float getLog2() {
        return log2;
    }

    public void setLog2(float log2) {
        this.log2 = log2;
    }
  
}
