% System parameters...
% ----------------------------------------------------------------------- %

lambda_controller_class_1 = sym(4);
lambda_controller_class_2 = sym(6.25);

mu_cloudlet_class_1 = sym(0.45);
mu_cloudlet_class_2 = sym(0.27);
mu_cloud_class_1 = sym(0.25);
mu_cloud_class_2 = sym(0.22);

P_controller_to_cloud_class_1 = sym(87859436926256646517251117638424741393475341796875000000/212259113498085857520971393983611845585800622137044274729);   
P_controller_to_cloud_class_2 = sym(87859436926256646517251117638424741393475341796875000000/212259113498085857520971393983611845585800622137044274729);     

% Probabilities computation...
% ----------------------------------------------------------------------- %

P_controller_to_cloudlet_class_1 = sym(1 - P_controller_to_cloud_class_1);
P_controller_to_cloudlet_class_2 = sym(1 - P_controller_to_cloud_class_2);

% (CLOUDLET) Lambda computation...
% ----------------------------------------------------------------------- %

lambda_cloudlet_class_1 = sym(lambda_controller_class_1*P_controller_to_cloudlet_class_1);
lambda_cloudlet_class_2 = sym(lambda_controller_class_2*P_controller_to_cloudlet_class_2);

% (CLOUD) Lambda computation...
% ----------------------------------------------------------------------- %

lambda_cloud_class_1 = sym(lambda_controller_class_1*P_controller_to_cloud_class_1);
lambda_cloud_class_2 = sym(lambda_controller_class_2*P_controller_to_cloud_class_2);

% (CLOUDLET) Global Average Arrival Rate...
% ----------------------------------------------------------------------- %
lambda_cloudlet_global = sym(lambda_cloudlet_class_1 + lambda_cloudlet_class_2);
lambda_cloud_global = sym(lambda_cloud_class_1 + lambda_cloud_class_2);

% (CLOUDLET) Global Average Service Rate...
% ----------------------------------------------------------------------- %
mu_cloudlet_global = sym(mu_cloudlet_class_1 + mu_cloudlet_class_2);
mu_cloud_global = sym(mu_cloud_class_1 + mu_cloud_class_2);

% (CLOUDLET) Mean Service Times
% ----------------------------------------------------------------------- %
average_service_time_cloudlet_class_1 = sym(mu_cloudlet_class_1^(-1));
average_service_time_cloudlet_class_2 = sym(mu_cloudlet_class_2^(-1));
average_service_time_cloud_class_1 = sym(mu_cloud_class_1^(-1));
average_service_time_cloud_class_2 = sym(mu_cloud_class_2^(-1));

% Mean Response Time
% ----------------------------------------------------------------------- %

average_global_response_time_cloudlet = average_service_time_cloudlet_class_1*(lambda_cloudlet_class_1/(lambda_cloudlet_class_1 + lambda_cloudlet_class_2)) + average_service_time_cloudlet_class_2*(lambda_cloudlet_class_2/(lambda_cloudlet_class_1 + lambda_cloudlet_class_2));
average_global_response_time_cloud = average_service_time_cloud_class_1*(lambda_cloud_class_1/(lambda_cloud_class_1 + lambda_cloud_class_2)) + average_service_time_cloud_class_2*(lambda_cloud_class_2/(lambda_cloud_class_1 + lambda_cloud_class_2));


GLOBAL_class_1_response_time = P_controller_to_cloudlet_class_1*average_service_time_cloudlet_class_1 + P_controller_to_cloud_class_1*average_service_time_cloud_class_1;
GLOBAL_class_2_response_time = P_controller_to_cloudlet_class_2*average_service_time_cloudlet_class_2 + P_controller_to_cloud_class_2*average_service_time_cloud_class_2;

GLOBAL_response_time = GLOBAL_class_1_response_time*(lambda_controller_class_1/(lambda_controller_class_1 + lambda_controller_class_2)) + GLOBAL_class_2_response_time*(lambda_controller_class_2/(lambda_controller_class_1 + lambda_controller_class_2));


% (CLOUD) Time-Average Population
% ----------------------------------------------------------------------- %
cloud_time_average_class_1_population = lambda_cloud_class_1/mu_cloud_class_1;
cloud_time_average_class_2_population = lambda_cloud_class_2/mu_cloud_class_2;
cloud_time_average_population = cloud_time_average_class_1_population + cloud_time_average_class_2_population;

% Time-Average Population
% ----------------------------------------------------------------------- %
time_average_class_1_population = cloud_time_average_class_1_population + sym(1104598468206022474496767594370330477471953336910445636480/212259113498085857520971393983611845585800622137044274729);
time_average_class_2_population = cloud_time_average_class_2_population + sym(2876558510953183527335332277006068951749878481537618845000/212259113498085857520971393983611845585800622137044274729);
time_average_population = time_average_class_1_population + time_average_class_2_population;















