package Account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Account_DeleteDialog extends JFrame{
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Acnum;
	public JLabel a;

	public Account_DeleteDialog() {
	setTitle("Delete");
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
	 a = new JLabel("���� ��ȣ");
	a.setPreferredSize(new Dimension(70,50));
	
	
	Ce.add(a);
	Ce.add(Acnum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ //���� ��ư�� ������ �׼��̺�Ʈ ����, Dao�� delete �Լ��� ȣ���Ѵ�.
        public void actionPerformed(ActionEvent e) {
        	String ac = Acnum.getText();		//Ű ���� �������� ��
            Account_DAO dao = new Account_DAO();       
            boolean ok = dao.delete(ac);	//dao�� delete�Լ��� ���� �� boolean ���� ���Ϲ���
            
            dispose(); // ������ ������ â�� ����
        }
        });
	setSize(300, 200);
	setVisible(true);
}
}
