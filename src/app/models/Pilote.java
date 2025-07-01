package app.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Pilote {

    public final static int NOMBRE_PNEUS_EN_RESERVE = 16;
    // MR Tu as oublié le mot-clé final pour indiquer que cette valeur ne changera pas pour les deux premiers attributs
    private String nom;
    private String nationalite;
    private int nombrePoints; // stat
    private int nombreCourses; // stat
    private int nombreVictoires; // stat
    private int nombresPodium; // stat
    private Pneu[] pneusEnReserve;
    private Voiture voiture;

    public Pilote(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombresPodium = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        this.voiture = null;
    }

    public Pilote(String nom, String nationalite, Voiture voiture) {
        this.nom = nom;
        this.nationalite = nationalite;
        this.nombrePoints = 0;
        this.nombreCourses = 0;
        this.nombreVictoires = 0;
        this.nombresPodium = 0;
        this.pneusEnReserve = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        this.voiture = voiture;
    }

    public boolean deposerPneuEnReserve(Pneu pneu) {
        boolean depotReussi = false;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] == null) {
                pneusEnReserve[i] = pneu;
                depotReussi = true;
                break;
            }
        }
        return depotReussi;
    }

    public Pneu retirerPneuEnReserve(TypePneu type) {
        //MR Pas nécessaire un nouveau pneu, on peut commencer avec un pneu vide (null)
        Pneu pneuRetirer = new Pneu(null, 0);
        for (int i = 0; i < pneusEnReserve.length; i++) {
            //MR Il faut aussi vérifier si pneusEnReserve[i] n'est pas null avant de comparer les types
            if (pneusEnReserve[i].getType() == type) {
                pneuRetirer = pneusEnReserve[i];
                pneusEnReserve[i] = null;
                break;
            }
        }
        return pneuRetirer;
    }

    public int compterNombrePneusEnReserveDeType(TypePneu type) {
        int count = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null && pneusEnReserve[i].getType() == type) {
                count++;
            }
        }
        return count;
    }

    public int getNombrePneusEnReserve() {
        int count = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                count++;
            }
        }
        return count;
    }

    public Pneu[] getPneusEnReserveSansTrous() {
        //MR C'est pas mal, mais il faut créer un tableau de la taille du nombre de pneus en réserve il faut donc compter le nombre de pneus non null avant
        //Tu peux utiliser la méthode getNombrePneusEnReserve pour connaître la taille du tableau
        Pneu[] listeSansTrou = new Pneu[NOMBRE_PNEUS_EN_RESERVE];
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                //MR Pourquoi tu recréer une boucle ici pour copier les pneus ?
                for (int j = 0; j < listeSansTrou.length; j++) {
                    listeSansTrou[j] = pneusEnReserve[j];
                    
                }
            }
        }
        return listeSansTrou;
    }

    public String pressionMoyenneDesPneusEnReserveFormatee() {
        int count = 0;
        double moyenne = 0.00;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                moyenne += pneusEnReserve[i].getPression();
                count++;
            }
        }
        moyenne = (moyenne / count);
        DecimalFormat df = new DecimalFormat("##.00");
        DecimalFormatSymbols dff = new DecimalFormatSymbols(Locale.US);
        df.setDecimalFormatSymbols(dff);
        String perssionMoyenneDf = df.format(moyenne);
        return perssionMoyenneDf;
    }

    public int supprimerPneusDePressionInferieure(double pression) {
        int count = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null && pneusEnReserve[i].getPression() <= pression) {
                pneusEnReserve[i] = null;
                count++;
            }
        }
        return count;
    }

    public boolean ajouterLotDePneus(Pneu[] pneus) {
        boolean ajoutReussi = false;
        int CaseVide = 0;
        int pneusAAjouter = 0;
        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusAAjouter == pneus.length) {
                break;
            }
            if (pneusEnReserve[i] == null) {
                CaseVide++;
                for (int j = 0; j < pneus.length; j++) {
                    if (pneus[j] != null) {
                        pneusAAjouter++;
                        break;
                    }
                }
            }
            
        }
        if (CaseVide >=  pneusAAjouter) {
            for (int i = 0; i < pneus.length; i++) {
                if (pneus[i] != null) {
                    for (int j = 0; j < pneusEnReserve.length; j++) {
                        if (pneusEnReserve[j] == null) {
                            pneusEnReserve[j] = pneus[i];
                            ajoutReussi = true;
                            break;
                            
                        }
                    }
                }
            }
        }
        return ajoutReussi;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public int getNombreCourses() {
        return nombreCourses;
    }

    public void setNombreCourses(int nombreCourses) {
        this.nombreCourses = nombreCourses;
    }

    public int getNombreVictoires() {
        return nombreVictoires;
    }

    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

    public int getNombrePodium() {
        return nombresPodium;
    }

    public void setNombresPodium(int nombresPodium) {
        this.nombresPodium = nombresPodium;
    }

    @Override
    public String toString() {
        String resultat = "Pilote : " + nom + " (" + nationalite + ")\n";
        if (voiture != null) {
            String nomEquipe = voiture.getNomEquipe();
            int numero = voiture.getNumero();
            resultat += "-> Voiture " + nomEquipe + " (" + numero + ")\n";
            resultat += "-> Points : " + nombrePoints + "\n";
            resultat += "-> Courses : " + nombreCourses + "\n";
            resultat += "-> Victoires : " + nombreVictoires + "\n";
            resultat += "-> Podiums : " + nombresPodium + "\n";
        } else {
            resultat += "Pas de voiture assignée. \n";
        }

        for (int i = 0; i < pneusEnReserve.length; i++) {
            if (pneusEnReserve[i] != null) {
                TypePneu type = pneusEnReserve[i].getType();
                resultat += "Pneu en réserve : " + type + "\n";
            }
        }

        return resultat;
    }
}
