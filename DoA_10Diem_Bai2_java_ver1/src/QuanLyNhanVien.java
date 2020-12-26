import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuanLyNhanVien {
	Scanner input = new Scanner(System.in);
	
	private List<CaNhan> lcaNhan;
    private List<BacSi> lbacsi;
    private List<HLVChienThuat> lHLVCT;
    private List<HLVTheLuc> lHLVTL;
    private List<NVBaoVe> lNVBV;
    private List<NVVeSinh> lNVVS;
    
    public List<CaNhan> getlcaNhan()
    {
    	return this.lcaNhan;
    }
    
    public void setlcaNhan(List<CaNhan> lcaNhan)
    {
    	this.lcaNhan = lcaNhan;
    }
    
    public List<BacSi> getlbacsi()
    {
    	return this.lbacsi;
    }
    
    public void setlbacsi(List<BacSi> lbacsi)
    {
    	this.lbacsi = lbacsi;
    }
    
    public List<HLVChienThuat> getlHLVCT()
    {
    	return this.lHLVCT;
    }
    
    public void setlHLVCT(List<HLVChienThuat> lHLVCT)
    {
    	this.lHLVCT = lHLVCT;
    }
    
    public List<HLVTheLuc> getlHLVTL()
    {
    	return this.lHLVTL;
    }
    
    public void setlHLVTL(List<HLVTheLuc> lHLVTL)
    {
    	this.lHLVTL = lHLVTL;
    }
    
    public List<NVBaoVe> getlNVBV()
    {
    	return this.lNVBV;
    }
    
    public void setlNVBV(List<NVBaoVe> lNVBV)
    {
    	this.lNVBV = lNVBV;
    }
    
    public List<NVVeSinh> getlNVVS()
    {
    	return this.lNVVS;
    }
    
    public void setlNVVS(List<NVVeSinh> lNVVS)
    {
    	this.lNVVS = lNVVS;
    }
	
	public QuanLyNhanVien() {
		// TODO Auto-generated constructor stub
		this.lbacsi = new ArrayList<BacSi>();
        this.lcaNhan = new ArrayList<CaNhan>();
        this.lHLVCT = new ArrayList<HLVChienThuat>();
        this.lHLVTL = new ArrayList<HLVTheLuc>();
        this.lNVBV = new ArrayList<NVBaoVe>();
        this.lNVVS = new ArrayList<NVVeSinh>();
	}

	public QuanLyNhanVien(List<CaNhan> lcaNhans, List<BacSi> lbacsi, List<HLVChienThuat> lHLVCT, List<HLVTheLuc> lHLVTL, List<NVBaoVe> lNVBV, List<NVVeSinh> lNVVS)
    {
        this.lcaNhan = lcaNhans;
        this.lbacsi = lbacsi;
        this.lHLVCT = lHLVCT;
        this.lHLVTL = lHLVTL;
        this.lNVBV = lNVBV;
        this.lNVVS = lNVVS;
    }
	
	public double TinhLuongToanBoNV()
    {
        double temp = 0;
        for(var item : this.lbacsi)
            temp = BacSi.operatorTong(item, temp);
        for (var item : this.lHLVCT)
            temp = HLVChienThuat.operatorTong(item, temp);
        for (var item : this.lHLVTL)
            temp = HLVTheLuc.operatorTong(item, temp);
        for (var item :this.lNVBV)
        {
            temp = NVBaoVe.operatorTong(item, temp);
        }
        for (var item : this.lNVVS)
        {
            temp = NVVeSinh.operatorTong(item, temp);
        }
        return temp;
    }
	
	public void Nhap() throws IOException
    {
        System.out.print("Moi nhap so luong Bac Si: ");
        int bs = input.nextInt();
        for (int i = 0; i < bs; i++)
        {
            BacSi a = new BacSi();
            a.Nhap();
            this.lbacsi.add(a);
            this.lcaNhan.add(a);
        }

        System.out.print("Moi nhap so luong HLV Chien Thuat: ");
        int hlvct = input.nextInt();
        for (int i = 0; i < hlvct; i++)
        {
            HLVChienThuat a = new HLVChienThuat();
            a.Nhap();
            this.lHLVCT.add(a);
            this.lcaNhan.add(a);
        }      

        System.out.print("Moi nhap so luong HLV The Luc: ");
        int hlvtl = input.nextInt();
        for (int i = 0; i < hlvtl; i++)
        {
            HLVTheLuc a = new HLVTheLuc();
            a.Nhap();
            this.lcaNhan.add(a);
            this.lHLVTL.add(a);
        }

        System.out.print("Moi nhap so luong Nhan Vien Bao Ve: ");
        int nvbv = input.nextInt();
        for (int i = 0; i < nvbv; i++)
        {
            NVBaoVe a = new NVBaoVe();
            a.Nhap();
            this.lNVBV.add(a);
            this.lcaNhan.add(a);
        }

        System.out.print("Moi nhap so luong Nhan Vien Ve Sinh: ");
        int nvvs = input.nextInt();
        for (int i = 0; i < nvvs; i++)
        {
            NVVeSinh a = new NVVeSinh();
            a.Nhap();
            this.lNVVS.add(a);
            this.lcaNhan.add(a);
        }
    }

	public void SapxepTheoLuong()
    {
        for (int i=0; i<this.lcaNhan.size() - 1; i++)
        {
        	if (this.lcaNhan.get(i).TinhLuong() > this.lcaNhan.get(i+1).TinhLuong())
    		{
    			CaNhan temp;
    			temp = this.lcaNhan.get(i);
    			this.lcaNhan.set(i, this.lcaNhan.get(i+1));
    			this.lcaNhan.set(i+1, temp);
    		}
        }
    }

	public void XuatDsBacSi()
    {
        if (this.lbacsi.size() == 0)
        	System.out.println("Khong co Bac Si nao!");
        else
            for (var item : this.lbacsi)
            	System.out.println("Ten: " + item.sHoTen + " Chuc vu: " + item.sNghe);
    }
	
	public BacSi chonBacsi()
    {
        XuatDsBacSi();
        if(this.lbacsi.size() != 0)
        {
        	System.out.print("Ban muon chon bac si so may: ");
            int key = input.nextInt();
            return this.lbacsi.get(key);
        }
        return null;
    }
	
	public void XuatDsHLVTL()
    {
        if (this.lHLVTL.size() == 0)
        	System.out.println("Khong co HLV the luc nao!");
        else
            for (var item : this.lHLVTL)
            	System.out.println("Ten: " + item.sHoTen + " Chuc vu: " + item.sNghe);
    }
	
	public HLVTheLuc chonHLVTL()
    {
        this.XuatDsHLVTL();
        System.out.print("Ban muon chon HLV the luc so may: ");
        int key = input.nextInt();
        return this.lHLVTL.get(key);
    }
	
	public HLVChienThuat chonHLVCT()
	{
		this.XuatDsHLVCT();
		System.out.print("Ban muon chon HLC chien thuat so may: ");
		int key = input.nextInt();
		return this.lHLVCT.get(key);
	}
	
	public void XuatDsHLVCT()
    {
        if (this.lHLVCT.size() == 0)
        	System.out.println("Khong co HLV chien thuat nao!");
        else
            for (var item : this.lHLVCT)
            	System.out.println("Ten: " + item.sHoTen + " Chuc vu: " + item.sNghe);
    }
	
	public void XuatDsNVBV()
    {
        if (this.lHLVTL.size() == 0)
        	System.out.println("Khong co nhan vien bao ve nao!");
        else
            for (var item : this.lNVBV)
            {
        		System.out.println("Ten: " + item.sHoTen + "Chuc vu: "  + item.sNghe);
            }
    }
	
	public void XuatDsNVVS()
    {
        if (this.lHLVTL.size() == 0)
        	System.out.println("Khong co nhan vien ve sinh nao!");
        else
            for (var item : this.lNVVS)
            {
        		System.out.println("Ten: " + item.sHoTen + " Chuc vu: " + item.sNghe);
            }
    }
	
	public void XuatDsNhanVien()
    {
        if (this.lHLVTL.size() == 0)
        	System.out.println("Khong co nhan vien nao!");
        else
            for (var item : this.lcaNhan)
            	System.out.println("Ten: " + item.sHoTen + " Chuc vu: " + item.sNghe);
    }
	
	public CaNhan TimkiemNVtheoTen() throws IOException
    { 
		InputStreamReader ips=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ips);
		System.out.print("Nhap ten Nhan Vien muon tim kiem : ");
        String key = br.readLine();
        for (int i=0; i<this.lcaNhan.size(); i++)
        {
        	if (key.toLowerCase() == this.lcaNhan.get(i).sHoTen.toLowerCase())
        		this.lcaNhan.get(i).Xuat();
        }
		return null;
    }
	
	public List<CaNhan> LocTheoLuongLon()
    {
		System.out.print("Nhap Luong (x) de co danh sach cau thu luong > x: ");
        int x = input.nextInt();

        List<CaNhan> temp = new ArrayList<CaNhan>();
        for (var item : this.lcaNhan)
            if (item.dLuongCoBan > x)
                temp.add(item);
        return temp;
    }
	
	public List<CaNhan> LocTheoLuongBe()
    {
		System.out.print("Nhap Luong (x) de co danh sach cau thu luong < x: ");
        int x = input.nextInt();
        
        List<CaNhan> temp = new ArrayList<CaNhan>();
        for (var item : this.lcaNhan)
            if(item.dLuongCoBan < x)
                temp.add(item);
        return temp;
    }
	
	public void XemcaNhan()
    {
        this.XuatDsNhanVien();
        System.out.print("Ban Muon Xem Nhan Vien thu may: !");
        int x = input.nextInt();
        if(this.lcaNhan.get(x).sNghe == "bacsi")
        {
            for (int i=0; i<this.lcaNhan.size(); i++)
            {
            	if (this.lbacsi.get(i).sHoTen.toLowerCase() == this.lcaNhan.get(i).sHoTen.toLowerCase())
            		this.lbacsi.get(i).Xuat();
            }
        }
        else if (this.lcaNhan.get(x).sNghe == "HLVTL")
        {
        	for (int i=0; i<this.lcaNhan.size(); i++)
            {
            	if (this.lHLVTL.get(i).sHoTen.toLowerCase() == this.lcaNhan.get(i).sHoTen.toLowerCase())
            		this.lHLVTL.get(i).Xuat();
            }
        }
        else if(this.lcaNhan.get(x).sNghe == "HLVCT")
        {
        	for (int i=0; i<this.lcaNhan.size(); i++)
            {
            	if (this.lHLVCT.get(i).sHoTen.toLowerCase() == this.lcaNhan.get(i).sHoTen.toLowerCase())
            		this.lHLVCT.get(i).Xuat();
            }
        }
        else if(this.lcaNhan.get(x).sNghe == "NVBaoVe")
        {
        	for (int i=0; i<this.lcaNhan.size(); i++)
            {
            	if (this.lNVBV.get(i).sHoTen.toLowerCase() == this.lcaNhan.get(i).sHoTen.toLowerCase())
            		this.lNVBV.get(i).Xuat();
            }
        }
        else if (this.lcaNhan.get(x).sNghe == "NVVeSinh")
        {
        	for (int i=0; i<this.lcaNhan.size(); i++)
            {
            	if (this.lNVVS.get(i).sHoTen.toLowerCase() == this.lcaNhan.get(i).sHoTen.toLowerCase())
            		this.lNVVS.get(i).Xuat();
            }
        }
    }
}
