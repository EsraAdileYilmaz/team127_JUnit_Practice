package tests.day01;

import org.junit.*;

public class P02_Notasyonlar {

    @BeforeClass
    public  static void setUp(){
        System.out.println("=================Test İslemleri Başlatıldı===================");
        System.out.println(" ");
        System.out.println(" ");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("=================Test İslemleri Tamamlandı===================");

    }

    @Before
    public void before(){
        System.out.println("------------------Before-----------------------");
        System.out.println("         Yeni Bir Test Calistiriliyor         ");
        System.out.println(" ");
    }

    @After
    public void after(){
        System.out.println(" ");
        System.out.println("------------------After-----------------------");
        System.out.println(" ");

    }

    @Test
    public void test01(){
        System.out.println("1 Numaralı Test Calistiriliyor");
    }
    @Test
    public void test02(){
        System.out.println("2 Numaralı Test Calistiriliyor");

    }
    @Test
    public void test03(){
        System.out.println("3 Numaralı Test Calistiriliyor");
    }
    @Test
    public void test04(){
        System.out.println("4 Numaralı Test Calistiriliyor");
    }
    @Test
    public void test05(){
        System.out.println("5 Numaralı Test Calistiriliyor");
    }


}
