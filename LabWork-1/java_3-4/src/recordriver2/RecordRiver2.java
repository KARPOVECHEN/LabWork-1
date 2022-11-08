package recordriver2;
import java.util.Scanner;

class RiverInfo2{
    String name, location;
    int lenghtRiver;

}

public class RecordRiver2 {

    public static RiverInfo2[] setRiverArr(int k) {
        Scanner scan = new Scanner(System.in, "cp1251");
        RiverInfo2[] river = new RiverInfo2[k];

        System.out.println("Введіть інформацію про річки: ");//Введення характеристик річок
        for (int i = 0; i < river.length; i++) {
            scan.nextLine(); // очищення буфера
            river[i] = new RiverInfo2();
            System.out.print("Назва " + (i + 1) + "-ї річки => ");
            river[i].name = scan.nextLine();
            System.out.print("Локація " + (i + 1) + "-ї річки => ");
            river[i].location = scan.nextLine();
            System.out.print("Протяжність " + (i + 1) + "-ї річки => ");
            river[i].lenghtRiver = scan.nextInt();
        }
        return river;
    }
    //------------------------------------------------------------------
    public static void showRiver(RiverInfo2 river) {
// Інформація про одну річку
        System.out.println("\t\nНазва річки : " + river.name +
                "\t\nМісцезнаходження : " + river.location +
                "\t\nПротяжність : " + river.lenghtRiver + " км");
    }
//------------------------------------------------------------------

    public static void showArray(RiverInfo2[] river) {
        // Виведення масиву з річками
        for (int i = 0; i < river.length; i++) {
            System.out.println("\t\nНазва річки : " + river[i].name +
                    "\t\nМісцезнаходження : " + river[i].location +
                    "\t\nПротяжність : " + river[i].lenghtRiver + " км" + "\n-------------------------------------");
        }
    }
    //------------------------------------------------------------------
    public static int NomMax(RiverInfo2[] river) {
        int nommax = 0;    // номер елемента річки з мін. протяжністю
// (початкове значення)
        double max = river[nommax].lenghtRiver;    //мін. протяжність (початкове значення)
        for (int i = 0; i < river.length; i++)
            if (river[i].lenghtRiver < max) {
                max = river[i].lenghtRiver;
                nommax = i;
            }
        return nommax;
    }
    //------------------------------------------------------------------
    public static void sortName(RiverInfo2[] river) {
// Сортування країн за назвою
        for (int i = 0; i < river.length - 1; i++)
            for (int j = 0; j < river.length - i - 1; j++)
                if (river[j].name.compareTo(river[i + 1].name) > 0) {
                    RiverInfo2 rab = river[j];        // rab – робоча змінна для перестановки
                    river[j] = river[j + 1];
                    river[j + 1] = rab;
                }
    }
    //------------------------------------------------------------------
    public static double avglength(RiverInfo2[] river) {

        // Середня протяжність
        double s = 0;                // сумарна довжина
        for (int i = 0; i < river.length; i++)
            s += river[i].lenghtRiver;
        double sr = s / river.length;        // середня довжина
        return sr;
    }
    //------------------------------------------------------------------
    public static RiverInfo2[] Bigger(RiverInfo2 river[]) {

        // Протяжність менше середньої
        double sred = avglength(river);
        int kol = 0;    //кількість країн
        for (int i = 0; i < river.length; i++) {
            if (river[i].lenghtRiver < sred)
                ++kol;
        }

        if (kol != 0) {
            RiverInfo2[] bigRiver = new RiverInfo2[kol];
            int n = -1;
            for (int i = 0; i < river.length; i++)
                if (river[i].lenghtRiver > sred) {
                    bigRiver[++n] = river[i];
                }
            return bigRiver;
        } else return null;
    }
    //------------------------------------------------------------------
    public static RiverInfo2 findForName(RiverInfo2 river[]) {
        Scanner scan = new Scanner(System.in,"cp1251");
        System.out.println("Введіть назву річки для зміни даних : ");
        String named = scan.nextLine();

        int newVal = -1; //1 – річка з шуканою назвою відсутня
        for (int i = 0; i < river.length; i++) {

            if (named.equalsIgnoreCase(river[i].name)) newVal = i;

            if (newVal != -1) {

                System.out.println("Така річка є у списку. "
                        + river[i].name +
                        " - " + river[i].location +
                        " - " + river[i].lenghtRiver);
                System.out.print("Введіть нову назву річки : ");
                river[newVal].name = scan.nextLine();

                System.out.print("Введіть нову локацію річки : ");
                river[newVal].location = scan.nextLine();

                System.out.print("Введіть нову протяжність річки : ");
                river[newVal].lenghtRiver = scan.nextInt();

                System.out.println("\nОновлена інформація про річку:");// Виведення інформації про річку

                return river[newVal];

            } else System.out.println("Річки з такою назвою немає у списку");

        }
        return river[newVal];
    }
//------------------------------------------------------------------


    public static void main(String[] args) {
// ГОЛОВНИЙ КЛАС З МЕТОДАМИ
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введіть кількість річок => ");
        int n = sc.nextInt();    // кількість країн

        RiverInfo2 river[] = setRiverArr(n);    // Введення інформації про країни

        System.out.println("\nХарактеристики річок:");
        showArray(river);            // Виведення отриманої інформації

// визначити найкоротшу річку;
        int nommax = NomMax(river);
        System.out.println("\nНайкоротша річка:");
        showRiver(river[nommax]);


// упорядкувати список річок за назвами за абеткою;
        sortName(river);
        System.out.println("\nВідсортований список за назвою:");
        showArray(river);

// вивести інформацію про річки з довжиною меншою за середню;
        System.out.println("\nРічки з протяжністю більше середньої");
        RiverInfo2[] larger = Bigger(river);
        showArray(larger);

// організувати пошук за назвою річки, виправлення одного з полів та
//виведення повної інформації про річку після редагування.

//    RecordRiver2.findForName(river);
    showRiver(findForName(river));

    }

}
