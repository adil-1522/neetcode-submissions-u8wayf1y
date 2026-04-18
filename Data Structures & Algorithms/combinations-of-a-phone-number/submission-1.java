class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0) return result;
        
        String[] map ={
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        backtrack(0,digits,new StringBuilder(),result,map);
        return result; 
    }

    private void backtrack(int index,String digits,StringBuilder sb,List<String> result,String[] map){
        if(index==digits.length()){
            result.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(index)-'0'];

        for(char c: letters.toCharArray()){

            sb.append(c);

            backtrack(index+1,digits,sb,result,map);

            sb.deleteCharAt(sb.length()-1);
        }
    }
}
