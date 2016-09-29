package com.ironyard.services;

import org.junit.Assert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * Created by jasonskipper on 9/29/16.
 */
public class DbServiceTest {
    @org.junit.Test
    public void getConnection() throws Exception {
        DbService dbService = new DbService();
        Connection con = dbService.getConnection();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM firstone.companies");

        boolean foundSomething = false;
        while(rs.next()){
            foundSomething = true;
            System.out.println(rs.getString("com_name"));
        }
        Assert.assertTrue(foundSomething);

    }

}