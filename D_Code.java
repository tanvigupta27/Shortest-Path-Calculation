import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
class D_Code extends JFrame implements ActionListener, MouseListener
{
	// Variables declaration 
    JButton create, move, connect,click_find,cal, refresh, exit,printpath, ok, back;
    JLabel c_node, nos_node, m_node, move_id, e_connection, src, dest,weight,s,d,sp, label;
    JTextField tf1, tf2, tf3, tf4, tf5,tf6,tf7;		
    int noofnodes=0,ssrc,ddesti,wght,xSize,ySize,currnode, wt[][],index, globalsource,flag=0,radius=50, parent[],show_path[];
    Container con;
	public ArrayList<node2> nodes = new ArrayList<node2>();
	public ArrayList<edge2> edges = new ArrayList<edge2>();
    // End of variables declaration
	D_Code()
	{
		super("Shortest Algo");
		Toolkit tk = Toolkit.getDefaultToolkit();
        xSize = ((int) tk.getScreenSize().getWidth());
        ySize = ((int) tk.getScreenSize().getHeight());
		setSize(xSize,ySize);
		System.out.print((xSize)+" "+(ySize));
		setResizable(false);
		initComponents();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				
	}
	public void initComponents() 
	{
		
		con=super.getContentPane();
		con.setBackground(Color.LIGHT_GRAY);
		con.setLayout(null);
		
		//First
		con.add(c_node = new JLabel("<html> <h1><font color='red'><u>NODE CREATION</u></font></h1></html>"));
		c_node.setBounds(10, 10, 250, 50);
		
		con.add(nos_node = new JLabel("<html><h2>No. of Nodes: </h2></html>"));
		nos_node.setBounds(10, 50, 150, 40);
				
		con.add(tf1 = new JTextField());
		tf1.setBounds(200, 60, 100, 25);
				
		con.add(create = new JButton( "<html><h3>CREATE</h3></html>"));
		create.setBounds(10, 100, 150, 35);
			
		//Second
		con.add(m_node = new JLabel("<html> <h1><font color='red'><u>MOVE A NODE</u></font></h1> </html>"));
		m_node.setBounds(10, 140, 250, 50);
		m_node.setVisible(false);
		
		con.add(move_id = new JLabel("<html> <h2>Move ID:  </h2></html>"));
		move_id.setBounds(10, 180, 150, 40);
		move_id.setVisible(false);
				
		con.add(tf2 = new JTextField());
		tf2.setBounds(200, 190, 100, 25);
		tf2.setVisible(false);
				
		con.add(move = new JButton( "MOVE"));
		move.setBounds(10, 230, 150, 35);
		move.setVisible(false);
		
		//Third
		con.add(e_connection = new JLabel("<html> <h1><font color='red'><u>ESTABLISH A CONNECTION</u></font></h1> </html>"));
		e_connection.setBounds(10, 270, 350, 50);
		e_connection.setVisible(false);
		
		con.add(src = new JLabel("<html> <h2>SOURCE:</h2></html>"));
		src.setBounds(10, 310, 150, 40);
		src.setVisible(false);
				
		con.add(tf3 = new JTextField());
		tf3.setBounds(200, 320, 100, 25);
		tf3.setVisible(false);
		
		con.add(dest = new JLabel("<html> <h2>DESTINATION:</h2></html>"));
		dest.setBounds(10, 340, 150, 40);
		dest.setVisible(false);
				
		con.add(tf4 = new JTextField());
		tf4.setBounds(200, 350, 100, 25);
		tf4.setVisible(false);
		
		con.add(weight = new JLabel("<html> <h2>WEIGHT:</h2></html>"));
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
		
		con.add(s=new JLabel("<html> <h2>Source Vertex:</h2></html>"));
		s.setBounds(10, 510, 150, 40);
		s.setVisible(false);
		
		con.add(tf6=new JTextField());
		tf6.setBounds(200, 520, 100, 25);
		tf6.setVisible(false);
		
		con.add(d=new JLabel("<html> <h2>Destination Vertex:</h2></html>"));
		d.setBounds(10, 550, 200, 40);
		d.setVisible(false);
		
		con.add(tf7=new JTextField());
		tf7.setBounds(200, 560, 100, 25);
		tf7.setVisible(false);
		
		//FIFTH
		con.add(cal=new JButton("Calculate"));
		cal.setBounds(10, 610, 150, 35);
		cal.setVisible(false);
		
		con.add(printpath=new JButton("Print Path"));
		printpath.setBounds(180, 610, 150, 35);
		printpath.setVisible(false);
		
		con.add(sp=new JLabel());
		sp.setBounds(20, 640, 1000, 100);
		sp.setVisible(true);
		
		con.add(ok=new JButton("<html> <h2>OK</h2></html>"));
		ok.setBounds(20, 740, 100, 35);
		ok.setVisible(false);
		
		con.add(label=new JLabel());
		
		//SIXTH
		con.add(refresh=new JButton("NEW GRAPH"));
		refresh.setBounds(20, 980, 150, 40);
		refresh.setVisible(true);
		con.add(back=new JButton("BACK"));
		back.setBounds(200, 980, 150, 40);
		back.setVisible(true);
		con.add(exit=new JButton("EXIT"));
		exit.setBounds(390, 980, 150, 40);
		exit.setVisible(true);
		
		refresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               new D_Code().setVisible(true);
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
   			createnodes();
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
	   	wt[ddesti][ssrc]=wght;
	   	   
	   	if(temp1!=null && temp2!=null)
	   		{
	   			edge2 temp= new edge2(ssrc,ddesti);
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
		 printpath.setVisible(true);
		 String s1;
		 int a=Integer.parseInt(tf6.getText());
		 int b=Integer.parseInt(tf7.getText());
		 if(tf6.getText()==null && tf7.getText()==null);
		 else {
			 printpath.setVisible(true); 
		 tf6.setText("");
		 tf7.setText("");}
		 globalsource=a;
			//	 SHORTEST PATH USING DIJKASTRA ALGORITHM;
		 if(a==b || ((a>noofnodes || a<0 )|| (b>noofnodes || b<0)))
		 {
			 s1="Using Dijkastra Algorithm\nShortest Distance between "+a+" & "+b+" = 0";
			 printpath.setVisible(false);
		 }
		 else {
		 int distance[]=dijkastra(a,b);
		 if(distance[b]==Integer.MAX_VALUE)
		 {
			 s1="Shortest Distance between "+a+" & "+b+" = NO PATH";
			 printpath.setVisible(false);
			 flag=0;
			 repaint();
		 }
		 else
		 {
			 index=1;
		 printpath(a,b);
		 System.out.println("Show Path: \n");
		 for(int i=0;i<index;i++)
			 System.out.println(show_path[i] + " ");
		 s1="Shortest Distance between "+a+" & "+b+" = "+distance[b]+"";
		 }
		 }
		 label.setText(s1);
		 label.setFont(new Font("Arial", Font.BOLD, 22));
		 JOptionPane.showMessageDialog(null,label);
	 }
	 
	 public void printAction(ActionEvent e)
	 {
		 System.out.println("Index: " +index);
		 sp.setVisible(true);
		 sp.setBackground(Color.RED);
		 sp.setForeground(Color.RED);
		 sp.setFont(getFont());
		 String s1="<html><h1> "; 
		 ok.setVisible(true);
		 cal.setVisible(false);
		 for(int i=0;i<index;i++)
		 {
			 if(i==index-1)
				 s1+=show_path[i]+"</h1></html";
			 else
				 s1+=show_path[i]+"-->";
		 }
			 sp.setText(""+s1);
			 
		flag=1;	 
		repaint();
	 }
	 
	 public void okAction(ActionEvent e)
	 { flag=0;
		 sp.setVisible(false);
		 printpath.setVisible(false);
		 ok.setVisible(false);
		 cal.setVisible(true);
		 repaint();
	 }
	 
	 int[] dijkastra(int a, int b)
	 {
		 parent=new int[noofnodes];
		 show_path=new int[noofnodes];
		 show_path[0]=a;
		 int distance[]=new int[noofnodes];
		 boolean state[]=new boolean[noofnodes];		 
		 for(int i=0;i<noofnodes;i++)
		 {
			 parent[a]=-1;
			 distance[i]=Integer.MAX_VALUE;
			 state[i]=false;
		 }
		 
		 distance[a]=0;
		 int min_v;
		 for(int i=0;i<noofnodes;i++)
		 {
			 min_v=find_vertex(distance,state);
			 state[min_v]=true;
			 
			 for(int j=0;j<noofnodes;j++)
			 {
				 if(wt[min_v][j]!=0 && !state[j])
				 {
					 int dist=distance[min_v]+ wt[min_v][j];
					 if(dist<distance[j])
					 {
						 parent[j]=min_v;
						 distance[j]=dist;
					 }
				 }
			 }
		 }
		 System.out.print("Parent:\n ");
		 for(int i=0;i<noofnodes;i++)
			 System.out.print(parent[i]+ " ");
		 return distance;
	 }
	 
	 void printpath(int s,int d)
	 {
		 if(parent[d]==-1) {
			// System.out.println(s);
		 		return;}
		 printpath(s,parent[d]);
		 //System.out.println(d);
		 show_path[index++]=d;
	 }
	 
	 
	 int find_vertex(int distance[],boolean state[])
	 {
		 int min=Integer.MAX_VALUE, min_v=-1;
		 
		 for(int i=0;i<noofnodes;i++)
		 {
			 if(!state[i] && distance[i]<=min)
			 {
				 min=distance[i];min_v=i;
			 }
		 }
		 
		 return min_v;
	 }	 
	 
	private void createnodes()
	{
			nodes.clear();
			int startX=400,startY=70;
			for(int i=0;i<noofnodes;i++)
			{
				startX+=60;
				if(startX+radius >=xSize)
				{
					startX=460;
					startY+=60;
				}
				node2 temp= new node2(startX,startY);
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
	      		node2 temp=nodes.get(i);
	   			g.drawOval(temp.x,temp.y,radius,radius);
	  			g.setColor(Color.BLACK);
				g.fillOval(temp.x,temp.y,radius,radius);
				g.setColor(Color.WHITE);
				Font f=new Font("Arial",Font.BOLD,15);
				g.setFont(f);
				g.drawString(" "+(i),temp.x+(radius/2)-5,temp.y+(radius/2)+5);
				
	        }
	 		g.setColor(Color.BLACK);

			Iterator itr= edges.iterator();
			node2 temp1,temp2;
			int i=0;
			while(itr.hasNext())
			{
				edge2 temp=(edge2)itr.next();
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
					for(i=0;i<index-1;i++)
					{
						if(temp.source==show_path[i] && temp.destination==show_path[i+1] || temp.source==show_path[i+1] && temp.destination==show_path[i] )
							{g2.setColor(Color.RED);break;}
						else
							g2.setColor(Color.BLACK);
					}
					//g.setColor(Color.BLACK);
						//if(i>index-1) g.setColor(Color.BLACK);
				}
					//else
						//g.setColor(Color.black);
				else
					g2.setColor(Color.black);
				g2.drawLine(x1+(radius/2)-4,y1+(radius/2)+4,x2+(radius/2)-4,y2+(radius/2)+4);
				g2.drawString(""+wt[temp.source][temp.destination], (x1+x2)/2, (y1+y2)/2);
		}
	
	}
			
	public static void main(String args[]) throws Exception
	{
		
		new D_Code().setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		node2 obj1=new node2(e.getX(), e.getY());
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
	class node2 {
	    public int x;
		public int y;
	    node2(int num1,int num2)
	    {
	    	x=num1;
	    	y=num2;
	    }
	}
	class edge2 {
	    public int source;
		public int destination;

	    public edge2(int s, int d)
	   	{
	    	source=s;
	    	destination=d;
	    }

	}