package Customer;
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

public class Customer_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Cunum , Cname, Acnum;
	public JLabel a,b,c;

	public Customer_UpdateDialog() {
	setTitle("Update");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
	setLayout(new BorderLayout());
	
	JPanel panel = new JPanel();
	Cunum = new TextField(10);
	Cname = new TextField(10);
	Acnum = new TextField(10);

	a = new JLabel("�� ��ȣ");
	b = new JLabel("�� �̸�");
	c = new JLabel("���� ��ȣ");
	a.setPreferredSize(new Dimension(70,50));
	b.setPreferredSize(new Dimension(70,50));
	c.setPreferredSize(new Dimension(70,50));


	a.setBounds(10, 10, 100, 250);
	panel.add(a);
	Cunum.setBounds(50, 10, 200, 25);
	panel.add(Cunum);
	c.setBounds(10, 50, 100, 25);
	panel.add(c);
	Acnum.setBounds(50, 40, 200, 25);
	panel.add(Acnum);
	b.setBounds(10, 90, 100, 25);
	panel.add(b);
	Cname.setBounds(50, 90, 200, 25);
	panel.add(Cname);

	JButton ok = new JButton("Ȯ��");
	ok.setBounds(10, 80, 100, 25);
	panel.add(ok);
add(panel);
	
	
	ok.addActionListener(new ActionListener(){ 				//Ȯ�� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ����
        public void actionPerformed(ActionEvent e) {
			int cu = Integer.parseInt(Cunum.getText());		//�ؽ�Ʈ �ʵ忡�� ���� ������
			String cn = Cname.getText();
			String ac = Acnum.getText();
			
			Customer_DTO dto = new Customer_DTO();			//dto ��ü ����
			dto.setCunum(cu);								//set �Լ��� �̿��Ͽ� ���� ����
			dto.setCname(cn);
			dto.setAcnum(ac);
            Customer_DAO dao = new Customer_DAO();       	//dao ��ü ����
            boolean ok = dao.update(dto);					// DAO�� update �Լ��� ȣ���ϰ� boolean ���� ���Ϲ���
            
            dispose(); // ������ ������ â�� ����
        }
        });
	setSize(250, 300);
	setVisible(true);
}
}
