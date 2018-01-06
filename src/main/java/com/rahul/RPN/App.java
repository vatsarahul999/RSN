package com.rahul.RPN;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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
			app.addExpression(input, args);
			scanner.close();
		} else {
			app.execute(args);
		}
		System.out.println("The process has been completed successfully.");
	}

	private void execute(String[] args) {
		addAllExpressions(args[0]);
		generateOutput(args);

	}

	private void generateOutput(String[] args) {
		StringBuffer progressBar = new StringBuffer();
		for (int i = 0; i <= 100; i++) {
			progressBar.append(' ');
		}

		StringBuffer progressBar2 = new StringBuffer();
		for (int i = 0; i <= 100; i++) {
			progressBar2.append('=');
		}
		File outputFile = null;
		if (args != null && args.length > 0) {
			if (args.length == 2 && StringUtils.isNotBlank(args[1])) {
				outputFile = new File(args[1]);
			} else {
				outputFile = new File(args[0] + ".evaluatedPostfix.txt");
			}
		} else {
			outputFile = new File("evaluatedPostfix.txt");
		}

		StringBuffer output = new StringBuffer();
		addHorizontalLine(output);
		output.append("Postfix Expression").append('\t').append('\t').append('|').append('\t').append("Value")
				.append('\n');
		addHorizontalLine(output);
		ExecutorService service = Executors.newFixedThreadPool(9);
		int total = postfixExpressions.size();
		int c = 0;
		System.out.println("Current Progress :");
		for (String postfixExpression : postfixExpressions) {
			try {
				Engine engine = new Engine(postfixExpression);
				Future<Double> future = service.submit(engine);
				double res = future.get();
				output.append(postfixExpression).append('\t').append('\t').append('\t').append('|').append('\t')
						.append(res).append('\n');

			} catch (Exception e) {
				e.printStackTrace();
			}
			c++;
			int cp = (int)(((float)c/total)*100);
			System.out.print("\r[ " + progressBar2.toString().substring(0, cp)
					+ progressBar.toString().substring(0, 100 -cp) + " ]" + cp+"%");
		}
		addHorizontalLine(output);
		System.out.println();
		if ((args.length >= 2 && args[1].equals("-debug")) || (args.length >= 3 && args[2].equals("-debug"))
				|| (args.length >= 1 && args[0].equals("-debug")) || (args.length >= 4 && args[3].equals("-debug"))) {
			System.out.println(output.toString());

		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outputFile);
			fos.write(output.toString().getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("The expressions have been evaluted and the results have been stored in the file : \n"
				+ outputFile.getAbsolutePath());
		try {
			if (service.awaitTermination(1, TimeUnit.SECONDS)) {
				log.debug("Shutting down thread pool completed");
			} else {
				log.error("Forcing all the threads down");
				service.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void addHorizontalLine(StringBuffer output) {
		for (int idx = 0; idx <= 100; idx++)
			output.append("_");
		output.append('\n');
	}

	private void addAllExpressions(String args) {
		File inputFile = new File(args);
		DataReader dataReader = new DataReader();
		System.out.println("Reading file :" + inputFile.getAbsolutePath());
		postfixExpressions.addAll(dataReader.getExpression(inputFile));
		log.debug("Identified all the expression.");

	}

	private void addExpression(String input, String[] args) {
		postfixExpressions.add(input);
		generateOutput(args);

	}
}
