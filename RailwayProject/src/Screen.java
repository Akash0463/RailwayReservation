import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import org.jdesktop.swingx.JXDatePicker;

public class Screen extends JFrame implements ActionListener
{	
	JFrame f;
	JLabel head,frm,to,jdate;
	JButton sub,res,back;  
	JTextField t;
	JComboBox frmcb,tocb;
	JXDatePicker picker;
	ImageIcon img=new ImageIcon("C:\\Users\\aakash\\Desktop\\a.jpg");
	Date date3;
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	String trainnno[]=new String[10];
	String frmstsn,tostsn;
	public Screen()
	{
		f=new JFrame("Railway Reservation");
		f.setContentPane(new JLabel(img));
		head=new JLabel("Plan Your Journey");
		Font font = new Font("Times New Roman", Font.BOLD,20);
		head.setFont(font);
		
		frm=new JLabel("From Station* : ");
		Font font1 = new Font("Times New Roman", Font.PLAIN,17);
		frm.setFont(font1);
		String frmName[]={"Pune-Jn","Dhaulpur","Nagpur-Jn","Kedgaon-St","Chennai-Ct","CSTM-Mumbai"};        
	    frmcb=new JComboBox(frmName);    
		
	    to=new JLabel("To Station* : ");
		Font font2 = new Font("Times New Roman", Font.PLAIN,17);
		to.setFont(font2);
		String toName[]={"Dhaulpur","Pune-Jn","Nagpur-Jn","Kedgaon-St","Chennai-Ct","CSTM-Mumbai"};        
	    tocb=new JComboBox(toName);    
		
	    jdate=new JLabel("Journey Date* : ");
	    Font font3 = new Font("Times New Roman", Font.PLAIN,17);
		jdate.setFont(font3);
		
		picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd-MM-yyyy"));
        
	    sub=new JButton("Search");
	    res=new JButton("Reset");
	    back=new JButton("Back");
	    sub.addActionListener(this);
	    back.addActionListener(this);
	    
	    head.setBounds(10,10,280,30);
	    head.setHorizontalAlignment(JLabel.CENTER);
	    
	    frm.setBounds(30,80,120,30);
		frmcb.setBounds(150,80,120,30);
		
		to.setBounds(30,140,120,30);
		tocb.setBounds(150,140,120,30);
        
        jdate.setBounds(30,200,120,30);
        picker.setBounds(150,200,120,30);
        
		sub.setBounds(40,300,100,30);
		res.setBounds(170,300,100,30);
		back.setBounds(110,350,100,30);
		
	    f.add(head);
	    f.add(frm);
	    f.add(frmcb);
	    f.add(to);
	    f.add(tocb);
	    f.add(jdate);
	    f.add(picker);
	    f.add(sub);
	    f.add(res);
	    f.add(back);
	    
	    f.setLayout(null);
		f.setVisible(true);
		f.setLocation(430, 30);
		f.setSize(350, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String[] details=new String[10];
		String journey[] =new String[10];
		int i=0;//,j=0,k=0;
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","");  
		Statement stmt=con.createStatement();
		
		date3=picker.getDate();
		String date2=formatter.format(date);
		String date4=formatter.format(date3);
		Date d=formatter.parse(date2);
		
		if(e.getSource()==back)
		{
			f.dispose();
			new ScreenPointFive();
		}
		
		if(e.getSource()==sub)
		{
			if(date3.before(d))
			{	
				JOptionPane.showMessageDialog(f, "Invalid Date");
			}
			
			else
			{
				
				frmstsn=frmcb.getSelectedItem().toString();
				tostsn=tocb.getSelectedItem().toString();
				if(frmstsn.equals(tostsn))
				{
					JOptionPane.showMessageDialog(f, "Arrival and Destination can't be same..!");
				}
				else
				{
				ResultSet res=stmt.executeQuery("select tno from journeydetails where fromstn='"+frmstsn+"' and tostn='"+tostsn+"'");
				while(res.next())
				{
					trainnno[i]=res.getString(1);
					//System.out.println(trainnno[i]);
					i++;
				}
				
				for(int j=0;j<i;j++)
				{
				ResultSet res1=stmt.executeQuery("select departure,arrival,traveltime from journeydetails where tno='"+trainnno[j]+"'");
				while(res1.next())
				{
					journey[j]=" "+res1.getString(1)+" "+res1.getString(2)+" "+res1.getString(3);
				}
						
				ResultSet rs=stmt.executeQuery("select tno,tname,cls1,cls2,cls3 from traindetails where tno='"+trainnno[j]+"'");  
				while(rs.next())
				{
		
				details[j]=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+journey[j];	
				}
				}
				f.dispose();
				
				Screen1 s1=new Screen1();
				s1.setValues(details,date4,frmstsn,tostsn);	
			}
		}	
		}
		}
		catch(Exception ae)
		{
			System.out.println(e);
		}
		
		
	}
	
	public static void main(String[] args) 
	{
		new Screen();
	}
}