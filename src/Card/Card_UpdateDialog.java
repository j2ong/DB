package Card;
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

public class Card_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Canum, Acnum, Ctype;
	public JLabel a,b,c;

	public Card_UpdateDialog() {
		setTitle("Update");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		Canum = new TextField(10);
		Acnum = new TextField(10);
		Ctype = new TextField(10);
		
		a = new JLabel("카드 번호");
		b = new JLabel("계좌 번호");
		c = new JLabel("카드 유형");
		a.setPreferredSize(new Dimension(70,30));
		b.setPreferredSize(new Dimension(70,30));
		c.setPreferredSize(new Dimension(70,30));

		a.setBounds(10, 10, 100, 250);
		panel.add(a);
		Canum.setBounds(50, 10, 200, 25);
		panel.add(Canum);
		b.setBounds(10, 50, 100, 25);
		panel.add(b);
		Acnum.setBounds(50, 40, 200, 25);
		panel.add(Acnum);
		c.setBounds(10, 90, 100, 25);
		panel.add(c);
		Ctype.setBounds(50, 90, 200, 25);
		panel.add(Ctype);
		
		JButton ok = new JButton("확인");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
	add(panel);

		 
		ok.addActionListener(new ActionListener(){ //확인 버튼이 클릭되면 액션이벤트 실행
			public void actionPerformed(ActionEvent e) {
				int ca = Integer.parseInt(Canum.getText());
				String ac = Acnum.getText();		//텍스트 필드에서 값을 가져옴
				String cy = Ctype.getText();

				Card_DTO dto = new Card_DTO();	//DTO클래스의 객체 생성후
				dto.setCanum(ca);				//set 함수를 이용하여 값을 집어넣음
				dto.setAcnum(ac);
				dto.setCtype(cy);
				Card_DAO dao = new Card_DAO();      //DAO 클래스의 객체 생성후
				boolean ok = dao.update(dto);		// DAO의 update 함수를 호출하고 boolean 값을 리턴받음

				dispose(); // 실행이 끝나면 창을 닫음

			}
		});



		setSize(250, 300);
		setVisible(true);
	}
}