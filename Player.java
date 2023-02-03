package snakes_and_ladders;
import java.util.*;
public class Player extends Board{
    int _Player_id;
    String _Player_Name;
    int Player_position;
    ArrayList<Integer>path;
    int [][]arr=new int[10][10];
    Player(int id,String name,int Player_position){
         path=new ArrayList<>();
        _Player_id=id;
        _Player_Name=name;
        this.Player_position=Player_position;

    }
    public void setPath(int a){
        path.add(a);
    }
    public void updatePosition(int position){
        Player_position=position;
        int count=0;
        for(int row=0;row<10;row++){
            for(int col=0;col<10;col++ ){
                count++;
               if(count==position){
                arr[row][col]=-1;
               }
               else{
                arr[row][col]=count;
               }
            }
            System.out.println();
        }
    }
    public int  getPosition(){
        return Player_position;
    }
}
