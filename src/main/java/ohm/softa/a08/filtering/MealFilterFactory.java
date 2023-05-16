package ohm.softa.a08.filtering;

import java.util.HashMap;
import java.util.Map;

public abstract class MealFilterFactory {

	private static final Map<String, MealsFilter> filters = new HashMap<>();

	static {
		filters.put("All", new NoFilter());
		filters.put("Vegetarian", new CategoryFilter(true,"vegetarisch", "vegan"));
		filters.put("No pork", new CategoryFilter(false, "schwein"));
		filters.put("No soy", new NotesFilter("soja"));
	}

	private MealFilterFactory() {
	}

	public static MealsFilter getStrategy(String key) {
		return filters.getOrDefault(key, filters.get("All"));
	}
}
