package by.epam.javatraining.beseda.task04.model.entity.simplepart;

import by.epam.javatraining.beseda.task04.model.entity.LexicalPart;
import by.epam.javatraining.beseda.task04.model.exception.IllegalCodeBlockException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 28/03/2019
 */
public class CodeBlock extends LexicalPart {

    private String codeBlock;

    public CodeBlock() {
        super();
    }

    public CodeBlock(String codeBlock) {
        super();
        this.codeBlock = codeBlock;
    }

    public CodeBlock(CodeBlock block) {
        super(block);
        this.codeBlock = block.codeBlock;
    }

    public void setCodeBlock(String codeBlock) throws IllegalCodeBlockException {
        if (codeBlock != null) {
            this.codeBlock = codeBlock;
        } else {
            throw new IllegalCodeBlockException();
        }
    }

    public String getCodeBlock() {
        return codeBlock;
    }

    public CodeBlock clone() {
        return new CodeBlock(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.codeBlock);
        return 17 * super.hashCode() + hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final CodeBlock other = (CodeBlock) obj;
        if (!Objects.equals(this.codeBlock, other.codeBlock)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codeBlock;
    }

}
