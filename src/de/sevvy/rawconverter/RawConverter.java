package de.sevvy.rawconverter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

public class RawConverter {
	public static void main(String[] args) {
		try {
			File path;
			if(args.length > 0) {
				path = new File(args[0]);
			} else {
				path = new File(System.getProperty("user.dir")); //if no args are given, use the same path as the jar file is located
			}
			if(!path.isDirectory() || !path.canRead()) {
				throw new IllegalArgumentException("Given path is not a valid directory");
			}
			ArrayList<File> allFiles = RawConverter.getRW2Files(path); //get a list of all files in path ending in .RW2
			RawConverter.convertRW2Files(allFiles); //perform conversion, i.e. change the byte containing the Panasonic GH model number
			
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
			System.out.println("Unexpected abort");
		} finally {
			System.out.println("Program finished");
		}
	}
	
	private static void convertRW2Files(ArrayList<File> allFiles) {
		Iterator<File> fileIterator = allFiles.iterator();
		while(fileIterator.hasNext()) {
			try {
				RawConverter.convertFile(fileIterator.next());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static ArrayList<File> getRW2Files(File path) {
		ArrayList<File> rw2Files = new ArrayList<File>();
		for (final File fileEntry : path.listFiles()) {
	        if (fileEntry.isFile() && fileEntry.getAbsolutePath().toUpperCase().endsWith(".RW2")) {
	            rw2Files.add(fileEntry);
	        }
	    }
		return rw2Files;
	}

	private static void convertFile(File file) throws IOException {
		RandomAccessFile fileToConvert;
		fileToConvert = new RandomAccessFile(file, "rw");
		fileToConvert.seek(890);
		fileToConvert.write(51); //Replace byte 52 (ASCII 4) with byte 51 (ASCII 3)
		fileToConvert.close();
	}
}
