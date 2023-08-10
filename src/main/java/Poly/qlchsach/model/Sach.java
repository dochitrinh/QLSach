/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly.qlchsach.model;

/**
 *
 * @author ASUS
 */
public class Sach {

    private String maSach;
    private String tenSach;
    private int soLuong;
    private double gia;
    private String tenTL;
    private String tenTG;
    private String NXB;
    private String hinh;

    @Override
    public String toString() {
        return this.tenSach;
    }

    public Sach() {
    }

    public Sach(String maSach, String tenSach, int soLuong, double gia, String tenTL, String tenTG, String NXB, String hinh) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tenTL = tenTL;
        this.tenTG = tenTG;
        this.NXB = NXB;
        this.hinh = hinh;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String masach) {
        this.maSach = masach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

}
