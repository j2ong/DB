package Card;


import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Card_DAO {

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
         String sql = "select * from Card order by Canum asc"; //sql ��
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();

         //DefaultTableModel�� �ִ� ������ �����
         for(int i = 0; i< model.getRowCount();) {
            model.removeRow(0);
         }

         while(rs.next()) {		//next()�� �����Ѵٸ�, ����ؼ� ���� �������� model�� �����Ѵ�.
            Object data[] = {rs.getInt(1), rs.getString(2), rs.getNString(3)};
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
   public boolean insert(Card_DTO dto) {
      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "insert into Card(" +"Canum,Acnum,Ctype)" +"values(?,?,?)";//sql ��
         ps = con.prepareStatement(sql);
         ps.setInt(1, dto.getCanum());
         ps.setString(2, dto.getAcnum());
         ps.setString(3, dto.getCtype());
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
   public boolean delete(int Canum) {

      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "delete from Card where Canum=?";//sql ��

         ps = con.prepareStatement(sql);
         ps.setInt(1, Canum);
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
   public boolean update(Card_DTO dto) {

      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "update Card set Acnum=? , Ctype=? " + "where Canum=?";//sql ��
         ps = con.prepareStatement(sql);
         ps.setString(1, dto.getAcnum());
         ps.setString(2, dto.getCtype());
         ps.setInt(3, dto.getCanum());
         
         

         int r = ps.executeUpdate();
         if(r>0)
            ok = true;
         JOptionPane.showMessageDialog(null, "�Ϸ��Ͽ����ϴ�.");
      }catch (SQLSyntaxErrorException e) {
    	  JOptionPane.showMessageDialog(null, "���Ἲ �������� ����", "�ȵ�", JOptionPane.ERROR_MESSAGE);
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