package by.epam.javatraining.beseda.task04.model.logic.sorter.sortable;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.exception.IllegalIndexException;

/**
 *
 * @author Beseda
 * @version 1.0 02/04/2019
 */
public class IncreasingOrder implements Sortable {

    @Override
    public boolean compare(LexicalContainer part, int index) throws IllegalIndexException {
        return part.getPart(index - 1).getNumber() > part.getPart(index).getNumber();
    }

}
