import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;
public class TranThaiTea
{
    //instance variables
    private int x,y;
    private int vx, vy;
    private int diam;
    private Color col;
    private ImageIcon[] imgIcons;
    
    //constructors
    public TranThaiTea(int a, int b)
    {
        x = a;
        y = b;
        diam = 30;
        col = Color.ORANGE;
        vx = 2;
        vy = 2;
        imgIcons = new ImageIcon[2]; // 1 2 3 2  1 2 3 2       
        imgIcons[0] = new ImageIcon(TranPlayer.class.getResource("ThaiTea.png"));
        imgIcons[1] = new ImageIcon(TranPlayer.class.getResource("ReverseThaiTea.png"));

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
            Image img = imgIcons[0].getImage(); //this gets the current image
            g2d.drawImage(img, x, y, diam, diam, null);
        }
        else if(vx <= 0)
        {
            Image img = imgIcons[1].getImage(); 
            g2d.drawImage(img, x, y, diam, diam, null);
        }
        
    }
    public void act(int w, int h)
    {
        //get the next x and y coordinates
        int nextX = x + vx;
        int nextY = y + vy;
        
        //if-statements to handle the Bubble bouncing off of the 4 walls
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
                                //ArrayList<Boba>
    public void handleCollision(ArrayList<TranBoba> bobas)
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
        
            //checking if collided
            double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
            if(dist <= rad + anotherRad)
            {
                //they collided
   
                //calculating the velocities
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
    public void handleCollision(TranThaiTea anotherTea)
    {
        //Getting the center 
        int centerX = this.getCenterX();
        int centerY = this.getCenterY();
        
        int anotherCX = anotherTea.getCenterX();
        int anotherCY = anotherTea.getCenterY();
        
        
        //getting the radius 
        int rad = diam/2;
        int anotherRad = anotherTea.getDiam()/2;
        
        //checking if collided
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
        if(dist <= rad + anotherRad)
        {
            //they collided
   
            //calculating the velocities
            vx = centerX-anotherCX;
            vy = centerY-anotherCY;
            
            //Slowing down the velocities.  otherwise they go crazy
            int maxSpeed = 2;
            
            if(vx<=-maxSpeed)
                vx = -maxSpeed;
            else if(vx>=maxSpeed)
                vx = maxSpeed;
            
            if(vy <= -maxSpeed)
                vy = -maxSpeed;
            else if(vy >= maxSpeed)
                vy = maxSpeed;

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
        
        //checking if this thaiTea collided with the player
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
        if(dist <= rad + anotherRad)
        {
            return true;    
        }
        else
            return false;
    }

}