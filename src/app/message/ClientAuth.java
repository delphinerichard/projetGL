package app.message;

public class ClientAuth extends Message {

    private String login;
    private String motDePasse;

    public ClientAuth(String login, String motDePasse) {
        this.login = login;
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "ClientAuth{" +
                "login='" + login + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

}
