package LPS2IMA.Rabault;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.Mock;
import
org.easymock.TestSubject;
import org.junit.Test;
import org.testng.Assert;

import LPS2IMA.Rabault.Contact.Contact;
import LPS2IMA.Rabault.Contact.ContactExistException;
import LPS2IMA.Rabault.Contact.ContactService;
import LPS2IMA.Rabault.Contact.IContactDAO;

public class ContactServiceMockTest extends MockTest{
	
	@TestSubject
	private ContactService service = new ContactService();
	
	@Mock
	private IContactDAO dao;
	
	@Test
	public void testCreerContactErr() throws IllegalStateException {
		//Phase d'enregistrement
		String nom = "ContactOk";
		EasyMock.expect(dao.isContactExist(nom)).andReturn(false);
		
		Capture<Contact> capture = EasyMock.newCapture();
		dao.creerContact(EasyMock.capture(capture));
		//Fin de l'enregistrement
		replayAll();
		
		//Appel de la méthode
		service.creerContact(nom, "0");
		
		//Verification
		verifyAll();
		
		Contact c = capture.getValue();
		Assert.assertEquals(nom,  c.getNom());
	}
	/*
	@Test
	public void testSupprimerContactok() throws ContactExistException {
		//Phase d'enregistrement
		Contact c = new Contact("Moi", "0646534285");
		EasyMock.expect(dao.supprimerContact(c)).andReturn();
		//Fin de l'enregistrement
		replayAll();
		
		//Appel de la méthode
		service.creerContact(nom, "0");
		
		//Verification
		verifyAll();
	}*/
}
