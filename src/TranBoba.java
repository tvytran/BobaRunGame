import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class TranBoba
{
    private int x,y;
    private int diam;
    private Color col;
    private ImageIcon imgI;
    
    public TranBoba(int a, int b)
    {
        x = a;
        y = b;
        diam = 30;
        col = Color.BLACK;
        imgI = new ImageIcon(TranBoba.class.getResource("Boba.png"));
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
    public int getCenterX()
    {
        return x + diam/2;
    }
    public int getCenterY()
    {
        return y + diam/2;
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
        
        int anotherCX = thePlayer.getCenterX() + thePlayer.getVX();//notice we are adding the VX and the VY
        int anotherCY = thePlayer.getCenterY() + thePlayer.getVY(); 

        //getting the radius
        int rad = diam/2;
        int anotherRad = thePlayer.getDiam()/2;
        
        //checking if this boba collided with the player
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
        if(dist <= rad + anotherRad)
        {
            return true;
        }
        else
            return false;
    }
    
    public boolean handleCollision(TranBoba anotherBoba)
    {
         //Getting the center
        int centerX = this.getCenterX();
        int centerY = this.getCenterY();
        
        int anotherCX = anotherBoba.getCenterX(); //+ anotherBoba.getVX();//notice we are adding the VX and the VY
        int anotherCY = anotherBoba.getCenterY(); //+ anotherBoba.getVY(); 

        //getting the radius
        int rad = diam/2;
        int anotherRad = anotherBoba.getDiam()/2;
        
        //checking if this boba collided with the boba
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        if(dist < rad + anotherRad)
        {
            return true;
        }
        else
            return false;
    }
    
    public boolean handleCollision(TranMatchaTea matchaTea)
    {
         //Getting the center
        int centerX = this.getCenterX();
        int centerY = this.getCenterY();
        
        int anotherCX = matchaTea.getCenterX(); //+ anotherBoba.getVX();//notice we are adding the VX and the VY
        int anotherCY = matchaTea.getCenterY(); //+ anotherBoba.getVY(); 

        //getting the radius
        int rad = diam/2;
        int anotherRad = matchaTea.getDiam()/2;
        
        //checking if this boba collided with the matchaTea
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        if(dist < rad + anotherRad)
        {
            return true;
        }
        else
            return false;
    }
    
    //HELPER METHOD FOR SHOOOT
    public boolean checkIfInside(TranBoba anotherBoba)//returns true if this boba is inside of another boba
    {
        int centerX = this.getCenterX();
        int centerY = this.getCenterY();
        
        int anotherCX = anotherBoba.getCenterX(); //+ anotherBoba.getVX();//notice we are adding the VX and the VY
        int anotherCY = anotherBoba.getCenterY(); 
                
        if(distance(getCenterX(), getCenterY(), x, y) <= diam/2)
            return true;
        else
            return false;
    }
    
}