
public class Player extends Users {

    private int location = 1;//startIndex
    private int railroadCounter = 0;//rail road counter
    private int jailCounter = 0;
    private boolean isInJail = false;

    public Player() {
        super(15000);
    }

    public boolean Act(Everything p[], CommunityChestList ccl, int dice,
            ChanceList cl, Player player2, Banker banker) {
        double player2Money, player1Money;
        boolean bankrupt = false;
        if (p[this.getLocation()] instanceof Property) {
            if (((Property) p[this.getLocation()]).isOwned() == false
                    && ((Property) p[this.getLocation()]).getCost() <= this.getMoney()) {//player will but this

                ((Property) p[this.getLocation()]).setOwned(true);
                ((Property) p[this.getLocation()]).setOwner(this);
                this.setMoney(this.getMoney() - ((Property) p[this.getLocation()]).getCost());
                banker.setMoney(banker.getMoney() + ((Property) p[this.getLocation()]).getCost());
                if (p[this.getLocation()] instanceof RailRoad) {//count up railroad number
                    this.railroadCounter++;
                }
                if (this.getName().equals("Player 2")) {
                    player2Money = this.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = this.getMoney();
                }

                System.out.print(this.getName() + "\t" + dice + "\t"
                        + this.getLocation() + "\t" + (int) player1Money + "\t");

                if (player2.getName() == null) {
                    System.out.println("15000\t" + this.getName()
                            + " bought " + p[this.getLocation()].getName());
                } else {
                    System.out.println((int) player2Money + "\t" + this.getName()
                            + " bought " + p[this.getLocation()].getName());
                }

            } else if (((Property) p[this.getLocation()]).isOwned()
                    && ((Property) p[this.getLocation()]).getOwner().getName().equals(this.getName())) {//if the player has own land
                if (this.getName().equals("Player 2")) {
                    player2Money = this.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = this.getMoney();
                }
                System.out.print(this.getName() + "\t" + dice + "\t"
                        + this.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(this.getName()
                        + " has " + p[this.location].getName());
            } else if (((Property) p[this.getLocation()]).isOwned() == false) {//if there is no money to buy or rent
                if (this.getName().equals("Player 2")) {
                    player2Money = this.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = this.getMoney();
                }
                System.out.print(this.getName() + "\t" + dice + "\t"
                        + this.getLocation() + "\t" + (int) player1Money
                        + "\t" + (int) player2Money + "\t");
                System.out.println(this.getName() + " goes bankrupt");
                return true;
            } else if (((Property) p[this.getLocation()]).getOwner().getName().equals(player2.getName())) {//pay rent 
                int rent = 0;
                if (p[this.getLocation()] instanceof Land) {//if porperty is a land
                    Land l = ((Land) p[this.getLocation()]);
                    rent = l.CalculateRent(dice, this);

                } else if (p[this.getLocation()] instanceof Company) { //else if property is a company
                    Company c = ((Company) p[this.getLocation()]);
                    rent = c.CalculateRent(dice, this);

                } else if (p[this.getLocation()] instanceof RailRoad) {//else if property is a rairoad
                    RailRoad r = ((RailRoad) p[this.getLocation()]);
                    rent = r.CalculateRent(dice, this);
                }
                if (this.getMoney() < 0) {
                    this.setMoney(this.getMoney() + rent);

                    bankrupt = true;
                }
                if (this.getName().equals("Player 2")) {
                    player2Money = this.getMoney();
                    player1Money = player2.getMoney();
                } else {
                    player2Money = player2.getMoney();
                    player1Money = this.getMoney();
                }

                if (bankrupt==false) {
                    System.out.print(this.getName() + "\t" + dice + "\t"
                            + this.getLocation() + "\t" + (int) player1Money + "\t");

                    if (player2.getName() == null) {
                        System.out.println("15000\t" + this.getName()
                                + " bought " + p[this.getLocation()].getName());
                    } else {
                        System.out.println((int) player2Money + "\t" + this.getName()
                                + " paid rent for " + p[this.getLocation()].getName());
                    }
                }else{
                    System.out.print(this.getName() + "\t" + dice + "\t"
                            + this.getLocation() + "\t" + (int) player1Money + "\t");
                    if (player2.getName() == null) {
                        System.out.println("15000\t" + this.getName()
                                + " goes bankrupt");
                    } else {
                        System.out.println((int) player2Money + "\t" + this.getName()
                                + " goes bankrupt");
                    }
                }

            }
        } else {//it is not property

            switch (p[this.getLocation()].getId()) {
                case 1://GO
                    if (this.getName().equals("Player 2")) {
                        player2Money = this.getMoney();
                        player1Money = player2.getMoney();
                    } else {
                        player2Money = player2.getMoney();
                        player1Money = this.getMoney();
                    }
                    System.out.print(this.getName() + "\t" + dice + "\t"
                            + this.getLocation() + "\t" + (int) player1Money
                            + "\t" + (int) player2Money + "\t");
                    System.out.println(this.getName()
                            + " is in GO square");
                    break;

                case 18://community chest
                case 3:
                case 34:
                    ccl.Action(this, banker, dice, player2);
                    break;

                case 5://tax
                case 39://super tax
                    this.setMoney(this.getMoney() - 100);
                    banker.setMoney(banker.getMoney() + 100);
                    if (this.getName().equals("Player 2")) {
                        player2Money = this.getMoney();
                        player1Money = player2.getMoney();
                    } else {
                        player2Money = player2.getMoney();
                        player1Money = this.getMoney();
                    }
                    System.out.print(this.getName() + "\t" + dice + "\t"
                            + this.getLocation() + "\t" + (int) player1Money
                            + "\t" + (int) player2Money + "\t");
                    System.out.println(this.getName()
                            + " paid Tax");
                    break;

                case 31://go to jail
                    this.setStartLocation();//go start point then move 10 point
                    this.setLocation(10);
                    this.isInJail = true;
                    if (this.getName().equals("Player 2")) {
                        player2Money = this.getMoney();
                        player1Money = player2.getMoney();
                    } else {
                        player2Money = player2.getMoney();
                        player1Money = this.getMoney();
                    }
                    System.out.print(this.getName() + "\t" + dice + "\t"
                            + this.getLocation() + "\t" + (int) player1Money
                            + "\t" + (int) player2Money + "\t");
                    System.out.println(this.getName()
                            + " went to jail");
                    break;

                case 11://jail

                    if (this.jailCounter <= 3) {
                        this.setStartLocation();//go start point then move 10 point
                        this.setLocation(10);
                    } else {
                        this.isInJail = false;
                        this.jailCounter = 0;
                    }
                    if (this.getName().equals("Player 2")) {
                        player2Money = this.getMoney();
                        player1Money = player2.getMoney();
                    } else {
                        player2Money = player2.getMoney();
                        player1Money = this.getMoney();
                    }
                    System.out.print(this.getName() + "\t" + dice + "\t"
                            + this.getLocation() + "\t" + (int) player1Money
                            + "\t" + (int) player2Money + "\t");
                    System.out.println(this.getName()
                            + " went to jail");
                    break;

                case 21://free parking
                    if (this.getName().equals("Player 2")) {
                        player2Money = this.getMoney();
                        player1Money = player2.getMoney();
                    } else {
                        player2Money = player2.getMoney();
                        player1Money = this.getMoney();
                    }
                    System.out.print(this.getName() + "\t" + dice + "\t"
                            + this.getLocation() + "\t" + (int) player1Money
                            + "\t" + (int) player2Money + "\t");
                    System.out.println(this.getName()
                            + " is in Free Parking");
                    break;

                case 8://chance
                case 23:
                case 37:
                    return cl.Action(p, this, ccl, banker, dice, player2);
                default:
                    break;
            }
        }
        return bankrupt;
    }

    public int getJailCounter() {
        return jailCounter;
    }

    public void setJailCounter(int jailCounter) {
        this.jailCounter = jailCounter;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location += location;
        if (this.location > 40) {
            this.location = (this.location) % 40;
        }
    }

    public void setStartLocation() {
        this.location = 1;
    }

    public int getRailroadCounter() {
        return railroadCounter;
    }

    public void setRailroadCounter(int railroadCounter) {
        this.railroadCounter = railroadCounter;
    }

}
