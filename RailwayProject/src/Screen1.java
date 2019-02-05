import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Screen1 implements ActionListener
{
	JFrame f;
	JTable table;
	DefaultTableModel mod;
	JScrollPane sp;
	JLabel l;
	JButton chk;
	TableColumnModel tablemodel;
	JButton back;
	String date,fromstsn,tostsn;
	public Screen1() 
	{
		f=new JFrame();
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		l=new JLabel("Trains");
		
		l.setFont(new Font("Times New Roman", Font.BOLD,33));
		
		table=new JTable();
		sp=new JScrollPane(table);
		mod=new DefaultTableModel();
		
		mod.addColumn("Train No");
		mod.addColumn("Train Name");
		mod.addColumn("Class-1");
		mod.addColumn("Class-2");
		mod.addColumn("Class-3");
		mod.addColumn("Departure");
		mod.addColumn("Arrival");
		mod.addColumn("Travel Time");
		
		table.setModel(mod);
		
		/*tablemodel=table.getColumnModel();
		tablemodel.getColumn(0).setPreferredWidth(100);*/
		
		table.setRowHeight(30);
		
		chk=new JButton("Check Avilability");
		chk.addActionListener(this);
		back=new JButton("Back");
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				f.dispose();
				new Screen();
			}
		});
		
		l.setBounds(385, 20, 100, 40);
		sp.setBounds(30, 90, 800, 300);
		chk.setBounds(370, 430, 150, 30);
		back.setBounds(385, 470, 120, 30);
		
		f.add(l);
		f.add(sp);
		f.add(chk);
		f.add(back);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocation(300, 30);
		f.setSize(880,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setValues(String details[],String date,String fromstsn,String tostsn)
	{
		this.date=date;
		this.fromstsn=fromstsn;
		this.tostsn=tostsn;
		for(int i=0;i<details.length;i++)
		{
		String[] arr=details[i].split(" ");
		mod.addRow(arr);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==chk)
		{
			int a=table.getSelectedRow();
			String trainno=mod.getValueAt(a, 0).toString();
			
			f.dispose();
			
			Screen1andHalf s15=new Screen1andHalf();
			try {
				s15.getDetails(trainno,date,fromstsn,tostsn);
			} catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) 
	{
		Screen1 s1=new Screen1();
	}


	
}
