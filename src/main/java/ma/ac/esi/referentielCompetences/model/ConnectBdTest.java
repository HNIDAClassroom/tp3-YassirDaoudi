package ma.ac.esi.referentielCompetences.model;

public class ConnectBdTest {

	public static void main(String[] args) {
		
		ConnectBd conbd = new ConnectBd();
		try {
		User u = conbd.FindUser("user1", "password");
		System.out.println(u.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
