import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashHelper {
	public String Hash(String value){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
			md.update(value.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return md.digest().toString();
	}
}
