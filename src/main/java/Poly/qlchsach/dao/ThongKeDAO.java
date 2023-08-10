/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poly.qlchsach.dao;

import Poly.qlchsach.helper.Jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ThongKeDAO {
    public List<Object[]> getDoanhThu(Integer nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TKDoanhThu (?)}";
                rs = Jdbc.executeQuery(sql, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSach"),
                        rs.getString("TenSach"),
                        rs.getInt("SoLuong"),
                        rs.getDouble("DoanhThu")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
