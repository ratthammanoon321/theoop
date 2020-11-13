



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class PlayGames extends JFrame implements ActionListener{  
	homegames home = new homegames();
	playstate1 playstate = new playstate1();
	
	public PlayGames(){
		this.setSize(1000,800);
		this.add(home);
		home.BStart.addActionListener(this);
				
	}

	public void actionPerformed(ActionEvent e) {
            if(e.getSource()== home.BStart){
		this.setLocationRelativeTo(null);
		this.remove(home);
                this.setSize(1000,800);
                this.add(playstate);
                playstate.requestFocusInWindow();
				playstate.timestart = false;
				playstate.scor=0;
				playstate.HP =2;
				playstate.times = 0;
				playstate.startball=false;
				playstate.timestart=false;
			}
						
			
			

            this.validate();
            this.repaint();
	}
        
     public static void main(String[] args) {
            JFrame jf = new PlayGames();
            jf.setSize(1000,800);
            jf.setTitle("man vs  monster");
            jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jf.setVisible(true);
            jf.setLocationRelativeTo(null);
    }    
        
        
	
}
