import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HLVTheLuc extends CaNhan {
	Scanner input = new Scanner(System.in);
	
	private final double hesoluong = 1.3;
    private int iChiSoNangCaoTL;
    private String sNoiSinh;

	public int getiChiSoNangCaoTL()
	{
		return this.iChiSoNangCaoTL;
	}
	
	public void setiChiSoNangCaoTL(int chisonangcaotl)
	{
		this.iChiSoNangCaoTL = chisonangcaotl;
	}
	
	public String getsNoiSinh()
	{
		return this.sNoiSinh;
	}
	
	public void setsNoiSinh(String noisinh)
	{
		this.sNoiSinh = noisinh;
	}
    
	public HLVTheLuc() 
	{
		// TODO Auto-generated constructor stub
		this.sNghe = "HLVTL";
	}

	 public HLVTheLuc(String hoten, String NgayGiaNhap, int thoigianhopdong, double luongcoban,int NangCaoTL, String cmnd, int namsinh, String noisinh) 
	 {
		 super(hoten, NgayGiaNhap, thoigianhopdong, luongcoban, cmnd , namsinh);
         this.iChiSoNangCaoTL = NangCaoTL;
         this.sNoiSinh = noisinh;
     }

     public HLVTheLuc(String hoten, String NgayGiaNhap, double luongcoban, int NangCaoTL, String cmnd, String noisinh)
     {
    	 super(hoten, luongcoban, cmnd);
         this.iChiSoNangCaoTL = NangCaoTL;
         this.sNoiSinh = noisinh;
     }
     
     public void Nhap() throws IOException
     {
    	 InputStreamReader ips=new InputStreamReader(System.in);
         BufferedReader br=new BufferedReader(ips);
         System.out.println("Moi nhap thong tin HLV The Luc ~~ ");
         super.Nhap();

         System.out.print("Moi nhap chi so nang Cao TL: ");
         this.iChiSoNangCaoTL = input.nextInt();

         System.out.print("Moi nhap Quoc Gia cua HLV The Luc: ");
         this.sNoiSinh = br.readLine();
     }

	@Override
	public double TinhLuong() 
	{
		// TODO Auto-generated method stub
		 return this.dLuongCoBan * hesoluong - this.TinhThue(hesoluong);
	}
     
	 public void Xuat()
     {
         
         super.Xuat();
         System.out.println("Tuoi cua HVL The Luc la: " + this.TinhTuoi());

         System.out.println("HLV the luc den tu: " + this.sNoiSinh);

         System.out.println("chi so nang cao the luc : " + this.iChiSoNangCaoTL);

         System.out.println("Luong cua HLV The Luc la: " + this.TinhLuong() + " VND");

         if (this.dLuongCoBan > 11000000)
        	 System.out.println("Thue thu nhap ca nhan cua HLV The Luc la: " + this.TinhThue(hesoluong) + " VND");
         else
        	 System.out.println("Doi tuong khong nam trong danh sach dong thue!! ");
     }
	 
	 public static double operatorTong(HLVTheLuc a, double num)
     {
         return a.TinhLuong() + num;
     }
}
