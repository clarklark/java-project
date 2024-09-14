package collection_.homework;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Homework01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new News("新冠疫情十分火急,全国各地进入防疫模式"));
        list.add(new News("原神人气角色流浪者被腾讯水军轮流抹黑"));
        for(int i=list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }

    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        if (title.length() <= 15) {
            return "标题" + title;
        } else {
            return title.substring(0,15)+"...";
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}