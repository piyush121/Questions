/*https://leetcode.com/problems/number-of-islands/*/
import java.util.HashSet;
public class NumberOfIslands
{
    public static void main(String args[])
    {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};
        NumberOfIslands n = new NumberOfIslands();
        System.out.println(n.numIslands(grid));
        grid = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(n.numIslands(grid));
        grid = new char[][]{{'1', '1', '1'},
                            {'0', '1', '0'},
                            {'1', '1', '1'}};
        System.out.println(n.numIslands(grid));
    }

    public int numIslands(char[][] grid)
    {
        HashSet<Pair<Integer, Integer>> global = new HashSet<Pair<Integer, Integer>>();
        int count = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i,j);
                if(!global.contains(pair) && grid[i][j]!='0')
                {
                    findComponents(i, j, global, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void findComponents(int row, int col, HashSet<Pair<Integer,Integer>> global, char[][] grid)
    {
        if(row<grid.length && row > -1
            && col<grid[0].length && col > -1
            && grid[row][col]=='1'
            && !global.contains(new Pair<Integer, Integer>(row, col)))
        {
            global.add(new Pair<Integer, Integer>(row, col));
            findComponents(row-1, col, global, grid);
            findComponents(row+1, col, global, grid);
            findComponents(row, col-1, global, grid);
            findComponents(row, col+1, global, grid);
        }
        return;
    }
}


class Pair<L,R>
{
    public final L left;
    public final R right;

    public Pair(L left, R right)
    {
        this.left = left;
        this.right = right;
    }

  public L getLeft()
  {
      return this.left;
  }

  public R getRight()
  {
      return this.right;
  }

  @Override
  public String toString()
  {
      return "Pair [left=" + this.left + ", right=" + this.right + "]";
  }

  @Override
  public int hashCode()
  {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.left == null) ? 0 : this.left.hashCode());
      result = prime * result + ((this.right == null) ? 0 : this.right.hashCode());
      return result;
  }

  @Override
  public boolean equals(Object obj)
  {
      if (this == obj)
      {
          return true;
      }
      if (obj == null)
      {
          return false;
      }
      if (getClass() != obj.getClass())
      {
          return false;
      }
      @SuppressWarnings("rawtypes")
      Pair other = (Pair) obj;
      if (this.left == null)
      {
          if (other.left != null)
          {
              return false;
          }
      }
      else if (!this.left.equals(other.left))
      {
          return false;
      }
      if (this.right == null)
      {
          if (other.right != null)
          {
              return false;
          }
      }
      else if (!this.right.equals(other.right))
      {
          return false;
      }
      return true;
    }
}
