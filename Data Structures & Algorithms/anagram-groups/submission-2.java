class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> grouped = new HashMap<>();
        for(String str : strs) {
            char [] ch = str.toCharArray();
            Arrays.sort(ch);
            String anagram = String.valueOf(ch);
            List<String> list = grouped.getOrDefault(anagram ,new ArrayList<>());
            list.add(str);
            grouped.put(anagram,list);
        }
        // // System.out.println(grouped);
        // List<List<String>> res = new ArrayList<>();
        // for(List<String> values : grouped.values()) {
        //     res.add(values);
        // }
        return new ArrayList<>(grouped.values());
    }
}
