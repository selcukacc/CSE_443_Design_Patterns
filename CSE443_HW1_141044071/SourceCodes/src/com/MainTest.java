package com;

import com.part1.Main;
import com.part2.ContentManagement;
import com.part3.ZirhSanProduction;
import com.part4a.TurkishAerospaceIndustries;
import com.part4b.TurkishAerospaceIndustriesVersion2;

public class MainTest {
    public static void main(String[] args) {
        Main.main(args);
        System.out.println();

        ContentManagement.main(args);
        System.out.println();

        ZirhSanProduction.main(args);
        System.out.println();

        TurkishAerospaceIndustries.main(args);
        System.out.println();

        TurkishAerospaceIndustriesVersion2.main(args);
        System.out.println();
    }
}
