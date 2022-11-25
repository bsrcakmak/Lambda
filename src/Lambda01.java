import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {

     /*
      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.
      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
   */


        List<Integer> sayi = new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));

        printElStructured(sayi); // 34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n*****************");
        printElFunctional(sayi); // 34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n*****************");
        printElFunctional1(sayi); // 342216113520632165446664813815
        System.out.println("\n*****************");
        printElFunctional2(sayi); // 34 22 16 11 35 20 63 21 65 44 66 64 81 38 15
        System.out.println("\n*****************");
        printCiftElFunctional(sayi); // 34 22 16 20 44 66 64 38
        System.out.println("\n*****************");
        printCiftOtzKckFunctional(sayi); // 22 16 20
        System.out.println("\n*****************");
        printCiftOtzBykFunctional(sayi); // 34 22 16 35 20 63 65 44 66 64 81 38


    }

    // TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElStructured(List<Integer> sayi){

        for (Integer w: sayi){
            System.out.print(w+" ");
        }
    }

    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void printElFunctional(List<Integer> sayi){
        sayi.
                stream().
                forEach((t) -> System.out.print(t+" ")); // lambda expression --> Lambdanin nasil calisacagini biz soyluyoruz
                                                         // buda lambda nin yapisina aykiri aslinda
                                                         // o yuzden cok tercih edilmemeli
    }

    public static void printElFunctional1(List<Integer> sayi) {
        sayi.
                stream().
                forEach(System.out::print); // method referance da Lambdaya ne yapacagini soyluyoruz sadece
                                            // ama burda isimizi gormedi, bosluk birakmadi

        // Bir Class'in icinden hangi methodu cagirmak istiyorsak :: kullanmamiz gerekiyor
    }


    // ====> Kendimiz bir method olusturalim ve onu cagiralim
    public static void yazdir(int a){
        System.out.print(a+" ");
    }

    public static void printElFunctional2(List<Integer> sayi) {
        sayi.
                stream().
                forEach(Lambda01::yazdir);  // classta bulunan methodu cagirmis olduk

        // "method referance" ın eksik kaldığı yerde kendimiz gerekli özelleştirmeyi sağlıyoruz
        // art arda method change yapmak icin :: yapisini kullanmamiz lazim
    }



    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElFunctional(List<Integer> sayi){

        sayi.
                stream().
                filter(t-> t%2==0).        // Lambda expression
                forEach(Lambda01::yazdir);
        // pespese if ve for each yapmis olduk
        // filter() methodunu if gibi kullaniyoruz
        // herbir method ciktisini diger methoda aktariyor

    }

    //TASK  : structural Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftElStructural(List<Integer> sayi){
        for (Integer w:sayi){
            if (w%2==0){
                System.out.print(w+" ");
            }
        }
    }

    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtzKckFunctional(List<Integer> sayi){

        sayi.
                stream().
                filter(t->t<34).
                filter(t->t%2==0).
                //filter(t->t<34 && t%2==0).  // yukaridaki ayni iki methot'daki islemi tek methot'da da yapabiliriz
                forEach(Lambda01::yazdir);
    }

    //TASK :stractural Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    // odevvvvvvvvvvvvvvvvvvvv





    //Task : functional Programming ile list elemanlarinin 34 den buyk veya cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printCiftOtzBykFunctional(List<Integer> sayi){
        sayi.stream().filter(t-> t%2==0 || t>34).forEach(Lambda01::yazdir);
    }



}
