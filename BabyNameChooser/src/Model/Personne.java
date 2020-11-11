package Model;

public class Personne {
     private int idpersonne;
     private String nom;
     private String prenom;
     private String sexe;
     private String email;
     private String password;
     private String statut;
     private String religion;
     private String emailconjoint;
     private String cle;




    public Personne() {
    }

    public Personne(String nom, String prenom, String sexe, String email, String password, String statut, String religion, String emailconjoint, String cle) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.email = email;
        this.password = password;
        this.statut = statut;
        this.religion = religion;
        this.emailconjoint = emailconjoint;
        this.cle = cle;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", statut='" + statut + '\'' +
                ", religion='" + religion + '\'' +
                ", emailconjoint='" + emailconjoint + '\'' +
                ", cle='" + cle + '\'' +
                '}';
    }

    public int getIdpersonne() {
        return idpersonne;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEmailconjoint() {
        return emailconjoint;
    }

    public void setEmailconjoint(String emailconjoint) {
        this.emailconjoint = emailconjoint;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }
    public static void afficherenfant (){

    }
    public static void childfororigine(String origine){

    }


}
