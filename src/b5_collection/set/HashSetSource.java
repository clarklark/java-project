package b5_collection.set;

import java.util.HashSet;

@SuppressWarnings("all")
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("jack");
        hashSet.add("clark");
    }
    /*
    1.执行HashSet()
     public HashSet() {
        map = new HashMap<>();
    }

    2.执行add()
    public boolean add(E e) {  e:"jack"
        return map.put(e, PRESENT)==null;
    }

    static final Object PRESENT = new Object();

    3.执行put(),该方法会执行hash()得到key对应hash值
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    4.执行putVal()
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {

        //定义辅助变量
        Node<K,V>[] tab; Node<K,V> p; int n, i;


        //table就是HashMap的一个数组,类型是Node[]
        //if语句表示当前table是null,或者大小=0
        //就是第一次扩容,到16个空间
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;

        //(1)根据key,得到hash去计算改key应该存放到table表的哪个索引位置
        //并且把这个位置的对象,赋给p
        //(2)判断p是否为空
        //(2.1)如果p为空,表示还没有存放元素,
        //就创建一个Node(key="jack",value=PRESENT)
        //(2.2)这个Node就放在该位置
        //tab[i]=newNode(hash,key,value,null)
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);

        else {
             //一个开发技巧提示:在需要局部变量(辅助变量)时,再创建

            Node<K,V> e; K k;

            //如果当前索引卫视对应的链表第一个元素和准备添加的key的hash值相同
            //并且满足一下两个条件之一:
            //(1)准备加入的key和p指向的Node节点的key是同一对象
            //(2)p指向的Node节点的key的equals()和准备加入的可以比较后相同
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;

            //再判断p是不是红黑树
            //如果是,就调用putTreeVal(),来进行添加
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);


            else {如果table对应索引位置,已经是一个链表,就使用for循环比较
            //(1)依次和链表的的每一个元素比较后,都不相同,则加入到链表的最后
            //  注意吧元素添加到链表后,立即判断,该链表是否已经达到8个节点
            //  就调用treeifyBin()对当前这个链表进行数化(转为红黑树)
            //  注意,转成红黑树是,要进行判断
            //    如果该table数组大小<64
            //    如果上面条件成立,先table扩容
            //    只有上面条件不成立是,才进行转成红黑树
            //(2)依次和链表的的每一个元素比较后,如果有相同的情况,就直接break

            p->no.1
            e=p.next->no.2
            第一个if判断,e不为空
            进入第二个if,与新的hash比较,相同则break
            未触发break,则p=e->no.2,继续循环回到第一个if
            e=p.next->no.3,如此循环
            当e=p.next->no.N=null时
            将hash插入p.next


                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }



    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;//16
            //加载因子,缓冲值
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
     */
}
