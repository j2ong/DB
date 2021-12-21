package Card;

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

public class Card_Panel extends JFrame implements ActionListener {
public JPanel contentPane;
	
	public Connection con = null;
	private String colName[] = { "ī�� ��ȣ", "���� ��ȣ" , "ī�� ����" };
	private DefaultTableModel model = new DefaultTableModel(colName,0);
	private JTable table = new JTable(model);
	JButton selete, insert, delete, update;


	public Card_Panel() {
		setTitle("Card table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Card");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		panel.add(table, BorderLayout.CENTER);
		table.setPreferredSize(new Dimension(100, 100));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel.add(horizontalBox, BorderLayout.SOUTH);
		
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
		table.setPreferredSize(new Dimension(300, 300));

		
		selete = new JButton("�˻�");
		insert = new JButton("�߰�");
		delete = new JButton("����");
		update = new JButton("����");

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
		
		
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer(); //��� ������ ���� �Լ�
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel(); // ������ ���̺��� ColumnModel�� ������
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) { // for���� �̿� ��� ����
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		
	}
	//������ ��ư���� Source�� ������ ������ ȣ��
		   public void actionPerformed(ActionEvent e) {
		      if(e.getSource() == insert) {
		         new Card_InsertDialog();
		      }
		      else if(e.getSource() == selete) {
		    	  Card_DAO dao = new Card_DAO();
		          dao.select(model);
		      }
		      else if(e.getSource() == update) {
		         new Card_UpdateDialog();
		      }
		      else if(e.getSource() == delete) {
		         new Card_DeleteDialog();
		      }
		      
		   }
		
		

	
	public static void main(String args[]) {
		new Card_Panel();
	}
}
