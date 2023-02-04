public class dice {
    private int no_of_dice;

    dice(int no_of_dice) {
        this.no_of_dice = no_of_dice;
    }

    public int rolldice() {
        return (int)(Math.random() * (6*no_of_dice - no_of_dice + 1)) + no_of_dice;
    }
}
