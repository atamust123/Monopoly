/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AtakanAYYILDIZ
 */
public class ChanceList {

    private String item[];
    private int counter = 0;

    public ChanceList() {
        this.item = new String[6];
    }

    public boolean Action(Everything p[], Player player,CommunityChestList ccl
            ,Banker banker, int dice, Player player2) {
        double player1Money, player2Money;
        switch (this.counter++) {
            case 0:
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
                System.out.println(player.getName()
                        + " advance to go (collect 200)");
                break;
            case 1:
                //27 leicester
                player.setStartLocation();//first come start point
                player.setLocation(26);//then go leicester
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }

                if (((Property) p[player.getLocation()]).isOwned()
                        && ((Property) p[player.getLocation()]).getOwner().getName().equals(player.getName())) {
                    System.out.print(player.getName() + "\t" + dice + "\t"
                            + player.getLocation() + "\t" + (int) player1Money
                            + "\t" + (int) player2Money + "\t");
                    System.out.println(player.getName()
                            + " draw Advance to Leicester Square and " + player.getName() + " has Leicester Square");
                } else if (((Property) p[player.getLocation()]).isOwned()//pay rent
                        && ((Property) p[player.getLocation()]).getOwner().getName().equals(player2.getName())) {
                    if (player.getMoney() < 780) {
                        return true;
                    }
                    player.setMoney(player.getMoney() - 780);
                    player2.setMoney(player2.getMoney() + 780);
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
                    System.out.println(player.getName()
                            + " draw Advance to Leicester Square and " + player.getName() + " paid rent for Leicester Square");
                } else if (((Property) p[player.getLocation()]).isOwned() == false//player will buy
                        && ((Property) p[player.getLocation()]).getCost() <= player.getMoney()) {
                    player.setMoney(player.getMoney() - 2600);
                    banker.setMoney(banker.getMoney() + 2600);
                    ((Property) p[player.getLocation()]).setOwned(true);
                    ((Property) p[player.getLocation()]).setOwner(player);
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
                    System.out.println(player.getName()
                            + " draw Advance to Leicester Square and " + player.getName() + " bought Leicester Square");
                }
                break;
            case 2:
                player.setLocation(-3);
                if (player.getName().equals("Player 2")) {
                    player2Money = player.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = player.getMoney();
                }
                if ((p[player.getLocation()] instanceof Property)==false){//if it is not property
                    player.Act(p, ccl, dice, this, player2, banker);
                }
                else if (((Property) p[player.getLocation()]).isOwned()//if player has been his own property
                        && ((Property) p[player.getLocation()]).getOwner().getName().equals(player.getName())) {
                    System.out.print(player.getName() + "\t" + dice + "\t"
                            + player.getLocation() + "\t" + (int) player1Money
                            + "\t" + (int) player2Money + "\t");
                    System.out.println(player.getName()
                            + " draw Go back 3 spaces "+player.getName()+" has  Vine Street");
                } else if (((Property) p[player.getLocation()]).isOwned()//pay rent
                        && ((Property) p[player.getLocation()]).getOwner().getName().equals(player2.getName())) {
                    if (player.getMoney() < 800) {
                        return true;
                    }
                    player.setMoney(player.getMoney() - 800);
                    player2.setMoney(player2.getMoney() + 800);
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
                    System.out.println(player.getName()
                            + " draw Go back 3 spaces "+player.getName()+" paid rent for Vine Street");
                }else if (((Property) p[player.getLocation()]).isOwned() == false//player will buy
                        && ((Property) p[player.getLocation()]).getCost() <= player.getMoney()){
                    player.setMoney(player.getMoney()-2000);
                    banker.setMoney(banker.getMoney()+2000);
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
                    System.out.println(player.getName()
                            + " draw Go back 3 spaces "+player.getName()+" bought Vine Street");
                }else {//bankrupt
                    return true;
                }

                break;
            case 3:
                player.setMoney(player.getMoney() - 15);
                banker.setMoney(banker.getMoney() + 15);
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
                System.out.println(player.getName()
                        + " draw Pay poor tax of $15");
                break;
            case 4:
                player.setMoney(player.getMoney() + 150);
                banker.setMoney(banker.getMoney() - 150);
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
                System.out.println(player.getName()
                        + " draw Your building loan matures - collect $150");
                break;
            case 5:
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
                System.out.println(player.getName()
                        + " draw You have won a crossword competition - collect $100");
                break;
            default:
                break;
        }
        return false;
    }

    public String getItem() {
        int i = counter;
        counter = (counter + 1) % 6;
        return item[counter++];
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
