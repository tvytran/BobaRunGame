import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
public class TranPlayer
{
    private int x,y;
    private int vx, vy;
    private int diam;
    private Color col;
    private int points;
    
    //vairiables to help us animate our player
    private ImageIcon[] imgIcons;
    private int imageTimer, imageIndex;
    //private ImageIcon imgI;
    
    
    private String facingDirection;  //This new String will keep track of which direction the player is facing
                           //this will help with 2 things
                           //1 which way to shoot the bobas
                           //2 how to draw the player.  (if you decide to get images)
    
    public TranPlayer(int a, int b, Color c)
    {
        x = a;
        y = b;
        vx = 0;
        vy = 0;
        col = c;
        diam = 45;
        points = 0;//stars at 0
        //imgI = new ImageIcon(TranPlayer.class.getResource("rightGoomba1.png"));
        
        imgIcons = new ImageIcon[5]; // 1 2 3 2  1 2 3 2       
        imgIcons[0] = new ImageIcon(TranPlayer.class.getResource("bobaUp.png"));
        imgIcons[1] = new ImageIcon(TranPlayer.class.getResource("bobaDown.png"));
        imgIcons[2] = new ImageIcon(TranPlayer.class.getResource("bobaRight.png"));
        imgIcons[3] = new ImageIcon(TranPlayer.class.getResource("bobaLeft.png"));
        imgIcons[4] = new ImageIcon(TranPlayer.class.getResource("bobaForward.png"));
        
        imageTimer = 0;
        imageIndex = 0;
        
        facingDirection = "up"; //the only values we will give this are   up, down, left, or right
    }
    
    public String toString()
    {
        String output;
        output = "The player is at (" + x + ", " + y + "). The speed is (" + vx + ", " + vy + "). The dir is " + facingDirection + " points = " + points;
        return output;
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
    public int getVX()
    {
        return vx;
    }
    public int getVY()
    {
        return vy;
    }
    public int getDiam()
    {
        return diam;
    }
    public int getCenterX()
    {
        return x + diam/2;
    }
    public int getCenterY()
    {
        return y + diam/2;
    }
    public int getPoints()
    {
        return points;
    }
    
    //mutator methods
    public void setX(int a)
    {
        x = a;
    }
    public void setY(int b)
    {
        y = b;
    }
    public void setVX(int v)  
    {
        vx = v;
        
        if(vx > 0)            //updating which way the user is facing
            facingDirection = "right";
        else if(vx < 0)
            facingDirection = "left";
    }
    public void setVY(int v)
    {
        vy = v;
        if(vy > 0)            //updating which way the user is facing
            facingDirection = "down";
        else if(vy < 0)
            facingDirection = "up";
    }
    public void setPoints(int p)
    {
        points = p;
    }
    
    //interesting methods
    private double distance(int x1, int y1, int x2, int y2)
    {
        double results;
        results = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
        return results;
    }
    
    public void move(ArrayList<TranBoba> bobas, int w, int h)//added this method so that it can collide correctly with ALL bobas!
    {
        
        boolean collided = false;
        for(int i = 0; i < bobas.size(); i++)
        {
            if(bobas.get(i).handleCollision(this) == true)
            {
                collided = true;
            }
        }
        
        int nextX = x + vx;
        int nextY = y + vy;
        
        if(nextX + diam >= w)
            vx=0;
        else if(nextY + diam >= h)
            vy=0;
        else if(nextX < 0)
            vx=0;
        else if(nextY < 0)
            vy=0;
        
        if(!collided)
        {
            x+=vx;
            y+=vy;
        }
        else 
        {
            vx=0;
            vy=0;
        }
    }

    public void drawSelf(Graphics g)
    {
        imageTimer++;
        
        Graphics2D g2d;
        
        g2d = (Graphics2D)g;
        
        if(vx > 0)//the char is moving RIGHT
        {
            /*moving right
            Image img = imgIcons[imageIndex].getImage(); //this gets the current image
            g2d.drawImage(img, x, y, diam, diam, null);


            if(imageTimer%10 == 0)//this 10 represents how fast it will change the image,
            {                       //the bigger the number the slower
                imageIndex++;
                if(imageIndex == imgIcons.length)// if we reach the end
                    imageIndex = 0; //restarts
            }
            */
            Image img = imgIcons[2].getImage();
            g2d.drawImage(img, x, y, diam, diam, null);
            
        }
        else if(vx < 0)
        {
            //moving left, using the  third image oas a place holder for LEFT
            Image img = imgIcons[3].getImage(); //this gets the current image
            g2d.drawImage(img, x, y, diam, diam, null);
        }
       /*else if(vx  == 0)
        {
            //staying still using the first img as a place holder for staying still
            Image img = imgIcons[4].getImage(); //this gets the current image
            g2d.drawImage(img, x, y, diam, diam, null);
        }
        */
        else if(vy <= 0)
        {
            Image img = imgIcons[0].getImage();
            g2d.drawImage(img, x, y, diam, diam, null);
        }
        else if(vy >= 0)
        {
            Image img = imgIcons[1].getImage();
            g2d.drawImage(img, x, y, diam, diam, null);
        }
        
        
        /*
        if(vx < 0)left
        
        else if(vx > 0)right
        
        else if(vy < 0)up
        
        else if(vy > 0)down
        */
        //Image img = imgI.getImage();
        
        //g.setColor(col);
        //g.fillOval(x, y, diam, diam);
        
        //g2d.drawImage(img, x, y, diam, diam, null);
        
        //if you decide to draw images for the user you will have a chain of length 4
        //if(facingDirection.equals("up")
        //{
        //  //draw the up facing image
        //}
        //the other 3 directions are similar.
    }
    
    public void gainStar()
    {
        points+=100;
    }
    public void gainCube()
    {
        points+=100;
    }
    public boolean handleCollision(TranBoba anotherBoba)
    {
         //Getting the center
        int centerX = this.getCenterX();// + vx;
        int centerY = this.getCenterY();// + vy;
        
        int anotherCX = anotherBoba.getCenterX(); //+ anotherBoba.getVX();//notice we are adding the VX and the VY
        int anotherCY = anotherBoba.getCenterY(); //+ anotherBoba.getVY(); 

        //getting the radius
        int rad = diam/2;
        int anotherRad = anotherBoba.getDiam()/2;
        
        //checking if this boba collided with the player
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        if(dist <= rad + anotherRad)
        {
            return true;
        }
        else
            return false;
    }
    
    //removing boba
    public boolean removeBoba(TranBoba anotherBoba) //added this method so that it could remove the boba from a small distance way
    {
         //Getting the center
        int centerX = this.getCenterX() + vx;
        int centerY = this.getCenterY() + vy;
        
        int anotherCX = anotherBoba.getCenterX(); //+ anotherBoba.getVX();//notice we are adding the VX and the VY
        int anotherCY = anotherBoba.getCenterY(); //+ anotherBoba.getVY(); 

        //getting the radius
        int rad = diam/2;       
        int anotherRad = anotherBoba.getDiam()/2;
        
        //checking if this boba collided with the player
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        if(dist <= rad + anotherRad + 10)  //this +10 is losen the method, otherwise it's too tight and won't allow you to take away the boba unless the 2 are touching
        {
            return true;
        }
        else
            return false;
    }
    
    ///shooting method
    public void shoot(ArrayList<TranBoba> bobas, int WIDTH, int  HEIGHT)
    {
        //I am going to help you shoot in 1 direction, but then you code for the other 3 directions
        
        //checking which direction the user is facing
        if(facingDirection.equals("right"))
        {
            boolean keepDroppingBobas = true;
            
            int xBobaPos = x + 30;  //x + 30 because I want it to be placed to my RIGHT, this will change depending on direction
                                     //30 is the current diam of your Bobas.  If you change your boba diams then change this number.
            while(keepDroppingBobas == true)
            {
                //Constructing a boba to place down
                TranBoba placeDown = new TranBoba(xBobaPos, y); //this will change depending on direction

                //since we are placing to the right we need to make sure that we don't make bobas OUT of the screen
                if(placeDown.getX() > WIDTH) //this will change depending on direction
                    keepDroppingBobas = false; //END THE METHOD STOP EVERYTHING!


                //checking if there is already a boba in the location that we want to place a boba.
                boolean itsGood = true;
                for(int i = 0; i < bobas.size(); i++)
                {
                    if(bobas.get(i).handleCollision(placeDown))
                        itsGood = false;
                }

                if(itsGood == true)
                    bobas.add(placeDown);
                else
                    keepDroppingBobas = false;//END THE METHOD DROP EVERYTHING WE HIT A WALL
                
                xBobaPos += placeDown.getDiam(); //this will be the position of the NEXT BOBA!  This wil change depending on direction
                
            }
        }
        else if(facingDirection.equals("left"))
        {
            boolean keepDroppingBobas = true;
            
            int xBobaPos = x;
            
            while(keepDroppingBobas == true)
            {
                TranBoba placeDown = new TranBoba(xBobaPos,y);
                
                if(placeDown.getX() < 0)
                    keepDroppingBobas = false;
                
                boolean itsGood = true;
                for(int i = 0; i <bobas.size(); i++)
                {
                    if(bobas.get(i).handleCollision(placeDown))
                        itsGood = false;
                }
                
                if(itsGood == true)
                    bobas.add(placeDown);
                else
                    keepDroppingBobas = false;
                
                xBobaPos -= placeDown.getDiam();
            }
        }
        else if(facingDirection.equals("up"))
        {
            boolean keepDroppingBobas = true;
            
            int yBobaPos = y;
            
            while(keepDroppingBobas == true)
            {
                TranBoba placeDown = new TranBoba(x, yBobaPos);
                
                if(placeDown.getY() < 0)
                    keepDroppingBobas = false;
                
                boolean itsGood = true;
                for(int i =0; i < bobas.size(); i++)
                {
                    if(bobas.get(i).handleCollision(placeDown))
                        itsGood = false;
                }
                
                if(itsGood == true)
                    bobas.add(placeDown);
                else
                    keepDroppingBobas = false;
                
                yBobaPos -=placeDown.getDiam();
                
            }
        }
        else if(facingDirection.equals("down"))
        {
            boolean keepDroppingBobas = true;
            
            int yBobaPos = y + 30;
            
            while(keepDroppingBobas == true)
            {
                TranBoba placeDown = new TranBoba(x, yBobaPos);
                
                if(placeDown.getY() > HEIGHT )
                    keepDroppingBobas = false;
                
                boolean itsGood = true;
                for(int i =0; i < bobas.size(); i++)
                {
                    if(bobas.get(i).handleCollision(placeDown))
                        itsGood = false;
                }
                
                if(itsGood == true)
                    bobas.add(placeDown);
                else
                    keepDroppingBobas = false;
                
                yBobaPos += placeDown.getDiam();
            }
        }
    }
    
    public boolean handleCollision(TranThaiTea thaiTea)
    {
        //Getting the center
        int centerX = this.getCenterX();
        int centerY = this.getCenterY();
        
        int anotherCX = thaiTea.getCenterX() + thaiTea.getVX();//notice we are adding the VX and the VY
        int anotherCY = thaiTea.getCenterY() + thaiTea.getVY(); 

        //getting the radius
        int rad = diam/2;
        int anotherRad = thaiTea.getDiam()/2;
        
        //checking if this player collided with the thaitea
        double dist = distance(centerX, centerY, anotherCX, anotherCY);
        
        if(dist <= rad + anotherRad)
        {
            return true;
        }
        else
            return false;
    }
    
    
    
    
    
    
}