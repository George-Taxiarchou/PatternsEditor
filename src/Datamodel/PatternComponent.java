package Datamodel;

public abstract class PatternComponent {
    private String name;


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    public abstract String getContents();
    public abstract void setContents(String contents);
    public abstract void setContents(String contents,int index);
    public abstract void saveName(String outstream);
    public abstract void saveContents(String outstream);
    public abstract void add(PatternComponent patternComponent);
    public abstract void remove(String patternComponentTitle);
    public abstract PatternComponent getChild();

}