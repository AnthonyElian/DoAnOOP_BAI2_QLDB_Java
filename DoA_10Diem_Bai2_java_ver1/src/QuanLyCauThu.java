import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class QuanLyCauThu implements Quanly{

	Scanner input = new Scanner(System.in);
	
	private List<CauThu> lDsCauThu;
	
	public List<CauThu> getlDsCauThu()
	{
		return this.lDsCauThu;
	}
	
	public void setlDsCauThu(List<CauThu> lDsCauThu)
	{
		this.lDsCauThu = lDsCauThu;
	}
	
	public QuanLyCauThu() {
		// TODO Auto-generated constructor stub
		this.lDsCauThu = new ArrayList<CauThu>();
	}

	public QuanLyCauThu(List<CauThu> lDsCauThu)
	{
		this.lDsCauThu = lDsCauThu;
	}
	
	public void Nhap()
    {
        System.out.print("Moi nhap so luong cau thu trong doi bong: ");
        int cauthu = input.nextInt();
        for (int i = 0; i < cauthu; i++)
        {
            CauThu a = new CauThu();
            try {
				a.Nhap();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            this.lDsCauThu.add(a);
        }
    }
	
	public void Xuat()
    {
		System.out.println("So luong cau thu trong doi bong la: " + this.lDsCauThu.size());
        for(var item : this.lDsCauThu)
        {
        	item.Xuat();
        }
    }

	public void Sort()
    {
		System.out.println("\t\t\t************************MENU************************\t\t\t");
		System.out.println("\t\t\t***              1. Ho ten                       ***\t\t\t");
		System.out.println("\t\t\t***              2. Tuoi                         ***\t\t\t");
		System.out.println("\t\t\t***              3. Ngay gia nhap                ***\t\t\t");
		System.out.println("\t\t\t***              4. Thoi han hop dong con lai    ***\t\t\t");
		System.out.println("\t\t\t***              5. So ao                        ***\t\t\t");
		System.out.println("\t\t\t***              6. TT the luc                   ***\t\t\t");
		System.out.println("\t\t\t***              7. TT Suc Khoe                  ***\t\t\t");
		System.out.println("\t\t\t****************************************************\t\t\t");
		System.out.print("Moi nhap lua chon cua ba => Your choice: ");
        int choice = input.nextInt();
        switch(choice)
        {
            case 1:
            {
                Collections.sort(this.lDsCauThu, new Comparator<CauThu>()
                {
                	public int compare(CauThu a, CauThu b) {
                		return a.sHoTen.compareTo(b.sHoTen);}
                });
                break;
            }
            case 2:
            {
            	for (int i=0; i<this.lDsCauThu.size() - 1; i++)
            	{
            		if (this.lDsCauThu.get(i).TinhTuoi() > this.lDsCauThu.get(i+1).TinhTuoi())
            		{
            			CauThu temp = new CauThu();
            			temp = this.lDsCauThu.get(i);
            			this.lDsCauThu.set(i, this.lDsCauThu.get(i+1));
            			this.lDsCauThu.set(i+1, temp);
            		}
            	}
            	 break;
            }
            case 3:
            {
                //lDsCauThu.Sort((x, y) => x.dNgayGiaNhap.CompareTo(y.dNgayGiaNhap));
            	for (int i=0;i<this.lDsCauThu.size()-1; i++)
            	{
            		if (this.lDsCauThu.get(i).iThoiGianHopDong > this.lDsCauThu.get(i+1).iThoiGianHopDong)
            		{
            			CauThu temp = new CauThu();
            			temp = this.lDsCauThu.get(i);
            			this.lDsCauThu.set(i, this.lDsCauThu.get(i+1));
            			this.lDsCauThu.set(i+1, temp);
            		}
            	}
            	break;
            }
            case 4:
            {
                //lDsCauThu.Sort((x, y) => x.ThoiGianHopDongConLai().CompareTo(y.ThoiGianHopDongConLai()));
            	//CauThu a = new CauThu();
            	for (int i=0;i<this.lDsCauThu.size()-1; i++)
            	{
            		if (this.lDsCauThu.get(i).ThoiGianHopDongConLai() > this.lDsCauThu.get(i+1).ThoiGianHopDongConLai())
            		{
            			CauThu temp = new CauThu();
            			temp = this.lDsCauThu.get(i);
            			this.lDsCauThu.set(i, this.lDsCauThu.get(i+1));
            			this.lDsCauThu.set(i+1, temp);
            		}
            	}
            	break;
            }
            case 5:
            {
            	for (int i=0; i<this.lDsCauThu.size() - 1; i++)
            	{
            		if (this.lDsCauThu.get(i).getiSoAo() > this.lDsCauThu.get(i+1).getiSoAo())
            		{
            			CauThu temp = new CauThu();
            			temp = this.lDsCauThu.get(i);
            			this.lDsCauThu.set(i, this.lDsCauThu.get(i+1));
            			this.lDsCauThu.set(i+1, temp);
            		}
            	}
            	break;
            }
            case 6:
            {
            	for (int i=0; i<this.lDsCauThu.size() - 1; i++)
            	{
            		if (this.lDsCauThu.get(i).getiTinhTrangTheLuc() > this.lDsCauThu.get(i+1).getiTinhTrangTheLuc())
            		{
            			CauThu temp = new CauThu();
            			temp = this.lDsCauThu.get(i);
            			this.lDsCauThu.set(i, this.lDsCauThu.get(i+1));
            			this.lDsCauThu.set(i+1, temp);
            		}
            	}
            	break;
            }
            case 7:
            {
            	for (int i=0; i<this.lDsCauThu.size() - 1; i++)
            	{
            		if (this.lDsCauThu.get(i).getiTinhTrangSucKhoe() > this.lDsCauThu.get(i+1).getiTinhTrangSucKhoe())
            		{
            			CauThu temp = new CauThu();
            			temp = this.lDsCauThu.get(i);
            			this.lDsCauThu.set(i, this.lDsCauThu.get(i+1));
            			this.lDsCauThu.set(i+1, temp);
            		}
            	}
            	break;
            }
            case 8:
            {
                break;
            }
            default:
            {
                    System.out.println("Nhap sai, moi nhap lai!!  ");
                    break;
            }
        }
  	}
        
    public List<CauThu> Loc()
    {
        List<CauThu> temp = new ArrayList<CauThu>();
        System.out.println("\t\t\t************************MENU************************\t\t\t");
        System.out.println("\t\t\t***       1. Danh sach cau thu thuan chan trai   ***\t\t\t");
        System.out.println("\t\t\t***       2. Danh sach cau thu thuan chan phai   ***\t\t\t");
        System.out.println("\t\t\t***       3. Danh sach cau thu co the da tien dao***\t\t\t");
        System.out.println("\t\t\t***       4. Danh sach cau thu co the da tien ve ***\t\t\t");
        System.out.println("\t\t\t***       5. Danh sach cau thu co the da hau ve  ***\t\t\t");
        System.out.println("\t\t\t***       6. Thoat                               ***\t\t\t");
        System.out.println("\t\t\t****************************************************\t\t\t");
        System.out.print("Moi nhap lua chon cua ba => Your choice: ");
        int choice = input.nextInt();
        switch (choice)
        {
            case 1:
            {
            	String b = "trai";
                for (var item : this.lDsCauThu)
                    if (item.getsChanThuan().toLowerCase().equals(b))
                        temp.add(item);
                break;
            }
            case 2:
            {
            	String b = "phai";
                for (var item : this.lDsCauThu)
                    if (item.getsChanThuan().toLowerCase().equals(b))
                        temp.add(item);
                break;
            }
            case 3:
            {
            	String b = "tiendao";
                for (var item : this.lDsCauThu)
                    if (item.getsViTriDaChinh().toLowerCase().equals(b))
                        temp.add(item);
                break;
            }
            case 4:
            {
            	String b = "tienve";
                for (var item : this.lDsCauThu)
                    if (item.getsViTriDaChinh().toLowerCase().equals(b))
                        temp.add(item);
                break;
            }
            case 5:
            {
            	String b = "hauve";
                for (var item : this.lDsCauThu)
                    if (item.getsViTriDaChinh().toLowerCase().equals(b))
                            temp.add(item);
                break;
            }
            case 6:
            {
                break;
            }
            default:
            {
            	System.out.println("Nhap sai, moi nhap lai!!  ");
                break;
            }             
        }
        return temp;
    }
    
    public CauThu Search()
    {
    	System.out.println("\t\t\t************************MENU************************\t\t\t");
    	System.out.println("\t\t\t***            1. Ho ten                         ***\t\t\t");
    	System.out.println("\t\t\t***            2. So ao                          ***\t\t\t");
    	System.out.println("\t\t\t***            3. Thoat                          ***\t\t\t");
    	System.out.println("\t\t\t****************************************************\t\t\t");
    	System.out.print("Moi nhap lua chon cua ba => Your choice: ");
        int choice = input.nextInt();
        CauThu temp = null;
        switch (choice)
        {
            case 1:
                {
                	InputStreamReader ips=new InputStreamReader(System.in);
                    BufferedReader br=new BufferedReader(ips);
                	System.out.print("Nhap ten cau thu tim kiem : ");
                    String key;
					try {
						key = br.readLine();
						for (int i=0; i<this.lDsCauThu.size(); i++)
	                    {
	                    	if (this.lDsCauThu.get(i).sHoTen.equals(key))
	                    		return this.lDsCauThu.get(i);
	                    }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}                 
                    return null;
                }
            case 2:
                {
                	System.out.print("Nhap so ao cau thu tim kiem : ");
                    int key = input.nextInt();
                    for (int i=0; i<this.lDsCauThu.size(); i++)
                    {
                    	if (this.lDsCauThu.get(i).getiSoAo() == key)
                    		return this.lDsCauThu.get(i);
                    }
                    return null;
                }
            case 3:
                {
                    return null;
                }
            default:
                {
                	System.out.println("Nhap sai, moi nhap lai!! ");
                    return temp;
                }
        }          
    }
    
    public void XemtinhTrangtheLuc()
    {
        for (var item : this.lDsCauThu)
        {
        	System.out.println("Cau thu " + item.sHoTen + " chi so TL la: " + item.getiTinhTrangTheLuc());
        }    
    }
    
    public void XemtinhTrangSucKhoe()
    {
        for (var item : this.lDsCauThu)
        {
        	System.out.println("Cau thu " + item.sHoTen + " chi so SK la: " + item.getiTinhTrangSucKhoe());
        }    
    }
    
    public CauThu CauThuCoTheLucTotNhat()
    {
        if (this.lDsCauThu.size() == 0)
            return null;
        else
        {
            CauThu temp = lDsCauThu.get(0);
            for (var item : this.lDsCauThu)
            {
                if (CauThu.operatorLon(item, temp))
                    temp = item;
            }
            return temp;
        }           
    }
    
    public CauThu CauThuCoTheSucKhoeYeuNhat()
    {
        if (this.lDsCauThu.size() == 0)
            return null;
        else
        {
            CauThu temp = this.lDsCauThu.get(0);
            for (var item : this.lDsCauThu)
            {
                if (CauThu.operatorBe(item, temp))
                    temp = item;
            }
            return temp;
        }
    }
    
    public double TongLuongToanCauThu()
    {
        double temp = 0;
        for (var item : this.lDsCauThu)
        {
            temp = CauThu.operatorTong(item, temp);
        }
        return temp;
    }
    
    public void xoaCT()
    {
        System.out.println("So luong cau thu hien tai la: " + this.lDsCauThu.size());
        System.out.print("Ban muon xoa bao nhieu Cau thu: ");
        int n = input.nextInt();
        for (int i = 0; i < n; i++)
        {
        	System.out.println("Danh sach cau thu: ");
            for (var item : this.lDsCauThu)
            {
            	System.out.println("Ten Cau Thu: " + item.sHoTen);
            }
            System.out.print("Nhap thu tu Cau thu muon xoa: ");
            int x = input.nextInt();
            this.xoa1CT(x);
        }
    }

    public void xoa1CT(int x)
    {
        this.lDsCauThu.remove(x);
    }
}
