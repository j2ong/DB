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
	 a = new JLabel("이벤트 번호");
	a.setPreferredSize(new Dimension(70,50));
	
	
	Ce.add(a);
	Ce.add(Enum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	ok.addActionListener(new ActionListener(){ 			//삭제 버튼이 클릭되면 액션이벤트 실행  
        public void actionPerformed(ActionEvent e) {
        	int en = Integer.parseInt(Enum.getText());	//키 값만 가져옴
            event_DAO dao = new event_DAO();       		//dao 객체 생성
            boolean ok = dao.delete(en);				//DAO클래스의 delete에 키값을 인자로 넣어 호출한 다음 boolean값 리턴받음
            
            dispose(); // 실행이 끝나면 창을 닫음
        }
        });
	setSize(300, 200);
	setVisible(true);
}
}
