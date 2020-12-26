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
    
    static public void DaGiaoLuu(List<CauThu> listCT, HLVChienThuat HLV) throws IOException
    {
    	InputStreamReader ips = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ips);
    	System.out.println("Chon cau thu tham gia thi dau");
        List<CauThu> listCT2 = HoatDong.TuyenChon11CT(listCT);
        System.out.println("Chon chien thuat");
        String chienthuat = HLV.ChonChienThuat();
        System.out.print("Nhap doi thu: ");
        String dt = br.readLine();
        System.out.println("\t\t\t************************************************\t\t\t");
        System.out.println("Doi nha VS" + dt);
        System.out.println("Danh sach cau thu tham du!");
        for (var item : listCT2)
        {
        	System.out.println("Cau thu " + item.sHoTen + " so ao: " + item.getiSoAo());
        }
        System.out.print("Huan luyen vien: "+HLV.sHoTen);
        System.out.print("Chien thuat: " + chienthuat);
        System.out.println("\t\t\t************************************************\t\t\t");
    }
}
