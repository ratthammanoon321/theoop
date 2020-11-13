


import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
public class ac extends monster1{
    Image img;
	
    public ImageIcon[] im = new ImageIcon[6];
    
    public int x;
    public int count = 0;
    ac(){

        
        for(int i=0;i<im.length;i++){
            String imageLocation = "m"+(i+1)+".png";
            im[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
       
      

    }
    public Image getImage(){
        return img;
}

public int getX(){
    
    
        return x;
}
public int getY(){
   
        return y;
}
public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x,y,45,45));
}
public Rectangle2D getboundG(){
    return (new Rectangle2D.Double(x,y+50,200,200));
}

}






	
	
	
	

