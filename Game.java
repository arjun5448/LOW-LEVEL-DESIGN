package snakes_and_ladders;
import java.util.*;
    public class Game{
      /*  static void  Display_Board(int[][]arr){
            for(int row=0;row<11;row++){
                for(int col=0;col<11;col++ ){
                    if(col<10){
                        System.out.print(1+"___");
                    }
                    else{
                        System.out.print(1);
                    }
                }
                System.out.println();
                if(row<10){
                    for(int col=0;col<11;col++ ){
                    if(col<10){
                        if(arr[row][col]==-1){
                            System.out.print("|"+"::"+" ");
                        }
                        else if(arr[row][col]==100){
                            System.out.print("|"+arr[row][col]+"");
                        }
                        else if(arr[row][col]!=0){
                            if(arr[row][col]<10){
                                System.out.print("| "+arr[row][col]+" ");
                            }
                            else{
                                System.out.print("|"+arr[row][col]+" ") ;
                            }
                        }
                        else{
                            System.out.print("|   ");
                        }
                    }
                    else{
                        System.out.print("|   ");
                    }
                    }
                System.out.println();
               }     
            }
        }*/
        public static void main(String[] args){
            Scanner _input=new Scanner(System.in);
            System.out.println("NO OF PLAYERS :  ");
            int no_of_players=_input.nextInt();
            Deque<Player> player_queue = new ArrayDeque<>();

//Taking Players_detaials

            for(int i=1;i<=no_of_players;i++){
                System.out.println("enter id of player_ and Name  "+i+" : ");
                int _id=_input.nextInt();
                String _name=_input.nextLine();
                Player player=new Player(_id,_name,0);
                System.out.println("welcome  "+_name);
                player_queue.add(player);    
            }
//we Are Going To STARTing Game
            System.out.println();
            System.out.println("LETS'S STARTT THE GAME");
            System.out.println();
            int count_6=0;
            Board object_of_Board=new Board();
            Dice obj_of_Dice=new Dice();
            boolean Continue=true;
            while(true && Continue){
                Player cur_player=player_queue.poll();
                System.out.println("Current Position of "+cur_player._Player_Name+" is : "+cur_player.getPosition());
                display.Display_Board(cur_player.arr);
                System.out.println();
                System.out.println("now "+cur_player._Player_Name+" turn");
                System.out.println();
                System.out.println("press 1 to roll the dice  or else press -1 to Stop the Game");
                int option=_input.nextInt();
                if(option==1){
                    int turn_result=obj_of_Dice.roll_dice();
                    System.out.println(cur_player._Player_Name+" you Got "+turn_result);
                    int result=turn_result+cur_player.getPosition();
// Here we are verifiying the whether player has goted an ladder or else bited By A snake
                   if(result<=100) {
// it is case when a player got 6 he has the chance to roll the dice again if he got 6 in third time his actual position is tend to preveious position
                    if(turn_result==6 && count_6<2){
                        player_queue.offerFirst(cur_player);
                        count_6+=1;
                    }
                    else{
                        count_6=0;
                        if(result!=100){
                            player_queue.add(cur_player);
                        }
                    }
                    int Board_reuslt=object_of_Board.Check_Ladders_and_Snakes(result, cur_player._Player_Name);
                    if(Board_reuslt==0){
                        cur_player.updatePosition(result);
                        cur_player.setPath(result);
                    }
                    else{
                        cur_player.updatePosition(Board_reuslt);
                        cur_player.setPath(result);
                    }

                   }
                   else{
                    player_queue.add(cur_player);
                   }
                }
// when we want to Stop the game instant 
                else if(option==-1){
                    player_queue.add(cur_player);
                    for(int i=0;i<no_of_players;i++){
                        Player presentplayer=player_queue.poll();
                        System.out.println("currentpositon of "+presentplayer._Player_Name+" is:  "+presentplayer.getPosition());
                        display.Display_Board(cur_player.arr);
                        System.out.println("The path traveled by the "+presentplayer._Player_Name+" is :");
                        System.out.println(presentplayer.path);
                    }
                    break;
                }
                else{
                    System.out.println("Enter proper option");
                        player_queue.offerFirst(cur_player);
                }

                if(cur_player.getPosition()==100){
                    display.Display_Board(cur_player.arr);
                    System.out.println(" The path traveled by "+cur_player._Player_Name+"is :");
                    System.out.println(cur_player.path);
                    Continue=false;
                    System.out.println("Winner is "+cur_player._Player_Name);
                    System.out.println();
                    no_of_players--;
                    if(no_of_players>1){
                    System.out.println("IF You Wan  To continue press 1 orelse  to stop press 0");
                    int con=_input.nextInt();
                    if(con==1){
                        Continue=true;
                    }
                }
            }
        
    
        }
        }
    }
    
