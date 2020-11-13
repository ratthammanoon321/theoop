
import java.awt.geom.Rectangle2D;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class bullet extends JPanel{
    public ImageIcon[] imbull = new ImageIcon[5];
    public int y;
    public int x;
    public int count=0;
    bullet(int x,int y){
        for(int i=0;i<imbull.length;i++){
            String imageLocation = "g"+(i+1)+".png";
            imbull[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x=x;
            this.y=y;
    }
	
    public void move(){
	this.y-=1;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
}
