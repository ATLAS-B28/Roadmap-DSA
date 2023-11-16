package array_string;
public class LeetcodeMatrix {
    public int countBattleShips(char[][] board) {
        int m = board.length;
        int n =board[0].length;
        int count = 0;
        for(int i =0;i < m; i++){
            for(int j = 0;j < n; j++){
                if(board[i][j]=='X') {
                    if ((i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        LeetcodeMatrix l = new LeetcodeMatrix();
        char[][] board = {
                {'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}
        };
        System.out.println(l.countBattleShips(board));

    }
}
