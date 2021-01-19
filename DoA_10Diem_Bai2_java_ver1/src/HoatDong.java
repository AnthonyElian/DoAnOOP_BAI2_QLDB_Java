import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HoatDong {
	
	
	static public void KhamSucKhoeToanDoi(List<CauThu> list, BacSi BS)
    {
        for(int i=0;i<list.size();i++)
        {
            CauThu temp = list.get(i);
            HoatDong.KhamSucKhoeCauThu(temp, BS);
            list.set(i, temp);
        }       
    }
	
	static public void KhamSucKhoeCauThu(CauThu CT, BacSi BS)
    {
        int a = 0;
        System.out.println("Cau thu: " + CT.sHoTen);
        a = BS.Kham(a);
        CT.setiTinhTrangSucKhoe(a) ;
    }
	
	static public List<CauThu> TuyenChon11CT(List<CauThu> list)
    {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        List<CauThu> temp= new ArrayList<CauThu>();
        System.out.println("=============================");
        System.out.println(" 1: Chon 11 Cau thu co TL tot nhat");
        System.out.println(" 2: Tu ban chon");
        System.out.print("Ban muon chon theo cai gi: ");
        int choose = input.nextInt();
        if(list.size() <= 11)
        {
        	System.out.println("Doi <=11 nguoi => Khong the chon Doi !!");
            return list;
        }
        switch (choose)
        {
            case 1:
                {
                	for (int i=0; i<list.size() - 1; i++)
                	{
                		if (list.get(i).getiTinhTrangTheLuc() > list.get(i+1).getiTinhTrangTheLuc())
                		{
                			CauThu temp1 = new CauThu();
                			temp1 = list.get(i);
                			list.set(i, list.get(i+1));
                			list.set(i+1, temp1);
                		}
                	}
                    for (int i = 0; i < 11; i++)
                        temp.add(list.get(i));
                    return temp;
                }
            case 2:
                {
                	System.out.println("Day la DS cau thu");
                    for (var item : list)
                    {
                    	System.out.println(" " + item.sHoTen);
                    }
                    for(int i=0;i<11;i++)
                    {
                    	System.out.print("Moi chon cau thu thu " + (i + 1) + ": ");
                        int x= input.nextInt();
                        temp.add(list.get(x));
                    }
                    return temp;
                }
            default:
                {
                    return temp;
                }
        }
    }
	
	static public void HuanLuyenTLCaDoi( List<CauThu> list, HLVTheLuc HLV)
    {
        for(int i=0;i<list.size();i++)
        {
            list.get(i).setiTinhTrangTheLuc(list.get(i).getiTinhTrangTheLuc() + HLV.getiChiSoNangCaoTL()) ; 
        }
    }
    static public void HuanLuyenTL(CauThu CT, HLVTheLuc HLV)
    {
        CT.setiTinhTrangTheLuc(CT.getiTinhTrangTheLuc() + HLV.getiChiSoNangCaoTL());
    } 
    
    static public void DaGiaoLuu(List<CauThu> listCT, HLVChienThuat HLV, San san) throws IOException
    {
    	Scanner input = new Scanner(System.in);
    	InputStreamReader ips = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ips);
    	System.out.println("Chon cau thu tham gia thi dau");
        List<CauThu> listCT2 = HoatDong.TuyenChon11CT(listCT);
        System.out.println("Chon chien thuat");
        String chienthuat = HLV.ChonChienThuat();
        System.out.print("Nhap doi thu: ");
        String dt = br.readLine();
        System.out.print("Ban muon da tren san nha:1 hay san khach:2 => Your choice: ");
        int key = input.nextInt(); int flag;
        String tensan = "";
        if (key == 1)
        {
            if (san != null)
            {
                flag = 1;
            }
            else
            {
                flag = 2;
                System.out.print("Doi tuyen khong co san, Moi nhap ten san khach: "); tensan = br.readLine();
            }
        }
        else
        {
            flag = 2;
            System.out.print("Moi nhap ten san khach: ");tensan = br.readLine();
        }
        int soLuong = 0;
        if (flag == 1)
        {
            do
            {
            	System.out.print("Moi nhap so luong khan gia da mua ve: ");
                soLuong = input.nextInt();

            } while (san.getiSoLuongKhanGia() < soLuong);
        }
        System.out.println("\t\t\t************************************************\t\t\t");
        System.out.println("Doi nha VS" + dt);
        System.out.println("Danh sach cau thu tham du!");
        for (var item : listCT2)
        {
        	System.out.println("Cau thu " + item.sHoTen + " so ao: " + item.getiSoAo());
        }
        System.out.print("Huan luyen vien: "+HLV.sHoTen);
        System.out.print("Chien thuat: " + chienthuat);
        System.out.println("\n\t\t\t************************************************\t\t\t\n");
        System.out.print("1_Thang || 2_Thua => Your choice: ");
        int temp = input.nextInt();
        if (temp == 1)
        {
            for (int i=0;i<listCT2.size();i++)
            {
                for (int j=0;j<listCT.size();j++)
                {
                    if (listCT2.get(i).sHoTen == listCT.get(j).sHoTen)
                    {
                        listCT.get(j).dLuongCoBan = listCT.get(j).dLuongCoBan + 500000;
                        listCT.get(j).setiTinhTrangSucKhoe(listCT.get(j).getiTinhTrangSucKhoe() - 2);
                        listCT.get(j).setiTinhTrangTheLuc(listCT.get(j).getiTinhTrangTheLuc() - 3);
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < listCT2.size(); i++)
            {
                for (int j = 0; j < listCT.size(); j++)
                {
                    if (listCT2.get(i).sHoTen == listCT.get(j).sHoTen)
                    {
                    	listCT.get(j).setiTinhTrangSucKhoe(listCT.get(j).getiTinhTrangSucKhoe() - 5);
                        listCT.get(j).setiTinhTrangTheLuc(listCT.get(j).getiTinhTrangTheLuc() - 7);
                    }
                }
            }
        }
        if (flag == 1)
        {
            System.out.println("Thu nhap cua san bong la: " + san.getdGiaVe()* soLuong);
        }
    }
    
    static public void createCauThu(List<CauThu> chuyennhuong)
    {
    	CauThu a = new CauThu("nguyen van a", 30000000, "56893457", 1998, 1, 56, 72, "trai", "tienve");
        CauThu b = new CauThu("nguyen van b", 20000000, "56630787", 2000, 90, 88, 12, "phai", "hauve");
        CauThu c = new CauThu("nguyen van c", 67000000, "99637457", 1995, 57, 26, 82, "trai", "tiendao");
        CauThu d = new CauThu("nguyen van d", 100000000, "63019457", 1998, 420, 100, 100, "phai", "tiendao");
        CauThu e = new CauThu("nguyen van e", 12000000, "56891234", 2005, 1, 36, 22, "phai", "tiendao");
        CauThu f = new CauThu("nguyen van f", 10000000, "12343457", 2004, 1, 46, 52, "phai", "tienve");
        chuyennhuong.add(a); chuyennhuong.add(b); chuyennhuong.add(c); chuyennhuong.add(d); chuyennhuong.add(e); chuyennhuong.add(f);
    }
    
    static public void ChuyenNhuong(QuanLyCauThu ct, List<CauThu> temp)
    {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Da den ki chuyen nhuong mua Dong, ban co muon mua them hay ban di cau thu ko? 1_Yes || 2_No");
    	System.out.print("=> Your choice: "); int choice = input.nextInt();
        if (choice == 1)
        {
            int flag = 1;
            while (flag == 1)
            {
            	System.out.println("\t\t\t************************MENU************************\t\t\t");
                System.out.println("\t\t\t***            1. Mua                            ***\t\t\t");
                System.out.println("\t\t\t***            2. Ban                            ***\t\t\t");
                System.out.println("\t\t\t***            3. Thoat                          ***\t\t\t");
                System.out.println("\t\t\t****************************************************\t\t\t");
                System.out.print("Moi nhap lua chon cua ban => Your choice: ");
                int choice1 = input.nextInt();
                switch (choice1)
                {
                case 1:
                {
                    int i = 0;
                    for (var item : temp)
                    {
                        System.out.println("STT: " + i++ + " Ho ten: " + item.sHoTen + " Luong: " + item.TinhLuong());
                    }
                    System.out.print("Moi nhap STT cau thu muon mua: ");
                    int n = input.nextInt();
                    temp.get(n).dNgayGiaNhap = "16/01/2001";
                    System.out.print("Ban muon ki hop dong thoi han bao lau: ");  int thoihan = input.nextInt();
                    temp.get(n).iThoiGianHopDong = thoihan;
                    temp.get(n).sNghe = "CauThu";
                    ct.getlDsCauThu().add(temp.get(n));
                    temp.remove(n);
                    System.out.println("Successfully ~~ ");
                    break;
                }
                case 2:
                {
                    int i = 0;
                    for (var item : ct.getlDsCauThu())
                    {
                        System.out.println("STT: " + i++ + " Ho ten: " + item.sHoTen + " Luong: " + item.TinhLuong());
                    }
                    System.out.print("Ban muon ban cau thu so may: "); int stt = input.nextInt();
                    ct.xoa1CT(stt);
                    System.out.println("Successfully ~~ ");
                    break;
                }
                case 3:
                {
                    flag = 0;
                    break;
                }
                default:
                {
                    System.out.println("Nhap sai, moi nhap lai!! ");
                    break;
                }
                }
            }
        }
    }
}
