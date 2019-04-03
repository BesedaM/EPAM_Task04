package by.epam.javatraining.beseda.task04.model.parser;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beseda
 * @version 1.0 29/03/2019
 */
public class ParagraphParser extends AbstractParser {

    private static ParagraphParser instance = null;

    private ParagraphParser() {
        nextParser = SentenceParser.getParser();
    }

    public static ParagraphParser getParser() {
        if (instance == null) {
            instance = new ParagraphParser();
        }
        return instance;
    }

    @Override
    public List<LexicalPart> parse(String text) {
        List<LexicalPart> paragraph = new ArrayList<>();
        if (text != null) {
            String[] parts = text.split(PARAGRAPH_PARSING);
            for (String part1 : parts) {
                //invoke next parser
                paragraph.add(new LexicalContainer(nextParser.parse(part1),
                        LexicalContainer.Type.SENTENCE));
            }
        }
        return paragraph;

    }

}
