package Trees;

public class TreeType implements Tree {
	private String name;
	private String color;
	private String texture;

	public TreeType(String name, String color, String texture) {
		this.name = name;
		this.color = color;
		this.texture = texture;
	}

	@Override
	public void display(int x, int y) {
		System.out.println("Displaying " + name + " Tree [Color: " + color + ", Texture: " + texture + ", x: " + x
				+ ", y: " + y + "]");
	}

	@Override
	public String toString() {
		return "TreeType [name=" + name + ", color=" + color + ", texture=" + texture + "]";
	}
}
