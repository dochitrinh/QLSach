/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly.qlchsach.dao;

import Poly.qlchsach.helper.Jdbc;
import Poly.qlchsach.model.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HoaDonDAO {
    public void insert(HoaDon model) {
        String sql = "INSERT INTO HoaDon (MaHD, MaNV, MaSach, TenSach, Gia, NgayBan, SoLuong, TongTien) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Jdbc.executeUpdate(sql,
                model.getMaHD(),
                model.getMaNV(),
                model.getMaSach(),
                model.getTenSach(),
                model.getGia(),
                model.getNgayBan(),
                model.getSoLuong(),
                model.getTongTien()
        );
    }
    
    public void update(HoaDon model) {
        String sql = "UPDATE HoaDon SET MaNV=?, MaSach=?, TenSach=?, Gia=?, NgayBan=?, SoLuong=?, TongTien=? WHERE MaHD=?";
        Jdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getMaSach(),
                model.getTenSach(),
                model.getGia(),
                model.getNgayBan(),
                model.getSoLuong(),
                model.getTongTien(),
                model.getMaHD()
        );
    }

    public void delete(String maHD) {
        String sql = "DELETE FROM HoaDon WHERE MaHD=?";
        Jdbc.executeUpdate(sql, maHD);
    }

    public List<HoaDon> select() {
        String sql = "SELECT * FROM HoaDon";
        return select(sql);
    }
    
    public List<HoaDon> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM HoaDon WHERE MaHD LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public HoaDon findById(String maHD) {
        String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
        List<HoaDon> list = select(sql, maHD);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
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

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHD(rs.getString("MaHD"));
        model.setMaNV(rs.getString("MaNV"));
        model.setMaSach(rs.getString("MaSach"));
        model.setNgayBan(rs.getDate("NgayBan"));
        model.setTenSach(rs.getString("TenSach"));
        model.setGia(rs.getDouble("Gia"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setTongTien(rs.getDouble("TongTien"));
        return model;
    }
}
