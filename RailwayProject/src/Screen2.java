import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Screen2 extends JFrame implements ActionListener
{
	JFrame f;
	JLabel head,l1,l2,l3,l4,l5,l6,l7,l8,l9,h2,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
	JRadioButton r1,r2;
	JComboBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9;
	JCheckBox ch1,ch2,ch3,ch4;
	JButton b1,b2,b3;
	Font ft = new Font("Times New Roman", Font.BOLD,20);
	String[] arr= {};
	ButtonGroup but=new ButtonGroup();
	String cls="",data="",date="",details1="",details2="",details3="",details4="",str;
	StringBuffer sb1,sb2,sb3;
	JCheckBox chb1,chb2,chb3,chb4;
	
	public Screen2()
	{
		f=new JFrame("Train Details");
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		head=new JLabel("Train Details");
		Font font = new Font("Times New Roman", Font.BOLD,30);
		head.setFont(font);
		h2=new JLabel("Passenger Details..");
		h2.setFont(font);
		head.setBounds(300,10,280,50);
		//head.setHorizontalAlignment(JLabel.CENTER);
		l1=new JLabel("Train No.");
		l2=new JLabel("Train Name.");
		l3=new JLabel("From.");
		l4=new JLabel("To.");
		l5=new JLabel("Date.");
		l6=new JLabel("Class.");
		l7=new JLabel("Reservation Upto.");
		l8=new JLabel("Boarding Point.");
		l9=new JLabel("Quota.");
		
		l10=new JLabel("SNo");
		l11=new JLabel("Name");
		l12=new JLabel("Age");
		l13=new JLabel("Sex");
		l14=new JLabel("Berth Preference");
		l15=new JLabel("Seniour Citizen");
		l16=new JLabel("1");
		l17=new JLabel("2");
		l18=new JLabel("3");
		l19=new JLabel("4");
		
		l1.setFont(ft);
		l2.setFont(ft);
		l3.setFont(ft);
		l4.setFont(ft);
		l5.setFont(ft);
		l6.setFont(ft);
		l7.setFont(ft);
		l8.setFont(ft);
		l9.setFont(ft);
		
		l10.setFont(ft);
		l11.setFont(ft);
		l12.setFont(ft);
		l13.setFont(ft);
		l14.setFont(ft);
		l15.setFont(ft);
		
		l16.setFont(ft);
		l17.setFont(ft);
		l18.setFont(ft);
		l19.setFont(ft);
		
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();

		t8=new JTextField();
		t9=new JTextField();
		t10=new JTextField();
		t11=new JTextField();
		t12=new JTextField();
		t13=new JTextField();
		t14=new JTextField();
		t15=new JTextField();
		
		r1=new JRadioButton();
		r2=new JRadioButton();
		r1.setText("General");
		r1.setSelected(true);
		r2.setText("Ladies");
		r1.setFont(ft);
		r2.setFont(ft);
		
		String frmName[]={"Pune-Jn","Dhaulpur","Nagpur-Jn","Kedgaon-St","Chennai-Ct","CSTM-Mumbai"};        
		cb1=new JComboBox(frmName);
		
		String gen[]={"Male","Female","Transgender"};
		cb2=new JComboBox(gen);
		cb3=new JComboBox(gen);
		cb4=new JComboBox(gen);
		cb5=new JComboBox(gen);
		
		String berp[]={"Lower","Middle","Upper","Side-Upper","Side-Lower"};
		cb6=new JComboBox(berp);
		cb7=new JComboBox(berp);
		cb8=new JComboBox(berp);
		cb9=new JComboBox(berp);
		
		ch1=new JCheckBox("Yes");
		ch2=new JCheckBox("Yes");
		ch3=new JCheckBox("Yes");
		ch4=new JCheckBox("Yes");
		
		chb1=new JCheckBox();
		chb2=new JCheckBox();
		chb3=new JCheckBox();
		chb4=new JCheckBox();
		
		b1=new JButton("Next");
		b2=new JButton("Reset");
		b3=new JButton("Cancel");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		but.add(r1);but.add(r2);
		
		l1.setBounds(70,80,90,30);
		t1.setBounds(230,80,120,30);
		l2.setBounds(420,80,120,30);
		t2.setBounds(600,80,120,30);
		
		l3.setBounds(70,130,90,30);
		t3.setBounds(230,130,120,30);
		l4.setBounds(420,130,120,30);
		t4.setBounds(600,130,120,30);
		
		l5.setBounds(70,180,90,30);
		t5.setBounds(230,180,120,30);
		l6.setBounds(420,180,120,30);
		t6.setBounds(600,180,120,30);
		
		l8.setBounds(70,230,150,30);
		cb1.setBounds(230,230,120,30);
		l7.setBounds(420,230,170,30);
		t7.setBounds(600,230,120,30);
		
		l9.setBounds(70,280,150,30);
		r1.setBounds(230,280,100,30);
		//r2.setBounds(420,280,170,30);
		
		h2.setBounds(70,330,280,50);
		
		l10.setBounds(70,390,150,30);
		l11.setBounds(130,390,100,30);
		l12.setBounds(250,390,170,30);
		l13.setBounds(310,390,170,30);
		l14.setBounds(430,390,170,30);
		l15.setBounds(590,390,170,30);
		
		l16.setBounds(70,430,170,30);		chb1.setBounds(30, 430, 30, 30);
		t8.setBounds(130,430,100,30);
		t9.setBounds(250,430,40,30);
		cb2.setBounds(310,430,100,30);
		cb6.setBounds(430,430,140,30);
		ch1.setBounds(640,430,50,30);
		
		l17.setBounds(70,470,170,30);		chb2.setBounds(30, 470, 30, 30);
		t10.setBounds(130,470,100,30);
		t11.setBounds(250,470,40,30);
		cb3.setBounds(310,470,100,30);
		cb7.setBounds(430,470,140,30);
		ch2.setBounds(640,470,50,30);
		
		l18.setBounds(70,510,170,30);		chb3.setBounds(30, 510, 30, 30);
		t12.setBounds(130,510,100,30);
		t13.setBounds(250,510,40,30);
		cb4.setBounds(310,510,100,30);
		cb8.setBounds(430,510,140,30);
		ch3.setBounds(640,510,50,30);
		
		l19.setBounds(70,550,170,30);		chb4.setBounds(30, 550, 30, 30);
		t14.setBounds(130,550,100,30);
		t15.setBounds(250,550,40,30);
		cb5.setBounds(310,550,100,30);
		cb9.setBounds(430,550,140,30);
		ch4.setBounds(640,550,50,30);
		
		b1.setBounds(180,610,100,30);
		b2.setBounds(350,610,100,30);
		b3.setBounds(510,610,100,30);
		
		
		f.add(head);f.add(l1);f.add(t1);f.add(l2);f.add(t2);f.add(l3);f.add(t3);
		f.add(l4);f.add(t4);f.add(l5);f.add(t5);f.add(l6);f.add(t6);f.add(l7);
		f.add(cb1);f.add(l8);f.add(t7);f.add(l9);f.add(r1);f.add(r2);f.add(h2);
		
		f.add(l10);f.add(l11);f.add(l12);f.add(l13);f.add(l14);f.add(l15);
		f.add(l16);f.add(l17);f.add(l18);f.add(l19);
		
		f.add(t8);f.add(t9);f.add(t10);f.add(t11);f.add(t12);
		f.add(t13);f.add(t14);f.add(t15);
		
		f.add(cb2);f.add(cb3);f.add(cb4);f.add(cb5);f.add(cb6);
		f.add(cb7);f.add(cb8);f.add(cb9);
		
		f.add(ch1);f.add(ch2);f.add(ch3);f.add(ch4);
		f.add(b1);f.add(b2);f.add(b3);
		f.add(chb1);f.add(chb2);f.add(chb3);f.add(chb4);
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(800,700);
		f.setLocation(270, 10);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void setValues(String data,String cls,String date,StringBuffer sb1,StringBuffer sb2,StringBuffer sb3,String str)
	{
		System.out.println(data);
		this.sb1=sb1;
		this.sb2=sb2;
		this.sb3=sb3;
		this.data=data;
		this.cls=cls;
		this.date=date;
		this.str=str;
		t5.setText("  "+date);
		t6.setText("  "+cls);
		for(int i=0;i<data.length();i++)
		{
			arr=data.split(" ");
		}
		
		t1.setText("  "+arr[0]);t2.setText("  "+arr[1]);
		t3.setText("  "+arr[2]);t4.setText("  "+arr[3]);
		t7.setText("  "+arr[3]);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b3)
		{
			f.dispose();
			try {
				new ScreenPointFive();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==b2)
		{
			t8.setText("");t9.setText("");t10.setText("");t11.setText("");
			t12.setText("");t13.setText("");t14.setText("");t15.setText("");
		}
		
		if(e.getSource()==b1)
		{
			try
			{
				
			if(chb1.isSelected())
			{
			String gen="General",lad="Ladies";
			f.dispose();
			Screen3 s3=new Screen3();
			if(r1.isSelected())
			s3.setData(data, cls, date,gen);
			
			if(r2.isSelected())
			s3.setData(data, cls, date,lad);
			
			if(chb1.isSelected())
			{
				if(ch1.isSelected())
					details1="1"+" "+t8.getText()+" "+t9.getText()+" "+cb2.getSelectedItem().toString()+" "+cb6.getSelectedItem().toString()+" "+"Yes";
			
				else
					details1="1"+" "+t8.getText()+" "+t9.getText()+" "+cb2.getSelectedItem().toString()+" "+cb6.getSelectedItem().toString()+" "+"No";
				
				s3.putRow1(details1);
			}
			if(chb2.isSelected())
			{
				if(ch2.isSelected())
					details2="2"+" "+t10.getText()+" "+t11.getText()+" "+cb3.getSelectedItem().toString()+" "+cb7.getSelectedItem().toString()+" "+"Yes";
			
				else
					details2="2"+" "+t10.getText()+" "+t11.getText()+" "+cb3.getSelectedItem().toString()+" "+cb7.getSelectedItem().toString()+" "+"No";
		
				s3.putRow2(details2);
			}
			
			if(chb3.isSelected())
			{
				if(ch3.isSelected())
					details3="3"+" "+t12.getText()+" "+t13.getText()+" "+cb4.getSelectedItem().toString()+" "+cb8.getSelectedItem().toString()+" "+"Yes";
			
				else
					details3="3"+" "+t12.getText()+" "+t13.getText()+" "+cb4.getSelectedItem().toString()+" "+cb8.getSelectedItem().toString()+" "+"No";
		
				s3.putRow3(details3);
			}
			
			if(chb4.isSelected())
			{
				if(ch4.isSelected())
					details4="4"+" "+t14.getText()+" "+t15.getText()+" "+cb5.getSelectedItem().toString()+" "+cb9.getSelectedItem().toString()+" "+"Yes";
			
				else
					details4="4"+" "+t14.getText()+" "+t15.getText()+" "+cb5.getSelectedItem().toString()+" "+cb9.getSelectedItem().toString()+" "+"No";
				s3.putRow4(details4);
			}
			s3.calFare(sb1,sb2,sb3,str);
			//System.out.println(details4);
		
		}
			else
			{

				JOptionPane.showMessageDialog(f, "Please select Passenger CheckBox.");
			}
		}
		catch (Exception e1) {}
		}
	}
	
	
	public static void main(String[] args) 
	{
		new Screen2();
	}
	

}
