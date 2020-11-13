
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class playstate1 extends JPanel implements ActionListener{
    
	private final ImageIcon imgstate1 = new ImageIcon(this.getClass().getResource("backstart.jpg"));
	private final ImageIcon imgstate2 = new ImageIcon(this.getClass().getResource("backsecond.jpg"));
	ac m = new ac();
    homegames hg = new homegames();
	ImageIcon end = new ImageIcon(this.getClass().getResource("showscore.jpg"));
	ImageIcon sc = new ImageIcon(this.getClass().getResource("score.png"));
	ImageIcon life = new ImageIcon(this.getClass().getResource("life.png"));
	ImageIcon ti = new ImageIcon(this.getClass().getResource("thetime.png"));
	ImageIcon restart = new ImageIcon(this.getClass().getResource("start.jpg"));
	ImageIcon sta = new ImageIcon(this.getClass().getResource("stage.png"));
	JButton BStartover = new JButton(restart);
	
	private JLabel score = new JLabel(); 

    
	public ArrayList<Fireball> fireball = new ArrayList<Fireball>();
	public ArrayList<bullet> bullet = new ArrayList<bullet>();
	public ArrayList<monster1> m1st = new ArrayList<monster1>();
	public ArrayList<monster1> mon1 = new ArrayList<monster1>();
	public ArrayList<monster2> mon2 = new ArrayList<monster2>();
	public ArrayList<angel> an = new ArrayList<angel>();
	public ArrayList<angel> ang = new ArrayList<angel>();
	public ArrayList<heart> heart = new ArrayList<heart>();
	public ArrayList<ghost> gh = new ArrayList<ghost>();   



	public int times ;
	public int HP = 3;
	public int st1 = 1;
	public int st2 = 2;
	public int dis;
	public int num;
	boolean timestart = true;
	boolean startball = false;
	
	private gameover gover = new gameover();
	public int scor = 0;
	boolean paralyze1 = false;
	int time_paralyze=5;
	
//--------------------------------------------------------------------------------------------------------
	Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
	
	Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});

	Thread m1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startball == false){
				Thread.sleep((long)(Math.random()*12000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            mon1.add(new monster1());
			}
		}
            }
	});


	Thread m1st2 = new Thread(new Runnable(){
		public void run() {
			while(true){
				try{
						if(startball == false){
			Thread.sleep((long)(Math.random()*990)+1000);
						}
		}catch(InterruptedException e){
						e.printStackTrace();
		}
		if(startball == false){
						m1st.add(new monster1());
		}
	}
		}
});

	Thread m2 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startball==false){
				Thread.sleep((long)(Math.random()*10000)+2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            mon2.add(new monster2());
			}
		}
            }
	});
	
	Thread angel = new Thread(new Runnable(){
            public void run() {
            	while(true){
			try{
                            if(startball==false){
								Thread.sleep((long)(Math.random()*10000)+2000);
							}
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startball == false){
                            an.add(new angel());
			}
		}
            }
	});

	Thread angel2 = new Thread(new Runnable(){
		public void run() {
			while(true){
		try{
						if(startball==false){
							Thread.sleep((long)(Math.random()*10000)+800);	
						}
		}catch(InterruptedException e){
						e.printStackTrace();
		}
		if(startball == false){
						ang.add(new angel());
		}
	}
		}
});

	Thread heartt = new Thread(new Runnable(){
		public void run() {
			while(true){
		try{
						if(startball==false){
							Thread.sleep((long)(Math.random()*10000)+2000);
						}
		}catch(InterruptedException e){
						e.printStackTrace();
		}
		if(startball == false){
			heart.add(new heart());
		}
	}
		}
});

Thread gghost = new Thread(new Runnable(){
	public void run() {
		while(true){
	try{
					if(startball==false){
						Thread.sleep((long)(Math.random()*10000)+2100);
					}
	}catch(InterruptedException e){
					e.printStackTrace();
	}
	if(startball == false){
		gh.add(new ghost());
	}
}
	}
});

	

        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times+1) ;
                           
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
	//------------------------------------------------------------------------------------------------
	playstate1(){
		this.setFocusable(true);
		this.setLayout(null);
		this.add(score);
		this.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			
			    if(a==KeyEvent.VK_LEFT){
			     	m.x-=15;
                                m.count++;
                            }
                            else if(a == KeyEvent.VK_RIGHT){
                               m.x+=15;
                               m.count++;
			   }
                            if(m.count>3){
                                m.count=0;
                            }
                            else if(a == KeyEvent.VK_Z){
								
                               m.count=5;
			       fireball.add(new Fireball(m.x,550));
				}
				else if(a == KeyEvent.VK_C){
								//System.out.println("bullet");
					m.count=5;
					bullet.add(new bullet(m.x,550));
	 }
				
			
                    }
            public void keyReleased(KeyEvent e){
			m.count=0;
		    }
		});
		
		m.x = 400;
		time.start();
		actor.start();
		t.start();
		m1.start();
		m2.start();
		angel.start();
		//paralyze.start();
		heartt.start();
		gghost.start();
		angel2.start();
		m1st2.start();
	}
	
	
	
	public void paintComponent(Graphics g){
			super.paintComponent(g);
			

            if(times >= 50 || HP<=0){
                 this.setLayout(null);
                g.drawImage(end.getImage(),0,0,1000,800,this);
				g.setColor(Color.red);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,200));		
			    g.drawString(""+scor,500,500);	     
               
				
				    
			}
			
			//--------------------stage2---------------------------
			else if(times > 25){
                g.drawImage(imgstate2.getImage(),0,0,1000,800,this);
                if(paralyze1){
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("Hobo Std",Font.BOLD,50));
                }else{
                    g.drawImage(m.im[m.count].getImage(), m.x, 550,110,160, this);
                }
   		if(m.x<0){
                    m.x=this.getWidth()-10;
   		}
   		if(m.x>this.getWidth()){
                    m.x=20;
   		}
   		for(int i=0;i<fireball.size();i++){
                    Fireball ba = fireball.get(i);
      		    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,50,50, null);
      		    ba.move();
      		    ba.count++;
      		    if(ba.y<0){
					  fireball.remove(i);
					  
      		    }
		   }
		   
		   for(int i=0;i<bullet.size();i++){
			bullet bu = bullet.get(i);
		  g.drawImage(bu.imbull[bu.count%5].getImage(), bu.x, bu.y,50,50, null);
		  bu.move();
		  bu.count++;
		  if(bu.y<0){
			bullet.remove(i);
			  
		  }
   }
		 					//------------------monster1 stage2--------------------
		 
		for(int i=0 ; i<m1st.size();i++){

					g.drawImage( m1st.get(i).getImage() ,m1st.get(i).getX(),m1st.get(i).getY(),100,100,this);
				
		}
			//------------------เกินเส้น------------------------
		for(int j=0 ; j<m1st.size();j++){
			if(m1st.get(j).getY() > 500){
				m1st.remove(j);
			   scor -= 10;
			   g.drawString("-10",m.x+100,650);
			}
		}

		//-----------------------ยิงงงงงงงงงง-------------------------------------------//
	                   for(int i=0 ; i<fireball.size();i++){
                    for(int j=0 ; j<m1st.size();j++){
						if(Intersect(fireball.get(i).getbound(),m1st.get(j).getbound())){
							
							num +=1;
							
							if(num ==2){
							
								m1st.remove(j);
						fireball.remove(i);
						scor += 10;
						g.drawString("+10",m.x+100,650);
								num =0;
								
					}
					} 
		    }
		}


						//---------------------monster2 stage2--------------------
		for(int i=0 ; i<mon2.size();i++){
                    g.drawImage(mon2.get(i).getImage(),mon2.get(i).getX(),mon2.get(i).getY(),100,100,this);
		}

		for(int j=0 ; j<mon2.size();j++){
			if(mon2.get(j).getY() > 500){
				mon2.remove(j);
			   scor -= 10;
			   g.drawString("-10",m.x+100,650);
			}
		}
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<mon2.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),mon2.get(j).getbound())){
			    mon2.remove(j);
			    fireball.remove(i);
			    scor += 20;
			    g.drawString("+20",m.x+100,650);
   			} 
		    }
		}


							//----------------------angel stage2------------------------
		for(int i=0 ; i<ang.size();i++){
		    g.drawImage(ang.get(i).getImage(),ang.get(i).getX(),ang.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fireball.size();i++){
                    for(int j=0 ; j<ang.size();j++){
                        if(Intersect(fireball.get(i).getbound(),ang.get(j).getbound())){
                            ang.remove(j);
			    fireball.remove(i);
			    scor -=20;
			    HP=HP-1;
			    g.drawString("-1HP",m.x+100,580);
			    g.drawString("-20",m.x+100,650);
			} 
		    }
		}

		//------------------------------heart stage2---------------------------------------------//
		for(int i=0 ; i<heart.size();i++){
		    g.drawImage(heart.get(i).getImage(),heart.get(i).getX(),heart.get(i).getY(),100,100,this);
		}

				for(int i=0 ; i<fireball.size();i++){
                    for(int j=0 ; j<heart.size();j++){
                        if(Intersect(fireball.get(i).getbound(),heart.get(j).getbound())){
                            heart.remove(j);
			    fireball.remove(i);
			   
			    HP=HP+1;
			    g.drawString("-1HP",m.x+100,580);
			   
			} 
		    }
		}
		      //------------------------------ghost stage2------------------------------------------------------//
		for(int i=0 ; i<gh.size();i++){
		    g.drawImage(gh.get(i).getImage(),gh.get(i).getX(),gh.get(i).getY(),100,100,this);
		}

		for(int j=0 ; j<gh.size();j++){
			if(gh.get(j).getY() >= 500){
				gh.remove(j);
				HP=HP-1;
			    g.drawString("-1HP",m.x+100,580);
			}
		}
		for(int i=0 ; i<bullet.size();i++){
                    for(int j=0 ; j<gh.size();j++){
                        if(Intersect(bullet.get(i).getbound(),gh.get(j).getbound())){
                            gh.remove(j);
							bullet.remove(i);
							HP=HP-1;
							   g.drawString("-1HP",m.x+100,580);
			   
			} 
		    }
		}
		

		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);
		g.drawImage(sc.getImage(),80,70,100,50,this);
		g.drawString(" =  "+scor,182, 100);	     
		g.drawImage(ti.getImage(),360,50,100,80,this);
		g.setColor(Color.white);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,60));
		g.drawString(" = "+times,450,120);
		g.drawImage(life.getImage(),90,150,100,80,this);
		g.setColor(Color.RED);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString(" =  "+HP,200,200);
		g.fillRect(-10, 500, 1000, 10);
		      
			}
			else if(times >= 50 || HP<=0){
		
                this.setLayout(null);
                g.drawImage(end.getImage(),0,0,1000,800,this);
                g.setColor(Color.red);
				g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,200));		
				g.drawString(""+scor,500,500);
		//------------------------------stage1------------------------------------------------------
			
			}else if(times <= 25){
                g.drawImage(imgstate1.getImage(),0,0,1000,800,this);
                if(paralyze1){
                    g.setColor(Color.RED);
                    g.setFont(new Font("Hobo Std",Font.BOLD,50));
                   // g.drawImage(img_paralyze.getImage(), m.x, 550,100,150, this);
                    g.drawString("-10",m.x+100,650);
                    g.drawString("AHHHH !!!", m.x+100, 560);
                }else{
                    g.drawImage(m.im[m.count].getImage(), m.x, 550,110,160, this);
                }
		if(m.x<0){
                    m.x=this.getWidth()-10;
		}
		if(m.x>this.getWidth()){
                    m.x=20;
		}
		for(int i=0;i<fireball.size();i++){
		    Fireball ba = fireball.get(i);
                    g.drawImage(ba.imfire[ba.count%5].getImage(), ba.x, ba.y,50,50, null);
		    ba.move();
                    ba.count++;
		    if(ba.y<0){
		    	fireball.remove(i);
		    }
		}

		for(int i=0;i<bullet.size();i++){
			bullet bu = bullet.get(i);
		  g.drawImage(bu.imbull[bu.count%5].getImage(), bu.x, bu.y,50,50, null);
		  bu.move();
		  bu.count++;
		  if(bu.y<0){
			bullet.remove(i);
			  
		  }
   }
		  
		//-------------------------------------monster1 stage1 ----------------------------------
                for(int i=0 ; i<mon1.size();i++){
					g.drawImage(mon1.get(i).getImage(),mon1.get(i).getX(),mon1.get(i).getY(),100,100,this);
					
		 }

		//--------------เกินเส้น------------------------
		 for(int j=0 ; j<mon1.size();j++){
			 if(mon1.get(j).getY() > 500){
				 mon1.remove(j);
				scor -= 10;
				g.drawString("-10",m.x+100,650);
			 }
		 }
		 
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<mon1.size();j++){
									
							

						
		    	if(Intersect(fireball.get(i).getbound(),mon1.get(j).getbound())){

					mon1.remove(j);
							fireball.remove(i);
							scor += 10;
							g.drawString("+10",m.x+100,650);
									num =0;
					
			} 
		    }
		}
		//--------------------------------------monster2 stage1 --------------------------------------
		for(int i=0 ; i<mon2.size();i++){
		    g.drawImage(mon2.get(i).getImage(),mon2.get(i).getX(),mon2.get(i).getY(),100,100,this);
		 }
		

		 for(int j=0 ; j<mon2.size();j++){
			if(mon2.get(j).getY() > 500){
				mon2.remove(j);
			   scor -= 10;
			   g.drawString("-10",m.x+100,650);
			}
		}

		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<mon2.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),mon2.get(j).getbound())){
					
			    mon2.remove(j);
			    fireball.remove(i);
			    scor += 20;
			    g.drawString("+20",m.x+100,650);
			 } 
		    }
		}
		//-------------------------------------angel------------------------------------------------------
		for(int i=0 ; i<an.size();i++){
		    g.drawImage(an.get(i).getImage(),an.get(i).getX(),an.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fireball.size();i++){
		    for(int j=0 ; j<an.size();j++){
		    	if(Intersect(fireball.get(i).getbound(),an.get(j).getbound())){
			    an.remove(j);
			    fireball.remove(i);
			    scor -=10;
			    HP=HP-1;
			    g.drawString("-1HP",m.x+100,650);
			    g.drawString("-20",m.x+100,580);
			} 
		    }
		}
		      
		//------------------------------heart-------------------------------------------------------------
		for(int i=0 ; i<heart.size();i++){
			g.drawImage(heart.get(i).getImage(),heart.get(i).getX(),heart.get(i).getY(),100,100,this);
			
		}
		for(int i=0 ; i<fireball.size();i++){
                    for(int j=0 ; j<heart.size();j++){
						 if(Intersect(fireball.get(i).getbound(),heart.get(j).getbound())){
							fireball.remove(i);
							heart.remove(j); 
			    HP=HP+1;
			    g.drawString("+1HP",m.x+100,580);
			   
			} 
		    }
		}

		
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);
		g.drawImage(sc.getImage(),80,70,100,50,this);
		g.drawString(" =  "+scor,182, 100);	     
		g.drawImage(ti.getImage(),360,50,100,80,this);
		g.setColor(Color.white);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,60));
		g.drawString(" = "+times,450,120);
		g.drawImage(life.getImage(),90,150,100,80,this);
		g.setColor(Color.RED);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString(" =  "+HP,200,200);
		g.fillRect(-10, 500, 1000, 10);
		      
	    }

	}

	public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== BStartover){		
                    this.setSize(1000,800);
                    this.add(hg);
                    this.setLocation(null);
                    timestart = true;
                    startball = true;
		}
		//else if(e.getSource() == BExitover){
              //      System.exit(0);
	//	}		
	}
}
