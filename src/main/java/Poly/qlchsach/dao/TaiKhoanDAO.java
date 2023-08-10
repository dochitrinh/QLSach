/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly.qlchsach.dao;

import Poly.qlchsach.helper.Jdbc;
import Poly.qlchsach.model.Sach;
import Poly.qlchsach.model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TaiKhoanDAO {

    public void insert(TaiKhoan model) {
        String sql = "INSERT INTO TaiKhoan (MaNV, TenNV, TaiKhoan, MatKhau, VaiTro) VALUES (?, ?, ?, ?, ?)";
        Jdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getTenNV(),
                model.getTaiKhoan(),
                model.getMatKhau(),
                model.isVaiTro()
        );
    }

    public void update(TaiKhoan model) {
        String sql = "UPDATE TaiKhoan SET TenNV=?, TaiKhoan=?, MatKhau=?, VaiTro=? WHERE MaNV=?";
        Jdbc.executeUpdate(sql,
                model.getTenNV(),
                model.getTaiKhoan(),
                model.getMatKhau(),
                model.isVaiTro(),
                model.getMaNV()
        );
    }
    
    public void updateTK(String maNV, String tenNV, String taiKhoan, String matKhau, boolean vaiTro) {
        String sql = "{call  sp_updateTK (?, ?, ? , ? , ?)}";
        Jdbc.executeUpdate(sql, maNV, tenNV, taiKhoan, matKhau, vaiTro);
    }
    
    public void updateMK(TaiKhoan model) {
    String sql = "UPDATE TaiKhoan SET MaNV=?, TenNV=?, MatKhau=?, VaiTro=? WHERE TaiKhoan=?";
        Jdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getTenNV(),
                model.getMatKhau(),
                model.isVaiTro(),
                model.getTaiKhoan()
        );
    } 

    public void delete(String maNV) {
        String sql = "{call sp_deleteTK (?)}";
        Jdbc.executeUpdate(sql, maNV);
    }

    public List<TaiKhoan> select() {
        String sql = "SELECT * FROM TaiKhoan";
        return select(sql);
    }

    public TaiKhoan findById(String maNV) {
        String sql = "SELECT * FROM TaiKhoan WHERE MaNV=?";
        List<TaiKhoan> list = select(sql, maNV);
        return list.size() > 0 ? list.get(0) : null;
    }
    
     public TaiKhoan findByTaiKhoan(String taiKhoan) {
        String sql = "SELECT * FROM TaiKhoan WHERE taiKhoan=?";
        List<TaiKhoan> list = select(sql, taiKhoan);
        return list.size() > 0 ? list.get(0) : null;
    }
     
     public List<TaiKhoan> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenNV LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    private List<TaiKhoan> select(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Jdbc.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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

    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setMaNV(rs.getString("MaNV"));
        model.setTenNV(rs.getString("TenNV"));
        model.setTaiKhoan(rs.getString("TaiKhoan"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
}
