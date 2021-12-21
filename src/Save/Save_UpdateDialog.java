package Save;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;

public class Save_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Snum, Samount, Stype, Acnum;
	public JLabel a,b,c,d;

	public Save_UpdateDialog() {
	setTitle("Update");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
	setLayout(new BorderLayout());
	
	JPanel panel = new JPanel();
	Snum = new TextField(10);
	Samount = new TextField(10);
	Stype = new TextField(10);
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
	 Snum.setBounds(50, 10, 200, 25);
	panel.add(Snum);
	
	b.setBounds(10, 50, 100, 25);
	panel.add(b);
	 Samount.setBounds(50, 40, 200, 25);
	panel.add(Samount);
	
	c.setBounds(10, 90, 100, 25);
	panel.add(c);
	 Stype.setBounds(50, 70, 200, 25);
	panel.add(Stype);
	
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
			
			int sn = Integer.parseInt(Snum.getText());		//�Ӽ��� ���� �ؽ�Ʈ �ʵ忡�� ������
			int sa = Integer.parseInt(Samount.getText());
			String st = Stype.getText();
			String ac = Acnum.getText();

			Save_DTO dto = new Save_DTO();					//dto ��ü ����
			dto.setSnum(sn);								//set �Լ��� �̿��� ���� ����
			dto.setSamount(sa);
			dto.setStype(st);
			dto.setAcnum(ac);
			Save_DAO dao = new Save_DAO();       			//dao ��ü ����
			boolean ok = dao.update(dto);					//dto�� ���ڷ� dao�� update �Լ��� ȣ�� �� boolean�� ���Ϲ���
            
            dispose(); // ������ ������ â�� ����
        }
        });

	setSize(280, 230);
	setVisible(true);
}
}
