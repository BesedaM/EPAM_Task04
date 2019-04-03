package by.epam.javatraining.beseda.task04.util;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.parser.AbstractParser;
import by.epam.javatraining.beseda.task04.model.parser.ParagraphParser;
import by.epam.javatraining.beseda.task04.model.parser.SentenceParser;
import by.epam.javatraining.beseda.task04.model.parser.SimpliestPartParser;
import by.epam.javatraining.beseda.task04.model.parser.TextParser;

/**
 *
 * @author Beseda
 * @version 1.0 31/03/2019
 */
public class ParserCreator {

    public static LexicalContainer invokeParser(String text, LexicalContainer.Type type) {
        AbstractParser parser;
        switch (type) {
            case TEXT:
                parser = TextParser.getParser();
                break;
            case PARAGRAPH:
                parser = ParagraphParser.getParser();
                break;
            case SENTENCE:
                parser = SentenceParser.getParser();
                break;
            default:
                parser = SimpliestPartParser.getParser();
                break;
        }
        return new LexicalContainer(parser.parse(text),
                type);
    }

}
