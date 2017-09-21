package LPS2IMA.Rabault.Contact;

public class Contact {
	private String nom;
	private String tel;
	
	public Contact(String n, String t) {
		setNom(n);
		setTel(t);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
