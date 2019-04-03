package by.epam.javatraining.beseda.task04.model.logic.word;

/**
 *
 * @author Beseda
 * @version 1.0 02/04/2019
 */
public class LetterTypeDefiner {

    public static final char REGION_START = 65;
    public static final char REGION_LENGTH = 90 - 64;
    public static final int REGION_SHIFT = 97 - 65;

    public static final char VOWEL_A = 65;
    public static final char VOWEL_E = 69;
    public static final char VOWEL_I = 73;
    public static final char VOWEL_O = 79;
    public static final char VOWEL_U = 85;
    public static final char VOWEL_Y = 89;

    public static boolean charIsLetter(char symbol) {
        return symbol >= REGION_START && symbol <= REGION_START + REGION_LENGTH
                || symbol >= REGION_START + REGION_SHIFT
                && symbol <= REGION_START + REGION_LENGTH + REGION_SHIFT;
    }

    public static boolean charIsVowel(char symbol) {
        switch (symbol) {
            case VOWEL_A:
            case VOWEL_A + REGION_SHIFT:
            case VOWEL_E:
            case VOWEL_E + REGION_SHIFT:
            case VOWEL_I:
            case VOWEL_I + REGION_SHIFT:
            case VOWEL_O:
            case VOWEL_O + REGION_SHIFT:
            case VOWEL_U:
            case VOWEL_U + REGION_SHIFT:
            case VOWEL_Y:
            case VOWEL_Y + REGION_SHIFT:
                return true;
            default:
                return false;
        }
    }

    public static boolean charIsConsonant(char symbol) {
        return charIsLetter(symbol) && !charIsVowel(symbol);
    }
}
