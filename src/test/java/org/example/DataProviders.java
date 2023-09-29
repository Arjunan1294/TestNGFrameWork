package org.example;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "ada")
    public Object[][] getData1() {
        return new Object[][]{{"dasd", "asds"},
                {"tyyt", "gfh"}
        };
    }
}
