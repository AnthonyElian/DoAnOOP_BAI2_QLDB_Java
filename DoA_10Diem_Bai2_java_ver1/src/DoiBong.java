import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoiBong {

	Scanner input = new Scanner(System.in);
	
	 private String sTenDoiBong;
	 private String sTenNhaTaiTro;
	 //private San sanDoiBong;
	 private QuanLyCauThu lCauThu;
	 private QuanLyNhanVien lNhanvien;
	 public List<CaNhan> expired;
 	 
	 public String getsTenDoiBong()
	 {
		 return this.sTenDoiBong;
	 }
	 
	 public void setsTenDoiBong(String tendoibong)
	 {
		 this.sTenDoiBong = tendoibong;
	 }
	 
	 public String getsTenNhaTaiTro()
	 {
		 return this.sTenNhaTaiTro;
	 }
	 
	 public void setsTenNhaTaiTro(String tentaitro)
	 {
		 this.sTenNhaTaiTro = tentaitro;
	 }
	 
	 public QuanLyCauThu getlCauThu()
	 {
		 return this.lCauThu;
	 }
	 
	 public void setlCauThu(QuanLyCauThu lCauThu)
	 {
		 this.lCauThu = lCauThu;
	 }
	 
	 public QuanLyNhanVien getlNhanVien()
	 {
		 return this.lNhanvien;
	 }
     
	 public void setslNhanVien(QuanLyNhanVien lNhanVien)
	 {
		 this.lNhanvien = lNhanVien;
	 }
	 
	public DoiBong() {
		// TODO Auto-generated constructor stub
		this.lCauThu = new QuanLyCauThu();
        this.lNhanvien = new QuanLyNhanVien();
        this.expired = new ArrayList<CaNhan>();
	}

	 public DoiBong(String tendoibong, String nhataitro)
     {
         this.sTenNhaTaiTro = nhataitro;
         this.sTenDoiBong = tendoibong;
     }

	 public void Xuat()
     {
         System.out.println("Ten Doi Bong la: " + this.sTenDoiBong);
         System.out.println("Ten Nha Tai Tro cua Doi Bong la: " + this.sTenNhaTaiTro);
     }

     public void Nhap()
     {
    	 System.out.print("Moi nhap Ten Doi Bong: ");
         this.sTenDoiBong = input.nextLine();
         System.out.print("Ten Nha Tai Tro cua Doi Bong: ");
         this.sTenNhaTaiTro = input.nextLine();
     }
     
     public void DanhSachHetHanHopDong()
     {
    	 for (int i = 0; i < this.lCauThu.getlDsCauThu().size(); i++)
    	 {
    		 if (this.lCauThu.getlDsCauThu().get(i).ThoiGianHopDongConLai() <= 0)
    		 {
    			 this.expired.add(this.lCauThu.getlDsCauThu().get(i));
    		 }
    	 }
    	 for (int i = 0; i < this.lNhanvien.getlcaNhan().size(); i++)
    	 {
    		 if (this.lNhanvien.getlcaNhan().get(i).ThoiGianHopDongConLai() <= 0)
    		 {
    			 this.expired.add(this.lNhanvien.getlcaNhan().get(i));
    		 }
    	 }
     }
     
     public void ThaoTacHopDong()
     {
    	 this.DanhSachHetHanHopDong();
    	 if (this.expired.size() <= 0)
    	 {
    		 System.out.println("Khong co nhan vien nao het han hop dong !!");
    	 }
    	 else
    	 {
    		 int flag = 1;
    		 while (flag == 1)
    		 {
    			 if (this.expired.size() == 0)
    			 {
    				 flag =0;
    			 }
    			 else
    			 {
    				 int dem =0;
        			 System.out.println("Danh sach hen han hop dong la: ");
        			 for (var item : this.expired)
        			 {
        				 System.out.println("STT: " + dem++ + " Ho ten: " + item.sHoTen + " Luong: " + item.TinhLuong());
        			 }
        			 System.out.print("1_Gia Han || 2_Kick => Your choice: ");
        			 int n = input.nextInt();
        			 switch(n)
        			 {
        			 case 1:
        			 {
        				 System.out.print("Ban muon gia han nhan vien thu may: ");
                         int x = input.nextInt();
                         if (this.expired.get(x).sNghe == "CauThu")
                         {
                             for (int i = 0; i < this.lCauThu.getlDsCauThu().size(); i++)
                             {
                                 if (this.lCauThu.getlDsCauThu().get(i).sHoTen == this.expired.get(x).sHoTen)
                                 {
                                     System.out.print("Gia han hop dong bao nhieu nam: ");
                                     this.lCauThu.getlDsCauThu().get(i).iThoiGianHopDong = input.nextInt();
                                     this.lCauThu.getlDsCauThu().get(i).dNgayGiaNhap = "16/01/2021";
                                     this.expired.remove(x);
                                     break;
                                 }
                             }
                         }
                         else
                         {
                             int temp;
                             for (int i = 0; i < this.lNhanvien.getlcaNhan().size(); i++)
                             {
                                 if (this.lNhanvien.getlcaNhan().get(i).sHoTen == this.expired.get(i).sHoTen)
                                 {
                                     System.out.print("Gia han hop dong bao nhieu nam?: ");
                                     temp = input.nextInt();
                                     this.lNhanvien.getlcaNhan().get(i).iThoiGianHopDong = temp;
                                     this.lNhanvien.getlcaNhan().get(i).dNgayGiaNhap = "16/01/2021";
                                     if (this.expired.get(x).sNghe == "bacsi")
                                     {
                                         for (int j = 0; j < this.lNhanvien.getlbacsi().size(); j++)
                                         {
                                             if (this.lNhanvien.getlbacsi().get(i).sHoTen == this.expired.get(x).sHoTen)
                                             {
                                                 this.lNhanvien.getlbacsi().get(i).iThoiGianHopDong = temp;
                                                 this.lNhanvien.getlbacsi().get(i).dNgayGiaNhap = "16/01/2021";
                                                 break;
                                             }
                                         }
                                     }
                                     else if (this.expired.get(x).sNghe == "HLVCT")
                                     {
                                         for (int j = 0; j < this.lNhanvien.getlHLVCT().size(); j++)
                                         {
                                             if (this.lNhanvien.getlHLVCT().get(i).sHoTen == this.expired.get(x).sHoTen)
                                             {
                                                 this.lNhanvien.getlHLVCT().get(i).iThoiGianHopDong = temp;
                                                 this.lNhanvien.getlHLVCT().get(i).dNgayGiaNhap = "16/01/2001";
                                             }
                                         }
                                     }
                                     else if (this.expired.get(x).sNghe == "HLVTL")
                                     {
                                         for (int j = 0; j < this.lNhanvien.getlHLVTL().size(); j++)
                                         {
                                             if (this.lNhanvien.getlHLVTL().get(i).sHoTen == this.expired.get(x).sHoTen)
                                             {
                                                 this.lNhanvien.getlHLVTL().get(i).iThoiGianHopDong = temp;
                                                 this.lNhanvien.getlHLVTL().get(i).dNgayGiaNhap = "16/01/2021";
                                             }
                                         }
                                     }
                                     else if (this.expired.get(x).sNghe == "NVVeSinh")
                                     {
                                         for (int j = 0; j < this.lNhanvien.getlNVVS().size(); j++)
                                         {
                                             if (this.lNhanvien.getlNVVS().get(i).sHoTen == this.expired.get(x).sHoTen)
                                             {
                                                 this.lNhanvien.getlNVVS().get(i).iThoiGianHopDong = temp;
                                                 this.lNhanvien.getlNVVS().get(i).dNgayGiaNhap = "16/01/2021";
                                             }
                                         }
                                     }
                                     else if (this.expired.get(x).sNghe == "NVBaoVe")
                                     {
                                         for (int j = 0; j < this.lNhanvien.getlNVBV().size(); j++)
                                         {
                                             if (this.lNhanvien.getlNVBV().get(i).sHoTen == this.expired.get(x).sHoTen)
                                             {
                                                 this.lNhanvien.getlNVBV().get(i).iThoiGianHopDong = temp;
                                                 this.lNhanvien.getlNVBV().get(i).dNgayGiaNhap = "16/01/2021";
                                             } 
                                         }
                                     }
                                     this.expired.remove(x);
                                     break;
                                 }
                             }
                         }
                         break;
        			 }
        			 case 2:
        			 {
        				 System.out.print("Ban muon kick nhan vien thu may: ");
                         int x = input.nextInt();
                         if (this.expired.get(x).sNghe != "CauThu")
                         {
                             int temp = 0;
                             for (int i = 0; i < this.lNhanvien.getlcaNhan().size(); i++)
                             {
                                 if (this.lNhanvien.getlcaNhan().get(i).sHoTen == this.expired.get(x).sHoTen)
                                 {
                                     temp = i;
                                     break;
                                 }
                             }
                             this.lNhanvien.xoa1NV(temp);
                             this.expired.remove(x);
                         }
                         else
                         {
                             int temp = 0;
                             for (int i = 0; i < this.lCauThu.getlDsCauThu().size(); i++)
                             {
                                 if (this.lCauThu.getlDsCauThu().get(i).sHoTen == this.expired.get(x).sHoTen)
                                 {
                                     temp = i;
                                     break;
                                 }
                             }
                             this.lCauThu.xoa1CT(temp);
                             this.expired.remove(x);
                         }
                         break;
        			 }
        			 }
        			 System.out.print("1_De tiep tuc !! => Your choice: ");
                     flag = input.nextInt();
    			 }
    		 }
    	 }
     }
	 
     public void MenuQLCT() throws IOException
     {
         int flag = 1;
         while (flag == 1)
         {
        	 System.out.println("\t\t\t************************MENU************************\t\t\t");
        	 System.out.println("\t\t\t***      0. Nhap cau thu                         ***\t\t\t");
        	 System.out.println("\t\t\t***      1. Sap xep Cau Thu                      ***\t\t\t");
        	 System.out.println("\t\t\t***      2. Loc Cau Thu                          ***\t\t\t");
        	 System.out.println("\t\t\t***      3. Tim Kiem Cau Thu                     ***\t\t\t");
        	 System.out.println("\t\t\t***      4. Xem Tinh Trang The Luc cua Cau Thu   ***\t\t\t");
        	 System.out.println("\t\t\t***      5. Xem Tinh Trang Suc Khoe cua Cau Thu  ***\t\t\t");
        	 System.out.println("\t\t\t***      6. Cau Thu co The Luc Tot Nhat          ***\t\t\t");
        	 System.out.println("\t\t\t***      7. Cau Thu co Suc Khoe Yeu Nhat         ***\t\t\t");
        	 System.out.println("\t\t\t***      8. Tong Luong Cau Thu                   ***\t\t\t");
        	 System.out.println("\t\t\t***      9. Xoa Cau Thu                          ***\t\t\t");
        	 System.out.println("\t\t\t***     10. Thoat                                ***\t\t\t");
        	 System.out.println("\t\t\t****************************************************\t\t\t");
        	 System.out.print("Moi nhap lua chon cua ban => Your choice: ");
             int choice = input.nextInt();
             switch(choice)
             {
                 case 0:
                     {
                         this.lCauThu.Nhap();;
                         break;
                     }
                 case 1:
                     {
                    	 this.lCauThu.Sort();
                    	 this.lCauThu.Xuat();
                         break;
                     }
                 case 2:
                     {
                    	 List<CauThu> temp = this.lCauThu.Loc();
                         if (temp.size() == 0)
                        	 System.out.println("Khong co Cau Thu nao thoa Dieu kien Loc");
                         else
                         {
                        	 for (var item : temp)
                             {
                                 item.Xuat();
                             }
                         }                 	 
                         //System.out.println("abc~~" + temp.size());
                         break;
                     }
                 case 3:
                     {
                         CauThu temp = this.lCauThu.Search();
                         if (temp == null)
                        	 System.out.println("Khong tim thay cau thu");
                         else
                             temp.Xuat();
                         break;
                     }
                 case 4:
                     {
                         this.lCauThu.XemtinhTrangtheLuc();
                         break;
                     }
                 case 5:
                     {
                         this.lCauThu.XemtinhTrangSucKhoe();
                         break;
                     }
                 case 6:
                     {
                         CauThu temp = this.lCauThu.CauThuCoTheLucTotNhat();
                         if (temp == null)
                        	 System.out.println("Khong tim thay cau thu");
                         else
                             temp.Xuat();
                         break;
                     }
                 case 7:
                     {
                         CauThu temp = this.lCauThu.CauThuCoTheSucKhoeYeuNhat();
                         if (temp == null)
                        	 System.out.println("Khong tim thay cau thu");
                         else
                             temp.Xuat();
                         break;
                     }
                 case 8:
                     {
                    	 System.out.println("Tong luong phai tra cho cac Cau Thu la: " + this.lCauThu.TongLuongToanCauThu());
                         break;
                     }
                 case 9:
                 	{
                 		if (this.lCauThu.getlDsCauThu().size() <= 0)
                 		{
                            System.out.println("Vui long nhap it nhat mot cau thu !! ");
                 		}
                        else
                        {
                            this.lCauThu.xoaCT();
                            System.out.println("Danh sach cau thu sau khi xoa: ");
                            for (var item : this.lCauThu.getlDsCauThu())
                            {
                                System.out.println("Ten cau thu: " + item.sHoTen);
                            }
                        }                         
                        break;
                 	}
                 case 10:
                     {
                         flag = 0;
                         break;
                     }
                 default:
                     {
                    	 System.out.println("Nhap sai, moi nhap lai!!  ");
                         break;
                     }
             }
         }
     }
     
     @SuppressWarnings("null")
	public void MenuQLNV() throws IOException
     {   
         int flag = 1;
         while (flag == 1)
         {
        	 System.out.println("\t\t\t************************MENU************************\t\t\t");
        	 System.out.println("\t\t\t***      0. Nhap NV                              ***\t\t\t");
        	 System.out.println("\t\t\t***      1. Sap xep Nhan Vien theo Luong         ***\t\t\t");
        	 System.out.println("\t\t\t***      2. Loc Nhan Vien theo Luong             ***\t\t\t");
        	 System.out.println("\t\t\t***      3. Xem Danh Sach Bac Si                 ***\t\t\t");
        	 System.out.println("\t\t\t***      4. Xem Danh Sach HLV Chien Thuat        ***\t\t\t");
        	 System.out.println("\t\t\t***      5. Xem Danh Sach HLV The Luc            ***\t\t\t");
        	 System.out.println("\t\t\t***      6. Xem Danh Sach Nhan Vien Bao Ve       ***\t\t\t");
        	 System.out.println("\t\t\t***      7. Xem Danh Sach Nhan Vien Ve Sinh      ***\t\t\t");
        	 System.out.println("\t\t\t***      8. Tong Luong Nhan Vien                 ***\t\t\t");
        	 System.out.println("\t\t\t***      9. Tim kiem Nhan Vien theo Ten          ***\t\t\t");
        	 System.out.println("\t\t\t***     10. Xem Ca Nhan                          ***\t\t\t");
        	 System.out.println("\t\t\t***     11. Xoa Nhan Vien                        ***\t\t\t");
        	 System.out.println("\t\t\t***     12. Thoat                                ***\t\t\t");
        	 System.out.println("\t\t\t****************************************************\t\t\t");
        	 System.out.print("Moi nhap lua chon cua ban => Your choice: ");
             int choice = input.nextInt();
             switch (choice)
             {
                 case 0:
                     {
                         this.lNhanvien.Nhap();
                         break;
                     }
                 case 1:
                     {
                         this.lNhanvien.Sort();
                         this.lNhanvien.Xuat();
                         break;
                     }
                 case 2:
                     {
                         List<CaNhan> temp = this.lNhanvien.Loc();
                         if (temp.size() == 0)
                        	 System.out.println("Khong co nhan vien nao thoa dieu kien Loc");
                         else
                         {
                        	 for (var item : temp)
                             {
                                 item.Xuat();
                                 System.out.println();
                             }
                         }                        
                         break;
                     }
                 case 3:
                     {
                         this.lNhanvien.XuatDsBacSi();
                         break;
                     }
                 case 4:
                     {
                         this.lNhanvien.XuatDsHLVCT();
                         break;
                     }
                 case 5:
                     {
                         this.lNhanvien.XuatDsHLVTL();
                         break;
                     }
                 case 6:
                     {
                         this.lNhanvien.XuatDsNVBV();
                         break;
                     }
                 case 7:
                     {
                         this.lNhanvien.XuatDsNVVS();
                         break;
                     }
                 case 8:
                     {
                    	 System.out.println("Tong luong toan nhan vien la: " + this.lNhanvien.TinhLuongToanBoNV());
                         break;
                     }
                 case 9:
                 	{
                 		CaNhan temp = this.lNhanvien.Search();
                 		if (temp != null)
                 			temp.Xuat();
                 		else
                 			System.out.println("Khong ton tai nhan vien nay!! ");
                 		break;
                 	}
                 case 10:
                 	{
                 		this.lNhanvien.XemcaNhan();
                 		break;
                 	}
                 case 11:
                 {
                	 if (this.lNhanvien.getlcaNhan().size() <= 0)
                         System.out.println("Vui long nhap it nhat mot nhan vien !!");
                     else
                     {
                         this.lNhanvien.xoaNV();
                         for (var item : this.lNhanvien.getlcaNhan())
                         {
                             System.out.println("Ten nhan vien: " + item.sHoTen + " Chuc vu: " + item.sNghe);
                         }
                     }                
                     break;
                 }
                 case 12:
                     {
                         flag = 0;
                         break;
                     }
                 default:
                     {
                    	 System.out.println("Nhap sai, moi nhap lai!! ");
                         break;
                     }
             }
         }
     }
     
     public void MenuHoatDong(San san) throws IOException
     {
    	 List<CauThu> tmp = new ArrayList<CauThu>();
    	 HoatDong.createCauThu(tmp);
         int flag = 1;
         while (flag == 1)
         {
        	 System.out.println("\t\t\t************************MENU************************\t\t\t");
        	 System.out.println("\t\t\t***      1. Kham Suc Khoe Toan Doi               ***\t\t\t");
        	 System.out.println("\t\t\t***      2. Kham Suc Khoe Cau Thu                ***\t\t\t");
        	 System.out.println("\t\t\t***      3. Chon Doi 11 Nguoi                    ***\t\t\t");
        	 System.out.println("\t\t\t***      4. Huan Luyen The Luc Ca Doi            ***\t\t\t");
        	 System.out.println("\t\t\t***      5. Huan Luyen The Luc Cau Thu           ***\t\t\t");
        	 System.out.println("\t\t\t***      6. Da thu                               ***\t\t\t");
        	 System.out.println("\t\t\t***      7. Thao tac hop dong                    ***\t\t\t");
        	 System.out.println("\t\t\t***      8. Chuyen nhuong                        ***\t\t\t");
        	 System.out.println("\t\t\t***      9. Thoat                                ***\t\t\t");
        	 System.out.println("\t\t\t****************************************************\t\t\t");
        	 System.out.print("Moi nhap lua chon cua ban => Your choice: ");
             int choice = input.nextInt();
             switch (choice)
             {
	             case 1:
	             {
	                 BacSi BsKham = this.lNhanvien.chonBacsi();
	                 if (BsKham != null)
	                 {
	                     HoatDong.KhamSucKhoeToanDoi(this.lCauThu.getlDsCauThu(), BsKham);
	                     this.lCauThu.XemtinhTrangSucKhoe();
	                 }
	                 break;
	             }
	             case 2:
                 {
                     BacSi BsKham = this.lNhanvien.chonBacsi();
                     if (BsKham != null)
                     {
                         for (var item : this.lCauThu.getlDsCauThu())
                         {
                        	 System.out.println("Ten: " + item.sHoTen + " So Ao: " + item.getiSoAo());
                         }
                         System.out.print("Muon Kham Suc Khoe Cau Thu thu: ");
                         int i = input.nextInt();
                         //CauThu temp =  this.lCauThu.getlDsCauThu().get(i);
                     
                         HoatDong.KhamSucKhoeCauThu(this.lCauThu.getlDsCauThu().get(i), BsKham);
                         this.lCauThu.XemtinhTrangSucKhoe();
                     }
                     break;
                 }
	             case 3:
                 {
                     List<CauThu> temp = HoatDong.TuyenChon11CT(this.lCauThu.getlDsCauThu());
                     System.out.println("Doi Hinh da lua chon: ");
                     for (var item : temp)
                     {
                    	 System.out.println("Ten: " + item.sHoTen + " Vi Tri: " + item.getsViTriDaChinh());
                     }
                     break;
                 }
	             case 4:
                 {
                	 HLVTheLuc HLVTL = this.lNhanvien.chonHLVTL();
                     if (HLVTL != null)
                     {
                    	 HoatDong.HuanLuyenTLCaDoi(this.lCauThu.getlDsCauThu(), HLVTL);
                         this.lCauThu.XemtinhTrangtheLuc();
                     }
                     break;
                 }
	             case 5:
                 {
                	 HLVTheLuc HLVTL = this.lNhanvien.chonHLVTL();
                     if (HLVTL != null)
                     {
                    	 for (var item : this.lCauThu.getlDsCauThu())
                         {
                        	 System.out.println("Ten: " + item.sHoTen + " CMND: " + item.sCMND);
                         }
                         System.out.print("Muon Cai Thien The Luc Cau Thu thu: ");
                         int i = input.nextInt();
                         //CauThu temp = this.lCauThu.getlDsCauThu().get(i);
                         HoatDong.HuanLuyenTL(this.lCauThu.getlDsCauThu().get(i), HLVTL);
                         //this.lCauThu.getlDsCauThu() = temp;
                         this.lCauThu.XemtinhTrangtheLuc();
                     }
                     break;
                 }
	             case 6:
                 {
                     if (this.lCauThu.getlDsCauThu().size() < 11)
                     {
                    	 System.out.println("Khong du cau thu de tham gia thi dau");
                         break;
                     }
                     if (this.lNhanvien.getlHLVCT().size() == 0)
                     {
                    	 System.out.println("Khong co HLV");
                         break;
                     }
                     HLVChienThuat hlv = this.lNhanvien.chonHLVCT();
                     HoatDong.DaGiaoLuu(this.lCauThu.getlDsCauThu(), hlv, san);
                     break;
                 }
	             case 7:
	             {
	            	 this.ThaoTacHopDong();
	            	 this.expired.clear();
	            	 break;
	             }
	             case 8:
	             {
	            	 HoatDong.ChuyenNhuong(this.lCauThu, tmp);
	             }
	             case 9:
                 {
                     flag = 0;
                     break;
                 }
            
             default:
                 {
                	 System.out.println("Nhap sai, moi nhap lai!! ");
                     break;
                 }
             }
         }
     }
}
     
