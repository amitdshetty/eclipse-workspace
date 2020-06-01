package come.amit.itcs6114;

/**
 * This class is the bean that holds the sub-array metadata containing the start index, end index and maximum sum
 * @author Amit
 *
 */
public class StockPositionBean implements Comparable<StockPositionBean> {

	int startIndex = 0;
	int endIndex = 0;
	int sum = 0;

	public StockPositionBean(int startIndex, int endIndex, int sum) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.sum = sum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public int compareTo(StockPositionBean o) {
		return this.sum > o.sum ? 1 : this.sum < o.sum ? -1 : 0;
	}

	@Override
	public String toString() {
		return "StockPositionBean [startIndex=" + startIndex + ", endIndex=" + endIndex + ", sum=" + sum + "]";
	}

}
