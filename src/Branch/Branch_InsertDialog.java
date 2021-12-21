package Branch;

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

public class Branch_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Bname, Lnum, Blocation;
	public JLabel a,b,c;

	public Branch_InsertDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		Bname = new TextField(10);
		Lnum = new TextField(10);
		Blocation = new TextField(10);

		a = new JLabel("���� ��ȣ");
		b = new JLabel("���� �̸�");
		c = new JLabel("���� ��ġ");
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

		JButton ok = new JButton("Ȯ��");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
	add(panel);

		 
		ok.addActionListener(new ActionListener(){ // Ȯ�ι�ư�� �������� �׼Ǹ����ʸ� ȣ��, DAO�� insert�� ȣ���Ѵ�
			public void actionPerformed(ActionEvent e) {
				int ln = Integer.parseInt(Lnum.getText());
				String bn = Bname.getText();
				String bl = Blocation.getText();

				Branch_DTO dto = new Branch_DTO();
				dto.setLnum(ln);					//dto Ŭ������ set�Լ��� �̿��� ���� ����
				dto.setBname(bn);
				dto.setBlocation(bl);
				Branch_DAO dao = new Branch_DAO();       
				boolean ok = dao.insert(dto);// DAO�� insert �Լ��� ȣ���ϰ� boolean ���� ���Ϲ���

				dispose(); // ������ ������ â�� ����

			}
		});



		setSize(250, 300);
		setVisible(true);
	}
}
