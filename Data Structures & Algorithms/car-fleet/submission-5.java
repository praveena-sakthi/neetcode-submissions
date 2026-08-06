class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++) {
            list.add(i);
        }
        Collections.sort(list, (a,b) -> position[b]-position[a]);
        int count = 1;
        double fleetSize = ((double)(target-position[list.get(0)]))/speed[list.get(0)];
        for(int idx=1;idx<len;idx++) {
            int i=list.get(idx);
            double currSize = ((double)(target-position[i]))/speed[i];
            if(currSize > fleetSize) {
                fleetSize = currSize;
                count++;
            }
        }
        return count;
    }
}
