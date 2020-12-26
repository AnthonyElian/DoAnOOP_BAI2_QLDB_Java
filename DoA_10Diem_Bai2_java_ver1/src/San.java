import java.util.Scanner;

public class San {
	Scanner input = new Scanner(System.in);
	
	private String sTenSan;
    private int iSoLuongKhanGia;
    private double dGiaVe;
    
    public String getsTenSan()
    {
    	return this.sTenSan;
    }
    
    public void setsTenSan(String tensan)
    {
    	this.sTenSan = tensan;
    }
    
    public int getiSoLuongKhanGia()
    {
    	return this.iSoLuongKhanGia;
    }
    
    public void setiSoLuongKhanGia(int soluong)
    {
    	this.iSoLuongKhanGia = soluong;
    }
    
    public double getdGiaVe()
    {
    	return this.dGiaVe;
    }
    
    public void setdGiaVe(double gia)
    {
    	this.dGiaVe = gia;
    }
    
	public San() {
		// TODO Auto-generated constructor stub
	}

	public San(int soluong, double GiaVe)
    {
        this.iSoLuongKhanGia = soluong;
        this.dGiaVe = GiaVe;
    }
	
	public void Nhap() 
    {
        System.out.print("Moi nhap Ten San: ");
        this.sTenSan = input.nextLine();

        System.out.print("Moi nhap Gia ve vao san: ");
        this.dGiaVe = input.nextDouble();

        System.out.print("Moi nhap So Luong Khan Gia ma San chua duoc toi da: ");
        this.iSoLuongKhanGia = input.nextInt();
    }
	
	public void Xuat()
    {
		System.out.println("Ten San Van Dong cua Doi Bong la: " + this.sTenSan);
		System.out.println("Gia ve vao san la: " + this.dGiaVe);
		System.out.println("So luong Khan Gia khan dai co the chua duoc la: " + this.iSoLuongKhanGia);
    }
}
