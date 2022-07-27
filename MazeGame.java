//package mazegame;
import java.util.Scanner;
public class MazeGame{
    int maze[][] = {{5,1,1,1,0,0,1,1,1,0},{1,0,0,1,1,1,1,0,1,1},{0,1,1,1,0,0,1,1,0,0},{0,0,0,0,0,0,1,1,0,1},{1,1,1,0,0,1,1,0,1,1},{0,0,1,0,0,1,0,0,0,1},{0,1,0,1,1,1,1,0,0,0},{1,1,1,1,0,1,0,0,1,0},{1,1,0,1,0,1,0,1,1,0},{0,0,0,0,0,1,1,1,1,9}};
    int row =0;
    int col = 0;
    public void displayMaze(){
        for(int i=0; i< maze.length;++i){
            for (int j=0; j<maze[0].length;++j){
                if(maze[i][j]==1){
                    System.out.print(" "+" ");}
                else if(maze[i][j]==0){
                    System.out.print("-"+" ");}
                else if(maze[i][j]==5){
                    System.out.print("x"+" ");}
                else if(maze[i][j]==9){
                    System.out.print("*"+" ");}
                }
            System.out.println();
        }
    }
    public void playGame(){
        Scanner input = new Scanner (System.in);
        char d;
        int flag=0;
        while (maze[9][9]!=5){
            System.out.println("Enter the direction: ");
            d= input.next().charAt(0);
            if(d == 's'){
                moveDown(row,col);
            }
            else if(d == 'w'){
                moveUp(row,col);
            }
            else if(d == 'a'){
                moveLeft(row,col);
            }
            else if(d == 'd'){
                moveRight(row,col);
            }
            else if (d == 'x'){
                System.out.println("Game Over!");
                flag =1;
                break;
            }
            else {
                System.out.println("Invalid input!");
            }
            displayMaze();
        }
        if (flag == 0){
            System.out.println("Congrats! You won the game!");
        }
    }
    public void moveUp(int r , int c ){
        if (r==0 || maze[r-1][c]==0)
            System.out.println("Invalid Input!");
        else{
            maze[r][c]=1;
            maze[r-1][c]= 5;
            row = r-1;
        }
    }
        public void moveDown(int r , int c ){
        if (r==9 || maze[r+1][c]==0){
            System.out.println("Invalid Input!");
        }
        else{
            maze[r][c]=1;
            maze[r+1][c]= 5;
            row = r+1;
        }
    }
        public void moveRight(int r , int c ){
        if (c==9 || maze[r][c+1]==0){
            System.out.println("Invalid Input!");
        }
        else{
            maze[r][c]=1;
            maze[r][c+1]= 5;
            col = c+1;
        }
    }
        public void moveLeft(int r , int c ){
        if (c==0 || maze[r][c-1]==0){
            System.out.println("Invalid Input!");
        }
        else{
            maze[r][c]=1;
            maze[r][c-1]= 5;
            col = c-1;
        }
    }
    public static void main(String[] args){
        MazeGame ob = new MazeGame();
        ob.displayMaze();
        ob.playGame();
    }
    }