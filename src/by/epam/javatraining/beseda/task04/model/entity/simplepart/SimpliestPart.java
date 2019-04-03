package by.epam.javatraining.beseda.task04.model.entity.simplepart;

import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import by.epam.javatraining.beseda.task04.model.exception.IllegalTypeException;

/**
 *
 * @author Beseda
 * @version 1.0 01/04/2019
 */
public class SimpliestPart extends LexicalPart {

    public enum Type {
        SPACE, TABULATION, PUNCTUATION, LETTER, NUMBER, EMPTY_VALUE
    }

    private char symbol;
    private Type type;

    public SimpliestPart() {
        super();
        type = Type.EMPTY_VALUE;
    }

    public SimpliestPart(char symbol, Type type) {
        super();
        this.symbol = symbol;
        this.type = type;
    }

    public SimpliestPart(SimpliestPart part) {
        super(part);
        this.symbol = part.symbol;
        this.type = part.type;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setType(Type type) throws IllegalTypeException {
        if (type != null) {
            this.type = type;
        } else {
            throw new IllegalTypeException();
        }
    }

    public Type getType() {
        return type;
    }

    @Override
    public SimpliestPart clone() {
        return new SimpliestPart(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.symbol;
        return 17 * super.hashCode() + hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final SimpliestPart other = (SimpliestPart) obj;
        if (this.symbol != other.symbol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String value;
        switch (type) {
            case EMPTY_VALUE:
                value = "";
                break;
            default:
                value = symbol + "";
        }
        return value;
    }

}
