
public class Banker extends Users {

    public Banker(String name) {
        super(100000);
    }

    @Override
    public void Show(Everything[] p) {
        System.out.println("\t" + (int) this.getMoney());
    }

}
