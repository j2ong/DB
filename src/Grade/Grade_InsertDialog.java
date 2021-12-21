		package Grade;

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

public class Grade_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Cunum, Acnum, Grade;
	public JLabel a,b,c;

	public Grade_InsertDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		Cunum = new TextField(10);
		Acnum = new TextField(10);
		Grade = new TextField(10);

		a = new JLabel("�� ��ȣ");
		b = new JLabel("���� ��ȣ");
		c = new JLabel("�� ���");
		a.setPreferredSize(new Dimension(70,30));
		b.setPreferredSize(new Dimension(70,30));
		c.setPreferredSize(new Dimension(70,30));


		a.setBounds(10, 10, 100, 250);
		panel.add(a);
		Cunum.setBounds(50, 10, 200, 25);
		panel.add(Cunum);
		b.setBounds(10, 50, 100, 25);
		panel.add(b);
		Acnum.setBounds(50, 40, 200, 25);
		panel.add(Acnum);
		c.setBounds(10, 90, 100, 25);
		panel.add(c);
		Grade.setBounds(50, 90, 200, 25);
		panel.add(Grade);

		JButton ok = new JButton("Ȯ��");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
	add(panel);

		 
		ok.addActionListener(new ActionListener(){ 			//Ȯ�� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ���� 
			public void actionPerformed(ActionEvent e) {
				int cu = Integer.parseInt(Cunum.getText());	//�Ӽ����� ���� �ؽ�Ʈ �ʵ忡�� �޾ƿ�
				String ac = Acnum.getText();
				String gr = Grade.getText();

				Grade_DTO dto = new Grade_DTO();			//dto��ü ����
				dto.setCunum(cu);							//set �Լ��� �̿��Ͽ� ���� ����
				dto.setAcnum(ac);
				dto.setGrade(gr);
				Grade_DAO dao = new Grade_DAO();       		//dao ��ü ����
				boolean ok = dao.insert(dto);				//dao�� insert �Լ��� ���ڷ� dto�� �־� boolean�� ���Ϲ���

				dispose(); // ������ ������ â�� ����

			}
		});



		setSize(250, 300);
		setVisible(true);
	}
}
