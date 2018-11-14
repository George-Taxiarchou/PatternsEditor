package Datamodel;

public class PatternPart extends PatternComponent {

    private String contents="";

    @Override
    public String getContents() {
        return contents;
    }

    @Override
    public void setContents(String contents) {
        this.contents=contents;
    }

    @Override
    public void setContents(String contents, int index) {

    }

    @Override
    public void saveName(String outstream) {

    }

    @Override
    public void saveContents(String outstream) {

    }

    @Override
    public void add(PatternComponent patternComponent) {

    }

    @Override
    public void remove(String patternComponentTitle) {

    }

    @Override
    public PatternComponent getChild() {
        return null;
    }
}