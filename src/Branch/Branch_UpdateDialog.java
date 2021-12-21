package Branch;
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

public class Branch_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Bname, Lnum, Blocation;
	public JLabel a,b,c;

	public Branch_UpdateDialog() {
		setTitle("Update");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		Bname = new TextField(10);
		Lnum = new TextField(10);
		Blocation = new TextField(10);

		a = new JLabel("대출 번호 ");
		b = new JLabel("지점 이름");
		c = new JLabel("지점 위치");
		a.setPreferredSize(new Dimension(70,30));
		b.setPreferredSize(new Dimension(70,30));
		c.setPreferredSize(new Dimension(70,30));


		a.setBounds(10, 10, 100, 250);
		panel.add(a);
		Lnum.setBounds(50, 10, 200, 25);
		panel.add(Lnum);
		b.setBounds(10, 50, 100, 25);
		panel.add(b);
		Bname.setBounds(50, 40, 200, 25);
		panel.add(Bname);
		c.setBounds(10, 90, 100, 25);
		panel.add(c);
		Blocation.setBounds(50, 90, 200, 25);
		panel.add(Blocation);

		JButton ok = new JButton("확인");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
	add(panel);

		 
		ok.addActionListener(new ActionListener(){ // 확인 버튼이 클릭되면 액션리스너 호출, DAO의 update 실행
			public void actionPerformed(ActionEvent e) {
				int ln = Integer.parseInt(Lnum.getText());
				String bn = Bname.getText();
				String bl = Blocation.getText();
				
				Branch_DTO dto = new Branch_DTO();
				dto.setLnum(ln);						//dto 클래스에 set함수를 이용해 값을 넣음
				dto.setBname(bn);
				dto.setBlocation(bl);
				Branch_DAO dao = new Branch_DAO();       
				boolean ok = dao.update(dto);// DAO의 update 함수를 호출하고 boolean 값을 리턴받음

				dispose(); // 실행이 끝나면 창을 닫음

			}
		});



		setSize(250, 300);
		setVisible(true);
	}
}