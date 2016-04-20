/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irrtree;


class sigmatch
{

    float sig(String sig1, String sig2)
    {
      float match=0;
      int i1=Integer.parseInt(sig1);
      int i2=Integer.parseInt(sig2);
      while(i1>0)
      {
          i1=i1%10;
          i2=i2%10;
          if(i1==i2)
          {
              match=match+25;
          }
          i1=i1/10;
          i2=i2/10;
      }
      
     return match;
    }

    
    
}
