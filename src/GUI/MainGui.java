package GUI;




import Datamodel.Pattern;
import Datamodel.PatternComponent;
import Datamodel.PatternLanguage;
import Datamodel.TemplateFactory;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.ArrayList;


public class MainGui extends Application  {

    private boolean language_enable=false;
    private boolean pattern_enable=false;
    private boolean template_enable=false;
    private boolean first_time_submenu=false;

    private Label language_name;
    private Label pattern_status;
    private BorderPane bPane;

    //---------Buttons---------------
    private Button language_button;
    private Button newlanguage_button;
    private Button loadlanguage_button;
    private Button savelanguage_button;
    private Button pattern_button;
    private Button newpattern_button;
    private Button editpattern_button;
    private Button savepattern_button;
    private Button removepattern_button;
    private Button template_button;
    private Button previewtemplate_button;
    private Button createtemplate_button;
    //-----------------------------------
    private ArrayList<TextArea> inputList=new ArrayList<TextArea>();;
    private boolean edit_enable;
    private int pattern_for_edit;
    private PatternLanguage language;
    private TemplateFactory templates;
    private Pattern userpattern;
    private ArrayList<Pattern> patternList;

    private Stage mainstage;


    public void start(Stage stage) {
        //Instantiating the BorderPane class (root)
    	//stage.initStyle(StageStyle.UNDECORATED);
        bPane = new BorderPane();  // Set the layout of the window
        patternList=new ArrayList<Pattern>();

        //-----------------Create Top Side Menu------------------------------
        mainstage=stage;
        HBox topmenu= new HBox();
        topmenu.setId("topborder");
        Label header=new Label("PATTERN\nEDITOR.");
        language_name=new Label("");
        pattern_status=new Label("");
        pattern_status.setId("pattern_status");
        header.setId("header"); 						//set ID for css file
        language_name.setId("lang_name");
        header.setMaxWidth(Double.MAX_VALUE );
        header.setMaxHeight(Double.MAX_VALUE );
        language_name.setMaxWidth(500);
        language_name.setMaxHeight(86 );
        language_name.setMinWidth(500 );
        language_name.setMinHeight(86 );
        pattern_status.setMaxWidth(253);
        pattern_status.setMaxHeight(86 );
        pattern_status.setMinWidth(253 );
        pattern_status.setMinHeight(86 );
        Line underheader=new Line(0,0,900,0);
        underheader.setStroke(Color.WHITE);
        topmenu.getChildren().addAll(header,language_name,pattern_status);
        bPane.setTop(topmenu);
        //-------------------------------------------------------------------

        createLeftMenu();       // Create Left Side Menu

        createLeftSubMenu();    // Create Left Side Submenus

        //------------------------------------------------------------------

        //Creating a scene object
        Scene scene = new Scene(bPane,900,600);

        //Setting title to the Stage
        mainstage.setTitle("Pattern Editor");

        //import css file
        scene.getStylesheets().add("GUI/Minimal.css");

        //Adding scene to the stage
        mainstage.setScene(scene);

        //Disable resizing
        mainstage.setResizable(false);

        //Displaying the contents of the stage
        mainstage.show();

    }


    public void createLeftMenu(){

        VBox leftmenu= new VBox();	//layout for left menu (stack)
        leftmenu.setId("leftmenu");
        leftmenu.setMaxWidth(250 );
        leftmenu.setMaxHeight(515 );
        leftmenu.setMinWidth(250 );
        leftmenu.setMinHeight(515 );

        //Language Menu Button
        language_button=new Button("+ Language");
        //Pattern menu Button
        pattern_button=new Button("+ Pattern");
        //Template menu Button
        template_button=new Button("+ Template");

        //handler for language button
        language_button.setOnAction(event ->
        {
            if(language_enable==false){			//if its not clicked drop down the language submenu
                language_button.setText("- Language");
                leftmenu.getChildren().add(1,newlanguage_button);
                leftmenu.getChildren().add(2,loadlanguage_button);
                leftmenu.getChildren().add(3,savelanguage_button);

                language_enable=true;
            }else{								//if its already clicked then remove language submenu
                language_button.setText("+ Language");
                language_enable=false;
                leftmenu.getChildren().removeAll(newlanguage_button,loadlanguage_button,savelanguage_button);
            }

        });

        //handler for pattern button
        pattern_button.setOnAction(event -> {
            if(pattern_enable==false && language_enable==false){		//if its not clicked, drop down the pattern submenu
                pattern_button.setText("- Pattern");
                leftmenu.getChildren().add(2,newpattern_button);
                leftmenu.getChildren().add(3,editpattern_button);
                leftmenu.getChildren().add(4,savepattern_button);
                leftmenu.getChildren().add(5,removepattern_button);
                pattern_enable=true;

            }else if(pattern_enable==false && language_enable==true){ 	//case where language submenu is open too
                pattern_button.setText("- Pattern");
                leftmenu.getChildren().add(5,newpattern_button);
                leftmenu.getChildren().add(6,editpattern_button);
                leftmenu.getChildren().add(7,savepattern_button);
                leftmenu.getChildren().add(8,removepattern_button);
                pattern_enable=true;

            }else{								//if its already clicked then remove pattern submenu
                pattern_button.setText("+ Pattern");
                pattern_enable=false;
                leftmenu.getChildren().removeAll(newpattern_button,editpattern_button,savepattern_button,removepattern_button);
            }

        });

        //handler for template button
        template_button.setOnAction(event -> {
            if(template_enable==false){			//if its not clicked drop down the language submenu
                template_button.setText("- Template");
                leftmenu.getChildren().addAll(previewtemplate_button,createtemplate_button);
                template_enable=true;
            }else{								//if its already clicked then remove language submenu
                template_button.setText("+ Template");
                template_enable=false;
                leftmenu.getChildren().removeAll(previewtemplate_button,createtemplate_button);
            }

        });








        //Add main menu buttons
        leftmenu.getChildren().addAll(language_button,pattern_button,template_button);
        bPane.setLeft(leftmenu);
    }

    public void createLeftSubMenu(){

        //Language Submenu Buttons
        newlanguage_button=new Button("New Language");                 //New Language button
        newlanguage_button.setId("submenu"); 	                            //set id for css file
        newlanguage_button.setOnAction(e -> setNewLanguageSubscene());      //handler for New Language button

        loadlanguage_button=new Button("Load Language");               //Load Language button
        loadlanguage_button.setId("submenu");	                            //set id for css file
        loadlanguage_button.setOnAction(e -> setLoadLanguageSubscene());    //handler for Load Language button

        savelanguage_button=new Button("Save Language");              //Save Language button
        savelanguage_button.setId("submenu");	                            //set id for css file
        //savelanguage_button.setOnAction(e -> setLoadLanguageSubscene());   //handler for Load Language button


        //Pattern Submenu Buttons
        newpattern_button=new Button("New Pattern");
        newpattern_button.setId("submenu");
        newpattern_button.setOnAction(e -> setNewPatternSubscene());

        editpattern_button=new Button("Edit Pattern");
        editpattern_button.setId("submenu");
        editpattern_button.setOnAction(e -> setEditPatternSubscene());

        savepattern_button=new Button("Save Pattern");
        savepattern_button.setId("submenu");
        savepattern_button.setOnAction(e -> setSavePatternSubscene());

        removepattern_button=new Button("Remove Pattern");
        removepattern_button.setId("submenu");
        removepattern_button.setOnAction(e->setRemoveSubscene());
        //Template Submenu Buttons
        previewtemplate_button=new Button("Preview Templates");
        previewtemplate_button.setId("submenu");
        createtemplate_button=new Button("Create New Template");
        createtemplate_button.setId("submenu");
    }

    public void setRemoveSubscene(){
    	/*VBox layout =new VBox();
    	Label remove_name=new Label("Enter Pattern's name to remove : ");
    	remove_name.setId("language_title");
    	TextField removepattern_input=new TextField("");
    	removepattern_input.setId("input");
    	Button remove_b=new Button("Remove");
    	remove_b.setOnAction(e->removePattern(removepattern_input.getText()));
    	remove_b.setId("classic_buttons");
    	layout.getChildren().addAll(remove_name,removepattern_input,remove_b);
    	bPane.setCenter(layout);*/
    	
    	 System.out.println("IN");
         disableAllSubscenes();
         VBox layout =new VBox(); //vertical container for text and template buttons (1 column , 2 rows)
         layout.setAlignment(Pos.TOP_CENTER);
         Label cur_patterns=new Label("Patterns :");
         cur_patterns.setId("avail_templates");
         layout.getChildren().add(cur_patterns);
         FlowPane pattern_layout=new FlowPane();       //horizontal container for buttons
         pattern_layout.setAlignment(Pos.CENTER);
         pattern_layout.setHgap(10);
         pattern_layout.setVgap(10);
         pattern_layout.setPadding(new Insets(0,50,0,50));
         //templates_layout.setSpacing(10);
         layout.getChildren().add(pattern_layout);
        // templates=new TemplateFactory();

        

         for(PatternComponent patterns: language.getComponentsList()){

            
             //Iterate over all Patterns and make a button for each one with the template's name
             Button pattern_select=new Button(patterns.getName());

             pattern_select.setOnAction(e->removePattern(pattern_select.getText()));

             pattern_select.setAlignment(Pos.CENTER);
             pattern_select.wrapTextProperty().setValue(true);
             pattern_select.setMinSize(200,100);
             pattern_select.setMaxSize(200,100);
             pattern_select.setPadding(new Insets(0,0,0,0));
             pattern_select.setId("templates");
             pattern_layout.getChildren().add(pattern_select);
         }

         bPane.setCenter(layout);
    	
    }
    
    public void removePattern(String pattern_name){
    	
    	ArrayList<Integer> patternsForRemove=new ArrayList<Integer>();
    	
    	
    	/*for(PatternComponent x: language.getComponentsList()){
    		if(x.getName().equals(pattern_name)){
    			language.remove(pattern_name);
    		}
    	}*/
    	
    	
    	language.remove(pattern_name);
    	
    	
    
    	
    	/*
    	for(int i=0; i<language.getComponentsList().size(); i++){
    		if(patternList.get(i).getName().equals(pattern_name)){
    			patternsForRemove.add(i);
    			
    		}
    	}
    	for(int i=0; i<patternsForRemove.size(); i++ ){
    		//language.remove(patternList().get(i).getName());
    		patternList.remove(i);
    	}
    	/*for(Pattern x: patternList){
    		if(x.getName().equals(pattern_name)){
    			patternList.remove(pattern_name);
    		}
    	}*/
    	System.out.println("Pattern list:"+patternList.size());
    	setRemoveSubscene();
    	
    }
    public void setNewLanguageSubscene(){

        disableAllSubscenes();              //clear subscene

        VBox verticalLayout = new VBox();
        verticalLayout.setId("subscene");

        HBox horizontalLayout=new HBox();
        HBox classicbuttonsLayout=new HBox();
        classicbuttonsLayout.setSpacing(20);
        classicbuttonsLayout.setPadding(new Insets(5, 0, 0, 122));


        Label languageTitle =new Label("Language Title :");
        languageTitle.setId("language_title");

        //Text Field for user language input
        TextField language_name_input=new TextField("");
        language_name_input.setId("input");
        language_name_input.setMaxSize(400, 25);
        language_name_input.setMinSize(400, 25);

        //Save Button
        Button save=new Button("  Save  ");
        save.setId("classic_buttons");

        save.setOnAction(event -> {
            if(language_name_input.getText().equals("")){
                AlertBox.display("Default Language Name", "Empty language name input. Language name will take the default value.");
                language_name.setText("LANGUAGE / newLanguage");
            }else{
                language_name.setText("LANGUAGE / "+language_name_input.getText());

            }
            // Create a new language and set Name
            language=new PatternLanguage();
            language.setName(language_name_input.getText());

        });

        //Cancel Button
        Button cancel=new Button("Cancel");
        cancel.setId("classic_buttons");
        cancel.setOnAction(event -> disableAllSubscenes());

        //add button and text field on scene
        horizontalLayout.getChildren().add(languageTitle);
        horizontalLayout.getChildren().add(language_name_input);

        classicbuttonsLayout.getChildren().addAll(save,cancel);

        verticalLayout.getChildren().add(horizontalLayout);
        verticalLayout.getChildren().add(classicbuttonsLayout);

        bPane.setCenter(verticalLayout);

    }

    public void setLoadLanguageSubscene(){

        disableAllSubscenes();         //clear subscene

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Language File");
        fileChooser.showOpenDialog(mainstage);
    }


    public void setNewPatternSubscene(){
        disableAllSubscenes();
        edit_enable=false;
        VBox layout =new VBox(); //vertical container for text and template buttons (1 column , 2 rows)
        layout.setAlignment(Pos.TOP_CENTER);
        Label avail_template=new Label("Available Templates:");
        avail_template.setId("avail_templates");
        layout.getChildren().add(avail_template);
        FlowPane templates_layout=new FlowPane();       //horizontal container for buttons
        templates_layout.setAlignment(Pos.CENTER);
        templates_layout.setHgap(10);
        templates_layout.setVgap(10);
        templates_layout.setPadding(new Insets(0,50,0,50));
        //templates_layout.setSpacing(10);
        layout.getChildren().add(templates_layout);
        templates=new TemplateFactory();

        for(String template_name : templates.getTemplatesNames()){

            //Iterate over all templates and make a button for each one with the template's name
            Button template_select=new Button(template_name);
            template_select.setOnAction(e->patternFormSubscene(template_name,"defaultname"));

            template_select.setAlignment(Pos.CENTER);
            template_select.wrapTextProperty().setValue(true);
            template_select.setMinSize(200,100);
            template_select.setMaxSize(200,100);
            template_select.setPadding(new Insets(0,0,0,0));
            template_select.setId("templates");
            templates_layout.getChildren().add(template_select);
        }

        bPane.setCenter(layout);

    }

    public void patternFormSubscene(String template,String patternName){
        disableAllSubscenes();
        inputList.clear();

        if(edit_enable==true){

            for(Pattern edit_pattern: patternList){
                if(edit_pattern.getName().equals(patternName)){
                    userpattern=edit_pattern;
                }
            }

        }else{
            userpattern = templates.createTemplate(template).clonePattern();
        }



        VBox formLayout=new VBox();
        formLayout.setId("patternbg");
        ScrollPane scrollPane = new ScrollPane(); // scroll bar



        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        formLayout.setPadding(new Insets(20,50,20,50));
        formLayout.setSpacing(10);
        formLayout.setAlignment(Pos.TOP_LEFT);

        Label name=new Label("Name");
        name.setPadding(new Insets(20,0,0,0));
        name.setId("patternform");
        formLayout.getChildren().add(name);
        TextArea nameInput=new TextArea(userpattern.getName());
        nameInput.setId("input");
        nameInput.setWrapText(true);
        nameInput.setMinSize(100,50);
        inputList.add(nameInput);
        formLayout.getChildren().add(nameInput);

        for(int i=0; i<userpattern.getComponentsList().size(); i++){

            Label contentTitle=new Label(userpattern.getComponentsList().get(i).getName());
            contentTitle.setPadding(new Insets(20,0,0,0));
            contentTitle.setId("patternform");
            formLayout.getChildren().add(contentTitle);

            if (userpattern.getComponentsList().get(i).getName().equals("Template")){
                Label tempTitle=new Label(template);
                TextArea templateInput=new TextArea(userpattern.getContents(i)); //used only to keep inputlist.size= # patternparts
                inputList.add(templateInput);
                formLayout.getChildren().add(tempTitle);

            }else{

                TextArea contentInput=new TextArea(userpattern.getContents(i));
                contentInput.setId("input");
                contentInput.setWrapText(true);

                contentInput.setMinSize(100,200);


                inputList.add(contentInput);
                formLayout.getChildren().add(contentInput);
            }

            //contentInput.setPadding(new Insets(0,0,100,0));


        }


        scrollPane.setContent(formLayout);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        //scrollPane.setMaxHeight(800);
        bPane.setCenter(scrollPane);
        //bPane.getCenter()
        //System.out.println(templates.createTemplate(template).getName());
        //System.out.println(userpattern.getComponentsList().get(4).getName());

    }

    public void setEditPatternSubscene(){

        if(patternList.size()<=0){
            AlertBox.finishMessage("Current Language contains 0 Patterns");
            return;
        }
        edit_enable=true;
        displayPatterns();




    }
    public void displayPatterns(){

        System.out.println("IN");
        disableAllSubscenes();
        VBox layout =new VBox(); //vertical container for text and template buttons (1 column , 2 rows)
        layout.setAlignment(Pos.TOP_CENTER);
        Label cur_patterns=new Label("Patterns :");
        cur_patterns.setId("avail_templates");
        layout.getChildren().add(cur_patterns);
        FlowPane pattern_layout=new FlowPane();       //horizontal container for buttons
        pattern_layout.setAlignment(Pos.CENTER);
        pattern_layout.setHgap(10);
        pattern_layout.setVgap(10);
        pattern_layout.setPadding(new Insets(0,50,0,50));
        //templates_layout.setSpacing(10);
        layout.getChildren().add(pattern_layout);
       // templates=new TemplateFactory();
        int counter=0;
        System.out.println("Patterns :"+language.getComponentsList().size()+"\n");

        for(PatternComponent patterns: language.getComponentsList() /*Pattern patterns: patternList*/){
        	int currentPattern=counter;
        	
            System.out.println(patterns.getName());
            //Iterate over all Patterns and make a button for each one with the template's name
            Button pattern_select=new Button(patterns.getName());

            pattern_select.setOnAction(e->patternFormSubscene(language.getContents(currentPattern),pattern_select.getText()));

            pattern_select.setAlignment(Pos.CENTER);
            pattern_select.wrapTextProperty().setValue(true);
            pattern_select.setMinSize(200,100);
            pattern_select.setMaxSize(200,100);
            pattern_select.setPadding(new Insets(0,0,0,0));
            pattern_select.setId("templates");
            pattern_layout.getChildren().add(pattern_select);
            counter++;
        }

        bPane.setCenter(layout);
    }


    public void setSavePatternSubscene(){

        if (language==null){
            AlertBox.display("Save unsuccessful","Pattern's Language is missing: Please create or load " +
                    "a language in order to save a Pattern.");
            return;
        }

        if(inputList.size()<=0){
            AlertBox.finishMessage("No Pattern selected for saving.");
            return;
        }
        if(inputList.get(0).getText().equals("")){
            AlertBox.display("Save unsuccessful","Pattern's name is empty: Please fill the Name area in order to save the Pattern. ");
            return;
        }
        if(edit_enable==true){
            patternList.remove(userpattern);
        }


        userpattern.setName(inputList.get(0).getText());
        System.out.println(inputList.get(0).getText());
        inputList.remove(0);
        for(int i=0; i<inputList.size(); i++){
            System.out.print(userpattern.getComponentsList().get(i).getName()+" : ");
            if(! userpattern.getComponentsList().get(i).getName().equals("Template")) {
                userpattern.getComponentsList().get(i).setContents(inputList.get(i).getText());
            }
            System.out.print(userpattern.getComponentsList().get(i).getContents()+"\n");
        }

        if (edit_enable==true){
            language.remove(userpattern.getName());
            language.add(userpattern);
            patternList.add(userpattern);

        }else{
            patternList.add(userpattern);
            language.add(userpattern);
        }


        saveMessage(); //show a save successful message
        edit_enable=true;
        patternFormSubscene(userpattern.getContents(0),userpattern.getName());
        //disableAllSubscenes();





    }

    public void saveMessage(){

        pattern_status.setText("Pattern saved successfully.");
        FadeTransition ft = new FadeTransition(Duration.millis(1000), pattern_status);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        PauseTransition delay = new PauseTransition(Duration.seconds(3));

        delay.setOnFinished( e -> {
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.play();
        } );

        delay.play();
    }


    public void disableAllSubscenes(){

        bPane.setCenter(null);


    }






    public static void main(String[] args) {
        launch(args);
    }



}