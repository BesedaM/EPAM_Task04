package by.epam.javatraining.beseda.task04.model.parser;

import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import by.epam.javatraining.beseda.task04.model.entity.simplepart.SimpliestPart;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Beseda
 * @version 1.0 01/04/2019
 */
public class SimpliestPartParser extends AbstractParser {

    private static SimpliestPartParser instance = null;

    private SimpliestPartParser() {
    }

    public static SimpliestPartParser getParser() {
        if (instance == null) {
            instance = new SimpliestPartParser();
        }
        return instance;
    }

    @Override
    public List<LexicalPart> parse(String text) {
        List<LexicalPart> symbols = new ArrayList<>();
        if (text != null) {
            String type;
            if (Pattern.compile(IS_NUMBER).matcher(text).matches()) {
                type = "NUMBER";
            } else {
                type = "LETTER";
            }
            for (int i = 0; i < text.length(); i++) {
                symbols.add(new SimpliestPart(text.charAt(i),
                        SimpliestPart.Type.valueOf(type)));
            }
        }
        return symbols;
    }

}
