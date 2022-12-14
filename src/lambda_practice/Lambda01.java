package lambda_practice;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        hepsiniYazdir(list); // -5 -8 -2 -12 0 1 12 5 5 6 9 15 8
        System.out.println("\n*******************");
        negatifYaz(list); // -5 -8 -2 -12
        System.out.println("\n*******************");
        ciftYazdir(list); // -8 -2 -12 0 12 6 8
        System.out.println("\n*******************");
        pozVeCift(list); // 12 6 8
        System.out.println("\n*******************");
        pozVeyaCiftYazdir(list); // -8 -2 -12 0 1 12 5 5 6 9 15 8
        System.out.println("\n*******************");
        karaYazdir(list); // 25 64 4 144 0 1 144 25 25 36 81 225 64
        System.out.println("\n*******************");
        ciftKupYazdir(list); // -512 -8 -1728 0 1728 216 512
        System.out.println("\n*******************");
        kareTekrarsiz(list); // 25 64 4 144 0 1 36 81 225
        System.out.println("\n*******************");
        elSirala(list); // -12 -8 -5 -2 0 1 5 5 6 8 9 12 15
        System.out.println("\n*******************");
        elTersSirala(list); // 15 12 9 8 6 5 5 1 0 -2 -5 -8 -12
        System.out.println("\n*******************");
        System.out.println("pozKup5List(list) = " + pozKup5List(list)); // pozKup5List(list) = [125, 125, 3375]
        pozKup5List2(list); // [125, 125, 3375]
        System.out.println("pozKareSon5DegilList(list) = " + pozKareSon5DegilList(list)); // pozKareSon5DegilList(list) = [1, 144, 36, 81, 64]
        System.out.println("elToplam(list) = " + elToplam(list)); // elToplam(list) = 34
        System.out.println("elToplamReference(list) = " + elToplamReference(list)); // elToplamReference(list) = 34
        System.out.println("elToplamReferenceInt(list) = " + elToplamReferenceInt(list)); //elToplamReferenceInt(list) = 34
        pozElToplam(list); // 61
    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz
    public static void hepsiniYazdir(List<Integer> l){

        l.stream().forEach(t-> System.out.print(t+" "));

    }


    //S2: sadece negatif olanlari yazdir
    public static void negatifYaz(List<Integer> l){

        l.stream().filter(t->t<0).forEach(t-> System.out.print(t+" "));
    }


    // S3: cift olanlardan yeni bir liste olustur
    public static void ciftYazdir(List<Integer> l){

        l.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));

    }


    // S4:pozitif ve ??ift olanlar?? yazd??r??n
    public static void pozVeCift(List<Integer> l){

        l.stream().filter(t->t%2==0 && t>0).forEach(t-> System.out.print(t+" "));

    }


    // S5:pozitif veya ??ift olanlar?? yazd??r??n
    public static void pozVeyaCiftYazdir(List<Integer> l){

        l.stream().filter(t-> t%2==0 || t>0).forEach(t-> System.out.print(t+" "));
    }


    // S6: list in elemanlarin karelerini ayn?? sat??rda b??r bosluklu yazd??ral??m
    // map():stream den gelen elemanlar?? baska tt??plere donusturmek veya uzerler??nde
    // ??slem yapmak ??c??n (update) kullan??l??r
    public static void karaYazdir(List<Integer> l){

        l.stream().map(t-> t*t).forEach(t->System.out.print(t+" "));

    }


    //S7: Listin cift elemanlar??n??n kuplerini  ayn?? sat??rda b??r bosluklu yazd??ral??m
    public static void ciftKupYazdir(List<Integer> l){

        l.stream().filter(t-> t%2==0).map(t-> t*t*t).forEach(t-> System.out.print(t+" "));
    }


    //S8 : list in elemanlarin karelerinden tekrarsiz yazd??ral??m
    public static void kareTekrarsiz(List<Integer> l){

        l.stream().map(t-> t*t).distinct().forEach(t-> System.out.print(t+" "));
    }
    //distinct() => Bu method tekrarl?? elemanlar?? sadece bir kere ak??sa sokar.
    // Bu ak??????n farkl?? elemanlar??ndan (Object.equals (Object) 'e g??re) olu??an bir ak???? d??nd??r??r.
    // S??ral?? ak????lar i??in, farkl?? eleman??n se??imi sabittir
    // (yinelenen ????eler i??in, kar????la??ma s??ras??nda ilk g??r??nen ????e korunur.)
    // S??ras??z ak????lar i??in, herhangi bir kararl??l??k garantisi verilmez. Stream return eder.


    //S9: listin elemanlarini kucukten buyuge siralayalim
    public static void elSirala(List<Integer> l){

        l.stream().sorted().forEach(t-> System.out.print(t+" "));
    }


    //S10: listin elemanlarini buyukten kucuge siralayalim
    public static void elTersSirala(List<Integer> l){

        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
    }


    // method'un uzerine gelip baktigimizdsa Stream'e goturuyorsa ara method'tur
    // method'un uzerine gelip baktigimizdsa void veriyorsa terminal method'tur, yani akisi durdurur


    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> pozKup5List(List<Integer> l){

        return l.stream().filter(t-> t>0).map(t-> t*t*t).filter(t-> t%10==5).collect(Collectors.toList());
    }


    public static void pozKup5List2(List<Integer>l){
        List<Integer>list=l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
        System.out.println(list);
    }


    //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozKareSon5DegilList(List<Integer>l){
        List<Integer> list = l.stream().filter(t-> t>0).map(t-> t*t).filter(t-> t%10!=5).collect(Collectors.toList());
        return list;
    }


    // S13 :list elemanlarini toplamini bulalim
    /*
    reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir, kullan??m?? yayg??nd??r pratiktir.
    Bir Stream i??erisindeki verilerin teker teker i??lenmesidir. Teker teker i??leme s??recinde, bir ??nceki ad??mda elde edilen sonu??
    bir sonraki ad??ma girdi olarak sunulmaktad??r. Bu sayede y??????lml?? bir hesaplama s??reci elde edilmi?? olmaktad??r.
    reduce metodu ilk parametrede identity de??eri, ikinci parametrede ise BinaryOperator t??r??nden bir obj kullan??l??r.
    reduce i??leminde bir ??nceki hesaplanm???? de??er ile s??radaki de??er bir i??leme tabi tutulmaktad??r.
    ????leme ba??larken bir ??nceki de??er olmad?????? i??in bu de??er identity parametresinde tan??mlanmaktad??r.
  */

    // Lambda expression ile;
    public static int elToplam(List<Integer>l){

        int i= l.stream().reduce(0, (x,y)->x+y);
        return i;
    }


    // Method reference ile;
    public static int elToplamReference(List<Integer>l){

        int i= l.stream().reduce(0,Math::addExact);  // Optional dan kurtulmak icin identity tanimladik
        return i;
    }


    public static int elToplamReferenceInt(List<Integer>l){

        int i= l.stream().reduce(0,Integer::sum);
        return i;
    }


    //S14 : List'in pozitif elemanlar?? toplam??n?? bulal??m
    public static void pozElToplam(List<Integer>l){

        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Integer::sum));
    }

}
