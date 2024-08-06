import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class TranStar
{
    //instance variables fun
    private int x,y;
    private int diam;
    private Color col;
    private boolean collected;
    private ImageIcon imgI;
    
    //constructors
    public TranStar(int a, int b)
    {
        x = a;
        y = b;
        diam = 20;
        col = Color.LIGHT_GRAY;
        collected = false;
        imgI = new ImageIcon(TranPlayer.class.getResource("Star.png"));
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
    public int getDiam()
    {
        return diam;
    }
    public Color getColor()
    {
        return col;
    }
    public boolean getCollected()
    {
        return collected;
    }
    public int getCenterX()
    {
        return x + diam/2;
    }
    public int getCenterY()
    {
        return y + diam/2;
    }
    //mutator methods
    public Color setColor(Color c)
    {
        col = c;
        return col;
    }
    private double distance(int x1, int y1, int x2, int y2)
    {
        double results;
        results = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return results;
    }
    
    //interesting methods
    public void drawSelf(Graphics g)
    {
        //g.setColor(col);
        //g.fillOval(x, y, diam, diam);
        Graphics2D g2d;
        g2d = (Graphics2D)g;
        Image img = imgI.getImage();
        g2d.drawImage(img, x, y, diam, diam, null);
    }
    public boolean handleCollision(TranPlayer thePlayer)
    {
        //Getting the center
        int centerX = this.getCenterX();
        int centerY = this.getCenterY();
        
        int anotherCX = thePlayer.getCenterX();
        int anotherCY = thePlayer.getCenterY();
        
        
        //getting radius
        int rad = diam/2;   
        int anotherRad = thePlayer.getDiam()/2;
        
        //checking if star has collided with player
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