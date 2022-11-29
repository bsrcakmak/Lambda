import javax.swing.plaf.PanelUI;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {

        System.out.println(topla(5)); // 15
        System.out.println(toplaCincix(5)); // 15
        System.out.println(toplaCift(4)); // 6
        System.out.println(toplaIlkXCift(4)); // 20
        System.out.println(toplaIlkXTek(3)); // 9
        ikininIlkXKuvvetPrint(3); // 2 4 8
        System.out.println();
        istenenSayiIlkXKuvvetPrint(3,2); // 3 9
        System.out.println();
        System.out.println(istenenSayiFaktoriyel(5)); // 120
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
    // tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x) {
        int toplam =0;
        for(int i=0 ; i<=x ; i++ ) {
            toplam = toplam + i ;
        }
        return toplam;
    }

    // Functional
    public static int toplaCincix(int x) {  // List<Integer> x ---> x.stream().
        return IntStream. // int değerlerde bir akış sağlar
                range(1,x+1). // range(a,b) --> a dan b'ye kadar ( b dahil değil) int değerler akısa alındı
                sum();// akışdan gelen değerler toplandı
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1,x).
                filter(Lambda01::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaCiftIlk(int x){
        return IntStream.
                rangeClosed(1,x*2).
                filter(Lambda01::ciftBul).
                sum();
    }
    public static int toplaIlkXCift(int x){
        return IntStream.
                iterate(2,t->t+2).  // 2 den sonsuza kadar elemanlara 2 ekleyerek akisa alir
                limit(x). // x ile sinirliyoruz
                sum();  // akistan gelen butun degerleri topluyoruz
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x){
        return IntStream.
                iterate(1,t->t+2).  // 1 den sonsuza kadar elemanlara 2 ekleyerek akisa alir, yani tum pozitif tek sayilari
                limit(x). // x ile sinirliyoruz
                sum();  // akistan gelen butun int degerleri topluyoruz
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x){
        IntStream.   // elimizde collection olmadigi icin boyle yaziyoruz
                iterate(2,t->t*2). // iterasyon icin sartimizi yazdik
                limit(x). // x degeri ile sinirladik
                forEach(Lambda01::yazdir); // Lambda01 class;indaki yazdir() metodunu cagirarak ekrana yazdirdik
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi,int x){
        IntStream.
                iterate(istenenSayi, t->t*istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi create ediniz.
    public static int istenenSayiFaktoriyel(int x){
        return IntStream.  // int akis basladi
                rangeClosed(1,x). // rangeClosed(1.5) --> 1,2,3,4,5
                reduce(1,(t,u)-> t*u); // t baslangictan baslar(1) , u da akistan alir, her carpim tekrar t ye gider t oyle devam eder
    }


}
