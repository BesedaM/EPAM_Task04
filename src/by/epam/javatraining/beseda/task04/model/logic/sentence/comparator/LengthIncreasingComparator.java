package by.epam.javatraining.beseda.task04.model.logic.sentence.comparator;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import java.util.Comparator;

/**
 *
 * @author Beseda
 * @version 1.0 02/04/2019
 */
public class LengthIncreasingComparator implements Comparator<LexicalContainer> {

    @Override
    public int compare(LexicalContainer o1, LexicalContainer o2) {
        return o1.toString().length() - o2.toString().length();
    }

}
