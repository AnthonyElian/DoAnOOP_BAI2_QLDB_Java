import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NVBaoVe extends CaNhan{
	Scanner input = new Scanner(System.in);
	
	private final double hesoluong = 1.0;
    private int iThoiGianLamTrongNgay;
    private String sMauDongPhuc;
    
    public int getiThoiGianLamTrongNgay()
    {
    	return this.iThoiGianLamTrongNgay;
    }
    
    public void setiThoiGianLamTrongNgay(int tgian)
    {
    	this.iThoiGianLamTrongNgay = tgian;
    }
    
    public String getsMauDongPhuc()
    {
    	return this.sMauDongPhuc;
    }
    
    public void setsMauDongPhuc(String color)
    {
    	this.sMauDongPhuc = color;
    }
	
	public NVBaoVe() 
	{
		this.sNghe = "NVBaoVe";
		// TODO Auto-generated constructor stub
	}
	
	public NVBaoVe(String hoten, int thoigianhopdong, double luongcoban, String cmnd, int namsinh, int time, String color)
    {
		super(hoten, thoigianhopdong
        , luongcoban, cmnd, namsinh);
        this.iThoiGianLamTrongNgay = time;
        this.sMauDongPhuc = color;
    }

	public NVBaoVe(String hoten, double luongcoban, String cmnd, int time)
    {
		super(hoten, luongcoban, cmnd);
        this.iThoiGianLamTrongNgay = time;
    }

	public void Nhap() throws IOException
    {
		InputStreamReader ips=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ips);
        System.out.println("Moi nhap thong tin Nhan Vien Bao Ve ~~ ");
        try {
			super.Nhap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.print("Moi nhap Thoi Gian Lam Viec/Ngay cua Nhan Vien Bao Ve: ");
        this.iThoiGianLamTrongNgay = input.nextInt();

        System.out.print("Moi nhap Mau Dong Phuc hom nay cu Nhan Vien Bao Ve: ");
        this.sMauDongPhuc = br.readLine();
    }

	@Override
	public double TinhLuong() 
	{
		// TODO Auto-generated method stub
		return super.dLuongCoBan + super.dLuongCoBan * this.hesoluong;
	}
	
	public void Xuat()
    {
        super.Xuat();
        System.out.println("Tong thoi gian lam tren mot ngay la: " + this.iThoiGianLamTrongNgay);
        System.out.println("Mau Dong Phuc NV Bao Ve: " + this.sMauDongPhuc);
    }
	
	public static double operatorTong (NVBaoVe a, double num)
    {
        return a.TinhLuong() + num;
    }
}
