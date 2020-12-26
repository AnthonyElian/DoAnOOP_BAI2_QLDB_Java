import java.io.IOException;
import java.util.Scanner;

public class HLVChienThuat extends CaNhan {
	Scanner input = new Scanner(System.in);
	
	private final double hesoluong = 1.3;
    private String sRank;
    private String sQuocGia;
    private int iKinhNghiem;
    
    public String getsRank()
    {
    	return this.sRank;
    }
    
    public void setsRank(String rank)
    {
    	this.sRank = rank;
    }
    
    public String getsQuocGia()
    {
    	return this.sQuocGia;
    }
    
    public void setsQuocGia(String quocgia)
    {
    	this.sQuocGia = quocgia;
    }
    
    public int getiKinhNghiem()
    {
    	return this.iKinhNghiem;
    }
    
    public void setiKinhNghiem(int kinhnghiem)
    {
    	this.iKinhNghiem = kinhnghiem;
    }
	
	public HLVChienThuat() 
	{
		this.sNghe = "HLVCT";
		// TODO Auto-generated constructor stub
	}
	
	 public HLVChienThuat(String hoten, int thoigianhopdong, double luongcoban, String cmnd, int namsinh, String rank, String quocgia, int kinhnghiem) 
     {
		 super(hoten, thoigianhopdong, luongcoban, cmnd, namsinh);
         this.sRank = rank;
         this.sQuocGia = quocgia;
         this.iKinhNghiem = kinhnghiem;
     }

     public HLVChienThuat(String hoten, double luongcoban, String cmnd, String rank)
     {
    	 super(hoten, luongcoban, cmnd);
         this.sRank = rank;
     }
     
     public void Nhap()
     {
    	 //Scanner input = new Scanner(System.in);
         System.out.println("Moi nhap thong tin HLV Chien Thuat ~~ ");
         try 
         {
			super.Nhap();
         }
         catch (IOException e) 
         {
			// TODO Auto-generated catch block
			e.printStackTrace();
         }

         System.out.print("Moi nhap han cua HLV //Hang: C_B_A_Pro : ");
         this.sRank = input.nextLine();

         System.out.print("Moi nhap Quoc Gia cua HLV: ");
         this.sQuocGia = input.nextLine();

         System.out.print("Moi nhap so doi ma HLV da tung cong tac: ");
         this.iKinhNghiem = input.nextInt();
     }

	@Override
	public double TinhLuong() 
	{
		// TODO Auto-generated method stub
		return this.dLuongCoBan * hesoluong - TinhThue(hesoluong);
	}
     
	public void Xuat()
    {
        super.Xuat();

        System.out.println("Hang cua HLV Chien Thuat la: " + this.sRank);

        System.out.println("HLV Chien Thuat den tu: " + this.sQuocGia);

        System.out.println("So doi bong HLV nay tung dan dat: " + this.iKinhNghiem);

        System.out.println("Luong cua HLV Chien Thuat: " + this.TinhLuong() + " VND");

        if (this.dLuongCoBan > 11000000)
        	System.out.println("Thue thu nhap ca nhan cua HLV Chien Thuat la: " + this.TinhThue(hesoluong) + " VND");
        else
        	System.out.println("Doi tuong khong nam trong danh sach dong thue!! ");
    } 
	
	public String ChonChienThuat()
    {
		//Scanner input = new
		System.out.print("Ban Muon chon chien thuat nao: ");
        String temp = input.nextLine();
        return temp;
    }

    public static double operatorTong(HLVChienThuat a, double num)
    {
        return a.TinhLuong() + num;
    }
}
