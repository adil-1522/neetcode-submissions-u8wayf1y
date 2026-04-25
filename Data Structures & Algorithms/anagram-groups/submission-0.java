class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s: strs){
            int[] count = new int[26];

            for(char ch: s.toCharArray()){
                count[ch-'a']++;
            }

            StringBuilder key = new StringBuilder();

            for(int i=0;i<26;i++){
                key.append(count[i]).append('#');
            }

            String finalkey = key.toString();

            map.putIfAbsent(finalkey,new ArrayList<>());
            map.get(finalkey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
