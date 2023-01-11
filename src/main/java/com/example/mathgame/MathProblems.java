package com.example.mathgame;

public class MathProblems {

    private int points;

    private int level;

    public MathProblems() {
        points = 0;
        level = 1;
    }

    public int returnRandomOneDigit() {
        // define the range
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        int rand = (int) (Math.random() * range) + min;
        return rand;

    }

    public int returnRandomChoice() {
        // define the range
        int max = 2;
        int min = 1;
        int range = max - min + 1;

        int rand = (int) (Math.random() * range) + min;
        System.out.println(rand);
        return rand;

    }

    public void addPoints() {
        points++;
    }

    public void losePoints() {
        points--;
    }

    public void addLevel() {
        level++;
    }

    public void loseLevel() {
        level--;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
