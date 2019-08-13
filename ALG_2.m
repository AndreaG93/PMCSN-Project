
% System parameters...
% ----------------------------------------------------------------------- %

CLOUDLET_mu_class_1 = sym(0.45);
CLOUDLET_mu_class_2 = sym(0.27);

CLOUD_mu_class_1 = sym(0.25);
CLOUD_mu_class_2 = sym(0.22);

P_INTERRUPT = Class2JobInterruptionProbability * Class1JobSendToCloudletProbability;

CLOUDLET_LAMBDA_CLASS_1 = lambda1 * Class1JobSendToCloudletProbability;
CLOUDLET_LAMBDA_CLASS_2 = lambda2 * Class2JobSendToCloudletProbability;

CLOUD_LAMBDA_CLASS_1 = lambda1 * Class1JobSendToCloudProbability;
CLOUD_LAMBDA_CLASS_2 = lambda2 * Class2JobSendToCloudProbability + CLOUDLET_LAMBDA_CLASS_2 * P_INTERRUPT;

% THROUGHPUT

CLOUDLET_THROUGHPUT_CLASS_1 = CLOUDLET_LAMBDA_CLASS_1;
CLOUDLET_THROUGHPUT_CLASS_2 = CLOUDLET_LAMBDA_CLASS_2 - CLOUDLET_LAMBDA_CLASS_2 * P_INTERRUPT;
CLOUDLET_THROUGHPUT = CLOUDLET_THROUGHPUT_CLASS_1 + CLOUDLET_THROUGHPUT_CLASS_2;

CLOUD_THROUGHPUT_CLASS_1 = CLOUD_LAMBDA_CLASS_1;
CLOUD_THROUGHPUT_CLASS_2 = CLOUD_LAMBDA_CLASS_2;
CLOUD_THROUGHPUT = CLOUD_THROUGHPUT_CLASS_1 + CLOUD_THROUGHPUT_CLASS_2;

% POPULATION

CLOUDLET_POPULATION_CLASS_1 = AverageNumberOfClass1JobCloudlet;
CLOUDLET_POPULATION_CLASS_2 = AverageNumberOfClass2JobCloudlet;
CLOUDLET_POPULATION = CLOUDLET_POPULATION_CLASS_1 + CLOUDLET_POPULATION_CLASS_2;

CLOUD_POPULATION_CLASS_1 = CLOUD_LAMBDA_CLASS_1 / CLOUD_mu_class_1;
CLOUD_POPULATION_CLASS_2 = CLOUD_LAMBDA_CLASS_2 / CLOUD_mu_class_2;
CLOUD_POPULATION = CLOUD_POPULATION_CLASS_1 + CLOUD_POPULATION_CLASS_2;

GLOBAL_POPULATION_CLASS_1 = CLOUDLET_POPULATION_CLASS_1 + CLOUD_POPULATION_CLASS_1;
GLOBAL_POPULATION_CLASS_2 = CLOUDLET_POPULATION_CLASS_2 + CLOUD_POPULATION_CLASS_2;
GLOBAL_POPULATION_CLASS = GLOBAL_POPULATION_CLASS_1 + GLOBAL_POPULATION_CLASS_2;

CLOUDLET_SERVICE_TIME = sym(CLOUDLET_mu_class_1^(-1))*(CLOUDLET_LAMBDA_CLASS_1)/(CLOUDLET_LAMBDA_CLASS_1+CLOUDLET_LAMBDA_CLASS_2) + sym(CLOUDLET_mu_class_2^(-1))*(CLOUDLET_LAMBDA_CLASS_2)/(CLOUDLET_LAMBDA_CLASS_1+CLOUDLET_LAMBDA_CLASS_2);
CLOUD_SERVICE_TIME = sym(CLOUD_mu_class_1^(-1))*(CLOUD_LAMBDA_CLASS_1)/(CLOUD_LAMBDA_CLASS_1+CLOUD_LAMBDA_CLASS_2) + sym(CLOUD_mu_class_2^(-1))*(CLOUD_LAMBDA_CLASS_2)/(CLOUD_LAMBDA_CLASS_1+CLOUD_LAMBDA_CLASS_2);

GLOBAL_SERVICE_TIME_CLASS_1 = Class1JobSendToCloudletProbability * sym(CLOUDLET_mu_class_1^(-1)) + Class1JobSendToCloudProbability * sym(CLOUD_mu_class_1^(-1));
GLOBAL_SERVICE_TIME_CLASS_2 = Class2JobSendToCloudletProbability * ( P_INTERRUPT * (0.8 + sym(CLOUD_mu_class_2^(-1))) + (1 - P_INTERRUPT)*sym(CLOUDLET_mu_class_2^(-1))) + Class2JobSendToCloudProbability*sym(CLOUDLET_mu_class_2^(-1));
GLOBAL_SERVICE_TIME = GLOBAL_SERVICE_TIME_CLASS_1*(lambda1)/(lambda1+lambda2) + GLOBAL_SERVICE_TIME_CLASS_2*(lambda2)/(lambda1+lambda2);

GLOBAL_SERVICE_TIME_INTERR_CLASS_2 = 0.8 + sym(CLOUD_mu_class_2^(-1)) + 0.649*sym(CLOUDLET_mu_class_2^(-1));

