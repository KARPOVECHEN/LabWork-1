package recordriver;

import java.util.Scanner;

class RiverInfo{
    String name, location;
    int lenghtRiver;

}

public class RecordRiver {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "cp1251");
        System.out.println("Введіть кількість річок => ");// Введення інформації про річки
        int numR = scan.nextInt();
//------------------------------------------------------------------
        RiverInfo[] river = new RiverInfo[numR];
//------------------------------------------------------------------
        System.out.println("Введіть інформацію про річки: ");//Введення характеристик річок
        for (int i = 0; i < river.length; i++) {
            scan.nextLine(); // очищення буфера
            river[i] = new RiverInfo();
            System.out.print("Назва " + (i + 1) + "-ї річки => ");
            river[i].name = scan.nextLine();
            System.out.print("Локація " + (i + 1) + "-ї річки => ");
            river[i].location = scan.nextLine();
            System.out.print("Протяжність " + (i + 1) + "-ї річки => ");
            river[i].lenghtRiver = scan.nextInt();
        }
//------------------------------------------------------------------



        System.out.println("\n----------- Інформація про річки -----------");
        for (int i = 0; i < river.length; i++) {
            System.out.println("\t\nНазва річки : " + river[i].name +
                    "\t\nМісцезнаходження : " + river[i].location +
                    "\t\nПротяжність : " + river[i].lenghtRiver + " км" + "\n-------------------------------------");
        }

        int numRiver = 0;//номер елемента для річки з максимальною протяжністю (початкове значення)
        int min = river[numRiver].lenghtRiver;

        for (int i = 0; i < river.length; i++) {
            if (river[i].lenghtRiver < min) {
                min = river[i].lenghtRiver;
                numRiver = i;

                System.out.println("\n----------- Річка з мінімальною протяжністю -----------");

                System.out.println("" + river[numRiver].name + "\t"
                        + river[numRiver].lenghtRiver + " км" + "\n-------------------------------------");

            }
        }
        // Протяжність більше середньої
        System.out.println("\n----------- Протяжність більше середньої -----------");
        int lengthR = 0; // Протяжність (базова)

        for (int i = 0; i < river.length; i++)
            lengthR += river[i].lenghtRiver;
        double sr = lengthR / river.length;
        ; // середня протяжність
        System.out.println("Середня протяжність =" + sr);
        System.out.println("\nРічки, з протяжністю більше середньої");

        for (int i = 0; i < river.length; i++) {
            if (river[i].lenghtRiver > sr)
                System.out.println(river[i].name + "\t"
                        + river[i].lenghtRiver + " км" + "\n-------------------------------------");
        }


        //------------------------------------------------------------------

        // Сортування річок за назвою
        System.out.println("\n----------- Сортування річок за назвою -----------");
        for (int i = 0; i < river.length - 1; i++)
            for (int j = 0; j < river.length - i - 1; j++)
                if (river[j].name.compareTo(river[i + 1].name) > 0) {
                    RiverInfo rab = river[j]; //rab – робоча змінна для перестановки
                    river[j] = river[j + 1];
                    river[j + 1] = rab;
                }
        System.out.println("\nВідсортований список за назвою:");
        for (int i = 0; i < river.length; i++) {
            System.out.println("Назва " + river[i].name +
                    "\t Місцезнаходження " + river[i].location +
                    " Протяжність "+river[i].lenghtRiver + " км" +
                    "\n-------------------------------------------------------");
        }

        //------------------------------------------------------------------

        // Пошук за назвою

        scan.nextLine(); // очищення буфера
        System.out.println("Введіть назву річки для перегляду даних => ");
        String name = scan.nextLine();
        int num = -1; //1 – країна з шуканою назвою відсутня
        for (int i = 0; i < river.length; i++) {
            if (name.equalsIgnoreCase(river[i].name)) num = i;{
                if (num != -1) {
                    System.out.println("Така річка є у списку" +
                            "\n Це : " + river[num].name +
                            "\n місцезнаходження : " + river[num].location +
                            "\n Протяжність : " + river[num].lenghtRiver+" км. "+
                            "\n-------------------------------------------------------");


                } else System.out.println("Такої річки немає у списку");
            }

        }

        System.out.println("Введіть назву річки для зміни даних : ");
        String named = scan.nextLine();
        int newVal = -1; //1 – країна з шуканою назвою відсутня
        for (int i = 0; i < river.length; i++) {

            if (named.equalsIgnoreCase(river[i].name)) newVal = i;
            {
                if (newVal != -1) {

                    System.out.println("Така річка є у списку. " + river[i].name +
                            " - " + river[i].location +
                            " - " + river[i].lenghtRiver);
                    System.out.print("Введіть нову назву річки : ");
                    river[newVal].name = scan.nextLine();

                    System.out.print("Введіть нову локацію річки : ");
                    river[newVal].location = scan.nextLine();

                    System.out.print("Введіть нову протяжність річки : ");
                    river[newVal].lenghtRiver = scan.nextInt();

                    System.out.println("\nОновлена інформація про річку:");// Виведення інформації про річку

                    System.out.println("\t\nНазва річки " + river[newVal].name + "\t\nМісцезнаходження "
                            + river[newVal].location +
                            "\t\nПротяжність " + river[newVal].lenghtRiver + " км" + "\n-------------------------------------");

                } else System.out.println("Річки з такою назвою немає у списку");

            }
        }
    }
}

