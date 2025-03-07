package d1_algorithm.dynamicPrograming.bag;

public class CompleteKnapsack {
    private static class Item {
        int index;
        String name;
        int value;
        int weight;

        public Item(int index, String name, int value, int weight) {
            this.index = index;
            this.name = name;
            this.value = value;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
       Item[] items = {new Item(0, "红宝石", 3, 2),
                new Item(1, "绿宝石", 4, 3),
                new Item(2, "白银", 7, 4)
        };
        System.out.println(select(items, 10));
    }
    public static int select(Item[]items,int total){
        int []dp=new int[total+1];
        for(Item item:items){
            for(int i=item.weight;i<=total;i++){
                dp[i]=Integer.max(dp[i],dp[i-item.weight]+item.value);
            }
        }
        return dp[total];

    }
}
