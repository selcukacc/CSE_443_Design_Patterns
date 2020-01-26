package com.part1;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------- Part 1 --------");
        LinearSolverDelux linearSolverDelux = new LinearSolverDelux(new MatrixInversion());
        linearSolverDelux.solveEquation();
        linearSolverDelux.setEquationSolver(new GaussianElimination());
        linearSolverDelux.solveEquation();

    }
}
