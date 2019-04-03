package by.epam.javatraining.beseda.task04.model.logic.sorter;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.model.logic.sorter.sortable.DecreasingOrder;
import by.epam.javatraining.beseda.task04.model.logic.sorter.sortable.IncreasingOrder;
import by.epam.javatraining.beseda.task04.model.testingdata.TestingData;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author User
 */
public class SorterNGTest {

    public SorterNGTest() {
    }

    @Test
    public void testSortByOrder00() throws Exception {
        Sorter.sortByOrder(null, new IncreasingOrder());
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testSortByOrder01(LexicalContainer container) throws Exception {
        Sorter.sortByOrder(container, null);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testSortByOrder02(LexicalContainer container) throws Exception {
        Sorter.sortByOrder(container, new DecreasingOrder());
        String expected = "Attributes attrs = new BasicAttributes();" + System.lineSeparator()
                + "attrs.put(\"o\", \"Yellow\");" + System.lineSeparator()
                + "attrs.put(\"cn\", \"Mango\");" + System.lineSeparator()
                + "// create a binary value for the RDN";
        assertEquals(container.getPart(0).toString(), expected);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testSortByOrder03(LexicalContainer container) throws Exception {
        Sorter.sortByOrder(container, new DecreasingOrder());
        String expected = "The type/values of and RDN can be obtained using the methods below:"
                + System.lineSeparator() + "- getType();" + System.lineSeparator()
                + "- getValue();" + System.lineSeparator() + "- toAttributes().";
        assertEquals(container.getPart(1).toString(), expected);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testSortByOrder04(LexicalContainer container) throws Exception {
        Sorter.sortByOrder(container, new DecreasingOrder());
        String expected = "Accessing type/value pairs of an RDN.";
        assertEquals(container.getPart(2).toString(), expected);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testSortByOrder05(LexicalContainer container) throws Exception {
        Sorter.sortByOrder(container, new IncreasingOrder());
        String expected = "Accessing type/value pairs of an RDN.";
        assertEquals(container.getPart(0).toString(), expected);
    }

    @Test(dataProvider = "data01", dataProviderClass = TestingData.class)
    public void testSortByOrder06(LexicalContainer container) throws Exception {
        Sorter.sortByOrder(container, new IncreasingOrder());
        String expected = "The type/values of and RDN can be obtained using the methods below:"
                + System.lineSeparator() + "- getType();" + System.lineSeparator()
                + "- getValue();" + System.lineSeparator() + "- toAttributes().";
        assertEquals(container.getPart(1).toString(), expected);
    }

    @Test(dataProvider = "data02", dataProviderClass = TestingData.class)
    public void testSortByOrder07(LexicalContainer container) throws Exception {
        Sorter.sortByOrder(container, new DecreasingOrder());
        String expected = "You can use compareTo() to sort a list of Rdn instances.";
        assertEquals(container.getPart(0).toString(), expected);
    }

}
