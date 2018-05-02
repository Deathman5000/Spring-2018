/*
    This program shows how to accept input into a java program as command line argument(s)
    This program will require two arguments on the command line. The first argument is a string and second is an integer
    Example of a run command is java CommandLineInput Hello 50
    author: James Hund
    version: 01/29/1018
	file: CommandLineInput.java
 */
public class CommandLineInput {
    public static void main(String [] args){
        int i = Integer.parseInt(args[1]); // convert second argument to an integer
        i++; 
        System.out.println("The first input is " + args[0]);
        System.out.println("The second input plus one is " + i);
    }
}