package qa;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AlphabetPositionReplacement {

    public String replaceLetterWithPosition(String input) {

        StringBuilder stringBuilder = new StringBuilder();

        String[] inputSplit = input.toLowerCase().split("");

        for (int x = 0; x < inputSplit.length; x++) {

            int letterToPosition = this.getLetterPosition(inputSplit[x]);

            if (letterToPosition != 0) {

                stringBuilder.append(Integer.toString(letterToPosition));
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();

    }

    public int getLetterPosition(String input) {

        String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        AtomicInteger position = new AtomicInteger();

        IntStream.range(0, alphabets.length)
                .filter(index -> Character.isLetter(alphabets[index].charAt(0)))
                .filter(index -> input.equalsIgnoreCase(alphabets[index]))
                .forEach(index -> position.set(index + 1));

        return position.get();
    }

}
