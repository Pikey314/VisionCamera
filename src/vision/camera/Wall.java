/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision.camera;

import java.util.ArrayList;

/**
 *
 * @author maciej.pikulicki
 */
public class Wall {
    int wallX[];
    int wallY[];
    int wallLength;
    double wallX3D[];
    double wallY3D[];
    double wallZ3D[];
    String color;
    double x3Dcenter;
    double y3Dcenter;
    double z3Dcenter;
    double howFar;
    Wall splitedWalls[];
    //C - Center, R- right, L- left, U- up, D- down
    int xCR;
    int yCR;
    int xCL;
    int yCL;
    int xCU;
    int yCU;
    int xCD;
    int yCD;
    int xCC;
    int yCC;
    double xCR3D;
    double yCR3D;
    double zCR3D;
    double xCL3D;
    double yCL3D;
    double zCL3D;
    double xCU3D;
    double yCU3D;
    double zCU3D;
    double xCD3D;
    double yCD3D;
    double zCD3D;
    
           
    
    public Wall(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4, double xD1, double yD1, double zD1, double xD2, double yD2, double zD2, double xD3, double yD3, double zD3, double xD4, double yD4, double zD4){
        this.wallLength = 4;
        this.wallX = new int[wallLength];
        this.wallY = new int[wallLength];
        this.wallX3D = new double[wallLength];
        this.wallY3D = new double[wallLength];
        this.wallZ3D = new double[wallLength];
        this.splitedWalls = new Wall[4];
        
        
        
        this.xCU = (x1 + x2)/2;
        this.yCU = (y1 + y2)/2;
        this.xCR = (x2 + x3)/2;
        this.yCR = (y2 + y3)/2;
        this.xCD = (x3 + x4)/2;
        this.yCD = (y3 + y4)/2;
        this.xCL = (x1 + x4)/2;
        this.yCL = (y1 + y4)/2;
        this.xCC = (x4 + x2)/2;
        this.yCC = (y4 + y2)/2;
        
         this.xCR3D = (xD2 + xD4)/2;
         this.yCR3D = (yD2 + yD4)/2;
         this.zCR3D = (zD2 + zD4)/2;
         this.xCL3D = (xD3 + xD1)/2;
         this.yCL3D = (yD3 + yD1)/2;
         this.zCL3D = (zD3 + zD1)/2;
         this.xCU3D = (xD3 + xD2)/2;
         this.yCU3D = (yD3 + yD2)/2;
         this.zCU3D = (zD3 + zD2)/2;
         this.xCD3D = (xD1 + xD4)/2;
         this.yCD3D = (yD1 + yD4)/2;
         this.zCD3D = (zD1 + zD4)/2;
        
        
        this.x3Dcenter = (xD1+xD2)/2;
        this.y3Dcenter = (yD1+yD2)/2;
        this.z3Dcenter = (zD1+zD2)/2;
        this.howFar = Math.pow(this.x3Dcenter,2) + Math.pow(this.y3Dcenter,2) + Math.pow(this.z3Dcenter,2);
        
        this.wallX[0] = x1;
        this.wallX[1] = x2;
        this.wallX[2] = x3;
        this.wallX[3] = x4;
        
        this.wallY[0] = y1;
        this.wallY[1] = y2;
        this.wallY[2] = y3;
        this.wallY[3] = y4;
        
        this.wallX3D[0] = xD1;
        this.wallX3D[1] = xD2;
        this.wallX3D[2] = xD3;
        this.wallX3D[3] = xD4;
        
        this.wallY3D[0] = yD1;
        this.wallY3D[1] = yD2;
        this.wallY3D[2] = yD3;
        this.wallY3D[3] = yD4;
        
        this.wallZ3D[0] = zD1;
        this.wallZ3D[1] = zD2;
        this.wallZ3D[2] = zD3;
        this.wallZ3D[3] = zD4;
    }
    
    public int[] getWallX() {
        return this.wallX;
    }
    
     public int[] getWallY() {
        return this.wallY;
    }
     
    public int getWallLength() {
        return this.wallLength;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    
    
    public double getHowFar() {
        return this.howFar;
    }

    public void splitWalls(){
        Wall splitedWalls[] = new Wall[4];
        
       Wall wallA = new Wall(this.wallX[0], this.xCU, this.xCC, this.xCL, this.wallY[0], this.yCU, this.yCC, this.yCL, this.xCL3D, this.yCL3D, this.zCL3D, this.xCU3D, this.yCU3D, this.zCU3D, this.wallX3D[2], this.wallY3D[2], this.wallZ3D[2], this.x3Dcenter, this.y3Dcenter, this.z3Dcenter);
       Wall wallB = new Wall(this.xCU, this.wallX[1], this.xCR, this.xCC, this.yCU, this.wallY[1], this.yCR, this.yCC, this.x3Dcenter, this.y3Dcenter, this.z3Dcenter, this.wallX3D[1], this.wallY3D[1], this.wallZ3D[1], this.xCU3D, this.yCU3D, this.zCU3D, this.xCR3D, this.yCR3D, this.zCR3D);
       Wall wallC = new Wall(this.xCC, this.xCR, this.wallX[2], this.xCD, this.yCC, this.yCR, this.wallY[2], this.yCD, this.xCD3D, this.yCD3D, this.zCD3D, this.xCR3D, this.yCR3D, this.zCR3D, this.x3Dcenter, this.y3Dcenter, this.z3Dcenter, this.wallX3D[3], this.wallY3D[3], this.wallZ3D[3]);
       Wall wallD = new Wall(this.xCL, this.xCC, this.xCD, this.wallX[3], this.yCL, this.yCC, this.yCD, this.wallY[3], this.wallX3D[0], this.wallY3D[0], this.wallZ3D[0], this.x3Dcenter, this.y3Dcenter, this.z3Dcenter, this.xCL3D, this.yCL3D, this.zCL3D, this.xCD3D, this.yCD3D, this.zCD3D);
        
       wallA.setColor(this.color);
       wallB.setColor(this.color);
       wallC.setColor(this.color);
       wallD.setColor(this.color);
       
       splitedWalls[0] = wallA;
       splitedWalls[1] = wallB;
       splitedWalls[2] = wallC;
       splitedWalls[3] = wallD;
        
        
        
        this.splitedWalls = splitedWalls;
    }
    
    public Wall[] getSplitedWalls(){
        
        return this.splitedWalls;
    }
    
}


/*
3D                  2D
3______ 2           1_______2
|       |           |       |
|       |           |       |
|_______|           |_______|
1       4           4       3

*/