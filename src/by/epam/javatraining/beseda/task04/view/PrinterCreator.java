package by.epam.javatraining.beseda.task04.view;

/**
 * Class for creating printers
 *
 * @author Beseda
 * @version 1.0 14/03/2019
 */
public class PrinterCreator {

    /**
     * Creates a single printer
     * 
     * @param type Printer type
     * @return a printer single instance
     */
    public static Printer getPrinter(PrinterType type) {
        return type.getPrinter();
    }

}
