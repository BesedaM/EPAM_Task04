package by.epam.javatraining.beseda.task04.model.logic.word;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.testingdata.TestingData;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author User
 */
public class WordChangerNGTest {

    public WordChangerNGTest() {
    }

    @Test
    public void testChangeFirstLastWord00() throws Exception {
        WordChanger.changeFirstLastWord(null);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testChangeFirstLastWord01(LexicalContainer container) throws Exception {
        WordChanger.changeFirstLastWord(container);
        String expected = "RDN";
        String actual = ((LexicalContainer)((LexicalContainer)container.getPart(0)).getPart(0)).getPart(0).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testChangeFirstLastWord02(LexicalContainer container) throws Exception {
        WordChanger.changeFirstLastWord(container);
        String expected = "Accessing";
        String actual = ((LexicalContainer)((LexicalContainer)container.getPart(0)).getPart(0)).getPart(
                ((LexicalContainer)((LexicalContainer)container.getPart(0)).getPart(0)).getPartsNumber() - 2).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testChangeFirstLastWord03(LexicalContainer container) throws Exception {
        WordChanger.changeFirstLastWord(container);
        String expected = "toAttributes";
        String actual = ((LexicalContainer)((LexicalContainer)container.getPart(1)).getPart(0)).getPart(0).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testChangeFirstLastWord04(LexicalContainer container) throws Exception {
        WordChanger.changeFirstLastWord(container);
        String expected = "The";
        String actual = ((LexicalContainer)((LexicalContainer)container.getPart(1)).getPart(0)).getPart(
                ((LexicalContainer)((LexicalContainer)container.getPart(1)).getPart(0)).getPartsNumber() - 4).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data02", dataProviderClass = TestingData.class)
    public void testChangeFirstLastWord05(LexicalContainer container) throws Exception {
        WordChanger.changeFirstLastWord(container);
        String expected = "instances";
        String actual = ((LexicalContainer)((LexicalContainer)container.getPart(
                container.getPartsNumber() - 1)).getPart(0)).getPart(0).toString();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data02", dataProviderClass = TestingData.class)
    public void testChangeFirstLastWord06(LexicalContainer container) throws Exception {
        WordChanger.changeFirstLastWord(container);
        String expected = "You";
        int lastElement=container.getPartsNumber() - 1;
        String actual = ((LexicalContainer)((LexicalContainer)container.getPart(lastElement)).getPart(0)).getPart(
                ((LexicalContainer)((LexicalContainer)container.getPart(
                        lastElement)).getPart(0)).getPartsNumber() - 2).toString();
        assertEquals(actual, expected);
    }

}
