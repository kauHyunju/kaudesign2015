function qr_spn_enhance5 = dwten(imgname, n, wavelet, m)

q = imread(imgname);

qr = im2double(rgb2gray(q));

%%%%%%% DWT %%%%%%%%%%%%%%%%%%%%%%%%%
[c,s] = wavefast(qr,n, wavelet);

[nc, y] = wavecut('a', c, s);

qr_dwt = abs(waveback(nc, s, wavelet));
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%% Denoising after DWT %%%%%%%%%%%%%%%%
dnc = nc;

[thr, sorh, keepapp] = ddencmp('den','wv',c);

dnc(find(abs(dnc)<(thr*m))) = 0 ;

qr_den_dwt = abs(waveback(dnc, s, wavelet));
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%% DWT - Denoising(DWT) %%%%%%%%%%%%%%%%

qr_edge = find(qr_den_dwt>0);

qr_edge = qr_edge';

qr_edge_length = length(qr_edge);

qr_dwt_size = size(qr_dwt);

qr_dwt_rowvector_size = (qr_dwt_size(1,1) * qr_dwt_size(1,2));

qr_dwt_row = qr_dwt(1:qr_dwt_rowvector_size);

for i = 1:qr_edge_length
    qr_dwt_row(qr_edge(i)) = 0;
end

qr_spn = reshape(qr_dwt_row, qr_dwt_size(1,1), qr_dwt_size(1,2));

%%%%%%%%%%%%%%%%%%%%%%% Enhance5 %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

qr_spn_enhance5 = enhance5(qr_spn);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%