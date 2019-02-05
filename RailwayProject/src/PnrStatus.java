import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PnrStatus implements ActionListener 
{
	JFrame f;
	JLabel pnrq,tnoq,tnameq,dateq,fromq,toq,classq,fareq,head;
	JLabel pnra,tnoa,tnamea,datea,froma,toa,classa,farea;
	JSeparator s1,s2,s3,s4,s5,s6,s7,s8,s9;
	Font ft=new Font("Times New Roman", Font.BOLD, 18);
	Font ft1=new Font("Times New Roman", 0, 18);
	JTable table=new JTable();
	JScrollPane sp=new JScrollPane(table);
	DefaultTableModel mod=new DefaultTableModel();
	JButton ok=new JButton("OK");
	JButton cancel=new JButton("Cancel");
	String arr[]=new String[8];
	String arr1[]=new String[4];
	String data,pnrno;
	Connection con;
	Statement stmt;
	
	public PnrStatus() throws Exception
	{
		f=new JFrame();
		
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","");  
		stmt=con.createStatement();
		
		head=new JLabel("Ticket Status");
		head.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		pnrq=new JLabel("PNR Number");
		tnoq=new JLabel("Train Number");
		tnameq=new JLabel("Train Name");
		dateq=new JLabel("Date");
		fromq=new JLabel("Source Stn");
		toq=new JLabel("Destination Stn");
		classq=new JLabel("Class");
		fareq=new JLabel("Total Booking Fare");
		
		pnra=new JLabel();
		tnoa=new JLabel();
		tnamea=new JLabel();
		datea=new JLabel();
		froma=new JLabel();
		toa=new JLabel();
		classa=new JLabel();
		farea=new JLabel();
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		cancel.setVisible(false);
		
		pnrq.setFont(ft);tnoq.setFont(ft);tnameq.setFont(ft);dateq.setFont(ft);
		fromq.setFont(ft);toq.setFont(ft);classq.setFont(ft);fareq.setFont(ft);
		
		pnra.setFont(ft1);tnoa.setFont(ft1);tnamea.setFont(ft1);datea.setFont(ft1);
		froma.setFont(ft1);toa.setFont(ft1);classa.setFont(ft1);farea.setFont(ft1);
		
		s1=new JSeparator(JSeparator.HORIZONTAL);
		s2=new JSeparator(JSeparator.HORIZONTAL);
		s3=new JSeparator(JSeparator.HORIZONTAL);
		s4=new JSeparator(JSeparator.HORIZONTAL);
		s5=new JSeparator(JSeparator.HORIZONTAL);
		s6=new JSeparator(JSeparator.HORIZONTAL);
		s7=new JSeparator(JSeparator.HORIZONTAL);
		s8=new JSeparator(JSeparator.HORIZONTAL);
		s9=new JSeparator(JSeparator.HORIZONTAL);
		
		mod.addColumn("Passengers");mod.addColumn("Ticket Status");
		table.setModel(mod);
		table.setRowHeight(30);
		head.setBounds(120, 2, 300, 40);
		s1.setBounds(110, 42, 165, 10);
		
		pnrq.setBounds(10, 80, 150, 30);			pnra.setBounds(220, 80, 150, 30);
		s2.setBounds(10, 110, 365, 10);
		
		tnoq.setBounds(10, 120, 150, 30);			tnoa.setBounds(220, 120, 150, 30);
		s3.setBounds(10, 150, 365, 10);
		
		tnameq.setBounds(10, 160, 150, 30);			tnamea.setBounds(220, 160, 150, 30);
		s4.setBounds(10, 190, 365, 10);
		
		dateq.setBounds(10, 200, 150, 30);			datea.setBounds(220, 200, 150, 30);
		s5.setBounds(10, 230, 365, 10);
		
		fromq.setBounds(10, 240, 150, 30);			froma.setBounds(220, 240, 150, 30);
		s6.setBounds(10, 270, 365, 10);
		
		toq.setBounds(10, 280, 150, 30);			toa.setBounds(220, 280, 150, 30);
		s7.setBounds(10, 310, 365, 10);
		
		classq.setBounds(10, 320, 150, 30);			classa.setBounds(220, 320, 150, 30);
		s8.setBounds(10, 350, 365, 10);
		
		fareq.setBounds(10, 360, 200, 30);			farea.setBounds(220, 360, 150, 30);
		s9.setBounds(10, 390, 365, 10);
		sp.setBounds(10, 420, 365, 140);
		ok.setBounds(120, 580, 150, 30);		cancel.setBounds(120, 580, 150, 30);
		
		f.add(head);f.add(ok);f.add(cancel);
		f.add(s1);f.add(s2);f.add(s3);f.add(s4);f.add(s5);f.add(s6);f.add(s7);f.add(s8);f.add(s9);f.add(sp);
		f.add(pnrq);f.add(tnoq);f.add(tnameq);f.add(fromq);f.add(toq);f.add(dateq);f.add(fareq);f.add(classq);
		f.add(pnra);f.add(tnoa);f.add(tnamea);f.add(froma);f.add(toa);f.add(datea);f.add(farea);f.add(classa);
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(400,660);
		f.setLocation(460, 10);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception
	{
		new PnrStatus();
	}

	public void getData(String pnrno) throws SQLException 
	{
		this.pnrno=pnrno;
		ResultSet rs=stmt.executeQuery("select pnrwala.* from pnrwala where pnr="+pnrno+"");
		while(rs.next())
		{
			data=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)
			+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getFloat(8);
			
			for(int i=0;i<data.length();i++)
			{
				arr=data.split(" ");
			}
		}
		
		pnra.setText(arr[0]);tnoa.setText(arr[1]);tnamea.setText(arr[2]);datea.setText(arr[3]);
		froma.setText(arr[4]);toa.setText(arr[5]);classa.setText(arr[6]);farea.setText(arr[7]);
		
		String pasname;
		
		ResultSet rs1=stmt.executeQuery("select pas,status from pnrpas where pnr="+pnrno+"");
		while(rs1.next())
		{
			pasname=rs1.getString(1)+" "+rs1.getString(2);
			arr1=pasname.split(" ");
			mod.addRow(arr1);
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
		if(e.getSource()==ok)
		{
			f.dispose();
			new ScreenPointFive();
		}
		
		if(e.getSource()==cancel)
		{
			int a=JOptionPane.showConfirmDialog(f, "Do You Want to Proceed?");
			if(a==JOptionPane.YES_OPTION)
			{
				stmt.executeUpdate("delete from pnrpas where pnr="+pnrno+"");
				stmt.executeUpdate("delete from pnrwala where pnr="+pnrno+"");
				JOptionPane.showMessageDialog(f, "Cancelled Succesfully");
				f.dispose();
				new ScreenPointFive();
			}
			
			
			if(a==JOptionPane.CANCEL_OPTION||a==JOptionPane.NO_OPTION)
			{
				f.dispose();
				new ScreenPointFive();
			}
			new ScreenPointFive();
		}
		}catch(Exception e1) {}
		
	}

	public void changeButton(String string) 
	{
		ok.setVisible(false);
		cancel.setVisible(true);
	}

	
}
