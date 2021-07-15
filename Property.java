
public class Property extends Everything {

    private double cost;
    private boolean owned = false;
    private Player owner;

    public Property(String name, int id, double cost) {
        super(name, id);
        this.cost = cost;
    }

    public int CalculateRent(int dice, Player player) {
        return 0;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

}
