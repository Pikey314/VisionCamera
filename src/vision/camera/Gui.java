/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision.camera;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author maciej.pikulicki
 */
public class Gui extends JFrame {
    
    
    public Gui () {
    initGUI();
    }
    
    private void initGUI() {
        
        
     //create Cube
    
       
       Cube cube1 = new Cube(-4,-2,7,2,2,2);
       Cube cube2 = new Cube(2,-2,7,2,2,2);
       Cube cube3 = new Cube(-4,-2,14,2,2,2);
       Cube cube4 = new Cube(2,-2,14,2,2,2);
       
       
       
     //create Frame
       Drawing frame = new Drawing(cube1,cube2,cube3,cube4);
       

        
     //Buttons 
        JButton forwardButton = new JButton("Forward");
        JButton backButton = new JButton("Back");
        JButton leftButton = new JButton("Left");
        JButton rightButton = new JButton("Right");
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");        
        JButton rotateYRightButton = new JButton ("Turn Right");
        JButton rotateYLeftButton = new JButton ("Turn Left");
        JButton zoomInButton = new JButton ("Zoom +");
        JButton zoomOutButton = new JButton ("Zoom -");
        JButton rotateZLeftButton = new JButton ("Spin Left");
        JButton rotateZRightButton = new JButton ("Spin Right");
        JButton rotateXUpButton = new JButton ("Turn Up");
        JButton rotateXDownButton = new JButton ("Turn Down");
        
      

     //Control Panel
        JPanel control = new JPanel();
       
        
        ArrayList <JButton> buttons = new ArrayList();
        buttons.add(forwardButton);
        buttons.add(backButton);
        buttons.add(leftButton);
        buttons.add(rightButton);
        buttons.add(upButton);
        buttons.add(downButton);
        buttons.add(zoomInButton);
        buttons.add(zoomOutButton);
        buttons.add(rotateYRightButton);
        buttons.add(rotateYLeftButton);
        buttons.add(rotateZLeftButton);
        buttons.add(rotateZRightButton);
        buttons.add(rotateXUpButton);
        buttons.add(rotateXDownButton);
        
        for (int i = 0; i<buttons.size(); i++)
        control.add(buttons.get(i));
        
        for (int i = 0; i<buttons.size(); i++){
            buttons.get(i).setPreferredSize(new Dimension(130,50));
            buttons.get(i).setBackground(Color.darkGray);
            buttons.get(i).setForeground(Color.green);
            buttons.get(i).setFont(new Font("Arial", Font.BOLD, 15));
        }
        
        
        
        
        
        
        control.setPreferredSize(new Dimension(150,800));
        control.setBackground(Color.green);
        
       //assign actions to buttons START
       rightButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).goLeft();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
       leftButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).goRight();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
        
       upButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).goDown();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
       downButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).goUp();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
       forwardButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).goBack();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
       backButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).goForward();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
       rotateYRightButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).rotYLeft();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
       rotateYLeftButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).rotYRight();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );

        zoomInButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).zoomMinus();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
        zoomOutButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).zoomPlus();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
        rotateZLeftButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).rotZRight();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
        
        rotateZRightButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).rotZLeft();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
        
        rotateXUpButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).rotXDown();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
        
        rotateXDownButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
             ArrayList<Cube> cubes;   
             cubes = frame.getCubes();
             for(int i = 0; i<=3; i++)
                 cubes.get(i).rotXUp();
             frame.setCubes(cubes);
             frame.revalidate();
             frame.repaint();
            }     
        } );
       
       
       
       //assign actions to buttons END
        //draw window
        frame.setOpaque(false);
        frame.setBackground(Color.red);
        //adding components to JFrame
        
        add(frame);
        frame.repaint();
        add(control,  BorderLayout.EAST);

     //JFrame settings
        setTitle("Visium Camera");
        setSize(950, 820);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    
}
