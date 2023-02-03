import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Ksiazka> lista = new ArrayList<>();
        List<Autor> autorzy = new ArrayList<>();

        autorzy.add(new Autor("Sussy","Baka"));
        autorzy.add(new Autor("Janusz","Korwin"));
        autorzy.add(new Autor("Andrzej","Duda"));

        lista.add(new Ksiazka("amogus",202,autorzy.get(0)));
        lista.add(new Ksiazka("asds",202,autorzy.get(0)));
        lista.add(new Ksiazka("aeaeae",202,autorzy.get(1)));
        lista.add(new Ksiazka("c++ - podstawy",202,autorzy.get(2)));

        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\n--MENU--\n" +
                    "1) wyswietl ksiazki\n" +
                    "2) wyswietl autorów\n" +
                    "3) dodaj autora\n" +
                    "4) dodaj ksiazke\n" +
                    "5) usun ksiazke\n" +
                    "6) wyszukaj");
            int in=scanner.nextInt();

            switch (in){
                case 1:
                    wyswietlKsiazki(lista);
                    break;
                case 2:
                    wyswietlAutorow(autorzy);
                    String nazwa=scanner.nextLine();
                    break;
                case 3:
                    System.out.print("\n--dodawanie autora--\nImie:");
                    String imie=scanner.next();
                    System.out.print("Nazwisko:");
                    String nazwisko=scanner.next();
                    autorzy.add(new Autor(imie,nazwisko));
                    break;
                case 4:
                    System.out.print("\n--dodawanie ksiazki--\nTytul:");
                    String tytul=scanner.next();
                    System.out.print("Strony:");
                    int strony=scanner.nextInt();
                    wyswietlAutorow(autorzy);
                    System.out.print("id autora:");
                    int autorid=scanner.nextInt()-1;
                    lista.add(new Ksiazka(tytul,strony,autorzy.get(autorid)));
                    break;
                case 5:
                    wyswietlKsiazki(lista);
                    System.out.print("\nnr książki do usunięcia:");
                    int ksiazkaid=scanner.nextInt()-1;
                    lista.remove(ksiazkaid);
                    break;
                case 6:
                    System.out.print("co wyszukac:");
                    String search=scanner.next();
                    szukaj(search,lista,autorzy);
                    break;
            }

        }


    }
    static void wyswietlKsiazki(List<Ksiazka> ksiazki){
        System.out.print("\n--książki--\n");
        int i=0;
        for (Ksiazka x:ksiazki) {
            i+=1;
            System.out.print(i);
            System.out.println(". "+x.getTytul()+", "+x.getStrony()+" stron\nautor: "+x.getAutor().getImie()+" "+x.getAutor().getNazwisko());
        }
    }
    static void wyswietlAutorow(List<Autor> autorzy){
        System.out.print("\n--autorzy--\n");
        int i=0;
        for (Autor x:autorzy) {
            i+=1;
            System.out.print(i);
            System.out.println(". "+x.getImie()+" "+x.getNazwisko());
        }
    }
    static void szukaj(String search, List<Ksiazka> ksiazki, List<Autor> autorzy){
        System.out.print("\n--wyniki wyszukiwania--\n");
        search=search.toLowerCase();
        for (Ksiazka x:ksiazki) {
            if (x.getTytul().toLowerCase().contains(search)){
                System.out.println("Ksiazka:  "+x.getTytul()+", "+x.getStrony()+" stron");

            }
        }
        for (Autor x:autorzy) {
            if (x.getImie().toLowerCase().contains(search) || x.getNazwisko().toLowerCase().contains(search)){
                System.out.println("Autor:    "+x.getImie()+" "+x.getNazwisko());

            }
        }
    }
}