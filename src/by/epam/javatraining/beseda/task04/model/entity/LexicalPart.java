package by.epam.javatraining.beseda.task04.model.entity;

import by.epam.javatraining.beseda.task04.model.exception.IllegalNumberException;
import by.epam.javatraining.beseda.task04.model.exception.ProjectLogicException;

/**
 *
 * @author Beseda
 * @version 1.0 28/03/2019
 */
public abstract class LexicalPart implements Comparable<LexicalPart> {

    public static int NUMBER = 0;

    protected int number;

    protected LexicalPart() {
        this.number = ++NUMBER;
    }

    protected LexicalPart(LexicalPart part) {
        this.number = part.number;
    }

    public void setNumber(int number) throws IllegalNumberException {
        if (number > 0) {
            this.number = number;
        } else {
            throw new IllegalNumberException();
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    abstract public LexicalPart clone();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 21 * hash + this.number;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LexicalPart other = (LexicalPart) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

    @Override
    public abstract String toString();

    @Override
    public int compareTo(LexicalPart o) {
        return this.number - o.number;
    }

}
