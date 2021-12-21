package Account;
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

public class Account_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Acnum, Balance;
	public JLabel a,b;

	public Account_UpdateDialog() {
	setTitle("Update");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
	setLayout(new BorderLayout());
	
	setLayout(new BorderLayout());
	JPanel Up = new JPanel();
	Up.setLayout(new FlowLayout());
	JPanel Ce = new JPanel();
	Ce.setLayout(new FlowLayout());
	JPanel Do = new JPanel();

	JButton ok = new JButton("수정");

	Acnum = new TextField(10);
	Balance = new TextField(10);
	 a = new JLabel("계좌 번호");
	 b = new JLabel("잔 액");
	a.setPreferredSize(new Dimension(70,50));
	b.setPreferredSize(new Dimension(70,50));
	
	Up.add(a);
	Up.add(Acnum);
	
	Ce.add(b);
	Ce.add(Balance);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ 		// 수정 버튼을 누르면 액션이벤트 실행, Dao의 Update를 호출한다.
        public void actionPerformed(ActionEvent e) {
        	String ac = Acnum.getText();
			int ba = Integer.parseInt(Balance.getText());
			Account_DTO dto = new Account_DTO();
			dto.setAccount(ac);						//dto 클래스에 set함수를 이용해 값을 넣음
			dto.setBalance(ba);
            Account_DAO dao = new Account_DAO();       
            boolean ok = dao.update(dto);		// DAO의 update 함수를 호출하고 boolean 값을 리턴받음
            
            dispose(); // 실행이 끝나면 창을 닫음
        }
        });
	setSize(300, 200);
	setVisible(true);
}
}
