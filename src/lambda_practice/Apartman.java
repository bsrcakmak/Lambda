package lambda_practice;

public class Apartman {

    private String cephe;
    private int katSayisi;
    private int kira;

    // 1-) Parametresiz const.
    public Apartman() {
    }

    // 2-) Bol parametreli const.
    public Apartman(String cephe, int katSayisi, int kira) {
        this.cephe = cephe;
        this.katSayisi = katSayisi;
        this.kira = kira;
    }

    // 3-) Getter-Setter
    public String getCephe() {
        return cephe;
    }

    public void setCephe(String cephe) {
        this.cephe = cephe;
    }

    public int getKatSayisi() {
        return katSayisi;
    }

    public void setKatSayisi(int katSayisi) {
        this.katSayisi = katSayisi;
    }

    public int getKira() {
        return kira;
    }

    public void setKira(int kira) {
        this.kira = kira;
    }

    // 4-) toString
    @Override
    public String toString() {
        return "Apartman{" +
                "cephe='" + cephe + '\'' +
                ", katSayisi=" + katSayisi +
                ", kira=" + kira +
                '}';
    }




}
