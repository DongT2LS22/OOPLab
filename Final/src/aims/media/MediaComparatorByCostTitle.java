package aims.media;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class MediaComparatorByCostTitle implements Comparator<Media>  {

    @Override
    public int compare(Media o1, Media o2) {
        if( o1.getCost() < o2.getCost()) return 1;
        else if( o1.getCost() > o2.getCost()) return -1;
        else{
            if( o1.getTitle().compareTo(o2.getTitle()) < 0) return -1;
            if( o1.getTitle().compareTo(o2.getTitle()) > 0 ) return 1;
            return 0;
        }
    }

    @Override
    public Comparator<Media> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Media> thenComparing(Comparator<? super Media> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Media> thenComparing(Function<? super Media, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Media> thenComparing(Function<? super Media, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Media> thenComparingInt(ToIntFunction<? super Media> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Media> thenComparingLong(ToLongFunction<? super Media> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Media> thenComparingDouble(ToDoubleFunction<? super Media> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
