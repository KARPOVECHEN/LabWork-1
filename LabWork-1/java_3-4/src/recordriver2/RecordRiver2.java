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

        System.out.println("������ ���������� ��� ����: ");//�������� ������������� ����
        for (int i = 0; i < river.length; i++) {
            scan.nextLine(); // �������� ������
            river[i] = new RiverInfo2();
            System.out.print("����� " + (i + 1) + "-� ���� => ");
            river[i].name = scan.nextLine();
            System.out.print("������� " + (i + 1) + "-� ���� => ");
            river[i].location = scan.nextLine();
            System.out.print("���������� " + (i + 1) + "-� ���� => ");
            river[i].lenghtRiver = scan.nextInt();
        }
        return river;
    }
    //------------------------------------------------------------------
    public static void showRiver(RiverInfo2 river) {
// ���������� ��� ���� ����
        System.out.println("\t\n����� ���� : " + river.name +
                "\t\n̳�������������� : " + river.location +
                "\t\n���������� : " + river.lenghtRiver + " ��");
    }
//------------------------------------------------------------------

    public static void showArray(RiverInfo2[] river) {
        // ��������� ������ � ������
        for (int i = 0; i < river.length; i++) {
            System.out.println("\t\n����� ���� : " + river[i].name +
                    "\t\n̳�������������� : " + river[i].location +
                    "\t\n���������� : " + river[i].lenghtRiver + " ��" + "\n-------------------------------------");
        }
    }
    //------------------------------------------------------------------
    public static int NomMax(RiverInfo2[] river) {
        int nommax = 0;    // ����� �������� ���� � ��. ����������
// (��������� ��������)
        double max = river[nommax].lenghtRiver;    //��. ���������� (��������� ��������)
        for (int i = 0; i < river.length; i++)
            if (river[i].lenghtRiver < max) {
                max = river[i].lenghtRiver;
                nommax = i;
            }
        return nommax;
    }
    //------------------------------------------------------------------
    public static void sortName(RiverInfo2[] river) {
// ���������� ���� �� ������
        for (int i = 0; i < river.length - 1; i++)
            for (int j = 0; j < river.length - i - 1; j++)
                if (river[j].name.compareTo(river[i + 1].name) > 0) {
                    RiverInfo2 rab = river[j];        // rab � ������ ����� ��� ������������
                    river[j] = river[j + 1];
                    river[j + 1] = rab;
                }
    }
    //------------------------------------------------------------------
    public static double avglength(RiverInfo2[] river) {

        // ������� ����������
        double s = 0;                // ������� �������
        for (int i = 0; i < river.length; i++)
            s += river[i].lenghtRiver;
        double sr = s / river.length;        // ������� �������
        return sr;
    }
    //------------------------------------------------------------------
    public static RiverInfo2[] Bigger(RiverInfo2 river[]) {

        // ���������� ����� ��������
        double sred = avglength(river);
        int kol = 0;    //������� ����
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
        System.out.println("������ ����� ���� ��� ���� ����� : ");
        String named = scan.nextLine();

        int newVal = -1; //1 � ���� � ������� ������ �������
        for (int i = 0; i < river.length; i++) {

            if (named.equalsIgnoreCase(river[i].name)) newVal = i;

            if (newVal != -1) {

                System.out.println("���� ���� � � ������. "
                        + river[i].name +
                        " - " + river[i].location +
                        " - " + river[i].lenghtRiver);
                System.out.print("������ ���� ����� ���� : ");
                river[newVal].name = scan.nextLine();

                System.out.print("������ ���� ������� ���� : ");
                river[newVal].location = scan.nextLine();

                System.out.print("������ ���� ���������� ���� : ");
                river[newVal].lenghtRiver = scan.nextInt();

                System.out.println("\n�������� ���������� ��� ����:");// ��������� ���������� ��� ����

                return river[newVal];

            } else System.out.println("г��� � ����� ������ ���� � ������");

        }
        return river[newVal];
    }
//------------------------------------------------------------------


    public static void main(String[] args) {
// �������� ���� � ��������
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("������ ������� ���� => ");
        int n = sc.nextInt();    // ������� ����

        RiverInfo2 river[] = setRiverArr(n);    // �������� ���������� ��� �����

        System.out.println("\n�������������� ����:");
        showArray(river);            // ��������� �������� ����������

// ��������� ���������� ����;
        int nommax = NomMax(river);
        System.out.println("\n���������� ����:");
        showRiver(river[nommax]);


// ������������ ������ ���� �� ������� �� �������;
        sortName(river);
        System.out.println("\n³����������� ������ �� ������:");
        showArray(river);

// ������� ���������� ��� ���� � �������� ������ �� �������;
        System.out.println("\nг��� � ���������� ����� ��������");
        RiverInfo2[] larger = Bigger(river);
        showArray(larger);

// ����������� ����� �� ������ ����, ����������� ������ � ���� ��
//��������� ����� ���������� ��� ���� ���� �����������.

//    RecordRiver2.findForName(river);
    showRiver(findForName(river));

    }

}
