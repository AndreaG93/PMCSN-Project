set(0,'DefaultFigureVisible','off')
folder  = 'C:\Users\Andrea\IdeaProjects\PMCSN-Project\SimulationOutputUsingRoutingAlgorithm1';
list    = dir(fullfile(folder, '*.m'));
nFile   = length(list);
success = false(1, nFile);
for k = 1:nFile
  file = list(k).name;
  try
    run(fullfile(folder, file));
    success(k) = true;
  catch
    fprintf('failed: %s\n', file);
  end
end