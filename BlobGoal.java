package assignment3;

import java.awt.Color;

public class BlobGoal extends Goal{

	public BlobGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {
		Color[][] c=board.flatten();
		int s=0;
		int s_temp;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++){
				s_temp=this.undiscoveredBlobSize(i,j,c,new boolean[c.length][c.length]);
				if (s_temp>s){
					s=s_temp;
				}
			}
		}
		return s;
	}

	@Override
	public String description() {
		return "Create the largest connected blob of " + GameColors.colorToString(targetGoal)
				+ " blocks, anywhere within the block";
	}

	/*public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {
        if (i<0||j<0){
            throw new IllegalArgumentException("Invalid input");
        } else if (unitCells[i][j].equals(this.targetGoal) && visited[i][j]!=true){
            int s=1;
            visited[i][j] =true;
            if(i+1<unitCells.length){
                int n=this.undiscoveredBlobSize(i+1,j,unitCells,visited);
                if (n!=0){
                    s+=n ;
                }
            } else if (j+1<unitCells.length && this.undiscoveredBlobSize(i,j+1,unitCells,visited)!=0) {
                int n=this.undiscoveredBlobSize(i,j+1,unitCells,visited);
                s+=n;
            }
            return s;
        }
        return 0;*/
    /*public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {
		if (i<0||j<0){
			throw new IllegalArgumentException("Invalid input");
		} else if (unitCells[i][j].equals(this.targetGoal) && visited[i][j]!=true){
			int s=1;
			visited[i][j] =true;
			if(i+1<unitCells.length){
				int n=this.undiscoveredBlobSize(i+1,j,unitCells,visited);
				if (n!=0){
					s+=n ;
				}
			}
			if (j+1<unitCells.length && this.undiscoveredBlobSize(i,j+1,unitCells,visited)!=0) {
				int n=this.undiscoveredBlobSize(i,j+1,unitCells,visited);
				s+=n;
			}
			return s;
		}
		return 0;*/
    /*public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {
		if (i<0||j<0){
			throw new IllegalArgumentException("Invalid input");
		} else if (unitCells[i][j].equals(this.targetGoal) && visited[i][j]!=true){
			int s=1;
			visited[i][j] =true;
			if(i+1<unitCells.length && this.undiscoveredBlobSize(i+1,j,unitCells,visited)!=0){
				s++ ;
			} else if (j+1<unitCells.length && this.undiscoveredBlobSize(i,j+1,unitCells,visited)!=0) {
				s++;
			}
			return s;
		}
		return 0;*/
	public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {
		if (i<0||j<0){
			throw new IllegalArgumentException("Invalid input");
		} else if (unitCells[i][j].equals(this.targetGoal) && visited[i][j]!=true){
			int s=1;
			visited[i][j] =true;
			if(i+1<unitCells.length){
				s+=this.undiscoveredBlobSize(i+1,j,unitCells,visited);
			}
			if(i-1>0){
				s+=this.undiscoveredBlobSize(i-1,j,unitCells,visited);
			}
			if(j-1>0){
				s+=this.undiscoveredBlobSize(i,j-1,unitCells,visited);
			}
			if (j+1<unitCells.length) {
				s+=this.undiscoveredBlobSize(i,j+1,unitCells,visited);
			}
			return s;
		}
		return 0;
	}

}
