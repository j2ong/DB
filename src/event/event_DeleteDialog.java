package event;

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

public class event_DeleteDialog extends JFrame{
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Enum;
	public JLabel a;

	public event_DeleteDialog() {
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

	Enum = new TextField(10);
	 a = new JLabel("�̺�Ʈ ��ȣ");
	a.setPreferredSize(new Dimension(70,50));
	
	
	Ce.add(a);
	Ce.add(Enum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ 			//���� ��ư�� Ŭ���Ǹ� �׼��̺�Ʈ ����  
        public void actionPerformed(ActionEvent e) {
        	int en = Integer.parseInt(Enum.getText());	//Ű ���� ������
            event_DAO dao = new event_DAO();       		//dao ��ü ����
            boolean ok = dao.delete(en);				//DAOŬ������ delete�� Ű���� ���ڷ� �־� ȣ���� ���� boolean�� ���Ϲ���
            
            dispose(); // ������ ������ â�� ����
        }
        });
	setSize(300, 200);
	setVisible(true);
}
}
