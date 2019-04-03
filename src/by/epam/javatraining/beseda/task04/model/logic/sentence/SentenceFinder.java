package by.epam.javatraining.beseda.task04.model.logic.sentence;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import by.epam.javatraining.beseda.task04.model.exception.IllegalIndexException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beseda
 * @version 1.0 03/04/2019
 */
public class SentenceFinder {

    public static List<LexicalContainer> find(LexicalContainer text) throws IllegalIndexException {
        List<LexicalContainer> sentences = new ArrayList<>();
        if (text != null && text.getType() == LexicalContainer.Type.TEXT) {
            for (int i = 0; i < text.getPartsNumber(); i++) {
                LexicalPart part = text.getPart(i);
                if ((part instanceof LexicalContainer)
                        && ((LexicalContainer) part)
                                .getType() == LexicalContainer.Type.PARAGRAPH) {
                    for (int j = 0; j < ((LexicalContainer) part).getPartsNumber(); j++) {
                        sentences.add((LexicalContainer) ((LexicalContainer) part).getPart(j));
                    }
                }
            }
        }
        return sentences;
    }

}
