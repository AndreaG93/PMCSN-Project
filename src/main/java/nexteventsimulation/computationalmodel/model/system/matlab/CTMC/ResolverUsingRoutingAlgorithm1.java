package nexteventsimulation.computationalmodel.model.system.matlab.CTMC;

import java.io.FileWriter;
import java.io.IOException;

public class ResolverUsingRoutingAlgorithm1 extends CTMCResolverScriptGenerator {

    public void startScriptGeneration() {

        try {

            this.MATLABScriptFile = new FileWriter("MATLAB_ALG1_CTMC_ResolverScript.m");

            this.writeCTMCResolutionCommandsOnMATLABScript();
            this.writeAverageNumberOfJobCloudletComputationCommandsOnMATLABScript(1);
            this.writeAverageNumberOfJobCloudletComputationCommandsOnMATLABScript(2);

            this.calculate_ALG_1_SendJobToCloudProbability();
            this.calculate_ALG_1_CloudletUtilization();

            this.MATLABScriptFile.close();

        } catch (IOException e) {
            System.exit(1);
        }
    }

    @Override
    protected void MATLABVariablesInit() {

        for (int n1 = 0; n1 <= N; n1++) {

            for (int n2 = 0; n2 <= N; n2++) {

                if (n1 + n2 <= N) {
                    this.MATLABVariables.put(String.format("pi(%d,%d)", n1, n2), String.format("x%d", this.numberOfMATLABVariables));
                    this.numberOfMATLABVariables++;
                }
            }
        }
    }

    @Override
    protected void writeBalanceEquations() throws IOException {

        String eq;

        eq = String.format("(lambda1 + lambda2)*%s == mu1*%s + mu2*%s", pi(0, 0), pi(1, 0), pi(0, 1));
        this.writeEquationOnMATLABScript(eq);

        // ********************************************************************************************** //

        for (int i = 1; i <= N - 1; i++) {
            eq = String.format("(lambda1 + lambda2 + mu1*%d)*%s == lambda1*%s + mu2*%s + mu1*(%d+1)*%s",
                    i, pi(i, 0), pi(i - 1, 0), pi(i, 1), i, pi(i + 1, 0));
            this.writeEquationOnMATLABScript(eq);
        }

        // ********************************************************************************************** //

        for (int i = 1; i <= N - 1; i++) {
            eq = String.format("(lambda1 + lambda2 + mu2*%d)*%s == lambda2*%s + mu1*%s + mu2*(%d+1)*%s",
                    i, pi(0, i), pi(0, i - 1), pi(1, i), i, pi(0, i + 1));
            this.writeEquationOnMATLABScript(eq);
        }

        // ********************************************************************************************** //

        eq = String.format("N*mu1*%s == lambda1*%s", pi(N, 0), pi(N - 1, 0));
        this.writeEquationOnMATLABScript(eq);

        // ********************************************************************************************** //

        eq = String.format("N*mu2*%s == lambda2*%s", pi(0, N), pi(0, N - 1));
        this.writeEquationOnMATLABScript(eq);

        // ********************************************************************************************** //

        for (int i = 1; i <= N - 1; i++)
            for (int j = 1; j <= N - 1; j++)
                if (i + j == N) {
                    eq = String.format("(mu1*%d + mu2*%d)*%s == lambda1*%s + lambda2*%s",
                            i, j, pi(i, j), pi(i - 1, j), pi(i, j - 1));
                    this.writeEquationOnMATLABScript(eq);
                }

        // ********************************************************************************************** //

        for (int i = 1; i <= N - 1; i++)
            for (int j = 1; j <= N - 1; j++)
                if (i + j < N) {
                    eq = String.format("(lambda1 + lambda2 + mu1*%d + mu2*%d)*%s == lambda1*%s + lambda2*%s + mu1*(%d + 1)*%s + mu2*(%d+1)*%s",
                            i, j, pi(i, j), pi(i - 1, j), pi(i, j - 1), i, pi(i + 1, j), j, pi(i, j + 1));
                    this.writeEquationOnMATLABScript(eq);
                }
    }

    private void calculate_ALG_1_CloudletUtilization() throws IOException {

        this.MATLABScriptFile.write(String.format("\nALG_1_CloudletUtilization = 1 - solution.%s", pi(0, 0)));
        this.MATLABScriptFile.write(";\n");
    }

    private void calculate_ALG_1_SendJobToCloudProbability() throws IOException {

        this.MATLABScriptFile.write("ALG_1_SendJobToCloudProbability = 0");

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (i + j == N) {
                    this.MATLABScriptFile.write(String.format(" + solution.%s", pi(i, j)));
                }

        this.MATLABScriptFile.write(";\n");
    }
}
