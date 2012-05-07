package dt05;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 7/05/12
 * Time: 9:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class Micro4442 {
    public final static int MEM_COUNT = 16;
    public final static int HEXADECIMAL = 16;
    public final static int DECIMAL = 10;

    public final static int HALT = 0;
    public final static int ADD = 1;
    public final static int MINUS = 2;
    public final static int INCREMENT_R0 = 3;
    public final static int INCREMENT_R1 = 4;
    public final static int DECREMENT_R0 = 5;
    public final static int DECREMENT_R1 = 6;
    public final static int SWAP_AND_BELL = 7;
    public final static int XOR_AND_PRINT = 8;
    public final static int LOAD_INTO_R0 = 9;
    public final static int LOAD_INTO_R1 = 10;
    public final static int SAVE_R0 = 11;
    public final static int SAVE_R1 = 12;
    public final static int JUMP_TO = 13;
    public final static int JUMP_IF = 14;
    public final static int JUMP_IF_NOT = 15;

    private boolean haltFlag = false;

    private ArrayList<Cmd> commands = new ArrayList<Cmd>();

    private int PC; //program counter
    private int steps;
    private int R0; //register 0
    private int R1; //register 1
    private int[] memAddress = new int[MEM_COUNT]; //memory address

    public Micro4442(){
        resetMem();

        commands.add(new Halt());           //0
        commands.add(new Add());            //1
        commands.add(new Minus());          //2
        commands.add(new IncrementR0());    //3
        commands.add(new IncrementR1());    //4
        commands.add(new DecrementR0());    //5
        commands.add(new DecrementR1());    //6
        commands.add(new SwapAndBell());    //7
        commands.add(new XorAndPrint());    //8
        commands.add(new LoadIntoR0());     //9
        commands.add(new LoadIntoR1());     //10
        commands.add(new SaveR0());         //11
        commands.add(new SaveR1());         //12
        commands.add(new JumpTo());         //13
        commands.add(new JumpIf());         //14
        commands.add(new JumpIfNot());      //15
    }

    void resetMem(){
        for(int i = 0; i < MEM_COUNT; i++){
            memAddress[i] = HALT;
        }
        PC = 0;
        R0 = HALT;
        R1 = HALT;
        steps = 0;
    }

    void performAction(){
        Cmd command = commands.get(memAddress[PC]);
        command.run();
        steps++;
    }

    public void setMemAddress(String input) {
        char[] letters = input.toCharArray();
        int i = 0;
        if(letters.length == MEM_COUNT){
            for(char letter : letters){
                memAddress[i] = hexadeciToInt(letter);
                i++;
            }
        } else {
            System.out.println("Can't input mismatched memory count");
        }
    }

    public void setMemAddress(char[] letters) {
        int i = 0;
        if(letters.length == MEM_COUNT){
            for(char letter : letters){
                memAddress[i] = hexadeciToInt(letter);
                i++;
            }
        } else {
            System.out.println("Can't input mismatched memory count");
        }
    }

    public char intToHexadeci(int number) {
        char output;
        if(number < DECIMAL){
            output = (char)('0' + number);
        } else {
            number -= DECIMAL;
            output = (char)('A' +  number);
        }
        return output;
    }

    public int hexadeciToInt(char letter){
        int output = 0;
        if(letter >= '0' && letter <= '9'){
            output = (int)(letter - '0');
        } else {
            output = (int)(letter - 'A') + 10;
        }
        return output;
    }
    
    private abstract class Cmd {
        private Cmd(){
        }
        abstract void run();
    }

    private class Halt extends Cmd{
        private Halt(){

        }
        void run(){
            haltFlag = true;
        }
    }

    private class Add extends Cmd {
        private Add(){

        }
        void run(){
            R0 = R0 + R1;
            R0 %= HEXADECIMAL;
            incrementPC();
        }
    }

    private class Minus extends Cmd {
        private Minus(){

        }
        void run(){
            R0 = R0 + HEXADECIMAL - R1;
            R0 %= HEXADECIMAL;
            incrementPC();
        }
    }

    private class IncrementR0 extends Cmd {
        private IncrementR0(){

        }
        void run(){
            R0++;
            R0 %= HEXADECIMAL;
            incrementPC();
        }
    }

    private class IncrementR1 extends Cmd {
        private IncrementR1(){

        }
        void run(){
            R1++;
            R1 %= HEXADECIMAL;
            incrementPC();
        }
    }

    private class DecrementR0 extends Cmd {
        private DecrementR0(){

        }
        void run(){
            R0 += HEXADECIMAL - 1;
            R0 %= HEXADECIMAL;
            incrementPC();
        }
    }

    private class DecrementR1 extends Cmd {
        private DecrementR1(){

        }
        void run(){
            R1 += HEXADECIMAL - 1;
            R1 %= HEXADECIMAL;
            incrementPC();
        }
    }

    private class SwapAndBell extends Cmd {
        private SwapAndBell(){

        }
        void run(){
            int tmp = R0;
            R0 = R1;
            R1 = tmp;
            // ring bell!
            incrementPC();
        }
    }

    private class XorAndPrint extends Cmd {
        private XorAndPrint(){

        }
        void run(){
            incrementPC();
            R0 = R0 ^ memAddress[PC];
            System.out.println("Printing:" + intToHexadeci(memAddress[PC]));
            incrementPC();
        }
    }

    private class LoadIntoR0 extends Cmd {
        private LoadIntoR0(){

        }
        void run(){
            incrementPC();
            R0 = memAddress[memAddress[PC]];
            incrementPC();
        }
    }

    private class LoadIntoR1 extends Cmd {
        private LoadIntoR1(){

        }
        void run(){
            incrementPC();
            R1 = memAddress[memAddress[PC]];
            incrementPC();
        }
    }

    private class SaveR0 extends Cmd {
        private SaveR0(){

        }
        void run(){
            incrementPC();
            memAddress[memAddress[PC]] = R0;
            incrementPC();
        }
    }

    private class SaveR1 extends Cmd {
        private SaveR1(){

        }
        void run(){
            incrementPC();
            memAddress[memAddress[PC]] = R1;
            incrementPC();
        }
    }

    private class JumpTo extends Cmd {
        private JumpTo(){

        }
        void run(){
            incrementPC();
            PC = memAddress[PC];
        }
    }

    private class JumpIf extends Cmd {
        private JumpIf(){

        }
        void run(){
            incrementPC();
            if(R0 == 0){
                PC = memAddress[PC];
            } else {
                incrementPC();
            }
        }
    }

    private class JumpIfNot extends Cmd {
        private JumpIfNot(){

        }
        void run(){
            incrementPC();
            if(R0 != 0){
                PC = memAddress[PC];
            } else {
                incrementPC();
            }
        }
    }

    private void incrementPC(){
        PC++;
        PC %= MEM_COUNT;
    }

    private void printState(){

        System.out.printf("|---------------------------|\n");
        System.out.printf("||--------||---------------||\n");
        System.out.printf("|| R0 = %c || %c | %c | %c | %c ||\n", intToHexadeci(R0),
                intToHexadeci(memAddress[0]), intToHexadeci(memAddress[1]),
                intToHexadeci(memAddress[2]), intToHexadeci(memAddress[3]));
        System.out.printf("||--------||---------------||\n");
        System.out.printf("|          | %c | %c | %c | %c ||\n", intToHexadeci(memAddress[4]),
                intToHexadeci(memAddress[5]), intToHexadeci(memAddress[6]),
                intToHexadeci(memAddress[7]));
        System.out.printf("||--------||---------------||\n");
        System.out.printf("|| R1 = %c || %c | %c | %c | %c ||\n", intToHexadeci(R1),
                intToHexadeci(memAddress[8]), intToHexadeci(memAddress[9]),
                intToHexadeci(memAddress[10]), intToHexadeci(memAddress[11]));
        System.out.printf("||--------||---------------||\n");
        System.out.printf("|          | %c | %c | %c | %c ||\n", intToHexadeci(memAddress[12]),
                intToHexadeci(memAddress[13]), intToHexadeci(memAddress[14]),
                intToHexadeci(memAddress[15]));
        System.out.printf("|  i = %-2d  |---------------||\n", PC);
        System.out.printf("|  s = %-8d             |\n", steps);
        System.out.printf("|---------------------------|\n");
    }

    public int getPC() {
        return PC;
    }

    public int getR0() {
        return R0;
    }

    public int getR1() {
        return R1;
    }

    public int[] getMemAddress() {
        return memAddress;
    }
}
