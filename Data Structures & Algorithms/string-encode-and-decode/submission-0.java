class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();

        for(String s: strs){
            encode.append(s.length()).append('#').append(s);
        }
        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        
        int i=0;

        while(i<str.length()){
            int j=i;

            while(str.charAt(j)!='#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i,j));

            j++;

        
            result.add(str.substring(j,j+length));

            i=j+length;
        }
        return result;
    }
}
