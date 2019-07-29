package GeekBrains_Algorithms.Lesson2;

public class MySortedArrayList <T extends Comparable> extends MyArrayList<T> {

    @Override
    public void add(T item) {
        int i = 0;
        while (i < this.getSize() && item.compareTo(get(i)) >= 0) {
            i++;
        }
        super.add(i, item);
    }

    public boolean binaryFind(T item) {
        return recBinaryFind(item,0,getSize()-1);
//        int low = 0;
//        int high = size() - 1;
//
//        while (low <= high) {
//            int middle = low + (high - low) / 2; //(high + low) / 2;
//
//            if (item.compareTo(get(middle)) < 0) {
//                high = middle - 1;
//            } else if (item.compareTo(get(middle)) > 0) {
//                low = middle + 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
    }

    private boolean recBinaryFind(T item, int low, int high) {
        int middle = low + (high - low) / 2;
        if (item.compareTo(get(middle)) == 0) {
            return true;
        } else if (low == high) {
            return false;
        } else if (item.compareTo(get(middle)) < 0) {
            return recBinaryFind(item, low, middle);
        } else if (item.compareTo(get(middle)) > 0) {
            return recBinaryFind(item, middle + 1, high);
        }
        return false;
    }
}