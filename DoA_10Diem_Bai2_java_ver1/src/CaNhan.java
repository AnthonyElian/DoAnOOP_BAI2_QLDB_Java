import java.util.Date;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public abstract class CaNhan 
{
	public String sHoTen;
	public String dNgayGiaNhap;
	public int iThoiGianHopDong;
	public double dLuongCoBan;
	public String sCMND;
	public int iNamsinh;
	public String sNghe;
	
	public CaNhan() 
	{
		super();
	}
	
	enum Bac{
		Bac0(0),
		Bac1(1),
		Bac2(2),
        Bac3(3),
        Bac4(4),
        Bac5(5),
        Bac6(6),
        Bac7(7);
		public int value;
		
		private Bac(int value) {
			this.value = value;
		}
	}
	
	public CaNhan(String hoten, String NgayGiaNhap, int thoigianhopdong, double luongcoban, String cmnd, int namsinh)
    {
        this.sHoTen = hoten;
        this.dNgayGiaNhap = NgayGiaNhap;
        this.iThoiGianHopDong = thoigianhopdong;
        this.dLuongCoBan = luongcoban;
        this.sCMND = cmnd;
        this.iNamsinh = namsinh;
    } 
	
	public CaNhan(String hoten, int thoigianhopdong, double luongcoban, String cmnd, int namsinh)
    {
        this.sHoTen = hoten;
        this.iThoiGianHopDong = thoigianhopdong;
        this.dLuongCoBan = luongcoban;
        this.sCMND = cmnd;
        this.iNamsinh = namsinh;
    }

    public CaNhan(String hoten, double luongcoban, String cmnd)
    {
        this.sHoTen = hoten;
        this.dLuongCoBan = luongcoban;
        this.sCMND = cmnd;
    }

    public void Nhap() throws IOException
    {
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    	InputStreamReader ips=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ips);
        
        System.out.print("Moi nhap Ho Ten thanh vien: ");     
        this.sHoTen = br.readLine();

        System.out.print("Nhap ngay gia nhap dinh dang dd/MM/yyyy: ");
        this.dNgayGiaNhap = input.nextLine();

        System.out.print("Moi nhap Thoi Gian Hop Dong: ");
        this.iThoiGianHopDong = input.nextInt();

        
        System.out.print("Moi nhap Luong Co Ban cua thanh vien: ");
        this.dLuongCoBan = input.nextDouble();

        System.out.print("Moi nhap so CMND cua thanh vien: ");
        this.sCMND = br.readLine();

        System.out.print("Moi nhap Nam Sinh cua thanh vien: ");
        this.iNamsinh = input.nextInt();
    }

    public abstract double TinhLuong();

    public void Xuat()
    {
    	System.out.println("Ho Ten thanh vien la: " + this.sHoTen);
    	System.out.println("Ngay Gia Nhap: " + this.dNgayGiaNhap);
    	System.out.println("Thoi gian Hop Dong cua thanh vien la: " + this.iThoiGianHopDong + " nam");
    	System.out.println("Luong co ban cua thanh vien la: " + this.dLuongCoBan + " VND");
    	System.out.println("So CMND cua thanh vien la: " + this.sCMND);
    	System.out.println("Nam sinh cua thanh vien la: " + this.iNamsinh);
    	System.out.println("Tuoi cua thanh vien la: " + this.TinhTuoi());
    }
    
    public double GiamTru(double heso)
    {
        double GiamTruGiaCanhBanThan = 11000000;
        //8% BHXH, 1.5% BHYT, 1% BHTN
        double BaoHiem = this.dLuongCoBan*heso * (0.08 + 0.015 + 0.01);
        double GiamTru = GiamTruGiaCanhBanThan + BaoHiem;
        return GiamTru;
    }

    public int XacDinhBacThue(double heso)
    {
        double ThuNhapTinhThue = this.dLuongCoBan * heso - this.GiamTru(heso);
        if (ThuNhapTinhThue <= 0)
            return Bac.Bac0.ordinal();

        if (ThuNhapTinhThue <= 500  )
            return Bac.Bac1.ordinal();
        else
        {
            if (ThuNhapTinhThue <= 10000000)
            {
                return Bac.Bac2.ordinal();
            }
            else
            {
                if (ThuNhapTinhThue <= 18000000)
                {
                    return Bac.Bac3.ordinal();
                }
                else
                {
                    if (ThuNhapTinhThue <= 32000000)
                    {
                        return Bac.Bac4.ordinal();
                    }
                    else
                    {
                        if (ThuNhapTinhThue <= 52000000)
                        {
                            return Bac.Bac5.ordinal();
                        }
                        else
                        {
                            if (ThuNhapTinhThue <= 80000000)
                            {
                                return Bac.Bac6.ordinal();
                            }
                            else
                                return Bac.Bac7.ordinal();
                        }
                    }
                }
            }
        }
    }

    public double TinhThue(double heso)
    {
        double ThuNhapTinhThue = this.dLuongCoBan * heso - this.GiamTru(heso);
        int Bac = XacDinhBacThue(heso);
        double SoThuePhaiNop = 0;
        switch (Bac)
        {
            case 0:
                {
                    return 0;
                }
            case 1:
                {
                    SoThuePhaiNop = ThuNhapTinhThue * 0.05;
                    break;
                }
            case 2:
                {
                    SoThuePhaiNop = (ThuNhapTinhThue * 0.1) - 250000;
                    break;
                }
            case 3:
                {
                    SoThuePhaiNop = (ThuNhapTinhThue * 0.15) - 750000;
                    break;
                }
            case 4:
                {
                    SoThuePhaiNop = (ThuNhapTinhThue * 0.2) - 1650000;
                    break;
                }
            case 5:
                {
                    SoThuePhaiNop = (ThuNhapTinhThue * 0.25) - 3250000;
                    break;
                }
            case 6:
                {
                    SoThuePhaiNop = (ThuNhapTinhThue * 0.3) - 5850000;
                    break;
                }
            default:
                {
                    SoThuePhaiNop = (ThuNhapTinhThue * 0.35) - 9850000;
                    break;
                }
        }
        return SoThuePhaiNop;
    }

    public int TinhTuoi()
    {
        return 2020 - this.iNamsinh;
    }
    
	@SuppressWarnings("deprecation")
	public int ThoiGianHopDongConLai()
    {
    	DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        Date date1 = null;
        Date date2 = null;
        int temp = 0;
        try {
        	//String startDate = simpleDateFormat.format(this.dNgayGiaNhap);
        	String endDate = simpleDateFormat.format(currentDate);
        	
        	date1 = simpleDateFormat.parse(this.dNgayGiaNhap);
        	date2 = simpleDateFormat.parse(endDate);
        	
			temp = date2.getDate() - date1.getDate();
        	//return temp;
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	//return (Integer) null;
        }
        return temp;
    }
    
	
}
