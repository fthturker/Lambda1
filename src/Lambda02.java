import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, 5, 7, 3, 15));
        ciftKarePrint(sayi); //16 4 36
        System.out.println("\n   ***   ");
        tekKupBirFazlaPrint(sayi);//1332 344 28 3376
        System.out.println("\n   ***   ");
        ciftKarePrint1(sayi); //2.0 1.4142135623730951 2.449489742783178
        System.out.println("\n   ***   ");
        maxElBul(sayi);
        System.out.println("\n   ***   ");
        ciftKareMaxBul(sayi);
        System.out.println("\n   ***   ");
        elTopla(sayi);
        System.out.println("\n   ***   ");
        ciftCarp(sayi);
        System.out.println("\n   ***   ");
        minBul(sayi);
        System.out.println("\n   ***   ");
        bestenByEnKck(sayi);
        System.out.println("\n   ***   ");
        ciftKareKbPrint(sayi);
        System.out.println("\n   ***   ");
        ciftKareBkPrint(sayi);
        System.out.println("\n   ***   ");

    }
    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).map(t -> t * t).forEach(Lambda01::yazdir);
        //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya
        // üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin
    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().//sayilar akisa alindi
                filter(t -> t % 2 == 1).//tek elemanlar filtrelendi
                map(t -> (t * t * t) + 1).//tek elemanlari kuplerinin 1 faszlasına update edildi
                forEach(Lambda01::yazdir);//print edildi
    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarePrint1(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt). // met ref--> double deger return eder
                //forEach(Lambda01::yazdir); -->yazdir() method int. calistigi icin map den cıkan datalari calistirmaz
                        forEach(t -> System.out.print(t + " "));
    }

    // Task : list'in en buyuk elemanini yazdiriniz
    public static void maxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); // akisa giren elemanlarin action sonrasi tek eleman haline getirir

        System.out.println(maxSayi);
        System.out.println("halukca : " + sayi.stream().reduce(Math::max));
    /*
     reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
     kullanımı yaygındır pratiktir.
     Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
     bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
     reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
     reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
     İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

    */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxBul(List<Integer> sayi) {
        System.out.println(
                sayi.
                        stream().
                        filter(Lambda01::ciftBul).
                        map(t -> t * t).
                        reduce(Math::max));
        System.out.println(sayi.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max));

        System.out.println("daha hizli specific integer class :" +
                sayi.
                        stream().
                        filter(Lambda01::ciftBul).
                        map(t -> t * t).
                        reduce(Integer::max)); // 36 specific class daha hizli run olur
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...
    public static void elTopla(List<Integer> sayi) {
        int toplam = sayi.stream().reduce(0, (a, b) -> a + b);//Lambda Expression

        //sayi.stream().reduce(Integer::sum); // method ref.
        /*
        a ilk degerini her zaman ataanan degerden (identity) aliır
        b degerini her zaman stream()'dan akısdan alir
        a ilk degerinden sonraki her degeri action (islem)'den alır
        */

        System.out.println("Lambda exp. : " + toplam);
        //method ref...
        Optional<Integer> topla = sayi.stream().reduce(Integer::sum);
        System.out.println("method ref : " + sayi.stream().reduce(Integer::sum));
    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer> sayi) {
        sayi.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        //method ref.

        System.out.println("Method ref : " + sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));

        //Lambda Expression...

        sayi.stream().filter(Lambda01::ciftBul).reduce(1, (a, b) -> (a * b));
        System.out.println("Lambda exp. : " + sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));
    }

    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void minBul(List<Integer> sayi) {
        // 1. yontem Method Reference --> Integer class
        Optional<Integer> minSayi = sayi.stream().reduce(Integer::min);
        System.out.println(minSayi);

        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println(minSayiMath);

        //3. yontem Lambda Expression
        int minSayiLambda =(sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x:y));
        System.out.println(minSayiLambda);

        //4. yontem Method Reference --> Haluk class
        Optional<Integer>minSayiHaluk=sayi.stream().reduce(Lambda02::byHalukMin); // bu method kendisine verilen iki int degerin en kucugunu return eder
        System.out.println(minSayiHaluk);
    }

        public static int byHalukMin(int a, int b){
        return a<b?a:b;
    }

        // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

        public static void bestenByEnKck(List<Integer> sayi){
            System.out.println(sayi.stream().filter(t-> t>5 && t%2==1).reduce(Lambda02::byHalukMin));

        }

        // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
        public static void ciftKareKbPrint(List<Integer> sayi){
        sayi.
                stream(). // akısa alındı
                filter(Lambda01::ciftBul).//cift elemanlar filtrelendi
                map(t->t*t).// filtrelenen cift sayi karesi alındı
                sorted().// karesi alınan elemanlar dogal (k--b) siralandi
                forEach(Lambda01::yazdir); //print edildi

            //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
            //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.
        }
        // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
        public static void ciftKareBkPrint(List<Integer> sayi){
            sayi. // akıs kaynagi
                    stream(). // akısa alındı
                    filter(t-> t%2==1).//tek elemanlar filtrelendi
                    map(t->t*t).// filtrelenen cift sayi karesi alındı
                    sorted(Comparator.reverseOrder()).// karesi alınan elemanlar ters (b--k) siralandi
                    forEach(Lambda01::yazdir); //print edildi


        }
}
