
public class Center extends Character {

    private int reboundingRating;

    public Center(String name, int overall, String teamName, int reboundingRating) {
        super(name, overall, teamName);
        this.reboundingRating = reboundingRating;
    }

    public int getReboundingRating() {
        return reboundingRating;
    }

    public void setReboundingRating(int reboundingRating) {
        this.reboundingRating = reboundingRating;
    }

    @Override
    public String getPosition() {
        return "Center";
    }

    @Override
    public void specialAbility() {
        System.out.println(
            getName() + " uses Paint Protector and blocks the shot!"
        );
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rebounding Rating: " + reboundingRating);
    }
}