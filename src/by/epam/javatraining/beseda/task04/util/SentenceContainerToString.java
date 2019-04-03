package by.epam.javatraining.beseda.task04.util;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import java.util.List;

/**
 *
 * @author Beseda
 * @version 1.0 02/04/2019
 */
public class SentenceContainerToString {

    public static String toString(List<LexicalContainer> sentences) {
        StringBuilder container = new StringBuilder();
        if (sentences != null) {
            boolean onlySentences = true;
            for (int i = 0; i < sentences.size(); i++) {
                if (sentences.get(i).getType() != LexicalContainer.Type.SENTENCE) {
                    onlySentences = false;
                }
            }
            if (onlySentences) {
                for (int i = 0; i < sentences.size(); i++) {
                    container.append(sentences.get(i).toString().length());
                    container.append(" ");
                    container.append(sentences.get(i).toString()).append("\n");
                }
            }
        }
        return container.toString();
    }
}
