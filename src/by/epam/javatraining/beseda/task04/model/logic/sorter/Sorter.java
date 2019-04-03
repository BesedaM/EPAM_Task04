package by.epam.javatraining.beseda.task04.model.logic.sorter;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import by.epam.javatraining.beseda.task04.model.exception.ProjectLogicException;
import by.epam.javatraining.beseda.task04.model.logic.sorter.sortable.Sortable;

/**
 *
 * @author Beseda
 * @version 1.0 02/04/2019
 */
public class Sorter {

    public static void sortByOrder(LexicalContainer container, Sortable sorter) 
            throws ProjectLogicException {
        if (sorter != null && container != null) {
            for (int i = 0; i < container.getPartsNumber(); i++) {
                for (int j = 1; j < container.getPartsNumber(); j++) {
                    if (sorter.compare(container, j)) {
                        LexicalPart temp = container.getPart(j - 1);
                        container.setPart(j - 1, container.getPart(j));
                        container.setPart(j, temp);
                    }
                }
            }
        }
    }
}
