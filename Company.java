/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AtakanAYYILDIZ
 */
public class Company extends Property {

    public Company(String name, int id, double cost) {
        super(name, id, cost);
    }

    @Override
    public int CalculateRent(int dice, Player player) {
        double rent = 4 * dice;
        this.getOwner().setMoney(this.getOwner().getMoney() + rent);
        player.setMoney(player.getMoney() - rent);//set money after rent paid
        return (int)rent;
    }

}
