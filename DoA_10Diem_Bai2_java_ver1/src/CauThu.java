import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CauThu extends CaNhan
{

	private final double hesoluong= 1.3;
    private int iSoAo;
    private int iTinhTrangTheLuc;
    private int iTinhTrangSucKhoe;
    private String sChanThuan;
    private String sViTriDaChinh;
    
    public int getiSoAo()
    {
    	return this.iSoAo;
    }
    
    public void setiSoAo(int iSoAo)
    {
    	this.iSoAo = iSoAo;
    }

    public int getiTinhTrangTheLuc()
    {
    	return this.iTinhTrangTheLuc;
    }
    
    public void setiTinhTrangTheLuc(int iTinhTrangTheLuc)
    {
    	this.iTinhTrangTheLuc = iTinhTrangTheLuc;
    }

    public int getiTinhTrangSucKhoe()
    {
    	return this.iTinhTrangSucKhoe;
    }
    
    public void setiTinhTrangSucKhoe(int iTinhTrangSucKhoe)
    {
    	this.iTinhTrangSucKhoe = iTinhTrangSucKhoe;
    }
    
    public String getsChanThuan()
    {
    	return this.sChanThuan;
    }
    
    public void setsChanThuan(String sChanThuan)
    {
    	this.sChanThuan = sChanThuan;
    }
    
    public String getsViTriDaChinh()
    {
    	return this.sViTriDaChinh;
    }
	
    public void setsViTriDaChinh(String sViTriDaChinh)
    {
    	this.sViTriDaChinh = sViTriDaChinh;
    }
    
    public CauThu(String hoten, String NgayGiaNhap ,int thoigianhopdong, double luongcoban, String cmnd, int namsinh, int soao, int tinhtrangsuckhoe, int tinhtrangtheluc, String chanthuan, String vitridachinh)
    {
    	super(hoten, NgayGiaNhap, thoigianhopdong, luongcoban, cmnd, namsinh);
        this.iSoAo = soao;
        this.iTinhTrangSucKhoe = tinhtrangsuckhoe;
        this.iTinhTrangTheLuc = tinhtrangtheluc;
        this.sChanThuan = chanthuan;
        this.sViTriDaChinh = vitridachinh;
    }
    
    public CauThu(String hoten, double luongcoban, String cmnd, int soao)
    {
    	super(hoten, luongcoban, cmnd);
        this.iSoAo = soao;
    }
    
	public CauThu() {}

	public void Nhap() throws IOException
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    	InputStreamReader ips=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ips);
        
		System.out.println("Moi nhap Thong Tin Cau Thu ~~ ");
		super.Nhap();
		System.out.print("So Ao cua Cau Thu la: ");
		this.iSoAo = input.nextInt();
		
		System.out.print("Tinh Trang The Luc cua Cau Thu la: ");
		this.iTinhTrangTheLuc = input.nextInt();
		
		System.out.print("Tinh Trang Suc Khoe cua Cau Thu la: ");
		this.iTinhTrangSucKhoe = input.nextInt();
		
		System.out.print("Chan Thuan cua Cau Thu la: ");
		this.sChanThuan = br.readLine();
		
		System.out.print("Vi Tri Da Chinh cua Cau Thu la: ");
		this.sViTriDaChinh = br.readLine();
	}
	
	@Override
	public double TinhLuong() 
	{
		// TODO Auto-generated method stub
		 return dLuongCoBan * hesoluong - this.TinhThue(hesoluong);
	}
	
	public void Xuat()
    {
        System.out.println("Thong Tin Cau Thu ~~ ");
        super.Xuat();

        System.out.println("Tuoi cua Cau Thu la: " + this.TinhTuoi());
        System.out.println("So Ao co dinh cua Cau Thu la: " + this.iSoAo);
        System.out.println("Chan Thuan cua Cau Thu la: " + this.sChanThuan);
        System.out.println("Vi tri Da Chinh trong doi hinh la: " + this.sViTriDaChinh);
        System.out.println("Luong cua Cau Thu la: " + this.TinhLuong() + " VND");

        if (this.dLuongCoBan > 11000000)
        	System.out.println("Thue thu nhap ca nhan cua Cau Thu la: " + this.TinhThue(hesoluong) + " VND");
        else
        	System.out.println("Doi tuong khong nam trong danh sach dong thue!! ");
    }
	
	public static boolean operatorLon(CauThu a, CauThu b)
	{
        int value1 = a.iTinhTrangSucKhoe;
        int value2 = b.iTinhTrangSucKhoe;
        return value1 > value2;
    }

    public static boolean operatorBe(CauThu a, CauThu b)
    {
        double value1 = a.iTinhTrangSucKhoe;
        double value2 = b.iTinhTrangSucKhoe;
        return value1 < value2;
    }

    public static double operatorTong (CauThu a, double num)
    {
        return a.TinhLuong() + num;
    }
    
    @SuppressWarnings("deprecation")
	public int SoSanhNgayGiaNhap(CauThu a, CauThu b)
    {
    	DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        int temp = 0;
        try {
        	String startDate = simpleDateFormat.format(a.dNgayGiaNhap);
        	String endDate = simpleDateFormat.format(b.dNgayGiaNhap);
        	
        	date1 = simpleDateFormat.parse(startDate);
        	date2 = simpleDateFormat.parse(endDate);
        	
			temp = date2.getDate() - date1.getDate();
        	//return temp;
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	//return (Integer) null;
        }
        if (temp >=0)
        	return 1;
        else
        	return 0;
    }
}
