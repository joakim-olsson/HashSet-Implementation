import java.util.LinkedList;
import java.util.List;

/**
* @Author: Joakim Olsson <lomo133>
* @Date:   2019-02-08T15:32:22+01:00
 * @Last modified by:   lomo133
 * @Last modified time: 2019-02-08T15:44:06+01:00
*/

/**
* A hash table-based implementation of the Set interface.
*/
public class HashSet<T> implements Set<T> {
    private List<T>[] table;
    private int size;

    /**
    * Creates a hash table with the given capacity (amount of buckets).
    *
    * @throws IllegalArgumentException if capacity <= 0.
    */
    public HashSet(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
            "capacity must be a positive, non-zero value! Provided: " + capacity);
        }

        /*
        * This array will contain only LinkedList<T>
        * instances, all created in the add method. This
        * is sufficient to ensure type safety.
        */
        @SuppressWarnings("unchecked") // for this declaration only
        List<T>[] t = new LinkedList[capacity];
        table = t;
        size = 0;

    }

    /**
    * Adds the given element to the set.
    *
    * @param elem An element to add to the set.
    * @return true if the set did not contain the element, otherwise false.
    */
    public boolean add(T elem) {
        if (contains(elem))
            return false;
        int hashFunction = Math.abs(elem.hashCode() % table.length);
        if (table[hashFunction] == null) {
            List<T> bucket = new LinkedList<>();
            bucket.add(elem);
            table[hashFunction] = bucket;
        } else
            table[hashFunction].add(elem);
        size++;
        return true;
    }

    /**
    * Removes the given element from the dictionary, if it is present.
    *
    * @param elem An element to remove from the set.
    * @return true if the set contained the element, false otherwise.
    */
    public boolean remove(T elem) {
        if (!contains(elem))
            return false;
        int hashFunction = Math.abs(elem.hashCode() % table.length);
        if (table[hashFunction].size() > 1)
            table[hashFunction].remove(hashFunction);
        else
            table[hashFunction] = null;
        size--;
        return true;
    }

    /**
    * Check if an element is in the Set.
    *
    * @param elem An element to look for.
    * @return true if the element is in the set, false otherwise.
    */
    public boolean contains(T elem) {
        int hashFunction = Math.abs(elem.hashCode() % table.length);

        if (table[hashFunction] == null)
            return false;
        else
            return table[hashFunction].contains(elem);
    }

    /**
    * Returns the number of elements in this set.
    *
    * @return The amount of elements in this set.
    */
    public int size() {
        return size;
    }
}
