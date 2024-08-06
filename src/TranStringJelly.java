import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class TranStringJelly
{
    private int x,y,vx,vy;
    private int diam;
    private Color col;
    private boolean collected;
    private ImageIcon[] imgIcons;
    
    public TranStringJelly(int a, int b)
    {
        x = a;
        y = b;
        diam = 30;
        vx = 2;
        vy = 2;
        col = Color.PINK;
        collected = false;
        imgIcons = new ImageIcon[2]; // 1 2 3 2  1 2 3 2       
        imgIcons[0] = new ImageIcon(TranPlayer.class.getResource("JellyString.png"));
        imgIcons[1] = new ImageIcon(TranPlayer.class.getResource("ReverseJellyString.png"));
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
    public boolean getCollected()
    {
        return collected;
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
    public void act(int w, int h)
    {
        //get the next x and y coordinates
        int nextX = x + vx;
        int nextY = y + vy;
        
        //if-statements to handle bouncing off of the 4 walls
        if(nextX + diam >= w)
            vx*=-1;
        else if(nextY + diam >= h)
            vy*=-1;
        else if(nextX < 0)
            vx*=-1;
        else if(nextY < 0)
            vy*=-1;
        
        
        //updating x and y
        x+=vx;
        y+=vy;
    }
                                
    public void handleCollision(ArrayList<TranBoba> bobas)
    {
        //Getting the center of this Bubble and anotherBubble
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
        
            //checking if collided
            double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
            if(dist <= rad + anotherRad)
            {
                //they collided
   
                //calculating the velocities of this Bubble after colliding with anotherBubble
                vx = centerX-anotherCX;
                vy = centerY-anotherCY;
            
                //Slowing down the velocities.  otherwise they go crazy
                int randXSpeed = (int)(Math.random()*4 + 1); //you can play with this but make sure you keep the +1
                int randYSpeed =  (int)(Math.random()*4 + 1); //you can play with this but make sure you keep the +1
            
                if(vx<=- randXSpeed )
                    vx = - randXSpeed ;
                else if(vx>= randXSpeed )
                    vx = randXSpeed ;
           
                if(vy <= - randYSpeed )
                    vy = - randYSpeed ;
                else if(vy >= randYSpeed )
                    vy = randYSpeed;

            }
        }
            
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
        
        //checking if collided
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