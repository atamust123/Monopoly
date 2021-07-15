
//think about birthday and grand night hotel
public class CommunityChestList {

    private String item[];
    private int counter = 0;

    public CommunityChestList() {
        this.item = new String[11];
    }

    public void Action(Player player, Banker banker, int dice, Player player2) {
        double player1Money, player2Money;
        switch (this.counter++) {
            case 0://advance to go and collect
                player.setStartLocation();
                player.setMoney(player.getMoney() + 200);
                banker.setMoney(banker.getMoney() - 200);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }

                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Advance to Go (Collect $200)");
                break;
            case 1:
                player.setMoney(player.getMoney() + 75);
                banker.setMoney(banker.getMoney() - 75);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "Bank error in your favor - collect $75");
                break;
            case 2:
                player.setMoney(player.getMoney() - 50);
                banker.setMoney(banker.getMoney() + 50);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "Doctor's fees - Pay $50");
                break;
            case 3:
                player.setMoney(player.getMoney() + 10);
                player2.setMoney(player2.getMoney() - 10);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "It is your birthday Collect $10 from each player");
                break;
            case 4:
                player.setMoney(player.getMoney() + 50);
                player2.setMoney(player2.getMoney() - 50);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "Grand Opera Night - collect $50 from every player for opening night seats");
                break;
            case 5:
                player.setMoney(player.getMoney() + 20);
                banker.setMoney(banker.getMoney() - 20);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "Income Tax refund - collect $20");
                break;
            case 6:
                player.setMoney(player.getMoney() + 100);
                banker.setMoney(banker.getMoney() - 100);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "Life Insurance Matures");
                break;
            case 7:
                player.setMoney(player.getMoney() - 100);
                banker.setMoney(banker.getMoney() + 100);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "Pay Hospital Fees - collect $100");
                break;
            case 8:
                player.setMoney(player.getMoney() - 50);
                banker.setMoney(banker.getMoney() + 50);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "Pay School Fees of $100");
                break;
            case 9:
                player.setMoney(player.getMoney() + 100);
                banker.setMoney(banker.getMoney() - 100);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "You inherit $100");
                break;
            case 10:
                player.setMoney(player.getMoney() + 50);
                banker.setMoney(banker.getMoney() - 50);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                System.out.print(player.getName() + "\t" + dice + "\t"
                        + player.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(player.getName() + " draw Community Chest "
                        + "From sale of stock you get $50");
                break;
            default:
                break;
        }
        
    }

    public String getItem() {
        int i = counter;
        counter = (counter + 1) % 6;
        return item[i];
    }

    public void setItem(String item) {
        this.item[counter++] = item;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
