# algorithm_exercise
algorithm_with_java
- 2022/03/29和30日更新：
    - 链表实现的stack栈: [LinkedList_Stack](./src/com/young/linked_list/LinkedListStack.java)
    - 链表实现queue队列: [LinkedList_Queue](./src/com/young/linked_list/LinkedListQueue.java)
    - 链表实现bag背包算法: [LinkedList_Bag](./src/com/young/linked_list/LinkedListBag.java)
- 2022/04/07日，算法分析实践测试代码
- union-find算法：
    - 2020/40/18日，测试Union-Find算法[union-find-exercise](./src/com/young/union_find_exercise/QuickUnionExercise.java)
    - 动态连通性知识点说明：[动态连通性知识点](./src/com/young/union_find_exercise/动态连通性知识点.md)
    - 算法实现：
        - 算法实现可视化图像：[union-find-visual](./src/com/young/union_find_exercise/union-find-detail.jpg)
        - quick-find算法[quick-find-algorithm](./src/com/young/union_find_exercise/QuickFindExercise.java)
        - quick-union算法[union-find-algorithm](./src/com/young/union_find_exercise/UnionFindExercise.java)
        - 加权quick-union算法[weighted-quick-union-algorithm](./src/com/young/union_find_exercise/WeightedQuickUnionExercise.java)
    
- 排序：[排序算法汇总](./src/com/young/sort_algorithm)
    - 排序知识点介绍：[排序知识点](./src/com/young/sort_algorithm/排序知识点.md)
    - 选择排序：[selection_sort](./src/com/young/sort_algorithm/Selection_Sort.java)
        - 首先，找到数组中最小的哪个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么就和自己交换）。再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。这种方法叫做选择排序，因为它不断地选择剩余元素之中的最小者。
        - 对于长度为N的数组，选择排序需要大于N<sup>2</sup>/2次比较和N次交换。
    - 插入排序：[Insertion_Sort](./src/com/young/sort_algorithm/Insertion_Sort.java)
        - 在计算机的实现中，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位，这种算法叫做插入排序。
        - 插入排序所需的时间取决于输入中元素的初始顺序。
        - 对于随机排列的长度为N且主键不重复的数组，平均情况下插入排序需要～N<sup>2</sup>/4次比较以及～N<sup>2</sup>/4次交换。最坏情况下需要～N<sup>2</sup>/2次比较和～N<sup>2</sup>/2次交换，最好情况下需要N-1次比较和0次交换。
    - 希尔排序：[Shell_Sort](./src/com/young/sort_algorithm/Shell_Sort.java)
        - 希尔排序是对插入排序的进一步优化，将数组元素分成h个子数组，对子数组进行插入排序。然后将h递减为1，由于数组大部分已经排序了，所以h=1的插入排序就快很多了。
        - 图片示例[shell_sort_pic](./resources/imgs/IMG_8537.PNG)
    - 归并排序：
        - 将两个有序的数组归并成一个更大的有序数组，根据这个操作发明了一种简单的递归排序算法：归并排序。
        - 要将一个数组排序，可以先（递归地）将它分成两半分别排序，然后将结果归并起来。
        - 优点：任意长度的N的数组排序所需时间和NlogN成正比。
        - 缺点：所需的额外空间和N成正比。
        ***
        - 原地归并的抽象方法：
            - 实现归并的一种直接了当的办法是将两个不同的有序数组归并到第三个数组中，两个数组中的元素应该都实现了Comparable接口。
            - 实现方法很简单，创建一个适当大小的数组然后将两个输入数组中的元素一个个从小到大放入这个数组中。
        - 自顶向下的归并排序（递归使用）：[Merge_Up_Down_Sort](./src/com/young/sort_algorithm/Merge_Up_Down_Sort.java)
        - 自底向上的归并排序：[Merge_Down_Up_Sort](./src/com/young/sort_algorithm/Merge_Down_Up_Sort.java)
    
          