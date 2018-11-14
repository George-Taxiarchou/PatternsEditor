package Datamodel;


import java.util.ArrayList;
import java.util.HashMap;

public class TemplateFactory {

    HashMap<String,Pattern> templatesList;

    public TemplateFactory(){
        templatesList=new HashMap<String,Pattern>();

        //--------Micro-Pattern-----------
        templatesList.put("Micro-Pattern",makeMicroPattern());

        //--------Inductive Mini-Pattern------------
        templatesList.put("Inductive Mini-Pattern",makeInductiveMiniPattern());

        templatesList.put("Deductive Mini-Pattern",makeDeductiveMiniPattern());
        
        templatesList.put("Gang-of-Four Pattern",makeGangOfFourPattern());
        
        templatesList.put("System of Patterns",makeSystemOfPatterns());
        


    }
    
    public Pattern makeDeductiveMiniPattern(){
    	Pattern deductiveMiniPattern = new Pattern();
    	PatternPart template=new PatternPart();
    	
    	template.setName("Template");
    	template.setContents("Deductive Mini-Pattern");
    	
    	PatternPart problem = new PatternPart();
    	problem.setName("Problem");
    	PatternPart benefits= new PatternPart();
    	benefits.setName("Benefits");
    	PatternPart solution = new PatternPart();
    	solution.setName("Solution");
    	PatternPart consequences = new PatternPart();
    	consequences.setName("Consequences");
 
    	deductiveMiniPattern.add(template);
    	deductiveMiniPattern.add(problem);
     	deductiveMiniPattern.add(solution);
    	deductiveMiniPattern.add(benefits);
    	deductiveMiniPattern.add(consequences);
   	      
    	return deductiveMiniPattern;
       
    }
    
    
    public Pattern makeGangOfFourPattern(){
    	Pattern GangOfFourPattern = new Pattern();
    	PatternPart template=new PatternPart();
    	
    	template.setName("Template");
    	template.setContents("Gang-of-Four Pattern");
    	
    	PatternPart patternclassification = new PatternPart();
    	patternclassification.setName("Pattern Clasification");
    	PatternPart intent = new PatternPart();
    	intent.setName("Intent");
    	PatternPart alsoknownas= new PatternPart();
    	alsoknownas.setName("Also Known As");
    	PatternPart motivation = new PatternPart();
    	motivation.setName("Motivation");
    	PatternPart applicability= new PatternPart();
    	applicability.setName("Applicability");
    	PatternPart structure= new PatternPart();
    	structure.setName("Structure");
    	PatternPart participants= new PatternPart();
    	participants.setName("Participants");
    	PatternPart collaborations = new PatternPart();
    	collaborations.setName("Collaborations");
    	PatternPart consequences= new PatternPart();
    	consequences.setName("Consequences");
    	PatternPart implementation= new PatternPart();
    	implementation.setName("Implementation");
    	PatternPart samplecode = new PatternPart();
    	samplecode.setName("Sample Code");
    	PatternPart knownuses = new PatternPart();
    	knownuses.setName("Known Uses");
    	PatternPart relatedpatterns= new PatternPart();
    	relatedpatterns.setName("Related Patterns");
    	
    	GangOfFourPattern.add(template);
    	GangOfFourPattern.add(patternclassification);
    	GangOfFourPattern.add(intent);
    	GangOfFourPattern.add(alsoknownas);
    	GangOfFourPattern.add(motivation);
    	GangOfFourPattern.add(applicability);
    	GangOfFourPattern.add(structure);
    	GangOfFourPattern.add(participants);
    	GangOfFourPattern.add(collaborations);
    	GangOfFourPattern.add(consequences);
    	GangOfFourPattern.add(implementation);
    	GangOfFourPattern.add(samplecode);
    	GangOfFourPattern.add(knownuses);
    	GangOfFourPattern.add(relatedpatterns);


    	
    	
    	return GangOfFourPattern;
    }
    
    public Pattern makeSystemOfPatterns(){
    	Pattern systemPattern = new Pattern();
    	PatternPart template=new PatternPart();
    	
    	template.setName("Template");
    	template.setContents("System-Of-Patterns");
       
        PatternPart alsoknownas=new PatternPart();
        alsoknownas.setName("Also Known As");
        PatternPart example=new PatternPart();
        example.setName("Example");
        PatternPart context=new PatternPart();
        context.setName("Context");
        PatternPart problem=new PatternPart();
        problem.setName("Problem");
        PatternPart solution=new PatternPart();
        solution.setName("Solution");
        PatternPart structure=new PatternPart();
        structure.setName("Structure");
        PatternPart dynamics=new PatternPart();
        dynamics.setName("Dynamics");
        PatternPart implementation=new PatternPart();
        implementation.setName("Implementation");
        PatternPart exampleresolved=new PatternPart();
        exampleresolved.setName("Example Resolved");
        PatternPart variants=new PatternPart();
        variants.setName("Variants");
        PatternPart knownuses=new PatternPart();
        knownuses.setName("Known Uses");
        PatternPart consequences=new PatternPart();
        consequences.setName("Consequences");
        
        systemPattern.add(template);
        systemPattern.add(alsoknownas);
        systemPattern.add(example);
        systemPattern.add(context);
        systemPattern.add(problem);
        systemPattern.add(solution);
        systemPattern.add(structure);
        systemPattern.add(dynamics);
        systemPattern.add(implementation);
        systemPattern.add(exampleresolved);
        systemPattern.add(variants);
        systemPattern.add(knownuses);
        systemPattern.add(consequences);
        
        return systemPattern;
       
    }
    
    public Pattern makeMicroPattern(){

        Pattern microPattern=new Pattern();
      
        PatternPart template=new PatternPart();
        template.setName("Template");
        template.setContents("Micro-Pattern");
        PatternPart problem=new PatternPart();
        problem.setName("Problem");
       
        PatternPart solution=new PatternPart();
        solution.setName("Solution");
     

        //microPattern.add(name);
        microPattern.add(template);
        microPattern.add(problem);
        microPattern.add(solution);
        return microPattern;
    }

    public Pattern makeInductiveMiniPattern(){

        Pattern inductiveMiniPattern=new Pattern();
        
        PatternPart template=new PatternPart();
        template.setName("Template");
        template.setContents("Inductive Mini-Pattern");
        PatternPart context=new PatternPart();
        context.setName("Context");
        PatternPart forces=new PatternPart();
        forces.setName("Forces");
        PatternPart solution=new PatternPart();
        solution.setName("Solution");

      
        inductiveMiniPattern.add(template);
        inductiveMiniPattern.add(context);
        inductiveMiniPattern.add(forces);
        inductiveMiniPattern.add(solution);


        return inductiveMiniPattern;
    }

    public Pattern createTemplate(String templateName){

        return templatesList.get(templateName);
    }



    public ArrayList<String> getTemplatesNames(){

        ArrayList<String> template_names=new ArrayList<String>();
        for(String name: templatesList.keySet()){
            template_names.add(name);
        }
        return template_names;
    }
}