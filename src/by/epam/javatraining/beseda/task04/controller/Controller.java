package by.epam.javatraining.beseda.task04.controller;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.exception.IllegalIndexException;
import by.epam.javatraining.beseda.task04.model.exception.ProjectLogicException;
import by.epam.javatraining.beseda.task04.util.SentenceContainerToString;
import by.epam.javatraining.beseda.task04.model.logic.sentence.SentenceFinder;
import by.epam.javatraining.beseda.task04.model.logic.sentence.comparator.LengthDecreasingComparator;
import by.epam.javatraining.beseda.task04.model.logic.sentence.comparator.LengthIncreasingComparator;
import by.epam.javatraining.beseda.task04.model.logic.word.WordChanger;
import by.epam.javatraining.beseda.task04.model.logic.word.WordRemover;
import by.epam.javatraining.beseda.task04.model.reader.TextFileReader;
import by.epam.javatraining.beseda.task04.util.ParserCreator;
import by.epam.javatraining.beseda.task04.view.Printer;
import by.epam.javatraining.beseda.task04.view.PrinterCreator;
import by.epam.javatraining.beseda.task04.view.PrinterType;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Beseda
 * @version 1.0 01/04/2019
 */
public class Controller {

    public static void main(String[] args) throws IllegalIndexException {

        Printer printer = PrinterCreator.getPrinter(PrinterType.LOGGER);

        printer.print("Reading the text file...\n");
        String text = TextFileReader.readFile("Text.txt");

        printer.print("Parsing the file...\n");
        LexicalContainer parsedText = ParserCreator.invokeParser(text, LexicalContainer.Type.TEXT);
        printer.print("Cloning the parsed data...\n");
        LexicalContainer clone = parsedText.clone();
        printer.print("Printing out parsed text...\n\n");

        printer.print(clone.toString() + "\n");

        List<LexicalContainer> sentenceList = SentenceFinder.find(clone);
        printer.print("Print out the sentences in order of their increasing length...\n");

        Collections.sort(sentenceList, new LengthIncreasingComparator());

        printer.print(SentenceContainerToString.toString(sentenceList) + "\n");

        Collections.sort(sentenceList, new LengthDecreasingComparator());
        printer.print("Print out the sentences in order of their decreasing length...\n");
        printer.print(SentenceContainerToString.toString(sentenceList) + "\n\n");

        printer.print("Replace first word in each sentence with last word of the sentence...\n");

        try {
            WordChanger.changeFirstLastWord(clone);
        } catch (ProjectLogicException ex) {
            printer.print("\n" + ex + "\n");
        }

        printer.print(clone.toString() + "\n");

        printer.print("Remove from sentences words starts consonant with 5 symbols length...\n");
        try {
            WordRemover.removeWordsStartsConsonant(clone, 5);
        } catch (ProjectLogicException ex) {
            printer.print("\n" + ex + "\n");
        }

        printer.print(clone.toString() + "\n");
    }
}
