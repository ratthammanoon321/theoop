
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class monster1 {
	Image img;
	public int x = (int) ((Math.random()*800)+50);
	public int y= 0;
	public int count = 0;
	monster1(){
                String imageLocation = "monster.png";
                URL imageURL = this.getClass().getResource(imageLocation);
		img = Toolkit.getDefaultToolkit().getImage(imageURL);
		runner.start();
	}
	Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
					y += 2;
				
                    if(y >= 800){
			img = null;
			runner = null;
			x = -300;
			y = -500;
                    }
                    try{
			runner.sleep(10);
                    }catch(InterruptedException e){}
                }
            }
	});
	
	public Image getImage(){
            return img;
	}
	
	public int getX(){
		
		//System.out.println("this is x "+x);
            return x;
	}
	public int getY(){
		//System.out.println("this is y "+y);
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,45,45));
	}
}
