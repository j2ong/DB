package Partner;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class Partner_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Canum, Pname, Disrate;
	public JLabel a,b,c;

	public Partner_InsertDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		Canum = new TextField(10);
		Pname = new TextField(10);
		Disrate = new TextField(10);

		a = new JLabel("카드 번호");
		b = new JLabel("제휴 업체");
		c = new JLabel("할인 율");
		a.setPreferredSize(new Dimension(70,30));
		b.setPreferredSize(new Dimension(70,30));
		c.setPreferredSize(new Dimension(70,30));


		a.setBounds(10, 10, 100, 250);
		panel.add(a);
		Canum.setBounds(50, 10, 200, 25);
		panel.add(Canum);
		b.setBounds(10, 50, 100, 25);
		panel.add(b);
		Pname.setBounds(50, 40, 200, 25);
		panel.add(Pname);
		c.setBounds(10, 90, 100, 25);
		panel.add(c);
		Disrate.setBounds(50, 90, 200, 25);
		panel.add(Disrate);

		JButton ok = new JButton("확인");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
	add(panel);

		 
		ok.addActionListener(new ActionListener(){ 				//확인 버튼이 클릭되면 액션이벤트 실행  
			public void actionPerformed(ActionEvent e) {
				int ca = Integer.parseInt(Canum.getText());		//속성들의 값을 텍스트 필드에서 가져옴
				String pn = Pname.getText();
				String di = Disrate.getText();

				Partner_DTO dto = new Partner_DTO();			//dto 객체 생성
				dto.setCanum(ca);								//set 함수를 이용해 값을 전달
				dto.setPname(pn);
				dto.setDisrate(di);
				Partner_DAO dao = new Partner_DAO();       		//dao 객체 생성
				boolean ok = dao.insert(dto);					//dto 값을 인자로 dao의 insert 함수룰 호출 후 boolean값 리턴

				dispose(); // 실행이 끝나면 창을 닫음

			}
		});

		setSize(250, 300);
		setVisible(true);
	}
}