package Array;

public class GameOflife {
	 /*
    ����һ�� two bits ��״̬������¼ϸ��״̬, ��һλ��ʾ
    ��һ״̬, �ڶ�λ��ʾ��ǰ״̬:
    00: dead (next state) <- dead (current state)
    01: dead (next state) <- live (current state) 
    10: live (next state) <- dead (current state)
    11: live (next state) <- live (current state) 
    ��ʼ�����Ӧ���� 00 �� 01 (Ĭ����һ״̬�� dead state)
    ͳ��ÿ��λ����Χ�� live ϸ����������λ�� 1 (live)���� 
    0 (dead), �������һλ��Ϊ����״̬, ע�ⲻ��Ҫ���� 01
    �Լ� 00 �����, ��Ϊ�Ѿ�Ĭ����һ״̬Ϊ dead.
    */
	public void gameOfLife(int[][] board) {
       
        if(board.length < 1) return;
        // ���¾���
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                int lives = countLives(board, i, j);
                // live -> live
                if((board[i][j] & 1) == 1) {
                    if(lives >= 2 && lives <= 3)
                        board[i][j] = 3;
                }
                // dead -> live
                else {
                    if(lives == 3)
                        board[i][j] = 2;
                }
            }
        }
        // ���þ���
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) 
                board[i][j] >>= 1;
        }
    }
    
    private int countLives(int[][] b, int i, int j) {
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};   
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x > b.length-1 || y < 0 || y > b[0].length-1)
                continue;
            count += (b[x][y] & 1);
        }
        return count;
    }
}
