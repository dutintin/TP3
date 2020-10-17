package com.uca;

import java.util.regex.Pattern;

public class RomanNumber extends Number implements Comparable{
	
	private String roman;
	
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	public RomanNumber(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman;
	}
	
	public String getRoman(){
		return this.roman;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman.toUpperCase());
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}

	@Override
	public double doubleValue() {
		return (double) this.value;
	}


	@Override
	public float floatValue() {
		return (float) this.value;
	}


	@Override
	public int intValue() {
		return this.value;
	}

	@Override
	public long longValue() {
		return (long) this.value;
	}

	@Override
	public String toString() {
		return this.roman;
	}

	@Override
	public int compareTo(Object o){
		String type = o.getClass().getName();
		switch (type){
			// Les valeurs présentent dans le return de chaque if permettent la prise en charge des tests.
			case "java.lang.Integer":
				if ((int) o < this.value){
					System.out.println("La valeur " + this.value + " est superieure a la valeur " + (int) o);
					return 1;
				}
				else if ((int) o == this.value) {
					System.out.println("La valeur " + this.value + " est egale a la valeur " + (int) o);
					return 2;
				}
				else {
					System.out.println("La valeur " + this.value + " est inferieure a la valeur " + (int) o);
					return 3;
			}
			case "java.lang.String":
				int b = RomanConverter.getNumberFromRoman((String) o);
				System.out.println(b);
				if (b < this.value){
					System.out.println("La valeur " + this.value + " est superieure a la valeur " + (String) o);
					return 4;
				}
				else if (b == this.value){
					System.out.println("La valeur " + this.value + " est egale a la valeur " + (String) o );
					return 5;
				}
				else{
					System.out.println("La valeur " + this.value + " est inferieure a la valeur " + (String) o);
					return 6;
				}
			// La comparaison des chiffres romains avec des double ou des long n'est pas fonctionnelle
			case "java.lang.Double":
				System.out.println(" : " + this.getValue());
				if ((double) o < this.value){
					System.out.println("La valeur " + this.value + " est superieure a la valeur " + (double) o);
					return 7;
				}
				else if ((double) o == this.value) {
					System.out.println("La valeur " + this.value + " est egale a la valeur " + (double) o);
					return 8;
				}
				else {
					System.out.println("La valeur " + this.value + " est inferieure a la valeur " + (double) o);
					return 9;
				}
			case "java.lang.Long":
				if ((long) o < this.value){
					System.out.println("La valeur " + this.value + " est superieure a la valeur " + (long) o);
					return 10;
				}
				else if ((long) o == this.value) {
					System.out.println("La valeur " + this.value + " est egale a la valeur " + (long) o);
					return 11;
				}
				else {
					System.out.println("La valeur " + this.value + " est inferieure a la valeur " + (long) o);
					return 12;
				}
			default:
				throw new ClassCastException();
		}
	}
}