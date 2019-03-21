package com.demo;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Song {
	
	@NotNull(message = "Code may not be null")
	@Size(max = 12, message = "Code must not be more than 12 characters long") 
	private static String code;
	
	@NotNull(message = "Title may not be null")
	private String title;
	
	@PastOrPresent
	private Date date;
	
	@NotEmpty(message = "Artist name must not be empty")
	private String artistName;
	
	@Positive
	private BigDecimal sales;
	
	@NotBlank
	private static String barcode;

	public Song(String code, String title, Date date, String artistName) {
		Song.code = code;
		this.title = title;
		this.date = new Date(date.getTime());  // Defensive copy
		this.artistName = artistName;
		this.sales = new BigDecimal(129623);
	}
	
	// Barcode format is XXX - XXX - XXX - XXX 
	public String formatBarcode(String inputStr) {

		if (inputStr.length() < 12) {
			StringBuilder sb = new StringBuilder();		

			for (int i = 0; i < 12; i++) {
				sb.append("0");
			}
			String padding = sb.toString();
			String paddedString = inputStr + padding.substring(inputStr.length());
			String newString = paddedString.substring(0, 3) + "-" + paddedString.substring(3, 6) 
			+ "-" + paddedString.substring(6, 9) + "-" + paddedString.substring(9, 12); 
			return newString;
		} 
		else {
			return inputStr.substring(0, 3)+ "-" + inputStr.substring(3, 6) 
			+ "-" + inputStr.substring(6, 9) + "-" + inputStr.substring(9, 12); 
		}
	}

	public static String getCode() {
		return code;
	}

	public static void setCode(String code) {
		Song.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		if(artistName == null ){
            throw new NullPointerException("Artist name can't be null");
        }
		this.artistName = artistName;
	}

	public BigDecimal getSales() {
		return sales;
	}

	public void setSales(BigDecimal sales) throws IllegalArgumentException {
		if (sales.compareTo(BigDecimal.ZERO) <= 0 ) {
		      throw new IllegalArgumentException("The value must be positive");
		    }
		this.sales = sales;
	}

	public static String getBarcode() {
		return barcode;
	}

	@Override
	public String toString() {
		return "\n\n Code : " + code + ", Title" + title + ", Date: " + date + ", Artist name: " + artistName
				+ ", Sales: " + sales + ", Barcode: " + barcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistName == null) ? 0 : artistName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (artistName == null) {
			if (other.artistName != null)
				return false;
		} else if (!artistName.equals(other.artistName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;		
		return true;
	}
	
	static class RockSong {
		
	}
	
	static class PopSong {
		
	}
	
	static class LoveSong {
		
	}

}
