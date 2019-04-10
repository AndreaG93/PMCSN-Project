package nexteventsimulation.computationalmodel.model.system.matlab;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class CTMCResolverScriptGenerator {

    protected Map<String, String> MATLABVariables = new HashMap<String, String>();

    protected String MATLABScriptFileName;
    protected FileWriter MATLABScriptFile;

    protected int equationNumber = 1;
    protected int numberOfMATLABVariables = 0;

    // Thresholds
    protected final int N = 20;
    protected final int S = 20;

    /**
     * This function is used to retrieve a string containing a MATLAB variable corresponding to a specified CTMC state.
     *
     * @param n1 - An @code{int} representing number of class 1 job in a CTMC state.
     * @param n2 - An @code{int} representing number of class 2 job in a CTMC state.
     * @return A @code{String} object.
     */
    protected String pi(int n1, int n2) {
        return MATLABVariables.get(String.format("pi(%d,%d)", n1, n2));
    }

    /**
     * This function is used to properly write previously build equation into MATLAB script.
     *
     * @param equation - A @code{String} object containing a MATLAB equation.
     */
    protected void writeEquationOnMATLABScript(String equation) throws IOException {

        this.MATLABScriptFile.write(String.format("eq%d = %s;\n", this.equationNumber, equation));
        this.equationNumber++;
    }

    /**
     * This function, invoked after completion of equation building phase, is used to insert some MATLAB command
     * used for equation computation.
     */
    protected void writeEquationComputationCommandsOnMATLABScript() throws IOException {

        this.MATLABScriptFile.write("solution = solve(");

        for (int i = 0; i < this.equationNumber; i++) {
            this.MATLABScriptFile.write(String.format("eq%d,", i));
        }

        for (int i = 0; i <= this.numberOfMATLABVariables; i++) {
            this.MATLABScriptFile.write(String.format("x%d", i));
            if (i == this.numberOfMATLABVariables)
                this.MATLABScriptFile.write(")\n");
            else
                this.MATLABScriptFile.write(",");
        }
    }

    /**
     * This function is used to perform MATLAB script initialization writing to them initial system parameters.
     */
    private void MATLABScriptInit() throws IOException {

        // Writing system parameters...
        this.MATLABScriptFile.write("lambda1 = 4;\n");
        this.MATLABScriptFile.write("lambda2 = 6.25;\n");
        this.MATLABScriptFile.write("mu1 = 0.45;\n");
        this.MATLABScriptFile.write("mu2 = 0.27;\n");
        this.MATLABScriptFile.write(String.format("N = %d;\n", N));
        this.MATLABScriptFile.write(String.format("S = %d;\n", N));

        // Declaration MATLAB variables...
        this.MATLABScriptFile.write("syms ");

        for (int i = 0; i <= this.numberOfMATLABVariables; i++) {
            this.MATLABScriptFile.write(String.format("x%d ", i));
        }

        this.MATLABScriptFile.write("\n");
    }

    /**
     * This function can be used to insert some MATLAB command for average population computation.
     *
     * @param classNumber - Class job which you want compute average population.
     */
    protected void writeAverageNumberOfJobCloudletComputationCommandsOnMATLABScript(int classNumber) throws IOException {

        this.MATLABScriptFile.write("\n");

        if (classNumber == 1)
            this.MATLABScriptFile.write("AverageNumberOfClass1JobCloudlet = 0");
        else
            this.MATLABScriptFile.write("AverageNumberOfClass2JobCloudlet = 0");

        for (int n1 = 0; n1 <= N; n1++)
            for (int n2 = 0; n2 <= N; n2++)
                if (pi(n1, n2) != null)
                    this.MATLABScriptFile.write(String.format(" + %d*solution.%s", (classNumber == 1) ? n1 : n2, pi(n1, n2)));

        this.MATLABScriptFile.write(";\n");
    }


    /**
     * This function is used to add an equation where the sum of the probability of all CTMC state is
     * equal to 1.
     */
    private void writeSumAllStateProbabilityEquation() throws IOException {
        this.MATLABScriptFile.write("eq0 = ");

        for (int i = 0; i <= this.numberOfMATLABVariables; i++) {
            this.MATLABScriptFile.write(String.format("x%d", i));

            if (i == this.numberOfMATLABVariables)
                this.MATLABScriptFile.write(" == 1\n");
            else
                this.MATLABScriptFile.write(" + ");
        }
    }

    /**
     * This function is used to populate an hash table used to contain matches between MATLAB variables and CTMC states.
     */
    protected abstract void MATLABVariablesInit();

    /**
     * This function is used to write balance equations on MATLAB script.
     */
    protected abstract void writeBalanceEquations() throws IOException;

    public abstract void startScriptGeneration();

    /**
     * Perform MATLAB script generation.
     */
    protected void writeCTMCResolutionCommandsOnMATLABScript() throws IOException {

        this.MATLABVariablesInit();
        this.MATLABScriptInit();

        this.writeBalanceEquations();
        this.writeSumAllStateProbabilityEquation();
        this.writeEquationComputationCommandsOnMATLABScript();
    }
}
