import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static boolean[][] air;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][4];
        air = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9){
                    air[i][j] = true;

                    for(int d=0; d<4; d++){
                        q.add(new int[]{i,j,d});
                        visited[i][j][d] = true;
                    }
                }
            }
        }

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

            air[nx][ny] = true;

            int nd = d;

            if(map[nx][ny]==1){
                if(d==2||d==3) continue;
            }
            else if(map[nx][ny]==2){
                if(d==0||d==1) continue;
            }
            else if(map[nx][ny]==3){
                if(d==0) nd=3;
                else if(d==1) nd=2;
                else if(d==2) nd=1;
                else nd=0;
            }
            else if(map[nx][ny]==4){
                if(d==0) nd=2;
                else if(d==1) nd=3;
                else if(d==2) nd=0;
                else nd=1;
            }

            if(!visited[nx][ny][nd]){
                visited[nx][ny][nd] = true;
                q.add(new int[]{nx,ny,nd});
            }
        }

        int answer = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(air[i][j]) answer++;
            }
        }

        System.out.println(answer);
    }
}