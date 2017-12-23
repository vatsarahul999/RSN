package com.rahul.RPN;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rahul.RPN.da.DataReader;
import com.rahul.RPN.engine.Engine;

public class App {

	private final Logger log = LoggerFactory.getLogger(App.class);
	List<String> postfixExpressions;

	public App() {
		postfixExpressions = new ArrayList<String>();
	}

	public static void main(String[] args) {
		App app = new App();
		System.out.println("Started ");
		if (args.length == 0) {
			System.out.println("No file has provided.");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the postfix expression(space seperated):");
			String input = scanner.nextLine().trim();
			app.addExpression(input);
			scanner.close();
		}else{
			app.execute(args);
		}
		System.out.println("Done");
	}

	private void execute(String[] args) {
		addAllExpressions(args[0]);
		File outputFile = null;
		if(args.length == 2 && StringUtils.isNotBlank(args[1])){
			outputFile = new File(args[0]);
		}
		else{
			outputFile = new File(args[0]+".evaluated.txt");
		}
		Engine engine = new Engine();
		StringBuffer output = new StringBuffer();
		for(String s : postfixExpressions){
			try {
				double res = engine.evaluteExpression(s);
				output.append(s).append('\t').append(res).append('\n');
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(output.toString());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outputFile);
			fos.write(output.toString().getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void addAllExpressions(String args) {
		File inputFile = new File(args);
		System.out.println("The file is being read");
		DataReader dataReader = new DataReader();
		postfixExpressions.addAll(dataReader.getExpression(inputFile));
		log.debug("Identified all the expression.");
		
	}

	private void addExpression(String input) {
		postfixExpressions.add(input);
		
	}
}
