package by.epam.javatraining.beseda.task04.model.logic.sentence;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.testingdata.TestingData;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 03/04/2019
 */
public class SentenceFinderNGTest {

    public SentenceFinderNGTest() {
    }

    @Test
    public void testFind00() throws Exception {
        List<LexicalContainer> sentences = SentenceFinder.find(null);
        assertEquals(sentences.size(), 0);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testFind01(LexicalContainer container) throws Exception {
        List<LexicalContainer> sentences = SentenceFinder.find(container);
        assertEquals(sentences.size(), 2);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testFind02(LexicalContainer container) throws Exception {
        List<LexicalContainer> sentences = SentenceFinder.find(container);
        assertEquals(sentences.get(0).toString(), "Accessing type/value pairs of an RDN.");
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testFind03(LexicalContainer container) throws Exception {
        List<LexicalContainer> sentences = SentenceFinder.find(container);
        assertEquals(sentences.get(1).toString(),
                "The type/values of and RDN can be obtained using the methods below:"
                + System.lineSeparator() + "- getType();" + System.lineSeparator()
                + "- getValue();" + System.lineSeparator() + "- toAttributes().");
    }

    @Test(dataProvider = "data02", dataProviderClass = TestingData.class)
    public void testFind04(LexicalContainer container) throws Exception {
        List<LexicalContainer> sentences = SentenceFinder.find(container);
        assertEquals(sentences.size(), 4);
    }

    @Test(dataProvider = "data02", dataProviderClass = TestingData.class)
    public void testFind05(LexicalContainer container) throws Exception {
        List<LexicalContainer> sentences = SentenceFinder.find(container);
        assertEquals(sentences.get(0).toString(), "Comparing RDNs.");
    }

    @Test(dataProvider = "data02", dataProviderClass = TestingData.class)
    public void testFind06(LexicalContainer container) throws Exception {
        List<LexicalContainer> sentences = SentenceFinder.find(container);
        assertEquals(sentences.get(sentences.size() - 1).toString(),
                "You can use compareTo() to sort a list of Rdn instances.");
    }

}
