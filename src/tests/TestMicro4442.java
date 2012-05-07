package tests;

import dt05.*;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 7/05/12
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMicro4442 {
    public static void main(String[] args){
        boolean allPassed = true;

        allPassed &= test01();
        allPassed &= test02();
        allPassed &= test03();
        allPassed &= test04();
        allPassed &= test05();
        allPassed &= test06();
        allPassed &= test07();
        allPassed &= test08();

        if(allPassed){
            System.out.println("All tests PASSED! You are AWESOME!");
        }
    }

    private static boolean test01() {
        boolean pass = true;
        Micro4442 chip = new Micro4442();
        int[] input =
               {1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1};
        int[] expected =
                {1, 1, 1, 1,
                 1, 1, 1, 1,
                 1, 1, 1, 1,
                 1, 1, 1, 1};
        int[] memAddress;
        boolean arrayChk = true;

        System.out.println("Running test01");
        chip.setMemAddress(input);
        chip.fullRun();
        memAddress = chip.getMemAddress();

        for(int i = 0; i < expected.length; i++){
            if(expected[i] != memAddress[i]){
                arrayChk = false;
            }
        }

        if(!chip.isLoop() || chip.getR0() != 0 || chip.getR1() != 0
                || !arrayChk){
            pass = false;
            chip.printState();
        }

        return pass;
    }

    private static boolean test02() {
        boolean pass = true;
        Micro4442 chip = new Micro4442();
        int[] input =
               {3, 3, 4, 1,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] expected =
               {3, 3, 4, 1,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] memAddress;
        boolean arrayChk = true;

        System.out.println("Running test02");
        chip.setMemAddress(input);
        chip.fullRun();
        memAddress = chip.getMemAddress();

        for(int i = 0; i < expected.length; i++){
            if(expected[i] != memAddress[i]){
                arrayChk = false;
            }
        }

        if(chip.getPC() != 5 || chip.getR0() != 3 || chip.getR1() != 1
                || !arrayChk){
            pass = false;
            chip.printState();
        }
        return pass;
    }

    private static boolean test03() {
        boolean pass = true;
        Micro4442 chip = new Micro4442();
        int[] input =
               {3, 3, 4, 2,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] expected =
               {3, 3, 4, 2,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] memAddress;
        boolean arrayChk = true;

        System.out.println("Running test03");
        chip.setMemAddress(input);
        chip.fullRun();
        memAddress = chip.getMemAddress();

        for(int i = 0; i < expected.length; i++){
            if(expected[i] != memAddress[i]){
                arrayChk = false;
            }
        }

        if(chip.getPC() != 5 || chip.getR0() != 1 || chip.getR1() != 1
                || !arrayChk){
            pass = false;
            chip.printState();
        }
        return pass;
    }

    private static boolean test04() {
        boolean pass = true;
        Micro4442 chip = new Micro4442();
        int[] input =
               {3, 3, 4, 2,
                5, 6, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] expected =
               {3, 3, 4, 2,
                5, 6, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] memAddress;
        boolean arrayChk = true;

        System.out.println("Running test04");
        chip.setMemAddress(input);
        chip.fullRun();
        memAddress = chip.getMemAddress();

        for(int i = 0; i < expected.length; i++){
            if(expected[i] != memAddress[i]){
                arrayChk = false;
            }
        }

        if(chip.getPC() != 7 || chip.getR0() != 0 || chip.getR1() != 0
                || !arrayChk){
            pass = false;
            chip.printState();
        }
        return pass;
    }

    private static boolean test05() {
        boolean pass = true;
        Micro4442 chip = new Micro4442();
        int[] input =
               {3, 3, 4, 2,
                5, 7, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] expected =
               {3, 3, 4, 2,
                5, 7, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] memAddress;
        boolean arrayChk = true;

        System.out.println("Running test05");
        chip.setMemAddress(input);
        chip.fullRun();
        memAddress = chip.getMemAddress();

        for(int i = 0; i < expected.length; i++){
            if(expected[i] != memAddress[i]){
                arrayChk = false;
            }
        }

        if(chip.getPC() != 7 || chip.getR0() != 1 || chip.getR1() != 0
                || !arrayChk){
            pass = false;
            chip.printState();
        }
        return pass;
    }

    private static boolean test06() {
        boolean pass = true;
        Micro4442 chip = new Micro4442();
        int[] input =
               {3, 3, 8, 15,
                3, 3, 3, 3,
                8, 15, 0, 0,
                0, 0, 0, 0};
        int[] expected =
               {3, 3, 8, 15,
                3, 3, 3, 3,
                8, 15, 0, 0,
                0, 0, 0, 0};
        int[] memAddress;
        boolean arrayChk = true;

        System.out.println("Running test06");
        chip.setMemAddress(input);
        chip.fullRun();
        memAddress = chip.getMemAddress();

        for(int i = 0; i < expected.length; i++){
            if(expected[i] != memAddress[i]){
                arrayChk = false;
            }
        }

        if(chip.getPC() != 11 || chip.getR0() != 14 || chip.getR1() != 0
                || !arrayChk){
            pass = false;
            chip.printState();
        }
        return pass;
    }

    private static boolean test07() {
        boolean pass = true;
        Micro4442 chip = new Micro4442();
        int[] input =
                {9, 3, 10, 2,
                11, 14, 12, 15,
                0, 0, 0, 0,
                0, 0, 0, 0};
        int[] expected =
               {9, 3, 10, 2,
                11, 14, 12, 15,
                0, 0, 0, 0,
                0, 0, 2, 10};
        int[] memAddress;
        boolean arrayChk = true;

        System.out.println("Running test07");
        chip.setMemAddress(input);
        chip.fullRun();
        memAddress = chip.getMemAddress();

        for(int i = 0; i < expected.length; i++){
            if(expected[i] != memAddress[i]){
                arrayChk = false;
            }
        }

        if(chip.getPC() != 9|| chip.getR0() != 2 || chip.getR1() != 10
                || !arrayChk){
            pass = false;
            chip.printState();
        }
        return pass;
    }

    private static boolean test08() {
        boolean pass = true;
        Micro4442 chip = new Micro4442();
        int[] input =
               {13, 10, 0, 0,
                0, 3, 15, 9,
                0, 0, 14, 5,
                0, 0, 0, 0};
        int[] expected =
               {13, 10, 0, 0,
                0, 3, 15, 9,
                0, 0, 14, 5,
                0, 0, 0, 0};
        int[] memAddress;
        boolean arrayChk = true;

        System.out.println("Running test08");
        chip.setMemAddress(input);
        chip.fullRun();
        memAddress = chip.getMemAddress();

        for(int i = 0; i < expected.length; i++){
            if(expected[i] != memAddress[i]){
                arrayChk = false;
            }
        }

        if(chip.getPC() != 10|| chip.getR0() != 1 || chip.getR1() != 0
                || !arrayChk){
            pass = false;
            chip.printState();
        }
        return pass;
    }
}
