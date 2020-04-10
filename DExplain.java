import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DExplain extends JFrame implements ActionListener{
	int xSize,ySize;
	String s1;
	ImageIcon im;
	JLabel l1, l2, l3,l4,l5,l6,l7;
	JTextArea jt1;
	JButton _1,_2,_3,_4,_5,_6,_7,_8,_9,_gf,exit,back;
	Container con;
	DExplain()
	{
		super("Example Explanation ");
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
		con.setBackground(Color.DARK_GRAY);
		con.setLayout(null);
		
		con.add(l1 = new JLabel("<html>  <font color='orange' size=10><u> Dijkstra's Algorithm</u></font></html>"));
		l1.setBounds(750, 30, 700, 60);
		
		con.add(l2 = new JLabel("<html><font size=6 color='white'> Dijkstra's algorithm is an algorithm that is used to solve the shortest distance problem. That is, we use it to find the shortest distance between two vertices on a graph. We can find shortest routes, minimum costs using this algorithm.</font></html>"));
		l2.setBounds(50, 120, 1800, 80);
		
		con.add(l3 = new JLabel("<html><u><font color='orange' size=6>ABOUT :</font></u></html>"));
		l3.setBounds(50, 210, 1800, 25);
		
		con.add(l4 = new JLabel("<html><font size=5 color='white'>* All edges must have non-negative weights. </font></html>"));
		l4.setBounds(50, 250, 1700, 25);	
		
		con.add(l4 = new JLabel("<html><font size=5 color='white'>* Graph must be connected. </font></html>"));
		l4.setBounds(50, 280, 1700, 25);	
		
		con.add(l4 = new JLabel("<html><font size=5 color='white'>* Worst case time complexity: Θ(E+V^2)</font></html>"));
		l4.setBounds(50, 310, 1700, 25);	
		
		con.add(l4 = new JLabel("<html><font size=5 color='white'>* Time complexity is Θ(E+V log V) if priority queue is used.</font></html>"));
		l4.setBounds(50, 340, 1700, 25);
		
		con.add(l4 = new JLabel("<html><font size=5 color='white'>* Here, V is the number of nodes in the given graph.</font></html>"));
		l4.setBounds(50, 370, 1700, 25);
		
		con.add(l3 = new JLabel("<html><u><font color='orange' size=6>EXAMPLE</font></u></html>"));
		l3.setBounds(50,400, 200, 30);
		
		//First
		con.add(l1 = new JLabel(new ImageIcon("img\\Graph.JPG")));
		l1.setBounds(700, 40, 900, 900);
		
		con.add(jt1=new JTextArea());
		//jt1.setBounds(1440, 260, 450, 400);
		jt1.setBounds(100, 500, 500, 450);
		jt1.setFont(new Font("Arial",Font.BOLD,23));
		jt1.setForeground(Color.BLUE);
	   	jt1.setBackground(Color.WHITE);
	   	s1="What is the Shortest Path to \ntravel from A to Z?";
		jt1.setText(s1);
		
		con.add(_gf=new JButton("<html><h3>Graph</h3></html>"));
		_gf.setBounds(880, 800, 80, 40);
		_gf.addActionListener(this);
		
		con.add(_1=new JButton("<html><h3>1</h3></html>"));
		_1.setBounds(980, 800, 30, 40);
		_1.addActionListener(this);
		
		con.add(_2=new JButton("<html><h3>2</h3></html>"));
		_2.setBounds(1020, 800, 30, 40);
		_2.addActionListener(this);
		
		con.add(_3=new JButton("<html><h3>3</h3></html>"));
		_3.setBounds(1060, 800, 30, 40);
		_3.addActionListener(this);
		
		con.add(_4=new JButton("<html><h3>4</h3></html>"));
		_4.setBounds(1100, 800, 30, 40);
		_4.addActionListener(this);
		
		con.add(_5=new JButton("<html><h3>5</h3></html>"));
		_5.setBounds(1140, 800, 30, 40);
		_5.addActionListener(this);
		
		con.add(_6=new JButton("<html><h3>6</h3></html>"));
		_6.setBounds(1180, 800, 30, 40);
		_6.addActionListener(this);
		
		con.add(_7=new JButton("<html><h3>7</h3></html>"));
		_7.setBounds(1220, 800, 30, 40);
		_7.addActionListener(this);
		
		con.add(_8=new JButton("<html><h3>8</h3></html>"));
		_8.setBounds(1260, 800, 30, 40);
		_8.addActionListener(this);
		
		con.add(_9=new JButton("<html><h3>9</h3></html>"));
		_9.setBounds(1300, 800, 30, 40);
		_9.addActionListener(this);
		
		con.add(back=new JButton("<html><h3>Back</h3></html>"));
		back.setBounds(1340, 800, 80, 40);
		back.addActionListener(this);
		
		con.add(exit=new JButton("<html><h3>Exit</h3></html>"));
		exit.setBounds(1440, 800, 80, 40);
		exit.addActionListener(this);
	}
	
	public static void main(String args[]) throws Exception
	{
		new DExplain();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==_gf)
		{
			im=new ImageIcon("img\\Graph.JPG");
			l1.setIcon(im);
			s1="What is the Shortest Path to \ntravel from A to Z?";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_1)
		{
			im=new ImageIcon("img\\1.JPG");
			l1.setIcon(im);
			s1="Start by setting the starting \nnode (A) as the current node";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_2)
		{
			im=new ImageIcon("img\\2.JPG");
			l1.setIcon(im);
			s1="Check all the nodes connected \nto A and update their “Distance \nfrom A” and set their \n“previous node” to “A”";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_3)
		{
			im=new ImageIcon("img\\3.JPG");
			l1.setIcon(im);
			s1="Set the current node (A) to\n “visited” and use the closest \nunvisited node to A as the current\n node (In this case: Node C)";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_4)
		{
			im=new ImageIcon("img\\4.JPG");
			l1.setIcon(im);
			s1="Check all unvisited nodes\nconnected to the current node\nand add the distance from A\nto C to all distances"
					+ " from \nthe connected nodes. Replace\ntheir values only if the new \ndistance is lower than the previous\n"
					+ " one.\r\n" + 
					"C -> B: 2 + 1 = 3 < 4 – Change Node B\r\n" + 
					"C -> D: 2 + 8 = 10 < ∞ – Change Node D\r\n" + 
					"C -> E: 2 + 10 = 12 < ∞ – Change Node E";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_5)
		{
			im=new ImageIcon("img\\5.JPG");
			l1.setIcon(im);
			s1="Set the current node C status to Visited." + 
					"\nWe then repeat the same \nprocess always picking the closest \nunvisited node to A as the current node.\n" + 
					"\nIn this case node B becomes the \ncurrent node.";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_6)
		{
			im=new ImageIcon("img\\6.JPG");
			l1.setIcon(im);
			s1="B -> D 3+5 = 8 < 10 – Change Node D\r\n" + 
					"\nNext “Current Node” will be D as it has \nthe shortest distance from A amongst \nall unvisited nodes.";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_7)
		{
			im=new ImageIcon("img\\7.JPG");
			l1.setIcon(im);
			s1="D -> E 8+2 = 10 < 12 – Change Node E\r\n" + 
					"D -> Z 8+6 = 14 < ∞ – Change Node Z\r\n" + 
					"\nWe found a path from A to Z but \nit may not be the shortest one yet.\nSo we need to carry on the process.\n" +  
					"\nNext “Current Node”: E";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_8)
		{
			im=new ImageIcon("img\\8.JPG");
			l1.setIcon(im);
			s1="E -> Z 10+5 = 15 > 14 \n\n– We do not change node Z.";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==_9)
		{
			im=new ImageIcon("img\\9.JPG");
			l1.setIcon(im);
			s1="We found the shortest path from A to Z\n\n" + 
					"Read the path from Z to A using \nthe previous node column:\n" + 
					"\nZ > D > B > C > A\n" + 
					"\nSo the Shortest Path is:\n" + 
					"A – C – B – D – Z with a length of 14";
			jt1.setText(s1);
		}
		
		else if(ae.getSource()==back)
		{
			new Home().setVisible(true);
		}
		
		else if(ae.getSource()==exit)
		{
	            int a=JOptionPane.showConfirmDialog(null,"Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
	            if(a==JOptionPane.YES_OPTION)
	            	System.exit(0);
		}
	
	}	
}
