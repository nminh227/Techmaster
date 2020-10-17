package vn.techmaster;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Draw {
    public int[] numbers;

    public Draw(int[] numbers) throws IllegalArgumentException {
        // check if all numbers are unique
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                if (numbers[i] == numbers[j]) {
                    throw new IllegalArgumentException("All numbers have to be unique.");
                }
            }
        }
        this.numbers = numbers;
    }


    public static Draw generateRandomDraw(int numberOfEntries, int lowerLimit, int upperLimit) {
            // generate list that contains possible values
        List<Integer> possibleValues = new ArrayList<>();
        for (int i = lowerLimit; i <= upperLimit; i++) {
            possibleValues.add(i);
        }

        // fill draw with randomly picked values
        int[] numbers = new int[numberOfEntries];
        Random random = new Random();
        for (int i = 0; i < numberOfEntries; i++) {
            int randomIndex = random.nextInt(possibleValues.size());
            Integer pickedValue = possibleValues.get(randomIndex);
            possibleValues.remove(pickedValue);
            numbers[i] = pickedValue;
        }

        Arrays.sort(numbers);

        return new Draw(numbers);
    }

    // returns count of equal numbers
    public int compare(Draw draw) throws IllegalArgumentException {
        if (draw.numbers.length != numbers.length) {
            throw new IllegalArgumentException("The draws dont have the same length.");
        }

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == draw.numbers[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public String getStringRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            sb.append(", " + numbers[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}

