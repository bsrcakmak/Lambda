import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trilece", "havucDilim", "guvec",
                "kokorec", "kusleme", "arabAsi", "affle", "kunefe"));

        alfBykTekrsz(menu); // ARABASI GUVEC HAVUCDILIM KOKOREC KUNEFE KUSLEME TRILECE WAFFLE
        System.out.println();
        charSayisiTersSilaliUnique(menu); // 10 7 6 5
        System.out.println();
        chrSayisiBykSirali(menu); // guvec waffle kunefe trilece kokorec kusleme arabAsi havucDilim
        System.out.println();
        harfSayisi7denAzKontrol(menu); // list elemanlari 7 harften buyuk
        System.out.println();
        wIleBaslayanElKontrol(menu); // w ile yemek icat ettik
        System.out.println();
        xIleBitenElKontrol(menu); // x ile yemek ismi biter mi hic
        System.out.println();
        charSayisiEnBykElPrint(menu); // [havucDilim]
        System.out.println();
        ilkElHrcSonHrfSirakiPrint(menu); // kokorec trilece kusleme affle kunefe arabAsi havucDilim
    }


    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrsz(List<String> yemek){
        yemek.
                stream().  // akis basladi
                map(String::toUpperCase).  // Buyuk harfe cevrildi
                sorted(). // dogal siralandi(alfabrtik)
                distinct(). // elemanlarin tekrarsiz olmasini sagladi *****
                forEach(t-> System.out.print(t+" ")); // print
    }


    // Task -2 : list elemanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void charSayisiTersSilaliUnique(List<String> ikram){
        ikram.
                stream().
                map(String::length). // akisi guncelledim kelimelerin uzunlugu olarak
                sorted(Comparator.reverseOrder()). // ters sirali
                distinct(). // tekrarsiz --> bu soru özelinde aynı karakter sayilarina sahip elemanlari tekrar etmez
                forEach(Lambda01::yazdir); // print
    }


    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBykSirali(List<String> ikram){
        ikram.
                stream().  // akis saglandi
                sorted(Comparator.comparing(String::length)). // String ifadeleri karakter sayisina gore k-> b ye gore siraladim
                forEach(Lambda01::yazdir); // print
    }


    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task-4 : List elemanlarinin hepsinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                allMatch(t-> t.length()<=7) ? "list elemanlari 7 ve daha az harften olusuyor" :
                "list elemanlari 7 harften buyuk");
    }


    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> ikram){
        System.out.println(ikram.
                stream().
                noneMatch(t-> t.startsWith("w")) ? "w ile yemek ismi mi olur":
                "w ile yemek icat ettik");
    }


    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı var mi kontrol ediniz.
    public static void xIleBitenElKontrol(List<String> ikram){
        System.out.println(ikram.stream().anyMatch(t-> t.endsWith("x")) ? "maasallah" :
                "x ile yemek ismi biter mi hic");
    }


    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiEnBykElPrint(List<String> ikram){
        Stream<String> sonIsim = ikram.
                stream(). // akis saglandi
                sorted(Comparator.comparing(t-> t.toString().length()).
                        reversed()). // karakter sayisina gore tersten siraladi
                        limit(1); // limit methodu kullanilarak sadece ilk eleman cagrildi
                        // limit() method'unun donen degeri Stream<String> yapidadir

        System.out.println(Arrays.toString(sonIsim.toArray()));
                        // sonIsim.toArray() --> Stream olan akis Array'a cevrildi
                        // Arrays.toString(sonIsim.toArray()) --> Array'i String yapiya ceviriyor
    }


    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHrcSonHrfSirakiPrint(List<String> ikram){
        ikram.
                stream(). // akis saglandi
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))). // son harfine gore alfabetik siralama
                skip(1). // akistaki ilk eleman haric tutuldu
                forEach(Lambda01::yazdir); // print edildi
    }






}
