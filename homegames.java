



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class homegames extends JPanel{
        private ImageIcon feild = new ImageIcon(this.getClass().getResource("homebackground.jpg"));
        private ImageIcon starts = new ImageIcon(this.getClass().getResource("startbutton.png"));
        public JButton BStart = new JButton(starts);
              
       
     
	homegames(){
            setLayout(null);
            add(BStart);
            BStart.setBounds(350,400,269,97);
            add(BStart);
          
            
        }
        
	public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,1000,800,this);
            g.setColor(Color.BLACK);
            g.setFont(new Font("ZapfDingbats",Font.CENTER_BASELINE,90));		
            g.drawString("      man vs monster  ",70,200);	
	}
}