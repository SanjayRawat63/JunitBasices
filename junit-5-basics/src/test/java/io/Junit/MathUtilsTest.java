package io.Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@DisplayName("MathUtils Running")
class MathUtilsTest {
     MathUtils m;
     
     @BeforeEach
     void init()
     {
    	m=new MathUtils(); 
    	System.out.println("Before Each");
     }
     
     @AfterEach
     void clean()
     {
    	System.out.println("After Each"); 
     }
     
     @BeforeAll
     static void Beforeall()    //static because it runs before the instance of the class is created.
     {
    	 System.out.println("This methods run first");
     }
	 @Nested
	 @DisplayName("Add method testing")
	 class AddTest{
     @Test
     @DisplayName("Testing add for + postive no")
	 void testAddPositive()
	 {

		assertEquals(15,m.add(9, 6),()->"should return 15 but returning"+m.add(9, 6));
	}
     @Test
     @DisplayName("Testing add for -ve no")
     void testAddNegtive()
	 {
		assertEquals(-2,m.add(-1,-1),"The add method");
	}
	}
	 @Test
	 @DisplayName("Testing divide method")
	 void testdivide()
	 {
	    assertThrows(ArithmeticException.class,()->m.divide(3, 0),"Divide by zero");
	
	    //Unexpected exception type thrown ==> expected: <java.lang.NullPointerException> but was: <java.lang.ArithmeticException>
	    //	assertThrows(NullPointerException.class,()->m.divide(3, 0),"Divide by zero");	
	 }
	 @Test
	 @DisplayName("Testing Multiply Method")
	 void testmul()
	 {
		 assertAll(
				 ()->assertEquals(10,m.mul(5, 2)),
				 ()->assertEquals(0,m.mul(5, 0)),
				 ()->assertEquals(-10,m.mul(5, -2))
				 );
		 
	 }
	 @Test
	 @DisplayName("Subtarction Method testing")
	 @RepeatedTest(1)
	 void sub()
	 { 
			assertEquals(2,m.sub(4, 2),()->"should return 2 but returning "+m.sub(4,2));
	 }
	 @Test
	 @DisplayName("Mod method should not run")
	 @Disabled
	 void mod()
	 {
		 fail("test fails");
	 }

}
