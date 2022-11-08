package recordCountry2;
import java.util.Scanner;

class Strana{
    String name;
    double square;
}

public class RecordCountry2{
// МЕТОДИ ДЛЯ ВСІХ ПІДЗАДАЧ для роботи з об'єктами класу Strana

    public static Strana [] setCountryArr(int k) {
// Введення масиву країн
        Scanner sc=new Scanner(System.in,"cp1251");
        Strana country[]=new Strana[k];

        System.out.println("Введіть інформацію про країни: ");
        for (int i = 0; i < country.length; i++) {
            country [i] = new Strana ();
            System.out.print("Назва "+(i+1)+"-ї країни => ");//Україна--США--
// Індія - Австралія
            country[i].name=sc.nextLine();
            System.out.print("Площа "+(i+1)+"-ї країни => ");//0.6-9,8-3,2-7,7
// млн кв. км (2010 р.)
            country[i].square=sc.nextDouble();
            sc.nextLine();   // очищення буфера
        }
        return country;
    }
    public static void showArray (Strana [] country) {
// Виведення масиву

        for (int i = 0; i<country.length; i++) {

            System.out.println(" "+ country[i].name + " \t" + country[i].square + " млн. кв. км");
        }
    }
    public static void showCountry	(Strana cntr){
// Інформація про одну країну
        System.out.println(""+cntr.name+"\t"+cntr.square+" млн. кв. км"); }

    public static int NomMax	(Strana []st) {
// Номер країни з макс. площею
        int nommax=0;	// номер елемента країни з макс. площею
// (початкове значення)
        double max=st[nommax].square;	//макс. площа (початкове значення)
        for (int i = 0; i <st.length; i++)
            if (st[i].square>max) {
                max = st [i]. square;
                nommax=i;
            }
        return nommax;
    }
    public static void sortSquare	(Strana [] cntr) {
// Сортування країн за площею
        for (int i = 0; i < cntr.length-1; i++)
            for (int j = 0; j <cntr.length-1-i; j++)
                if (cntr[j].square>cntr[j+1].square){
                    Strana rab=cntr[j];		// rab – робоча змінна для перестановки
                    cntr[j]=cntr[j+1];
                    cntr[j+1] =rab;
                }
    }


    public static void sortName	(Strana [] country) {
// Сортування країн за назвою
        for (int i = 0; i < country.length-1; i++)
            for (int j = 0; j <country.length-i-1; j++) if(country[j].name.compareTo(country[i+1].name)>0){
                Strana rab=country[j];		// rab – робоча змінна для перестановки
                country[j]=country[j+1];
                country[j+1]=rab;
            }
    }
    public static double avgSquare(Strana [] cntr) {
// Середня площа
        double s=0; 				// сумарна площа
        for (int i = 0; i < cntr.length; i++)
            s+=cntr[i].square;
        double sr=s/cntr.length;		// середня площа
        return sr; }

    public static Strana [] Bigger(Strana cntr[]){
// Країни з площою більше середньої
        double sred = avgSquare(cntr);
        int kol=0;	//кількість країн
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].square>sred)
                ++kol;
        }

        if (kol != 0) {
            Strana [] bigCountry = new Strana [kol];
            int n=-1;
            for (int i = 0; i <cntr.length; i++)
                if (cntr[i].square>sred) {
                    bigCountry[++n]=cntr[i];
                }
            return bigCountry;
        } else return null;
    }

    public static Strana findForName(Strana cntr [],
                                     String name) {
// Пошук за назвою
        int n=-1;			//-1 – країна з шуканою
        // назвою відсутня
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name)) n=i;
        if (n != -1) { return cntr[n];
        } else return null;
    }

    public static void main(String[] args) {
// ГОЛОВНИЙ КЛАС З МЕТОДАМИ
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("Введіть кількість країн => ");
        int n=sc.nextInt();	// кількість країн
        Strana country[]= setCountryArr(n);	// Введення інформації про країни

        System.out.println("\nХарактеристики країн:");
        showArray(country);			// Виведення отриманої інформації

// Країна з максимальною площею
        int nommax=NomMax(country);
        System.out.println("\nКраїна з максимальною площею:");
        showCountry (country [nommax]);

// Сортування країн за площею
        sortSquare(country);
        System.out.println("\nВідсортований список за площею:");
        showArray(country);

// Сортування країн за назвою
        sortName(country);
        System.out.println("\nВідсортований список за назвою:");
        showArray(country);

// Середня площа
        System.out.println("Середня площа ="+avgSquare(country));

// Площа більша за середню
        System.out.println("\nКраїни, з площею більше середньої");
        Strana [] larger = Bigger (country);
        showArray(larger);

// Пошук країни
        System.out.println("\nПошук країни \n " +
                "Введіть назву країни => ");
        sc.nextLine();
        String sname=sc.nextLine();
        Strana sfind = findForName(country, sname);

        if (sfind != null) {
            showCountry(sfind);
        } else {
            System.out.println("Такої країни немає у списку!");
        }}}
