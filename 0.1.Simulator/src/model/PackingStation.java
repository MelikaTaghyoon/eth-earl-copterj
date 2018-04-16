//seems good, no need to make edits? Dawid

package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PackingStation extends Entity {

	private Order currentOrder;
	private HashSet<String> requestedItems;
	private ArrayList<Robot> robots;


	public PackingStation(String ID, Location loc) {
		super(ID, loc);
		robots = new ArrayList<Robot>();
		requestedItems = new HashSet<String>();
	}

	@Override
	public void act(Grid grid, List<Order> orders) {
		// check if it has an order
		if (currentOrder != null) {
			//if so, see what needs to happen to it
			if (currentOrder.requiredItems().isEmpty()) {
				//the order has all of the items needed, pack/dispatch
				if (currentOrder.progress()) {
					//if order is complete, remove order
					currentOrder = null;
				}
			} else {//needs items brought to it

				// use unrequested items to ask robots for those items
				HashSet<String> items = new HashSet<String>();
				items.addAll(currentOrder.requiredItems());
				items.removeAll(requestedItems);
				requestItems(items, grid);

				//Check if there is a robot in its location that has the item
				Robot r = grid.getRobot(location);
				if (r != null ) {
					if (r.hasItem(requestedItems)){
						String collectedItem = r.carriedItem();
						currentOrder.itemGained(collectedItem);
						requestedItems.remove(collectedItem);
					}
				}

			}
		} else {//needs a new order
			currentOrder = orders.get(0);
			orders.remove(0);
			//ask sim for a new order
		}
	}

	/**
	 * Informs the packing station of a robot within the simulation
	 *
	 * @param robot A robot that exists within the simulation
	 */
	public void addRobot(Robot robot) {
		robots.add(robot);
	}

	private void requestItems(HashSet<String> items, Grid grid) {
		//Change to do per item rather than per robot
		for (Robot r : robots) {
			if (r.getStatus().equals("ready")) {
				for (String item : items) {
					if (r.takeJob(item, grid, location)) {
						requestedItems.add(item);
						break;
					}
				}
			}
		}
	}




}
