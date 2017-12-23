package com.rahul.RPN.da;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataReader {

	private final Logger log = LoggerFactory.getLogger(DataReader.class);

	public List<String> getExpression(File file) {
		log.info("Reading File {}", file.getName());
		List<String> result = new ArrayList<String>();
		Scanner scanner = null;
		if (file.isFile()) {
			try {
				scanner = new Scanner(file);
				while (scanner.hasNext()) {
					String line = scanner.nextLine().trim();
					if (StringUtils.isNotBlank(line))
						result.add(line);
					log.debug("Read expression {} ", line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
