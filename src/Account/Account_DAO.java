package Account;


import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Account_DAO {		//�����ͺ��̽��� �����ϴ� ��ü

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
         String sql = "select * from Account order by Acnum asc"; //sql ��
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();

         //DefaultTableModel�� �ִ� ������ �����
         for(int i = 0; i< model.getRowCount();) {
            model.removeRow(0);
         }

         while(rs.next()) {		//next()�� �����Ѵٸ�, ����ؼ� ���� �������� model�� �����Ѵ�.
            Object data[] = {rs.getString(1), rs.getString(2)};
            model.addRow(data);
         }
         
         
      } catch (Exception e) {						//����ó����
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
   public boolean insert(Account_DTO dto) {
      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "insert into Account(" +"Acnum,Balance)" +"values(?,?)"; //sql ��
         ps = con.prepareStatement(sql);
         ps.setString(1, dto.getAccount());
         ps.setInt(2, dto.getBalance());
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
   public boolean delete(String Acnum) {

      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon(); 
         String sql = "delete from Account where Acnum=?"; //sql ��

         ps = con.prepareStatement(sql);
         ps.setString(1, Acnum);
         int r = ps.executeUpdate();

         if(r>0)
            ok = true;
         JOptionPane.showMessageDialog(null, " �Ϸ��Ͽ����ϴ�.");
      } catch (Exception e) {
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
   public boolean update(Account_DTO dto) {

      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      

      try {
         con = getCon();
         String sql = "update Account set Balance=? " + "where Acnum=?"; //sql ��
         
         ps = con.prepareStatement(sql);
         ps.setInt(1, dto.getBalance());
         ps.setString(2, dto.getAccount());

         int r = ps.executeUpdate();
         if(r>0)
            ok = true;
         JOptionPane.showMessageDialog(null, " �Ϸ��Ͽ����ϴ�.");
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