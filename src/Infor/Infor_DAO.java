package Infor;


import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Infor_DAO {

   private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
   private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

   private static final String USER = "jhbank"; // ���� DB ����
   private static final String PASS = "1234"; // ���� DB �н�����

   //DB �����Լ�
   public Connection getCon(){
      Connection con = null;

      try {
         Class.forName(DRIVER); // 1. ����̹� �ε�
         con = DriverManager.getConnection(URL,USER,PASS); // 2. ����̹� ����

      } catch (Exception e) {
         e.printStackTrace();
      }

      return con;
   }
   
   //Selete �Լ�
   public void select(DefaultTableModel model) {

      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;

      try { 
         con = getCon();
         String sql = "select * from Infor order by Cname asc"; //sql ��
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();

         //DefaultTableModel�� �ִ� ������ �����
         for(int i = 0; i< model.getRowCount();) {
            model.removeRow(0);
         }

         while(rs.next()) {		//next()�� �����Ѵٸ�, ����ؼ� ���� �������� model�� �����Ѵ�.
            Object data[] = {rs.getString(1), rs.getString(2), rs.getString(3)};
            model.addRow(data);
         }
         
         
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         if(rs != null){
            try {
               rs.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }

         if(ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }

         if(con != null) {
            try {
               con.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
      JOptionPane.showMessageDialog(null, "��ȸ�� �Ϸ��Ͽ����ϴ�.");
   }

   //Insert �Լ�
   public boolean insert(Infor_DTO dto) {
      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "insert into Infor(" +"cname,phone,address)" +"values(?,?,?)";//sql ��
         ps = con.prepareStatement(sql);
         ps.setString(1, dto.getCname());
         ps.setString(2, dto.getPhone());
         ps.setString(3, dto.getAddress());
         int r = ps.executeUpdate();

         if(r>0) {
             ok = true;
             JOptionPane.showMessageDialog(null, "�߰��� �Ϸ��Ͽ����ϴ�.");
          }

        		 
      } catch(SQLIntegrityConstraintViolationException e) { //���Ἲ ���࿡ ����ɶ� ����ó����
    	  JOptionPane.showMessageDialog(null, "���Ἲ �������� ����", "�ȵ�", JOptionPane.ERROR_MESSAGE);
      }
      
      catch (Exception e) { 
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {

         if(con != null) {
            try {
               con.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }

         if(ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
      
	return ok;
   }

   //delete �Լ�
   public boolean delete(String Cname) {

      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "delete from Infor where Cname=?";//sql ��

         ps = con.prepareStatement(sql);
         ps.setString(1, Cname);
         int r = ps.executeUpdate();

         if(r>0)
            ok = true;
         JOptionPane.showMessageDialog(null, " �Ϸ��Ͽ����ϴ�.");
      } 
      
      catch (Exception e) {
         e.printStackTrace();
      }finally {

         if(con != null) {
            try {
               con.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }

         if(ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
      
      return ok;
   }

   //UPDATE
   public boolean update(Infor_DTO dto) {

      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "update infor set phone=? , address=? " + "where Cname=?";//sql ��
         ps = con.prepareStatement(sql);
         
         ps.setString(1, dto.getPhone());
         ps.setString(2, dto.getAddress());
         ps.setString(3, dto.getCname());
         

         int r = ps.executeUpdate();
         if(r>0)
            ok = true;
         JOptionPane.showMessageDialog(null, " �Ϸ��Ͽ����ϴ�.");
      }
      catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {

         if(con != null) {
            try {
               con.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }

         if(ps != null) {
            try {
               ps.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
     
      return ok;
   }
}