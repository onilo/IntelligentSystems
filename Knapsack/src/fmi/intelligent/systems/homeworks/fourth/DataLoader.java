package fmi.intelligent.systems.homeworks.fourth;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

class DataLoader {
	/**
	 * Count of all items.
	 */
	private static int itemsCount;

	/**
	 * List with all values.
	 */
	private static List<Integer> values;

	/**
	 * List with all weights.
	 */
	private static List<Integer> weights;

	/**
	 * Private constructor - not to be instantiate.
	 */
	private DataLoader() {

	}

	/**
	 * Load data from text file in weights and values lists.
	 */
	static void loadData() {
		values = new ArrayList<>();
		weights = new ArrayList<>();

		Path path = Paths.get("src/fmi/intelligent/systems/homeworks/fourth/resources/testData.txt");

		try {
			Files.lines(path).forEach(
					line -> {
						String[] l = line.split(" ");

						values.add(Integer.parseInt(l[0]));
						weights.add(Integer.parseInt(l[1]));
					}
			);
		} catch (IOException e) {
			e.printStackTrace();
		}

		itemsCount = values.size();
	}

	static List<Integer> getValues() {
		return values;
	}

	static List<Integer> getWeights() {
		return weights;
	}

	static int getItemsCount() {
		return itemsCount;
	}
}
