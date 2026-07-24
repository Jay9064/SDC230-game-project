
public class SmallForward extends Character {

    private int athleticRating;

    public SmallForward(String name, int overall, String teamName,
            int athleticRating) {

        super(name, overall, teamName);
        this.athleticRating = athleticRating;
    }

    public int getAthleticRating() {
        return athleticRating;
    }

    public void setAthleticRating(int athleticRating) {
        this.athleticRating = athleticRating;
    }

    @Override
    public String getPosition() {
        return "Small Forward";
    }

    @Override
    public void specialAbility() {
        System.out.println(getName()
                + " uses Slasher and finishes a powerful dunk!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Athletic Rating: " + athleticRating);
    }
}