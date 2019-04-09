package nexteventsimulation.computationalmodel.model.system;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class System_MATLAB_MarkovChainResolverScriptGenerator {

    private Map<String, String> MATLABVariables = new HashMap<String, String>();
    private final int N = 20;

    private String pi(int n1, int n2) {
        return MATLABVariables.get(String.format("pi(%d,%d)", n1, n2));
    }

    private FileWriter MATLABScriptFile;

    private int equationNumber = 1;
    private int numberOfMATLABVariables = 0;

    /**
     * This function is used to initialize an HashMap object used to contain correspondences between CTMC States and MATLAB variables.
     */
    private void initializationMapCTMCStateToMATLABVariables() throws IOException {

        FileWriter MATLABStateToVariablesFile = new FileWriter("./MATLAB_StateToVariables.txt");

        for (int n1 = 0; n1 <= N; n1++) {

            for (int n2 = 0; n2 <= N; n2++) {

                if (n1 + n2 <= 20) {
                    MATLABStateToVariablesFile.write(String.format("pi(%d,%d) --> x%d \n", n1, n2, this.numberOfMATLABVariables));
                    this.MATLABVariables.put(String.format("pi(%d,%d)", n1, n2), String.format("x%d", this.numberOfMATLABVariables));
                    this.numberOfMATLABVariables++;
                }
            }
        }

        MATLABStateToVariablesFile.close();
    }


    /**
     * This function is used to create, initialize and populate files containing generated MATLAB output script and
     */
    private void initializationOutputFiles() throws IOException {

        this.MATLABScriptFile = new FileWriter("./MATLAB_Script.m");

        initializationMapCTMCStateToMATLABVariables();

        // Writing...
        this.MATLABScriptFile.write("lamda1 = 4;\n");
        this.MATLABScriptFile.write("lamda2 = 6.25;\n");
        this.MATLABScriptFile.write("mu1 = 0.45;\n");
        this.MATLABScriptFile.write("mu2 = 0.27;\n");
        this.MATLABScriptFile.write(String.format("N = %d;\n", N));
        // Declaration MATLAB variables...
        this.MATLABScriptFile.write("syms ");

        for (int i = 0; i <= this.numberOfMATLABVariables; i++) {
            this.MATLABScriptFile.write(String.format("x%d ", i));
        }

        this.MATLABScriptFile.write("\n");
    }

    private void writeEquationOnOutputMATLABScript(String equation) throws IOException {

        this.MATLABScriptFile.write(String.format("eq%d = %s;\n", this.equationNumber, equation));
        this.equationNumber++;
    }

    private void buildEquations() throws IOException {

        String eq;

        // Sum of the probability of each state is equal to 1:
        this.MATLABScriptFile.write("eq0 = ");

        for (int i = 0; i <= this.numberOfMATLABVariables; i++) {
            this.MATLABScriptFile.write(String.format("x%d", i));

            if (i == this.numberOfMATLABVariables)
                this.MATLABScriptFile.write(" == 1\n");
            else
                this.MATLABScriptFile.write(" + ");

        }

        // Build equation (1)
        eq = String.format("(lamda1 + lamda2)*%s == mu1*%s + mu2*%s", pi(0, 0), pi(1, 0), pi(0, 1));
        this.writeEquationOnOutputMATLABScript(eq);

        // Build equations (2)
        for (int i = 1; i <= N - 1; i++) {
            eq = String.format("(lamda1 + lamda2 + mu1*%d)*%s == lamda1*%s + mu2*%s + mu1*(%d+1)*%s",
                    i, pi(i, 0), pi(i - 1, 0), pi(i, 1), i, pi(i + 1, 0));
            this.writeEquationOnOutputMATLABScript(eq);
        }

        // Build equations (3)
        for (int i = 1; i <= N - 1; i++) {
            eq = String.format("(lamda1 + lamda2 + mu2*%d)*%s == lamda2*%s + mu1*%s + mu2*(%d+1)*%s",
                    i, pi(0, i), pi(0, i - 1), pi(1, i), i, pi(0, i + 1));
            this.writeEquationOnOutputMATLABScript(eq);
        }

        // Build equation (4)
        eq = String.format("N*mu1*%s == lamda1*%s", pi(N, 0), pi(N - 1, 0));
        this.writeEquationOnOutputMATLABScript(eq);

        // Build equation (5)
        eq = String.format("N*mu2*%s == lamda2*%s", pi(0, N), pi(0, N - 1));
        this.writeEquationOnOutputMATLABScript(eq);

        // Build equation (6)
        for (int i = 1; i <= N - 1; i++)
            for (int j = 1; j <= N - 1; j++)
                if (i + j == N) {
                    eq = String.format("(mu1*%d + mu2*%d)*%s == lamda1*%s + lamda2*%s",
                            i, j, pi(i, j), pi(i - 1, j), pi(i, j - 1));
                    this.writeEquationOnOutputMATLABScript(eq);
                }

        // Build equation (7)
        for (int i = 1; i <= N - 1; i++)
            for (int j = 1; j <= N - 1; j++)
                if (i + j < N) {
                    eq = String.format("(lamda1 + lamda2 + mu1*%d + mu2*%d)*%s == lamda1*%s + lamda2*%s + mu1*(%d + 1)*%s + mu2*(%d+1)*%s",
                            i, j, pi(i, j), pi(i - 1, j), pi(i, j - 1), i, pi(i + 1, j), j, pi(i, j + 1));
                    this.writeEquationOnOutputMATLABScript(eq);
                }
    }

    private void writingLastPartMATLABScript() throws IOException {

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

    public void generateScript() {

        try {

            this.initializationOutputFiles();
            this.buildEquations();
            this.writingLastPartMATLABScript();
            this.calculate_ALG_1_SendJobToCloudProbability();
            this.calculate_ALG_1_AverageNumberOfJobCloudlet(1);
            this.calculate_ALG_1_AverageNumberOfJobCloudlet(2);

            this.MATLABScriptFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void calculate_ALG_1_AverageNumberOfJobCloudlet(int classNumber) throws IOException {

        this.MATLABScriptFile.write("\n");

        if (classNumber == 1)
            this.MATLABScriptFile.write("ALG_1_AverageNumberOfClass1JobCloudlet = 0");
        else
            this.MATLABScriptFile.write("ALG_1_AverageNumberOfClass2JobCloudlet = 0");

        for (int n1 = 0; n1 <= N; n1++)
            for (int n2 = 0; n2 <= N; n2++)
                if (pi(n1, n2) != null)
                    this.MATLABScriptFile.write(String.format(" + %d*solution.%s", (classNumber == 1) ? n1 : n2, pi(n1, n2)));

        this.MATLABScriptFile.write("\n");
    }

    private void calculate_ALG_1_SendJobToCloudProbability() throws IOException {

        this.MATLABScriptFile.write("ALG_1_SendJobToCloudProbability = 0");

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (i + j == N) {
                    this.MATLABScriptFile.write(String.format(" + solution.%s", pi(i, j)));
                }

        this.MATLABScriptFile.write("\n");
    }
}
