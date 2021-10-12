package com.uni;
import java.util.Arrays;


class Aufgabe_1
{
    static int[] noten;

    public Aufgabe_1(int[] _noten)
    {
        noten = _noten;
    }

    //die Funktion fur das Runden der Zahlen
    public static int runden(int x)
    {
        if ((5 - x % 5) < 3 && x > 38)
            return x + (5 - x % 5);
        return x;
    }

    //eine Funktion die, die Noten die nicht ausreichen returniert
    public static int[] nicht_ausreichende_Note()
    {
        int[] list = new int[noten.length];
        int poz = 0;
        for (int i : noten)
        {
            if (runden(i) < 40)
            {
                list[poz] = i;
                poz++;
            }
        }
        return list;
    }

    //eine einfache Funktion die, die Liste returniert
    public static void print_list(int[] list)
    {
        for (int i : list)
            if (i > 0)
                System.out.println(i);
    }

    // eine Funktion fur das Durchschnittswert
    public static double durschnittswert()
    {
        int sum = 0;
        int ct = 0;
        for (int i : noten)
        {
            ct++;
            sum += runden(i);
        }
        return sum/ct;
    }

    // eine Funktion, die die rundete Noten returniert
    public static int[] rundete_noten(int[] list)
    {
        int[] list1 = new int[list.length];
        for (int i = 0; i < list.length; i++)
        {
            list1[i] = runden(list[i]);
        }
        return list1;
    }

    // eine Funktion die, die maximale abgerundete Note returniert
    public static int max_abgerundete_note()
    {
        int max = 0;
        for (int i : rundete_noten(noten))
            if (i > max)
                max = i;
        return max;
    }

}

class Aufgabe_2
{
    // wir berechnen die maximale Zahl der Liste
    static int maximale_Zahl(int[] list)
    {
        int max = list[0];
        for(int i : list)
            if(i>max)
                max=i;
        return max;
    }


    //wir berechnen die minimale Zahl der Liste
    static int minimale_Zahl(int[] list)
    {
        int min = list[0];
        for(int i : list)
            if(i<min)
                min=i;
        return min;
    }


    //wir berechnen die maximale Summe
    static int max_Summe(int[] list)
    {
        int S=0;
        for(int i : list)
            if(i != minimale_Zahl(list))
                S=S+i;
        return S;
    }

    //wir berechnen die minimale Summe
    static int min_Summe(int[] list)
    {
        int sum=0;
        for(int i : list)
            if( i != maximale_Zahl(list) )
                sum+=1;
        return sum;
    }

}

class Aufgabe_3
{
    // eine Funktion fur das return
    public static void print_list3(int[] list)
    {
        System.out.println(Arrays.toString(list)); // array -> string
    }
    // Eine Funktion fur die Summe
    static int[] summe(int[] list1, int[] list2)
    {
        int[] aux = new int[list1.length]; // aux = hier werden wir den Endresult der Summe tun

        //Wenn die Lange von list1=list2, dann addieren wir den letzten Zahl aus einer liste mit
        //der aus der andere und wenn die Summe <10 addieren wir sie zum aux
        if (list1.length == list2.length)
        {
            for (int i = list1.length - 1; i >= 0; i--)
            {
                if (list1[i] + list2[i] < 10)
                {
                    aux[i] += list1[i] + list2[i];
                } else // wenn die Summe >9 ist dann tun wir ein 1 auf die Position i-1 und die lezte Ziffer der Summe
                      // auf i
                {
                    if (i != 0 && list1[i] + list2[i] > 9)
                    {
                        aux[i] += (list1[i] + list2[i]) % 10;
                        aux[i - 1]++;
                    } else if (i == 0 && list1[i] + list2[i] >= 10)
                          // wenn i NULL ist, dann mussen wir resize machen, um aux eine Ziffer am Anfang zu bekommen
                    {
                        int size = list1.length + 1;
                        int[] aux1 = new int[size];
                        int k = 1;
                        aux1[0] = 1;
                        aux[0] += (list1[i] + list2[i]) % 10;
                        for (int j = 0; j < aux.length; j++)
                        {
                            aux1[k] = aux[j];
                            k++;
                        }
                        return aux1;
                    }
                }
            }
            return aux;
        } else
            return list1;
    }

    // Bei Differenz habe ich die Listen in einen Zahl verwechselt und dann die Differenz gemacht
    // Dann habe ich den Ergebniss zuruck in eine Liste gewechselt
    static int[] diff(int[] list1, int[] list2)
    {
        int dif = 0;
        int list_1_nr = 0;
        int list_2_nr = 0;
        int p = 1;
        if (list1.length == list2.length)
        {
            for (int i = list1.length - 1; i >= 0; i--)
            {
                list_1_nr += list1[i] * p;
                list_2_nr += list2[i] * p;
                p = p * 10;
            }
            dif = list_1_nr - list_2_nr;

            //Das Wechseln
            String diff = String.valueOf(dif);
            int len = diff.length();
            int[] aux = new int[len];
            for (int i = 0; i < diff.length(); i++)
                aux[i] = diff.charAt(i) - '0';
            return aux;
        } else
            return list1;
    }

    // Die Multiplikation - Ahnlich wie bei Addition
    static int[] multi(int[] list1, int num)
    {
        int[] aux = new int[list1.length];
        for (int i = list1.length - 1; i >= 0; i--)
        {

            if (list1[i] * num < 10)
            {
                aux[i] += list1[i] * num;
            } else
            {
                if (i != 0 && list1[i] * num > 9)
                {
                    aux[i] += (list1[i] * num) % 10;
                    aux[i - 1] += (list1[i] * num) / 10;
                } else if (i == 0 && list1[i] * num >= 10)//resize
                {
                    int size = list1.length + 1;
                    int[] aux1 = new int[size];
                    int k = 1;
                    aux1[0] = (list1[i] * num) / 10;
                    aux[0] += (list1[i] * num) % 10;
                    for (int j = 0; j < aux.length; j++)
                    {
                        aux1[k] = aux[j];
                        k++;
                    }
                    return aux1;
                }
            }
        }

        return aux;
    }

    // Die Division - wir wechseln die Liste in einem int um, teilen wir durch num und dann wechseln wir den Ergebnis
    // zuruck in eine Liste
    static int[] div(int[] list, int num)
    {
        int list_nr = 0;
        int p = 1;
        int rez = 0;
        for (int i = list.length - 1; i >= 0; i--)
        {
            list_nr += list[i] * p;
            p = p * 10;
        }
        rez = list_nr / num;
        String div = String.valueOf(rez);
        int len = div.length();
        int[] aux = new int[len];
        for (int i = 0; i < div.length(); i++)
            aux[i] = div.charAt(i) - '0';
        return aux;
    }
}

class Aufgabe_4 {
    // Die kleinste Zahl aus Tastatur
    static int billigste_tast(int[] list) {
        int min = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i] < min)
                min = list[i];
        }
        return min;
    }

    // Die grosste Zahlen aus USB und Tastatur
    static int teuerste_Gegenstand(int[] list1, int[] list2) {
        int max = list1[0];
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] > max)
                max = list1[i];
        }
        for (int j = 0; j < list2.length; j++) {
            if (list2[j] > max)
                max = list2[j];
        }
        return max;
    }

    // Das teuerste USB kaufen mit einem gegebenen Budget
    static int teuerste_USB(int[] list, int budget) {
        int max = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max && list[i] <= budget)
                max = list[i];
        }
        return max;
    }

    //Der maximalen Geldbetrag,der ausgegeben werden kann mit einem gegebenen Budget
    static int max_Geldbetrag(int[] list1, int[] list2, int budget) {
        int max_sum = 0;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if ((list1[i] + list2[j]) <= budget && (list1[i] + list2[j]) > max_sum) {
                    max_sum = list1[i] + list2[j];
                }
            }
        }
        if (max_sum != 0) {
            return max_sum;
        } else return -1;
    }
}

public class Main {

    public static void main(String[] args)
    {

        //Main - Aufgabe_1
        System.out.println("AUFGABE1");
        System.out.println();

        int[] noten = {49, 31, 88, 91, 77, 43, 89, 98};
        Aufgabe_1 obj1 = new Aufgabe_1(noten);
        int[] rez1 = Aufgabe_1.nicht_ausreichende_Note();

        System.out.println("Die Noten die nicht ausreichen sind:" );
        Aufgabe_1.print_list(rez1);
        System.out.println();

        System.out.println("Durchschnittwert: " + Aufgabe_1.durschnittswert());
        System.out.println();

        System.out.println("Die abgerundete Noten sind:");
        Aufgabe_1.print_list(Aufgabe_1.rundete_noten(noten));

        System.out.println("Die maximale abgerundete Zahl ist: " + Aufgabe_1.max_abgerundete_note());



        //Main - Aufgabe2
        System.out.println();
        System.out.println();
        System.out.println("AUFGABE2");
        int[] zahlen = {4,8,3,10,17};

        int max_Zahl = Aufgabe_2.maximale_Zahl(zahlen);
        System.out.println("Die maximale Zahl ist: " + max_Zahl);

        int min_Zahl = Aufgabe_2.minimale_Zahl(zahlen);
        System.out.println("Die minimale Zahl ist: " + min_Zahl);

        int max_sum = Aufgabe_2.max_Summe(zahlen);
        System.out.println("Die maximale Summe ist: " + max_sum);

        int min_sum = Aufgabe_2.min_Summe(zahlen);
        System.out.println("Die minimale Summe ist: " + min_sum);



        //Aufgabe_3
        System.out.println();
        System.out.println();
        System.out.println("AUFGABE_3");
        int[] Zahl_1 = {7, 1, 3, 2, 1, 0, 1, 7};
        int[] Zahl_2 = {4, 5, 6, 6, 3, 2, 5, 7};
        int Zahl_3 = 4;

        int[] sum = Aufgabe_3.summe(Zahl_1, Zahl_2);
        Aufgabe_3.print_list3(sum);
        int[] dif = Aufgabe_3.diff(Zahl_1, Zahl_2);
        Aufgabe_3.print_list3(dif);
        int[] mult = Aufgabe_3.multi(Zahl_1,Zahl_3);
        Aufgabe_3.print_list3(mult);
        int[] div = Aufgabe_3.div(Zahl_1, Zahl_3);
        Aufgabe_3.print_list3(div);


        //Aufgabe_4
        System.out.println();
        System.out.println();
        System.out.println("AUFGABE_4");
        int[] Preis_Tastatur = {10, 35, 15, 400};
        int[] Preis_USB = {20, 15, 40, 30};
        int budget=15;
        System.out.println("Die billigste Tastatur: " + Aufgabe_4.billigste_tast(Preis_Tastatur));
        System.out.println("Das teurste Gestand: "+Aufgabe_4.teuerste_Gegenstand(Preis_USB,Preis_Tastatur));
        System.out.println("Er kann sich ein USB mit "+Aufgabe_4.teuerste_USB(Preis_USB,budget)+" Euro kaufen");
        System.out.println("Das maximale Geldbetrag ist: "+Aufgabe_4.max_Geldbetrag(Preis_Tastatur,Preis_USB,budget));

    }
}