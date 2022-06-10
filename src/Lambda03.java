import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece", "trilece", "xacik", "havucDilim", "buryan", "yaglama", "kokorec"));

        alfBykTekrrsz(menu);
        System.out.println("\n   ***   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menu);
        System.out.println("\n   ***   ");
        sonHrfBkSirala(menu);
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n   ***   ");
        wIleBaslayanElKontrol(menu);
        System.out.println("\n   ***   ");
        xIleBtnElKontrol(menu);
        System.out.println("\n   ***   ");
        chrSayisiBykElPrint(menu);
        System.out.println("\n   ***   ");
        ilkElHarcSonHrGoreSiralaPrint(menu);
        System.out.println("\n   ***   ");
    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> menu) {
        menu. // akıs kaynagı
                stream().// akısa girdi
                // map(t-> t.toUpperCase()). //elemanlar buyuk harf update edildi //jamb. Ex
                        map(String::toUpperCase).// Method Ref. elemanlar buyuk hrf update edildi
                sorted(). // alfabetik (natural dogal) sıra yapıldı
                distinct().// bensersiz: tekrarsiz hale getirildi
                forEach(t -> System.out.print(t + " ")); // print edildi

        //distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır. Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void chrSayisiTersSirali(List<String> menu) {

        menu.
                stream().// akısa alındı
                //map(t->t.length()).
                        map(String::length).//elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).//ter sıra yapıldı
                distinct().//benzersiz yapıldı
                //forEach(t->System.out.print(t+" "));
                        forEach(Lambda01::yazdir);//print edildi
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBkSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t -> System.out.print(t + " "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHrfBkSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).// elemanın lenght()-1 --> son index'nin karakterini alir
                                reversed()). //elemanın lenght()-1 --> son index'inin karakterini ters sıralar z->a
                forEach(t -> System.out.print(t + " "));
    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,
    // ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void charKaresiCiftElSirala(List<String> menu) {
        menu.
                stream(). // akısa alindi
                map(t -> t.length() * t.length()). // akısdaki string elemanları boyutlarının karesine update edildi
                filter(Lambda01::ciftBul).// cift elemanlar filtrelendi
                distinct().// tekrarsiz yapildi
                sorted(Comparator.reverseOrder()).// ters b->k sira yapildi
                forEach(Lambda01::yazdir);// print edildi
    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol(List<String> menu) {
        System.out.println("amele kod");
        boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanlari 7 harf ve daha az harften olusuyor");
        } else {
            System.out.println("list elemanlari 7 harften buyuk");
        }
        System.out.println("cincix kod");
        System.out.println(
                menu.
                        stream().
                        allMatch(t -> t.length() <= 7) ?
                        "list elemanlari 7 harf ve daha az harften olusuyor" : "list elemanlari 7 harften buyuk");

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> menu) {
        System.out.println(menu.
                stream().
                noneMatch(t -> t.startsWith("w")) ?
                "w ile baslayan yemegin menu de ne isi var" : "agam hic w ile yemek olur mu");
    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemani kontrol ediniz.
    public static void xIleBtnElKontrol(List<String> menu) {
        System.out.println(menu.
                stream().
                anyMatch(t -> t.endsWith("x")) ?
                "x ile biten yemegin menu de ne isi var" : "agam hic x ile yemek olur mu");
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void chrSayisiBykElPrint(List<String> menu) {
        Stream<String> sonIsim=menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().
                length()).
                reversed()).
                //findFirst());  // ilk eleman alindi
                limit(3); // limit(a) akısdan cıkan elemanlari a parametresine gore ilk a eleman alir.
        /*
        sonIsim.toArray())--> limit() meth return dan dolayi stream type olan sonIsim toArray() method ile array type convert edildi
         */

        System.out.println(Arrays.toString(sonIsim.toArray())); // arraya cevrilen sonIsim stream print edildi


        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.

        /*
        TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz. Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
        •  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.

        */

    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHarcSonHrGoreSiralaPrint(List<String> menu) {
        menu.
                stream(). // akısa alindi
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).// son harfe gore siralandi
                skip(1).//ilk eleman atlandi
                forEach(t -> System.out.print(t + " ")); // print edildi

        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
    }


}