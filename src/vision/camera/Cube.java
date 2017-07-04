/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision.camera;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author maciej.pikulicki
 */
public class Cube {
    private double[] vectorX3D;
    private double[] vectorY3D;
    private double[] vectorZ3D;
    private int[] vectorX2D;
    private int[] vectorY2D;
    private int[] vectorZ2D;
    double d;
    double zoom;
    private Wall[] walls;
    private Wall[] splitedWalls;
    private Wall[] splitedWalls2;
    private Wall[] splitedWalls3;
   
    
    
    
    
    public Cube(double x, double y, double z, double width, double height, double depth){
        
        this.splitedWalls = new Wall[24];
        this.splitedWalls2 = new Wall[96];
        this.splitedWalls3 = new Wall[96*4];
        this.walls = new Wall[6];
        this.d = 355;
        this.zoom = this.d;
        this.vectorX3D = new double[8];
        this.vectorY3D = new double[8];
        this.vectorZ3D = new double[8];
        this.vectorX2D = new int[8];
        this.vectorY2D = new int[8];
        this.vectorZ2D = new int[8];
        this.vectorX3D[0] = x;
        this.vectorY3D[0] = y;       
        this.vectorZ3D[0] = z; 
        this.vectorX3D[1] = x;
        this.vectorY3D[1] = y+height;       
        this.vectorZ3D[1] = z;  
        this.vectorX3D[2] = x+width;
        this.vectorY3D[2] = y+height;       
        this.vectorZ3D[2] = z;  
        this.vectorX3D[3] = x+width;
        this.vectorY3D[3] = y;       
        this.vectorZ3D[3] = z; 
        //
        this.vectorX3D[4] = x+width;
        this.vectorY3D[4] = y;       
        this.vectorZ3D[4] = z+depth;  
        this.vectorX3D[5] = x;
        this.vectorY3D[5] = y;       
        this.vectorZ3D[5] = z+depth;
        this.vectorX3D[6] = x;
        this.vectorY3D[6] = y+height;       
        this.vectorZ3D[6] = z+depth;  
        this.vectorX3D[7] = x+width;
        this.vectorY3D[7] = y+height;       
        this.vectorZ3D[7] = z+depth;  
        
    }
    
    
    
    public void convertTo2D(){
        double zView[] = new double[8];
        for (int i = 0; i<=7; i++){
            if (this.vectorZ3D[i] <= 0.00001){
                zView[i] = 0.00001;
            } else {
            zView[i]=this.vectorZ3D[i];
            }
            
        }
        
        for (int i = 0; i<=7; i++){
      
            this.vectorX2D[i] = (int) ((this.vectorX3D[i] * this.d) / (zView[i]));
            this.vectorY2D[i] = (int) ((this.vectorY3D[i] * this.d) / (zView[i]));
            //this.vectorZ2D[i] = d;
            
            
           
        }  
    }
    
    public void zoomMinus () {
    this.d = this.d + 10;
    convertTo2D();
    }
    
        public void zoomPlus () {
    this.d = this.d - 10;
    convertTo2D();
    }
    
    public void goRight() {
        for (int i = 0; i<=7; i++)
        this.vectorX3D[i] = this.vectorX3D[i] + 1;
        convertTo2D();
    }
    
     public void goLeft() {
        for (int i = 0; i<=7; i++)
        this.vectorX3D[i] = this.vectorX3D[i] - 1;
        convertTo2D();
    }
    
    public void goUp() {
        for (int i = 0; i<=7; i++)
        this.vectorY3D[i] = this.vectorY3D[i] - 1;
        convertTo2D();
    }
    
    public void goDown() {
        for (int i = 0; i<=7; i++)
        this.vectorY3D[i] = this.vectorY3D[i] + 1;
        convertTo2D();
    }
    
    public void goBack() {
        for (int i = 0; i<=7; i++){
        this.vectorZ3D[i] = this.vectorZ3D[i] - 1;
        }
        convertTo2D();
    }
    
    public void goForward() {
        for (int i = 0; i<=7; i++){
        this.vectorZ3D[i] = this.vectorZ3D[i] + 1;
        }
        convertTo2D();
    }
    
    public void rotYRight() {
        
       double fi = Math.PI/18;
       double tempX3D;
       double tempZ3D;
        for (int i = 0; i<=7; i++){
        tempX3D = (this.vectorX3D[i]*Math.cos(fi))+(this.vectorZ3D[i]*Math.sin(fi));
        tempZ3D = (this.vectorX3D[i]*Math.sin(fi)*(-1))+(this.vectorZ3D[i]*Math.cos(fi));
        this.vectorX3D[i] = tempX3D;
        this.vectorZ3D[i] = tempZ3D;
        }
        convertTo2D(); 
    }
    
    public void rotYLeft() {
        
       double fi = (Math.PI*2) - Math.PI/18;
       double tempX3D;
       double tempZ3D;
        for (int i = 0; i<=7; i++){
        tempX3D = (this.vectorX3D[i]*cos(fi)+this.vectorZ3D[i]*sin(fi));
        tempZ3D = (this.vectorX3D[i]*sin(fi)*(-1)+this.vectorZ3D[i]*cos(fi));
        this.vectorX3D[i] = tempX3D;
        this.vectorZ3D[i] = tempZ3D;
        }
        convertTo2D(); 
    }
    
    public void rotZLeft() {
     double tempX3D;
     double tempY3D;
     double fi = Math.PI/18;
        for (int i = 0; i<=7; i++){
         tempX3D = (this.vectorX3D[i]*cos(fi)-this.vectorY3D[i]*sin(fi));
         tempY3D = (this.vectorX3D[i]*sin(fi)+this.vectorY3D[i]*cos(fi));
        this.vectorX3D[i] = tempX3D;
        this.vectorY3D[i] = tempY3D;
        }
     convertTo2D();
    }
    
    public void rotZRight() {
     double tempX3D;
     double tempY3D;
     double fi = (Math.PI*2) - Math.PI/18;
       for (int i = 0; i<=7; i++){
        tempX3D = (this.vectorX3D[i]*cos(fi)-this.vectorY3D[i]*sin(fi));
        tempY3D = (this.vectorX3D[i]*sin(fi)+this.vectorY3D[i]*cos(fi));
        this.vectorX3D[i] = tempX3D;
        this.vectorY3D[i] = tempY3D;
       }
     convertTo2D();
    }
    
    public void rotXUp() {
     double tempY3D;
     double tempZ3D;   
     double fi = Math.PI/18;
        for (int i = 0; i<=7; i++){
         tempY3D = (this.vectorY3D[i]*cos(fi)-this.vectorZ3D[i]*sin(fi));
         tempZ3D = (this.vectorY3D[i]*sin(fi)+this.vectorZ3D[i]*cos(fi));
        this.vectorZ3D[i] = tempZ3D;
        this.vectorY3D[i] = tempY3D;
        }
     convertTo2D();
    }
    
    public void rotXDown() {
     double tempY3D;
     double tempZ3D;   
     double fi = (Math.PI*2) - Math.PI/18;
        for (int i = 0; i<=7; i++){
         tempY3D = (this.vectorY3D[i]*cos(fi)-this.vectorZ3D[i]*sin(fi));
         tempZ3D = (this.vectorY3D[i]*sin(fi)+this.vectorZ3D[i]*cos(fi));
       this.vectorZ3D[i] = tempZ3D;
       this.vectorY3D[i] = tempY3D;
      }
     convertTo2D();
    }
    
    
    public double[] getVectorX3D(){
        return vectorX3D;
    }
    public double[] getVectorY3D(){
        return vectorY3D;
    }
    public double[] getVectorZ3D(){
        return vectorZ3D;
    }
    public int[] getVectorX2D(){
        return vectorX2D;
    }
    public int[] getVectorY2D(){
        return vectorY2D;
    }
    
    
    public void setWalls() {
        Wall wall1 = new Wall(this.vectorX2D[5],this.vectorX2D[4],this.vectorX2D[7],this.vectorX2D[6],
        this.vectorY2D[5],this.vectorY2D[4],this.vectorY2D[7],this.vectorY2D[6],
        this.vectorX3D[6], this.vectorY3D[6], this.vectorZ3D[6], this.vectorX3D[4], this.vectorY3D[4], this.vectorZ3D[4],
        this.vectorX3D[5], this.vectorY3D[5], this.vectorZ3D[5], this.vectorX3D[7], this.vectorY3D[7], this.vectorZ3D[7]);
        
        Wall wall2 = new Wall(this.vectorX2D[6],this.vectorX2D[7],this.vectorX2D[2],this.vectorX2D[1],
        this.vectorY2D[6],this.vectorY2D[7],this.vectorY2D[2],this.vectorY2D[1],
        this.vectorX3D[1], this.vectorY3D[1], this.vectorZ3D[1], this.vectorX3D[7], this.vectorY3D[7], this.vectorZ3D[7],
        this.vectorX3D[6], this.vectorY3D[6], this.vectorZ3D[6], this.vectorX3D[2], this.vectorY3D[2], this.vectorZ3D[2]);
        
        Wall wall3 = new Wall(this.vectorX2D[3],this.vectorX2D[4],this.vectorX2D[7],this.vectorX2D[2],
        this.vectorY2D[3],this.vectorY2D[4],this.vectorY2D[7],this.vectorY2D[2],
        this.vectorX3D[2], this.vectorY3D[2], this.vectorZ3D[2], this.vectorX3D[4], this.vectorY3D[4], this.vectorZ3D[4],
        this.vectorX3D[3], this.vectorY3D[3], this.vectorZ3D[3], this.vectorX3D[7], this.vectorY3D[7], this.vectorZ3D[7]);
        
        Wall wall4 = new Wall(this.vectorX2D[0],this.vectorX2D[5],this.vectorX2D[6],this.vectorX2D[1],
        this.vectorY2D[0],this.vectorY2D[5],this.vectorY2D[6],this.vectorY2D[1],
        this.vectorX3D[1], this.vectorY3D[1], this.vectorZ3D[1], this.vectorX3D[5], this.vectorY3D[5], this.vectorZ3D[5],
        this.vectorX3D[0], this.vectorY3D[0], this.vectorZ3D[0], this.vectorX3D[6], this.vectorY3D[6], this.vectorZ3D[6]);
        
        Wall wall5 = new Wall(this.vectorX2D[5],this.vectorX2D[4],this.vectorX2D[3],this.vectorX2D[0],
        this.vectorY2D[5],this.vectorY2D[4],this.vectorY2D[3],this.vectorY2D[0],
        this.vectorX3D[0], this.vectorY3D[0], this.vectorZ3D[0], this.vectorX3D[4], this.vectorY3D[4], this.vectorZ3D[4],
        this.vectorX3D[5], this.vectorY3D[5], this.vectorZ3D[5], this.vectorX3D[3], this.vectorY3D[3], this.vectorZ3D[3]);
        
        Wall wall6 = new Wall(this.vectorX2D[0],this.vectorX2D[3],this.vectorX2D[2],this.vectorX2D[1],
        this.vectorY2D[0],this.vectorY2D[3],this.vectorY2D[2],this.vectorY2D[1],
        this.vectorX3D[1], this.vectorY3D[1], this.vectorZ3D[1], this.vectorX3D[3], this.vectorY3D[3], this.vectorZ3D[3],
        this.vectorX3D[0], this.vectorY3D[0], this.vectorZ3D[0], this.vectorX3D[2], this.vectorY3D[2], this.vectorZ3D[2]);
        
        
        
              
        this.walls[0] = wall1;
        this.walls[1] = wall2;
        this.walls[2] = wall3;
        this.walls[3] = wall4;
        this.walls[4] = wall5;
        this.walls[5] = wall6;
    
        
    }
    
    public Wall[] getMainWalls(String color){
        setWalls();
        for (int i=0; i<6; i++){
            this.walls[i].setColor(color);
        }
        return this.walls;
    }
    
    
    
    
    
    
    
    public Wall[] getWalls(String color){
        setWalls();
        for (int i=0; i<6; i++){
            this.walls[i].setColor(color);
            this.walls[i].splitWalls();
        }
        for (int i=0; i<24; i=i+4){
            this.splitedWalls[i] = this.walls[i/4].getSplitedWalls()[0];
            this.splitedWalls[i+1] = this.walls[i/4].getSplitedWalls()[1];
            this.splitedWalls[i+2] = this.walls[i/4].getSplitedWalls()[2];
            this.splitedWalls[i+3] = this.walls[i/4].getSplitedWalls()[3];
            
        }
        for (int i=0; i<24; i++){
            this.splitedWalls[i].splitWalls();
        }
       // System.out.println("ALA");
        for (int i=0; i<96; i=i+4){
            this.splitedWalls2[i] = this.splitedWalls[i/4].getSplitedWalls()[0];
            this.splitedWalls2[i+1] = this.splitedWalls[i/4].getSplitedWalls()[1];
            this.splitedWalls2[i+2] = this.splitedWalls[i/4].getSplitedWalls()[2];
            this.splitedWalls2[i+3] = this.splitedWalls[i/4].getSplitedWalls()[3];
            
         
        }
        
        for (int i=0; i<96; i++){
            this.splitedWalls2[i].splitWalls();
        }
        for (int i=0; i<384; i=i+4){
            this.splitedWalls3[i] = this.splitedWalls2[i/4].getSplitedWalls()[0];
            this.splitedWalls3[i+1] = this.splitedWalls2[i/4].getSplitedWalls()[1];
            this.splitedWalls3[i+2] = this.splitedWalls2[i/4].getSplitedWalls()[2];
            this.splitedWalls3[i+3] = this.splitedWalls2[i/4].getSplitedWalls()[3];
            
        }
       return this.splitedWalls3;
    }
}
    



 /*
  5 ___________4
  /|          /|
0/_|________3/ |
|  |        |  |
|  |6_______|__|7
| /         | /
|/__________|/
1          2

    
    
*/