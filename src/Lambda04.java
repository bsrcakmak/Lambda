import java.util.*;
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

        System.out.println(matBolumSayisi(unv)); // 2
        System.out.println(ogrcSayisi550BykMaxNotOrt(unv)); // OptionalInt[93]
        System.out.println(ogrSayisi1050AzMinNotOrt(unv));
    }

    //task 01--> butun(allMatch) Univ. lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv){
        return unv.
                stream().  // akis sagladik --> u01,u02.... universiteler geliyor, asagida t ler bunlardan olusuyor
                allMatch(t-> t.getNotOrt()>74);
               // allMatch(); eger sarti hepsi saglarsa true, saglamayan bir tane bile durum varsa false doner
    }

    //task 02-->universite'lerde herhangi birinde(anyMatch) "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv){
        return unv.
                stream().  // akis saglandi
                anyMatch(t-> t.getBolum().  // objelerin bolum isimleri alindi
                        toLowerCase().  // bolum isimlerindeki karakterler kucuk harfe cevrildi
                        contains("mat")); // mat kelimesi var mi kontrol ettik
                // anyMatch(); eger sarti en az biri saglarsa true, hicbiri saglamazsa false doner
    }

    // task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.(dogal sirali olmadigi icin reverse gerekli)
    public static List<Universite> ogrSayisiBykSirala (List<Universite> unv){
        return unv.
                stream().  // akis saglandi
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                // universiteler ogrenci sayisina gore tersten siralandi
                collect(Collectors.toList()); // Stream yapisi List yapisina donusturuldu
    }

    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolumSayisi(List<Universite> unv){
        return (int) unv.  // long'u int'a cast ettik ==> explicit narrowing
                stream().
                filter(t-> t.getBolum(). // matematik bolumu olan uni.ler sectik
                        contains("mat")).count(); // secilen uni. sayisini aldik
    }

    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi550BykMaxNotOrt(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getOgrSayisi()>550).
                mapToInt(t-> (int) t.getNotOrt()).max();

    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayisi1050AzMinNotOrt(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getOgrSayisi()<1050).
                mapToInt(t-> (int) t.getNotOrt()).min();

    }




}
