package unionfind.dynamicconnecitvity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UFClient {

    private UF uf;

    @Test
    public void shouldCoundInitializedComponents() {
        uf = new UF(10);
        assertEquals(10, uf.count());

        uf = new UF(100);
        assertEquals(100, uf.count());
    }

    @Test
    public void shouldUnifyComponents() {
        uf = new UF(10);

        assertFalse(uf.isConnected(1, 2));
        uf.union(1, 2);
        assertTrue(uf.isConnected(1, 2));

        assertFalse(uf.isConnected(1, 7));
        uf.union(1, 5);
        uf.union(5, 7);
        assertTrue(uf.isConnected(1, 7));
    }

    @Test
    public void shouldUnifyAndCountComponents() {
        uf = new UF(10);

        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(5, 6);
        uf.union(5, 0);
        uf.union(7, 8);
        uf.union(7, 9);
        uf.union(2, 8);
        uf.union(1, 9);

        assertTrue(uf.isConnected(1, 2));
        assertTrue(uf.isConnected(1, 8));
        assertTrue(uf.isConnected(1, 7));
        assertTrue(uf.isConnected(1, 9));
        assertTrue(uf.isConnected(2, 7));
        assertTrue(uf.isConnected(2, 8));
        assertTrue(uf.isConnected(2, 9));

        assertTrue(uf.isConnected(5, 6));
        assertTrue(uf.isConnected(6, 0));

        assertTrue(uf.isConnected(3, 4));

        assertFalse(uf.isConnected(1, 3));
        assertFalse(uf.isConnected(1, 4));
        assertFalse(uf.isConnected(1, 5));
        assertFalse(uf.isConnected(1, 0));
        assertFalse(uf.isConnected(1, 6));
        assertFalse(uf.isConnected(2, 3));
        assertFalse(uf.isConnected(2, 4));
        assertFalse(uf.isConnected(2, 5));
        assertFalse(uf.isConnected(2, 0));
        assertFalse(uf.isConnected(2, 6));
        assertFalse(uf.isConnected(7, 3));
        assertFalse(uf.isConnected(7, 4));
        assertFalse(uf.isConnected(7, 5));
        assertFalse(uf.isConnected(7, 0));
        assertFalse(uf.isConnected(7, 6));
        assertFalse(uf.isConnected(8, 3));
        assertFalse(uf.isConnected(8, 4));
        assertFalse(uf.isConnected(8, 5));
        assertFalse(uf.isConnected(8, 0));
        assertFalse(uf.isConnected(8, 6));
        assertFalse(uf.isConnected(9, 3));
        assertFalse(uf.isConnected(9, 4));
        assertFalse(uf.isConnected(9, 5));
        assertFalse(uf.isConnected(9, 0));
        assertFalse(uf.isConnected(9, 6));
        assertFalse(uf.isConnected(3, 5));
        assertFalse(uf.isConnected(3, 6));
        assertFalse(uf.isConnected(3, 0));
        assertFalse(uf.isConnected(4, 5));
        assertFalse(uf.isConnected(4, 6));
        assertFalse(uf.isConnected(4, 0));

        assertEquals(3, uf.count());
    }
}
