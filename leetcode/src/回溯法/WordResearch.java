package ���ݷ�;

public class WordResearch {
	public boolean exist(char[][] board, String word) {
		final int m = board.length;
		final int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (dfs(board, word, 0, i, j, visited))
					return true;
			return false;
		}
		private static boolean dfs(char[][] board, String word,
		int index, int x, int y, boolean[][] visited) {
		if (index == word.length())
			return true; // ��������
		
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
			return false; // Խ�磬��ֹ����
		
		if (visited[x][y]) return false; // �Ѿ����ʹ�����֦
		
		if (board[x][y] != word.charAt(index)) return false; // ����ȣ���֦
		
		visited[x][y] = true;
		boolean ret = dfs(board, word, index + 1, x - 1, y, visited) || // ��
				dfs(board, word, index + 1, x + 1, y, visited) || // ��
				dfs(board, word, index + 1, x, y - 1, visited) || // ��
				dfs(board, word, index + 1, x, y + 1, visited); // ��
		visited[x][y] = false;
		return ret;
		}
}
