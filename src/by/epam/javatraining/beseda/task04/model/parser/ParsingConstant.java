package by.epam.javatraining.beseda.task04.model.parser;

/**
 *
 * @author Beseda
 * @version 1.0 28/03/2019
 */
public interface ParsingConstant {

    String NEWLINE_CHARACTER = System.lineSeparator();

    String TEXT_PARSING = "\\r?\\n";
    String IN_PARAGRAPH = "^[^/].*([\\.!?:]|[a-zA-Z])$";
    String NOT_IN_PARAGRAPH = ".*(([/]{2})|(/\\*)).*";
    String IS_LIST_ELEMENT = "^(\\h*([-+\\*]|(([0-9]|[a-zA-Z]|[xivXIV])+)\\.)\\s).*[;\\.]$";
    String CONTAINS_LIST_ELEMENTS = ".*:{1}([-+\\*]|(([0-9]|[a-zA-Z]|[xivXIV])+)\\.)\\s.*[\\.]$";
    String LIST_START = "^(\\h*([-+\\*]|(([0-9]|[a-zA-Z]|[xivXIV])+)\\.))\\s";
    String IS_EMPTY_STRING = "\\h*";

    char COLON_SYMBOL = ':';
    char SEMICOLUMN_SYMBOL = ';';
    char DOT_SYMBOL = '.';
    char IS_TAB = '\t';

    String PARAGRAPH_PARSING = "(?<=([\\.!?]\\s))";

    String SENTENCE_PARSING = "(?<=\\s)|(?=\\s)|(?<=\\p{Punct})|(?=\\p{Punct})";
    String IS_WORD = "[a-zA-Z]+";
    String IS_NUMBER = "[0-9]+";
    String IS_WHITESPACE = "\\s";
    
}
