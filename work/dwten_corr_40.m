
function [result] = dwten_corr_40(imgname, n, wavelet, m)

img_base_name = imgname; %% sb
imgNumber = 3;

for i = 1 : imgNumber
    in = num2str(i);
    img_real_name = strcat(img_base_name, in); %% sb1
    img_real_filename = strcat(img_real_name, '.jpeg'); %% sb
    
    dwten_result{i} = dwten( img_real_filename , n, wavelet, m );
end

for i = 1 : imgNumber
    for j = 1 : imgNumber
        result(i,j) = corr2( dwten_result{i}, dwten_result{j});
    end
end