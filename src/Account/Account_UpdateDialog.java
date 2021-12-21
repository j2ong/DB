package Account;
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

public class Account_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Acnum, Balance;
	public JLabel a,b;

	public Account_UpdateDialog() {
	setTitle("Update");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
	setLayout(new BorderLayout());
	
	setLayout(new BorderLayout());
	JPanel Up = new JPanel();
	Up.setLayout(new FlowLayout());
	JPanel Ce = new JPanel();
	Ce.setLayout(new FlowLayout());
	JPanel Do = new JPanel();

	JButton ok = new JButton("����");

	Acnum = new TextField(10);
	Balance = new TextField(10);
	 a = new JLabel("���� ��ȣ");
	 b = new JLabel("�� ��");
	a.setPreferredSize(new Dimension(70,50));
	b.setPreferredSize(new Dimension(70,50));
	
	Up.add(a);
	Up.add(Acnum);
	
	Ce.add(b);
	Ce.add(Balance);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ 		// ���� ��ư�� ������ �׼��̺�Ʈ ����, Dao�� Update�� ȣ���Ѵ�.
        public void actionPerformed(ActionEvent e) {
        	String ac = Acnum.getText();
			int ba = Integer.parseInt(Balance.getText());
			Account_DTO dto = new Account_DTO();
			dto.setAccount(ac);						//dto Ŭ������ set�Լ��� �̿��� ���� ����
			dto.setBalance(ba);
            Account_DAO dao = new Account_DAO();       
            boolean ok = dao.update(dto);		// DAO�� update �Լ��� ȣ���ϰ� boolean ���� ���Ϲ���
            
            dispose(); // ������ ������ â�� ����
        }
        });
	setSize(300, 200);
	setVisible(true);
}
}
