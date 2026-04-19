class TimeMap {
    class Pair{
        int time;
        String value;

        Pair(int t,String v){
            time=t;
            value=v;
        }

    }
    private Map<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair(timestamp,value));

    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int l=0;
        int r = list.size()-1;
        String res="";

        while(l<=r){
            int mid = l+(r-l)/2;

            if(list.get(mid).time<=timestamp){
                res=list.get(mid).value;
                l=mid+1;
            }else{
                r=mid-1;
            }
            
        }
        return res;
    }
}
