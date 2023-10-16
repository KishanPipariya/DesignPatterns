import Trees.*;

public class Main {
	private static final int CANVAS_SIZE = 500;
	private static final int TREES_TO_DRAW = 10;
	private static final int TREE_TYPES = 5;

	public static void main(String[] args) {

		// display trees until TREES_TO_DRAW
		for (int i = 0; i < TREES_TO_DRAW; i++) {

			// get random coordinates
			int x = (int) (Math.random() * CANVAS_SIZE);
			int y = (int) (Math.random() * CANVAS_SIZE);

			// specify intrinsic properties
			String name = "Tree " + (int) (Math.random() * TREE_TYPES);
			String color = "green";
			String texture = "leaves";

			// get a tree object from Factory
			TreeType treeType = TreeFactory.getTreeType(name, color, texture);

			// display the tree at given coordinates
			treeType.display(x, y);
		}
	}
}
