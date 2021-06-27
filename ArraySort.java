/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.sort;

/**
 *
 * @author Marcus
 */
public class ArraySort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] talListe = new int[130];
        double sd = 0;
        boolean tjek;
        double gennemsnit;

        for (int i = 0; i < talListe.length; i++) {
            tjek = true;
            while (tjek) {
                talListe[i] = (int) (1 + Math.random() * 199);
                if (talListe[i] % 2 != 0) {
                    tjek = false;
                }
            }
        }

        udskriv(talListe);
        insertionSort(talListe);
        System.out.println();
        System.out.println("\n After the sort the numbers are ");
        udskriv(talListe);
        gennemsnit = average(talListe);
        sd = spredning(talListe, gennemsnit, sd);

        int min = talListe[129];
        int max = talListe[0];

        for (int i = 0; i < talListe.length; i++) {
            if (talListe[i] > max) {
                max = talListe[i];
            }
        }

        for (int i = 0; i < talListe.length; i++) {
            if (talListe[i] < min) {
                min = talListe[i];
            }
        }

        System.out.println();
        System.out.println("\nThe minimum value is: " + min);
        System.out.println("The maximum value is: " + max);
        System.out.format("The mean is: %.3f", gennemsnit);
        System.out.println("\nThe standard deviation is: " + sd);

    }

    public static void udskriv(int[] talListe) {
        for (int i = 0; i < talListe.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.printf("%4d", talListe[i]);
        }
    }

    public static void insertionSort(int[] talListe) {
        for (int i = 1; i < talListe.length; i++) {
            int current = talListe[i];
            int j = i - 1;
            while (j >= 0 && current > talListe[j]) {
                talListe[j + 1] = talListe[j];
                j--;
            }
            talListe[j + 1] = current;
        }
    }

    public static double average(int[] talListe) {
        double total = 0;
        for (int i = 0; i < talListe.length; i++) {
            total = total + talListe[i];
        }
        double average = total / talListe.length;
        return average;
    }

    public static double spredning(int[] talListe, double gennemsnit, double sd) {
        for (int i = 0; i < talListe.length; i++) {
            sd += ((talListe[i] - gennemsnit) * (talListe[i] - gennemsnit)) / (talListe.length - 1);
        }
        double standardDeviation = Math.sqrt(sd);
        return standardDeviation;
    }

}
