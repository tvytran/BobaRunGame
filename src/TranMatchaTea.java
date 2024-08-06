import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class TranMatchaTea
{
    private int x,y,vx,vy;
    private int diam;
    private Color col;
    private ImageIcon[] imgIcons;
    
    public TranMatchaTea(int a, int b)
    {
        x = a;
        y = b;
        diam = 30;
        vx = 3;
        vy = 3;
        col = Color.GREEN;
        
        imgIcons = new ImageIcon[2];      
        imgIcons[0] = new ImageIcon(TranPlayer.class.getResource("MatchaTea.png"));
        imgIcons[1] = new ImageIcon(TranPlayer.class.getResource("ReverseMatchaTea.png"));  
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
    public int getVX()
    {
        return vx;
    }
    public int getVY()
    {
        return vy;
    }
    
    //interesting methods
    private double distance(int x1, int y1, int x2, int y2)
    {
        double results;
        results = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return results;
    }
    public void drawSelf(Graphics g)
    {
        //g.setColor(col);
        //g.fillOval(x, y, diam, diam);
        Graphics2D g2d;
        g2d = (Graphics2D)g;
        if(vx >= 0)
        {
            //moving right
            Image img = imgIcons[0].getImage(); 
            g2d.drawImage(img, x, y, diam, diam, null);
        }
        else if(vx <= 0)
        {
            //moving left
            Image img = imgIcons[1].getImage(); 
            g2d.drawImage(img, x, y, diam, diam, null);
        }
    }
    public void act(int w, int h, TranPlayer player)
    {
        //get the next x and y coordinates
        int nextX = x + vx;
        int nextY = y + vy;
        
        //if-statements to handle the tea following the player
        if(player.getX() > this.getX())
        {
            vx=3;
        }
        else if(player.getX() < this.getX())
        {
            vx=-3;
        }
        
        if(player.getY() > this.getY())
        {
            vy=3;
        }
        else if(player.getY() < this.getY())
        {
            vy=-3;
        }
        
        
        
        
        //updating x and y
        x+=vx;
        y+=vy;
    }
    public boolean handleCollision(TranPlayer thePlayer)
    {
        //Getting the center
        int centerX = this.getCenterX() + vx;
        int centerY = this.getCenterY() + vy;
        
        int anotherCX = thePlayer.getCenterX() + thePlayer.getVX();//notice we are adding the VX and the VY
        int anotherCY = thePlayer.getCenterY() + thePlayer.getVY(); 

        //getting the radius
        int rad = diam/2;
        int anotherRad = thePlayer.getDiam()/2;
        
        //checking if collided
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
        if(dist <= rad + anotherRad)
        {
            return true;    
        }
        else
            return false;
    }
    public boolean handleCollision(ArrayList<TranBoba> bobas)
    {
        //Getting the center 
        int centerX = this.getCenterX();
        int centerY = this.getCenterY();
       
        for(int i = 0; i < bobas.size(); i++)
        {
              
            TranBoba currBoba = bobas.get(i);

            //then you can get the  center of each boba.
            int anotherCX = currBoba.getCenterX();
            int anotherCY = currBoba.getCenterY();
            
            int rad = diam/2;
            int anotherRad = currBoba.getDiam()/2;
        
            //checking if this COLLIDED
            double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
            if(dist <= rad + anotherRad)
            {
                //they collided
                bobas.remove(i);
                return true;
            }
            
        }
        return false; 
    }
}