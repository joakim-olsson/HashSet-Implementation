/**
* @Author: Joakim Olsson <lomo133>
* @Date:   2019-02-08T15:31:10+01:00
 * @Last modified by:   lomo133
 * @Last modified time: 2019-02-08T15:32:11+01:00
*/

/**
* An interface describing a generic set. Duplicates are not allowed.
*/
public interface Set<T> {

    /**
    * Adds the given element to the set.
    *
    * @param elem An element to add to the set.
    * @return true if the set did not contain the element, otherwise false.
    */
    boolean add(T elem);

    /**
    * Removes the given element from the dictionary, if it is present.
    *
    * @param elem An element to remove from the set.
    * @return true if the set contained the element, false otherwise.
    */
    boolean remove(T elem);

    /**
    * Check if an element is in the Set.
    *
    * @param elem An element to look for.
    * @return true if the element is in the set, false otherwise.
    */
    boolean contains(T elem);

    /**
    * Returns the number of elements in this set.
    *
    * @return The amount of elements in this set.
    */
    int size();
}
