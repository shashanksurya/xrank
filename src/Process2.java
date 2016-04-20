/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package irrtree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author abhishek
 */
class Process2
{

    void cal(String query, double a, double b, int k,double prt,int per) throws ClassNotFoundException, SQLException 
    {
            Connection con=null;
            Class.forName("java.sql.Driver");
            LinkedList l=new LinkedList();
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","netuts");
            PreparedStatement preparedStatement = con.prepareStatement("select * from exp3");
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next())
            {
                String name=rs.getString(2);
                float lat=rs.getFloat(3);
                float log=rs.getFloat(4);
                String sig=rs.getString(5);
                l.add(new node(name,lat,log,lat,log,sig,null,null,null,""));
            }
//            System.out.println(l.getFirst());
//            node n=(node)l.getFirst();
//            System.err.println(n.getName());
//            code for priting object values.
           rtree r =new rtree();
           System.out.println(l);
           r.construct(l,a,b,k,query,prt,per);
    }
    
}
