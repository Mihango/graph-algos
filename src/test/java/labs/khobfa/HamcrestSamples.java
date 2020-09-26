package labs.khobfa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestSamples {

    @Test
    public void arraySampleAssertions() {
        Integer[] arr = {4, 2, 5, 7};

//        List<List<Integer>> ar = new ArrayList<>();
//        ar.add(0).add(3);

        assertThat(arr, arrayWithSize(4)); // assert not working for int[]
        assertThat(arr, arrayContaining(4, 2, 5, 7));
    }

    @Test
    public void listSampleAssertions() {
        List<Integer> data = List.of(3, 4, 5, 6);


        assertThat(data, hasItem(4));
        assertThat(data, contains(3, 4, 5, 6));
        assertThat(data, containsInAnyOrder(4, 5, 6, 3));
        assertThat(data, everyItem(greaterThan(2)));
    }
}
