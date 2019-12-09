package com.learn.spl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author created by zzz at 2019/12/3 17:01
 */

@RestController
@RequestMapping("/user")
public class H2DataBaseController {

    private DataSource dataSource;

    private ObjectMapper objectMapper;

    @Autowired
    public H2DataBaseController(@Qualifier("h2PooledDataSource") DataSource dataSource, ObjectMapper objectMapper) {
        this.dataSource = dataSource;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/query")
    public void queryUser() throws SQLException, JsonProcessingException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = dataSource.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM USER");
            resultSet = preparedStatement.executeQuery();
            List<UserEntity> result = new LinkedList<>();
            do {
                if (!resultSet.isBeforeFirst()) {
                    UserEntity item = new UserEntity();
                    item.setId(resultSet.getInt(0));
                    item.setName(resultSet.getString(1));
                    item.setPassword(resultSet.getString(2));
                }
            } while (resultSet.next());
            System.out.println(objectMapper.writeValueAsString(result));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public static class UserEntity {
        private int id;

        private String name;

        private String password;

        private int detailId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getDetailId() {
            return detailId;
        }

        public void setDetailId(int detailId) {
            this.detailId = detailId;
        }
    }

    public static class UserDetailEntity {

        private int id;

        private int gender;

        private String des;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }
}
