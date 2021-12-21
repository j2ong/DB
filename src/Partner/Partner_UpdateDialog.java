package Partner;
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

public class Partner_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Canum, Pname, Disrate;
	public JLabel a,b,c;

	public Partner_UpdateDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		Canum = new TextField(10);
		Pname = new TextField(10);
		Disrate = new TextField(10);

		a = new JLabel("ī�� ��ȣ");
		b = new JLabel("���� ��ü");
		c = new JLabel("���� ��");
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

		JButton ok = new JButton("Ȯ��");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
	add(panel);

		 
	ok.addActionListener(new ActionListener(){ 				//Ȯ�� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ����  
		public void actionPerformed(ActionEvent e) {
			int ca = Integer.parseInt(Canum.getText());		//�Ӽ����� ���� �ؽ�Ʈ �ʵ忡�� ������
			String pn = Pname.getText();
			String di = Disrate.getText();

			Partner_DTO dto = new Partner_DTO();			//dto ��ü ����
			dto.setCanum(ca);								//set �Լ��� �̿��� ���� ����
			dto.setPname(pn);
			dto.setDisrate(di);
			Partner_DAO dao = new Partner_DAO();       		//dao ��ü ����
			boolean ok = dao.update(dto);					//dto ���� ���ڷ� dao�� update �Լ��� ȣ�� �� boolean�� ����


				dispose(); // ������ ������ â�� ����

			}
		});

		setSize(250, 300);
		setVisible(true);
	}
}