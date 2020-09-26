package labs.khobfa.hacker_rank;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CitiesAndLibrariesTest {

    @Test
    public void givenRoadCost_greaterThanLibrary_returnLibraryCostOnAllCities() {
        //GIVEN
        CitiesAndLibraries citiesAndLibraries = new CitiesAndLibraries();

        // WHEN
        long cost = citiesAndLibraries.findMinCostOfRoadsAndLib(3, 20, 40, null);

        // THEN
        assertThat(cost, is(equalTo(60L)));
    }

    @Test
    public void givenLibraryCost_greaterThanRoads_returnLibraryAndRoadCostOnAllCities() {
        //GIVEN
        CitiesAndLibraries citiesAndLibraries = new CitiesAndLibraries();

        // WHEN
        long cost = citiesAndLibraries.findMinCostOfRoadsAndLib(3, 2, 1,
                new int[][] {
                        {1, 2},
                        {3, 1},
                        {2, 3}
                });

        // THEN
        assertThat(cost, is(equalTo(4L)));
    }
}
