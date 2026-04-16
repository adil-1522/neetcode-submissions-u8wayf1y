class KthLargest {
    int k;
    PriorityQueue<Integer> minheap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minheap = new PriorityQueue<>();
    

        for(int num: nums){
            add(num);
        }}

    
    public int add(int val) {
        minheap.offer(val);

        if(minheap.size()>k){
            minheap.poll();
        }
        return minheap.peek();
    }
}
