import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login implements ActionListener
{
	int cnt=0,ch=4;
	String s=null;
	JFrame f;
	JLabel uname,pas,login;
	JTextField ufield;
	JPasswordField pasfield;
	JButton log,res;
	JCheckBox cb;
	public Login()
	{
		f=new JFrame("Login");
		
		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\aakash\\Desktop\\t.jpg")));
		
		login=new JLabel("LOGIN");
		Font font = new Font("Times New Roman", Font.BOLD,20);
		login.setFont(font);
		
		uname=new JLabel("Username:");
		Font ft=new Font("Times New Roman", Font.PLAIN, 17);
		uname.setFont(ft);
		ufield=new JTextField();
		
		pas=new JLabel("Password:");
		pas.setFont(ft);
		pasfield=new JPasswordField();
		
		log=new JButton("Login");
		res=new JButton("Reset");
		
		cb=new JCheckBox();
		
		login.setBounds(140,10,280,30);
		
		uname.setBounds(40,80,120,30);
		ufield.setBounds(120,80,150,30);
		
		pas.setBounds(40,160,120,30);
		pasfield.setBounds(120,160,150,30);
		pasfield.setText(null);
		cb.setBounds(270, 160, 25, 30);
		
		char defaulty = pasfield.getEchoChar(); 
		cb.addItemListener(new ItemListener() { 
		        public void itemStateChanged(ItemEvent e) { 
		            if (e.getStateChange() == ItemEvent.SELECTED) {
		                pasfield.setEchoChar(defaulty); 
		            } else {  
		                pasfield.setEchoChar((char)0);  
		            } 
		        }
		    });
		cb.setSelected(true);
		log.setBounds(50,260,90,30);
		res.setBounds(180,260,90,30);
		
		log.addActionListener(this);
		res.addActionListener(this);
		
		f.add(login);
		f.add(uname);
		f.add(ufield);
		f.add(pas);
		f.add(pasfield);
		f.add(log);
		f.add(res);
		f.add(cb);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(350,400);
		f.setLocation(450, 100);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{		try
		{
		if(e.getSource()==log)
		{
			if(ufield.getText().equals("Railway") && pasfield.getText().equals("12345"))
			{
				JOptionPane.showMessageDialog(f, "Logged In");
				f.dispose();
				new ScreenPointFive();
			}
			else
			{
				cnt++;
				JOptionPane.showMessageDialog(f,"Wrong ID or Password\n*You Have "+(--ch)+" Chances* ","Error",JOptionPane.ERROR_MESSAGE);
				ufield.setText("");
				pasfield.setText("");
				if(cnt>3)
				{
					ufield.setEditable(false);
					pasfield.setEditable(false);
					ufield.setText("");
					pasfield.setText("");
						
				}
			}
			
		}
		
		if(e.getSource()==res)
		{
			ufield.setText("");
			pasfield.setText("");
		}
		
		}catch(Exception e1) {}
	}
	
	public static void main(String[] args) 
	{
		new Login();
	}
	
}
