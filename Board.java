import java.util.List;
public class Board {
  private int dimi;
  private int dimj;
  private int dimLi;
  private int dimLj;
  char[][] b;
  char[][] bL;
  List<String> bl;
  
  public Board(int i, int j){
    dimi = i;
    dimj = j;
    dimLi = i + 2;
    dimLj = j + 2;
    b = new char[dimi][dimj];
    bL = new char[dimLi][dimLj];
    initBoards();
  }
  
  private void initBoards(){
    for(int i = 0; i < dimLi; i++){
      for(int j = 0; j < dimLj; j++){
        if(i>0 && j>0 && i<dimLi-1 && j<dimLj-1)
        b[i-1][j-1] = ' ';
        bL[i][j] = ' ';
      }
    }
  }
  
  public void addMine(int x, int y){
    b[x][y] = '*';
  }
  
  public void addMines(int[][] coords){
    for(int i=0; i<coords.length; i++){
      addMine(coords[i][0], coords[i][1]);
    }
  }
  
  @Override
  public String toString(){
    String tmp = "";
    String t2 ="+";
    for(int k=0; k<b[0].length; k++){
      t2 += "-";
    }
    t2 += "+";
    tmp += t2 + "\n";
    for(int i = 0; i<b.length;i++){
      tmp += "|";
      for(int j=0; j<b[0].length;j++){
        String eol = j==b[0].length - 1?"|\n":"";
        tmp += ("" + b[i][j] + eol);
        
      }
    }
    tmp += t2 + "\n";
    return tmp;
  }
}
