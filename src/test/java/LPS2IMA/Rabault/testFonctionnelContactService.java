package LPS2IMA.Rabault;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import LPS2IMA.Rabault.Contact.Contact;
import LPS2IMA.Rabault.Contact.ContactService;


public class testFonctionnelContactService {
	private ContactService service ;
	@Before
	public void setUp() {
		service = new ContactService() ;
	}
	
	@Test
	public void testSupprimerContactOk() {
		Contact c = new Contact("Moi","0646534285");
		ContactService.supprimerContact(c);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSupprimerContactContactNonExistant() {
		ContactService.supprimerContact(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSupprimerContactNull() {
		Contact c = new Contact("Moine","0646534285");
		ContactService.supprimerContact(c);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreerContactWithNameLengthUnderThree() {
		ContactService.creerContact("AL","0200000000");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreerContactWithNameLengthSuperiorToTheLimit() {
		ContactService.creerContact("ALaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","0200000000");
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreerContactWithNameNulll() {
		ContactService.creerContact(null,"02020202020");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCreerContactWithNameVide() {
		ContactService.creerContact("","02020202020");
	}
	
	@Test (expected = IllegalStateException.class)
	public void testCreerContactDoublon() {
		ContactService.creerContact("Moi","0646534285");
		ContactService.creerContact("Moi","0646534285");
	}
	
	@Test
	public void testCreerContactWithCorrectParameter() {
		ContactService.creerContact("Moii","0646534285");
	}
}
