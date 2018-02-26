import java.util.Map;
import java.util.TreeMap;

public class Login {
    private Map<String, String> usuarios = new TreeMap<>();

    public Login() {
        usuarios.put("Dave", "mumo");
    }

    public boolean login (String user, String password) {
        return usuarios.get(user).contentEquals(password);
    }
}
