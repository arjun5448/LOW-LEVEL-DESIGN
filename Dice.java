package snakes_and_ladders;

interface DiceInterface{
    int roll_dice();
}
public class Dice implements DiceInterface{
    //we can also create for multipile dice by manipulating the min max value for example two dice it may be 2-12 and for 3 dice 3-18
     int min=1;
    int max=6; 
    public int roll_dice(){
       int output=(int) (Math.random()*(max-min+1)+min);   
       return output;
    }
}