import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int flag = 1;
        DoiBong a = new DoiBong();
        a.Nhap();
        San san = new San();
        int co = 1, co2 = 1, co3 = 0, co4 = 0;
        while (flag == 1)
        {
        	System.out.println("\t\t\t************************MENU************************\t\t\t");
        	System.out.println("\t\t\t***            1. Quan Ly Cau Thu                ***\t\t\t");
        	System.out.println("\t\t\t***            2. Quan Ly Nhan Vien              ***\t\t\t");
        	System.out.println("\t\t\t***            3. Quan Ly San                    ***\t\t\t");
        	System.out.println("\t\t\t***            4. Hoat Dong                      ***\t\t\t");
        	System.out.println("\t\t\t***            5. Thoat                          ***\t\t\t");
        	System.out.println("\t\t\t****************************************************\t\t\t");
        	System.out.print("Moi nhap lua chon cua ban => Your choice: ");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    {
                        a.MenuQLCT();
                        co3 = 1;
                        break;
                    }
                case 2:
                    {
                        a.MenuQLNV();
                        co4 = 1;
                        break;
                    }
                case 3:
                    {
                        if (co == 1)
                        {
                        	System.out.print("Doi Bong co san co khong? 1_Co || 2_Khong : ");
                            int temp = input.nextInt();
                            if (temp == 1)
                            {
                                san.Nhap();
                                System.out.println("//////////////////////////////////////////////////////////////////////");
                                san.Xuat();
                            }
                            else
                            {
                                co2 = 0;
                                san = null;
                                System.out.println("Doi bong khong co San!! ");
                            }
                            co = 0;
                        }
                        else
                        {
                            if (co2 == 1)
                                san.Xuat();
                            else 
                            	System.out.println("Doi bong khong co San!! ");
                        }
                        break;
                    }
                case 4:
                    {
                        if (co3 == 1 && co4 == 1)
                            a.MenuHoatDong();
                        else
                        	System.out.println("Yeu cau phai nhap 1 va 2 truoc moi co the su dung Tinh Nang nay !!");
                        break;
                    }
                case 5:
                    {
                        flag = 0;
                        break;
                    }
                default:
                    {
                    	System.out.println("Nhap sai, moi nhap lai!!  ");
                        break;
                    }
            }
        }
	}
}
