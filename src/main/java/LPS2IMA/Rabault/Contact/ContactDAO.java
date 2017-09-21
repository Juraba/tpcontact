package LPS2IMA.Rabault.Contact;

import java.util.ArrayList;


public class ContactDAO implements IContactDAO{
	private ArrayList<Contact> listeContacts;
	
	public ContactDAO() {
		listeContacts = new ArrayList<Contact>();
	}
	
	public void creerContact(Contact c) {
		if(c != null) {
			if(!isContactExist(c.getNom())) {
				listeContacts.add(c);
				System.out.println("Ajout du contact");
			}
			
		}
		else {
			System.out.println("Erreur d'ajout");
			throw new IllegalArgumentException("Erreur d'ajout");
		}
	}
	
	public boolean isContactExist(String n) {
		boolean bool = false;
		int i=0;
		while(!bool && i < listeContacts.size()) {
			if((listeContacts.get(i).getNom()).equals(n)) {
				bool = true;
				System.out.println("Contact déjà existant");
				throw new IllegalStateException("Contact déjà existant");
			}
			i++;
		}
		return bool;
	}
	
	public Contact recupererContact(String n) {
		Contact c = null;
		boolean bool = false;
		int i=0;
		if(n != null) {
			while(!bool && i < listeContacts.size()) {
				if((listeContacts.get(i).getNom()).equals(n)) {
					c = listeContacts.get(i);
					bool = true;
				}
				i++;
			}
		}
		
		if(!bool) {
			System.out.println("Contact non existant");
			throw new IllegalStateException("Contact non existant");
		}
		return c; 
	}
	
	public void supprimerContact(Contact c) {
		boolean bool = false;
		int i=0;
		if(c.getNom() != null  && c.getTel() != null) {
			if(!isContactExist(c.getNom())) {
				throw new IllegalStateException("Contact non existant");
			}
			else {
				while(!bool && i < listeContacts.size()) {
					if((listeContacts.get(i).getNom()).equals(c.getNom()) && (listeContacts.get(i).getTel()).equals(c.getTel())) {
						bool = true;
						listeContacts.remove(i);
					}
					i++;
				}
			}
		}
		
	}
}
