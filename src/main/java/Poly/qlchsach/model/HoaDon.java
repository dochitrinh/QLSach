/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly.qlchsach.model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class HoaDon {

    private String maHD;
    private String maNV;
    private String maSach;
    private Date ngayBan;
    private String tenSach;
    private double Gia;
    private int soLuong;
    private double tongTien;

    @Override
    public String toString() {
        return this.maHD;
    }

    public HoaDon() {
    }

    public HoaDon(String maHD, String maNV, String maSach, Date ngayBan, String tenSach, double Gia, int soLuong, double tongTien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maSach = maSach;
        this.ngayBan = ngayBan;
        this.tenSach = tenSach;
        this.Gia = Gia;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    

    
}
