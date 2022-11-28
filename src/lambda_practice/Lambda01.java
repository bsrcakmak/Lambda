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


    // S4:pozitif ve çift olanları yazdırın
    public static void pozVeCift(List<Integer> l){

        l.stream().filter(t->t%2==0 && t>0).forEach(t-> System.out.print(t+" "));

    }


    // S5:pozitif veya çift olanları yazdırın
    public static void pozVeyaCiftYazdir(List<Integer> l){

        l.stream().filter(t-> t%2==0 || t>0).forEach(t-> System.out.print(t+" "));
    }


    // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
    // map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
    // ıslem yapmak ıcın (update) kullanılır
    public static void karaYazdir(List<Integer> l){

        l.stream().map(t-> t*t).forEach(t->System.out.print(t+" "));

    }


    //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
    public static void ciftKupYazdir(List<Integer> l){

        l.stream().filter(t-> t%2==0).map(t-> t*t*t).forEach(t-> System.out.print(t+" "));
    }


    //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım
    public static void kareTekrarsiz(List<Integer> l){

        l.stream().map(t-> t*t).distinct().forEach(t-> System.out.print(t+" "));
    }
    //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
    // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
    // Sıralı akışlar için, farklı elemanın seçimi sabittir
    // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
    // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.


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
    reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir, kullanımı yaygındır pratiktir.
    Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
    bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
    reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
    reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
    İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
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


    //S14 : List'in pozitif elemanları toplamını bulalım
    public static void pozElToplam(List<Integer>l){

        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Integer::sum));
    }

}
