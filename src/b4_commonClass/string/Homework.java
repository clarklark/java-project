package b4_commonClass.string;

public class Homework {
    public static void main(String[] args) {
        System.out.println(revolveSub("AABDCDBA", "DAA"));
        String text = "小明是一个米孝子,很喜欢妮露,给她买皮肤,抽命作座和专武花了1w元, 但是妮露从来不和他恩爱,反而和散兵" +
                "一起玩公主和勇者的游戏,妮露被散兵中出多了怀孕了,但是散兵只想要性奴不要孩子,去找纳西妲去了," +
                "妮露急忙去找小明结婚,人们嘲讽小明,小明却反驳说他们是自律仙人";
        String[] keys = {"勇者", "中出", "公主"};

    }

    // 判断s1旋转后得到的字符串是否可以包含s2
    public static boolean revolveSub(String s1, String s2) {
        return (s1 + s1).contains(s2);
    }

    // 最短摘要
    // 给出N个关键词,在文章中找到包含所有关键词的最小子串
}

