import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int map[][] = new int[100][100];
        
		for(int i=0; i<10; i++) {
            int n = Integer.parseInt(br.readLine());
            int max = 0;
            int sumRow = 0;
            int sumCol = 0;
            int sum1 = 0;
            int sum2 = 0;
            for(int j=0; j<100; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<100; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int a=0; a<100; a++) {
                int curSumRow = 0;
                for(int b=0; b<100; b++) {
                    curSumRow += map[a][b];
                }
                sumRow = Math.max(sumRow, curSumRow);
            }
            
            for(int a=0; a<100; a++) {
                int curSumCol = 0;
                for(int b=0; b<100; b++) {
                    curSumCol += map[b][a];
                }
                sumCol = Math.max(sumCol, curSumCol);
            }
            
            for(int a=0; a<100; a++) {
                sum1 += map[a][a];
            }
            
            int x=0;
            int y=99;
            for(int a=0; a<100; a++) {             
                sum2 += map[x][y];
                x++;
                y--;
            }
            
            max = Math.max(sumRow, Math.max(sumCol, Math.max(sum1, sum2)));
            sb.append("#").append(n).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
	}
}