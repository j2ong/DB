package Partner;

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

public class Partner_DeleteDialog extends JFrame{
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Canum;
	public JLabel a;

	public Partner_DeleteDialog() {
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

	Canum = new TextField(10);
	 a = new JLabel("ī�� ��ȣ ");
	a.setPreferredSize(new Dimension(70,50));
	
	
	Ce.add(a);
	Ce.add(Canum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){			 //���� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ����  
        public void actionPerformed(ActionEvent e) {
        	int ca 	= Integer.parseInt(Canum.getText());	//Ű ���� ������
            Partner_DAO dao = new Partner_DAO();       		//dao ��ü ����
            boolean ok = dao.delete(ca);					//Ű ���� ���ڷ� dao�� delete�Լ� ȣ���� boolean�� ����
            
            dispose(); // ������ ������ â�� ����
        }
        });
	setSize(200, 200);
	setVisible(true);
}
}
