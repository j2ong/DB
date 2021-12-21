package BankMain;

import Account.Account_DAO;
import Account.Account_DeleteDialog;
import Account.Account_InsertDialog;
import Account.Account_Panel;
import Account.Account_UpdateDialog;
import Branch.Branch_Panel;
import Card.Card_Panel;
import Customer.Customer_Panel;
import event.event_Panel;
import Grade.Grade_Panel;
import Infor.Infor_Panel;
import Loan.Loan_Panel;
import Partner.Partner_Panel;
import Save.Save_Panel;

import java.sql.Connection;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import Save.Save_Panel;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class MainFrame extends JFrame{

	public MainFrame() {
		setTitle("JEong Hyeon Bank DataBase");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2,5));		// 그리드 레이아웃을 사용해 10개의 테이블이 배치될수 있도록 설정
		Account_Panel a = new Account_Panel();		//10가지 테이블의 객체를 생성
		event_Panel e = new event_Panel();
		Customer_Panel c = new Customer_Panel();
		Branch_Panel b = new Branch_Panel();
		Card_Panel c2 = new Card_Panel();
		Grade_Panel g = new Grade_Panel();
		Infor_Panel i = new Infor_Panel();
		Loan_Panel  l = new Loan_Panel();
		Partner_Panel p = new Partner_Panel();
		Save_Panel s = new Save_Panel();
		this.add(a.contentPane);					//메인 프레임 안에 집어넣음
		this.add(e.contentPane);
		this.add(c.contentPane);
		this.add(b.contentPane);
		this.add(c2.contentPane);
		this.add(g.contentPane);
		this.add(i.contentPane);
		this.add(l.contentPane);
		this.add(p.contentPane);
		this.add(s.contentPane);
		
		
		
		setSize(1300, 650);
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new MainFrame();
	}
}
