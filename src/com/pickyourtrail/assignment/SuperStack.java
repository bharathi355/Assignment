package com.pickyourtrail.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperStack {
    private List<Integer> stack;
    private int top;
    public SuperStack(){
        this.stack = new ArrayList<>();
        this.top = -1;
    }
    public static void main(String args[]) throws Exception {
        SuperStack superStack = new SuperStack();
        superStack.executeCommands(superStack.getUserCommands());
    }

    private void executeCommands(String[] userCommand) throws Exception {
        for (int i=0; i<userCommand.length;i++){
            if(userCommand[i].toLowerCase().contains("push")){
                String[] operationValue = userCommand[i].split(" ");
                int value = Integer.parseInt(operationValue[1]);
                this.push(value);
                this.printCurrentTop();
            }else if(userCommand[i].toLowerCase().contains("pop")){
                this.pop();
                this.printCurrentTop();
            }else if(userCommand[i].toLowerCase().contains("inc")){
                String[] operationValue = userCommand[i].split(" ");
                int count = Integer.parseInt(operationValue[1]);
                int valueToIncrease = Integer.parseInt(operationValue[2]);
                this.incrementStackPart(count,valueToIncrease);
                this.printCurrentTop();
            }else {
                System.out.println("Operation Not Supported");
            }
        }
    }

    private void incrementStackPart(int count, int valueToIncrease) throws Exception {
        if(count > this.getSize()){
            throw new Exception("Cannot Perform Operation! Stack size is low!");
        }
        for(int i=0; i<count; i++){
            this.stack.add(i,this.stack.get(i)+valueToIncrease);
            this.stack.remove(i+1);
        }
    }

    private int getSize() {
        return this.stack.size();
    }

    private void printCurrentTop() {
        if(this.top == -1){
            System.out.println("EMPTY");
            return;
        }
        System.out.println(this.stack.get(this.top));
    }

    private String[] getUserCommands() {
        int numberOfCommands;
        String commandArray[];
        Scanner inputScanner = new Scanner(System.in);
        numberOfCommands = inputScanner.nextInt();
        inputScanner = new Scanner(System.in);
        commandArray = new String[numberOfCommands];
        for(int index=0;index<numberOfCommands;index++){
            commandArray[index] = inputScanner.nextLine();
        }
        return commandArray;
    }

    private int pop() throws Exception {
        if(this.top == -1 ){
            throw new Exception("Cannot pop..Stack Underflow!");
        }
        int value = this.stack.get(this.top);
        this.stack.remove(this.top);
        this.top--;
        return value;
    }

    private void push(int value) {
        this.stack.add(value);
        this.top++;
    }
}
