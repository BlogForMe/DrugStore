package com.eoe.drugstore;


import android.test.AndroidTestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2016/7/19.
 */

public class JunitLifeCycle {
    @Before
    public void init() {
        System.out.println("--- method init() called---");
    }

    @BeforeClass
    public static void prepareDataForTest() {
        System.out.println("--- method prepareDataForTest() called--");
    }

    @Test
    public void test1() {
        System.out.println("--- method test1() called--");
    }

    @After
    public void clearDataForTest() {
        System.out.println("--- method clearDataForTest() called--");
    }

    @AfterClass
    public static void finish() {
        System.out.println("--- method finish() called--");
    }
}
