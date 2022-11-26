import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        ciftKarePrint(sayi); // 16 4 36
        System.out.println("\n*****************");
        tekKupBirFazlaPrint(sayi); // 1332 -124 344 28 3376
        System.out.println("\n*****************");
        maxElBul(sayi);  // Optional[15]
        System.out.println("\n*****************");
        structuredMaxElBul(sayi); // En buyuk sayi: 15
        System.out.println("\n*****************");
        ciftKareMaxPrint(sayi); // Optional[36]
        System.out.println("\n*****************");
        elTopla(sayi); // toplam = 43
        System.out.println("\n*****************");
        ciftCarp(sayi); // Optional[48]
        System.out.println("\n*****************");
        minBul(sayi); // Optional[-5]
        System.out.println("\n*****************");
        bestenBykTekKckPrint(sayi); // Optional[7]
        System.out.println("\n*****************");
        ciftElKareKbSortPrint(sayi); // 4 16 36

    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).  // akistaki cift sayilari filtreledik
                map(t-> t*t).               // yeni bir stream olustu  // stream icerisindeki elemanalari baska degerlere donusturur
                forEach(Lambda01::yazdir);

    }


    // Task-2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak print edi

    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(t-> t%2!=0).
                map(t-> t*t*t+1).
                forEach(Lambda01::yazdir);

    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKarekokPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).           // double
                forEach(t-> System.out.println(t+" "));  // yazdir methodunda int deger var ama map double dondurdugu icin hata verdi
                                                         // o yuzden method referance yapamadik Lambda expression yaptik
    }


    // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi){

       Optional<Integer> maxSayi= sayi.  // yazdirabilmek icin atama yaptik  (Java 8 ile Optional gelmis)
                stream().
                reduce(Math::max);  // Eger result tek bir deger ise reduce() terminal operatoru kullanilir.

        // Eger sonuc listede yoksa veya reduce'ten once baska bir aralik olusturulmus ve orda aranan yoksa
        // o zaman NullPointerException verir,
        // akisa eleman gelmez ve null degeri alir , int da null alamaz o yuzden hata verir

        System.out.println(maxSayi);

    }

    // Structured yapi ile cozelim
    public static void structuredMaxElBul(List<Integer> sayi){
        int max = Integer.MIN_VALUE;
        System.out.println("max = " + max);
        for (int i=0; i<sayi.size();i++){
            if (sayi.get(i)>max)  max=sayi.get(i);
        }
        System.out.println("En buyuk sayi: " + max);

    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void ciftKareMaxPrint(List<Integer> sayi){

        System.out.println(sayi.         // Optional kullanarak atamak yerine direk sout icine koyarak yazdirabiliriz
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));   // Math::max yerine bunu yazmamizin sebebi daha hizli calismasi

    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression..

    public static void elTopla(List<Integer> sayi) {

        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);
        System.out.println("toplam = " + toplam);

        /*
         * a ilk degerini her zaman atanan degerden (ilk parametre) alır, bu örnekte 0 oluyor
         * b degerini her zamana  stream()'dan akısdan alır
         * a ilk degerinden sonraki her değeri action(işlem)'dan alır
         */
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));  // Method referance

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));  // Lambda expression
        // Optinal olmadi cunku null pointer verme ihtimali yok, 1 ile basladi her turlu sonuc gelir
    }


    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.

    public static void minBul(List<Integer> sayi){

        // 1. yol; method referance , Java kutuphanesinden cagirdik
        System.out.println(sayi.
                stream().
                reduce(Integer::min));    // Math::min   // Optional[-5]

        // 2. yol; method referance , kendimiz yazdik
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byMiracMin));  // Optional[-5]
    }

    public static int byMiracMin(int a, int b){
        return a<b ? a: b;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBykTekKckPrint(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                filter(a -> a > 5 && a % 2 == 1).
                reduce(Lambda02::byMiracMin));

    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void ciftElKareKbSortPrint(List<Integer> sayi){
        sayi.
                stream().                    // akisi baslattik
                filter(Lambda01::ciftBul).   // akis icindeki cift sayilari aldik
                map(t-> t*t).                // sayilarin karesi ile yeni bir akis baslattik
                sorted().                    // akis icindeki sayilari naturel-order olarak siraladik
                forEach(Lambda01::yazdir);   // akistaki sayilari ekrana yazdirdik
    }

}
