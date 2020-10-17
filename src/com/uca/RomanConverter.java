package com.uca;


import java.util.Collection;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class RomanConverter{
	
	// Table des symboles
	private static final Collection<RomanNumber> SYMBOLS = new ArrayList<>();
	static {
		SYMBOLS.add(new RomanNumber(1000, "M"));
		SYMBOLS.add(new RomanNumber(900, "CM"));
		SYMBOLS.add(new RomanNumber(500, "D"));
		SYMBOLS.add(new RomanNumber(400, "CD"));
		SYMBOLS.add(new RomanNumber(100, "C"));
		SYMBOLS.add(new RomanNumber(90, "XC"));
		SYMBOLS.add(new RomanNumber(50, "L"));
		SYMBOLS.add(new RomanNumber(40, "XL"));
		SYMBOLS.add(new RomanNumber(10, "X"));
		SYMBOLS.add(new RomanNumber(9, "IX"));
		SYMBOLS.add(new RomanNumber(5, "V"));
		SYMBOLS.add(new RomanNumber(4, "IV"));
		SYMBOLS.add(new RomanNumber(1, "I"));
	  }

	// Expression reguliere de validation
	private static final Pattern VALIDATION_RE = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");


	public static String getRomanFromNumber(int a) throws IllegalArgumentException{
		String resultat = "";
		if (a < 0) {
				System.out.println("La valeur " + a + " est inferieure a zero et n'existe pas en version romaine");
		}
		else if (a == 0) {
			System.out.println(" Il n'existe pas de chiffre zero en version romaine");
		}
		else if (a > 3999) {
				System.out.println("Il n'existe pas de nombre " + a +" en version romaine" );
		}
		else {
			for (RomanNumber element : SYMBOLS) {
				while (a >= element.getValue()) {
					resultat = resultat + element.getRoman();
					a = a - element.getValue();
				}
			}
		}
		return resultat;
	}

	public static int getNumberFromRoman(String a) throws IllegalArgumentException{
		int resultat = 0;
		int index = 0;
		boolean b = Pattern.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$",a);
		if (b == false){
			System.out.println("Le chiffre romain que vous avez inscrit n'existe pas");
		}
		else {
			for (RomanNumber element : SYMBOLS) {
				try {
					while (a.substring(index, index + element.getRoman().length()).equals(element.getRoman())) {
						resultat = resultat + element.getValue();
						index = index + element.getRoman().length();
					}
				} catch (Exception e) {

				}
			}
		}
		return resultat;
	}
}