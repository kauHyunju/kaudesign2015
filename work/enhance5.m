function [ne] = enhance5( n )

[r,c]=size(n);

e = 2.71828182846;
a =7;

for i=1:r
    for j=1:c
        if n(i,j)>=0
            ne(i,j) = e^( (-0.5*n(i,j)*n(i,j)) / (a*a)  );
        else
            ne(i,j) = -e^( (-0.5*n(i,j)*n(i,j)) / (a*a)  );
        end
    end
end