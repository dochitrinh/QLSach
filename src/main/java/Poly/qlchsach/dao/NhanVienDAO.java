/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly.qlchsach.dao;

import Poly.qlchsach.helper.Jdbc;
import Poly.qlchsach.model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class NhanVienDAO {
    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (MaNV, TenNV, SDT, Email, GioiTinh, DiaChi, Hinh) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Jdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getTenNV(),
                model.getSDT(),
                model.getEmail(),
                model.isGioiTinh(),
                model.getDiaChi(),
                model.getHinh()
        );
    }
    
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET TenNV=?, SDT=?, Email=?, GioiTinh=?, DiaChi=?, Hinh=? WHERE MaNV=?";
        Jdbc.executeUpdate(sql,
                model.getTenNV(),
                model.getSDT(),
                model.getEmail(),
                model.isGioiTinh(),
                model.getDiaChi(),
                model.getHinh(),
                model.getMaNV()
        );
    }
    
    public void updateNV(String maNV, String tenNV, String SDT, String email, boolean gioiTinh, String diaChi, String hinh) {
        String sql = "{call  sp_updateNV (?, ?, ? , ? , ? , ? , ?)}";
        Jdbc.executeUpdate(sql, maNV,tenNV, SDT, email, gioiTinh, diaChi, hinh);
    }

    public void delete(String maNV) {
        String sql = "{call sp_deleteNV (?)}";
        Jdbc.executeUpdate(sql, maNV);
    }

    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }
    
    public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public NhanVien findById(String maNV) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, maNV);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setTenNV(rs.getString("TenNV"));
        model.setSDT(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }
}
