package Save;

import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;

public class Save_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Snum, Samount, Stype, Acnum;
	public JLabel a,b,c,d;

	public Save_InsertDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		Snum = new TextField(10);
		Samount = new TextField(10);
		Stype = new TextField(10);
		Acnum = new TextField(10);

		a = new JLabel("적금 번호");
		b = new JLabel("적금 금액");
		c = new JLabel("적금 유형");
		d = new JLabel("계좌 번호");
		
		
		a.setPreferredSize(new Dimension(70,30));
		b.setPreferredSize(new Dimension(70,30));
		c.setPreferredSize(new Dimension(70,30));
		d.setPreferredSize(new Dimension(70,30));
		

		a.setBounds(10, 10, 100, 25);
		panel.add(a);
		 Snum.setBounds(50, 10, 200, 25);
		panel.add(Snum);
		
		b.setBounds(10, 50, 100, 25);
		panel.add(b);
		 Samount.setBounds(50, 40, 200, 25);
		panel.add(Samount);
		
		c.setBounds(10, 90, 100, 25);
		panel.add(c);
		 Stype.setBounds(50, 70, 200, 25);
		panel.add(Stype);
		
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
				
				int sn = Integer.parseInt(Snum.getText());		//속성의 값을 텍스트 필드에서 가져옴
				int sa = Integer.parseInt(Samount.getText());
				String st = Stype.getText();
				String ac = Acnum.getText();

				Save_DTO dto = new Save_DTO();					//dto 객체 생성
				dto.setSnum(sn);								//set 함수를 이용해 값을 전달
				dto.setSamount(sa);
				dto.setStype(st);
				dto.setAcnum(ac);
				Save_DAO dao = new Save_DAO();       			//dao 객체 생성
				boolean ok = dao.insert(dto);					//dto를 인자로 dao의 insert 함수를 호출 후 boolean값 리턴받음

				dispose(); // 실행이 끝나면 창을 닫음

			}
		});



		setSize(280, 230);
		setVisible(true);
	}
}
