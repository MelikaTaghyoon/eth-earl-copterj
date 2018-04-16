package model;

import java.util.HashSet;

/**
 * Represents a single order for an automated warehouse
 *
 * @author Nathan32
 * 
 * TODO: does anything need to be added? it seems fully functional to me
 *
 */
public class Order {

	private int packingTime;
	private HashSet<String> shelfUIDs;
	private String status;

	public Order(int pt, HashSet<String> SUIDs) {
		packingTime = pt;
		shelfUIDs = SUIDs;
		status = "unassigned";
	}

	public String getStatus() {
		return status;
	}

	/**
	 * Tells the order that it has now been assigned
	 *
	 */
	public void assignOrder() {
		status = "assigned";
	}

	/**
	 * gets a HashSet with the required items for the order
	 *
	 * @return IDs of shelves that are needed
	 */
	public HashSet<String> requiredItems(){
		return shelfUIDs;
	}

	/**
	 * Gets the order to progress one step, and see if it has been packed
	 *
	 * @return true if item has finished, false if it still needs packing time
	 */
	public boolean progress() {
		packingTime--;
		if (packingTime == 0) {
			status = "dispatched";
			return true;
		}
		return false;
	}

	/**
	 * Removes an item from the set of required items
	 *
	 * @param collectedItem shelfID that the item has been "collected" from
	 */
	public void itemGained(String collectedItem) {
		shelfUIDs.remove(collectedItem);
	}

	public String toString(){
		String str = "Shelf: ";
		for (String string : shelfUIDs) {
			str+= string + ", ";
		}
		str += "Status: " + status;
		str += "Packing Time: " + packingTime;

		return str;
	}
}
