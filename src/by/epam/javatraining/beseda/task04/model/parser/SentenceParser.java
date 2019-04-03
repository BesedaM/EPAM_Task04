package by.epam.javatraining.beseda.task04.model.parser;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import by.epam.javatraining.beseda.task04.model.entity.simplepart.SimpliestPart;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Beseda
 * @version 1.0 28/03/2019
 */
public class SentenceParser extends AbstractParser {

    private static SentenceParser instance = null;

    private Pattern isWord;
    private Pattern isNumber;
    private Pattern isWhiteSpace;

    private SentenceParser() {
        nextParser = SimpliestPartParser.getParser();
        isWord = Pattern.compile(IS_WORD);
        isNumber = Pattern.compile(IS_NUMBER);
        isWhiteSpace = Pattern.compile(IS_WHITESPACE);
    }

    public static SentenceParser getParser() {
        if (instance == null) {
            instance = new SentenceParser();
        }
        return instance;
    }

    @Override
    public List<LexicalPart> parse(String text) {
        List<LexicalPart> sentence = new ArrayList();
        if (text != null) {
            String[] parts = text.split(SENTENCE_PARSING);
            LexicalPart part;
            for (String part1 : parts) {
                if (isWhiteSpace.matcher(part1).matches()) {
                    if (part1.charAt(0) == IS_TAB) {
                        part = new SimpliestPart(part1.charAt(0),
                                SimpliestPart.Type.TABULATION);
                    } else {
                        part = new SimpliestPart(part1.charAt(0),
                                SimpliestPart.Type.SPACE);
                    }
                } else if (isNumber.matcher(part1).matches()) {
                    part = new LexicalContainer(nextParser.parse(part1),
                            LexicalContainer.Type.NUMBER);
                } else if (isWord.matcher(part1).matches()) {
                    part = new LexicalContainer(nextParser.parse(part1),
                            LexicalContainer.Type.WORD);
                } else {
                    part = new SimpliestPart(part1.charAt(0),
                            SimpliestPart.Type.PUNCTUATION);
                }
                sentence.add(part);
            }
        }
        return sentence;
    }

}
