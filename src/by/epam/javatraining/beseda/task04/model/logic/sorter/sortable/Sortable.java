package by.epam.javatraining.beseda.task04.model.logic.sorter.sortable;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.exception.IllegalIndexException;

/**
 *
 * @author Beseda
 * @version 1.0 02/04/2019
 */
public interface Sortable {
    
    boolean compare(LexicalContainer part, int index) throws IllegalIndexException;
}
