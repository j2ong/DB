package Customer;


import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Customer_DAO {

   private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
   private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

   private static final String USER = "jhbank"; // 나의 DB 계정
   private static final String PASS = "1234"; // 나의 DB 패스워드

   //DB 연결함수
   public Connection getCon(){
      Connection con = null;

      try {
         Class.forName(DRIVER); // 1. 드라이버 로딩
         con = DriverManager.getConnection(URL,USER,PASS); // 2. 드라이버 연결

      } catch (Exception e) {
         e.printStackTrace();
      }

      return con;
   }
   
   //Selete 함수
   public void select(DefaultTableModel model) {

      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;

      try { 
         con = getCon();
         String sql = "select * from Customer order by Cunum asc"; //sql 문
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();

         //DefaultTableModel에 있는 데이터 지우기
         for(int i = 0; i< model.getRowCount();) {
            model.removeRow(0);
         }

         while(rs.next()) {		//next()가 존재한다면, 계속해서 값을 읽은다음 model에 삽입한다.
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
      JOptionPane.showMessageDialog(null, "조회를 완료하였습니다.");
   }

   //Insert 함수
   public boolean insert(Customer_DTO dto) {
      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "insert into Customer(" +"cunum,cname,acnum)" +"values(?,?,?)";//sql 문
         ps = con.prepareStatement(sql);
         ps.setInt(1, dto.getCunum());
         ps.setString(2, dto.getCname());
         ps.setString(3, dto.getAcnum());
         int r = ps.executeUpdate();

         if(r>0) {
             ok = true;
             JOptionPane.showMessageDialog(null, "추가를 완료하였습니다.");
          }

        		 
      } catch(SQLIntegrityConstraintViolationException e) { //무결성 제약에 위배될때 예외처리문
    	  JOptionPane.showMessageDialog(null, "무결성 제약조건 위배", "안돼", JOptionPane.ERROR_MESSAGE);
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

   //delete 함수
   public boolean delete(int Cunum) {

      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "delete from Customer where Cunum=?";//sql 문

         ps = con.prepareStatement(sql);
         ps.setInt(1, Cunum);
         int r = ps.executeUpdate();

         if(r>0)
            ok = true;
         JOptionPane.showMessageDialog(null, " 완료하였습니다.");
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
   public boolean update(Customer_DTO dto) {

      boolean ok = false;
      Connection con = null;
      PreparedStatement ps = null;

      try {
         con = getCon();
         String sql = "update customer set cname=? , Acnum=? " + "where Cunum=?";//sql 문
         ps = con.prepareStatement(sql);
        
         ps.setString(1, dto.getCname());
         ps.setString(2, dto.getAcnum());
         ps.setInt(3, dto.getCunum());
         

         int r = ps.executeUpdate();
         if(r>0)
            ok = true;
         JOptionPane.showMessageDialog(null, " 완료하였습니다.");
      }catch (SQLSyntaxErrorException e) {
    	  JOptionPane.showMessageDialog(null, "무결성 제약조건 위배", "안돼", JOptionPane.ERROR_MESSAGE);
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