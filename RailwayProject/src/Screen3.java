import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Screen3 extends JFrame implements ActionListener
{
	JFrame f;
	JLabel head,l1,l2,l3,l4,l5,l6,l7,l8,l9,h2,caplabel,entercapl,phnol,paymt,ttl,ffl,cashl,cardhnamel,cardnol,cvvl,expdatel;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,capfield,entercapt,phnot,ttt,fft,cardhnamet,cardnot,cvvt,mmt,yyt;
	JTable table=new JTable();
	DefaultTableModel model=new DefaultTableModel();
	JScrollPane sp=new JScrollPane(table);
	JButton mkpay,cancel,recap,process,abort,pay,abort1;
	JLabel l=new JLabel("Take Final fare from Passenger in Cash.");
	JLabel totcash=new JLabel("Total Amt* : ");
	int cnt;String cntStr;
	String tablewala[][]=new String[4][5];
	String arr[];
	String captchastr,str1;
	String arr1[];
	String arr2[];
	String arr3[];
	String arr4[];
	String arr5[]= {"Select a Method","Cash","Credit/Debit"};
	
	String quota,date,cls,tname,tno,from,to,totalseats,captchano;
	
	Statement stmt;
	Connection con;
	
	JComboBox cb=new JComboBox(arr5);
	
	Font ft = new Font("Times New Roman", Font.BOLD,20);
	
	JSeparator sep=new JSeparator(JSeparator.HORIZONTAL);
	JSeparator sep1=new JSeparator(JSeparator.VERTICAL);
	JSeparator sep2=new JSeparator(JSeparator.HORIZONTAL);
	
	public Screen3() throws Exception
	{
		f=new JFrame("Payment");
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","");  
		stmt=con.createStatement();
		
		
		head=new JLabel("Payment");
		Font font = new Font("Times New Roman", Font.BOLD,30);
		head.setFont(font);
		head.setBounds(300,10,280,50);
		l1=new JLabel("Train No :");
		l2=new JLabel("Train Name :");
		l3=new JLabel("From :");
		l4=new JLabel("To :");
		l5=new JLabel("Date :");
		l6=new JLabel("Class :");
		l7=new JLabel("Reservation Upto :");
		l8=new JLabel("Boarding Point :");
		l9=new JLabel("Quota :");
		
		caplabel=new JLabel("Captcha : ");
		entercapl=new JLabel("Enter Captcha :");
		phnol=new JLabel("Enter Phone No :");
		paymt=new JLabel("Payment Method :");
		ttl=new JLabel("Total Ticket :");
		ffl=new JLabel("Final Fare :");
		cashl=new JLabel("Cash");
		cardhnamel=new JLabel("Cardholder Name");
		cardnol=new JLabel("Card Number");
		cvvl=new JLabel("CVV");
		expdatel=new JLabel("Exp Date");
		
		capfield=new JTextField();		capfield.setEditable(false);
		entercapt=new JTextField();
		phnot=new JTextField();
		ttt=new JTextField();
		fft=new JTextField();
		cardhnamet=new JTextField();
		cardnot=new JTextField();
		cvvt=new JTextField();
		mmt=new JTextField("  MM");
		yyt=new JTextField("  YYYY");
		
		mmt.setForeground(Color.GRAY);
		yyt.setForeground(Color.GRAY);
		
		t1=new JTextField();t2=new JTextField();t3=new JTextField();t4=new JTextField();
		t7=new JTextField();t6=new JTextField();t8=new JTextField();t5=new JTextField();
		t9=new JTextField();
		
		l1.setFont(ft);l2.setFont(ft);l3.setFont(ft);l4.setFont(ft);
		l5.setFont(ft);l6.setFont(ft);l7.setFont(ft);l8.setFont(ft);
		l9.setFont(ft);phnol.setFont(ft);paymt.setFont(ft);cvvl.setFont(ft);
		cardhnamel.setFont(ft);cardnol.setFont(ft);expdatel.setFont(ft);
		
		model.addColumn("SNo");model.addColumn("Name");model.addColumn("Age");
		model.addColumn("Sex");model.addColumn("Berth Preference");model.addColumn("Seniour Citizen");
		table.setModel(model);
		table.setRowHeight(30);
		
		mkpay=new JButton("Make Payment");
		cancel=new JButton("Cancel");
		recap=new JButton();
		process=new JButton("Process");
		abort=new JButton("Abort");
		pay=new JButton("Pay");
		abort1=new JButton("Abort");
		
		recap.setIcon(new ImageIcon("C:\\Users\\aakash\\Desktop\\refresh.jpg"));
		
		mkpay.addActionListener(this);
		cancel.addActionListener(this);
		recap.addActionListener(this);
		cb.addActionListener(this);
		process.addActionListener(this);
		abort.addActionListener(this);
		pay.addActionListener(this);	
		abort1.addActionListener(this);
		
		mmt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) 
			{
				mmt.setText("");
				mmt.setForeground(Color.BLACK);
			}
		});
		
		yyt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {}
			public void focusGained(FocusEvent e) 
			{
				yyt.setText("");
				yyt.setForeground(Color.BLACK);
			}
		});
		
		l1.setBounds(70,80,90,30);			t1.setBounds(180,80,120,30);
		l2.setBounds(420,80,120,30);		t2.setBounds(560,80,120,30);			
		l3.setBounds(70,130,90,30);			t3.setBounds(180,130,120,30);
		l4.setBounds(420,130,120,30);		t4.setBounds(560,130,120,30);
		l5.setBounds(70,180,90,30);			t5.setBounds(180,180,120,30);
		l6.setBounds(420,180,120,30);		t6.setBounds(560,180,120,30);
		l8.setBounds(70,230,150,30);		t7.setBounds(230,230,120,30);
		l7.setBounds(420,230,170,30);		t8.setBounds(610,230,120,30);
		l9.setBounds(70,280,150,30);		t9.setBounds(180,280,120,30);
		
		ttl.setBounds(70,480,120,30);		ttt.setBounds(200, 480, 30, 30);		
		ffl.setBounds(480, 480, 120, 30);	fft.setBounds(590, 480, 100, 30);
		sp.setBounds(60, 330, 640, 140);
		mkpay.setBounds(180, 550, 150, 30);		
		cancel.setBounds(430, 550, 150, 30);
		
		sep.setBounds(0, 60, 800, 30);
		sep1.setBounds(800, 0, 30, 720);
		
		caplabel.setBounds(850, 60, 120, 40);
		capfield.setBounds(1030, 60, 120, 40); recap.setBounds(1160, 60, 40, 40);
		
		entercapl.setBounds(850, 120, 220, 40);
		entercapt.setBounds(1030, 120, 120, 40);
		
		phnol.setBounds(850, 180, 220, 40);
		phnot.setBounds(1030, 180, 120, 40);
		
		paymt.setBounds(850, 240, 220, 40);
		cb.setBounds(1030, 240, 120, 40);
		
		caplabel.setFont(ft);entercapl.setFont(ft);l.setFont(ft);
		ttl.setFont(ft);ffl.setFont(ft);totcash.setFont(ft);cashl.setFont(ft);
		l.setForeground(Color.BLUE);
		totcash.setForeground(Color.RED);
		cashl.setForeground(Color.red);
		
		f.add(head);f.add(l1);f.add(l2);f.add(l3);
		f.add(l4);f.add(l5);f.add(l6);f.add(l7);
		f.add(l8);f.add(l9);
		
		f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(t5);
		f.add(t6);f.add(t7);f.add(t8);f.add(t9);
		
		f.add(sp);f.add(mkpay);f.add(cancel);f.add(sep);f.add(sep1);
		f.add(caplabel);f.add(capfield);f.add(entercapl);f.add(entercapt);
		f.add(recap);f.add(phnol);f.add(phnot);f.add(cb);f.add(paymt);
		f.add(l);f.add(ttl);f.add(ffl);f.add(ttt);f.add(fft);
		
		f.add(totcash);f.add(cashl);f.add(process);f.add(abort);
		f.add(cardhnamel);f.add(cardhnamet);f.add(cardnol);f.add(cardnot);
		f.add(cvvl);f.add(cvvt);f.add(expdatel);f.add(mmt);f.add(pay);
		f.add(abort1);f.add(yyt);f.add(sep2);
		
		f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocation(270, 15);
		f.setSize(800,650);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setData(String data, String cls, String date,String quota) 
	{
		this.cls=cls;
		this.date=date;
		this.quota=quota;
		
		t9.setText("  "+quota);
		t5.setText("  "+date);
		t6.setText("  "+cls);
		for(int i=0;i<data.length();i++)
		{
			arr=data.split(" ");
		}
		
		t1.setText("  "+arr[0]);t2.setText("  "+arr[1]);
		t3.setText("  "+arr[2]);t4.setText("  "+arr[3]);
		t8.setText("  "+arr[3]);t7.setText("  "+arr[2]);
		
		tno=arr[0];tname=arr[1];from=arr[2];to=arr[3];
		
		int tseat = 0;
		
	}
	
	public void captcha()
	{
		Random random=new Random();
		  int length=7+(Math.abs(random.nextInt())%3);
		  StringBuffer cap=new StringBuffer();
		  
		  for(int i=0;i<length;i++)
		  {
			  int basech=Math.abs(random.nextInt())%62;
			  int chno=0;
			  if(basech<26)
			  {
				  chno=65+basech;
			  }
			  
			  else if(basech<52)
			  {
				  chno=97+(basech-26);
			  }
			  else
			  {
				  chno=48+(basech-52);
			  }
			  
			  cap.append((char)chno); 
		  }
		  captchastr=cap.toString();
	}
	
	
	public void captchaNo()
	{
		Random random=new Random();
		  int length=2;
		  StringBuffer cap=new StringBuffer();
		  
		  for(int i=0;i<length;i++)
		  {
			  int basech=Math.abs(random.nextInt())%47;
			  int chno=0;
			  if(basech<26)
			  {
				  chno=65+basech;
			  }
			  
			  else if(basech<52)
			  {
				  chno=97+(basech-26);
			  }
			  else 
			  {
				  chno=48+(basech-52);
			  }
			  
			  cap.append(chno); 
		  }
		  
		  captchano=cap.toString();
	}

	
	public void putRow1(String data)
	{
		for(int i=0;i<data.length();i++)
		{
			arr1=data.split(" ");
		}
		model.addRow(arr1);
		cnt=cnt+1;
		cntStr=Integer.toString(cnt);
		ttt.setText(cntStr);
		
	}
	
	public void putRow2(String data)
	{
		for(int i=0;i<data.length();i++)
		{
			arr2=data.split(" ");
		}
		model.addRow(arr2);
		cnt=cnt+1;
		cntStr=Integer.toString(cnt);
		ttt.setText(cntStr);
	}
	
	public void putRow3(String data)
	{
		for(int i=0;i<data.length();i++)
		{
			arr3=data.split(" ");
		}
		model.addRow(arr3);
		cnt=cnt+1;
		cntStr=Integer.toString(cnt);
		ttt.setText(cntStr);
	}
	
	public void putRow4(String data)
	{
		for(int i=0;i<data.length();i++)
		{
			arr4=data.split(" ");
		}
		model.addRow(arr4);
		cnt=cnt+1;
		cntStr=Integer.toString(cnt);
		ttt.setText(cntStr);
	}
	
	public void putLabel()
	{
		sep2.setBounds(800,300,450,30);
		
		cardhnamel.setVisible(false);		cardhnamet.setVisible(false);
		cardnol.setVisible(false); 			cardnot.setVisible(false);
		expdatel.setVisible(false); 			mmt.setVisible(false);
		cvvl.setVisible(false); 				cvvt.setVisible(false);
		pay.setVisible(false);				abort1.setVisible(false);
		yyt.setVisible(false);
		
		l.setVisible(true);
		totcash.setVisible(true);
		cashl.setVisible(true);
		process.setVisible(true);
		abort.setVisible(true);
		cashl.setText(str1);
		l.setBounds(840,320,400,30);
		totcash.setBounds(840, 360, 150, 30);
		cashl.setBounds(960, 360, 150, 30);
		process.setBounds(880, 420, 100, 30);
		abort.setBounds(1040, 420, 100, 30);
	}
	
	public void removeLabel()
	{
		l.setVisible(false);
		totcash.setVisible(false);
		cashl.setVisible(false);
		process.setVisible(false);
		abort.setVisible(false);		
		
		cardhnamel.setVisible(true);		cardhnamet.setVisible(true);
		cardnol.setVisible(true); 			cardnot.setVisible(true);
		expdatel.setVisible(true); 			mmt.setVisible(true);
		cvvl.setVisible(true); 				cvvt.setVisible(true);
		pay.setVisible(true);				abort1.setVisible(true);
		yyt.setVisible(true);
		
		cardhnamel.setBounds(840, 320, 200, 30);		cardhnamet.setBounds(840, 350, 320, 30);
		cardnol.setBounds(840, 390, 200, 30);		cardnot.setBounds(840, 420, 320, 30);
		expdatel.setBounds(840, 460, 120, 30);		cvvl.setBounds(1060, 460, 120, 30);
		mmt.setBounds(840, 490, 40, 30);		cvvt.setBounds(1060, 490, 100, 30);
		pay.setBounds(840,540,320,30);				abort1.setBounds(950, 580, 100,30);
		yyt.setBounds(890, 490, 80, 30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==cancel)
		{
			f.dispose();
			try {
				new ScreenPointFive();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==mkpay)
		{
			
			f.setSize(1250, 650);
			f.setLocation(50, 10);
			
			captcha();
			capfield.setText("   "+captchastr);
		}
		
		if(e.getSource()==recap)
		{
			captcha();
			capfield.setText("   "+captchastr);
		}
		
		if(cb.getSelectedItem().toString()=="Cash")
		{
			putLabel();
		}
		
		if(cb.getSelectedItem().toString()=="Credit/Debit")
		{
			removeLabel();
		}
		
		if(e.getSource()==abort)
		{
			f.dispose();
		}
		
		if(e.getSource()==abort1){f.dispose();}
		
		if(e.getSource()==pay || e.getSource()==process)
		{
			int tseat=0;
			try
			{
				ResultSet rs=stmt.executeQuery("select totalseat from availability where tno="+arr[0]+" and cls='"+cls+"'");
				while(rs.next())
					tseat=rs.getInt(1);
			//	System.out.println("Seat = "+tseat);
			}catch(Exception e2) {}
			
			if(!(entercapt.getText().equals(captchastr)))
			{
				JOptionPane.showMessageDialog(f, "Captcha Mismatch", "Error", 0);
				entercapt.setText("");
			}
			else
			{
				captchaNo();
				totalseats=ttt.getText();
			try {
				
				stmt.executeUpdate("update availability set totalseat=totalseat-"+totalseats+" where cls='"+cls+"' and tno="+tno+"");
				
			for(int i=0;i<table.getRowCount();i++)
			{
				for(int j=0;j<table.getColumnCount()-1;j++)
				{
					if(table.getValueAt(i, j)!=null)
					tablewala[i][j]=(String) table.getValueAt(i, j);
					if(tseat<=0)
					{
						tablewala[i][4]="W/L";
					}
					else
					tablewala[i][4]="CNF";
				}
			}
			
			
			stmt.executeUpdate("insert into pnrwala values('"+captchano+"','"+tno+"','"+tname+"','"+date+"','"+from+"','"+to+"','"+cls+"','"+fft.getText()+"')");
			
			String pasname = null,passtatus = null;
			
			for(int k=0;k<table.getRowCount();k++)
			{
				if(table.getValueAt(k,0)!=null)
				{
					pasname=tablewala[k][1];
					passtatus=tablewala[k][4];
				}
				
				stmt.executeUpdate("insert into pnrpas values('"+captchano+"','"+pasname+"','"+passtatus+"')");
			}
			
			
			
			}catch (Exception e1) {	}
				
			f.dispose();
			Screen4 s4=new Screen4();
			
			s4.putData(tno,tname,from,to,cls,quota,date,ttt.getText(),fft.getText(),phnot.getText(),captchano);
			s4.putTable(tablewala);
		}
		}
	}
	
	public void calFare(StringBuffer sb1, StringBuffer sb2, StringBuffer sb3,String str) 
	{
		int total=Integer.parseInt(ttt.getText());
		
		double slfare=Integer.parseInt(sb1.toString());
		double ac2fare=Integer.parseInt(sb2.toString());
		double ac3fare=Integer.parseInt(sb3.toString());
		
		if(str.equals("SL"))
		{
			double finalfare=total*slfare;
			str1=Double.toString(finalfare);
			fft.setText(str1);
		}
		
		if(str.equals("2AC"))
		{
			double finalfare=total*ac2fare;
			str1=Double.toString(finalfare);
			fft.setText(str1);
		}
		
		if(str.equals("3AC"))
		{
			double finalfare=total*ac3fare;
			str1=Double.toString(finalfare);
			fft.setText(str1);
		}
		
		if(str.equals("CC"))
		{
			double finalfare=total*ac3fare;
			str1=Double.toString(finalfare);
			fft.setText(str1);
		}
		
		if(str.equals("2S"))
		{
			double finalfare=total*ac2fare;
			str1=Double.toString(finalfare);
			fft.setText(str1);
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
		new Screen3();
	}
	
}
