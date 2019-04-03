package by.epam.javatraining.beseda.task04.model.logic.word;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.exception.ProjectLogicException;
import by.epam.javatraining.beseda.task04.model.logic.sorter.Sorter;
import by.epam.javatraining.beseda.task04.model.logic.sorter.sortable.IncreasingOrder;

/**
 *
 * @author Beseda
 * @version 1.0 02/04/2019
 */
public class WordChanger {

    public static void changeFirstLastWord(LexicalContainer text) throws ProjectLogicException {
        if (text != null
                && text.getType() == LexicalContainer.Type.TEXT) {
            for (int i = 0; i < text.getPartsNumber(); i++) {
                if (text.getPart(i) instanceof LexicalContainer) {
                    LexicalContainer paragraph = (LexicalContainer) text.getPart(i);
                    for (int j = 0; j < paragraph.getPartsNumber(); j++) {
                        if (paragraph.getPart(j) instanceof LexicalContainer
                                && ((LexicalContainer) paragraph.getPart(j))
                                        .getType() == LexicalContainer.Type.SENTENCE) {
                            LexicalContainer sentence = (LexicalContainer) paragraph.getPart(j);
                            changeFirstLastWordInSentence(sentence);
                        }
                    }
                }
            }
        }
    }

    private static void changeFirstLastWordInSentence(LexicalContainer sentence)
            throws ProjectLogicException {
        if (sentence != null
                && sentence.getType() == LexicalContainer.Type.SENTENCE) {
            for (int i = 0; i < sentence.getPartsNumber(); i++) {
                if (sentence.getPart(i) instanceof LexicalContainer
                        && ((LexicalContainer) sentence.getPart(i))
                                .getType() == LexicalContainer.Type.WORD) {
                    for (int j = sentence.getPartsNumber() - 1; j >= 0; j--) {
                        if (sentence.getPart(j) instanceof LexicalContainer
                                && ((LexicalContainer) sentence.getPart(j))
                                        .getType() == LexicalContainer.Type.WORD) {
                            int tempNumber = sentence.getPart(i).getNumber();
                            sentence.getPart(i).setNumber(sentence.getPart(j).getNumber());
                            sentence.getPart(j).setNumber(tempNumber);
                            Sorter.sortByOrder(sentence, new IncreasingOrder());
                            return;
                        }
                    }
                }
            } 
        }
    }

}
