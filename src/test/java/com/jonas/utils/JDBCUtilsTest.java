package com.jonas.utils;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Desc：
 * Author Jonas
 * 2018/10/30 14:50
 */
public class JDBCUtilsTest {

    @Test
    public void getConnection() throws Exception {

        Connection connection = JDBCUtils.getConnection();
        Assert.assertNotNull(connection);

    }
}