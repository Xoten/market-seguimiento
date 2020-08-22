import static org.junit.jupiter.api.Assertions.*;
package model;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import exceptions.InvalidNumberException;
import exceptions.InvalidTypeException;
import model.Market;

class TestcheckCedula {

private Market minimarketTest;
	
	public void setUpStageOne() {
		minimarketTest = new Market();
	}
	
	@Test
	void RregisterVisitorsTest() {

		setUpStageOne();
          int documentTest = 6;
		try {
			minimarketTest.checkCedula("1994169512" );
			assertEquals(1994169512, minimarketTest.getClients().get(0).getidNumber(),"the person was not succesfully registered.");
			assertEquals(1, minimarketTest.getEntries(),"The visitor was registered"
					+ " but was not added to the visitors count.");
		
			
		} catch (InvalidNumberException invalidNumberException) {
			if (LocalDate.now().getDayOfMonth()%2 == 0) {
				fail("invalidNumberException not expected.\nthe document(pair) should be allowed to enter on this day(pair)");
			}else {
				assertEquals(1, minimarketTest.getEntries(),"The visitor was not registered(id type didnt match) "
						+ " but was not added to the visitors count.");
			}
			
		}catch (InvalidTypeException invalidTypeException) {
			fail("invalidTypeException not expected.\nThe document registered does not match the type expected");
		}



		setUpStageOne();
		documentTest = 7;
		try {
			minimarketTest.checkCedula("1986169713" );
			assertEquals(1986169713, minimarketTest.getClients().get(0).getidNumber(),"the person was not succesfully registered.");
			assertEquals(1, minimarketTest.getEntries(),"The visitor was registered"
					+ " but was not added to the visitors count.");
			
		} catch (InvalidNumberException invalidNumberException) {
			if (LocalDate.now().getDayOfMonth()%2 == 0) {
				assertEquals(1, minimarketTest.getEntries(),"The visitor was not registered(id type didnt match) "
						+ " but was not added to the visitors count.");
				
			}else {
				fail("invalidNumberException not expected.\nthe document(odd) should be allowed to enter on this day(odd)");
				
			}
			
		}catch (InvalidTypeException invalidTypeException) {
			fail("invalidTypeException not expected.\nThe document registered does not match the type expected");
		}



		setUpStageOne();
		documentTest = 5;
		try {
			minimarketTest.checkId(documentTest);
			fail("the registration of an under age should trow an invalidTypeException.");
			
		} catch (InvalidNumberException invalidNumberException) {
				fail("invalidNumberException not expected.\nthe document type from an under age should not generate the invalidNubmerException");

		}catch (InvalidTypeException invalidTypeException) {
			assertEquals(1, minimarketTest.getEntries(),"The visitor was not registered(id type mismatch)"
					+ " but was not added to the visitors count.");
		}
		
	}

}
