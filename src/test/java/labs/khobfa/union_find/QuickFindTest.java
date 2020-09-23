package labs.khobfa.union_find;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class QuickFindTest {

    @Test
    public void givenUnionFind_ensureConnectivity() {
        UnionFind uf = new QuickFind(10);

        uf.union(5, 0);
        uf.union(6, 5);
        uf.union(2, 1);
        uf.union(4, 3);

        System.out.println("0 id >>>> " + uf.find(0));
        System.out.println("7 id >>>> " + uf.find(7));

        assertThat(uf.isConnected(4, 3), is(equalTo(true)));
        assertThat(uf.isConnected(1, 2), is(equalTo(true)));
        assertThat(uf.isConnected(0, 7), is(equalTo(false)));
        assertThat(uf.isConnected(8, 9), is(equalTo(false)));

        uf.union(3, 8);
        uf.union(9, 4);
        assertThat(uf.isConnected(8, 9), is(equalTo(true)));
    }
}
