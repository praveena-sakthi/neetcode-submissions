class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<len;i++) {
            list.add(i);
        }
        // System.out.println(list);
        Collections.sort(list, (a,b) -> position[b]-position[a]);
        // System.out.println(list);
        int count = 1;
        // for(int i=0;i<len;i++) {
        //     System.out.print(position[i]+"("+speed[i]+")"+"  ");
        // }
        double fleetSize = ((double)(target-position[list.get(0)]))/speed[list.get(0)];
        for(int idx=1;idx<len;idx++) {
            int i=list.get(idx);
            double currSize = ((double)(target-position[i]))/speed[i];
            // System.out.println((double)(4/3));
            //  System.out.print(position[i]+"("+speed[i]+")"+"  ");
            // System.out.println("Fleetsize "+fleetSize+" , curr : "+currSize);
            if(currSize > fleetSize) {
                fleetSize = currSize;
                count++;
            }
        }
        return count;
    }
}
