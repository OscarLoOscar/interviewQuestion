package TEST6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemInfo {

  public int ItemKey;
  public int ItemValue;

  public ItemInfo(int ItemKey, int ItemValue) {
    this.ItemKey = ItemKey;
    this.ItemValue = ItemValue;
  }

  @Override
  public String toString() {
    return "ItemKey : " + this.ItemKey + //
        " , ItemValue : " + this.ItemValue;
  }

  public class FillGrid {
    public static String CalcDistribution(List<ItemInfo> items, int columns, int rows) {
      int[][] result = buildGrid(columns, rows);
      List<Double> ratios = calRatios(items);
      int itemIndex = 0;

      for (int i = 0; i < columns; i++) {
        for (int j = 0; j < rows; j++) {
          if (itemIndex < items.size()) {
            int itemKey = items.get(itemIndex).ItemKey;
            result[i][j] = itemKey;
            itemIndex++;
          }
        }
      }
      return Arrays.toString(result);
    }
  }

  public static List<Double> calRatios(List<ItemInfo> items) {
    List<Double> ratios = new ArrayList<>();
    int total = 0;
    for (ItemInfo item : items) {
      total += item.ItemValue;
    }
    for (ItemInfo item : items) {
      double ratio = (double) item.ItemValue / total;
      ratios.add(ratio);
    }
    return ratios;
  }

  public static int[][] buildGrid(int columns, int rows) {
    int[][] grid = new int[columns][rows];
    for (int i = 0; i < columns; i++) {
      for (int j = 0; j < rows; j++) {
        grid[i][j] = 0;
      }
    }
    return grid;
  }

  public static void main(String[] args) {
    ItemInfo.buildGrid(5, 4);

    List<ItemInfo> items = new ArrayList<>();
    items.add(new ItemInfo(1, 25));
    items.add(new ItemInfo(2, 25));
    items.add(new ItemInfo(3, 25));
    items.add(new ItemInfo(4, 25));

    ItemInfo.calRatios(items);
    System.out.println("items : " + items);
    System.out.println("calRatios : " + ItemInfo.calRatios(items));

    System.out.println(FillGrid.CalcDistribution(items, 5, 4));
  }
}
