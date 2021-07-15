/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AtakanAYYILDIZ
 */
public class Land extends Property {

    public Land(String name, int id, double cost) {
        super(name, id, cost);
    }

    @Override
    public int CalculateRent(int dice,Player player) {
        double rent = 0;
        if (this.getCost() < 2001) {
            rent = this.getCost() * 4 / 10;
        } else if (this.getCost() < 3001) {
            rent = this.getCost() * 3 / 10;
        } else if (this.getCost() < 4001) {
            rent = this.getCost() * 35 / 100;
        }
        this.getOwner().setMoney(this.getOwner().getMoney() + rent);//rent paid
        player.setMoney(player.getMoney() - rent);//set money after rent paid 
        return (int)rent;
    }

}
