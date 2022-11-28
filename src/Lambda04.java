import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
    */

    public static void main(String[] args) {

        Universite u01 = new Universite("Bogazici", "Matematik", 571, 93);
        Universite u02 = new Universite("Istanbul Tk.", "Matematik", 600, 81);
        Universite u03 = new Universite("Istanbul", "Hukuk", 1400, 71);
        Universite u04 = new Universite("Marmara", "Bilg. Muh.", 1080, 77);
        Universite u05 = new Universite("Odtu", "Gemi. Muh.", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv)); // false
        System.out.println(matBolumVarMi(unv)); // true
        System.out.println(ogrSayisiBykSirala(unv));
        // [Universite{univercity='Istanbul', bolum='Hukuk', ogrSayisi=1400, notOrt=71},
        // Universite{univercity='Marmara', bolum='Bilg. Muh.', ogrSayisi=1080, notOrt=77},
        // Universite{univercity='Istanbul Tk.', bolum='Matematik', ogrSayisi=600, notOrt=81},
        // Universite{univercity='Bogazici', bolum='Matematik', ogrSayisi=571, notOrt=93},
        // Universite{univercity='Odtu', bolum='Gemi. Muh.', ogrSayisi=333, notOrt=74}]
    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv){
        return unv.
                stream().  // akis sagladik --> u01,u02.... universiteler geliyor, asagida t ler bunlardan olusuyor
                allMatch(t-> t.getNotOrt()>74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv){
        return unv.
                stream().  // akis saglandi
                anyMatch(t-> t.getBolum().  // objelerin bolum isimleri alindi
                        toLowerCase().  // bolum isimlerindeki karakterler kucuk harfe cevrildi
                        contains("mat")); // mat kelimesi var mi kontrol ettik
    }

    // task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBykSirala (List<Universite> unv){
        return unv.
                stream().  // akis saglandi
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                // universiteler ogrenci sayisina gore tersten siralandi
                collect(Collectors.toList()); // Stream yapisi List yapisina donusturuldu
    }



}
