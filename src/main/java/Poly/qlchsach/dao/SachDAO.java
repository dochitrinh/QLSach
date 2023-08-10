/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly.qlchsach.dao;

import Poly.qlchsach.helper.Jdbc;
import Poly.qlchsach.model.Sach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SachDAO {
    public void insert(Sach model) {
        String sql = "INSERT INTO Sach (MaSach, TenSach, SoLuong, Gia, TheLoai, TacGia, NXB, Hinh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Jdbc.executeUpdate(sql,
                model.getMaSach(),
                model.getTenSach(),
                model.getSoLuong(),
                model.getGia(),
                model.getTenTL(),
                model.getTenTG(),
                model.getNXB(),
                model.getHinh()
        );
    }
    
    public void update(Sach model) {
        String sql = "UPDATE Sach SET TenSach=?, SoLuong=?, Gia=?, TheLoai=?, TacGia=?, NXB=?, Hinh=? WHERE MaSach=?";
        Jdbc.executeUpdate(sql,
                model.getTenSach(),
                model.getSoLuong(),
                model.getGia(),
                model.getTenTL(),
                model.getTenTG(),
                model.getNXB(),
                model.getHinh(),
                model.getMaSach()
        );
    }

    public void delete(String maSach) {
        String sql = "DELETE FROM Sach WHERE MaSach=?";
        Jdbc.executeUpdate(sql, maSach);
    }

    public List<Sach> select() {
        String sql = "SELECT * FROM Sach";
        return select(sql);
    }

    public Sach findById(String maSach) {
        String sql = "SELECT * FROM Sach WHERE MaSach=?";
        List<Sach> list = select(sql, maSach);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<Sach> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Sach WHERE TenSach LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    private List<Sach> select(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    Sach model = readFromResultSet(rs);
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

    private Sach readFromResultSet(ResultSet rs) throws SQLException {
        Sach model = new Sach();
        model.setMaSach(rs.getString("MaSach"));
        model.setTenSach(rs.getString("TenSach"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGia(rs.getDouble("Gia"));
        model.setTenTL(rs.getString("TheLoai"));
        model.setTenTG(rs.getString("TacGia"));
        model.setNXB(rs.getString("NXB"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }
}
