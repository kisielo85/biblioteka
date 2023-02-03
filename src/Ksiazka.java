public class Ksiazka {
    private String tytul;
    private int strony;
    private Autor autor;

    public Ksiazka(String tytul, int strony, Autor autor) {
        this.tytul = tytul;
        this.strony = strony;
        this.autor = autor;
    }

    public String getTytul() {
        return tytul;
    }

    public int getStrony() {
        return strony;
    }

    public Autor getAutor() {
        return autor;
    }
}
