package com.uca;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), equalTo(null));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-4)), equalTo(null));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), equalTo(null));
        assertThat(RomanConverter.getNumberFromRoman("IIII"), equalTo(0));
        assertThat(RomanConverter.getNumberFromRoman("VVCC"), equalTo(0));
        assertThat(RomanConverter.getNumberFromRoman("XCX"), equalTo(0));
        // Test sur la vérification du fait que la valeur romaine de 6 est en majuscule
        assertThat(RomanConverter.getRomanFromNumber(6).toUpperCase(), equalTo(RomanConverter.getRomanFromNumber(6)));
	}
	
	@Test
	public void Comparaison(){
        RomanNumber number = new RomanNumber(4);
		assertThat(number.doubleValue(), equalTo(4.0));
        assertThat(number.longValue(), equalTo(4l));
	}

	@Test
	public void ComparaisonEntier_Entier(){
        RomanNumber number = new RomanNumber(4);
        assertThat(number.compareTo(3), equalTo(1));
        assertThat(number.compareTo(4), equalTo(2));
        assertThat(number.compareTo(5), equalTo(3));
    }

    @Test
    public void ComparaisonRomain_Romain(){
        RomanNumber number = new RomanNumber("IV");
        assertThat(number.compareTo("III"), equalTo(4));
        assertThat(number.compareTo("IV"), equalTo(5));
        assertThat(number.compareTo("VI"), equalTo(6));
    }

    @Test
    public void ComparaisonEntier_Romain(){
        RomanNumber number = new RomanNumber(4);
        assertThat(number.compareTo("III"), equalTo(4));
        assertThat(number.compareTo("IV"), equalTo(5));
        assertThat(number.compareTo("VI"), equalTo(6));
    }

    @Test
    public void ComparaisonRomain_Entier(){
        RomanNumber number = new RomanNumber("IV");
        assertThat(number.compareTo(3), equalTo(1));
        assertThat(number.compareTo(4), equalTo(2));
        assertThat(number.compareTo(6), equalTo(3));
    }

    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
