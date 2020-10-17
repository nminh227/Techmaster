package vn.techmaster;

public class LotteryGame {

    private final int drawSize;
    private final int drawLowerLimit;
    private final int drawUpperLimit;

    public LotteryGame(int drawSize, int drawLowerLimit, int drawUpperLimit) {
        this.drawSize = drawSize;
        this.drawLowerLimit = drawLowerLimit;
        this.drawUpperLimit = drawUpperLimit;
    }

    public void play() {
        // generate new random draw
        Draw draw = Draw.generateRandomDraw(drawSize, drawLowerLimit, drawUpperLimit);

        // let the user guess
        Draw userDraw = guess();

        // compare the draws and print result
        int rightNumbers = draw.compare(userDraw);
        System.out.println("Your guess: " + userDraw.getStringRepresentation());
        System.out.println("Draw:       " + draw.getStringRepresentation());
        System.out.println("You guessed " + rightNumbers + " right!");
        int prize = 0;
        if (rightNumbers > 0) {
            prize = 100 * (2 * rightNumbers);
        }
        System.out.println("Your prize is $" + prize);
    }

    public Draw guess() {
        int numbers[] = new int[drawSize];
        while (true) {
            try {
                for (int i = 0; i < drawSize; i++) {
                    numbers[i] = Main.warn("Number " + (i+1) + ": ");
                }
                System.out.println();
                return new Draw(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("The numbers have to be unique\n");
            }
        }
    }

    public String getExplanationString() {
        StringBuilder sb = new StringBuilder();
        sb.append("You have to guess the numbers of a lottery draw.\n");
        sb.append("A draw consists of 6 different numbers.\n");
        sb.append("Each number is in a range between 1 and 49.\n");
        sb.append("The more numbers you guess right, the luckier you can be!\n");
        return sb.toString();
    }
}