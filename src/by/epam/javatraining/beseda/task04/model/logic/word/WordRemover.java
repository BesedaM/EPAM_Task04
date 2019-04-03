package by.epam.javatraining.beseda.task04.model.logic.word;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.exception.ProjectLogicException;

/**
 *
 * @author Beseda
 * @version 1.0 02/04/2019
 */
public class WordRemover {

    public static void removeWordsStartsConsonant(LexicalContainer text, int length) 
            throws ProjectLogicException{
        if (text != null
                && text.getType() == LexicalContainer.Type.TEXT
                && length > 0) {
            for (int i = 0; i < text.getPartsNumber(); i++) {
                if (text.getPart(i) instanceof LexicalContainer) {
                    LexicalContainer paragraph = (LexicalContainer) text.getPart(i);
                    for (int j = 0; j < paragraph.getPartsNumber(); j++) {
                        if (paragraph.getPart(j) instanceof LexicalContainer
                                && ((LexicalContainer) paragraph.getPart(j))
                                        .getType() == LexicalContainer.Type.SENTENCE) {
                            LexicalContainer sentence = (LexicalContainer) paragraph.getPart(j);
                            removeWordsStartsConsonantInSentence(sentence, length);
                        }
                    }
                }
            }
        }
    }

    private static void removeWordsStartsConsonantInSentence(LexicalContainer sentence, int length) 
            throws ProjectLogicException{
        if (sentence != null
                && sentence.getType() == LexicalContainer.Type.SENTENCE) {
            for (int i = 0; i < sentence.getPartsNumber(); i++) {
                if (sentence.getPart(i) instanceof LexicalContainer
                        && ((LexicalContainer) sentence.getPart(i))
                                .getType() == LexicalContainer.Type.WORD) {
                    String word = ((LexicalContainer) sentence.getPart(i)).toString();
                    if (word.length() == length
                            && LetterTypeDefiner.charIsConsonant(word.charAt(0))) {
                        sentence.removePart(i);
                    }
                }
            }
        }
    }

}
