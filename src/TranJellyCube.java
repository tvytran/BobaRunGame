import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class TranJellyCube
{
    //instance variables
    private int x,y,w,h;
    private Color col;
    private boolean collected;
    private ImageIcon imgI;
    
    //constructor
    public TranJellyCube(int a, int b)
    {
        x = a;
        y = b;
        w =30;
        h = 30;
        col = Color.RED;
        collected = false;
        imgI = new ImageIcon(TranPlayer.class.getResource("JellyCube.png"));
    }
    
    //accessor methods
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getW()
    {
        return w;
    }
    public int getH()
    {
        return h;
    }
    public boolean getCollected()
    {
        return collected;
    }
    public int getCenterX()
    {
        return x + w/2;
    }
    public int getCenterY()
    {
        return y + h/2;
    }
    
    //interesting methods
    public void drawSelf(Graphics g)
    {
        //g.setColor(col);
        //g.fillRect(x, y, w, h);
        Graphics2D g2d;
        g2d = (Graphics2D)g;
        Image img = imgI.getImage();
        g2d.drawImage(img, x, y, w, h, null);
    }
    private double distance(int x1, int y1, int x2, int y2)
    {
        double results;
        results = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return results;
    }
    public boolean handleCollision(TranPlayer thePlayer)
    {
        //Getting the center
        int centerX = this.getCenterX();
        int centerY = this.getCenterY();
        
        int anotherCX = thePlayer.getCenterX();
        int anotherCY = thePlayer.getCenterY();
        
        
        //getting radius
        int rad = h/2;   
        int anotherRad = thePlayer.getDiam()/2;
        
        //checking if jellyCube has collided with player
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
        if(dist <= rad + anotherRad)
        {
            collected = true;
            return true;
        }
        else
            return false;
    }
}