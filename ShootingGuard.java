
public class ShootingGuard extends Character {

    private int shootingRating;

    public ShootingGuard(String name, int overall, String teamName,
            int shootingRating) {

        super(name, overall, teamName);
        this.shootingRating = shootingRating;
    }

    public int getShootingRating() {
        return shootingRating;
    }

    public void setShootingRating(int shootingRating) {
        this.shootingRating = shootingRating;
    }

    @Override
    public String getPosition() {
        return "Shooting Guard";
    }

    @Override
    public void specialAbility() {
        System.out.println(getName()
                + " uses Sharpshooter and hits a deep three-pointer!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Shooting Rating: " + shootingRating);
    }
}
