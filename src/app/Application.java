package app;

import app.models.Pilote;
import app.models.Pneu;
import app.models.Voiture;
import app.models.TypePneu;

public class Application {

    public static void main(String[] args) {

        // ---------------------------------------------------------------------------------------
        // Etape 1 : Création d'une voiture de Formule 1
        Voiture ferrari = new Voiture(16, "Ferrari");
        // ---------------------------------------------------------------------------------------

        // ---------------------------------------------------------------------------------------
        // Etape 2 : Afficher la voiture
        System.out.println(ferrari);
        // ---------------------------------------------------------------------------------------

        // ---------------------------------------------------------------------------------------
        // Etape 3 : Création d'un pilote de Formule 1 et afficher ses informations
        Pilote charles = new Pilote("Charles Leclerc", "Monégasque", ferrari);
        charles.setNombreCourses(16);
        charles.setNombrePoints(65);
        charles.setNombreVictoires(3);
        charles.setNombresPodium(7);
        // ---------------------------------------------------------------------------------------

        // ---------------------------------------------------------------------------------------
        // Etape 4 : Afficher le Pilote
        System.out.println(charles);
        // ---------------------------------------------------------------------------------------

        // ---------------------------------------------------------------------------------------
        // Etape 5 : Tests des méthodes de la classe Pilote
        Pneu p1 = new Pneu(TypePneu.DUR_BLANC, 1.5);
        Pneu p2 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.8);
        Pneu p3 = new Pneu(TypePneu.TENDRE_ROUGE, 2.0);
        Pneu p4 = new Pneu(TypePneu.DUR_BLANC, 1.6);
        Pneu p5 = new Pneu(TypePneu.MEDIUM_JAUNE, 1.7);

        // ---------------------------------------------------------------------------------------
        // deposerPneuEnReserve() 5 fois de types différents
        charles.deposerPneuEnReserve(p1);
        charles.deposerPneuEnReserve(p2);
        charles.deposerPneuEnReserve(p3);
        charles.deposerPneuEnReserve(p4);
        charles.deposerPneuEnReserve(p5);
        // retirerPneuEnReserve() de type TENDRE_ROUGE et l'afficher
        Pneu pneuRetirer = charles.retirerPneuEnReserve(TypePneu.TENDRE_ROUGE);
        System.out.println("Le Pneu TENDRE_ROUGE qui a été retirer : Pneu " + pneuRetirer);

        // getNombrePneusEnReserve() et afficher le nombre de pneus en réserve
        int pneuEnReserve = charles.getNombrePneusEnReserve();
        System.out.println("Pneu en reserve : " + pneuEnReserve);

        // getPneusEnReserveSansTrous() et afficher les pneus en réserve
        Pneu[] tableauSansTrou = charles.getPneusEnReserveSansTrous();
        System.out.println("Pneu en réserve sans trous : ");
        
        for (int i = 0; i < tableauSansTrou.length; i++) {
            if (tableauSansTrou[i] != null) {
                System.out.println("- " + tableauSansTrou[i].getType() + " avec pression " + tableauSansTrou[i].getPression());
            }
        }

        // pressionMoyenneDesPneusEnReserveFormatee() et afficher la pression moyenne des
        // pneus
        String moyenne = charles.pressionMoyenneDesPneusEnReserveFormatee();
        System.out.println("Pression moyenne des pneus en réserve : " + moyenne);


        // compterNombrePneusEnReserveDeType() et afficher le nombre de pneus en réserve
        // de type DUR_BLANC
        int nombreType = charles.compterNombrePneusEnReserveDeType(TypePneu.DUR_BLANC);
        System.out.println("Nombre de pneus en réserve de type DUR_BLANC : " + nombreType);

        // Créer les 3 pneus et ajout le lot de pneus pour le pilote et afficher réussi
        // ou échoué
        Pneu p6 = new Pneu(TypePneu.DUR_BLANC, 1.3);
        Pneu p7 = new Pneu(TypePneu.DUR_BLANC, 1.2);
        Pneu p8 = new Pneu(TypePneu.DUR_BLANC, 1.1);
        Pneu[] lotDePneus = new Pneu[3];
        lotDePneus[0] = p6;
        lotDePneus[1] = p7;
        lotDePneus[2] = p8;
        boolean reussi = charles.ajouterLotDePneus(lotDePneus);
        if (reussi) {
            System.out.println("Ajout de lot de pneu en reserve réussi :-)");
        }else{
            System.out.println("Ajout de lot de pneu en reserve raté :-(");
        }

        // Supprimer les pneus de pression inférieure à 1.4 et afficher le nombre de
        // pneus supprimés
        int nombrePneuRetirer = charles.supprimerPneusDePressionInferieure(1.4);
        System.out.println("Nombre de pneus supprimés de pression inférieur à 1.4 : " + nombrePneuRetirer);

        // ---------------------------------------------------------------------------------------
    }

}
