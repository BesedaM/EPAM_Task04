package by.epam.javatraining.beseda.task04.model.parser;

import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import java.util.List;

/**
 *
 * @author Beseda
 * @version 1.0 01/04/2019
 */
abstract public class AbstractParser implements ParsingConstant {

    protected AbstractParser nextParser;

    public AbstractParser() {
    }

    public void setNextParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

    public AbstractParser getNextParser() {
        return nextParser;
    }
     
    public abstract List<LexicalPart> parse(String text);

}
