class TimeMap {

    Map<String, List<Pair<Integer,String>>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Pair<Integer,String>> list = map.get(key);
        // System.out.println(list+" , "+timestamp);
        int left = 0, right = list.size()-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            Pair<Integer,String> curr = list.get(mid);
            if(curr.getKey().intValue() == timestamp) {
                return curr.getValue();
            }else if(curr.getKey().intValue() < timestamp) {
                left = mid+1;
            }else{
                right = mid-1;
            }
            // System.out.println("Left : "+left+", right : "+right+" mid : "+mid);
        }
        
        if(left == 0) {
            return list.get(left).getKey().intValue() > timestamp ? "" : list.get(left).getValue();
        }
        return list.get(left).getKey().intValue() > timestamp ? list.get(left-1).getValue() : list.get(left).getValue();
        
    }
}
