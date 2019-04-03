package by.epam.javatraining.beseda.task04.model.testingdata;

import by.epam.javatraining.beseda.task04.model.entity.LexicalContainer;
import by.epam.javatraining.beseda.task04.util.ParserCreator;
import org.testng.annotations.DataProvider;

/**
 *
 * @author Beseda
 * @version 1.0 03/04/2019
 */
public class TestingData {

    @DataProvider(name = "data01")
    public static Object[][] provideData01() {
        String inputText = "Accessing type/value pairs of an RDN.\n"
                + "The type/values of and RDN can be obtained using the methods below:\n"
                + "- getType();\n" + "- getValue();\n" + "- toAttributes().\n"
                + "Attributes attrs = new BasicAttributes();\n"
                + "attrs.put(\"o\", \"Yellow\");\n"
                + "attrs.put(\"cn\", \"Mango\");\n"
                + "// create a binary value for the RDN";
        LexicalContainer text = ParserCreator.invokeParser(inputText, LexicalContainer.Type.TEXT);
        return new Object[][]{{text}};
    }

    @DataProvider(name = "data02")
    public static Object[][] provideData02() {
        String inputText = "Comparing RDNs.\n"
                + "Here's an example:\n"
                + "Rdn one = new Rdn(\"ou=Sales+cn=Bob\");\n"
                + "Rdn two = new Rdn(\"cn=Bob+ou=Sales\");\n"
                + "Rdn three = new Rdn(\"ou=Sales+cn=Bob+c=US\");\n"
                + "\tThe methods below enable comparison of RDNs:\n"
                + "- equals(Object Rdn);\n"
                + "- compareTo(Object Rdn).\n"
                + "You can use compareTo() to sort a list of Rdn instances.";
        LexicalContainer text = ParserCreator.invokeParser(inputText, LexicalContainer.Type.TEXT);
        return new Object[][]{{text}};
    }
}
