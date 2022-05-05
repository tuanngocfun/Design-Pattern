package PrototypeDesignPattern;


import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {
    protected static Map<String, Shape> CACHE = new HashMap<String, Shape>();

	public static Shape getByType(String type) {
		return CACHE.get(type);
	}

	public static void addShape(Shape shape) throws CloneNotSupportedException {
		CACHE.put(shape.type(), shape.clone());
	}
}
