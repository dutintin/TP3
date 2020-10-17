package com.uca;
import java.util.regex.Pattern;
import java.lang.*;
public class Start{
	//DUBREUIL Valentin
	//HAMMOUCHE Yasmine
	//Start class
	public static void main(String[] args){
	RomanNumber numberA = new RomanNumber();
	if (args.length > 0){
		try {
			numberA.setValue(Integer.parseInt(args[0]));
			//Comparaison d'un chiffre arabe donné en argument avec la valeur X présente dans numberA.compareTo(X)
			System.out.println(numberA.compareTo(5));
			if (numberA.getRoman()!="")
			System.out.println("La valeur romaine de " + args[0] + " est "+ numberA.getRoman());
		} catch (Exception e){
			// voir RomanNumber.setRoman dans lequel a été ajouté un UpperCase pour gérer les cas de lettres en minuscules et les passer en majuscules
			numberA.setRoman(args[0]);
			//Comparaison d'un chiffre romain donné en argument avec la valeur X présente dans numberA.compareTo(X)
			System.out.println(numberA.compareTo(5));
			//La valeur entre 1 et 6 affichée est nécessaire pour la prise en charge des tests unitaires Cf RomanNumber.java ligne 78
			if (numberA.getValue()!=0){
				System.out.println("La valeur arabe de " + args[0].toUpperCase() + " est "+ numberA.getValue());
			}
		}
	}
	}
	
}