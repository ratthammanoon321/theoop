
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.geom.Rectangle2D;
import java.net.URL;


public class monster2 extends monster1{
    Image img;
    public int x = (int) ((Math.random()*800)+50);
	public int y= 0;
	public int count = 0;
    monster2(){
        String imageLocation = "mm.png";
        URL imageURL1 = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL1);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
	public void run() {
            while(true){
		x += 2;
		if(x >= 1100){
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try{
                    runner.sleep(30);
                }catch(InterruptedException e){}
            }
	}
    });

    public Image getImage(){
	return img;
    }
}
