package com.infotel.tp.tpPassword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PasswordFinder {

	private List<String> lines;
	private List<Word> words = new ArrayList<Word>();

	public PasswordFinder() {

	}

	public void findMyPassword(String password, File file, int iterations) throws IOException {

		List l = readFileInList(file.getAbsolutePath());

		/*
		 * BufferedReader br = new BufferedReader(new FileReader(file)); String st;
		 * 
		 * while ((st = br.readLine()) != null) { System.out.println(st); }
		 * Iterator<String> itr = l.iterator(); while (itr.hasNext())
		 * System.out.println(itr.next());
		 */

		int totalWords = l.size();
		Random rand = new Random();

		
		for(int i = 0; i != iterations; i++) {
			int index = Math.round(rand.nextInt(totalWords) % totalWords);
			
			Word word = new Word();
			word.index = index;
			word.word = (String) l.get(index);
			this.words.add(word);
		}
		
		SentenceComposite sc = new SentenceComposite();
		
		for(Word word: this.words) {
			sc.add(word);
		}
		
		String result = "";
        for (Iterator i = sc.getChildren(); i.hasNext(); ) {
            Object objet = i.next();
			
            Composant composant = (Composant)objet;

            result += " " + composant.getWord();
        }
        
        String position = "";
        for (Iterator i = sc.getChildren(); i.hasNext(); ) {
            Object objet = i.next();
			
            Composant composant = (Composant)objet;

            position += " " + composant.getIndex();
        }
        
		System.out.println(result);
		System.out.println(position);
		
		if (result == password) {
			System.out.println("Le mot de passe a �t� trouv�! MOUHAHAHAHAHAHAHAHAHA");
		}

		
	}

	public static List<String> readFileInList(String fileName) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		}

		catch (IOException e) {

			// do something
			e.printStackTrace();
		}
		return lines;
	}
}
