package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Datamodel.*;

public class PatternLanguageTest {

	@Test
	public void test() {
		PatternLanguage language = new PatternLanguage();
		Pattern p1=new Pattern();
		Pattern p2=new Pattern();
		Pattern p3=new Pattern();
		
		
		PatternPart pp = new PatternPart();
		pp.setContents("ContentsOfPattern");
		p1.setName("Pattern1");
		p1.add(pp);
		
		p2.setName("Pattern2");
		p3.setName("Pattern3");
		
		String languagename= "Language1";
		language.setName(languagename);
		//test name
		assertEquals(language.getName(),languagename);
		//test add 
		language.add(p1);
		language.add(p2);
		language.add(p3);
		int initialSize = language.getComponentsList().size();
		assertEquals(language.getComponentsList().get(0).getName(),"Pattern1");
		assertEquals(language.getComponentsList().get(1).getName(),"Pattern2");
		assertEquals(language.getComponentsList().get(2).getName(),"Pattern3");
		//testing remove
		language.remove("Pattern2");
		assertEquals(language.getComponentsList().size(),initialSize-1);
		//testing edit
		language.getComponentsList().get(0).setName("editedPattern");
		assertEquals(language.getComponentsList().get(0).getName(),"editedPattern");
		
		
		
		
	}

}
