package irrtree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Distance
{
    public double calc(double d1,double d2,double d3,double d4)
  {
   double d = d2-d4;
   double d21 = (Math.sin(deg2rad(d1)))* (Math.sin(deg2rad(d3))) + (Math.cos(deg2rad(d1)) * Math.cos(deg2rad(d3)) * Math.cos(deg2rad(d)));
   d21 = Math.acos(d21);
   d21 = rad2deg(d21);
   d21 = d21 * 60 * 1.1515;
   d21 = d21* 1.609344;
   return d21;

  }

    public double deg2rad(double d1) 
    {
       
        return (d1 * Math.PI / 180.0);

    }

    public double rad2deg(double d2) 
    {
        return (d2 * 180 / Math.PI);

    }
    
}
