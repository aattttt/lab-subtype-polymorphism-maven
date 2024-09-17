package edu.grinnell.csc207.blocks;

/**
 * The center-aligned horizontal composition of two blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class HorizontalCompositionCenter implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left block.
   */
  AsciiBlock left;

  /**
   * The right block.
   */
  AsciiBlock right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a Horizontal Composition.
   *
   * @param leftBlock
   *   The block on the left.
   *
   * @param rightBlock
   *   The block on the right.
   */
  public HorizontalCompositionCenter(AsciiBlock leftBlock, AsciiBlock rightBlock) {
    this.left = leftBlock;
    this.right = rightBlock;
  } // HorizontalCompositionCenter

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
      int difference = Math.abs((this.left.height() - this.right.height()));
      boolean rightBigger = ( this.right.height() > this.left.height());
      if ((i < 0) || (i >= this.height())) {
        // Outside of normal bounds
        throw new Exception("Invalid row " + i);
      } else if ((i >= difference/2) && (i < this.height() - difference/2)) {
        // Inside both left and right bounds
        return rightBigger ? 
        this.left.row(i - difference/2) + this.right.row(i) : 
        this.left.row(i) + this.right.row(i - difference/2);
      } else if (rightBigger && ((i < difference/2) || (i > left.height()))) {
        // Inside right bounds, outside left bounds
        return " ".repeat(this.left.width()) + this.right.row(i);
      } else {
        // Inside right bounds, outside left bounds
        return  this.left.row(i) + " ".repeat(this.right.width());
      }
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return Math.max(this.left.height(), this.right.height());
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.left.width() + this.right.width();
  } // width()

} // class HorizontalCompositionCenter
