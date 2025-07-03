Node flatten(Node head) {
    Node cur = head;
    while (cur != null) {
        if (cur.child != null) {
            Node nxt = cur.next;
            Node child = flatten(cur.child);
            cur.next = child;
            child.prev = cur;
            cur.child = null;
            while (cur.next != null) cur = cur.next;
            cur.next = nxt;
            if (nxt != null) nxt.prev = cur;
        }
        cur = cur.next;
    }
    return head;
}
