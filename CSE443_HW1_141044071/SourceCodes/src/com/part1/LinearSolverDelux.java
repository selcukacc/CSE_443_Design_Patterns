package com.part1;

public class LinearSolverDelux {
    /**
     * Behavior for equation solver methods.
     */
    private EquationSolver equationSolver;

    public LinearSolverDelux(EquationSolver equationSolver) {
        this.equationSolver = equationSolver;
    }

    /**
     * It helps to change solver dynamically.
     * @param equationSolver Wanted solver method.
     */
    public void setEquationSolver(EquationSolver equationSolver) {
        this.equationSolver = equationSolver;
    }

    public EquationSolver getEquationSolver() {
        return this.equationSolver;
    }

    public void solveEquation() {
        equationSolver.linearEquationSolver();
    }
}
