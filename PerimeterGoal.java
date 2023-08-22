package assignment3;

import java.awt.Color;

public class PerimeterGoal extends Goal{

	public PerimeterGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {
		if (board.getMaxDepth() ==0){
			throw new IllegalArgumentException("Can't score unit cell");
		}
		Color[][] c=board.flatten();
		int s=0;
        for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if ((i==0 ||i==c.length-1 || j==0||j==c.length-1)) {
					if (c[i][j].equals(this.targetGoal)) {
						if ((i == 0 && j == 0) || (i == 0 && j == c.length-1) || (i == c.length-1 && j == 0) || (i == c.length-1 && j == c.length-1)) {
							s += 2;
						} else {
							s++;
						}
					}
				}
			}
		}
		return s;
	}
	/*private int score_arr(Color[] c){
		int s=0;
		for (int i = 0; i < c.length; i++) {
			if(c[i].equals(this.targetGoal)){
				if (i == 0 || i == c.length - 1) {
					s+=2;
				}
				else{
					s++;
				}
			}
		}
		return s;
	}

	@Override
	public int score(Block board) {
		if (board.getMaxDepth() ==0){
			throw new IllegalArgumentException("Can't score unit cell");
		}
		Color[][] c=board.flatten();
		int s=0;
        s+= score_arr(c[0]);
		s+= score_arr(c[c.length-1]);

        *//*for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if (c[i][j].equals(this.targetGoal)){
					if ((i==0 && j==0) || (i==0 && j==c.length)||(i==c.length && j==0)||(i==c.length && j==c.length)){
						s+=2;
					}
					else{
						s++;
					}
				}

			}
		}*//*
		return s;
	}*/

	@Override
	public String description() {
		return "Place the highest number of " + GameColors.colorToString(targetGoal)
				+ " unit cells along the outer perimeter of the board. Corner cell count twice toward the final score!";
	}

}
