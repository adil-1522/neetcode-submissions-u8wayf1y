class WordDictionary {
    class Node{
        Node[] links = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch){
            return (links[ch-'a']!=null);
        }

        void put(char ch,Node node){
            links[ch-'a']=node;
        }

        Node get(char ch){
            return links[ch-'a'];
        }
        void setEnd(){
            flag = true;
        }

        boolean isEnd(){
            return flag;
        }
    }

    private Node root;
    
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);

            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
       return dfs(0,word,root);
    }

    private boolean dfs(int index,String word,Node node){
        if(node==null) return false;

        if(index==word.length()){
            return node.isEnd();
        }
        char ch = word.charAt(index);

        if(ch!='.'){
            if(!node.containsKey(ch)){
                return false;
            }
            return dfs(index+1,word,node.get(ch));
        }

        for(int i=0;i<26;i++){
            if(node.links[i]!=null){
                if(dfs(index+1,word,node.links[i])){
                    return true;
                }
            }
        }
        return false;
    }
}
