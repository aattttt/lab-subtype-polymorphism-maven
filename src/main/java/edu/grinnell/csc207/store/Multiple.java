package edu.grinnell.csc207.store;

/**
 * Items purchased in multiples.
 * 
 * @author A.J. Trimble
 * @author David William Stroud
 */
public class Multiple implements Purchase {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The name of the item.
   */
  String name;

  /**
   * A description of the item.
   */
  String description;

  /**
   * The cost per item (in cents).
   */
  int costPerItem;

  /**
   * The number of items.
   */
  int items;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new bunch of items.
   *
   * @param itemName
   *   The name of the item.
   *
   * @param itemDescription
   *   A desciption of the item.
   *
   * @param itemCost
   *   The cost per item.
   *
   * @param numItems
   *   The number of items
   */
  public Multiple(String itemName, String itemDescription, int itemCost,
      int numItems) {
    this.name = itemName;
    this.description = itemDescription;
    this.costPerItem = itemCost;
    this.items = numItems;
  } // Multiple(String, String, int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine the cost of this purchase.
   *
   * @return the cost in cents
   */
  public int cost() {
    return this.costPerItem * this.items;
  } // cost()

  /**
   * Convert to a string.
   *
   * @return the multiple as a string.
   */
  public String toString() {
    return String.format("%d %s (at $%s each)",
        this.items,
        this.items == 1 ? this.name : this.name + "s",
        StoreUtils.centsToDollars(this.costPerItem));
  } // toString()
} // class Multiple