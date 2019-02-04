package unionfind.dynamicconnecitvity;

public class UF {

    private int count;
    private int[] parent;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int p = find(x);
        int q = find(y);
        if (p == q) return;
        parent[p] = q;
        System.out.println(String.format("Union between %d and %d through components %d and %d", x, y, p, q));
        count--;
        System.out.println(String.format("There is/are just %s components", count));
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int find(int x) {
        while (x != parent[x])
            x = parent[x];
        return x;
    }

    public int count() {
        return count;
    }
}
