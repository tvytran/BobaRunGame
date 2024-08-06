import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.applet.*;


public class TranProj8b extends JComponent implements KeyListener, MouseListener, MouseMotionListener
{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    private TranPlayer player;
    private TranPlayer secondPlayer;
    private TranPlayer thirdPlayer;
    private TranPlayer fourthPlayer;
    private TranPlayer fifthPlayer;
    private TranStar[] moreStars;
    private TranStar[] secondStars;
    private TranStar[] thirdStars;
    private TranStar[] fourthStars;
    private TranStar[] fifthStars;
    private TranJellyCube[] cubes;
    private TranJellyCube[] thirdCubes;
    private TranStringJelly[] stringJellies;
    private TranStringJelly[] fourthStringJellies;
    private TranStringJelly[] fifthStringJellies;
    private ArrayList<TranBoba> bobas;
    private ArrayList<TranBoba> secondBobas;
    private ArrayList<TranBoba> thirdBobas;
    private ArrayList<TranBoba> fourthBobas;
    private ArrayList<TranBoba> fifthBobas;
    private TranThaiTea[] thaiTea;
    private TranThaiTea[] fifthThaiTea;
    private TranJasmineTea jasmineTea;
    private TranMatchaTea matchaTea;
    private TranMatchaTea[] fifthMatchaTea;
    private TranOolongTea oolongTea;
    private TranOolongTea fifthOolongTea;
    private ImageIcon[] background;
    private AudioClip audio;
    private boolean gameOver;
    private int level;
    
    
    //Default Constructor
    public TranProj8b()
    {
        //initializing instance variables
        WIDTH = 1000;
        HEIGHT = 500;
        
        //level 
        level = 0;
        
        
        //boba
        background = new ImageIcon[8];
        background[0] =  new ImageIcon(TranProj8b.class.getResource("ThaiTea.png"));
        background[1] = new ImageIcon(TranProj8b.class.getResource("JasmineTea.png"));
        background[2] = new ImageIcon(TranProj8b.class.getResource("MatchaTea.png"));
        background[3] = new ImageIcon(TranProj8b.class.getResource("OolongTea.png"));
        background[4] = new ImageIcon(TranProj8b.class.getResource("JellyCube.png"));
        background[5]= new ImageIcon(TranProj8b.class.getResource("Directions.png"));
        background[6] = new ImageIcon(TranProj8b.class.getResource("gameOver.png"));
        background[7] = new ImageIcon(TranProj8b.class.getResource("win.png"));
        
        //the player
        player = new TranPlayer(90, 275, Color.CYAN);
        secondPlayer = new TranPlayer(90, 100, Color.CYAN);
        thirdPlayer = new TranPlayer(90, 90, Color.CYAN);
        fourthPlayer = new TranPlayer(90, 90, Color.CYAN);
        fifthPlayer = new TranPlayer(80,80, Color.CYAN);

        //jelly cube
        cubes = new TranJellyCube[12];
        cubes[0] = new TranJellyCube(425, 165);
        cubes[1] = new TranJellyCube(380, 165);
        cubes[2] = new TranJellyCube(335, 165);
        cubes[3] = new TranJellyCube(30, 70);
        cubes[4] = new TranJellyCube(75, 70);
        cubes[5] = new TranJellyCube(120, 70);
        cubes[6] = new TranJellyCube(550, 255);
        cubes[7] = new TranJellyCube(595, 255);
        cubes[8] = new TranJellyCube(640, 255);
        cubes[9] = new TranJellyCube(900, 400);
        cubes[10] = new TranJellyCube(855, 400);
        cubes[11] = new TranJellyCube(810, 400);
        
        thirdCubes = new TranJellyCube[16];
        thirdCubes[0] = new TranJellyCube(100, 450);
        thirdCubes[1] = new TranJellyCube(150, 450);
        thirdCubes[2] = new TranJellyCube(200, 450);
        thirdCubes[3] = new TranJellyCube(250, 450);
        thirdCubes[4] = new TranJellyCube(300, 450);
        thirdCubes[5] = new TranJellyCube(350, 450);
        thirdCubes[6] = new TranJellyCube(400, 450);
        thirdCubes[7] = new TranJellyCube(450, 450);//
        thirdCubes[8] = new TranJellyCube(500, 0);
        thirdCubes[9] = new TranJellyCube(550, 0);
        thirdCubes[10] = new TranJellyCube(600 ,0);
        thirdCubes[11] = new TranJellyCube(650, 0);
        thirdCubes[12] = new TranJellyCube(700, 0);
        thirdCubes[13] = new TranJellyCube(750, 0);
        thirdCubes[14] = new TranJellyCube(800, 0);
        thirdCubes[15] = new TranJellyCube(850, 0);
        
        
        
        //the stars
        moreStars = new TranStar[20];
        moreStars[0] = new TranStar(150,100);
        moreStars[1] = new TranStar(200,100);
        moreStars[2] = new TranStar(250,100);
        moreStars[3] = new TranStar(150, 160);
        moreStars[4] = new TranStar(200, 160);
        moreStars[5] = new TranStar(250, 160);
        moreStars[6] = new TranStar(450, 250);
        moreStars[7] = new TranStar(450, 200);
        moreStars[8] = new TranStar(450, 300);
        moreStars[9] = new TranStar(740, 20);
        moreStars[10] = new TranStar(790, 20);
        moreStars[11] = new TranStar(840, 20);
        moreStars[12] = new TranStar(890, 20);
        moreStars[13] = new TranStar(800, 395);
        moreStars[14] = new TranStar(850, 395);
        moreStars[15] = new TranStar(150, 395);
        moreStars[16] = new TranStar(200, 395);
        moreStars[17] = new TranStar(525, 250);
        moreStars[18] = new TranStar(525, 200);
        moreStars[19] = new TranStar(525, 300);
        
        secondStars = new TranStar[43];
        secondStars[0] = new TranStar(865, 150);
        secondStars[1] = new TranStar(805, 150);
        secondStars[2] = new TranStar(745, 150);
        secondStars[3] = new TranStar(685, 150);
        secondStars[4] = new TranStar(625, 150);
        secondStars[5] = new TranStar(565, 150);
        secondStars[6] = new TranStar(925, 150);
        secondStars[7] = new TranStar(835, 90);
        secondStars[8] = new TranStar(895, 90);
        secondStars[9] = new TranStar(775, 90);
        secondStars[10] = new TranStar(715, 90);
        secondStars[11] = new TranStar(655, 90);
        secondStars[12] = new TranStar(595, 90);
        secondStars[13] = new TranStar(925, 30);
        secondStars[14] = new TranStar(865, 30);
        secondStars[15] = new TranStar(805, 30);
        secondStars[16] = new TranStar(745, 30);
        secondStars[17] = new TranStar(685, 30);
        secondStars[18] = new TranStar(625, 30);
        secondStars[19] = new TranStar(565, 30);
        secondStars[20] = new TranStar(25, 270);
        secondStars[21] = new TranStar(85, 270);
        secondStars[22] = new TranStar(145, 270);
        secondStars[23] = new TranStar(205, 270);
        secondStars[24] = new TranStar(265, 270);
        secondStars[25] = new TranStar(325, 270);
        secondStars[26] = new TranStar(385, 270);
        secondStars[27] = new TranStar(445, 270);
        secondStars[28] = new TranStar(55, 330);
        secondStars[29] = new TranStar(115, 330);
        secondStars[30] = new TranStar(175, 330);
        secondStars[31] = new TranStar(235, 330);
        secondStars[32] = new TranStar(295, 330);
        secondStars[33] =  new TranStar(355, 330);
        secondStars[34] = new TranStar(415, 330);
        secondStars[35] = new TranStar(25, 390);
        secondStars[36] = new TranStar(85, 390);
        secondStars[37] = new TranStar(145,390);
        secondStars[38] = new TranStar(205, 390);
        secondStars[39] = new TranStar(265, 390);
        secondStars[40] = new TranStar(325, 390);
        secondStars[41] = new TranStar(385, 390);
        secondStars[42] = new TranStar(445, 390);
        
        thirdStars = new TranStar[12];
        thirdStars[0] = new TranStar(300, 155);
        thirdStars[1] = new TranStar(300, 275);
        thirdStars[2] = new TranStar(300, 215);
        thirdStars[3] = new TranStar(373, 155);
        thirdStars[4] = new TranStar(373, 275);
        thirdStars[5] = new TranStar(373, 215);
        thirdStars[6] = new TranStar(633, 155);
        thirdStars[7] = new TranStar(633, 275);
        thirdStars[8] = new TranStar(633, 215);
        thirdStars[9] = new TranStar(709, 155);
        thirdStars[10] = new TranStar(709, 275);
        thirdStars[11] = new TranStar(709, 215);
        
        fourthStars = new TranStar[6];
        fourthStars[0] = new TranStar(255, 85);
        fourthStars[1] = new TranStar(505, 85);
        fourthStars[2] = new TranStar(755, 85);
        fourthStars[3] = new TranStar(255, 300);
        fourthStars[4] = new TranStar(505, 300);
        fourthStars[5] = new TranStar(755, 300);
        
        fifthStars = new TranStar[74];
        fifthStars[0] = new TranStar(240, 55);
        fifthStars[1] = new TranStar(240, 85);
        fifthStars[2] = new TranStar(210, 85);
        fifthStars[3] = new TranStar(325, 55);
        fifthStars[4] = new TranStar(325, 85);
        fifthStars[5] = new TranStar(325, 115);
        fifthStars[6] = new TranStar(325, 145);
        fifthStars[7] = new TranStar(325, 175);
        fifthStars[8] = new TranStar(295, 175);
        fifthStars[9] = new TranStar(265, 175);
        fifthStars[10] = new TranStar(235, 175);
        fifthStars[11] = new TranStar(425, 55);
        fifthStars[12] = new TranStar(425, 85);
        fifthStars[13] = new TranStar(425, 115);
        fifthStars[14] = new TranStar(425, 145);
        fifthStars[15] = new TranStar(425, 175);
        fifthStars[16] = new TranStar(425, 205);
        fifthStars[17] = new TranStar(425, 235);
        fifthStars[18] = new TranStar(425, 265);
        fifthStars[19] = new TranStar(395, 265);
        fifthStars[20] = new TranStar(365, 265);
        fifthStars[21] = new TranStar(335, 265);
        fifthStars[22] = new TranStar(305, 265);
        fifthStars[23] = new TranStar(275, 265);
        fifthStars[24] = new TranStar(245, 265);
        fifthStars[25] = new TranStar(535, 55);
        fifthStars[26] = new TranStar(535, 85);
        fifthStars[27] = new TranStar(535, 115);
        fifthStars[28] = new TranStar(535, 145);
        fifthStars[29] = new TranStar(535, 175);
        fifthStars[30] = new TranStar(535, 205);
        fifthStars[31] = new TranStar(535, 235);
        fifthStars[32] = new TranStar(535, 265);
        fifthStars[33] = new TranStar(535, 295);
        fifthStars[34] = new TranStar(535, 325);
        fifthStars[35] = new TranStar(535, 355);
        fifthStars[36] = new TranStar(505, 355);
        fifthStars[37] = new TranStar(475, 355);
        fifthStars[38] = new TranStar(445, 355);
        fifthStars[39] = new TranStar(415, 355);
        fifthStars[40] = new TranStar(385, 355);
        fifthStars[41] = new TranStar(355, 355);
        fifthStars[42] = new TranStar(325, 355);
        fifthStars[43] = new TranStar(295, 355);
        fifthStars[44] = new TranStar(265, 355);
        fifthStars[45] = new TranStar(235, 355);
        fifthStars[46] = new TranStar(655, 55);
        fifthStars[47] = new TranStar(655, 85);
        fifthStars[48] = new TranStar(655, 115);
        fifthStars[49] = new TranStar(655, 145);
        fifthStars[50] = new TranStar(655,175);
        fifthStars[51] = new TranStar(655,205);
        fifthStars[52] = new TranStar(655, 235);
        fifthStars[53] = new TranStar(655, 265);
        fifthStars[54] = new TranStar(655, 295);
        fifthStars[55] = new TranStar(655, 325);
        fifthStars[56] = new TranStar(655, 355);
        fifthStars[57] = new TranStar(655, 385);
        fifthStars[58] = new TranStar(655, 415);
        fifthStars[59] = new TranStar(655, 445);
        fifthStars[60] = new TranStar(625, 445);
        fifthStars[61] = new TranStar(595, 445);
        fifthStars[62] = new TranStar(565, 445);
        fifthStars[63] = new TranStar(535, 445);
        fifthStars[64] = new TranStar(505, 445);
        fifthStars[65] = new TranStar(475, 445);
        fifthStars[66] = new TranStar(445, 445);
        fifthStars[67] = new TranStar(415, 445);
        fifthStars[68] = new TranStar(385, 445);
        fifthStars[69] = new TranStar(355, 445);
        fifthStars[70] = new TranStar(325, 445);
        fifthStars[71] = new TranStar(295, 445);
        fifthStars[72] = new TranStar(265, 445);
        fifthStars[73] = new TranStar(235, 445);
        
        //the string jellies
        stringJellies = new TranStringJelly[16];
        for(int i = 0; i < stringJellies.length;i++)
        {
            int bx = (int)(Math.random()* 950);//50 less than the width
            int by = (int)(Math.random()*450);//50 less than the height
            stringJellies[i] = new TranStringJelly(bx, by);
        }
        fourthStringJellies= new TranStringJelly[20];
        for(int i = 0; i < fourthStringJellies.length;i++)
        {
            int bx = (int)(Math.random()* 950);//50 less than the width
            int by = (int)(Math.random()*450);//50 less than the height
            fourthStringJellies[i] = new TranStringJelly(bx, by);
        }
        fifthStringJellies = new TranStringJelly[30];
        for(int i = 0; i < fifthStringJellies.length;i++)
        {
            int bx = (int)(Math.random()* 950);//50 less than the width
            int by = (int)(Math.random()*450);//50 less than the height
            fifthStringJellies[i] = new TranStringJelly(bx, by);
        }
        //the bobas
        bobas = new ArrayList<TranBoba>();
        bobas.add(new TranBoba(100, 125));
        bobas.add(new TranBoba(150, 125));
        bobas.add(new TranBoba(200, 125));
        bobas.add(new TranBoba(250, 125));
        bobas.add(new TranBoba(300, 125));
        bobas.add(new TranBoba(483, 245));
        bobas.add(new TranBoba(483, 195));
        bobas.add(new TranBoba(483, 295));
        bobas.add(new TranBoba(760, 50));
        bobas.add(new TranBoba(860, 50));
        bobas.add(new TranBoba(900, 390));
        bobas.add(new TranBoba(750, 390));
        
        secondBobas = new ArrayList<TranBoba>();
        secondBobas.add(new TranBoba(WIDTH/2, 0));
        secondBobas.add(new TranBoba(WIDTH/2, 30));
        secondBobas.add(new TranBoba(WIDTH/2, 60));
        secondBobas.add(new TranBoba(WIDTH/2, 90));
        secondBobas.add(new TranBoba(WIDTH/2, 120));
        secondBobas.add(new TranBoba(WIDTH/2, 150));
        secondBobas.add(new TranBoba(WIDTH/2, 180));
        secondBobas.add(new TranBoba(WIDTH/2, 210));//middle
        secondBobas.add(new TranBoba(WIDTH/2, 240));
        secondBobas.add(new TranBoba(WIDTH/2, 270));
        secondBobas.add(new TranBoba(WIDTH/2, 300));
        secondBobas.add(new TranBoba(WIDTH/2, 330));
        secondBobas.add(new TranBoba(WIDTH/2, 360));
        secondBobas.add(new TranBoba(WIDTH/2, 390));
        secondBobas.add(new TranBoba(WIDTH/2, 420));
        secondBobas.add(new TranBoba(WIDTH/2, 450));
        secondBobas.add(new TranBoba(950, 210));
        secondBobas.add(new TranBoba(920, 210));
        secondBobas.add(new TranBoba(890, 210));
        secondBobas.add(new TranBoba(860, 210));
        secondBobas.add(new TranBoba(830, 210));
        secondBobas.add(new TranBoba(800, 210));
        secondBobas.add(new TranBoba(770, 210));
        secondBobas.add(new TranBoba(740, 210));
        secondBobas.add(new TranBoba(710, 210));
        secondBobas.add(new TranBoba(680, 210));
        secondBobas.add(new TranBoba(650, 210));
        secondBobas.add(new TranBoba(620, 210));
        secondBobas.add(new TranBoba(590, 210));
        secondBobas.add(new TranBoba(560, 210));
        secondBobas.add(new TranBoba(530, 210));
        secondBobas.add(new TranBoba(470, 210));
        secondBobas.add(new TranBoba(440, 210));
        secondBobas.add(new TranBoba(410, 210));
        secondBobas.add(new TranBoba(380, 210));
        secondBobas.add(new TranBoba(350, 210));
        secondBobas.add(new TranBoba(320, 210));
        secondBobas.add(new TranBoba(290, 210));
        secondBobas.add(new TranBoba(260, 210));
        secondBobas.add(new TranBoba(230, 210));
        secondBobas.add(new TranBoba(200, 210));
        secondBobas.add(new TranBoba(170, 210));
        secondBobas.add(new TranBoba(140, 210));
        secondBobas.add(new TranBoba(110, 210));
        secondBobas.add(new TranBoba(80, 210));
        secondBobas.add(new TranBoba(50, 210));
        secondBobas.add(new TranBoba(20, 210));
        
        thirdBobas = new ArrayList<TranBoba>();
        thirdBobas.add(new TranBoba(333, 60));
        thirdBobas.add(new TranBoba(333, 90));
        thirdBobas.add(new TranBoba(333, 120));
        thirdBobas.add(new TranBoba(333, 150));
        thirdBobas.add(new TranBoba(333, 180));
        thirdBobas.add(new TranBoba(333, 210));
        thirdBobas.add(new TranBoba(333, 240));
        thirdBobas.add(new TranBoba(333, 270));
        thirdBobas.add(new TranBoba(333, 300));
        thirdBobas.add(new TranBoba(333, 330));
        thirdBobas.add(new TranBoba(333, 360));
        thirdBobas.add(new TranBoba(333, 390));
        thirdBobas.add(new TranBoba(666, 60));
        thirdBobas.add(new TranBoba(666, 90));
        thirdBobas.add(new TranBoba(666, 120));
        thirdBobas.add(new TranBoba(666, 150));
        thirdBobas.add(new TranBoba(666, 180));
        thirdBobas.add(new TranBoba(666, 210));
        thirdBobas.add(new TranBoba(666, 240));
        thirdBobas.add(new TranBoba(666, 270));
        thirdBobas.add(new TranBoba(666, 300));
        thirdBobas.add(new TranBoba(666, 330));
        thirdBobas.add(new TranBoba(666, 360));
        thirdBobas.add(new TranBoba(666, 390));
        
        fourthBobas = new ArrayList<TranBoba>();
        fourthBobas.add(new TranBoba(250, 45));
        fourthBobas.add(new TranBoba(500, 45));
        fourthBobas.add(new TranBoba(750, 45));
        fourthBobas.add(new TranBoba(220, 80));
        fourthBobas.add(new TranBoba(470, 80));
        fourthBobas.add(new TranBoba(720, 80));
        fourthBobas.add(new TranBoba(280, 80));
        fourthBobas.add(new TranBoba(530, 80));
        fourthBobas.add(new TranBoba(780, 80));
        fourthBobas.add(new TranBoba(250, 115));
        fourthBobas.add(new TranBoba(500, 115));
        fourthBobas.add(new TranBoba(750, 115));
        fourthBobas.add(new TranBoba(250, 260));
        fourthBobas.add(new TranBoba(500, 260));
        fourthBobas.add(new TranBoba(750, 260));
        fourthBobas.add(new TranBoba(220, 295));
        fourthBobas.add(new TranBoba(470, 295));
        fourthBobas.add(new TranBoba(720, 295));
        fourthBobas.add(new TranBoba(280, 295));
        fourthBobas.add(new TranBoba(530, 295));
        fourthBobas.add(new TranBoba(780, 295));
        fourthBobas.add(new TranBoba(250, 330));
        fourthBobas.add(new TranBoba(500, 330));
        fourthBobas.add(new TranBoba(750, 330));
        
        fifthBobas = new ArrayList<TranBoba>();
        fifthBobas.add(new TranBoba(270, 50));
        fifthBobas.add(new TranBoba(270, 80));
        fifthBobas.add(new TranBoba(270, 110));
        fifthBobas.add(new TranBoba(240, 110));
        fifthBobas.add(new TranBoba(210, 110));
        fifthBobas.add(new TranBoba(370, 50));
        fifthBobas.add(new TranBoba(370, 80));
        fifthBobas.add(new TranBoba(370, 110));
        fifthBobas.add(new TranBoba(370, 140));
        fifthBobas.add(new TranBoba(370, 170));
        fifthBobas.add(new TranBoba(370, 200));
        fifthBobas.add(new TranBoba(340, 200));
        fifthBobas.add(new TranBoba(310, 200));
        fifthBobas.add(new TranBoba(280, 200));
        fifthBobas.add(new TranBoba(250, 200));
        fifthBobas.add(new TranBoba(220, 200));
        fifthBobas.add(new TranBoba(470, 50));
        fifthBobas.add(new TranBoba(470, 80));
        fifthBobas.add(new TranBoba(470, 110));
        fifthBobas.add(new TranBoba(470, 140));
        fifthBobas.add(new TranBoba(470, 170));
        fifthBobas.add(new TranBoba(470, 200));
        fifthBobas.add(new TranBoba(470, 230));
        fifthBobas.add(new TranBoba(470, 260));
        fifthBobas.add(new TranBoba(470, 290));
        fifthBobas.add(new TranBoba(440, 290));
        fifthBobas.add(new TranBoba(410, 290));
        fifthBobas.add(new TranBoba(380, 290));
        fifthBobas.add(new TranBoba(350, 290));
        fifthBobas.add(new TranBoba(320, 290));
        fifthBobas.add(new TranBoba(290,290));
        fifthBobas.add(new TranBoba(260, 290));
        fifthBobas.add(new TranBoba(230, 290));
        fifthBobas.add(new TranBoba(590,50));
        fifthBobas.add(new TranBoba(590, 80));
        fifthBobas.add(new TranBoba(590, 110));
        fifthBobas.add(new TranBoba(590, 140));
        fifthBobas.add(new TranBoba(590, 170));
        fifthBobas.add(new TranBoba(590, 200));
        fifthBobas.add(new TranBoba(590, 230));
        fifthBobas.add(new TranBoba(590, 260));
        fifthBobas.add(new TranBoba(590, 290));
        fifthBobas.add(new TranBoba(590, 320));
        fifthBobas.add(new TranBoba(590, 350));
        fifthBobas.add(new TranBoba(590, 380));
        fifthBobas.add(new TranBoba(560, 380));
        fifthBobas.add(new TranBoba(530, 380));
        fifthBobas.add(new TranBoba(500, 380));
        fifthBobas.add(new TranBoba(470, 380));
        fifthBobas.add(new TranBoba(440, 380));
        fifthBobas.add(new TranBoba(410, 380));
        fifthBobas.add(new TranBoba(380, 380));
        fifthBobas.add(new TranBoba(350, 380));
        fifthBobas.add(new TranBoba(320, 380));
        fifthBobas.add(new TranBoba(290, 380));
        fifthBobas.add(new TranBoba(260, 380));
        fifthBobas.add(new TranBoba(230, 380));
        fifthBobas.add(new TranBoba(710, 50));
        fifthBobas.add(new TranBoba(710, 80));
        fifthBobas.add(new TranBoba(710, 110));
        fifthBobas.add(new TranBoba(710, 140));
        fifthBobas.add(new TranBoba(710, 170));
        fifthBobas.add(new TranBoba(710, 200));
        fifthBobas.add(new TranBoba(710, 230));
        fifthBobas.add(new TranBoba(710, 260));
        fifthBobas.add(new TranBoba(710, 290));
        fifthBobas.add(new TranBoba(710, 320));
        fifthBobas.add(new TranBoba(710, 350));
        fifthBobas.add(new TranBoba(710, 380));
        fifthBobas.add(new TranBoba(710, 410));
        fifthBobas.add(new TranBoba(710, 440));
        fifthBobas.add(new TranBoba(710, 470));
        fifthBobas.add(new TranBoba(680, 470));
        fifthBobas.add(new TranBoba(650, 470));
        fifthBobas.add(new TranBoba(620, 470));
        fifthBobas.add(new TranBoba(590, 470));
        fifthBobas.add(new TranBoba(560, 470));
        fifthBobas.add(new TranBoba(530, 470));
        fifthBobas.add(new TranBoba(500, 470));
        fifthBobas.add(new TranBoba(470, 470));
        fifthBobas.add(new TranBoba(440, 470));
        fifthBobas.add(new TranBoba(410, 470));
        fifthBobas.add(new TranBoba(380, 470));
        fifthBobas.add(new TranBoba(350, 470));
        fifthBobas.add(new TranBoba(320, 470));
        fifthBobas.add(new TranBoba(290, 470));
        fifthBobas.add(new TranBoba(260, 470));
        fifthBobas.add(new TranBoba(230, 470));
        
        
        //the thaiTea
        thaiTea = new TranThaiTea[2];
        thaiTea[0] = new TranThaiTea(800, 275);
        thaiTea[1] = new TranThaiTea(WIDTH/2,400);
        
        fifthThaiTea = new TranThaiTea[1];
        fifthThaiTea[0] = new TranThaiTea(430, 100);
        //fifthThaiTea[1] = new TranThaiTea(500, 200);
        //fifthThaiTea[2] = new TranThaiTea(350, 350);
        //fifthThaiTea[3] = new TranThaiTea(200, 400);
        //fifthThaiTea[4] = new TranThaiTea(100, 500);

        //jasemine tea
        jasmineTea = new TranJasmineTea(920, 0);
        
        //matcha tea
        matchaTea = new TranMatchaTea(900,100);
        fifthMatchaTea = new TranMatchaTea[1];
        fifthMatchaTea[0] = new TranMatchaTea(900, 100);
        
        
        //oolong tea
        oolongTea = new TranOolongTea(900, 100);
        
        //audio
        audio = Applet.newAudioClip(this.getClass().getResource("pink.wav"));
        audio.loop();
        
        //gameover 
        gameOver = false;
        
        
        //Setting up the GUI
        JFrame gui = new JFrame(); 
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        gui.setTitle("Boing Boing Boba"); 
        gui.setPreferredSize(new Dimension(WIDTH + 5, HEIGHT + 30)); 
        gui.setResizable(false); 
        gui.getContentPane().add(this); 

         /*If after you finish everything, you can declare your buttons or other things
          *at this spot. AFTER gui.getContentPane().add(this) and BEFORE gui.pack();
         */

        gui.pack(); 
        gui.setLocationRelativeTo(null); 
        gui.setVisible(true); 
        gui.addKeyListener(this);
        gui.addMouseListener(this); 
        gui.addMouseMotionListener(this); 

    }
    //This method will acknowledge user input   
    public void keyPressed(KeyEvent e) 
    {
        //getting the key pressed
        int key = e.getKeyCode();
        System.out.println(key);
        if(key == 38 || key == 87) 
        {
            player.setVY(-5);
            secondPlayer.setVY(-5);
            thirdPlayer.setVY(-5);
            fourthPlayer.setVY(-5);
            fifthPlayer.setVY(-5);
        }
        if(key == 40 || key == 83)
        {
            player.setVY(5);
            secondPlayer.setVY(5);
            thirdPlayer.setVY(5);
            fourthPlayer.setVY(5);
            fifthPlayer.setVY(5);
        }
        if(key == 39 || key == 68)
        {
            player.setVX(5);
            secondPlayer.setVX(5);
            thirdPlayer.setVX(5);
            fourthPlayer.setVX(5);
            fifthPlayer.setVX(5);
        }
        if(key == 37 || key == 65)
        {
            player.setVX(-5);
            secondPlayer.setVX(-5);
            thirdPlayer.setVX(-5);
            fourthPlayer.setVX(-5);
            fifthPlayer.setVX(-5);
        }
        if(key == 66 && level == 0)
            level = 1;
        if(key == 69) //E
        {
            //System.out.println("TAKE AWAY");
            for(int i = bobas.size() - 1; i >= 0; i-- )
            {
                boolean collide = player.removeBoba(bobas.get(i));
                if(collide == true)
                    bobas.remove(i);
            }
            for(int i = secondBobas.size() - 1; i >= 0; i--)
            {
                boolean collide = secondPlayer.removeBoba(secondBobas.get(i));
                if(collide == true)
                    secondBobas.remove(i);
            }
            for(int i = thirdBobas.size() -1; i >= 0; i--)
            {
                boolean collide = thirdPlayer.removeBoba(thirdBobas.get(i));
                if(collide == true)
                    thirdBobas.remove(i);
            }
            for(int i = fourthBobas.size() -1; i>= 0; i--)
            {
                boolean collide = fourthPlayer.removeBoba(fourthBobas.get(i));
                if(collide == true)
                    fourthBobas.remove(i);
            }
            for(int i = fifthBobas.size() -1; i>= 0; i--)
            {
                boolean collide = fifthPlayer.removeBoba(fifthBobas.get(i));
                if(collide == true)
                    fifthBobas.remove(i);
            }
        }
        if(key == 70) //F to shoot
        {
            if(level == 1)
                player.shoot(bobas, WIDTH, HEIGHT);
            
            if(level == 2)
               secondPlayer.shoot(secondBobas,WIDTH, HEIGHT);
            if(level == 3)
                thirdPlayer.shoot(thirdBobas, WIDTH, HEIGHT);
            if(level == 4)
                fourthPlayer.shoot(fourthBobas, WIDTH, HEIGHT);
            if(level == 5)
                fifthPlayer.shoot(fifthBobas,WIDTH, HEIGHT);
        }
        if(key == 82 && gameOver == true || key == 82 && level == 6)//restart
        {
            WIDTH = 1000;
            HEIGHT = 500;

            //level 
            level = 1;


            //boba
            background = new ImageIcon[8];
            background[0] =  new ImageIcon(TranProj8b.class.getResource("ThaiTea.png"));
            background[1] = new ImageIcon(TranProj8b.class.getResource("JasmineTea.png"));
            background[2] = new ImageIcon(TranProj8b.class.getResource("MatchaTea.png"));
            background[3] = new ImageIcon(TranProj8b.class.getResource("OolongTea.png"));
            background[4] = new ImageIcon(TranProj8b.class.getResource("Star.png"));
            background[5]= new ImageIcon(TranProj8b.class.getResource("Directions.png"));
            background[6] = new ImageIcon(TranProj8b.class.getResource("gameOver.png"));
            background[7] = new ImageIcon(TranProj8b.class.getResource("win.png"));

            //the player
            player = new TranPlayer(90, 275, Color.CYAN);
            secondPlayer = new TranPlayer(90, 100, Color.CYAN);
            thirdPlayer = new TranPlayer(90, 90, Color.CYAN);
            fourthPlayer = new TranPlayer(90, 90, Color.CYAN);
            fifthPlayer = new TranPlayer(80,80, Color.CYAN);

            //jelly cube
            cubes = new TranJellyCube[12];
            cubes[0] = new TranJellyCube(425, 165);
            cubes[1] = new TranJellyCube(380, 165);
            cubes[2] = new TranJellyCube(335, 165);
            cubes[3] = new TranJellyCube(30, 70);
            cubes[4] = new TranJellyCube(75, 70);
            cubes[5] = new TranJellyCube(120, 70);
            cubes[6] = new TranJellyCube(550, 255);
            cubes[7] = new TranJellyCube(595, 255);
            cubes[8] = new TranJellyCube(640, 255);
            cubes[9] = new TranJellyCube(900, 400);
            cubes[10] = new TranJellyCube(855, 400);
            cubes[11] = new TranJellyCube(810, 400);

            thirdCubes = new TranJellyCube[16];
            thirdCubes[0] = new TranJellyCube(100, 450);
            thirdCubes[1] = new TranJellyCube(150, 450);
            thirdCubes[2] = new TranJellyCube(200, 450);
            thirdCubes[3] = new TranJellyCube(250, 450);
            thirdCubes[4] = new TranJellyCube(300, 450);
            thirdCubes[5] = new TranJellyCube(350, 450);
            thirdCubes[6] = new TranJellyCube(400, 450);
            thirdCubes[7] = new TranJellyCube(450, 450);//
            thirdCubes[8] = new TranJellyCube(500, 0);
            thirdCubes[9] = new TranJellyCube(550, 0);
            thirdCubes[10] = new TranJellyCube(600 ,0);
            thirdCubes[11] = new TranJellyCube(650, 0);
            thirdCubes[12] = new TranJellyCube(700, 0);
            thirdCubes[13] = new TranJellyCube(750, 0);
            thirdCubes[14] = new TranJellyCube(800, 0);
            thirdCubes[15] = new TranJellyCube(850, 0);



            //the stars
            moreStars = new TranStar[20];
            moreStars[0] = new TranStar(150,100);
            moreStars[1] = new TranStar(200,100);
            moreStars[2] = new TranStar(250,100);
            moreStars[3] = new TranStar(150, 160);
            moreStars[4] = new TranStar(200, 160);
            moreStars[5] = new TranStar(250, 160);
            moreStars[6] = new TranStar(450, 250);
            moreStars[7] = new TranStar(450, 200);
            moreStars[8] = new TranStar(450, 300);
            moreStars[9] = new TranStar(740, 20);
            moreStars[10] = new TranStar(790, 20);
            moreStars[11] = new TranStar(840, 20);
            moreStars[12] = new TranStar(890, 20);
            moreStars[13] = new TranStar(800, 395);
            moreStars[14] = new TranStar(850, 395);
            moreStars[15] = new TranStar(150, 395);
            moreStars[16] = new TranStar(200, 395);
            moreStars[17] = new TranStar(525, 250);
            moreStars[18] = new TranStar(525, 200);
            moreStars[19] = new TranStar(525, 300);

            secondStars = new TranStar[43];
            secondStars[0] = new TranStar(865, 150);
            secondStars[1] = new TranStar(805, 150);
            secondStars[2] = new TranStar(745, 150);
            secondStars[3] = new TranStar(685, 150);
            secondStars[4] = new TranStar(625, 150);
            secondStars[5] = new TranStar(565, 150);
            secondStars[6] = new TranStar(925, 150);
            secondStars[7] = new TranStar(835, 90);
            secondStars[8] = new TranStar(895, 90);
            secondStars[9] = new TranStar(775, 90);
            secondStars[10] = new TranStar(715, 90);
            secondStars[11] = new TranStar(655, 90);
            secondStars[12] = new TranStar(595, 90);
            secondStars[13] = new TranStar(925, 30);
            secondStars[14] = new TranStar(865, 30);
            secondStars[15] = new TranStar(805, 30);
            secondStars[16] = new TranStar(745, 30);
            secondStars[17] = new TranStar(685, 30);
            secondStars[18] = new TranStar(625, 30);
            secondStars[19] = new TranStar(565, 30);
            secondStars[20] = new TranStar(25, 270);
            secondStars[21] = new TranStar(85, 270);
            secondStars[22] = new TranStar(145, 270);
            secondStars[23] = new TranStar(205, 270);
            secondStars[24] = new TranStar(265, 270);
            secondStars[25] = new TranStar(325, 270);
            secondStars[26] = new TranStar(385, 270);
            secondStars[27] = new TranStar(445, 270);
            secondStars[28] = new TranStar(55, 330);
            secondStars[29] = new TranStar(115, 330);
            secondStars[30] = new TranStar(175, 330);
            secondStars[31] = new TranStar(235, 330);
            secondStars[32] = new TranStar(295, 330);
            secondStars[33] =  new TranStar(355, 330);
            secondStars[34] = new TranStar(415, 330);
            secondStars[35] = new TranStar(25, 390);
            secondStars[36] = new TranStar(85, 390);
            secondStars[37] = new TranStar(145,390);
            secondStars[38] = new TranStar(205, 390);
            secondStars[39] = new TranStar(265, 390);
            secondStars[40] = new TranStar(325, 390);
            secondStars[41] = new TranStar(385, 390);
            secondStars[42] = new TranStar(445, 390);

            thirdStars = new TranStar[12];
            thirdStars[0] = new TranStar(300, 155);
            thirdStars[1] = new TranStar(300, 275);
            thirdStars[2] = new TranStar(300, 215);
            thirdStars[3] = new TranStar(373, 155);
            thirdStars[4] = new TranStar(373, 275);
            thirdStars[5] = new TranStar(373, 215);
            thirdStars[6] = new TranStar(633, 155);
            thirdStars[7] = new TranStar(633, 275);
            thirdStars[8] = new TranStar(633, 215);
            thirdStars[9] = new TranStar(709, 155);
            thirdStars[10] = new TranStar(709, 275);
            thirdStars[11] = new TranStar(709, 215);

            fourthStars = new TranStar[6];
            fourthStars[0] = new TranStar(255, 85);
            fourthStars[1] = new TranStar(505, 85);
            fourthStars[2] = new TranStar(755, 85);
            fourthStars[3] = new TranStar(255, 300);
            fourthStars[4] = new TranStar(505, 300);
            fourthStars[5] = new TranStar(755, 300);

            fifthStars = new TranStar[74];
            fifthStars[0] = new TranStar(240, 55);
            fifthStars[1] = new TranStar(240, 85);
            fifthStars[2] = new TranStar(210, 85);
            fifthStars[3] = new TranStar(325, 55);
            fifthStars[4] = new TranStar(325, 85);
            fifthStars[5] = new TranStar(325, 115);
            fifthStars[6] = new TranStar(325, 145);
            fifthStars[7] = new TranStar(325, 175);
            fifthStars[8] = new TranStar(295, 175);
            fifthStars[9] = new TranStar(265, 175);
            fifthStars[10] = new TranStar(235, 175);
            fifthStars[11] = new TranStar(425, 55);
            fifthStars[12] = new TranStar(425, 85);
            fifthStars[13] = new TranStar(425, 115);
            fifthStars[14] = new TranStar(425, 145);
            fifthStars[15] = new TranStar(425, 175);
            fifthStars[16] = new TranStar(425, 205);
            fifthStars[17] = new TranStar(425, 235);
            fifthStars[18] = new TranStar(425, 265);
            fifthStars[19] = new TranStar(395, 265);
            fifthStars[20] = new TranStar(365, 265);
            fifthStars[21] = new TranStar(335, 265);
            fifthStars[22] = new TranStar(305, 265);
            fifthStars[23] = new TranStar(275, 265);
            fifthStars[24] = new TranStar(245, 265);
            fifthStars[25] = new TranStar(535, 55);
            fifthStars[26] = new TranStar(535, 85);
            fifthStars[27] = new TranStar(535, 115);
            fifthStars[28] = new TranStar(535, 145);
            fifthStars[29] = new TranStar(535, 175);
            fifthStars[30] = new TranStar(535, 205);
            fifthStars[31] = new TranStar(535, 235);
            fifthStars[32] = new TranStar(535, 265);
            fifthStars[33] = new TranStar(535, 295);
            fifthStars[34] = new TranStar(535, 325);
            fifthStars[35] = new TranStar(535, 355);
            fifthStars[36] = new TranStar(505, 355);
            fifthStars[37] = new TranStar(475, 355);
            fifthStars[38] = new TranStar(445, 355);
            fifthStars[39] = new TranStar(415, 355);
            fifthStars[40] = new TranStar(385, 355);
            fifthStars[41] = new TranStar(355, 355);
            fifthStars[42] = new TranStar(325, 355);
            fifthStars[43] = new TranStar(295, 355);
            fifthStars[44] = new TranStar(265, 355);
            fifthStars[45] = new TranStar(235, 355);
            fifthStars[46] = new TranStar(655, 55);
            fifthStars[47] = new TranStar(655, 85);
            fifthStars[48] = new TranStar(655, 115);
            fifthStars[49] = new TranStar(655, 145);
            fifthStars[50] = new TranStar(655,175);
            fifthStars[51] = new TranStar(655,205);
            fifthStars[52] = new TranStar(655, 235);
            fifthStars[53] = new TranStar(655, 265);
            fifthStars[54] = new TranStar(655, 295);
            fifthStars[55] = new TranStar(655, 325);
            fifthStars[56] = new TranStar(655, 355);
            fifthStars[57] = new TranStar(655, 385);
            fifthStars[58] = new TranStar(655, 415);
            fifthStars[59] = new TranStar(655, 445);
            fifthStars[60] = new TranStar(625, 445);
            fifthStars[61] = new TranStar(595, 445);
            fifthStars[62] = new TranStar(565, 445);
            fifthStars[63] = new TranStar(535, 445);
            fifthStars[64] = new TranStar(505, 445);
            fifthStars[65] = new TranStar(475, 445);
            fifthStars[66] = new TranStar(445, 445);
            fifthStars[67] = new TranStar(415, 445);
            fifthStars[68] = new TranStar(385, 445);
            fifthStars[69] = new TranStar(355, 445);
            fifthStars[70] = new TranStar(325, 445);
            fifthStars[71] = new TranStar(295, 445);
            fifthStars[72] = new TranStar(265, 445);
            fifthStars[73] = new TranStar(235, 445);













            //the string jellies
            stringJellies = new TranStringJelly[16];
            for(int i = 0; i < stringJellies.length;i++)
            {
                int bx = (int)(Math.random()* 950);//50 less than the width
                int by = (int)(Math.random()*450);//50 less than the height
                stringJellies[i] = new TranStringJelly(bx, by);
            }
            fourthStringJellies= new TranStringJelly[20];
            for(int i = 0; i < fourthStringJellies.length;i++)
            {
                int bx = (int)(Math.random()* 950);//50 less than the width
                int by = (int)(Math.random()*450);//50 less than the height
                fourthStringJellies[i] = new TranStringJelly(bx, by);
            }
            fifthStringJellies = new TranStringJelly[30];
            for(int i = 0; i < fifthStringJellies.length;i++)
            {
                int bx = (int)(Math.random()* 950);//50 less than the width
                int by = (int)(Math.random()*450);//50 less than the height
                fifthStringJellies[i] = new TranStringJelly(bx, by);
            }
            //the bobas
            bobas = new ArrayList<TranBoba>();
            bobas.add(new TranBoba(100, 125));
            bobas.add(new TranBoba(150, 125));
            bobas.add(new TranBoba(200, 125));
            bobas.add(new TranBoba(250, 125));
            bobas.add(new TranBoba(300, 125));
            bobas.add(new TranBoba(483, 245));
            bobas.add(new TranBoba(483, 195));
            bobas.add(new TranBoba(483, 295));
            bobas.add(new TranBoba(760, 50));
            bobas.add(new TranBoba(860, 50));
            bobas.add(new TranBoba(900, 390));
            bobas.add(new TranBoba(750, 390));

            secondBobas = new ArrayList<TranBoba>();
            secondBobas.add(new TranBoba(WIDTH/2, 0));
            secondBobas.add(new TranBoba(WIDTH/2, 30));
            secondBobas.add(new TranBoba(WIDTH/2, 60));
            secondBobas.add(new TranBoba(WIDTH/2, 90));
            secondBobas.add(new TranBoba(WIDTH/2, 120));
            secondBobas.add(new TranBoba(WIDTH/2, 150));
            secondBobas.add(new TranBoba(WIDTH/2, 180));
            secondBobas.add(new TranBoba(WIDTH/2, 210));//middle
            secondBobas.add(new TranBoba(WIDTH/2, 240));
            secondBobas.add(new TranBoba(WIDTH/2, 270));
            secondBobas.add(new TranBoba(WIDTH/2, 300));
            secondBobas.add(new TranBoba(WIDTH/2, 330));
            secondBobas.add(new TranBoba(WIDTH/2, 360));
            secondBobas.add(new TranBoba(WIDTH/2, 390));
            secondBobas.add(new TranBoba(WIDTH/2, 420));
            secondBobas.add(new TranBoba(WIDTH/2, 450));
            secondBobas.add(new TranBoba(950, 210));
            secondBobas.add(new TranBoba(920, 210));
            secondBobas.add(new TranBoba(890, 210));
            secondBobas.add(new TranBoba(860, 210));
            secondBobas.add(new TranBoba(830, 210));
            secondBobas.add(new TranBoba(800, 210));
            secondBobas.add(new TranBoba(770, 210));
            secondBobas.add(new TranBoba(740, 210));
            secondBobas.add(new TranBoba(710, 210));
            secondBobas.add(new TranBoba(680, 210));
            secondBobas.add(new TranBoba(650, 210));
            secondBobas.add(new TranBoba(620, 210));
            secondBobas.add(new TranBoba(590, 210));
            secondBobas.add(new TranBoba(560, 210));
            secondBobas.add(new TranBoba(530, 210));
            secondBobas.add(new TranBoba(470, 210));
            secondBobas.add(new TranBoba(440, 210));
            secondBobas.add(new TranBoba(410, 210));
            secondBobas.add(new TranBoba(380, 210));
            secondBobas.add(new TranBoba(350, 210));
            secondBobas.add(new TranBoba(320, 210));
            secondBobas.add(new TranBoba(290, 210));
            secondBobas.add(new TranBoba(260, 210));
            secondBobas.add(new TranBoba(230, 210));
            secondBobas.add(new TranBoba(200, 210));
            secondBobas.add(new TranBoba(170, 210));
            secondBobas.add(new TranBoba(140, 210));
            secondBobas.add(new TranBoba(110, 210));
            secondBobas.add(new TranBoba(80, 210));
            secondBobas.add(new TranBoba(50, 210));
            secondBobas.add(new TranBoba(20, 210));

            thirdBobas = new ArrayList<TranBoba>();
            thirdBobas.add(new TranBoba(333, 60));
            thirdBobas.add(new TranBoba(333, 90));
            thirdBobas.add(new TranBoba(333, 120));
            thirdBobas.add(new TranBoba(333, 150));
            thirdBobas.add(new TranBoba(333, 180));
            thirdBobas.add(new TranBoba(333, 210));
            thirdBobas.add(new TranBoba(333, 240));
            thirdBobas.add(new TranBoba(333, 270));
            thirdBobas.add(new TranBoba(333, 300));
            thirdBobas.add(new TranBoba(333, 330));
            thirdBobas.add(new TranBoba(333, 360));
            thirdBobas.add(new TranBoba(333, 390));
            thirdBobas.add(new TranBoba(666, 60));
            thirdBobas.add(new TranBoba(666, 90));
            thirdBobas.add(new TranBoba(666, 120));
            thirdBobas.add(new TranBoba(666, 150));
            thirdBobas.add(new TranBoba(666, 180));
            thirdBobas.add(new TranBoba(666, 210));
            thirdBobas.add(new TranBoba(666, 240));
            thirdBobas.add(new TranBoba(666, 270));
            thirdBobas.add(new TranBoba(666, 300));
            thirdBobas.add(new TranBoba(666, 330));
            thirdBobas.add(new TranBoba(666, 360));
            thirdBobas.add(new TranBoba(666, 390));

            fourthBobas = new ArrayList<TranBoba>();
            fourthBobas.add(new TranBoba(250, 45));
            fourthBobas.add(new TranBoba(500, 45));
            fourthBobas.add(new TranBoba(750, 45));
            fourthBobas.add(new TranBoba(220, 80));
            fourthBobas.add(new TranBoba(470, 80));
            fourthBobas.add(new TranBoba(720, 80));
            fourthBobas.add(new TranBoba(280, 80));
            fourthBobas.add(new TranBoba(530, 80));
            fourthBobas.add(new TranBoba(780, 80));
            fourthBobas.add(new TranBoba(250, 115));
            fourthBobas.add(new TranBoba(500, 115));
            fourthBobas.add(new TranBoba(750, 115));
            fourthBobas.add(new TranBoba(250, 260));
            fourthBobas.add(new TranBoba(500, 260));
            fourthBobas.add(new TranBoba(750, 260));
            fourthBobas.add(new TranBoba(220, 295));
            fourthBobas.add(new TranBoba(470, 295));
            fourthBobas.add(new TranBoba(720, 295));
            fourthBobas.add(new TranBoba(280, 295));
            fourthBobas.add(new TranBoba(530, 295));
            fourthBobas.add(new TranBoba(780, 295));
            fourthBobas.add(new TranBoba(250, 330));
            fourthBobas.add(new TranBoba(500, 330));
            fourthBobas.add(new TranBoba(750, 330));

            fifthBobas = new ArrayList<TranBoba>();
            fifthBobas.add(new TranBoba(270, 50));
            fifthBobas.add(new TranBoba(270, 80));
            fifthBobas.add(new TranBoba(270, 110));
            fifthBobas.add(new TranBoba(240, 110));
            fifthBobas.add(new TranBoba(210, 110));
            fifthBobas.add(new TranBoba(370, 50));
            fifthBobas.add(new TranBoba(370, 80));
            fifthBobas.add(new TranBoba(370, 110));
            fifthBobas.add(new TranBoba(370, 140));
            fifthBobas.add(new TranBoba(370, 170));
            fifthBobas.add(new TranBoba(370, 200));
            fifthBobas.add(new TranBoba(340, 200));
            fifthBobas.add(new TranBoba(310, 200));
            fifthBobas.add(new TranBoba(280, 200));
            fifthBobas.add(new TranBoba(250, 200));
            fifthBobas.add(new TranBoba(220, 200));
            fifthBobas.add(new TranBoba(470, 50));
            fifthBobas.add(new TranBoba(470, 80));
            fifthBobas.add(new TranBoba(470, 110));
            fifthBobas.add(new TranBoba(470, 140));
            fifthBobas.add(new TranBoba(470, 170));
            fifthBobas.add(new TranBoba(470, 200));
            fifthBobas.add(new TranBoba(470, 230));
            fifthBobas.add(new TranBoba(470, 260));
            fifthBobas.add(new TranBoba(470, 290));
            fifthBobas.add(new TranBoba(440, 290));
            fifthBobas.add(new TranBoba(410, 290));
            fifthBobas.add(new TranBoba(380, 290));
            fifthBobas.add(new TranBoba(350, 290));
            fifthBobas.add(new TranBoba(320, 290));
            fifthBobas.add(new TranBoba(290,290));
            fifthBobas.add(new TranBoba(260, 290));
            fifthBobas.add(new TranBoba(230, 290));
            fifthBobas.add(new TranBoba(590,50));
            fifthBobas.add(new TranBoba(590, 80));
            fifthBobas.add(new TranBoba(590, 110));
            fifthBobas.add(new TranBoba(590, 140));
            fifthBobas.add(new TranBoba(590, 170));
            fifthBobas.add(new TranBoba(590, 200));
            fifthBobas.add(new TranBoba(590, 230));
            fifthBobas.add(new TranBoba(590, 260));
            fifthBobas.add(new TranBoba(590, 290));
            fifthBobas.add(new TranBoba(590, 320));
            fifthBobas.add(new TranBoba(590, 350));
            fifthBobas.add(new TranBoba(590, 380));
            fifthBobas.add(new TranBoba(560, 380));
            fifthBobas.add(new TranBoba(530, 380));
            fifthBobas.add(new TranBoba(500, 380));
            fifthBobas.add(new TranBoba(470, 380));
            fifthBobas.add(new TranBoba(440, 380));
            fifthBobas.add(new TranBoba(410, 380));
            fifthBobas.add(new TranBoba(380, 380));
            fifthBobas.add(new TranBoba(350, 380));
            fifthBobas.add(new TranBoba(320, 380));
            fifthBobas.add(new TranBoba(290, 380));
            fifthBobas.add(new TranBoba(260, 380));
            fifthBobas.add(new TranBoba(230, 380));
            fifthBobas.add(new TranBoba(710, 50));
            fifthBobas.add(new TranBoba(710, 80));
            fifthBobas.add(new TranBoba(710, 110));
            fifthBobas.add(new TranBoba(710, 140));
            fifthBobas.add(new TranBoba(710, 170));
            fifthBobas.add(new TranBoba(710, 200));
            fifthBobas.add(new TranBoba(710, 230));
            fifthBobas.add(new TranBoba(710, 260));
            fifthBobas.add(new TranBoba(710, 290));
            fifthBobas.add(new TranBoba(710, 320));
            fifthBobas.add(new TranBoba(710, 350));
            fifthBobas.add(new TranBoba(710, 380));
            fifthBobas.add(new TranBoba(710, 410));
            fifthBobas.add(new TranBoba(710, 440));
            fifthBobas.add(new TranBoba(710, 470));
            fifthBobas.add(new TranBoba(680, 470));
            fifthBobas.add(new TranBoba(650, 470));
            fifthBobas.add(new TranBoba(620, 470));
            fifthBobas.add(new TranBoba(590, 470));
            fifthBobas.add(new TranBoba(560, 470));
            fifthBobas.add(new TranBoba(530, 470));
            fifthBobas.add(new TranBoba(500, 470));
            fifthBobas.add(new TranBoba(470, 470));
            fifthBobas.add(new TranBoba(440, 470));
            fifthBobas.add(new TranBoba(410, 470));
            fifthBobas.add(new TranBoba(380, 470));
            fifthBobas.add(new TranBoba(350, 470));
            fifthBobas.add(new TranBoba(320, 470));
            fifthBobas.add(new TranBoba(290, 470));
            fifthBobas.add(new TranBoba(260, 470));
            fifthBobas.add(new TranBoba(230, 470));


            //the thaiTea
            thaiTea = new TranThaiTea[2];
            thaiTea[0] = new TranThaiTea(800, 275);
            thaiTea[1] = new TranThaiTea(WIDTH/2,400);

            fifthThaiTea = new TranThaiTea[5];
            fifthThaiTea[0] = new TranThaiTea(430, 100);
            fifthThaiTea[1] = new TranThaiTea(500, 200);
            fifthThaiTea[2] = new TranThaiTea(350, 350);
            fifthThaiTea[3] = new TranThaiTea(200, 400);
            fifthThaiTea[4] = new TranThaiTea(100, 500);
            
            //jasemine tea
            jasmineTea = new TranJasmineTea(920, 0);

            //matcha tea
            matchaTea = new TranMatchaTea(900,100);
            fifthMatchaTea = new TranMatchaTea[1];
            fifthMatchaTea[0] = new TranMatchaTea(900, 100);


            //oolong tea
            oolongTea = new TranOolongTea(900, 100);

            //audio
            //audio = Applet.newAudioClip(this.getClass().getResource("boba.wav"));
            //audio.loop();

            //gameover 
            gameOver = false;


            //Setting up the GUI
            JFrame gui = new JFrame(); 
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            gui.setTitle("Boba Chase"); 
            gui.setPreferredSize(new Dimension(WIDTH + 5, HEIGHT + 30)); 
            gui.setResizable(false); 
            gui.getContentPane().add(this); 

             /*If after you finish everything, you can declare your buttons or other things
              *at this spot. AFTER gui.getContentPane().add(this) and BEFORE gui.pack();
             */

            gui.pack(); 
            gui.setLocationRelativeTo(null); 
            gui.setVisible(true); 
            gui.addKeyListener(this);
            gui.addMouseListener(this); 
            gui.addMouseMotionListener(this); 
        }
        
        
       
    }   
    //All your UI drawing goes in here
    public void paintComponent(Graphics g)
    {
        if(gameOver == false && level == 1)
        {
            Graphics2D g2d = (Graphics2D) g;
            
        
            //the gui
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        
            //the writing
            Image background1 = background[0].getImage();
            g2d.drawImage(background1, 0, 0, WIDTH, HEIGHT, null);
            Font f = new Font("Times New Roman", Font.BOLD, 35);
            g.setFont(f);
            g.setColor(Color.RED);
            g.drawString("Points: " + player.getPoints(), 30, 50);
            g.setColor(Color.RED);
            g.drawString("Level 1", 830, 480);
            
            //ze stars
            for(int i = 0; i < moreStars.length; i++)
            {
                if(moreStars[i].getCollected() == false)//draw star because it has not been collected yet
                {
                    moreStars[i].drawSelf(g);
                }
            }
            
            //removing all bobas once everything has been collected
            
            
            //conditions of the boba being drawn
            for(int i = 0; i <bobas.size();i++)
            {
                bobas.get(i).drawSelf(g);
            }
        
            thaiTea[0].drawSelf(g);
            thaiTea[1].drawSelf(g);
        

            player.drawSelf(g);
        }
        else if(gameOver == false && level == 2)
        {
            Graphics2D g2d = (Graphics2D) g;
            
            //gui and the points
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            Font f = new Font("Times New Roman", Font.BOLD, 35);
            g.setFont(f);
            g.setColor(Color.RED);
            g.drawString("Points: " + secondPlayer.getPoints(), 30, 50);
            g.setColor(Color.RED);
            g.drawString("Level 2", 830, 480);
            
            Image background1 = background[1].getImage();
            g2d.drawImage(background1, 0, 0, WIDTH, HEIGHT, null);
            
            //the bobas
            for(int i = 0; i < secondBobas.size(); i++)
            {
                secondBobas.get(i).drawSelf(g);
            }
            
            //jasmine tea
            jasmineTea.drawSelf(g);
            
            //drawing the stars
            for(int i = 0; i < secondStars.length; i++)
            {
                if(secondStars[i].getCollected() == false)//draw star because it has not been collected yet
                {
                    secondStars[i].drawSelf(g);
                }
            }
            
            //jelly cubes
            if(secondPlayer.getPoints() >= 4300)
            {
                for(int i = 0; i < cubes.length;i++)
                {    
                    if(cubes[i].getCollected() == false)
                        cubes[i].drawSelf(g);
                }
            }
            //the player
            secondPlayer.drawSelf(g);
        }
        else if(gameOver == false && level == 3)
        {
            Graphics2D g2d = (Graphics2D) g;
            //gui and points
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            Font f = new Font("Times New Roman", Font.BOLD, 35);
            g.setFont(f);
            g.setColor(Color.RED);
            g.drawString("Points: " + thirdPlayer.getPoints(), 30, 50);
            g.setColor(Color.RED);
            g.drawString("Level 3", 830, 480);
            Image background1 = background[2].getImage();
            g2d.drawImage(background1, 0, 0, WIDTH, HEIGHT, null);
            
            //bobas
            for(int i = 0; i < thirdBobas.size(); i++)
            {
                thirdBobas.get(i).drawSelf(g);
            }
            
            //matcha tea
            matchaTea.drawSelf(g);
            
            //jelly cubes
            if(thirdPlayer.getPoints() >= 1200)
            {
                for(int i = 0; i < thirdCubes.length;i++)
                {    
                    if(thirdCubes[i].getCollected() == false)
                        thirdCubes[i].drawSelf(g);
                }
            }
            //stars
            for(int i = 0; i < thirdStars.length; i++)
            {
                if(thirdStars[i].getCollected() == false)//draw star because it has not been collected yet
                {
                    thirdStars[i].drawSelf(g);
                }
            }            
            
            //string jellies
            if(thirdPlayer.getPoints() >= 2800)
            {
                for(int i = 0; i < stringJellies.length; i++)
                {
                    if(stringJellies[i].getCollected() == false)//draw star because it has not been collected yet
                    {
                        stringJellies[i].drawSelf(g);
                    }
                }
            }
            
            //str
            //player
            thirdPlayer.drawSelf(g);
        }
        else if(gameOver == false && level == 4)
        {
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            Font f = new Font("Times New Roman", Font.BOLD, 35);
            g.setFont(f);
            g.setColor(Color.RED);
            g.drawString("Points: " + fourthPlayer.getPoints(), 30, 50);
            g.setColor(Color.RED);
            g.drawString("Level 4", 830, 480);
            Image background1 = background[3].getImage();
            g2d.drawImage(background1, 0, 0, WIDTH, HEIGHT, null);
            
            //the bobas
            for(int i = 0; i < fourthBobas.size(); i++)
            {
                fourthBobas.get(i).drawSelf(g);
            }
            
            //the stars
            for(int i = 0; i < fourthStars.length; i++)
            {
                if(fourthStars[i].getCollected() == false)//draw star because it has not been collected yet
                {
                    fourthStars[i].drawSelf(g);
                }
            }
            
            //the string jellies
            if(fourthPlayer.getPoints() >= 600)
            {
                for(int i = 0; i < fourthStringJellies.length; i++)
                {
                    if(fourthStringJellies[i].getCollected() == false)//draw star because it has not been collected yet
                    {
                        fourthStringJellies[i].drawSelf(g);
                    }
                }
            }
            
            //oolong tea
            oolongTea.drawSelf(g);
            fourthPlayer.drawSelf(g);
        }
        else if(gameOver == false && level == 5)
        {
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            Font f = new Font("Times New Roman", Font.BOLD, 35);
            g.setFont(f);
            g.setColor(Color.RED);
            g.drawString("Points: " + fifthPlayer.getPoints(), 30, 50);
            g.setColor(Color.RED);
            g.drawString("Level 5", 830, 480);
            Image background1 = background[4].getImage();
            g2d.drawImage(background1, 0, 0, WIDTH, HEIGHT, null);
            
            //drawing bobas
            for(int i = 0; i < fifthBobas.size(); i++)
            {
                fifthBobas.get(i).drawSelf(g);
            }
            
            //drawing stars
            for(int i = 0; i < fifthStars.length; i++)
            {
                if(fifthStars[i].getCollected() == false)//draw star because it has not been collected yet
                {
                    fifthStars[i].drawSelf(g);
                }
            }
            
            //jelly strings
            if(fifthPlayer.getPoints() >= 7400)
            {
                for(int i = 0; i < fifthStringJellies.length; i++)
                {
                    if(fifthStringJellies[i].getCollected() == false)//draw star because it has not been collected yet
                    {
                        fifthStringJellies[i].drawSelf(g);
                    }
                }
            }
            
            //thaitea
            for(int i = 0; i <fifthThaiTea.length;i++)
            {
                fifthThaiTea[i].drawSelf(g);
            }
            //matcha tea
            for(int i = 0; i <fifthMatchaTea.length;i++)
            {
                fifthMatchaTea[i].drawSelf(g);
            }
            
            fifthPlayer.drawSelf(g);    
        }
        else if(level == 6 && gameOver == false)
        {
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            Image background1 = background[7].getImage();
            g2d.drawImage(background1, 0, 0, WIDTH, HEIGHT, null);

        }
        else if(level == 0 && gameOver == false)
        {
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            Image background1 = background[5].getImage();
            g2d.drawImage(background1, 0, 0, WIDTH, HEIGHT, null);
        }
        else
        {
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            Image background1 = background[6].getImage();
            g2d.drawImage(background1, 0, 0, WIDTH, HEIGHT, null);
        }
        
        
    }
    
    public void loop()
    {
        if(gameOver == false && level == 1)
        {
            //checks if game is working
            //System.out.println(player);
            //System.out.println("(" + thaiTea[0].getX() + ", " + thaiTea[0].getY() + ")" );
            //System.out.println("(" + thaiTea[1].getX() + ", " + thaiTea[1].getY() + ")");
        
            //player moving
            player.move(bobas, WIDTH, HEIGHT);
        
        
            //player colliding with star
            for(int i = 0; i < moreStars.length; i++)
            {
                if(moreStars[i].getCollected() == false)//star is not collected, therefore needs to be collected by player
                {
                    boolean starObtained = moreStars[i].handleCollision(player);
                    if(starObtained == true)
                    {
                        player.gainStar();
                    }
                }
            }
            
            //player completed collected star
            if(player.getPoints() == 2000)
            {
                level = 2;
            }
            //thai tea moving
            thaiTea[0].act(WIDTH, HEIGHT);
            thaiTea[1].act(WIDTH, HEIGHT);
        
            //thai tea colliding with bobas
            thaiTea[0].handleCollision(bobas);
            thaiTea[1].handleCollision(bobas);
        
            //thaiTea collding with other thaiTea
            thaiTea[0].handleCollision(thaiTea[1]);
            thaiTea[1].handleCollision(thaiTea[0]);
            
            //thaiTea colliding with player
            boolean t = thaiTea[0].handleCollision(player);
            boolean t2 = thaiTea[1].handleCollision(player);
            if(t == true || t2 == true)
            {
                gameOver = true;
            }
        }
        else if(gameOver == false && level == 2)
        {
            //player is working
            System.out.println(secondPlayer);
            
            //player moving
            secondPlayer.move(secondBobas, WIDTH, HEIGHT);
            
            //player collecting stars
            for(int i = 0; i < secondStars.length; i++)
            {
                if(secondStars[i].getCollected() == false)//star is not collected, therefore needs to be collected by player
                {
                    boolean starObtained = secondStars[i].handleCollision(secondPlayer);
                    if(starObtained == true)
                    {
                        secondPlayer.gainStar();
                    }
                }
            }
            //player collecting jelly cube
            if(secondPlayer.getPoints() >= 4300)
            {
                for(int i =0; i < cubes.length; i++)
                {
                    if(cubes[i].getCollected() == false)
                    {
                        boolean cubeObtained = cubes[i].handleCollision(secondPlayer);
                        if(cubeObtained == true)
                        {
                            secondPlayer.gainStar();
                        }
                    }
                }
            }
            //jasmine tea moving
            jasmineTea.act(WIDTH, HEIGHT, secondPlayer);
            
            //jasmine tea colliding with the bobas
            if(jasmineTea.handleCollision(secondBobas) == true)
                    //secondBobas.remove();
            jasmineTea.handleCollision(secondBobas);
            
            //jasmine tea colliding with player
            if(jasmineTea.handleCollision(secondPlayer) == true)
                gameOver = true;
            //checking if player has collected everything
            if(secondPlayer.getPoints() == 5500)
            {
                level = 3;
            }
            
        }
        else if(gameOver == false && level == 3)
        {
            //player
            System.out.println(thirdPlayer);
            thirdPlayer.move(thirdBobas, WIDTH, HEIGHT);

            
            //player collecting star
            for(int i = 0; i < thirdStars.length; i++)
            {
                if(thirdStars[i].getCollected() == false)//star is not collected, therefore needs to be collected by player
                {
                    boolean starObtained = thirdStars[i].handleCollision(thirdPlayer);
                    if(starObtained == true)
                    {
                        thirdPlayer.gainStar();
                    }
                }
            }
            
            //player collecting cubes
            if(thirdPlayer.getPoints() >= 1200)
            {
                for(int i =0; i < thirdCubes.length; i++)
                {
                    if(thirdCubes[i].getCollected() == false)
                    {
                        boolean cubeObtained = thirdCubes[i].handleCollision(thirdPlayer);
                        if(cubeObtained == true)
                        {
                            thirdPlayer.gainStar();
                        }
                    }
                }
            }
            //string jellies moving
            if(thirdPlayer.getPoints() >= 2800)
            {
                for(int i = 0; i < stringJellies.length; i++)
                {
                    stringJellies[i].act(WIDTH, HEIGHT);
                    stringJellies[i].handleCollision(thirdBobas);
                    if(stringJellies[i].getCollected() == false)//star is not collected, therefore needs to be collected by player
                    {
                        boolean starObtained = stringJellies[i].handleCollision(thirdPlayer);
                        if(starObtained == true)
                        {
                            thirdPlayer.gainStar();
                        }
                    }
                }
            
            }
            //matcha tea
            if(matchaTea.handleCollision(thirdBobas) == false)
            {
                matchaTea.act(WIDTH, HEIGHT, thirdPlayer);  
            }

            if(matchaTea.handleCollision(thirdPlayer) == true)
                gameOver = true;
            
            //when the player has finished collecting
            if(thirdPlayer.getPoints() >= 4400)
                level = 4;
            
        }
        else if(gameOver == false && level == 4)
        {
            //playaer collecting stars
            for(int i = 0; i < fourthStars.length; i++)
            {
                if(fourthStars[i].getCollected() == false)//star is not collected, therefore needs to be collected by player
                {
                    boolean starObtained = fourthStars[i].handleCollision(fourthPlayer);
                    if(starObtained == true)
                    {
                        fourthPlayer.gainStar();
                    }
                }
            }
            //string jellies
            if(fourthPlayer.getPoints() >= 600)
            {
                for(int i = 0; i < fourthStringJellies.length; i++)
                {
                    fourthStringJellies[i].act(WIDTH, HEIGHT);
                    fourthStringJellies[i].handleCollision(fourthBobas);
                    if(fourthStringJellies[i].getCollected() == false)//star is not collected, therefore needs to be collected by player
                    {
                        boolean starObtained = fourthStringJellies[i].handleCollision(fourthPlayer);
                        if(starObtained == true)
                        {
                            fourthPlayer.gainStar();
                        }
                    }
                }
            
            }
            //oolong tea
                oolongTea.act(WIDTH, HEIGHT, fourthPlayer);  
            
            //next level
            if(fourthPlayer.getPoints() >= 2600)
                level =5;
            //gamveOver
            if(oolongTea.handleCollision(fourthPlayer) == true)
                gameOver = true;
            fourthPlayer.move(fourthBobas, WIDTH, HEIGHT);
        }
        else if(gameOver == false && level == 5)
        {
            //the stars
            for(int i = 0; i < fifthStars.length; i++)
            {
                if(fifthStars[i].getCollected() == false)//star is not collected, therefore needs to be collected by player
                {
                    boolean starObtained = fifthStars[i].handleCollision(fifthPlayer);
                    if(starObtained == true)
                    {
                        fifthPlayer.gainStar();
                    }
                }
            }
            
            //string jellies
            if(fifthPlayer.getPoints() >= 7400)
            {
                for(int i = 0; i < fifthStringJellies.length; i++)
                {
                    fifthStringJellies[i].act(WIDTH, HEIGHT);
                    fifthStringJellies[i].handleCollision(fifthBobas);
                    if(fifthStringJellies[i].getCollected() == false)//star is not collected, therefore needs to be collected by player
                    {
                        boolean starObtained = fifthStringJellies[i].handleCollision(fifthPlayer);
                        if(starObtained == true)
                        {
                            fifthPlayer.gainStar();
                        }
                    }
                }
            
            }
            
            //thaitea
            for(int i = 0; i <fifthThaiTea.length;i++)
            {
                fifthThaiTea[i].act(WIDTH, HEIGHT);
                fifthThaiTea[i].handleCollision(fifthBobas);
                boolean t = fifthThaiTea[i].handleCollision(fifthPlayer);
                if(t == true)
                    gameOver = true;
            }
            
            //matcha tea
            for(int i = 0; i <fifthMatchaTea.length;i++)
            {
                if(fifthMatchaTea[i].handleCollision(fifthBobas) == false)
                {
                    fifthMatchaTea[i].act(WIDTH, HEIGHT, fifthPlayer);  
                }

                if(fifthMatchaTea[i].handleCollision(fifthPlayer) == true)
                    gameOver = true;
            }
            
            //player
            if(fifthPlayer.getPoints() >= 10400)
                level=6;
            
            fifthPlayer.move(fifthBobas, WIDTH, HEIGHT);
        }
        
        
        repaint();
        
    }
    
    //These methods are required by the compiler.  
    //You might write code in these methods depending on your goal.
    public void keyTyped(KeyEvent e) 
    {
    }
    public void keyReleased(KeyEvent e) 
    {
      int key = e.getKeyCode();
      
        if(key == 38 || key == 87)
        {
            player.setVY(0);
            secondPlayer.setVY(0);
            thirdPlayer.setVY(0);
            fourthPlayer.setVY(0);
            fifthPlayer.setVY(0);
        }
        else if(key == 40 || key == 83)
        {
            player.setVY(0);
            secondPlayer.setVY(0);
            thirdPlayer.setVY(0);
            fourthPlayer.setVY(0);
            fifthPlayer.setVY(0);
        }
        else if(key == 39 || key == 68)
        {
            player.setVX(0);
            secondPlayer.setVX(0);
            thirdPlayer.setVX(0);
            fourthPlayer.setVX(0);
            fifthPlayer.setVX(0);
        }
        else if(key == 37 || key == 65)
        {
            player.setVX(0);
            secondPlayer.setVX(0);
            thirdPlayer.setVX(0);
            fourthPlayer.setVX(0);
            fifthPlayer.setVX(0);
        }
        
      
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mouseMoved(MouseEvent e)
    {
    }
    public void mouseDragged(MouseEvent e)
    {
    }
    public void start(final int ticks){
        Thread gameThread = new Thread(){
            public void run(){
                while(true){
                    loop();
                    try{    
                        Thread.sleep(1000 / ticks);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };	
        gameThread.start();
    }

    public static void main(String[] args)
    {
        TranProj8b g = new TranProj8b();
        g.start(60);
    }
}
