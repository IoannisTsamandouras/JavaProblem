package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MusicStore {

	public static void main(String[] args) {

		List<Song> songs = new ArrayList<Song>();

		List<String> codes = new ArrayList<String>();
		List<String> titles = new ArrayList<String>();
		List<String> artists = new ArrayList<String>();
		HashSet<String> barcodes = new HashSet<String>();
		Scanner sc = new Scanner(System.in);
		
		int menu = (songs.isEmpty())? 1: 2;
		
		switch (menu) {
		case 1:
			if (songs.isEmpty()) {
				System.out.println("Enter menu option: 1/2");
				System.out.println("1. Add a song");
				System.out.println("2. Exit application");
				String ans = sc.next();
				if (ans.equals("2")) {
					System.out.println("Thank you");
					break;
				}
				
				System.out.println("Please enter code: ");
				codes.add(sc.next());
				System.out.println("Please enter title: ");
				titles.add(sc.next());
				System.out.println("Please enter artist name: ");
				artists.add(sc.next());
				System.out.println("Please enter barcode: ");
				barcodes.add(sc.next());

				System.out.println("Do you want to add a directory Y/n?");
				String answ = sc.next();

				if (answ.equals("n")) {
					System.out.println("Thanks for adding to the directory");
					break;
				}
			}
			break;
		case 2:
			if (!songs.isEmpty()) {
				
				System.out.println("Enter menu option: 1-7");
				System.out.println("1. Create song entry");
				System.out.println("2. Show song entry");
				System.out.println("3. Delete song entry");
				System.out.println("4. List all song entries by title");
				System.out.println("5. List all song entries by release-date");
				System.out.println("6. List all song entries by popularity");
				System.out.println("7. Exit application");
				String answer = sc.next();
				
				if(answer.equals("1")) {
					System.out.println("Please enter code: ");
					codes.add(sc.next());
					System.out.println("Please enter title: ");
					titles.add(sc.next());
					System.out.println("Please enter artist name: ");
					artists.add(sc.next());
					System.out.println("Please enter barcode: ");
					barcodes.add(sc.next());
					System.out.println("Do you want to add a directory Y/n?");
					String answ = sc.next();

					if (answ.equals("n")) {
						System.out.println("Thanks for adding to the directory");
						break;
					}					
				}
				else if(answer.equals("2")) {
					// use "some_code".contains("part_of_code") for partial search
					songs.stream().filter(c -> "some_code".equals(Song.getCode())).findAny().orElse(null);					
									
				}
				else if(answer.equals("3")){
					songs.stream().filter(e -> !"some_code".equals(Song.getCode())).collect(Collectors.toList());
					for(Song song : songs) {						
						System.out.println(" " + song.toString());					
					}					
				}
				else if(answer.equals("4")){
					Filter<Song,String> filter = new Filter<Song,String>() {
			            public boolean isMatched(Song object, String text) {
			                return object.getTitle().startsWith(String.valueOf(text));
			            }
			        };
			        
			        List<Song> sortedSongs = new FilterList<String>().filterList(songs, filter, "title");
			        
			        for(Song song : sortedSongs) {						
						System.out.println(" " + song.toString());					
					}
				}
				else if(answer.equals("5")){								
					Comparator<Song> c = (s1, s2) -> s1.getDate().compareTo(s2.getDate());
					songs.sort(c);
					Collections.reverse(songs);
					songs.forEach(System.out::println);									
				}
				else if(answer.equals("6")){
					Comparator<Song> c = (s1, s2) -> s1.getSales().compareTo(s2.getSales());
					songs.sort(c);
					songs.forEach(System.out::println);					
				}
				else if(answer.equals("7")){
					System.out.println("Thank you");
					break;
				}				
			}
			break;
		default:
			System.out.println("An unknown error occurred!");
		}
	}
}
