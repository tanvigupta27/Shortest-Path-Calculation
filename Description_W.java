import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Description_W extends JFrame implements ActionListener{
	int xSize,ySize;
	JLabel l1, l2, l3,l4,l5,l6,l7;
	JButton back,exit;
	Container con;
	Description_W()
	{
		super("Floyd Warshall Algorithm");
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
		con.setBackground(Color.white);
		con.setLayout(null);
		
		con.add(l1 = new JLabel("<html> <font color='orange' size=24><u> Floyd warshall Algorithm</u></h1></html>"));
		l1.setBounds(700, 30, 700, 50);
		
		con.add(l2 = new JLabel("<html><font size=5> The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. It computes the shortest path between every pair of vertices of the given graph.Floyd Warshall Algorithm is an example of dynamic programming approach.</font></html>"));
		l2.setBounds(50, 100, 1800, 50);
		
		con.add(l3 = new JLabel("<html><u><font color='orange' size=6>TIME COMPLEXITY</font></u></html>"));
		l3.setBounds(50, 170, 1800, 25);
		
		con.add(l4 = new JLabel("<html><font size=5>* Floyd Warshall Algorithm consists of three loops over all the nodes.</font></html>"));
		l4.setBounds(50, 210, 1700, 25);	
		
		con.add(l4 = new JLabel("<html><font size=5>* The inner most loop consists of only constant complexity operations.</font></html>"));
		l4.setBounds(50, 240, 1700, 25);	
		
		con.add(l4 = new JLabel("<html><font size=5>* Hence, the asymptotic complexity of Floyd Warshall algorithm is O(n3).</font></html>"));
		l4.setBounds(50, 270, 1700, 25);	
		
		con.add(l4 = new JLabel("<html><font size=5>* Here, n is the number of nodes in the given graph.</font></html>"));
		l4.setBounds(50, 300, 1700, 25);	
		
		con.add(l5 = new JLabel("<html> <font color='orange' size=6><u>ALGORITHM:</u></font></html>"));
		l5.setBounds(50, 345, 1700, 25);
		
		ImageIcon img=new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Shortest_Path_Project\\1.jpg");
		con.add(l5 = new JLabel(img));
		l5.setBounds(20, 180, 600, 800);
		
		con.add(l3 = new JLabel("<html><u><font color='orange' size=8>EXAMPLE</font></u></html>"));
		l3.setBounds(900, 200, 200, 40);
		
		ImageIcon n=new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\Shortest_Path_Project\\2.jpg");
		con.add(l7 = new JLabel(n));
		l7.setBounds(800, 150, 1060, 900);	
		
		con.add(back=new JButton("<html><h2>Go back to Home Page</h2></html>"));
		back.setBounds(1450, 980, 250, 40);
		back.addActionListener(this);
		
		con.add(exit=new JButton("<html><h2>Exit</h2></html>"));
		exit.setBounds(1750, 980, 150, 40);
		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            int a=JOptionPane.showConfirmDialog(null,"Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
      
            if(a==JOptionPane.YES_OPTION)
            	System.exit(0);
            
            }
        });
		
	}
	
	public static void main(String args[])
	{
		new Description_W();		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
			new Home().setVisible(true);
	}
}
