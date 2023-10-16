package Trees;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
	// Hashmap to store tree data
	private static final Map<String, TreeType> treeTypes = new HashMap<String, TreeType>();
	public static TreeType getTreeType(String name, String color, String texture) {

		TreeType treeType = treeTypes.get(name);

		// check if tree already exists
		if (treeType == null) {
			treeType = new TreeType(name, color, texture);
			treeTypes.put(name, treeType);
			System.out.print("\n\u001B[36m" + "New Tree created:\n" + treeType + "\u001B[0m\n\n");
		}

		return treeType;
	}
}
