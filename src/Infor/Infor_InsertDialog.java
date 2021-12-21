package Infor;

import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;

public class Infor_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Cname, Phone, Address, Cunum;
	public JLabel a,b,c;

	public Infor_InsertDialog() {
		setTitle("Insert");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
		setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		Cunum = new TextField(10);
		Cname = new TextField(10);
		Address = new TextField(10);
		Phone = new TextField(10);

		a = new JLabel("고객 이름");
		b = new JLabel("전화 번호");
		c = new JLabel("고객 주소");
		
		a.setPreferredSize(new Dimension(70,30));
		b.setPreferredSize(new Dimension(70,30));
		c.setPreferredSize(new Dimension(70,30));


		a.setBounds(10, 10, 100, 25);
		panel.add(a);
		 Cname.setBounds(50, 10, 200, 25);
		panel.add(Cname);
		
		b.setBounds(10, 50, 100, 25);
		panel.add(b);
		 Phone.setBounds(50, 40, 200, 25);
		panel.add(Phone);
		
		c.setBounds(10, 90, 100, 25);
		panel.add(c);
		 Address.setBounds(50, 70, 200, 25);
		panel.add(Address);

		JButton ok = new JButton("확인");
		ok.setBounds(10, 80, 100, 25);
		panel.add(ok);
		add(panel);

		 
		ok.addActionListener(new ActionListener(){ 			//확인 버튼이 클릭되면 액션이벤트 실행 
			public void actionPerformed(ActionEvent e) {
				
				String cn = Cname.getText();				//속성의 값을 텍스트필드에서 가져옴
				String ph = Phone.getText();
				String ad = Address.getText();

				Infor_DTO dto = new Infor_DTO();			//dto 객체 생성
				dto.setCname(cn);							//set 함수를 이용해 값을 전달
				dto.setPhone(ph);
				dto.setAddress(ad);
				Infor_DAO dao = new Infor_DAO();       		//dao 객체 생성
				boolean ok = dao.insert(dto);				//dto를 인자로 dao의 insert 함수를 호출후 boolean값 리런받음

				dispose(); // 실행이 끝나면 창을 닫음

			}
		});



		setSize(280, 230);
		setVisible(true);
	}
}
