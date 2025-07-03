ListNode[] splitListToParts(ListNode root, int k) {
    int n = 0; ListNode cur = root;
    while (cur != null) { n++; cur = cur.next; }
    int size = n / k, extra = n % k;
    ListNode[] res = new ListNode[k];
    cur = root;
    for (int i = 0; i < k; i++) {
        ListNode head = cur;
        for (int j = 0; j < size + (i < extra ? 1 : 0) - 1; j++)
            if (cur != null) cur = cur.next;
        if (cur != null) {
            ListNode nxt = cur.next;
            cur.next = null;
            cur = nxt;
        }
        res[i] = head;
    }
    return res;
}
