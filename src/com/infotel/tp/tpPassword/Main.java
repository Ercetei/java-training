package com.infotel.tp.tpPassword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class Main {

	public static void main(String[] args) {
    	PasswordFinder pf = new PasswordFinder();
    	File file = new File("E:\\POEI\\JAVA\\src\\com\\infotel\\tp\\tpPassword\\words.txt");
    	try {
			pf.findMyPassword("je suis gentil", file, 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

    }


}