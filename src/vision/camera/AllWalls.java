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
public class AllWalls {
    ArrayList<Wall> allWalls;
    ArrayList<Wall> mainWalls;
    
    public AllWalls (Cube c1, Cube c2, Cube c3, Cube c4){
        allWalls = new ArrayList<>();
        mainWalls = new ArrayList<>();
        for(int i = 0; i<384; i++){
            allWalls.add(c1.getWalls("green")[i]);
            allWalls.add(c2.getWalls("blue")[i]);
            allWalls.add(c3.getWalls("red")[i]);
            allWalls.add(c4.getWalls("yellow")[i]);
        }
        
        for(int i = 0; i<6; i++){
            mainWalls.add(c1.getMainWalls("green")[i]);
            mainWalls.add(c2.getMainWalls("blue")[i]);
            mainWalls.add(c3.getMainWalls("red")[i]);
            mainWalls.add(c4.getMainWalls("yellow")[i]);
        }
        
        
    }
    public ArrayList<Wall> getAllWalls(){
        return this.allWalls;
    }
    
    public ArrayList<Wall> getMainWalls(){
        return this.mainWalls;
    }
    
    
    public void sortAllWalls(){
        sortThisArray(this.mainWalls,0,23);
        sortThisArray(this.allWalls,0,1535);
        //System.out.println(allWalls.size());
    }
    
    public void sortThisArray(ArrayList<Wall> board, int x, int y) {
      
        int i,j;
        double v;
        Wall temp;

        i=x;
        j=y;
        v=board.get((x+y)/2).howFar;
        do {
            while ((board.get(i).howFar) > v )
                i++;
            while (v > (board.get(j).howFar))
                j--;
            if (i<=j) {
                temp=board.get(i);
                board.set(i,board.get(j));
                board.set(j,temp);
                i++;
                j--;
            }
        }
        while (i <= j);
            if (x<j)
                sortThisArray(board,x,j);
        if (i < y)
            sortThisArray(board,i,y);
    }
    
}
