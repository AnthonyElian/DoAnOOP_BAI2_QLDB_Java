import java.io.IOException;
import java.util.Scanner;

public class BacSi extends CaNhan
{
	private final double hesoluong = 1.15;
    private String sRank;
    private String sTruongDaoTao;
    
    public String getsRank()
    {
    	return this.sRank;
    }
    
    public void setsRank(String sRank)
    {
    	this.sRank = sRank;
    }
    
    public String getsTruongDaoTao()
    {
    	return this.sTruongDaoTao;
    }
    
    public void setsTruongDaoTao(String sTruongDaoTao)
    {
    	this.sTruongDaoTao = sTruongDaoTao;
    }
	
	public BacSi()
	{
		// TODO Auto-generated constructor stub
		this.sNghe = "bacsi";
	}
	
	public BacSi(String hoten, String NgayGiaNhap, int thoigianhopdong, double luongcoban, String cmnd, int namsinh, String rank, String truong)
	{
		super(hoten, NgayGiaNhap, thoigianhopdong, luongcoban, cmnd, namsinh);
		this.sRank = rank;
		this.sTruongDaoTao = truong;
	}
	
	public BacSi(String hoten, double luongcoban, String cmnd, String rank)
	{
		super(hoten, luongcoban, cmnd);
		this.sRank = rank;
	}
	
	@SuppressWarnings("resource")
	public void Nhap() throws IOException
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Moi nhap thong tin Bac Si ~~ ");
		super.Nhap();
		
		System.out.print("Moi nhap loai Bang cua Bac Si: ");
		this.sRank = input.nextLine();
		
		System.out.print("Moi nhap Truong dao tao Bac Si: ");
		this.sTruongDaoTao = input.nextLine();
	}
	
	@SuppressWarnings("resource")
	public int Kham(int a)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Moi nhap Tinh Trang(The Luc) cua Cau Thu: ");
		a = input.nextInt();
		if (a < 50)
		{
			System.out.println("Cau thu bi chan thuong !!");
			System.out.print("1_Chua benh || 2_Khong Chua  => your choice: ");
			int temp = input.nextInt();
			if (temp == 1)
			{
				a = this.ChuaBenh(a);
				System.out.println("Cau thu da duoc chua benh -> " + a);
				return a;
			}
			else
			{
				System.out.println("Cau thu dang dau qua");
				return a;
			}
		}
        else
        {
        	System.out.println("Cau thu dang o tinh trang the luc tot !!");
        	return a;
        }
	}
	
	public int ChuaBenh(int a)
    {
        return a = 100;
        //System.out.println("Cau thu dang o tinh trang the luc tot nhat !!");
    }

	@Override
	public double TinhLuong() {
		// TODO Auto-generated method stub
		return dLuongCoBan * hesoluong - this.TinhThue(hesoluong);
	}
	
	public void Xuat()
    {
        super.Xuat();
        System.out.println("Bang cua Bac Si hang: " + this.sRank);
        System.out.println("Truong dao tao cua Bac Si la: " + this.sTruongDaoTao);
        System.out.println("Luong cua Bac Si la: " + this.TinhLuong() + " VND");
        if (this.dLuongCoBan > 11000000)
        	System.out.println("Thue thu nhap ca nhan cua Cau Thu la: " + this.TinhThue(hesoluong) + " VND");
        else
        	System.out.println("Doi tuong khong nam trong danh sach dong thue!! ");
    }

	 public static double operatorTong (BacSi a, double num)
     {
         return a.TinhLuong() + num;
     }
}
