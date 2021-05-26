package com.mycompany.app;

import java.io.FileReader;
import java.io.BufferedReader;
import uk.gov.nationalarchives.csv.validator.api.java.CsvValidator;
import uk.gov.nationalarchives.csv.validator.api.java.FailMessage;
import uk.gov.nationalarchives.csv.validator.api.java.Substitution;
import java.util.List;
import static java.util.Collections.emptyList;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
	    	BufferedReader schemaReader = new BufferedReader(new FileReader("schema.csvs"));
	    	BufferedReader dataReader = new BufferedReader(new FileReader("data.csv"));
	    	List<uk.gov.nationalarchives.csv.validator.api.java.Substitution> sl = emptyList();
			List<FailMessage> failures = CsvValidator.validate(dataReader, schemaReader, false, sl, TRUE, FALSE);
	        System.out.println( "Hello World!" );
	        System.out.println( failures.get(0).getMessage());    		
    	} catch(java.io.FileNotFoundException e) {
    		System.out.println("File not found");
    	}
    }
}
