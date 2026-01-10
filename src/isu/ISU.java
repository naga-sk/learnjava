// package isu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

import static java.awt.BasicStroke.*;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import java.awt.Rectangle; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


/**
 * ISU
 * @author Shadya Hajela
 */

public class ISU extends JPanel implements ActionListener, KeyListener{
    Timer timer = new Timer(3, this);
    
    int y = 0;
    int x = 100;
    int velX = 0;
    int velY = 0;
    
    String word="";
    
    File fontFile = new File("./fonts/poti.ttf");
    Font poti;
    
    ImageIcon hamster = new ImageIcon(getClass().getResource("/images/hamster.jfif"));
    ImageIcon grass = new ImageIcon(getClass().getResource("/images/grass.png"));
    ImageIcon movingWater = new ImageIcon(getClass().getResource("/images/movingWater.gif"));
    ImageIcon pavingBlock = new ImageIcon(getClass().getResource("/images/pavingBlock.jpg"));
    
    ImageIcon alien = new ImageIcon(getClass().getResource("/images/alien.png"));
    
    public static int[][] map = {{1, 0, 0, 2, 2, 2, 2, 1, 1, 1},
                                 {1, 0, 2, 2, 2, 2, 2, 2, 1, 0},
                                 {1, 0, 0, 0, 0, 1, 2, 2, 2, 0},
                                 {1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                                 {0, 0, 0, 1, 0, 1, 0, 0, 0, 0}};
    
    ImageIcon[] tiles = {
        new ImageIcon(getClass().getResource("/images/grass.png")),       //0
        new ImageIcon(getClass().getResource("/images/movingWater.gif")), //1
        new ImageIcon(getClass().getResource("/images/pavingBlock.jpg")), //2
    };
   

    public ISU(){
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        try{
            poti = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        }catch(Exception e){}
        
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    
    //hamster.paintIcon(this, g, 20, 30);
    
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if(map[row][col] == 0){
                    grass.paintIcon(this, g, col*100, row*100);
                }else if(map[row][col] == 1){
                    pavingBlock.paintIcon(this, g, col*100, row*100);
                }else if(map[row][col] == 2){
                    movingWater.paintIcon(this, g, col*100, row*100);
                }
                
            }
        }
        
        g.fillRect(x, y, 50, 50);
        
        alien.paintIcon(this, g, x, y);

        g.fillRect(500, 0, 10, 500);
        
    }
    
    public void keyPressed(KeyEvent e){
        int c = e.getKeyCode();
        
        if(c == KeyEvent.VK_RIGHT){
            velX = 3;
        }else if(c == KeyEvent.VK_LEFT){
            velX = -3;
        }else if(c == KeyEvent.VK_UP){
            velY = -3;
        }else if(c == KeyEvent.VK_DOWN){
            velY = 3;
        }
    }
    
    public void keyTyped(KeyEvent e){
        word = word + e.getKeyChar();
    }
    
    public void keyReleased(KeyEvent e){
        int c = e.getKeyCode();
        
        if(c == KeyEvent.VK_RIGHT){
            velX = 0;
        }else if(c == KeyEvent.VK_LEFT){
            velX = 0;
        }else if(c == KeyEvent.VK_UP){
            velY = 0;
        }else if(c == KeyEvent.VK_DOWN){
            velY = 0;
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,50,50);
    }
    
    public void actionPerformed (ActionEvent e){
        
        collision();
        
        x = x + velX;
        y = y + velY;
        
        repaint();
    }
    
    public void collision(){
        Rectangle playerRL = new Rectangle(x, y + velY, 50, 50);
        Rectangle playerUD = new Rectangle(x + velX, y, 50, 50);
        Rectangle computer = new Rectangle(500, 0, 10, 500);
        if (playerRL.intersects(computer)){
            
            velY = 0;
        }
        if (playerUD.intersects(computer)){
            
            velX = 0;
        }
    }
    
    public static void main(String[] args) {
        
        ISU panel = new ISU();
        
        panel.setBackground(Color.WHITE);
        
        JFrame frame = new JFrame( );
        
        frame.setTitle("Lesson 5.4");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);

        frame.pack();
        
        frame.setSize(1000, 500);
        
        frame.setVisible(true);

        
        
    }
}