import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	int xSize,ySize;
	JLabel l1, l2, l3;
	JButton go_d, exp_d, go_f, exp_f, exit;
	Container con;
	Home()
	{
		super("Shortest Algorithm Application");
		Toolkit tk = Toolkit.getDefaultToolkit();
        xSize = ((int) tk.getScreenSize().getWidth());
        ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize,ySize);
		System.out.print((xSize)+" "+(ySize));
		setResizable(false);
		setVisible(true);
		initComponents();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	void initComponents()
	{
		con=super.getContentPane();
		con.setBackground(Color.darkGray);
		con.setLayout(null);
		
		//First
		con.add(l1 = new JLabel("<html> <h1><font color='orange' size=56><u>CALCULATE SHORTEST PATH BETWEEN TWO NODES</u></font></h1></html>"));
		l1.setBounds(460, 100, 1200, 200);
		
		con.add(l2=new JLabel("<html><h3><font color='white' size=16> 1) Dijkstra�s Shortest Path Algorithm</font></h3></html>"));
		l2.setBounds(460,290,700,60);
		
		con.add(l3=new JLabel("<html><h3><font color='white' size=16> 2) Floyd Warshall Algorithm</font></h3></html>"));
		l3.setBounds(460,390,700,60);
		
		con.add(go_d=new JButton("<html><h3>GO</h3></html>"));
		go_d.setBounds(1200, 300, 100, 40);
		go_d.addActionListener(this);
		
		con.add(exp_d=new JButton("<html><h3>Explanation</h3></html>"));
		exp_d.setBounds(1350, 300, 150, 40);
		exp_d.addActionListener(this);
		
		con.add(go_f=new JButton("<html><h3>GO</h3></html>"));
		go_f.setBounds(1200, 400, 100, 40);
		go_f.addActionListener(this);
		
		con.add(exp_f=new JButton("<html><h3>Explanation</h3></html>"));
		exp_f.setBounds(1350, 400, 150, 40);
		exp_f.addActionListener(this);
		
		con.add(exit=new JButton("<html><h3>Exit</h3></html>"));
		exit.setBounds(850, 540, 150, 40);
		exit.addActionListener(this);
	}
	
	public static void main(String args[])
	{
		new Home();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==go_d)
			new D_Code().setVisible(true);;
		if(ae.getSource()==go_f)
			new GraphPath().setVisible(true);
		if(ae.getSource()==exp_d)
			new DExplain().setVisible(true);
		if(ae.getSource()==exp_f)
			new Description_W().setVisible(true);
		if(ae.getSource()==exit)
			System.exit(0);
	}
	
}


