import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.Border;
class GraphPath extends JFrame implements ActionListener, MouseListener
{
	// Variables declaration 
    JButton create, move, connect,click_find,cal, refresh, exit, printpath, ok, back;
    JLabel c_node, nos_node, m_node, move_id, e_connection, src, dest,weight,s,d, sp, label;
    JTextField tf1, tf2, tf3, tf4, tf5,tf6,tf7;		
    JTextArea show_weight;
    int noofnodes=0,ssrc,ddesti,wght,xSize,ySize,currnode, wt[][], flag=0,final_path[],index,path[][],radius=50;
    Container con;

    String s1="EDGES: \n\n";
	public ArrayList<node> nodes = new ArrayList<node>();
	public ArrayList<edge> edges = new ArrayList<edge>();
    // End of variables declaration
	GraphPath()
	{
		super("Shortest Path Algorithm");
		Toolkit tk = Toolkit.getDefaultToolkit();
        xSize = ((int) tk.getScreenSize().getWidth());
        ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize,ySize);
		//System.out.print((xSize)+" "+(ySize));
		setResizable(false);
		initComponents();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				
	}
	public void initComponents() 
	{
		
		con=super.getContentPane();
		con.setBackground(Color.GRAY);
		con.setLayout(null);
		
		//First
		con.add(c_node = new JLabel("<html> <h1><font color='white'><u>NODE CREATION</u></font></h1></html>"));
		c_node.setBounds(10, 10, 250, 50);
		
		con.add(nos_node = new JLabel("<html><h2><font color='black'>No. of Nodes: </font></h2></html>"));
		nos_node.setBounds(10, 50, 150, 40);
				
		con.add(tf1 = new JTextField());
		tf1.setBounds(200, 60, 100, 25);
				
		con.add(create = new JButton( "<html><h3>CREATE</h3></html>"));
		create.setBounds(10, 100, 150, 35);
					
		//Second
		con.add(m_node = new JLabel("<html> <h1><font color='white'><u>MOVE A NODE</u></font></h1> </html>"));
		m_node.setBounds(10, 140, 250, 50);
		m_node.setVisible(false);
		
		con.add(move_id = new JLabel("<html> <h2><font color='black'>Move ID:  </font></h2></html>"));
		move_id.setBounds(10, 180, 150, 40);
		move_id.setVisible(false);
				
		con.add(tf2 = new JTextField());
		tf2.setBounds(200, 190, 100, 25);
		tf2.setVisible(false);
				
		con.add(move = new JButton( "MOVE"));
		move.setBounds(10, 230, 150, 35);
		move.setVisible(false);
		
		//Third
		con.add(e_connection = new JLabel("<html> <h1><font color='white'><u>ESTABLISH A CONNECTION</u></font></h1> </html>"));
		e_connection.setBounds(10, 270, 350, 50);
		e_connection.setVisible(false);
		
		con.add(src = new JLabel("<html> <h2><font color='black'>SOURCE:</font></h2></html>"));
		src.setBounds(10, 310, 150, 40);
		src.setVisible(false);
				
		con.add(tf3 = new JTextField());
		tf3.setBounds(200, 320, 100, 25);
		tf3.setVisible(false);
		
		con.add(dest = new JLabel("<html> <h2><font color='black'>DESTINATION:</font></h2></html>"));
		dest.setBounds(10, 340, 150, 40);
		dest.setVisible(false);
				
		con.add(tf4 = new JTextField());
		tf4.setBounds(200, 350, 100, 25);
		tf4.setVisible(false);
		
		con.add(weight = new JLabel("<html> <h2><font color='black'>WEIGHT:</font></h2></html>"));
		weight.setBounds(10, 370, 150, 40);
		weight.setVisible(false);
				
		con.add(tf5 = new JTextField());
		tf5.setBounds(200, 380, 100, 25);
		tf5.setVisible(false);
		
				
		con.add(connect = new JButton("CONNECT"));
		connect.setBounds(10, 420, 150, 35);
		connect.setVisible(false);
		
		//Fourth
		con.add(click_find=new JButton("Click to find distance"));
		click_find.setBounds(10, 470, 160, 35);
		click_find.setVisible(false);
		
		con.add(s=new JLabel("<html> <h2><font color='black'>Source Vertex:</font></h2></html>"));
		s.setBounds(10, 510, 150, 40);
		s.setVisible(false);
		
		con.add(tf6=new JTextField());
		tf6.setBounds(200, 520, 100, 25);
		tf6.setVisible(false);
		
		con.add(d=new JLabel("<html> <h2><font color='black'>Destination Vertex:</font></h2></html>"));
		d.setBounds(10, 550, 200, 40);
		d.setVisible(false);
		
		con.add(tf7=new JTextField());
		tf7.setBounds(200, 560, 100, 25);
		tf7.setVisible(false);
		
		con.add(cal=new JButton("Calculate"));
		cal.setBounds(10, 610, 150, 35);
		cal.setVisible(false);
		
		con.add(label = new JLabel());
		
		//FIGTH
		con.add(printpath=new JButton("Print Path"));
		printpath.setBounds(180, 610, 150, 35);
		printpath.setVisible(false);
		
		con.add(sp=new JLabel());
		sp.setBounds(20, 640, 1000, 100);
		sp.setVisible(false);
		
		con.add(ok=new JButton("<html> <h2>OK</h2></html>"));
		ok.setBounds(20, 740, 100, 35);
		ok.setVisible(false);
		
		con.add(refresh=new JButton("NEW GRAPH"));
		refresh.setBounds(20, 980, 150, 40);
		refresh.setVisible(true);
		con.add(back=new JButton("BACK"));
		back.setBounds(200, 980, 150, 40);
		back.setVisible(true);
		
		con.add(exit=new JButton("EXIT"));
		exit.setBounds(390, 980, 150, 40);
		exit.setVisible(true);
		
		con.add(show_weight=new JTextArea());
		show_weight.setBounds(1700,20 , 500, 1000);
		show_weight.setVisible(false);
		
		refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               new GraphPath().setVisible(true);
            }
        });
		
		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            int a=JOptionPane.showConfirmDialog(null,"Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
      
            if(a==JOptionPane.YES_OPTION)
            	System.exit(0);
            
            }
        });
		
		back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	new Home();
            
            }
        });
		
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                createAction(evt);
            }
        });
			
        move.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		moveAction(e);
        	}
        });
        
        connect.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		connectAction(e);
        	}
        });
        
        click_find.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		findAction(e);
        	}
        });
        
        cal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		calAction(e);
        	}
        });
        
        printpath.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		printAction(e);
        	}
        });
        
        ok.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		okAction(e);
        	}
        });
	}
	
	 public void createAction(ActionEvent evt) {
     String temp=tf1.getText();
     tf1.setText("");
  		if (temp!=null)
   		{
   			noofnodes=Integer.parseInt(temp);
   			System.out.println(noofnodes);
   			wt=new int[noofnodes][noofnodes];
   			final_path=new int[noofnodes];
   			path=new int[noofnodes][noofnodes];

   			for(int i=0;i<noofnodes;i++)
   			{
   				for(int j=0;j<noofnodes;j++)
   					wt[i][j]=9999;
   				wt[i][i]=0;
   			}
   			createnodes();
   	/*		for(int i=0;i<noofnodes;i++)
   			{
   				for(int j=0;j<noofnodes;j++)
   					System.out.print(wt[i][j]+ " ");
   				System.out.println();
   			}		*/
   			repaint();
   			if(noofnodes>0)
   			{
   			m_node.setVisible(true);
   			move_id.setVisible(true);
   			tf2.setVisible(true);
   			move.setVisible(true);                        
   			}
   		}
    }
	 
	 public void moveAction(ActionEvent e)
	 {
		 String temp=tf2.getText();
	     tf2.setText("");

		 if(temp!=null)
		 {
			 currnode=Integer.parseInt(temp);
	        super.addMouseListener(this);	

		 }
		 repaint();
		 e_connection.setVisible(true);
		 src.setVisible(true);
		 dest.setVisible(true);
		 tf3.setVisible(true);
		 tf4.setVisible(true);
		 weight.setVisible(true);
		 tf5.setVisible(true);
		 connect.setVisible(true);
	 }
	 
	 
	 
	 public void connectAction(ActionEvent e)
	 {
		show_weight.setVisible(true);
		click_find.setVisible(true);
        String temp1=tf3.getText();
        ssrc=Integer.parseInt(temp1);
	   	String temp2=tf4.getText();
	   	ddesti=Integer.parseInt(temp2);
	   	String temp3= tf5.getText();
	   	wght=Integer.parseInt(temp3);
	     tf3.setText("");
	     tf4.setText("");
	     tf5.setText("");

	   	wt[ssrc][ddesti]=wght;
	   	s1+= ssrc+"->"+ddesti+" = "+wght+"\n";
	   	System.out.println(s1);
		Font f=new Font("Arial",Font.BOLD,24);
		show_weight.setFont(f);
		show_weight.setForeground(Color.BLACK);
	   	show_weight.setText(s1);
	   	show_weight.setBackground(Color.GRAY);
	   	/*for(int i=0;i<noofnodes;i++)
	   	{
	   		for(int j=0;j<noofnodes;j++)
	   		{
	   			System.out.print(wt[i][j]+"\t\t");
	   		}
	   		System.out.println();
	   	}*/	
	   
	   	if(temp1!=null && temp2!=null)
	   		{
	   			edge temp= new edge(ssrc,ddesti);
	    		edges.add(temp);
	    	}
	    	repaint();
	 }
	 
	 public void findAction(ActionEvent e)
	 {
		 s.setVisible(true);
		 d.setVisible(true);
		 tf6.setVisible(true);
		 tf7.setVisible(true);
		 cal.setVisible(true);
	 }
	 
	 public void calAction(ActionEvent e)
	 {
		 String str;
		 int a=Integer.parseInt(tf6.getText());
		 int b=Integer.parseInt(tf7.getText());
		 
		 if((tf6.getText()==null && tf7.getText()==null) || ((a>noofnodes || a<0 )|| (b>noofnodes || b<0)))
		 	{
			 printpath.setVisible(false);
			 tf6.setText("");
			 tf7.setText("");
		 	}
		 else 
		 {
			 printpath.setVisible(true); 
			 tf6.setText("");
			 tf7.setText("");
		 }
		 int distance[][]=floydWarshall(a,b);
		 if(distance[a][b]==9999)
			 {
			 str = "Shortest Distance Between "+a+" & "+b+" = NO PATH";
			 printpath.setVisible(false);
			 flag=0;
			 repaint();
			 }
		 else
		 {
			 index=1;
			 printPath(a,b);
			 str="Shortest Distance between "+a+" & "+b+" = "+distance[a][b];
		 }
		 label.setText(str);
		 label.setFont(new Font("Arial", Font.BOLD, 22));
		 JOptionPane.showMessageDialog(null,label);
	 }
	 
	 public void printAction(ActionEvent e)
	 {
		 sp.setVisible(true);
		 String s1="<html><u><h1><font color='black'>PATH: "; 
		 ok.setVisible(true);
		 cal.setVisible(false);
		 for(int i=0;i<index;i++)
		 {
			 if(i==index-1)
				 s1+=final_path[i]+"</font></h1></u></html>";
			 else
				 s1+=final_path[i]+"-->";
		 }
			 sp.setText(s1);
			 
		flag=1;	 
		repaint();
	 }
	 
	 public void okAction(ActionEvent e)
	 {
		 flag=0;
		 sp.setVisible(false);
		 printpath.setVisible(false);
		 ok.setVisible(false);
		 cal.setVisible(true);
		 sp.setText("");
		 repaint();
	 }
	 
	 int[][] floydWarshall(int a, int b)
	 {
		 int distance[][]=new int[noofnodes][noofnodes];
		 int i,j,k;
		 for(i=0;i<noofnodes;i++)
		 {
			 for(j=0;j<noofnodes;j++)
			 {
				 distance[i][j]=wt[i][j];
				 path[i][j]=(i!=j)?j+1:0;
			 }
		 }
		 for(k=0;k<noofnodes;k++)
		 {
			 for(i=0;i<noofnodes;i++)
			 {
				 for(j=0;j<noofnodes;j++)
				 {
					 if (distance[i][k] + distance[k][j] < distance[i][j])  
					 {
						 distance[i][j] = distance[i][k] + distance[k][j]; 
						 path[i][j]=path[i][k];
					 }
				 }
			 }
		 }
		 System.out.println("Distance matrix");
		 for(int s=0;s<noofnodes;s++)	{
			 for(int t=0;t<noofnodes;t++)
				 System.out.print(distance[s][t]+"\t");
			 System.out.println();
		 }	 
	/*	 for(i=0;i<noofnodes;i++)	{
			 for(j=0;j<noofnodes;j++)	{
				 if(a!=b)
				 {
					 System.out.println("\n"+a+"-> "+b+" "+distance[a][b]+" "+a);
					 k=a+1;
					 do {
						 k=path[k-1][b];
						 System.out.println("-->"+(k-1));
					 }while(k!=b+1);
				 }
		 }
		 }*/
		 return distance;
	 }
	 
	 void printPath(int s, int d)
	 {
		int k;
		final_path[0]=s;
		if(s!=d)
		{
			k=s+1;
			do {
				k=path[k-1][d];
				final_path[index++]=k-1;
			}while(k!=d+1);
		}
	 }
	 	 
	private void createnodes()
	{
			nodes.clear();
			int startX=400,startY=70;
			for(int i=0;i<noofnodes;i++)
			{
				startX+=60;
				if(startX+radius >=xSize-300)
				{
					startX=460;
					startY+=60;
				}
				node temp= new node(startX,startY);
				nodes.add(i,temp);
			}
	
	}
	 public void paint(Graphics g)
		{
		 	int x,y,x1,x2,y1,y2;
	 		super.paint(g);
	 		if(noofnodes>0)
	 		for (int i=0;i<noofnodes;i++)
			{
	      		node temp=nodes.get(i);
	   			g.drawOval(temp.x,temp.y,radius,radius);
	  			g.setColor(Color.BLACK);
				g.fillOval(temp.x,temp.y,radius,radius);
				g.setColor(Color.WHITE);
				Font f=new Font("Arial",Font.BOLD,15);
				g.setFont(f);
				g.drawString(" "+(i),temp.x+(radius/2)-7,temp.y+(radius/2)+5);
	        }
	 		g.setColor(Color.BLACK);

			Iterator itr= edges.iterator();
			node temp1,temp2;
			int i=0;
			while(itr.hasNext())
			{
				edge temp=(edge)itr.next();
				temp1=nodes.get(temp.source);
				temp2=nodes.get(temp.destination);
				x1=temp1.x;
				y1=temp1.y;
				x2=temp2.x;
				y2=temp2.y;
				Graphics2D g2 = (Graphics2D)g;
				g2.setStroke(new BasicStroke(2));
	            if(flag==1)
	            {
	            	if(temp.source==final_path[i] && temp.destination==final_path[i+1])
					{
						g2.setColor(Color.ORANGE);
						i++;
						if(i>index-1) g2.setColor(Color.BLACK);
					}	
					else
						g2.setColor(Color.black);
	            }
	            else
	            	g2.setColor(Color.black);
	            
				g2.drawLine(x1+(radius/2)+4,y1+(radius/2)+8,x2+(radius/2)-4,y2+(radius/2)-8);
				g2.drawString(" "+wt[temp.source][temp.destination], (x1+x2)/2, (y1+y2)/2);
			}
	}
			
	public static void main(String args[]) throws Exception
	{
		
		new GraphPath().setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		node obj1=new node(e.getX(), e.getY());
		nodes.remove(currnode);
		nodes.add(currnode,obj1);
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	class node {
	    public int x;
		public int y;
	    node(int num1,int num2)
	    {
	    	x=num1;
	    	y=num2;
	    }
	}
	class edge {
	    public int source;
		public int destination;

	    public edge(int s, int d)
	   	{
	    	source=s;
	    	destination=d;
	    }

	}