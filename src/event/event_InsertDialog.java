package event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class event_InsertDialog extends JFrame {
	public Connection con = null;
	private String row[] = new String[14];
	private JTable table = new JTable();
	public TextField Enum, Cunum;
	public JLabel a,b;

	public event_InsertDialog() {
	setTitle("Insert");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
	setLayout(new BorderLayout());

	JPanel Up = new JPanel();
	Up.setLayout(new FlowLayout());
	JPanel Ce = new JPanel();
	Ce.setLayout(new FlowLayout());
	JPanel Do = new JPanel();

	JButton ok = new JButton("확인");

	Enum = new TextField(10);
	Cunum = new TextField(10);
	 a = new JLabel("이벤트 번호");
	 b = new JLabel("고객 번호");
	a.setPreferredSize(new Dimension(70,30));
	b.setPreferredSize(new Dimension(70,30));
	
	Up.add(a);
	Up.add(Enum);
	
	Ce.add(b);
	Ce.add(Cunum);
	Do.add(ok);

	add(Up,BorderLayout.NORTH);
	add(Ce,BorderLayout.CENTER);
	add(Do,BorderLayout.SOUTH);
	
	
	ok.addActionListener(new ActionListener(){ 			//확인 버튼이 클릭되면 액션이벤트 실행  
        public void actionPerformed(ActionEvent e) {
        	int en = Integer.parseInt(Enum.getText());	//속성들의 값을 텍스트필드에서 받아옴
			int cu = Integer.parseInt(Cunum.getText());
			event_DTO dto = new event_DTO();			//dto 객체 생성
			dto.setEnum(en);							//set 함수 이용 값을 전달
			dto.setCunum(cu);
            event_DAO dao = new event_DAO();       		//dao 객체 생성
            boolean ok = dao.insert(dto);				//dto 값을 인자로 넣어 dao의 insert를 호출 후 boolean 값 리턴받음
            
            dispose(); // 실행이 끝나면 창을 닫음
    
        }
        });



	setSize(300, 200);
	setVisible(true);
}
}
