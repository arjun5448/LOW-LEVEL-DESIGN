package snakes_and_ladders;
import java.util.*;
    public class Board{
      private static HashMap<Integer,Integer>Ladder;
      private static HashMap<Integer,Integer>Snakes;
        Board(){
            Ladder=new HashMap<>();
            Snakes=new HashMap<>();
            //SETTING LOCATIONS OF LADDERS IN BOARD
            Ladder.put(4,14);
            Ladder.put(9,31);
            Ladder.put(28,84);
            Ladder.put(21,42);
            Ladder.put(51,67);
            Ladder.put(72,91);
            Ladder.put(80,98);
            //setting locations of Snakes in our Board
            Snakes.put(17,7);
            Snakes.put(54,34);
            Snakes.put(64,60);
            Snakes.put(62,19);
            Snakes.put(87,36);
            Snakes.put(95,75);
            Snakes.put(98,79);
            Snakes.put(93,38);
            
        }
        public int Check_Ladders_and_Snakes(int Currentposition, String Nam){
            if(Ladder.containsKey(Currentposition)){
                System.out.println(Nam+"  Got Ladder ");
                return Ladder.get(Currentposition);
            }
            if(Snakes.containsKey(Currentposition)){
                System.out.println(Nam+" Bited By a Snake");
                return Snakes.get(Currentposition);
            }
            return 0;
        }
    
    }
