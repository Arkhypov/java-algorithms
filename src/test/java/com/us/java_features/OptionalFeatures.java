package com.us.java_features;

import java.util.Optional;

import org.junit.Test;

class Modem {
    private Double price;
 
    public Modem(Double price) {
        this.price = price;
    }
    //standard getters and setters

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

public class OptionalFeatures {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getMyDefault() {
	    System.out.println("Getting Default Value");
	    return "Default Value";
	}
	
	@Test
	public void notNullOptional(){
		Optional<String> s = Optional.of("value");
		Assert.assertEquals("Optional[value]", s.toString());
	}
	
	@Test(expected = NullPointerException.class)
	public void nullOptional(){	
		String text=null;
		Optional<String> s = Optional.of(text);
	}
	
	@Test
	public void optionalIfPresent(){	
		String text="someText";
		Optional<String> s = Optional.of(text);
		s.ifPresent(name -> System.out.println(name.length()));
	}
	
	@Test
	public void optionalOfNullable(){	
		String text=null;
		Optional<String> s = Optional.ofNullable(text);
		Assert.assertEquals("Optional.empty", s.toString()); //return empty
		Assert.assertFalse(s.isPresent());
	}
	
	@Test
	public void optionalOrElse(){
		String text = null;
		String testT = Optional.ofNullable(text).orElse("randomText");
		String name = Optional.ofNullable(text).orElseGet(() -> "john");
		Assert.assertEquals("randomText", testT);
		Assert.assertEquals("john", name);
	}
	
	public boolean priceIsInRange2(Modem modem2) {
	     return Optional.ofNullable(modem2)
	       .map(Modem::getPrice)
	       .filter(p -> p >= 10)
	       .filter(p -> p <= 15)
	       .isPresent();
	 }
	
	@Test
	public void testOptionalEmpty(){
		Optional<String> x = Optional.empty();
		Assert.assertFalse(x.isPresent());
	}
	
	@Test
	public void whenOptionalFilterWorks_thenCorrect() {
	    Integer year = 2016;
	    Optional<Integer> yearOptional = Optional.of(year);
	    boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
	    Assert.assertTrue(is2016);
	    boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
	    Assert.assertFalse(is2017);
	}
	
	@Test
	public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
	    String text = "Text present";
	 
	    System.out.println("Using orElseGet:");
	    String defaultText 
	      = Optional.ofNullable(text).orElseGet(this::getMyDefault);
	    Assert.assertEquals("Text present", defaultText);
	 
	    System.out.println("Using orElse:");
	    defaultText = Optional.ofNullable(text).orElse(getMyDefault());
	    Assert.assertEquals("Text present", defaultText);
	}
	
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void whenOrElseThrowWorks_thenCorrect() {
	    String nullName = null;
	    String name = Optional.ofNullable(nullName).orElseThrow(
	      IllegalArgumentException::new);
	}
	
	
	
	
	
}
