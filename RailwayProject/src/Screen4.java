import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class Screen4 implements ActionListener, Printable
{
	JFrame f;
	JLabel head,fared,pasd,pnrq,tnoq,tnameq,quotaq,dateq,classq,fromq,toq,dateofjq,shdaq,shddq,distanceq,phnq,ticketfq;
	JLabel pnra,tnoa,tnamea,quotaa,datea,classa,froma,toa,dateofja,shdaa,shdda,distancea,phna,ticketfa;
	Component comp;
	JSeparator sep,sep1,sep2,sep3,sep4,sep5,sep6,sep7,sep8,sep9,sep10,sep11,sep12,sep13,sep14;
	String totalseats,cls,tno,captchastr,sdhar,shddep,data="";
	JTable table=new JTable();
	JScrollPane sp=new JScrollPane(table); 
	DefaultTableModel mod=new DefaultTableModel();
	Date dobd=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	String dob=sdf.format(dobd);
	JButton print;
	String arr[][]=new String[4][5];
	String dataarr[]=new String[3];
	static int pnrno=81100280;
	Font ftp = new Font("Times New Roman", Font.BOLD,33);
	Font ft=new Font("Times new Roman", Font.BOLD, 18);
	Font fa=new Font("Times new Roman", 0, 18);
	Connection con;
	Statement stmt;
	public Screen4()
	{
		f=new JFrame();
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		head=new JLabel("Happy Journey");
		head.setFont(ftp);
		sep=new JSeparator(JSeparator.HORIZONTAL);
		
		sep1=new JSeparator(JSeparator.HORIZONTAL);
		sep2=new JSeparator(JSeparator.HORIZONTAL);
		sep3=new JSeparator(JSeparator.HORIZONTAL);
		sep8=new JSeparator(JSeparator.HORIZONTAL);
		sep9=new JSeparator(JSeparator.HORIZONTAL);
		
		sep10=new JSeparator(JSeparator.HORIZONTAL);
		sep11=new JSeparator(JSeparator.HORIZONTAL);
		
		sep4=new JSeparator(JSeparator.VERTICAL);
		sep5=new JSeparator(JSeparator.VERTICAL);
		sep6=new JSeparator(JSeparator.VERTICAL);
		sep7=new JSeparator(JSeparator.VERTICAL);
		
		sep12=new JSeparator(JSeparator.VERTICAL);
		sep13=new JSeparator(JSeparator.VERTICAL);
		sep14=new JSeparator(JSeparator.VERTICAL);
		
		pnrq=new JLabel("PNR No : ");
		tnoq=new JLabel("Train No : ");
		tnameq=new JLabel("Train Name : ");
		quotaq=new JLabel("Quota : ");
		dateq=new JLabel("Date Of Booking : ");
		classq=new JLabel("Class : ");
		fromq=new JLabel("From : ");
		dateofjq=new JLabel("Date Of Journey : ");
		toq=new JLabel("To : ");
		shdaq=new JLabel("Shd. Arrival : ");
		shddq=new JLabel("Shd. Departure : ");
		distanceq=new JLabel("Travel Time : ");
		fared=new JLabel("Fare Details");  fared.setFont(new Font("Times New Roman", Font.BOLD, 22));
		ticketfq=new JLabel("Ticket Fare : ");
		phnq=new JLabel("Phone No : ");
		pasd=new JLabel("Passenger Details");	pasd.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		
		pnra=new JLabel("");
		tnoa=new JLabel("");
		tnamea=new JLabel("");
		quotaa=new JLabel("");
		datea=new JLabel("");
		classa=new JLabel("");
		froma=new JLabel("");
		dateofja=new JLabel("");
		toa=new JLabel("");
		shdaa=new JLabel("");
		shdda=new JLabel("");
		distancea=new JLabel("");
		ticketfa=new JLabel("");
		phna=new JLabel("");
		
		print=new JButton("Print");
		print.setVisible(true);
		print.addActionListener(this);
		
		pnrq.setFont(ft);tnoq.setFont(ft);tnameq.setFont(ft);quotaq.setFont(ft);
		dateq.setFont(ft);classq.setFont(ft);fromq.setFont(ft);toq.setFont(ft);dateofjq.setFont(ft);
		shdaq.setFont(ft);shddq.setFont(ft);distanceq.setFont(ft);phnq.setFont(ft);ticketfq.setFont(ft);
		
		pnra.setFont(fa);tnoa.setFont(fa);tnamea.setFont(fa);quotaa.setFont(fa);
		datea.setFont(fa);classa.setFont(fa);froma.setFont(fa);toa.setFont(fa);dateofja.setFont(fa);
		shdaa.setFont(fa);shdda.setFont(fa);distancea.setFont(fa);phna.setFont(fa);ticketfa.setFont(fa);
		
		mod.addColumn("SNo");mod.addColumn("Name");mod.addColumn("Age");
		mod.addColumn("Sex");mod.addColumn("Ticket Status");
		table.setModel(mod);
		table.setRowHeight(30);
		
		head.setBounds(340, 0, 300, 50);
		sep1.setBounds(50, 80, 780, 10);
		sep2.setBounds(50, 115, 780, 10);
		sep3.setBounds(50, 150, 780, 10);
		sep8.setBounds(50, 185, 780, 10);
		sep9.setBounds(50, 220, 780, 10);
		sep4.setBounds(50, 80, 10, 140);
		sep5.setBounds(305, 80, 10, 140);
		sep6.setBounds(575, 80, 10, 140);
		sep7.setBounds(830, 80, 10, 140);
		
		pnrq.setBounds(65, 85, 100, 30);			pnra.setBounds(150, 85, 100, 30);
		tnoq.setBounds(320, 85, 100, 30);			tnoa.setBounds(410, 85, 100, 30);
		tnameq.setBounds(590, 85, 150, 30);			tnamea.setBounds(700, 85, 150, 30);
		
		quotaq.setBounds(65, 120, 150, 30);			quotaa.setBounds(130, 120, 150, 30);
		dateq.setBounds(320, 120, 150, 30);			datea.setBounds(470, 120, 150, 30);
		classq.setBounds(590, 120, 150, 30);		classa.setBounds(650, 120, 150, 30);
		
		fromq.setBounds(65, 155, 150, 30);			froma.setBounds(130, 155, 150, 30);
		dateofjq.setBounds(320, 155, 150, 30);		dateofja.setBounds(470, 155, 150, 30);
		toq.setBounds(590, 155, 150, 30);			toa.setBounds(630, 155, 150, 30);
		
		shdaq.setBounds(65, 190, 150, 30);			shdaa.setBounds(180, 190, 150, 30);
		shddq.setBounds(320, 190, 150, 30);			shdda.setBounds(460, 190, 150, 30);
		distanceq.setBounds(590, 190, 150, 30);		distancea.setBounds(700, 190, 150, 30);
		
		fared.setBounds(50, 240, 150, 30);
		
		sep10.setBounds(50, 280, 780, 10);
		sep11.setBounds(50, 315, 780, 10);
		
		sep12.setBounds(50, 280, 10, 35);
		sep13.setBounds(420, 280, 10, 35);
		sep14.setBounds(830, 280, 10, 35);
		
		phnq.setBounds(435, 285, 100, 30);			phna.setBounds(530, 285, 100, 30);
		ticketfq.setBounds(65, 285, 150, 30);		ticketfa.setBounds(170, 285, 150, 30);
		pasd.setBounds(50, 330, 200, 30);
		sp.setBounds(50, 370, 785, 143);
		
		print.setBounds(380, 570, 100, 30);
		
		f.add(sep);f.add(sep2);f.add(head);
		f.add(sep1);f.add(sep3);f.add(sep4);f.add(sep5);f.add(sep6);f.add(sep7);f.add(sep8);f.add(sep9);
		f.add(sep10);f.add(sep11);f.add(sep12);f.add(sep13);f.add(sep14);
		f.add(pnrq);f.add(tnoq);f.add(tnameq);f.add(quotaq);f.add(dateq);f.add(classq);
		f.add(fromq);f.add(toq);f.add(dateofjq);f.add(shdaq);f.add(shddq);f.add(distanceq);
		f.add(fared);f.add(phnq);f.add(ticketfq);f.add(pasd);f.add(sp);
		
		f.add(pnra);f.add(tnoa);f.add(tnamea);f.add(quotaa);f.add(datea);f.add(classa);
		f.add(froma);f.add(toa);f.add(dateofja);f.add(shdaa);f.add(shdda);f.add(distancea);
		f.add(ticketfa);f.add(phna);f.add(print);
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(900,700);
		f.setLocation(250, 10);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void trainCon() throws Exception
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","");  
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select arrival,departure,traveltime from journeydetails where tno='"+tno+"'");
		while(rs.next())
		{
			data=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);
		}
		for(int i=0;i<data.length();i++)
		{
			dataarr=data.split(" ");
		}
		shdaa.setText(dataarr[1]);shdda.setText(dataarr[0]);distancea.setText(dataarr[2]);
	}
	
	public Screen4(Component comp)
	{
		this.comp=comp;
	}
	
	public static void main(String[] args) 
	{
		new Screen4();
	}

	public void putData(String tno, String tname, String from, String to, String cls, String quota, String date,String ttt,
			String text, String text2,String captchastr) 
	{	
		
		this.tno=tno;
		try {trainCon();} catch (Exception e){}
		this.cls=cls;
		this.captchastr=captchastr;
		totalseats=ttt;
		
		pnra.setText(captchastr);tnoa.setText(tno);tnamea.setText(tname);froma.setText(from);toa.setText(to);classa.setText(cls);
		quotaa.setText(quota);dateofja.setText(date);phna.setText(text2);ticketfa.setText(text);datea.setText(dob);	
	}

	public void putTable(String[][] tablewala) 
	{
		for(int i=0;i<tablewala.length;i++)
		{
			if(tablewala[i][0]!=null)
			{
				mod.addRow(tablewala[i]);
			}
		}
	}
	
	public void printFrame()
	{
		PrinterJob pjob = PrinterJob.getPrinterJob();
		PageFormat preformat = pjob.defaultPage();
		preformat.setOrientation(PageFormat.LANDSCAPE);
		PageFormat postformat = pjob.pageDialog(preformat);
		//If user does not hit cancel then print.
		if (preformat != postformat) {
		    //Set print component
		    pjob.setPrintable(new Screen4(f), postformat);
		    if (pjob.printDialog()) {
		        try {
					pjob.print();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
	}
	
	public int print(Graphics g, PageFormat format, int page_index) 
            throws PrinterException {
        if (page_index > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // get the bounds of the component
        Dimension dim = comp.getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();

        // get the bounds of the printable area
        double pHeight = format.getImageableHeight();
        double pWidth = format.getImageableWidth();

        double pXStart = format.getImageableX();
        double pYStart = format.getImageableY();

        double xRatio = pWidth / cWidth;
        double yRatio = pHeight / cHeight;


        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);
        comp.paint(g2);

        return Printable.PAGE_EXISTS;
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==print)
			{
				print.setVisible(false);
				f.setSize(900,600);
				printFrame();
			}
		}
	}











