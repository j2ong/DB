package event;
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

public class event_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Enum, Cunum;
	public JLabel a,b;

	public event_UpdateDialog() {
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

	Enum = new TextField(10);
	Cunum = new TextField(10);
	 a = new JLabel("�̺�Ʈ ��ȣ");
	 b = new JLabel("�� ��ȣ");
	a.setPreferredSize(new Dimension(70,50));
	b.setPreferredSize(new Dimension(70,50));
	
	Up.add(a);
	Up.add(Enum);
	
	Ce.add(b);
	Ce.add(Cunum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ 			//Ȯ�� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ���� 
        public void actionPerformed(ActionEvent e) {
        	int en = Integer.parseInt(Enum.getText());	//�Ӽ����� ���� �ؽ�Ʈ�ʵ忡�� �޾ƿ�
			int cu = Integer.parseInt(Cunum.getText());
			event_DTO dto = new event_DTO();			//dto ��ü ����
			dto.setEnum(en);							//set �Լ� �̿��� ���� ����
			dto.setCunum(cu);
            event_DAO dao = new event_DAO();       		//dao ��ü ����
            boolean ok = dao.update(dto);				//dto���� ���ڷ� dao Ŭ������ update �Լ��� ȣ�� �� boolean�� ���Ϲ���
            
            dispose(); // ������ ������ â�� ����
        }
        });
	setSize(300, 200);
	setVisible(true);
}
}
