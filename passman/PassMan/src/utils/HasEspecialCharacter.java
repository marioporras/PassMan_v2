package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasEspecialCharacter {

	public boolean hasEspecial (String inputString) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(inputString);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if(isStringContainsSpecialCharacter) {
        	//System.out.println(inputString+ " contains special character");
            return true;
        } 
        else {
        	//System.out.println(inputString+ " does NOT contain special character");	
        	return false;
        }           	
	}
}
