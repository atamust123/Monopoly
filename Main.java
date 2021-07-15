
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void Show(Player player1, Player player2, Banker banker, Everything p[]) {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.print("Player 1");
        player1.Show(p);
        System.out.print("Player 2");
        player2.Show(p);
        System.out.print("Banker");
        banker.Show(p);
        player1.winnerControl(player2);
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        
        System.setOut(new PrintStream(new FileOutputStream("output.txt")));

        Everything p[] = new Everything[41];//it includes everything on the monopoly squares.
        ChanceList cl = new ChanceList();
        CommunityChestList ccl = new CommunityChestList();

        new FileReaders(p, cl, ccl);

        Scanner sc = new Scanner(new FileReader(args[0]));

        Player player1 = new Player();
        Player player2 = new Player();
        Banker banker = new Banker("Banker");
        while (sc.hasNext()) {
            String array[] = sc.nextLine().split(";");
            boolean bankrupt = false;
            if (array.length == 1) {//show command
                Show(player1, player2, banker, p);
            } else {
                int dice = Integer.parseInt(array[1]);
                if (player1.getName() == null) {//if player1 is not created
                    player1.setName(array[0]);
                    player1.setLocation(dice);
                    bankrupt = player1.Act(p, ccl, Integer.parseInt(array[1]), cl, player2, banker);//buy or pay rent

                } else if (player2.getName() == null && !(player1.getName().equals(array[0]))) {//if player2 is not created
                    player2.setName(array[0]);
                    player2.setLocation(dice);
                    bankrupt = player2.Act(p, ccl, Integer.parseInt(array[1]), cl, player1, banker);

                } else {
                    if (array[0].equals(player1.getName())) {//next line actions
                        if (player1.getLocation() == 11 && player1.getJailCounter() < 3) {//if player is in jail
                            player1.setJailCounter(player1.getJailCounter() + 1);
                            System.out.println(player1.getName() + "\t" + dice + "\t"
                                    + player1.getLocation() + "\t" + (int) player1.getMoney() + "\t"
                                    + (int) player2.getMoney() + "\t" + player1.getName()
                                    + " in jail (count=" + player1.getJailCounter() + ")");
                        }  else {
                            player1.setJailCounter(0);
                            if ((player1.getLocation() + dice) > 40
                                    && ((player1.getLocation() + dice) % 40) != 31) {
                                player1.setMoney(player1.getMoney() + 200);
                                banker.setMoney(banker.getMoney() - 200);
                            }
                            player1.setLocation(dice);
                            bankrupt = player1.Act(p, ccl, dice, cl, player2, banker);
                        }
                    } else {
                        if (player2.getLocation()==11 && player2.getJailCounter()<3) {
                            player2.setJailCounter(player2.getJailCounter() + 1);
                            System.out.println(player2.getName() + "\t" + dice + "\t"
                                    + player2.getLocation() + "\t" + (int) player1.getMoney() + "\t"
                                    + (int) player2.getMoney() + "\t" + player2.getName()
                                    + " in jail (count=" + player2.getJailCounter() + ")");

                        } else {
                            player2.setJailCounter(0);
                            if ((player2.getLocation() + dice) > 40
                                    && ((player2.getLocation() + dice) % 40) != 31) {
                                player2.setMoney(player2.getMoney() + 200);
                                banker.setMoney(banker.getMoney() - 200);
                            }
                            player2.setLocation(dice);
                            bankrupt = player2.Act(p, ccl, dice, cl, player1, banker);
                        }
                    }
                }
            }

            if (bankrupt == true || player1.getMoney() < 0 || player2.getMoney() < 0
                    || banker.getMoney() < 0 || sc.hasNext() == false) {
                Show(player1, player2, banker, p);
                return;
            }

        }

    }

}
