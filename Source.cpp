#include<iostream>
#include<stdio.h>
#include<conio.h>
#include <memory>

using namespace std;

class matrix{
	int matrix1[2][2],matrix2[2][2];
	int result[2][2];
	int *pt, *pt1, *pt2;

	//iterative multiplication
public:


	void initialize()
	{
	
		for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
		{
			result[i][j] = 0;
			matrix1[i][j] = j;
				matrix2[i][j] = j;
		}
		
	
	}
	void multiply()
	{

		pt = &matrix1[0][0];
		pt1 = &matrix2[0][0];
		pt2 = &result[0][0];
		for (int i = 0; i<2; i++)
		{
			for (int k = 0; k<2; k++)
			{
				*(pt2 + (i * 10 + k)) = 0;
				for (int j = 0; j<2; j++)
				{
					*(pt2 + (i * 10 + k)) += *(pt + (i * 10 + j))**(pt1 + (j * 10 + k));
				}
			}
		}
		for (int i = 0; i<2; i++)
		{
			for (int j = 0; j<2; j++)
			{
				printf("%d ", result[i][j]);
			}
			printf("\n");
		}
		//return 0;
	}
		
		/*int temp = 0;
		for (int i = 0; i < 2; i++)
		{

			for (int j = 0; j < 2; j++)
			{
				for (int k = 0; k < 2; k++)
					temp += matrix1[i][k] * matrix2[k][j];
				result[i][j] = temp;

			}
		}*/

	




	void algo()
	{
		int t1, t2, t3, t4, t5, t6, t7;

		t1 = matrix1[0][0] * (matrix2[0][1] - matrix2[1][1]);
		t2 = (matrix1[0][0] + matrix1[0][1])*matrix2[1][1];
		t3 = (matrix1[1][0] + matrix1[1][1])*matrix2[0][0];
		t4 = matrix1[1][1] * (matrix2[1][0] - matrix2[0][0]);
		t5 = (matrix1[0][0] + matrix1[1][1])*(matrix2[0][0] + matrix2[1][1]);
		t6 = (matrix1[0][1] - matrix1[1][1])*(matrix2[1][0] + matrix2[1][1]);
		t7 = (matrix1[0][0] - matrix1[1][0])*(matrix2[0][0] + matrix2[0][1]);
	
		result[0][0] = t5 + t4 + -t2 + t6;
		result[0][1] = t1 + t2;
		result[1][0] = t3 + t4;
		result[1][1] = t1 + t5 - t3 - t7;


	}


	//printing

	void print(){

		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
				cout << result[i][j]<<" ";
			cout << "\n";
		}

	}


};


int main(void)
{
	matrix m;
	m.initialize();
    m.print();
	m.multiply();
	m.print();
	m.algo();
	m.print();
	_getch();
	return 0;

}