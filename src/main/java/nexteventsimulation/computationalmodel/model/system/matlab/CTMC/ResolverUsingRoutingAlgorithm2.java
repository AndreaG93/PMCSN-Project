package nexteventsimulation.computationalmodel.model.system.matlab.CTMC;

import java.io.FileWriter;
import java.io.IOException;

public class ResolverUsingRoutingAlgorithm2 extends CTMCResolverScriptGenerator {

    public void startScriptGeneration() {

        try {

            this.MATLABScriptFile = new FileWriter("MATLAB_ALG2_CTMC_ResolverScript.m");

            this.writeCTMCResolutionCommandsOnMATLABScript();
            this.writeAverageNumberOfJobCloudletComputationCommandsOnMATLABScript(1);
            this.writeAverageNumberOfJobCloudletComputationCommandsOnMATLABScript(2);

            writeOnMATLABScript_Class1JobSendToCloudletProbability();

            writeOnMATLABScript_Class1JobSendToCloudProbability();

            writeOnMATLABScript_Class2JobInterruptionProbability();

            writeOnMATLABScript_Class2JobSendToCloudProbability();

            writeOnMATLABScript_Class2JobSendToCloudletProbability();

            this.MATLABScriptFile.close();

        } catch (IOException e) {
            System.exit(1);
        }
    }

    @Override
    protected void MATLABVariablesInit() {

        for (int n1 = 0; n1 <= S; n1++) {

            for (int n2 = 0; n2 <= S; n2++) {

                if (n1 + n2 <= S) {
                    this.MATLABVariables.put(String.format("pi(%d,%d)", n1, n2), String.format("x%d", this.numberOfMATLABVariables));
                    this.numberOfMATLABVariables++;
                }
            }
        }

        for (int n1 = S + 1; n1 <= N; n1++) {

            this.MATLABVariables.put(String.format("pi(%d,%d)", n1, 0), String.format("x%d", this.numberOfMATLABVariables));
            this.numberOfMATLABVariables++;
        }
    }

    @Override
    protected void writeBalanceEquations() throws IOException {

        String eq;

        eq = String.format("(lambda1 + lambda2)*%s == mu1*%s + mu2*%s", pi(0, 0), pi(1, 0), pi(0, 1));
        this.writeEquationOnMATLABScript(eq);

        // ********************************************************************************************** //

        for (int i = 1; i <= S - 1; i++) {
            eq = String.format("(lambda1 + lambda2 + mu1*%d)*%s == lambda1*%s + mu2*%s + mu1*(%d+1)*%s",
                    i, pi(i, 0), pi(i - 1, 0), pi(i, 1), i, pi(i + 1, 0));
            this.writeEquationOnMATLABScript(eq);
        }

        // ********************************************************************************************** //

        for (int i = 1; i <= S - 1; i++) {
            eq = String.format("(lambda1 + lambda2 + mu2*%d)*%s == lambda2*%s + mu1*%s + mu2*(%d+1)*%s",
                    i, pi(0, i), pi(0, i - 1), pi(1, i), i, pi(0, i + 1));
            this.writeEquationOnMATLABScript(eq);
        }

        // ********************************************************************************************** //

        if (S < N)
            eq = String.format("(S*mu1+lambda1)*%s == lambda1*%s + lambda1*%s + mu1*(S+1)*%s",
                    pi(S, 0), pi(S - 1, 0), pi(S - 1, 1), pi(S + 1, 0));
        else
            eq = String.format("(S*mu1)*%s == lambda1*%s + lambda1*%s",
                    pi(S, 0), pi(S - 1, 0), pi(S - 1, 1));
        this.writeEquationOnMATLABScript(eq);

        // ********************************************************************************************** //

        eq = String.format("(S*mu2 + lambda1)*%s == lambda2*%s", pi(0, S), pi(0, S - 1));
        this.writeEquationOnMATLABScript(eq);

        // ********************************************************************************************** //

        for (int i = 1; i <= S - 1; i++)
            for (int j = 1; j <= S - 1; j++)
                if (i + j == S) {
                    eq = String.format("(mu1*%d + mu2*%d + lambda1)*%s == lambda1*%s + lambda1*%s + lambda2*%s",
                            i, j, pi(i, j), pi(i - 1, j + 1), pi(i - 1, j), pi(i, j - 1));
                    this.writeEquationOnMATLABScript(eq);
                }

        // ********************************************************************************************** //

        for (int i = 1; i <= S - 1; i++)
            for (int j = 1; j <= S - 1; j++)
                if (i + j < S) {
                    eq = String.format("(lambda1 + lambda2 + mu1*%d + mu2*%d)*%s == lambda1*%s + lambda2*%s + mu1*(%d + 1)*%s + mu2*(%d+1)*%s",
                            i, j, pi(i, j), pi(i - 1, j), pi(i, j - 1), i, pi(i + 1, j), j, pi(i, j + 1));
                    this.writeEquationOnMATLABScript(eq);
                }

        // ********************************************************************************************** //

        for (int i = S + 1; i <= N - 1; i++) {
            eq = String.format("(lambda1 + mu1*%d)*%s == mu1*(%d + 1)*%s + lambda1*%s",
                    i, pi(i, 0), i, pi(i + 1, 0), pi(i - 1, 0));
            this.writeEquationOnMATLABScript(eq);
        }

        // ********************************************************************************************** //

        if (S < N) {
            eq = String.format("(mu1*N)*%s == lambda1*%s",
                    pi(N, 0), pi(N - 1, 0));
            this.writeEquationOnMATLABScript(eq);
        }
    }


    private void writeOnMATLABScript_Class1JobSendToCloudProbability() throws IOException {
        this.MATLABScriptFile.write(String.format("Class1JobSendToCloudProbability = solution.%s;\n", pi(N, 0)));
    }

    private void writeOnMATLABScript_Class1JobSendToCloudletProbability() throws IOException {
        this.MATLABScriptFile.write(String.format("Class1JobSendToCloudletProbability = 1 - solution.%s;\n", pi(N, 0)));
    }

    private void writeOnMATLABScript_Class2JobSendToCloudProbability() throws IOException {

        this.MATLABScriptFile.write("Class2JobSendToCloudProbability = 0");

        for (int n1 = 0; n1 <= N; n1++)
            for (int n2 = 0; n2 <= N; n2++) {

                if (n1 + n2 == S) {
                    this.MATLABScriptFile.write(String.format(" + solution.%s", pi(n1, n2)));
                }

                if (n2 == 0 && n1 >= S + 1) {
                    this.MATLABScriptFile.write(String.format(" + solution.%s", pi(n1, n2)));
                }
            }
        this.MATLABScriptFile.write(";\n");
    }

    private void writeOnMATLABScript_Class2JobSendToCloudletProbability() throws IOException {

        this.MATLABScriptFile.write("Class2JobSendToCloudletProbability = 1 - Class2JobSendToCloudProbability\n;");
    }

    private void writeOnMATLABScript_Class2JobInterruptionProbability() throws IOException {

        this.MATLABScriptFile.write("Class2JobInterruptionProbability = 0 ");

        for (int n1 = 0; n1 <= S - 1; n1++)
            for (int n2 = 1; n2 <= S; n2++)
                if (n1 + n2 == S) {
                    this.MATLABScriptFile.write(String.format(" + solution.%s", pi(n1, n2)));
                }

        this.MATLABScriptFile.write(";\n");
    }
}
