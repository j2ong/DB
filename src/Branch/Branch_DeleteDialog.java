package Branch;

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

public class Branch_DeleteDialog extends JFrame{
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Lnum;
	public JLabel a;

	public Branch_DeleteDialog() {
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

	Lnum = new TextField(10);
	 a = new JLabel("���� ��ȣ ");
	a.setPreferredSize(new Dimension(70,50));
	
	
	Ce.add(a);
	Ce.add(Lnum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ // ���� ��ư�� Ŭ���Ǹ� �׼Ǹ����ʸ� ȣ��, Dao�� delete�� ȣ���Ѵ�
        public void actionPerformed(ActionEvent e) {
        	int ln 	= Integer.parseInt(Lnum.getText());		//Ű���� int ������ �������� ��
            Branch_DAO dao = new Branch_DAO();       
            boolean ok = dao.delete(ln);
            
            dispose(); // ������ ������ â�� ����
        }
        });
	setSize(200, 200);
	setVisible(true);
}
}
