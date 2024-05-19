public class Duelo {
    private PJ pj;
    private PJ pj2;

    public Duelo(PJ pj, PJ pj2) {
        this.pj = pj;
        this.pj2 = pj2;
    }

    public PJ duelo() {
        int pj1Health = pj.getVida();
        int pj2Health = pj2.getVida();

        while (pj1Health > 0 && pj2Health > 0) {
            pj2Health -= Math.max(0, pj.getAtaque() - pj2.getDefensa());
            if (pj2Health > 0) {
                pj1Health -= Math.max(0, pj2.getAtaque() - pj.getDefensa());
            }
        }

        return pj1Health > 0 ? pj : pj2;
    }

    public String fin() {
        return "El ganador es: "+duelo();
    }
}

