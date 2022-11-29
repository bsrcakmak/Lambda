package lambda_practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {

        List<String> list=new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println("ilkHarfBykGerisiKckList(list) = " + ilkHarfBykGerisiKckList(list));
        System.out.println("ecIleBaslayanList(list) = " + ecIleBaslayanList(list));
        yildizliYaz(list);
        System.out.println();
        System.out.println("eOlanList(list) = " + eOlanList(list));
        lLeriSil(list);
        System.out.println();
        ikiHrfSiralaIlk5ElChEnByk(list);

    }
    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim
    public static List<String> ilkHarfBykGerisiKckList(List<String> l){
       return l.stream().
                map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
                collect(Collectors.toList());
    }

    // S2: ilk harfi e ve ya c olanlari listeleyelim
    public static List<String> ecIleBaslayanList(List<String> l){
        return l.stream().
                filter(t-> t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).
                collect(Collectors.toList());
    }

    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yildizliYaz(List<String> l){
        l.stream().map(t->"*"+t+"*").forEach(Utils::yazString);

    }

    //S4 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eOlanList(List<String> l){
        return l.stream().
                filter(t-> t.toLowerCase().contains("e")).
                collect(Collectors.toList());
    }

    //S5: tum 'l' leri silelim yazdiralim
    public static void lLeriSil(List<String> l){
        l.stream().
                map(t->t.replaceAll("l","")).
                forEach(Utils::yazString);
    }

    //S6: List elemanlarını 2.harfe gore sıralayıp
    //ilk 5 elemandan char sayısı en buyuk elemanı print
    public static void ikiHrfSiralaIlk5ElChEnByk(List<String> liste){
        System.out.println(liste.
                stream().
                sorted(Comparator.comparing(t-> t.charAt(1))). // list elemanlarini 2. harfe gore alfabetik siraladi
                limit(5). // ilk 5 eleman akisa devam etti
                sorted(Comparator.comparing(t-> t.toString().length()). // akistan gelen ilk 5 elemani uzunluklarina gore ters siraladi
                        reversed()).
                findFirst()); // akistan gelen ilk elemani aldik
    }






}
