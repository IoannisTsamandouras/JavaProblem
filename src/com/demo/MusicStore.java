package com.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class MusicStore {

	public static void main(String[] args) {

		List<String> codes = new ArrayList<String>();
		List<String> titles = new ArrayList<String>();
		List<String> artists = new ArrayList<String>();
		HashSet<String> barcodes = new HashSet<String>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Please enter code: ");
			codes.add(sc.next());
			System.out.println("Please enter title: ");
			titles.add(sc.next());
			System.out.println("Please enter artist name: ");
			artists.add(sc.next());
			System.out.println("Please enter barcode: ");
			barcodes.add(sc.next());
			
			System.out.println("Do you want to add a directory Y/n?");
		    String answer = sc.next(); 

		    if (answer.equals("n")){
		        System.out.println("Thanks for adding to the directory");
		        break; 
		    }
		}
	}
}
