import java.io.IOException;
import java.util.Scanner;

public class NVVeSinh extends CaNhan{
	Scanner input = new Scanner(System.in);
	
	private final double hesoluong = 1.0;
    private int iShift;
    private double dThuong;

	public int getiShift()
	{
		return this.iShift;
	}
	
	public void setiShift(int ca)
	{
		this.iShift = ca;
	}
	
	public double getdThuong()
	{
		return this.dThuong;
	}
	
	public void setdThuong(double Thuong)
	{
		this.dThuong = Thuong;
	}
    
	public NVVeSinh() {
		this.sNghe = "NVVeSinh";
		// TODO Auto-generated constructor stub
	}

	public NVVeSinh(String hoten, int thoigianhopdong, double luongcoban, String cmnd, int namsinh, int ca, double thuong)
    {
		super(hoten, thoigianhopdong
        , luongcoban, cmnd, namsinh);
        this.iShift = ca;
        this.dThuong = thuong;
    }

    public NVVeSinh(String hoten, double luongcoban, String cmnd, int time)
    {
    	super(hoten, luongcoban, cmnd);
        this.iShift = time;
    }
    
    public void Nhap() throws IOException
    {
        System.out.println("Moi nhap thong tin Nhan Vien Ve Sinh ~~ ");
        super.Nhap();

        System.out.print("Moi nhap Ca lam viec cua Nhan Vien Ve Sinh: ");
        this.iShift = input.nextInt();

        System.out.print("Moi nhap Luong thuong cua Nhan Vien Ve Sinh: ");
        this.dThuong = input.nextDouble();
    }

	@Override
	public double TinhLuong() {
		// TODO Auto-generated method stub
		return super.dLuongCoBan + this.dThuong * this.hesoluong;
	}
    
	public void Xuat()
    {
        super.Xuat();
        System.out.println("Ca lam cua Nhan Vien Ve Sinh la: " + this.iShift);
        System.out.println("Luong thuong them cua Nhan Vien Ve Sinh la: " + this.dThuong + " VND");
    }
	
	public static double operatorTong (NVVeSinh a, double num)
    {
        return a.TinhLuong() + num;
    }
}
