package Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Customer_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Cunum , Cname, Acnum;
	public JLabel a,b,c;

	public Customer_UpdateDialog() {
	setTitle("Update");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
	setLayout(new BorderLayout());
	
	JPanel panel = new JPanel();
	Cunum = new TextField(10);
	Cname = new TextField(10);
	Acnum = new TextField(10);

	a = new JLabel("고객 번호");
	b = new JLabel("고객 이름");
	c = new JLabel("계좌 번호");
	a.setPreferredSize(new Dimension(70,50));
	b.setPreferredSize(new Dimension(70,50));
	c.setPreferredSize(new Dimension(70,50));


	a.setBounds(10, 10, 100, 250);
	panel.add(a);
	Cunum.setBounds(50, 10, 200, 25);
	panel.add(Cunum);
	c.setBounds(10, 50, 100, 25);
	panel.add(c);
	Acnum.setBounds(50, 40, 200, 25);
	panel.add(Acnum);
	b.setBounds(10, 90, 100, 25);
	panel.add(b);
	Cname.setBounds(50, 90, 200, 25);
	panel.add(Cname);

	JButton ok = new JButton("확인");
	ok.setBounds(10, 80, 100, 25);
	panel.add(ok);
add(panel);
	
	
	ok.addActionListener(new ActionListener(){ 				//확인 버튼이 클릭되면 액션이벤트 실행
        public void actionPerformed(ActionEvent e) {
			int cu = Integer.parseInt(Cunum.getText());		//텍스트 필드에서 값을 가져옴
			String cn = Cname.getText();
			String ac = Acnum.getText();
			
			Customer_DTO dto = new Customer_DTO();			//dto 객체 생성
			dto.setCunum(cu);								//set 함수를 이용하여 값을 전달
			dto.setCname(cn);
			dto.setAcnum(ac);
            Customer_DAO dao = new Customer_DAO();       	//dao 객체 생성
            boolean ok = dao.update(dto);					// DAO의 update 함수를 호출하고 boolean 값을 리턴받음
            
            dispose(); // 실행이 끝나면 창을 닫음
        }
        });
	setSize(250, 300);
	setVisible(true);
}
}
