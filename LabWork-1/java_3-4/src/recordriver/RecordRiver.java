package recordriver;

import java.util.Scanner;

class RiverInfo{
    String name, location;
    int lenghtRiver;

}

public class RecordRiver {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "cp1251");
        System.out.println("������ ������� ���� => ");// �������� ���������� ��� ����
        int numR = scan.nextInt();
//------------------------------------------------------------------
        RiverInfo[] river = new RiverInfo[numR];
//------------------------------------------------------------------
        System.out.println("������ ���������� ��� ����: ");//�������� ������������� ����
        for (int i = 0; i < river.length; i++) {
            scan.nextLine(); // �������� ������
            river[i] = new RiverInfo();
            System.out.print("����� " + (i + 1) + "-� ���� => ");
            river[i].name = scan.nextLine();
            System.out.print("������� " + (i + 1) + "-� ���� => ");
            river[i].location = scan.nextLine();
            System.out.print("���������� " + (i + 1) + "-� ���� => ");
            river[i].lenghtRiver = scan.nextInt();
        }
//------------------------------------------------------------------



        System.out.println("\n----------- ���������� ��� ���� -----------");
        for (int i = 0; i < river.length; i++) {
            System.out.println("\t\n����� ���� : " + river[i].name +
                    "\t\n̳�������������� : " + river[i].location +
                    "\t\n���������� : " + river[i].lenghtRiver + " ��" + "\n-------------------------------------");
        }

        int numRiver = 0;//����� �������� ��� ���� � ������������ ���������� (��������� ��������)
        int min = river[numRiver].lenghtRiver;

        for (int i = 0; i < river.length; i++) {
            if (river[i].lenghtRiver < min) {
                min = river[i].lenghtRiver;
                numRiver = i;

                System.out.println("\n----------- г��� � ��������� ���������� -----------");

                System.out.println("" + river[numRiver].name + "\t"
                        + river[numRiver].lenghtRiver + " ��" + "\n-------------------------------------");

            }
        }
        // ���������� ����� ��������
        System.out.println("\n----------- ���������� ����� �������� -----------");
        int lengthR = 0; // ���������� (������)

        for (int i = 0; i < river.length; i++)
            lengthR += river[i].lenghtRiver;
        double sr = lengthR / river.length;
        ; // ������� ����������
        System.out.println("������� ���������� =" + sr);
        System.out.println("\nг���, � ���������� ����� ��������");

        for (int i = 0; i < river.length; i++) {
            if (river[i].lenghtRiver > sr)
                System.out.println(river[i].name + "\t"
                        + river[i].lenghtRiver + " ��" + "\n-------------------------------------");
        }


        //------------------------------------------------------------------

        // ���������� ���� �� ������
        System.out.println("\n----------- ���������� ���� �� ������ -----------");
        for (int i = 0; i < river.length - 1; i++)
            for (int j = 0; j < river.length - i - 1; j++)
                if (river[j].name.compareTo(river[i + 1].name) > 0) {
                    RiverInfo rab = river[j]; //rab � ������ ����� ��� ������������
                    river[j] = river[j + 1];
                    river[j + 1] = rab;
                }
        System.out.println("\n³����������� ������ �� ������:");
        for (int i = 0; i < river.length; i++) {
            System.out.println("����� " + river[i].name +
                    "\t ̳�������������� " + river[i].location +
                    " ���������� "+river[i].lenghtRiver + " ��" +
                    "\n-------------------------------------------------------");
        }

        //------------------------------------------------------------------

        // ����� �� ������

        scan.nextLine(); // �������� ������
        System.out.println("������ ����� ���� ��� ��������� ����� => ");
        String name = scan.nextLine();
        int num = -1; //1 � ����� � ������� ������ �������
        for (int i = 0; i < river.length; i++) {
            if (name.equalsIgnoreCase(river[i].name)) num = i;{
                if (num != -1) {
                    System.out.println("���� ���� � � ������" +
                            "\n �� : " + river[num].name +
                            "\n ��������������� : " + river[num].location +
                            "\n ���������� : " + river[num].lenghtRiver+" ��. "+
                            "\n-------------------------------------------------------");


                } else System.out.println("���� ���� ���� � ������");
            }

        }

        System.out.println("������ ����� ���� ��� ���� ����� : ");
        String named = scan.nextLine();
        int newVal = -1; //1 � ����� � ������� ������ �������
        for (int i = 0; i < river.length; i++) {

            if (named.equalsIgnoreCase(river[i].name)) newVal = i;
            {
                if (newVal != -1) {

                    System.out.println("���� ���� � � ������. " + river[i].name +
                            " - " + river[i].location +
                            " - " + river[i].lenghtRiver);
                    System.out.print("������ ���� ����� ���� : ");
                    river[newVal].name = scan.nextLine();

                    System.out.print("������ ���� ������� ���� : ");
                    river[newVal].location = scan.nextLine();

                    System.out.print("������ ���� ���������� ���� : ");
                    river[newVal].lenghtRiver = scan.nextInt();

                    System.out.println("\n�������� ���������� ��� ����:");// ��������� ���������� ��� ����

                    System.out.println("\t\n����� ���� " + river[newVal].name + "\t\n̳�������������� "
                            + river[newVal].location +
                            "\t\n���������� " + river[newVal].lenghtRiver + " ��" + "\n-------------------------------------");

                } else System.out.println("г��� � ����� ������ ���� � ������");

            }
        }
    }
}

