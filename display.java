package snakes_and_ladders;

public class display {
    public static void  Display_Board(int[][]arr){
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
                        System.out.print("| "+"#"+" ");
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
    }
}

