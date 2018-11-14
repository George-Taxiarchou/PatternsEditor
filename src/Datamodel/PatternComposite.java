package Datamodel;


import java.util.ArrayList;

public class PatternComposite extends PatternComponent {
    private ArrayList<PatternComponent> componentsList;

    public PatternComposite(){
        componentsList=new ArrayList<PatternComponent>();
    }

    public ArrayList<PatternComponent> getComponentsList(){
        return componentsList;
    }

    @Override
    public String getContents() {
        return null;
    }

    public String getContents(int i){
        return componentsList.get(i).getContents();
    }

    @Override
    public void setContents(String contents) {

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
        componentsList.add(patternComponent);
    }

    @Override
    public void remove(String patternComponentTitle) {
        for(int i=0; i<componentsList.size(); i++){
            if(componentsList.get(i).getName().equals(patternComponentTitle)){
                componentsList.remove(i);
            }
        }
    }

    @Override
    public PatternComponent getChild() {
        return null;
    }
}