import java.util.Scanner;
public class BattleShipClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        boolean done = false;
        System.out.println("Welcome to BattleShip!");
        while(!done){
            System.out.println("Would you like to add a ship [a], see the board [b], play, [p], or quit[q]");
            String y = scan.nextLine();
            if(y.equalsIgnoreCase("a")){
                System.out.println(board);
                if (board.addShip(InputHelper.getRangedInt(scan,"What row would you like to place the start of your ship at [1-10]?", 1,10)-1,InputHelper.getRangedInt(scan,"What column would you like to place the start of your ship at [1-10]?", 1,10)-1, InputHelper.getRangedInt(scan,"How long would you like your ship [3-4]?", 3,4),InputHelper.getYNConfirm(scan, "Would you like your ship to be horizontal [Y/N]"))){
                    System.out.println("New Ship Added");
                } else{
                    System.out.println("You Can't Put A Ship There");
                }
            } else if (y.equalsIgnoreCase("b")){
                System.out.println(board);
            }  else if (y.equalsIgnoreCase("p")){
                if(board.foundShip(3) && board.foundShip(4)){
                    System.out.println("OK, lets play!");
                    done = true;
                } else{
                    System.out.println("You must have a ship of length 3 and 4 before you can play");
                }
            }  else if (y.equalsIgnoreCase("q")){
                System.exit(0);
            } else {
                System.out.println("Invalid Input - Please Try Again");
            }
        }
        boolean done1 = true;
        int x;
        while (done1){
            System.out.println("Press 's' to shoot at a square, 'b' to see the board and 'q' to quit");
            String z = scan.nextLine();

            if(z.equalsIgnoreCase("q")){
                System.exit(0);
            } else if(z.equalsIgnoreCase("b")){
                System.out.println(board);
            } else if (z.equalsIgnoreCase("s")){
                x = board.shoot(InputHelper.getRangedInt(scan,"What row would you like to shoot at [1-10]", 1,10)-1,InputHelper.getRangedInt(scan,"What column would you like to shoot at [1-10]",1,10)-1);
                if (x == 0){
                    System.out.println("Miss");
                } else if (x == 1){
                    System.out.println("Hit");
                    if(board.gameOver()){
                        done1 = false;
                        System.out.println("You sunk all my battleships");
                    }
                } else if(x ==2){
                    System.out.println("That spot was already guessed");
                } else{
                    System.out.println("Invalid Shot");
                }
            }
        }

    }
}