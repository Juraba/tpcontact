package LPS2IMA.Rabault.Contact;

public interface IContactDAO {
	public void creerContact(Contact c);
	
	public boolean isContactExist(String n);
	
	public Contact recupererContact(String n);
	
	public void supprimerContact(Contact c);
}
