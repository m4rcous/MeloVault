package melo_vault.presentation;

public class Text {
    public static void textCustom(String textLetters, int lateralPaddings, int verticalPaddings, char asciiLetterLateral, char asciiVerticalLater) {

        final var MAX_LATERAL_LENGTH = textLetters.length() + (lateralPaddings * 2) + 2;
        final var MAX_VERTICAL_LENGTH = (verticalPaddings * 2) + 3;

        int lateralPaddingCounter = 0;
        int verticalPaddingCounter = -1;

        int indexTitleLetter = 0;

        for (var row = 1; row <= MAX_VERTICAL_LENGTH; row++) {
            for (var column = 1; column <= MAX_LATERAL_LENGTH; column++) {
                if (row == 1 || row == MAX_VERTICAL_LENGTH)
                    System.out.print(asciiVerticalLater);

                else if (column == 1 || column == MAX_LATERAL_LENGTH)
                    System.out.print(asciiLetterLateral);

                else if (verticalPaddingCounter == verticalPaddings) {
                    if (lateralPaddingCounter >= lateralPaddings){
                        if (indexTitleLetter < textLetters.length())
                            System.out.print(textLetters.charAt(indexTitleLetter++));
                        else
                            System.out.print(" ");
                    } else {
                        System.out.print(" ");
                        lateralPaddingCounter++;
                    }
                } else
                    System.out.print(" ");
            }

            System.out.println();
            verticalPaddingCounter++;
        }
    }
}
