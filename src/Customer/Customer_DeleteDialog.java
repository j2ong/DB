package Customer;

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

public class Customer_DeleteDialog extends JFrame{
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Enum;
	public JLabel a;

	public Customer_DeleteDialog() {
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

	Enum = new TextField(10);
	 a = new JLabel("고객 번호");
	a.setPreferredSize(new Dimension(70,50));
	
	
	Ce.add(a);
	Ce.add(Enum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ //  //삭제 버튼이 클릭되면 액션이벤트 실행
        public void actionPerformed(ActionEvent e) {
        	int en = Integer.parseInt(Enum.getText());	//텍스트 필드에서 키 값을 가져옴
            Customer_DAO dao = new Customer_DAO();       //DAO 객체 생성후
            boolean ok = dao.delete(en);	//dao의 delete 함수에 키값을 인자로 집어넣어 boolean값을 리턴받음
            
            dispose(); // 실행이 끝나면 창을 닫음
        }
        });
	setSize(200, 200);
	setVisible(true);
}
}
