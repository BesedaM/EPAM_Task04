package by.epam.javatraining.beseda.task04.model.parser;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.entity.simplepart.CodeBlock;
import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import by.epam.javatraining.beseda.task04.model.entity.simplepart.SimpliestPart;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Beseda
 * @version 1.0 30/03/2019
 */
public class TextParser extends AbstractParser {

    private static TextParser instance = null;

    private Pattern inParagraph;
    private Pattern notInParagraph;
    private Pattern isListElement;

    private TextParser() {
        nextParser = ParagraphParser.getParser();
        inParagraph = Pattern.compile(IN_PARAGRAPH);
        notInParagraph = Pattern.compile(NOT_IN_PARAGRAPH);
        isListElement = Pattern.compile(IS_LIST_ELEMENT);
    }

    public static TextParser getParser() {
        if (instance == null) {
            instance = new TextParser();
        }
        return instance;
    }

    @Override
    public List<LexicalPart> parse(String text) {
        List<LexicalPart> textPart = new ArrayList<>();
        if (text != null) {
            String[] parts = text.split(TEXT_PARSING);
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].equals(IS_EMPTY_STRING)) {
                    textPart.add(new SimpliestPart());
                } else if (isParagraph(parts[i])) {
                    StringBuilder data = new StringBuilder();
                    data.append(parts[i]);
                    if (parts[i].charAt(parts[i].length() - 1) == COLON_SYMBOL) {
                        while (true) {
                            if (parts[i + 1].equals(IS_EMPTY_STRING)) {
                                data.append(NEWLINE_CHARACTER);
                            } else if (isListElement.matcher(parts[i + 1]).matches()) {
                                data.append(parts[i + 1]);
                            } else {
                                break;
                            }
                            i++;
                        }
                    }
                    textPart.add(new LexicalContainer(nextParser.parse(data.toString()),
                            LexicalContainer.Type.PARAGRAPH));
                } else {        
                    StringBuilder data = new StringBuilder();
                    data.append(parts[i]);
                    while (i + 1 < parts.length && !isParagraph(parts[i + 1])) {
                        data.append(NEWLINE_CHARACTER).append(parts[i + 1]);
                        i++;
                    }
                    textPart.add(new CodeBlock(data.toString()));
                }
            }
        }
        return textPart;
    }

    private boolean isParagraph(String text) {
        return inParagraph.matcher(text).matches()
                && !notInParagraph.matcher(text).matches();
    }

}
