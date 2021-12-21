package Loan;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;

public class Loan_UpdateDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Lnum, Lamount, Ltype, Acnum;
	public JLabel a,b,c,d;

	public Loan_UpdateDialog() {
	setTitle("Update");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
	setLayout(new BorderLayout());
	
	JPanel panel = new JPanel();
	Lnum = new TextField(10);
	Lamount = new TextField(10);
	Ltype = new TextField(10);
	Acnum = new TextField(10);

	a = new JLabel("대출 번호");
	b = new JLabel("대출 금액");
	c = new JLabel("대출 유형");
	d = new JLabel("계좌 번호");
	
	
	a.setPreferredSize(new Dimension(70,30));
	b.setPreferredSize(new Dimension(70,30));
	c.setPreferredSize(new Dimension(70,30));
	d.setPreferredSize(new Dimension(70,30));
	

	a.setBounds(10, 10, 100, 25);
	panel.add(a);
	 Lnum.setBounds(50, 10, 200, 25);
	panel.add(Lnum);
	
	b.setBounds(10, 50, 100, 25);
	panel.add(b);
	 Lamount.setBounds(50, 40, 200, 25);
	panel.add(Lamount);
	
	c.setBounds(10, 90, 100, 25);
	panel.add(c);
	 Ltype.setBounds(50, 70, 200, 25);
	panel.add(Ltype);
	
	d.setBounds(10, 90, 100, 25);
	panel.add(d);
	 Acnum.setBounds(50, 70, 200, 25);
	panel.add(Acnum);
	

	JButton ok = new JButton("확인");
	ok.setBounds(10, 80, 100, 25);
	panel.add(ok);
	add(panel);

	 
	ok.addActionListener(new ActionListener(){ 				//확인 버튼이 클릭되면 액션이벤트 실행 
		public void actionPerformed(ActionEvent e) {
			
			int ln = Integer.parseInt(Lnum.getText());		//텍스트 필드에서 속성의 값을 가져옴	
			int la = Integer.parseInt(Lamount.getText());
			String ad = Ltype.getText();
			String ac = Acnum.getText();

			Loan_DTO dto = new Loan_DTO();					//dto 객체 생성
			dto.setLnum(ln);								//set 함수를 이용 값 넣음
			dto.setLamount(la);
			dto.setLtype(ad);
			dto.setAcnum(ac);
			Loan_DAO dao = new Loan_DAO();       			//dao 객체 생성
			boolean ok = dao.update(dto);					//dto 값을 인자로 dao의 update 함수 호출후 boolean값 리턴받음

			dispose(); // 실행이 끝나면 창을 닫음

		}
	});
	setSize(280, 230);
	setVisible(true);
}
}
