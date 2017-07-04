/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision.camera;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author maciej.pikulicki
 */
public class Drawing extends JPanel {
    private int c1x1 = 0;
    private int c1y1 = 0;
    private int c1x2 = 0;
    private int c1y2 = 0;
    private int c1x3 = 0;
    private int c1y3 = 0;
    private int c1x4 = 0;
    private int c1y4 = 0;
    private int c1x5 = 0;
    private int c1y5 = 0;
    private int c1x6 = 0;
    private int c1y6 = 0;
    private int c1x7 = 0;
    private int c1y7 = 0;
    private int c1x8 = 0;
    private int c1y8 = 0;
    //
    private int c2x1 = 0;
    private int c2y1 = 0;
    private int c2x2 = 0;
    private int c2y2 = 0;
    private int c2x3 = 0;
    private int c2y3 = 0;
    private int c2x4 = 0;
    private int c2y4 = 0;
    private int c2x5 = 0;
    private int c2y5 = 0;
    private int c2x6 = 0;
    private int c2y6 = 0;
    private int c2x7 = 0;
    private int c2y7 = 0;
    private int c2x8 = 0;
    private int c2y8 = 0;
    //
    private int c3x1 = 0;
    private int c3y1 = 0;
    private int c3x2 = 0;
    private int c3y2 = 0;
    private int c3x3 = 0;
    private int c3y3 = 0;
    private int c3x4 = 0;
    private int c3y4 = 0;
    private int c3x5 = 0;
    private int c3y5 = 0;
    private int c3x6 = 0;
    private int c3y6 = 0;
    private int c3x7 = 0;
    private int c3y7 = 0;
    private int c3x8 = 0;
    private int c3y8 = 0;
    //
    private int c4x1 = 0;
    private int c4y1 = 0;
    private int c4x2 = 0;
    private int c4y2 = 0;
    private int c4x3 = 0;
    private int c4y3 = 0;
    private int c4x4 = 0;
    private int c4y4 = 0;
    private int c4x5 = 0;
    private int c4y5 = 0;
    private int c4x6 = 0;
    private int c4y6 = 0;
    private int c4x7 = 0;
    private int c4y7 = 0;
    private int c4x8 = 0;
    private int c4y8 = 0;
    //
    Cube cube1;
    Cube cube2;
    Cube cube3;
    Cube cube4;
           
    
    public Drawing(Cube cubeT1, Cube cubeT2, Cube cubeT3, Cube cubeT4){
            this.cube1 = cubeT1;
            this.cube2 = cubeT2;
            this.cube3 = cubeT3;
            this.cube4 = cubeT4;
            
            this.cube1.convertTo2D();
            this.cube2.convertTo2D();
            this.cube3.convertTo2D();
            this.cube4.convertTo2D();
           
        }
        
        @Override    

        protected void paintComponent(Graphics g) {
                
                
                super.paintComponent(g);
                
        //drawBackground
                g.setColor(Color.lightGray);
                g.drawRect(0, 0, 800, 800);
                g.fillRect(0, 0, 800, 800);
        //drawLine
                g.translate(400, 400);
                initPoints();
                g.setColor(Color.green);
                
                AllWalls allWalls = new AllWalls(cube1, cube2, cube3, cube4);
                allWalls.sortAllWalls();
               for(int i = 0; i<1536; i++){        

                   
                switch (allWalls.getAllWalls().get(i).getColor()){
                       case "red": g.setColor(Color.red);
                            break;
                       case "yellow": g.setColor(Color.magenta);
                            break;
                       case "blue": g.setColor(Color.blue);
                            break;
                       case "green": g.setColor(Color.green);
                            break;      
                       default: g.setColor(Color.white);
                            break;      
               }
               g.fillPolygon(allWalls.getAllWalls().get(i).getWallX(), allWalls.getAllWalls().get(i).getWallY(), allWalls.getAllWalls().get(i).getWallLength());
               g.setColor(Color.black);
               g.drawPolygon(allWalls.getAllWalls().get(i).getWallX(), allWalls.getAllWalls().get(i).getWallY(), allWalls.getAllWalls().get(i).getWallLength());
               }
         }
        
        public void initPoints() {
            
            this.c1x1 = this.cube1.getVectorX2D()[0];
            this.c1y1 = this.cube1.getVectorY2D()[0];
            this.c1x2 = this.cube1.getVectorX2D()[1];
            this.c1y2 = this.cube1.getVectorY2D()[1];
            this.c1x3 = this.cube1.getVectorX2D()[2];
            this.c1y3 = this.cube1.getVectorY2D()[2];
            this.c1x4 = this.cube1.getVectorX2D()[3];
            this.c1y4 = this.cube1.getVectorY2D()[3];
            this.c1x5 = this.cube1.getVectorX2D()[4];
            this.c1y5 = this.cube1.getVectorY2D()[4];
            this.c1x6 = this.cube1.getVectorX2D()[5];
            this.c1y6 = this.cube1.getVectorY2D()[5];
            this.c1x7 = this.cube1.getVectorX2D()[6];
            this.c1y7 = this.cube1.getVectorY2D()[6];
            this.c1x8 = this.cube1.getVectorX2D()[7];
            this.c1y8 = this.cube1.getVectorY2D()[7];
            //
            this.c2x1 = this.cube2.getVectorX2D()[0];
            this.c2y1 = this.cube2.getVectorY2D()[0];
            this.c2x2 = this.cube2.getVectorX2D()[1];
            this.c2y2 = this.cube2.getVectorY2D()[1];
            this.c2x3 = this.cube2.getVectorX2D()[2];
            this.c2y3 = this.cube2.getVectorY2D()[2];
            this.c2x4 = this.cube2.getVectorX2D()[3];
            this.c2y4 = this.cube2.getVectorY2D()[3];
            this.c2x5 = this.cube2.getVectorX2D()[4];
            this.c2y5 = this.cube2.getVectorY2D()[4];
            this.c2x6 = this.cube2.getVectorX2D()[5];
            this.c2y6 = this.cube2.getVectorY2D()[5];
            this.c2x7 = this.cube2.getVectorX2D()[6];
            this.c2y7 = this.cube2.getVectorY2D()[6];
            this.c2x8 = this.cube2.getVectorX2D()[7];
            this.c2y8 = this.cube2.getVectorY2D()[7];
            //
            this.c3x1 = this.cube3.getVectorX2D()[0];
            this.c3y1 = this.cube3.getVectorY2D()[0];
            this.c3x2 = this.cube3.getVectorX2D()[1];
            this.c3y2 = this.cube3.getVectorY2D()[1];
            this.c3x3 = this.cube3.getVectorX2D()[2];
            this.c3y3 = this.cube3.getVectorY2D()[2];
            this.c3x4 = this.cube3.getVectorX2D()[3];
            this.c3y4 = this.cube3.getVectorY2D()[3];
            this.c3x5 = this.cube3.getVectorX2D()[4];
            this.c3y5 = this.cube3.getVectorY2D()[4];
            this.c3x6 = this.cube3.getVectorX2D()[5];
            this.c3y6 = this.cube3.getVectorY2D()[5];
            this.c3x7 = this.cube3.getVectorX2D()[6];
            this.c3y7 = this.cube3.getVectorY2D()[6];
            this.c3x8 = this.cube3.getVectorX2D()[7];
            this.c3y8 = this.cube3.getVectorY2D()[7];
            //
            this.c4x1 = this.cube4.getVectorX2D()[0];
            this.c4y1 = this.cube4.getVectorY2D()[0];
            this.c4x2 = this.cube4.getVectorX2D()[1];
            this.c4y2 = this.cube4.getVectorY2D()[1];
            this.c4x3 = this.cube4.getVectorX2D()[2];
            this.c4y3 = this.cube4.getVectorY2D()[2];
            this.c4x4 = this.cube4.getVectorX2D()[3];
            this.c4y4 = this.cube4.getVectorY2D()[3];
            this.c4x5 = this.cube4.getVectorX2D()[4];
            this.c4y5 = this.cube4.getVectorY2D()[4];
            this.c4x6 = this.cube4.getVectorX2D()[5];
            this.c4y6 = this.cube4.getVectorY2D()[5];
            this.c4x7 = this.cube4.getVectorX2D()[6];
            this.c4y7 = this.cube4.getVectorY2D()[6];
            this.c4x8 = this.cube4.getVectorX2D()[7];
            this.c4y8 = this.cube4.getVectorY2D()[7];
        }
        
        public ArrayList<Cube> getCubes() {
            ArrayList<Cube> a = new ArrayList();
            a.add(this.cube1);
            a.add(this.cube2);
            a.add(this.cube3);
            a.add(this.cube4);
            return a;
        }
        
        public void setCubes(ArrayList<Cube> a) {
            this.cube1 = a.get(0);
            this.cube2 = a.get(1);
            this.cube3 = a.get(2);
            this.cube4 = a.get(3);
            
        }
    
}
