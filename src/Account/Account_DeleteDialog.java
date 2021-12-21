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
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
	
	setLayout(new BorderLayout());
	
	setLayout(new BorderLayout());
	JPanel Up = new JPanel();
	Up.setLayout(new FlowLayout());
	JPanel Ce = new JPanel();
	Ce.setLayout(new FlowLayout());
	JPanel Do = new JPanel();

	JButton ok = new JButton("삭제");

	Acnum = new TextField(10);
	 a = new JLabel("계좌 번호");
	a.setPreferredSize(new Dimension(70,50));
	
	
	Ce.add(a);
	Ce.add(Acnum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ //삭제 버튼을 누르면 액션이벤트 실행, Dao의 delete 함수를 호출한다.
        public void actionPerformed(ActionEvent e) {
        	String ac = Acnum.getText();		//키 값만 가져오면 됨
            Account_DAO dao = new Account_DAO();       
            boolean ok = dao.delete(ac);	//dao의 delete함수를 실행 후 boolean 값을 리턴받음
            
            dispose(); // 실행이 끝나면 창을 닫음
        }
        });
	setSize(300, 200);
	setVisible(true);
}
}
