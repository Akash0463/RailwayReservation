import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScreenPointFive implements ActionListener
{
	JFrame f;
	JButton pnr,book,cancel,show,view,back,back1;
	JLabel enterpnr;
	JTextField pnrt;
	String pnrno;
	Connection con;
	Statement stmt;
	
	public ScreenPointFive() throws Exception
	{
		f=new JFrame("Railway reservation");
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","");  
		stmt=con.createStatement();
		
		pnr=new JButton("PNR Check");			pnr.setVisible(true);
		book=new JButton("Book Ticket");		book.setVisible(true);
		cancel=new JButton("Cancel Ticket");	cancel.setVisible(true);
		show=new JButton("Show");				show.setVisible(false);
		view=new JButton("View");				view.setVisible(false);
		back=new JButton("Back");				back.setVisible(false);
		back1=new JButton("Back");				back1.setVisible(false);
		
		pnr.setBounds(130, 50, 130, 50);		pnr.addActionListener(this);
		book.setBounds(130, 130, 130, 50);		book.addActionListener(this);
		cancel.setBounds(130, 210, 130, 50);	cancel.addActionListener(this);
		
		
		enterpnr=new JLabel("Enter PNR No");
		enterpnr.setFont(new Font("Times New Roman", Font.BOLD, 18));
		enterpnr.setBounds(140,130,150,30);
		
		pnrt=new JTextField();
		pnrt.setBounds(130,160,140,30);
		
		show.setBounds(150, 200, 100, 30);		show.addActionListener(this);
		view.setBounds(150, 200, 100, 30);		view.addActionListener(this);
		back.setBounds(140, 250, 120, 30);		back.addActionListener(this);
		back1.setBounds(140, 250, 120, 30);		back1.addActionListener(this);
		
		enterpnr.setVisible(false);
		pnrt.setVisible(false);
		
		f.add(pnr);f.add(book);f.add(cancel);f.add(enterpnr);f.add(show);f.add(pnrt);f.add(view);
		f.add(back);f.add(back1);
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(400, 400);
		f.setLocation(470, 100);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) throws Exception 
	{
		new ScreenPointFive();
	}

	public void actionPerformed(ActionEvent e) 
	{	
		if(e.getSource()==book)
		{
			f.dispose();
			new Screen();
		}
		
		if(e.getSource()==pnr)
		{
			book.setVisible(false);
			cancel.setVisible(false);
			
			enterpnr.setVisible(true);
			pnrt.setVisible(true);
			show.setVisible(true);
			back.setVisible(true);
			
		}
		
		if(e.getSource()==show)
		{
			try
			{
			pnrno=pnrt.getText();
			
			ResultSet rs=stmt.executeQuery("Select pnr from pnrwala where pnr="+pnrno+"");
			if(rs.next()==false)
			{
				JOptionPane.showMessageDialog(f, "Invalid PNR", "Error", 0);
			}
			else
			{
			f.dispose();
			PnrStatus p=new PnrStatus();
			p.getData(pnrno);
			}
			}catch (Exception e1) {}
		}
		
		if(e.getSource()==cancel)
		{
			cancel.setBounds(130, 50, 130, 50);
			book.setVisible(false);
			pnr.setVisible(false);
			show.setVisible(false);
			
			back1.setVisible(true);
			enterpnr.setVisible(true);
			pnrt.setVisible(true);
			view.setVisible(true);
			
		}
		
		if(e.getSource()==view)
		{
			ResultSet rs;
			try{
				pnrno=pnrt.getText();
			rs = stmt.executeQuery("Select pnr from pnrwala where pnr="+pnrno+""); 
			if(rs.next()==false)
			{
				JOptionPane.showMessageDialog(f, "Invalid PNR", "Error", 0);
			}
			else
			{
			f.dispose();
			PnrStatus p=new PnrStatus();
			p.getData(pnrno);
			p.changeButton("change");
			}
			}
			catch (Exception e1) {}
			
		}
		if(e.getSource()==back)
		{
			show.setVisible(false);
			pnrt.setVisible(false);
			back.setVisible(false);
			
			pnr.setVisible(true);
			book.setVisible(true);
			cancel.setVisible(true);
		}
		
		if(e.getSource()==back1)
		{
			cancel.setBounds(130, 210, 130, 50);
			enterpnr.setVisible(false);
			pnrt.setVisible(false);
			back1.setVisible(false);
			view.setVisible(false);
			
			pnr.setVisible(true);
			cancel.setVisible(true);
			book.setVisible(true);
		}
	}
}




