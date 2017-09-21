package LPS2IMA.Rabault.Contact;


public class ContactService {
	
	private static IContactDAO dao;
	
	public static void main(String[] args) {
		
	}
	
	public static void creerContact(String nom, String telephone) {
		if(nom != null  &&  telephone != null) {
			if(nom != "" && telephone != "" && nom.length() >= 3 && nom.length() <= 40) {
				if(dao == null) {
					dao = new ContactDAO();
				}
				Contact c = new Contact(nom, telephone);
				dao.creerContact(c);
			}
			else {
				System.out.println("Données invalides");
				throw new IllegalArgumentException("Données invalides");
			}
		}
		else {
			System.out.println("Donnée(s) nulle(s)");
			throw new IllegalArgumentException("Donnée(s) nulle(s)");
		}
	}
	
	public static void supprimerContact(Contact c) {
		if(dao == null) {
			dao = new ContactDAO();
		}
		dao.supprimerContact(c);
	}
}
