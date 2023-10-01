package org.example;

import lombok.Data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.*;

public class LoginPage extends BaseTest{


    Google google;


    @Test(groups = {"sanity","regression"})
    public void test1() throws InterruptedException {
        google = new Google(DriverFactory.getDriver());
        google.enterEmail("summa");
        Thread.sleep(5000);
    }

    @Ignore
    @Test(groups = {"sanity"})
    public void test2() throws InterruptedException {
        google = new Google(DriverFactory.getDriver());
        google.enterEmail("summa");

        Thread.sleep(5000);
    }

   // @Test(dataProvider = "dataprov1", groups = {"smoke"},expectedExceptions = {NoSuchElementException.class, ExcelReader.class})
    @Test(dataProvider = "dataprov1", groups = {"smoke"},enabled = true,retryAnalyzer = RetryAnalyzerClass.class)
    public void test3(Object s1,Object s2,Object s3,Object s4) throws InterruptedException {
        System.out.println("summa test1");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }

    @Test(dataProvider = "ada",dataProviderClass = DataProviders.class, dependsOnMethods = {"test3"}, groups = {"smoke"},ignoreMissingDependencies = true)
    public void test4(Object[] ss) throws InterruptedException {
        System.out.println("summa test1");
        for(Object o:ss){
            System.out.println(o);

        }
    }

    @DataProvider(name = "dataprov1",indices = {0,2})
    public Object[][] datapro1(){
        Object[][] obj = new Object[2][4];
        obj[0][0] = "s";
        obj[0][1] = "a";
        obj[0][2] = "b";
        obj[0][3] = "f";

        obj[1][0] = "b";
        obj[1][1] = "a";
        obj[1][2] = "d";
        obj[1][3] = "e";

        return obj;
    }

    @DataProvider(name="dataprov2")
    public Object[][] data2(){
        Object[][] obj1 = new Object[][]{
                {"ada",1,"mala","fs"},
                {"fdd","sde"},
                {"ry"}
        };
        return obj1;
    }

    @DataProvider(name="summa")
    public Iterator<Object[]> data3(){
        List<Object[]> sss = new ArrayList<>();
        sss.add(new Object[]{"ada","enna"});
        sss.add(new Object[]{"ytu","jhjh"});
        return sss.iterator();
    }
}
