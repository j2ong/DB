package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

public class Customer_Panel extends JFrame implements ActionListener {
public JPanel contentPane;
	
	public Connection con = null;
	private String colName[] = { "고객 번호","계좌 번호","고객 이름" };
	private DefaultTableModel model = new DefaultTableModel(colName,0);
	private JTable table = new JTable(model);
	JButton selete, insert, delete, update;


	public Customer_Panel() {
		setTitle("Customer table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		panel.add(table, BorderLayout.CENTER);
		table.setPreferredSize(new Dimension(100, 100));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox, BorderLayout.SOUTH);
		
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		table.setPreferredSize(new Dimension(300, 300));
		
		selete = new JButton("검색");
		insert = new JButton("추가");
		delete = new JButton("삭제");
		update = new JButton("수정");

		insert.addActionListener(this);
        selete.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
        
        Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_1);
		horizontalBox.add(selete);
		horizontalBox.add(insert);
		horizontalBox.add(delete);
		horizontalBox.add(update);
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer(); //가운데 정렬을 위한 함수
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel(); // 정렬할 테이블의 ColumnModel을 가져옴
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) { // for문을 이용 가운데 정렬
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		
	}
	//각각의 버튼에서 Source를 가져와 생성자 호출
		   public void actionPerformed(ActionEvent e) {
		      if(e.getSource() == insert) {
		         new Customer_InsertDialog();
		      }
		      else if(e.getSource() == selete) {
		    	  Customer_DAO dao = new Customer_DAO();
		          dao.select(model);
		      }
		      else if(e.getSource() == update) {
		         new Customer_UpdateDialog();
		      }
		      else if(e.getSource() == delete) {
		         new Customer_DeleteDialog();
		      }
		      
		   }
		
		

	
	public static void main(String args[]) {
		new Customer_Panel();
	}
}
