/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly.qlchsach.dao;

import Poly.qlchsach.helper.Jdbc;
import Poly.qlchsach.model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class KhachHangDAO {
    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang (MaKH, MaHD, TenKH, SDT, Email, GioiTinh, DiaChi, Hinh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Jdbc.executeUpdate(sql,
                model.getMaKH(),
                model.getMaHD(),
                model.getTenKH(),
                model.getSDT(),
                model.getEmail(),
                model.isGioiTinh(),
                model.getDiaChi(),
                model.getHinh()
        );
    }
    
    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang SET MaHD=?, TenKH=?, SDT=?, Email=?, GioiTinh=?, DiaChi=?, Hinh=? WHERE MaKH=?";
        Jdbc.executeUpdate(sql,
                model.getMaHD(),
                model.getTenKH(),
                model.getSDT(),
                model.getEmail(),
                model.isGioiTinh(),
                model.getDiaChi(),
                model.getHinh(),
                model.getMaKH()
        );
    }

    public void delete(String tenKH) {
        String sql = "DELETE FROM KhachHang WHERE TenKH=?";
        Jdbc.executeUpdate(sql, tenKH);
    }

    public List<KhachHang> select() {
        String sql = "SELECT * FROM KhachHang";
        return select(sql);
    }
    
    public List<KhachHang> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ?";
        return select(sql, "%" + keyword + "%");
    }
    
    public KhachHang findById(String maKH) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
        List<KhachHang> list = select(sql, maKH);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKH(rs.getString("MaKH"));
        model.setMaHD(rs.getString("MaHD"));
        model.setTenKH(rs.getString("TenKH"));
        model.setSDT(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }
}
