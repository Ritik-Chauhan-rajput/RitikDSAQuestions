class SummaryRanges {
    TreeSet<Integer> set;
    public SummaryRanges() {
        set = new TreeSet<>();
    }
    public void addNum(int value) {
        set.add(value);
    }
    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();
        for (int num : set) {
            if (list.isEmpty() ||
                num > list.get(list.size() - 1)[1] + 1) {
                list.add(new int[]{num, num});
            } else {
                list.get(list.size() - 1)[1] = num;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
