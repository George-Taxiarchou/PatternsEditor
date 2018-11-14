package Datamodel;

public class Pattern extends PatternComposite {

    public Pattern clonePattern(){

        //deep copy
        Pattern clone=new Pattern();

        for(int i=0; i<this.getComponentsList().size(); i++ ){


            PatternPart clonepart=new PatternPart();
            String clonename=new String(this.getComponentsList().get(i).getName());
            System.out.println(i+" "+clonename);
            String clonecontents;
            clonecontents=this.getComponentsList().get(i).getContents();

            clonepart.setName(clonename);
            clonepart.setContents(clonecontents);

            clone.add(clonepart);         //take from caller pattern every element and add it in clone
        }




        return clone;
    }


}