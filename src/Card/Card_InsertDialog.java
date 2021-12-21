	package Card;

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

public class Card_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Canum, Acnum, Ctype;
	public JLabel a,b,c;

	public Card_InsertDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		Canum = new TextField(10);
		Acnum = new TextField(10);
		Ctype = new TextField(10);

		a = new JLabel("ī�� ��ȣ");
		b = new JLabel("���� ��ȣ");
		c = new JLabel("ī�� ����");
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

		JButton ok = new JButton("Ȯ��");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
	add(panel);

		 
		ok.addActionListener(new ActionListener(){   //Ȯ�� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ����
			public void actionPerformed(ActionEvent e) {
				int ca = Integer.parseInt(Canum.getText());
				String ac = Acnum.getText();
				String cy = Ctype.getText();

				Card_DTO dto = new Card_DTO();	//DTOŬ������ set �޼��带 �̿��Ͽ� ���� �������
				dto.setCanum(ca);
				dto.setAcnum(ac);
				dto.setCtype(cy);
				Card_DAO dao = new Card_DAO();       
				boolean ok = dao.insert(dto);// DAO�� insert �Լ���  dto ��ü�� ���ڷ� �־�ȣ���ϰ� boolean ���� ���Ϲ���

				dispose(); // ������ ������ â�� ����

			}
		});

		setSize(250, 300);
		setVisible(true);
	}
}