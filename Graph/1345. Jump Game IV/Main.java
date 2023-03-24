class Solution {
    public int minJumps(int[] arr) {


        int n=arr.length;
        boolean visited[]=new boolean [arr.length];

        Map<Integer,ArrayList<Integer>>hm=new HashMap<>(); //hashmap for finding location arr[i]=arr[j]
        Queue<Integer>q=new LinkedList<>(); // queue for bfs traversal

        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                ArrayList<Integer>oldList=hm.get(arr[i]);
                oldList.add(i);
                hm.put(arr[i],oldList);
            }else{
                ArrayList<Integer>newList=new ArrayList<>();
                newList.add(i);
                hm.put(arr[i],newList);
            }
        }

        

        q.add(0);
        visited[0]=true;
        int level=0;

        while(q.size()>0){

            int size=q.size();

            for(int i=0;i<size;i++){

                int idx=q.remove();

                if(idx==n-1) return level;

                if(idx+1<n && !visited[idx+1]){
                    q.add(idx+1);
                    visited[idx+1]=true;
                }

                if(idx-1>=0 && !visited[idx-1]){
                    q.add(idx-1);
                    visited[idx-1]=true;
                }

                for(int newIdx : hm.get(arr[idx])){

                    if(!visited[newIdx]){
                        q.add(newIdx);
                        visited[newIdx]=true;
                    }
                }
                hm.get(arr[idx]).clear();
            }

            level++;
        }

        return -1;
    }
}