package Model;

public class Enfant {
    private int idenfant;
    private String prenom;
    private String signification;
    private String couleur;
    private String caractere;
    private int    numerologie;
    private String Genre;


    @Override
    public String toString() {
        return "Enfant{" +
                "prenom='" + prenom + '\'' +
                ", signification='" + signification + '\'' +
                ", couleur='" + couleur + '\'' +
                ", caractere='" + caractere + '\'' +
                ", numerologie=" + numerologie +
                ", Genre='" + Genre + '\'' +
                '}';
    }



    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSignification(String signification) {
        this.signification = signification;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }

    public void setNumerologie(int numerologie) {
        this.numerologie = numerologie;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getIdenfant() {
        return idenfant;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSignification() {
        return signification;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getCaractere() {
        return caractere;
    }

    public int getNumerologie() {
        return numerologie;
    }

    public String getGenre() {
        return Genre;
    }
}
