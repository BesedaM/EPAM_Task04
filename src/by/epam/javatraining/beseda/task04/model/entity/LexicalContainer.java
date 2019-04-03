package by.epam.javatraining.beseda.task04.model.entity;

import by.epam.javatraining.beseda.task04.model.entity.simplepart.SimpliestPart;
import by.epam.javatraining.beseda.task04.model.exception.IllegalIndexException;
import by.epam.javatraining.beseda.task04.model.exception.IllegalLexicalPartException;
import by.epam.javatraining.beseda.task04.model.exception.IllegalTypeException;
import by.epam.javatraining.beseda.task04.model.exception.ProjectLogicException;
import static by.epam.javatraining.beseda.task04.model.parser.ParsingConstant.COLON_SYMBOL;
import static by.epam.javatraining.beseda.task04.model.parser.ParsingConstant.NEWLINE_CHARACTER;
import static by.epam.javatraining.beseda.task04.model.parser.ParsingConstant.SEMICOLUMN_SYMBOL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 01/04/2019
 */
public class LexicalContainer extends LexicalPart {

    public enum Type {
        TEXT, PARAGRAPH, SENTENCE, NUMBER, WORD;
    }

    protected List<LexicalPart> parts;
    private Type type;

    public LexicalContainer() {
        super();
        this.parts = new ArrayList<>();
    }

    public LexicalContainer(List<LexicalPart> parts, Type type) {
        super();
        this.parts = parts;
        this.type = type;
    }

    public LexicalContainer(LexicalContainer container) {
        super(container);
        this.parts = new ArrayList<>();
        for (int i = 0; i < container.getPartsNumber(); i++) {
            try {
                parts.add(container.getPart(i).clone());
            } catch (IllegalIndexException ex) {
                parts.add(new SimpliestPart());
            }
        }
        this.type = container.type;
    }

    public void addPart(LexicalPart part) throws IllegalLexicalPartException {
        if (part != null) {
            parts.add(part);
        } else {
            throw new IllegalLexicalPartException();
        }
    }

    public void setPart(int index, LexicalPart part) throws ProjectLogicException {
        if (part != null) {
            if (index >= 0 && index < parts.size()) {
                parts.set(index, part);
            } else {
                throw new IllegalIndexException();
            }
        } else {
            throw new IllegalLexicalPartException();
        }
    }

    public LexicalPart getPart(int index) throws IllegalIndexException {
        if (index >= 0 && index < parts.size()) {
            return parts.get(index);
        } else {
            throw new IllegalIndexException();
        }
    }

    public void removePart(int index) throws IllegalIndexException {
        if (index >= 0 && index < parts.size()) {
            parts.remove(index);
        } else {
            throw new IllegalIndexException();
        }
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

    public int getPartsNumber() {
        return parts.size();
    }

    @Override
    public LexicalContainer clone() {
        return new LexicalContainer(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.parts);
        return super.hashCode() + 17 * hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final LexicalContainer other = (LexicalContainer) obj;
        if (!Objects.equals(this.parts, other.parts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        switch (type) {
            case WORD:
            case NUMBER:
            case PARAGRAPH: {
                for (int i = 0; i < parts.size(); i++) {
                    data.append(parts.get(i).toString());
                }
                break;
            }
            case SENTENCE: {
                for (int i = 0; i < parts.size(); i++) {
                    data.append(parts.get(i).toString());
                    switch (parts.get(i).toString()) {
                        case SEMICOLUMN_SYMBOL + "":
                            data.append(NEWLINE_CHARACTER);
                            break;
                        case COLON_SYMBOL + "":
                            if (i != parts.size() - 1) {
                                data.append(NEWLINE_CHARACTER);
                            }
                            break;
                        default:
                            break;
                    }
                }
                break;
            }
            case TEXT: {
                for (int i = 0; i < parts.size(); i++) {
                    data.append(parts.get(i).toString());
                    if (i < parts.size() - 1) {
                        data.append(NEWLINE_CHARACTER);
                    }
                }
                break;
            }
        }
        return data.toString();
    }

}
