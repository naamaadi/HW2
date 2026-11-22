package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	// TODO: add the fields:
	//       - an array of Collectibles (it may be larger than the number of items actually stored)
	//       - an int that counts how many items are actually stored
	private Collectible[] items;
	private int cSize;


	public NaiveInventory() {
		// TODO: implement
		this.items = new Collectible[INITIAL_CAPACITY];
		this.cSize = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		// TODO: implement
		if (this.cSize == this.items.length){
			int newCap = this.items.length * 2;
			Collectible[] doubleSize = new Collectible[newCap];
			for (int i = 0; i < this.cSize; i++){
				doubleSize[i] = this.items[i];
			}
			this.items = doubleSize;
		}
		this.items[this.cSize] = collectible;
		this.cSize++;
	}

	@Override
	public float getTotalWeight() {
		float weightSum = 0;
		for (int i = 0; i < this.cSize; i++){
			if (this.items[i] != null){
				weightSum += this.items[i].getWeight();
			}
		}
		return weightSum;
	}

	@Override
	public int getCurrentCount() {
		return this.cSize;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return this.items;
	}
}
