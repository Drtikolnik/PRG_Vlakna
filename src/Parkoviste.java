public class Parkoviste {

    private int pocetMist = 30;


    public synchronized void vjezd(int pocet) {
        if (pocet > pocetMist) {
            System.out.println("Není dostatek volných míst na parkovišti");
        }else{
            setPocetMist(pocetMist - pocet);
            System.out.println("Vjelo " +pocet+ " aut, volných míst je nyní " + pocetMist);
        }

    }


    public synchronized void vyjezd(int pocet) {
        if (pocet + pocetMist <= 30) {
            setPocetMist(pocetMist + pocet);
            System.out.println("Vyjelo " +pocet+ " aut, volných míst je nyní " + pocetMist);
        }else{
            throw new PocetMistVetsiNez30("Počet volných míst by byl větší než 30");
        }

    }








    public void setPocetMist(int pocetMist) {
        this.pocetMist = pocetMist;
    }

    public int getPocetMist() {
        return pocetMist;
    }
}
