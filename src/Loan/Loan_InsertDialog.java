package Loan;

import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;

public class Loan_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Lnum, Lamount, Ltype, Acnum;
	public JLabel a,b,c,d;

	public Loan_InsertDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		Lnum = new TextField(10);
		Lamount = new TextField(10);
		Ltype = new TextField(10);
		Acnum = new TextField(10);

		a = new JLabel("���� ��ȣ");
		b = new JLabel("���� �ݾ�");
		c = new JLabel("���� ����");
		d = new JLabel("���� ��ȣ");
		
		
		a.setPreferredSize(new Dimension(70,30));
		b.setPreferredSize(new Dimension(70,30));
		c.setPreferredSize(new Dimension(70,30));
		d.setPreferredSize(new Dimension(70,30));
		

		a.setBounds(10, 10, 100, 25);
		panel.add(a);
		 Lnum.setBounds(50, 10, 200, 25);
		panel.add(Lnum);
		
		b.setBounds(10, 50, 100, 25);
		panel.add(b);
		 Lamount.setBounds(50, 40, 200, 25);
		panel.add(Lamount);
		
		c.setBounds(10, 90, 100, 25);
		panel.add(c);
		 Ltype.setBounds(50, 70, 200, 25);
		panel.add(Ltype);
		
		d.setBounds(10, 90, 100, 25);
		panel.add(d);
		 Acnum.setBounds(50, 70, 200, 25);
		panel.add(Acnum);
		

		JButton ok = new JButton("Ȯ��");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
		add(panel);

		 
		ok.addActionListener(new ActionListener(){ 				//Ȯ�� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ���� 
			public void actionPerformed(ActionEvent e) {
				
				int ln = Integer.parseInt(Lnum.getText());		//�ؽ�Ʈ �ʵ忡�� �Ӽ��� ���� ������	
				int la = Integer.parseInt(Lamount.getText());
				String ad = Ltype.getText();
				String ac = Acnum.getText();

				Loan_DTO dto = new Loan_DTO();					//dto ��ü ����
				dto.setLnum(ln);								//set �Լ��� �̿� �� ����
				dto.setLamount(la);
				dto.setLtype(ad);
				dto.setAcnum(ac);
				Loan_DAO dao = new Loan_DAO();       			//dao ��ü ����
				boolean ok = dao.insert(dto);					//dto ���� ���ڷ� dao�� insert �Լ� ȣ���� boolean�� ���Ϲ���

				dispose(); // ������ ������ â�� ����

			}
		});



		setSize(280, 230);
		setVisible(true);
	}
}
