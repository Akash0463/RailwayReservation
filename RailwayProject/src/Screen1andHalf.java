import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Screen1andHalf implements ActionListener
{
	JFrame f;
	JLabel head,choose;
	JTable table;
	DefaultTableModel model;
	JScrollPane sp;
	JTextField sl,ac2,ac3,gf1,gf2,gf3;
	JComboBox cb;
	JButton back,book,getavl,getfare;
	Statement stmt;
	ResultSet rs;
	Connection con;
	String date,fromstsn,tostsn;
	StringBuffer sb1,sb2,sb3;
	String[] arr; 
	public Screen1andHalf() 
	{
		f=new JFrame();
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		head=new JLabel("Availability");
		head.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		table=new JTable();
		model=new DefaultTableModel();
		sp=new JScrollPane(table);
		
		model.addColumn("Train No");
		model.addColumn("Train Name");
		model.addColumn("Class-1");
		model.addColumn("Class-2");
		model.addColumn("Class-3");
		
		table.setRowHeight(37);
		table.setModel(model);
		
		sl=new JTextField();
		ac2=new JTextField();
		ac3=new JTextField();
		gf1=new JTextField();
		gf2=new JTextField();
		gf3=new JTextField();
		
		String[] cls= {"SL","3AC","2AC","CC","2S"};
		cb=new JComboBox(cls);
		
		choose=new JLabel("Select a Class : ");
		choose.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		book=new JButton("Book");
		back=new JButton("Back");
		getavl=new JButton("Get Availability"); 
		getfare=new JButton("Get Fare");
		getfare.addActionListener(this);
		getavl.addActionListener(this);
		
		head.setBounds(230, 20, 200, 30);
		sp.setBounds(40, 70, 540, 60);
		
		getavl.setBounds(40, 140, 170, 40);
		getfare.setBounds(40, 190, 170, 40);
		
		sl.setBounds(250, 140, 100, 40);		gf1.setBounds(250, 190, 100, 40);
		ac2.setBounds(357, 140, 100, 40);		gf2.setBounds(357, 190, 100, 40);
		ac3.setBounds(464, 140, 100, 40);		gf3.setBounds(464, 190, 100, 40);
		choose.setBounds(50, 270, 150, 40);
		cb.setBounds(180, 270, 100, 30);
		book.setBounds(420, 270, 120, 30);
		back.setBounds(280, 350, 120, 30);
		
		book.addActionListener(this);
		back.addActionListener(this);
		
		f.add(head);f.add(sp);f.add(sl);f.add(ac2);
		f.add(ac3);f.add(cb);f.add(choose);f.add(back);
		f.add(book);f.add(getavl);f.add(getfare);f.add(gf1);
		f.add(gf2);f.add(gf3);
		
		f.setSize(650, 500);
		f.setLocation(340, 60);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void getDetails(String trainno,String date,String fromstsn,String tostsn) throws Exception 
	{
		this.date=date;
		this.fromstsn=fromstsn;
		this.tostsn=tostsn;
		String details ="",getseat1="",getseat2="",getseat3="";
		
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","");  
		stmt=con.createStatement();
		
		rs=stmt.executeQuery("select tno,tname,cls1,cls2,cls3 from traindetails where tno='"+trainno+"'");
		while(rs.next())
		details=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5);
	//	System.out.println(details);
		putValues(details);
		
	}
	
	public void putValues(String data)
	{
		for(int i=0;i<data.length();i++)
		{
			arr=data.split(" ");
			model.addRow(arr);
		}
	}
	
		@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==back)
		{
			f.dispose();
			new Screen();
		}
		
		if(e.getSource()==getavl)
		{
			try
			{
				//System.out.println(arr[0]);
			int getseat2 = 0,getseat3=0,getseat1=0;	
				
			ResultSet rs1=stmt.executeQuery("select totalseat from availability where tno='"+arr[0]+"' and cls='SL'");
			while(rs1.next())
			getseat1=rs1.getInt(1);
			
			if(getseat1<=0)
				sl.setForeground(Color.RED);
			else
				sl.setForeground(Color.GREEN);
			
			
			String cls2=(String) table.getValueAt(0, 3);
			ResultSet rs2=stmt.executeQuery("select totalseat from availability where tno='"+arr[0]+"' and cls='"+cls2+"'");
			while(rs2.next())
			getseat2=rs2.getInt(1);
			
			String cls3=(String) table.getValueAt(0, 4);
			ResultSet rs3=stmt.executeQuery("select totalseat from availability where tno='"+arr[0]+"' and cls='"+cls3+"'");
			while(rs3.next())
			getseat3=rs3.getInt(1);
		
			sl.setText("   SL-"+"["+getseat1+"]");
			if(getseat2<=0)
				ac2.setForeground(Color.RED);
			else
				ac2.setForeground(Color.GREEN);
			
			if(getseat3<=0)
				ac3.setForeground(Color.RED);
			else
				ac3.setForeground(Color.GREEN);
			
		    ac2.setText("   "+cls2+"-"+"["+getseat2+"]");
		    ac3.setText("   "+cls3+"-"+"["+getseat3+"]");
			}
			catch (Exception e2) 
			{}
		}
		
		if(e.getSource()==book)
		{
			String data="",data1 = null;
			String cls=cb.getSelectedItem().toString();
			try 
			{
				ResultSet rs4=stmt.executeQuery("select tno,tname from traindetails where tno='"+arr[0]+"'");
				while(rs4.next())
				data1=rs4.getString(1)+" "+rs4.getString(2)+" ";
				
				ResultSet rs45=stmt.executeQuery("select fromstn,tostn tname from journeydetails where tno='"+arr[0]+"'");
				while(rs45.next())
				data=data1+rs45.getString(1)+" "+rs45.getString(2)+" ";
				
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			String str=cb.getSelectedItem().toString();
			f.dispose();
			Screen2 s2=new Screen2();
			s2.setValues(data,cls,date,sb1,sb2,sb3,str);
		}
		
		if(e.getSource()==getfare)
		{
			try {
				ResultSet rs5=stmt.executeQuery("select fare from ticketfare where class='SL' and tno="+arr[0]+"");
				while(rs5.next())
					sb1=new StringBuffer(rs5.getString(1));
					gf1.setText("  SL-"+sb1);
					
					
				String cls2=(String)table.getValueAt(0, 3);	
				ResultSet rs6=stmt.executeQuery("select fare from ticketfare where class='"+cls2+"' and tno="+arr[0]+"");
				while(rs6.next())
					sb2=new StringBuffer(rs6.getString(1));
					gf2.setText("  "+cls2+"-"+sb2);
					
				String cls3=(String)table.getValueAt(0, 4);
				ResultSet rs7=stmt.executeQuery("select fare from ticketfare where class='"+cls3+"' and tno="+arr[0]+"");
				while(rs7.next())
					sb3=new StringBuffer(rs7.getString(1));
					gf3.setText("  "+cls3+"-"+sb3);
					
					gf1.setEditable(false);
					gf2.setEditable(false);
					gf3.setEditable(false);
			
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
	}
		public static void main(String[] args) 
		{
			new Screen1andHalf();
		}
	
}



