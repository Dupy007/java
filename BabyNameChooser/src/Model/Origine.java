package Model;

public class Origine {
    private int idorigine;
    private String nomOrigine;

    public int getIdorigine() {
        return idorigine;
    }

    public String getNomOrigine() {
        return nomOrigine;
    }

    public void setNomOrigine(String nomOrigine) {
        this.nomOrigine = nomOrigine;
    }

    @Override
    public String toString() {
        return "Origine{" +
                "nomOrigine='" + nomOrigine + '\'' +
                '}';
    }
}
