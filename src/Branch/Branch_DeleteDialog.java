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
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
	
	setLayout(new BorderLayout());
	
	setLayout(new BorderLayout());
	JPanel Up = new JPanel();
	Up.setLayout(new FlowLayout());
	JPanel Ce = new JPanel();
	Ce.setLayout(new FlowLayout());
	JPanel Do = new JPanel();

	JButton ok = new JButton("삭제");

	Lnum = new TextField(10);
	 a = new JLabel("대출 번호 ");
	a.setPreferredSize(new Dimension(70,50));
	
	
	Ce.add(a);
	Ce.add(Lnum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ // 삭제 버튼이 클릭되면 액션리스너를 호출, Dao의 delete를 호출한다
        public void actionPerformed(ActionEvent e) {
        	int ln 	= Integer.parseInt(Lnum.getText());		//키값만 int 형으로 가져오면 됨
            Branch_DAO dao = new Branch_DAO();       
            boolean ok = dao.delete(ln);
            
            dispose(); // 실행이 끝나면 창을 닫음
        }
        });
	setSize(200, 200);
	setVisible(true);
}
}
