package Infor;

import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;

public class Infor_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Cname, Phone, Address, Cunum;
	public JLabel a,b,c;

	public Infor_InsertDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		Cunum = new TextField(10);
		Cname = new TextField(10);
		Address = new TextField(10);
		Phone = new TextField(10);

		a = new JLabel("�� �̸�");
		b = new JLabel("��ȭ ��ȣ");
		c = new JLabel("�� �ּ�");
		
		a.setPreferredSize(new Dimension(70,30));
		b.setPreferredSize(new Dimension(70,30));
		c.setPreferredSize(new Dimension(70,30));


		a.setBounds(10, 10, 100, 25);
		panel.add(a);
		 Cname.setBounds(50, 10, 200, 25);
		panel.add(Cname);
		
		b.setBounds(10, 50, 100, 25);
		panel.add(b);
		 Phone.setBounds(50, 40, 200, 25);
		panel.add(Phone);
		
		c.setBounds(10, 90, 100, 25);
		panel.add(c);
		 Address.setBounds(50, 70, 200, 25);
		panel.add(Address);

		JButton ok = new JButton("Ȯ��");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
		add(panel);

		 
		ok.addActionListener(new ActionListener(){ 			//Ȯ�� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ���� 
			public void actionPerformed(ActionEvent e) {
				
				String cn = Cname.getText();				//�Ӽ��� ���� �ؽ�Ʈ�ʵ忡�� ������
				String ph = Phone.getText();
				String ad = Address.getText();

				Infor_DTO dto = new Infor_DTO();			//dto ��ü ����
				dto.setCname(cn);							//set �Լ��� �̿��� ���� ����
				dto.setPhone(ph);
				dto.setAddress(ad);
				Infor_DAO dao = new Infor_DAO();       		//dao ��ü ����
				boolean ok = dao.insert(dto);				//dto�� ���ڷ� dao�� insert �Լ��� ȣ���� boolean�� ��������

				dispose(); // ������ ������ â�� ����

			}
		});



		setSize(280, 230);
		setVisible(true);
	}
}
