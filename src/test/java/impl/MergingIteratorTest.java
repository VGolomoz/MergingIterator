package impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class MergingIteratorTest {

    @Test
    public void mergingTest_success() {
        //given
        List<Integer> list1 = Arrays.asList(6, 8, 19, 21, 32, 66, 67, 77, 89);
        List<Integer> list2 = Arrays.asList(1, 3, 5, 24, 33, 45, 57, 59, 89);
        List<Integer> list3 = Arrays.asList(2, 4, 9, 18, 22, 44, 46, 89, 89);

        List<Integer> expectedList = Stream.of(list1, list2, list3)
                .flatMap(Collection::stream)
                .sorted(Integer::compare)
                .collect(Collectors.toList());
        
        //when
        List<Integer> result = new ArrayList<>();
        MergingIterator<Integer> mergingIterator =
                new MergingIterator(new PeekableIteratorComparator(), list1.iterator(), list2.iterator(), list3.iterator());

        while (mergingIterator.hasNext()) {
            result.add(mergingIterator.next());
        }

        //then
        assertThat(result, is(expectedList));
    }
}
